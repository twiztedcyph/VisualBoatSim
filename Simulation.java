package com.twizted;

import com.twizted.Frames.OutputFrame;

/**
 * This is where the simulation takes place.
 * <p/>
 * A simulation requires a grouping on TripSection objects in the form of a Journey.
 * <p/>
 * Created by Ian Weeks on 30/06/2015.
 */
public class Simulation
{
    //Information from Wikipedia
    private final double AVERAGE_RADIUS_OF_EARTH = 6371;
    private final double SEAWATER_DENSITY = 1025;

    //Pure educated guess work here... Just needed some numbers to work with.
    private final double DART_DRAG_COEF = 0.08;

    //More educated guess work... will do till we get some more data.
    private final double DART_CROSS_SECTION = 2.06;

    private final double WAVE_RPM_NORMALISER = 1000;

    //Grouping of trip sections.
    private Journey journey;

    private boolean forExcel = false;
    private OutputFrame outputFrame;

    /**
     * Constructor for the simulation class.
     *
     * @param journey The grouping of trip sections to make a single journey.
     */
    public Simulation(Journey journey)
    {
        this.journey = journey;
    }

    /**
     * Run the simulation
     *
     * @return A string containing the journey details.  If forExcel is true
     * this string will be tab separated values for easy copy/paste into
     * excel.
     */
    public void runSim()
    {
        outputFrame = new OutputFrame();
        StringBuilder result = new StringBuilder();

        //Keeps track of the trip section number.
        int counter = 1;

        //Final tally of duration, distance and fuel.
        double totalTime = 0, totalDistance = 0, totalTrueDist = 0, totalFuel = 0;

        //Iterate through the journey object.
        for (TripSection trip : journey)
        {
            double speed = trip.getSpeed();
            double speedInMs = speedToMetersPerSecond(speed);

            //From wikipedia.  Standard drag equation.
            //REMOVED FOR NOW As was cyclic....
            //double dragForce = 0.5 * SEAWATER_DENSITY * speedInMs * speedInMs * DART_DRAG_COEF * DART_CROSS_SECTION;

            //Get the distance and bearing from the inputted latitudes and longitudes.
            double latDistance = Math.toRadians(trip.getStartLat() - trip.getEndLat());
            double lngDistance = Math.toRadians(trip.getStartLong() - trip.getEndLong());

            double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                    + Math.cos(Math.toRadians(trip.getStartLat())) * Math.cos(Math.toRadians(trip.getEndLat()))
                    * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

            double distance = AVERAGE_RADIUS_OF_EARTH * c * 0.539956803;
            double trueDist = distance;

            double long1 = trip.getStartLong();
            double long2 = trip.getEndLong();
            double lat1 = Math.toRadians(trip.getStartLat());
            double lat2 = Math.toRadians(trip.getEndLat());

            double longDiff = Math.toRadians(long2 - long1);
            double y = Math.sin(longDiff) * Math.cos(lat2);
            double x = Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1) * Math.cos(lat2) * Math.cos(longDiff);
            double bearing = (Math.toDegrees(Math.atan2(y, x)) + 360) % 360;

            //Derived equation for MCR from speed. mcr=e^(0.19721092*speed)
            double mcr = Math.exp(0.19721092 * speed);

            //Derived equation for rpm from speed. May combine this and the one above....
            double rpm = 12 * mcr + 800;


            //Wind calculations
            double vesselBearing = (bearing > 180)
                    ? Math.abs(bearing - 360)
                    : bearing;

            double windBearing = (trip.getSectionWeather().getWind().getBearing() > 180)
                    ? Math.abs(trip.getSectionWeather().getWind().getBearing() - 360)
                    : trip.getSectionWeather().getWind().getBearing();

            double windDirWeight = -1 +
                    (2 * Math.abs(vesselBearing - windBearing) / 180);
            double windFactor = trip.getSectionWeather().getWind().getMagnitude() *
                    windDirWeight;

            rpm = rpm * (1 + windFactor / 200);

        //Wave calculations
            /*
             * So we're saying the combo of:
             *      Wave height and direction affects distance traveled.
             *      Wave height and period affects RPM.
             */

            //Distance compensation.
            double waveBearing = (trip.getSectionWeather().getWaves().getBearing() > 180)
                    ? Math.abs(trip.getSectionWeather().getWaves().getBearing() - 360)
                    : trip.getSectionWeather().getWaves().getBearing();

            double waveDirWeight = -1 +
                    (2 * Math.abs(vesselBearing - waveBearing) / 180);

            double waveDistFactor = trip.getSectionWeather().getWaves().getHeight() *
                    waveDirWeight;

            trueDist = trueDist * (1 + waveDistFactor / 200);

            //RPM compensation.
            double waveRpmFactor = getWavesPerMin(trip.getSectionWeather().getWaves().getPeriod()) *
                    (Math.pow(2, trip.getSectionWeather().getWaves().getHeight() - 1));

            rpm = rpm * (1 + (waveRpmFactor / WAVE_RPM_NORMALISER));


            //v = d / t
            //Standard equation for time as a function of speed and distance.
            //Note that this distance value includes compensation for waves.
            double duration = trueDist / speed;

            //Initialise fuel per hour.
            double fph;

            //Set of straight line equations from our fuel usage based on rpm graph.
            if (rpm < 1000)
            {
                fph = 0.146 * rpm - 80.69;
            }
            else if (rpm < 1100)
            {
                fph = 0.302 * rpm - 235.4;
            }
            else if (rpm < 1300)
            {
                fph = 0.215 * rpm - 139.1;
            }
            else if (rpm < 1400)
            {
                fph = 0.056 * rpm + 67.16;
            }
            else if (rpm < 1800)
            {
                fph = 0.121 * rpm - 26.3;
            }
            else if (rpm < 1900)
            {
                fph = 0.203 * rpm - 172.4;
            }
            else
            {
                //TODO Check with Amine that this is correct....
                //This was the only one of Amines that didn't work so I replotted it...
                //f(x) = (-0.0000513)*x^2 + (0.221)*x + (-27.2)
                fph = ((-0.0000513) * rpm * rpm) + (0.221 * rpm) - 27.2;
            }

            //Trip section fuel based on FPH and duration.
            double tripFuel = fph * duration;

            //Update the total counters.
            totalDistance += distance;
            totalTrueDist += trueDist;
            totalTime += duration;
            totalFuel += tripFuel;

            String tripResult;
            if (forExcel)
            {
                //Excel formated output...
                tripResult = String.format("%d\t%8.2f\t%8.2f\t%8.2f\t%8.2f\t" +
                                                   "%8.2f\t%8.2f\t%8.2f\n",
                                           counter++, speed, distance, bearing,
                                           rpm, duration, fph, tripFuel);
            }
            else
            {
                //People formated output...
                tripResult = String.format("Part %d of %d\n" +
                                                   "\tWind speed:\t%8.2f knots\n" +
                                                   "\tWind bearing:\t%8.2f degrees\n" +
                                                   "\tWave height:\t%8.2f meters\n" +
                                                   "\tWave bearing:\t%8.2f degrees\n" +
                                                   "\tWave period:\t%8.2f seconds\n" +
                                                   "\tSpeed:\t\t%8.2f knots\n" +
                                                   "\tDistance:\t%8.2f nautical miles\n" +
                                                   "\tBearing:\t%8.2f degrees\n" +
                                                   "\tRPM:\t\t%8.2f rpm\n" +
                                                   "\tDuration:\t%8.2f hours\n" +
                                                   "\tFuel rate:\t%8.2f liters per hour\n" +
                                                   "\tTotal fuel:\t%8.2f liters\n\n",
                                           counter++, journey.getSize(),
                                           trip.getSectionWeather().getWind().getMagnitude(),
                                           trip.getSectionWeather().getWind().getBearing(),
                                           trip.getSectionWeather().getWaves().getHeight(),
                                           trip.getSectionWeather().getWaves().getBearing(),
                                           trip.getSectionWeather().getWaves().getPeriod(),
                                           speed, distance, bearing,
                                           rpm, duration, fph, tripFuel);
            }
            result.append(tripResult);
        }

        outputFrame.setTextAreaOne(result.toString());


        String summary = String.format("\nTotal distance:\t\t%8.2f nautical miles with an extra %.2f nautical miles for wave compensation\n" +
                                               "Total duration:\t\t%8.2f hours\n" +
                                               "Total fuel used:\t%8.2f liters\n\n",
                                       totalDistance,
                                       totalTrueDist - totalDistance, totalTime,
                                       totalFuel);

        outputFrame.setTextAreaTwo(summary);
        outputFrame.setVisible(true);
    }

    /**
     * Set which output type the simulation will produce.
     *
     * @param forExcel True for Excel format. False for people format.
     */
    public void setForExcel(boolean forExcel)
    {
        this.forExcel = forExcel;
    }

    /**
     * Covert from knots to m/s.
     *
     * @param speedInKnots The speed in knots to be converted.
     * @return The m/s equivalent.
     */
    private double speedToMetersPerSecond(double speedInKnots)
    {
        return speedInKnots * 0.514444444;
    }

    /**
     * Covert a wave period to waves per minute.
     *
     * @param wavePeriod The wave period to be converted.
     * @return Waves per minute.
     */
    private double getWavesPerMin(double wavePeriod)
    {
        return 60.0 / wavePeriod;
    }
}

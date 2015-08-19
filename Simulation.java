package com.twizted;

import com.twizted.Frames.OutputFrame;
import com.twizted.Frames.OutputPanel;
import com.twizted.Vessels.Vessel;

import java.util.ArrayList;

/**
 * This is where the simulation takes place.
 * <p>
 * A simulation requires a grouping on TripSection objects in the form of a Journey.
 * <p>
 * Created by Ian Weeks on 30/06/2015.
 */
public class Simulation
{

    //Grouping of trip sections.
    private Journey journey;
    private ArrayList<Vessel> vesselList;
    private double pax, weight;

    /**
     * Constructor for the simulation class.
     *
     * @param journey The grouping of trip sections to make a single journey.
     * @param vesselList The list of vessels to be considered for this journey.
     */
    public Simulation(Journey journey, ArrayList<Vessel> vesselList, double pax, double weight)
    {
        this.journey = journey;
        this.vesselList = vesselList;
        this.pax = pax;
        this.weight = weight;
    }

    /**
     * Run the simulation.
     */
    public void runSim()
    {
        final double AVERAGE_RADIUS_OF_EARTH = 6371;
        OutputFrame outputFrame = new OutputFrame();
        for (Vessel vessel : vesselList)
        {
            boolean safeWaveExceeded = false;
            boolean paxExceeded = pax > vessel.getMaxPAX();
            boolean weightExceeded = weight > vessel.getMaxCargoWeight();


            OutputPanel outputPanel = new OutputPanel();
            StringBuilder result = new StringBuilder();

            //Keeps track of the trip section number.
            int counter = 1;

            //Final tally of duration, distance and fuel.
            double totalTime = 0, totalDistance = 0, totalTrueDist = 0, totalFuel = 0;

            //Iterate through the journey object.
            for (TripSection trip : journey)
            {
                safeWaveExceeded = trip.getSectionWeather().getWaves().getHeight() > vessel.getMaxSafeWaveHeight();
                double speed = trip.getSpeed() > vessel.getMaxSpeed() ? vessel.getMaxSpeed() : trip.getSpeed();

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

                //Derived equation for rpm from speed. May combine this and the one above.
                //Derived equation for MCR from speed. mcr=e^(0.19721092*speed) and rpm=12*mcr+800
                double rpm = vessel.getRPM(speed);


                //Wind calculations
                //TODO: Maybe make these unique to each vessel.
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

                double WAVE_RPM_NORMALISER = 1000;
                rpm = rpm * (1 + (waveRpmFactor / WAVE_RPM_NORMALISER));


                //v = d / t
                //Standard equation for time as a function of speed and distance.
                //Note that this distance value includes compensation for waves.
                double duration = trueDist / speed;

                //Get this vessel's fuel usage per hour.
                double fph = vessel.getFPH(rpm);

                //Trip section fuel based on FPH and duration.
                double tripFuel = fph * duration;

                //Update the total counters.
                totalDistance += distance;
                totalTrueDist += trueDist;
                totalTime += duration;
                totalFuel += tripFuel;

                String tripResult;

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
                result.append(tripResult);
            }

            outputPanel.setTextAreaOne(result.toString());

            final double COST_OF_FUEL = 0.95;
            String summary = String.format("\nTotal distance:\t\t%8.2f nautical miles with an extra %.2f nautical " +
                                                   "miles for wave compensation\n" +
                                                   "Total duration:\t\t%8.2f hours\n" +
                                                   "Total fuel used:\t%8.2f liters\n",
                                           totalDistance,
                                           totalTrueDist - totalDistance, totalTime,
                                           totalFuel);

            if (safeWaveExceeded)
            {
                summary += "WAVE HEIGHT LIMIT EXCEEDED. ";
            }
            if (paxExceeded)
            {
                summary += "PAX LIMIT EXCEEDED. ";
            }
            if (weightExceeded)
            {
                summary += "CARGO WEIGHT EXCEEDED. ";
            }

            outputPanel.setTextAreaTwo(summary);


            outputPanel.setTextAreaThree(String.format("Total fuel cost:\t%8.2f GBP\n", totalFuel * COST_OF_FUEL));
            outputFrame.addTabPanel(vessel.getClass().getName().replaceAll("com.twizted.Vessels.", ""), outputPanel);
        }
        outputFrame.pack();
        outputFrame.setVisible(true);
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

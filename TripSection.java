package com.twizted;

/**
 * This class defines a section of a Journey.
 * <p>
 * Created by Ian Weeks on 30/06/2015.
 */
public class TripSection
{
    private double startLat, startLong, endLat, endLong, speed;
    private Weather sectionWeather;

    /**
     * Constructor for the TripSection class.
     *
     * @param startLat  The starting latitude for this TripSection.
     * @param startLong The starting longitude for this TripSection.
     * @param endLat    The destination latitude for this TripSection.
     * @param endLong   The destination longitude for this TripSection.
     * @param speed     The desired speed for this section of the journey.
     * @param weather   The weather for this section of the journey.
     */
    public TripSection(double startLat, double startLong, double endLat, double endLong, double speed, Weather weather)
    {
        this.startLat = startLat;
        this.startLong = startLong;
        this.endLat = endLat;
        this.endLong = endLong;
        this.speed = speed;
        this.sectionWeather = weather;
    }

    /**
     * Get the starting latitude for this TripSection.
     *
     * @return The starting latitude for this TripSection.
     */
    public double getStartLat()
    {
        return startLat;
    }

    /**
     * Get the starting longitude for this TripSection.
     *
     * @return The starting longitude for this TripSection.
     */
    public double getStartLong()
    {
        return startLong;
    }

    /**
     * Get the end latitude for this TripSection.
     *
     * @return The end latitude for this TripSection.
     */
    public double getEndLat()
    {
        return endLat;
    }

    /**
     * Get the destination longitude for this TripSection.
     *
     * @return The destination longitude for this TripSection.
     */
    public double getEndLong()
    {
        return endLong;
    }

    /**
     * Get the speed for this TripSection.
     *
     * @return The speed for this TripSection.
     */
    public double getSpeed()
    {
        return speed;
    }

    /**
     * Get the weather for this TripSection.
     *
     * @return The weather for this TripSection.
     */
    public Weather getSectionWeather()
    {
        return sectionWeather;
    }

    @Override
    public String toString()
    {
        return "TripSection:\n" +
                "startLat   = " + startLat  + "\n" +
                "startLong  = " + startLong + "\n" +
                "endLat     = " + endLat    + "\n" +
                "endLong    = " + endLong   + "\n" +
                "speed      = " + speed     + "\n";
    }
}


package com.twizted;

/**
 * Weather class
 *
 * Storage class for trip section weather.
 *
 * @author Ian Weeks on 02/07/2015.
 */
public class Weather
{
    private Wind wind;
    private Waves waves;

    /**
     * Weather constructor.
     *
     * @param windMagnitude The speed of the wind in knots.
     * @param windBearing The bearing of the wind.
     * @param waveHeight The significant wave height.
     * @param waveBearing The wave bearing.
     * @param wavePeriod The time between waves.
     */
    public Weather(double windMagnitude, double windBearing, double waveHeight, double waveBearing, double wavePeriod)
    {
        this.wind = new Wind(windMagnitude, windBearing);
        this.waves = new Waves(waveHeight, waveBearing, wavePeriod);
    }

    /**
     * Get the wind object from this weather.
     *
     * @return The wind object from this weather.
     */
    public Wind getWind()
    {
        return wind;
    }

    /**
     * Get the wave object from this weather.
     *
     * @return The wave object from this weather.
     */
    public Waves getWaves()
    {
        return waves;
    }

    /**
     * Wind class for weather.
     */
    protected class Wind
    {
        private double bearing, magnitude;

        /**
         * Wind constructor.
         *
         * @param magnitude The speed of the wind in knots.
         * @param bearing The bearing of the wind.
         */
        public Wind(double magnitude, double bearing)
        {
            this.magnitude = magnitude;
            this.bearing = bearing;
        }

        /**
         * Get the bearing of the wind.
         *
         * @return The bearing of the wind.
         */
        public double getBearing()
        {
            return bearing;
        }

        /**
         * Get the wind speed.
         *
         * @return The speed of the wind.
         */
        public double getMagnitude()
        {
            return magnitude;
        }
    }

    /**
     * Wave class for weather.
     */
    protected class Waves
    {
        private double height, period, bearing;

        /**
         * Wave constructor.
         *
         * @param height The significant wave height.
         * @param bearing The wave bearing.
         * @param period The time between waves.
         */
        public Waves(double height, double bearing, double period)
        {
            this.height = height;
            this.bearing = bearing;
            this.period = period;
        }

        /**
         * Get the significant wave height.
         *
         * @return The significant wave height.
         */
        public double getHeight()
        {
            return height;
        }

        /**
         * Get the wave period.
         *
         * @return The wave period.
         */
        public double getPeriod()
        {
            return period;
        }

        /**
         * Get the wave bearing.
         *
         * @return The wave bearing.
         */
        public double getBearing()
        {
            return bearing;
        }

    }
}

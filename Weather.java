package com.twizted;

/**
 * @author Ian Weeks on 02/07/2015.
 */
public class Weather
{
    private Wind wind;
    private Waves waves;

    public Weather(double windMagnitude, double windBearing, double waveHeight, double waveBearing, double wavePeriod)
    {
        this.wind = new Wind(windMagnitude, windBearing);
        this.waves = new Waves(waveHeight, waveBearing, wavePeriod);
    }

    public Wind getWind()
    {
        return wind;
    }

    public void setWind(Wind wind)
    {
        this.wind = wind;
    }

    public Waves getWaves()
    {
        return waves;
    }

    public void setWaves(Waves waves)
    {
        this.waves = waves;
    }

    protected class Wind
    {
        private double bearing, magnitude;

        public Wind(double magnitude, double bearing)
        {
            this.magnitude = magnitude;
            this.bearing = bearing;
        }

        public double getBearing()
        {
            return bearing;
        }

        public void setBearing(double bearing)
        {
            this.bearing = bearing;
        }

        public double getMagnitude()
        {
            return magnitude;
        }

        public void setMagnitude(double magnitude)
        {
            this.magnitude = magnitude;
        }
    }

    protected class Waves
    {
        private double height, period, bearing;
        /*
        Wave height affects distance.
        Wave period affects rpm.
        Wave bearing decides if the effects are negative or positive.
         */

        public Waves(double height, double bearing, double period)
        {
            this.height = height;
            this.bearing = bearing;
            this.period = period;
        }

        public double getHeight()
        {
            return height;
        }

        public void setHeight(double height)
        {
            this.height = height;
        }

        public double getPeriod()
        {
            return period;
        }

        public void setPeriod(double period)
        {
            this.period = period;
        }

        public double getBearing()
        {
            return bearing;
        }

        public void setBearing(double bearing)
        {
            this.bearing = bearing;
        }
    }
}

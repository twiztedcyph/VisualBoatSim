package com.twizted;

/**
 * @author Ian Weeks on 02/07/2015.
 */
public class Weather
{
    private Wind wind;
    private Waves waves;

    public Weather(double windBearing, double windMagnitude,
                   double waveHeight, double wavePeriod, double waveBearing)
    {
        this.wind = new Wind(windBearing, windMagnitude);
        this.waves = new Waves(waveHeight, wavePeriod, waveBearing);
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

        public Wind(double bearing, double magnitude)
        {
            this.bearing = bearing;
            this.magnitude = magnitude;
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

        public Waves(double height, double period, double bearing)
        {
            this.height = height;
            this.period = period;
            this.bearing = bearing;
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

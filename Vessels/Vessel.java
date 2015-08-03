package com.twizted.Vessels;

/**
 * @author Ian Weeks.
 */
public abstract class Vessel
{
    private double maxSafeWaveHeight, maxCargoWeight;
    private int maxPAX;

    public Vessel(double maxSafeWaveHeight, double maxCargoWeight, int maxPAX)
    {
        this.maxSafeWaveHeight = maxSafeWaveHeight;
        this.maxCargoWeight = maxCargoWeight;
        this.maxPAX = maxPAX;
    }

    public abstract double getRPM(double speed);

    public abstract double getFPH(double RPM);

    public double getMaxSafeWaveHeight()
    {
        return maxSafeWaveHeight;
    }

    public double getMaxCargoWeight()
    {
        return maxCargoWeight;
    }

    public int getMaxPAX()
    {
        return maxPAX;
    }
}

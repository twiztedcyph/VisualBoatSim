package com.twizted.Vessels;

/**
 * Super class for all vessels.
 *
 * @author Ian Weeks.
 */
public abstract class Vessel
{
    private double maxSafeWaveHeight, maxCargoWeight;
    private int maxPAX;

    /**
     * Vessel constructor.
     *
     * @param maxSafeWaveHeight The maximum safe wave height this vessel can handle.
     * @param maxCargoWeight The maximum cargo weight this vessel can handle.
     * @param maxPAX The maximum number of PAX this vessel can handle.
     */
    public Vessel(double maxSafeWaveHeight, double maxCargoWeight, int maxPAX)
    {
        this.maxSafeWaveHeight = maxSafeWaveHeight;
        this.maxCargoWeight = maxCargoWeight;
        this.maxPAX = maxPAX;
    }

    /**
     * Get the vessel's RPM from its speed.
     *
     * @param speed The speed of the vessel.
     * @return The RPM of the vessel.
     */
    public abstract double getRPM(double speed);

    /**
     * Get the vessel's fuel usage per hour from its RPM.
     *
     * @param RPM The vessel's RPM;
     * @return The vessel's fuel usage per hour.
     */
    public abstract double getFPH(double RPM);

    /**
     * Get the maximum safe wave height this vessel can handle.
     *
     * @return The maximum safe wave height this vessel can handle.
     */
    public double getMaxSafeWaveHeight()
    {
        return maxSafeWaveHeight;
    }

    /**
     * Get the maximum cargo weight this vessel can handle.
     *
     * @return The maximum cargo weight this vessel can handle.
     */
    public double getMaxCargoWeight()
    {
        return maxCargoWeight;
    }

    /**
     * Get the maximum number of PAX this vessel can handle.
     *
     * @return The maximum number of PAX this vessel can handle.
     */
    public int getMaxPAX()
    {
        return maxPAX;
    }
}

package com.twizted.Vessels;

/**
 * Vessel larger than dart fisher.
 *
 * @author Ian Weeks
 */
public class LargerVessel extends Vessel
{
    /**
     * Super Vessel constructor for larger vessel.
     *
     * @param maxSafeWaveHeight The maximum safe wave height this vessel can handle.
     * @param maxCargoWeight The maximum cargo weight this vessel can handle.
     * @param maxPAX The maximum number of PAX this vessel can handle.
     */
    public LargerVessel(double maxSafeWaveHeight, double maxCargoWeight, double maxSpeed, int maxPAX)
    {
        super(maxSafeWaveHeight, maxCargoWeight, maxSpeed, maxPAX);
    }

    /**
     * Get this vessel's RPM from its speed.
     *
     * @param speed The speed of the vessel.
     * @return The RPM of the vessel.
     */
    @Override
    public double getRPM(double speed)
    {
        double mcr;

        if (speed <= 15)
        {
            mcr = 1.33 * speed;
        }else if (speed <= 25)
        {
            mcr = 4 * speed - 40;
        }else
        {
            mcr = 10 * speed - 190;
        }

        return 13 * mcr + 800;
    }

    /**
     * Get this vessel's fuel usage per hour from its RPM.
     *
     * @param RPM The vessel's RPM;
     * @return The vessel's fuel usage per hour.
     */
    @Override
    public double getFPH(double RPM)
    {
        if (RPM < 1000)
        {
            return 0.135 * RPM - 60;
        }
        else if (RPM < 1100)
        {
            return 0.350 * RPM - 275;
        }
        else if (RPM < 1300)
        {
            return 0.155 * RPM - 60.5;
        }
        else if (RPM < 1500)
        {
            return 0.0450 * RPM + 82.5;
        }
        else if (RPM < 1800)
        {
            return 0.0833 * RPM + 25;
        }
        else if (RPM < 1900)
        {
            return 0.140 * RPM - 77;
        }
        else
        {
            return 0.0367 * RPM + 119;
        }
    }
}

package com.twizted.Vessels;

/**
 * Vessel smaller than the Dart fisher.
 *
 * @see Vessel
 * @author Ian Weeks
 */
public class SmallerVessel extends Vessel
{
    /**
     * Super Vessel constructor for smaller vessel.
     *
     * @param maxSafeWaveHeight The maximum safe wave height this vessel can handle.
     * @param maxCargoWeight The maximum cargo weight this vessel can handle.
     * @param maxPAX The maximum number of PAX this vessel can handle.
     */
    public SmallerVessel(double maxSafeWaveHeight, double maxCargoWeight, int maxPAX)
    {
        super(maxSafeWaveHeight, maxCargoWeight, maxPAX);
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

        if (speed <= 22)
        {
            mcr = 0.909 * speed;
        }else if (speed <= 27)
        {
            mcr = 4 * speed - 68;
        }else if (speed <= 29)
        {
            mcr = 10 * speed - 230;
        }else
        {
            mcr = 20 * speed - 520;
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
        if (RPM < 900)
        {
            return 0.05 * RPM - 25;
        }
        else if (RPM < 1200)
        {
            return 0.2 * RPM - 160;
        }
        else if (RPM < 1300)
        {
            return 0.150 * RPM - 100;
        }
        else if (RPM < 1500)
        {
            return 0.275 * RPM - 262;
        }
        else if (RPM < 1700)
        {
            return 0.195 * RPM - 143;
        }
        else if (RPM < 1800)
        {
            return 0.0800 * RPM + 53;
        }
        else if (RPM < 1900)
        {
            return 0.230 * RPM - 217;
        }
        else
        {
            return 0.0467 * RPM + 131;
        }
    }
}

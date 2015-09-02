package com.twizted.Vessels;

/**
 * Dart Fisher vessel.
 *
 * @see Vessel
 * @author Ian Weeks
 */
public class DartFisher extends Vessel
{
    /**
     * Super Vessel constructor for Dart Fisher.
     *
     * @param maxSafeWaveHeight The maximum safe wave height this vessel can handle.
     * @param maxCargoWeight The maximum cargo weight this vessel can handle.
     * @param maxPAX The maximum number of PAX this vessel can handle.
     */
    public DartFisher(double maxSafeWaveHeight, double maxCargoWeight, double maxSpeed, int maxPAX)
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
        if (speed < 6.1)
        {
            return 42.29 * speed + 650;
        }else if (speed <= 10.8)
        {
            return 62.97 * speed + 523.8;
        }else if (speed < 13.5)
        {
            return 71.48 * speed + 432;
        }else if (speed < 15.1)
        {
            return 128.1 * speed - 332.6;
        }else if (speed < 19.3)
        {
            return 45.95 * speed + 908.1;
        }else if (speed < 23.9)
        {
            return 38.47 * speed + 1052;
        }else
        {
            return 19.03 * speed + 1517;
        }
    }

    /**
     * Get this vessel's fuel usage per hour from its RPM.
     *
     * @param rpm The vessel's RPM;
     * @return The vessel's fuel usage per hour.
     */
    @Override
    public double getFPH(double rpm)
    {
        if (rpm <= 825)
        {
            return 5;
        }
        else if (rpm <= 1204)
        {
            return 0.128 * rpm - 105.2;
        }
        else if (rpm < 1397)
        {
            return 0.268 * rpm - 273.4;
        }
        else if (rpm <= 1602)
        {
            return 0.567 * rpm - 691.0;
        }
        else if (rpm < 1795)
        {
            return 0.643 * rpm - 813.1;
        }
        else if (rpm <= 1972)
        {
            return 0.333 * rpm - 256.3;
        }else
        {
            return 1.444 * rpm - 2447;
        }
    }
}
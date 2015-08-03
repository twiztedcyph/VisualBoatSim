package com.twizted.Vessels;

/**
 * Created by Cypher on 02/08/2015.
 */
public class LargerVessel extends Vessel
{
    public LargerVessel(double maxSafeWaveHeight, double maxCargoWeight, int maxPAX)
    {
        super(maxSafeWaveHeight, maxCargoWeight, maxPAX);
    }

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

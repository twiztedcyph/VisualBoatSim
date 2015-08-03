package com.twizted.Vessels;

/**
 * @author Ian Weeks
 */
public class DartFisher extends Vessel
{
    public DartFisher(double maxSafeWaveHeight, double maxCargoWeight, int maxPAX)
    {
        super(maxSafeWaveHeight, maxCargoWeight, maxPAX);
    }

    @Override
    public double getRPM(double speed)
    {
        double mcr;

        if (speed <= 19.97239323)
        {
            mcr = speed;
        }else if (speed <= 24.59356989)
        {
            mcr = 4.33 * speed - 66.4;
        }else if (speed <= 27.29678495)
        {
            mcr = 7.4 * speed - 142;
        }else if (speed <= 29.21474655)
        {
            mcr = 10.4 * speed - 225;
        }else if (speed <= 30)
        {
            mcr = 12.7 * speed - 292;
        }else
        {
            mcr = 14.2 * speed - 337;
        }

        return 13 * mcr + 800;
    }

    @Override
    public double getFPH(double RPM)
    {
        if (RPM < 1000)
        {
            return 0.146 * RPM - 80.69;
        }
        else if (RPM < 1100)
        {
            return 0.302 * RPM - 235.4;
        }
        else if (RPM < 1300)
        {
            return 0.215 * RPM - 139.1;
        }
        else if (RPM < 1400)
        {
            return 0.056 * RPM + 67.16;
        }
        else if (RPM < 1800)
        {
            return 0.121 * RPM - 26.3;
        }
        else if (RPM < 1900)
        {
            return 0.203 * RPM - 172.4;
        }
        else
        {
            //TODO Check with Amine that this is correct....
            //This was the only one of Amines that didn't work so I replotted it...
            //f(x) = (-0.0000513)*x^2 + (0.221)*x + (-27.2)
            return ((-0.0000513) * RPM * RPM) + (0.221 * RPM) - 27.2;
        }
    }
}

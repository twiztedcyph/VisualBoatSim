package com.twizted.Vessels;

/**
 * Created by Cypher on 02/08/2015.
 */
public class DartFisher extends Vessel
{
    @Override
    double getMCR(double speed)
    {
        return Math.exp(0.19721092 * speed);
    }

    @Override
    double getRPM(double MCR)
    {
        return 12 * MCR + 800;
    }

    @Override
    double getFPH(double RPM)
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

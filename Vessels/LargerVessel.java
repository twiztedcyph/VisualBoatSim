package com.twizted.Vessels;

/**
 * Created by Cypher on 02/08/2015.
 */
public class LargerVessel extends Vessel
{
    @Override
    public double getMCR(double speed)
    {
        return 0;
    }

    @Override
    public double getRPM(double MCR)
    {
        return 0;
    }

    @Override
    public double getFPH(double RPM)
    {
        return 0;
    }
}

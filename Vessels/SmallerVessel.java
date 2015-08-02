package com.twizted.Vessels;

/**
 * Created by Cypher on 02/08/2015.
 */
public class SmallerVessel extends Vessel
{
    @Override
    double getMCR(double speed)
    {
        return 0;
    }

    @Override
    double getRPM(double MCR)
    {
        return 0;
    }

    @Override
    double getFPH(double RPM)
    {
        return 0;
    }
}

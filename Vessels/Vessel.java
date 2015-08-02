package com.twizted.Vessels;

/**
 * Created by Cypher on 02/08/2015.
 */
public abstract class Vessel
{
    private double maxSafeWaveHeight;

    abstract double getMCR(double speed);

    abstract double getRPM(double MCR);

    abstract double getFPH(double RPM);
}

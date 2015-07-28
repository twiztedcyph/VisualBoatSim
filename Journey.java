package com.twizted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Journey class holds a list of TripSections.
 * <p/>
 * The class iterator will iterate over the each tripSection.
 * <p/>
 * Created by Ian Weeks on 30/06/2015.
 */
public class Journey implements Iterable<TripSection>
{
    private ArrayList<TripSection> tripSectionList;

    /**
     * Default constructor for the Journey class.
     */
    public Journey()
    {
        this.tripSectionList = new ArrayList<TripSection>();
    }

    /**
     * Add a TripSection object to the list.
     *
     * @param tripSection A TripSection object.
     */
    public void add(TripSection tripSection)
    {
        tripSectionList.add(tripSection);
    }

    /**
     * Get the number of trip sections in this Journey.
     *
     * @return The number of trip sections in this Journey.
     */
    public int getSize()
    {
        return tripSectionList.size();
    }

    /**
     * Returns an iterator over a set of elements of type TripSection.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<TripSection> iterator()
    {
        return tripSectionList.iterator();
    }

    /**
     * Reverse the order of the TripSection list.
     */
    public void reverseOrder()
    {
        //TODO: This may not be required... Remove if that is the case.
        Collections.reverse(tripSectionList);
    }

    public void clear()
    {
        if (!tripSectionList.isEmpty())
        {
            tripSectionList = new ArrayList<TripSection>();
        }
    }
}


/*
 * FILENAME
 *     Government.java
 *
 * FILE LOCATION
 *     $Source$
 *
 * VERSION
 *     $Id$
 *         @version       $Revision$
 *         Check-Out Tag: $Name$
 *         Locked By:     $Lockers$
 *
 * FORMATTING NOTES
 *     * Lines should be limited to 78 characters.
 *     * Files should contain no tabs.
 *     * Indent code using four-character increments.
 *
 * COPYRIGHT
 *     Copyright (C) 2007 Genix Ventures Pty. Ltd. All rights reserved.
 *     This software is the confidential and proprietary information of
 *     Genix Ventures ("Confidential Information"). You shall not
 *     disclose such Confidential Information and shall use it only in
 *     accordance with the terms of the license agreement you entered into
 *     with Genix Ventures.
 */

package com.beingjavaguys.serialization;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public abstract class Government
{

    private String fWinningParty;
    private boolean fIsInitialized = false;

    /**
     * This no-argument constructor is needed by subclass's Serialization mechanism.
     */
    protected Government()
    {
        System.out.println("3");
    }

    public Government(String aWinningParty)
    {
        System.out.println("2");
        init(aWinningParty);
        //never invoke an overridable method in a constructor
    }

    /**
     * Called by both this class's public constructor, and by a subclass's readObject method. Note this method is final.
     */
    protected final void init(String aWinningParty)
    {
        if (fIsInitialized)
        {
            throw new IllegalStateException("Cannot call init twice.");
        }
        fWinningParty = aWinningParty;
        fIsInitialized = true;
    }

    public final void raiseTaxes()
    {
        validateInit(); //always called by public methods
        //..elided
    }

    public final void lowerTaxes()
    {
        validateInit();
        //..elided
    }

    /**
     * A template method which calls a protected abstract method, to be overridden by subclasses.
     */
    public boolean makeLaw()
    {
        validateInit();
        String bill = draftLegislation(); //protected, abstract method
        return vote(bill);
    }

    private boolean vote(String aBill)
    {
        return true; //toy implentation
    }

    /**
     * Must be called by public methods.
     */
    private void validateInit() throws IllegalStateException
    {
        if (!fIsInitialized)
        {
            throw new IllegalStateException("Uninitialized object");
        }
    }

    /**
     * Each governament will draft legislation in a particular way. A tyranny, for example, would not have wide debate
     * between its citizens.
     */
    protected abstract String draftLegislation();

    /**
     * Subclass will need access to the superclass's internal state, either through public or protected gets. Note that
     * the get needs to be final.
     */
    protected final String getWinningParty()
    {
        return fWinningParty;
    }
}

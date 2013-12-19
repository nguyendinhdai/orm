/*
 * FILENAME
 *     SpaceShuttle.java
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

package com.beingjavaguys.assertions;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public class SpaceShuttle
{

    /**
     * The non-nullity of aName is part of the contract of the constructor.
     * 
     * @param aName
     *            is non-null.
     */
    public SpaceShuttle(String aName)
    {
        //WRONG way:
//        assert aName != null : "Name must not be null";
        checkOnParameter(null);

        //RIGHT way:
//        if (aName == null)
//        {
//            throw new IllegalArgumentException("Name must not be null.");
//        }

        fName = aName;
    }

    private void checkOnParameter(String aName)
    {
        //WRONG way:
        assert aName != null : "Name must not be null";
    }

    public String getName()
    {
        return fName;
    }

    // PRIVATE 
    private final String fName;

    public static void main(String[] args)
    {
        SpaceShuttle spaceShuttle = new SpaceShuttle(null);
    }
}

/*
 * FILENAME
 *     Tyranny.java
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

import java.io.*;

/** A Serializable subclass. */
public class Tyranny extends Government implements Serializable
{

    public Tyranny(String aWinningParty)
    {
        super(aWinningParty);
        System.out.println("1");
    }

    // PROTECTED

    protected String draftLegislation()
    {
        return "Forbid all use of C++.";
    }

    // PRIVATE

    /**
     * Custom deserialization is needed.
     */
    private void readObject(ObjectInputStream aStream) throws IOException, ClassNotFoundException
    {
        aStream.defaultReadObject();
        //manually deserialize and init superclass
        String winningParty = (String) aStream.readObject();
        init(winningParty);
    }

    /**
     * Custom serialization is needed.
     */
    private void writeObject(ObjectOutputStream aStream) throws IOException
    {
        aStream.defaultWriteObject();
        //manually serialize superclass
        aStream.writeObject(getWinningParty());
    }

    public static void main(String args[])
    {
        // Object serialization
        try
        {
            Tyranny object1 = new Tyranny("Forbid all use of JAVA.");
            System.out.println("object1: " + object1);
            FileOutputStream fos = new FileOutputStream("serial");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object1);
            oos.flush();
            oos.close();
        }
        catch (Exception e)
        {
            System.out.println("Exception during serialization: " + e);
            System.exit(0);
        }
        // Object deserialization
        try
        {
            Tyranny object2;
            FileInputStream fis = new FileInputStream("serial");
            ObjectInputStream ois = new ObjectInputStream(fis);
            object2 = (Tyranny) ois.readObject();
            ois.close();
            System.out.println("object2: " + object2.getWinningParty());
        }
        catch (Exception e)
        {
            System.out.println("Exception during deserialization: " + e);
            System.exit(0);
        }
    }
}

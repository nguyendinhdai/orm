/*
 * FILENAME
 *     Rectangle.java
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

package com.beingjavaguys.onetableperclasshierarchy;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "R")
public class Rectangle extends Shape
{

    @Column(name = "Rectangle_Length")
    int length;
    @Column(name = "Rectangle_Breadth")
    int breadth;

    // getters and setters

    public Rectangle()
    {

    }

    public Rectangle(String shapeName, int length, int breadth)
    {
        super(shapeName);
        this.length = length;
        this.breadth = breadth;
    }

    // getters and setters
}

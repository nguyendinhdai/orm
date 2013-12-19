/*
 * FILENAME
 *     PaymentActoinPerfomer.java
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

package com.beingjavaguys.polymorphism;

import java.util.List;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//
public class PaymentActoinPerfomer
{

    public static void main(String[] args)
    {

        HibernateInterface.exectueQuery("delete from com.beingjavaguys.polymorphism.CardPayment");
        HibernateInterface.exectueQuery("delete from com.beingjavaguys.polymorphism.CashPayment");

        HibernateInterface.saveEntities(new CardPayment(600L, "IND", "123456789", "Salil Verma"));
        HibernateInterface.saveEntities(new CashPayment(200L, "USD", "Salil Verma"));

        // Attempt to retrieve all the payments (cash and card both) existing in the system
        List<Object> objects = HibernateInterface.getRecordsOfType(Payment.class);
        for (Object object : objects)
            System.out.println(object);
    }
}

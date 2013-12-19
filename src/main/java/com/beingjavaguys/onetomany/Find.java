/*
 * FILENAME
 *     Find.java
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

package com.beingjavaguys.onetomany;

import java.util.ArrayList;

import org.hibernate.Session;

import com.beingjavaguys.hbn.HibernateUtil;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public class Find
{
    public static void main(String[] args)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        ArrayList<AccountEntity> list =
            (ArrayList<AccountEntity>) session.createQuery("from ForeignKeyAssoAccountEntity").list();
        if (list != null)
        {
            for (int i = 0; i < list.size(); i++)
            {
                AccountEntity accountEntity = (AccountEntity) list.get(0);
                System.out.println(accountEntity.getEmployee().getEmail());
            }
        }
        session.getTransaction().commit();
    }
}

/*
 * FILENAME
 *     TestForeignKeyAssociation.java
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

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.beingjavaguys.hbn.HibernateUtil;

public class TestForeignKeyAssociation
{

    public static void main(String[] args)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        AccountEntity account1 = new AccountEntity();
        account1.setAccountNumber("Account detail 1");

        AccountEntity account2 = new AccountEntity();
        account2.setAccountNumber("Account detail 2");

        AccountEntity account3 = new AccountEntity();
        account3.setAccountNumber("Account detail 3");

        EmployeeEntity firstEmployee = new EmployeeEntity();
        firstEmployee.setEmail("demo-user-first@mail.com");
        firstEmployee.setFirstName("demo-one");
        firstEmployee.setLastName("user-one");

        EmployeeEntity secondEmployee = new EmployeeEntity();
        secondEmployee.setEmail("demo-user-second@mail.com");
        secondEmployee.setFirstName("demo-two");
        secondEmployee.setLastName("user-two");

        Set<AccountEntity> accountsOfFirstEmployee = new HashSet<AccountEntity>();
        accountsOfFirstEmployee.add(account1);
        accountsOfFirstEmployee.add(account2);

        Set<AccountEntity> accountsOfSecondEmployee = new HashSet<AccountEntity>();
        accountsOfSecondEmployee.add(account3);

        firstEmployee.setAccounts(accountsOfFirstEmployee);
        secondEmployee.setAccounts(accountsOfSecondEmployee);

        // saving employees
        session.save(firstEmployee);
        session.save(secondEmployee);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}

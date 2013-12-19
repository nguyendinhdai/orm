/*
 * FILENAME
 *     App.java
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

package com.beingjavaguys.onetoone;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * @author Nagesh Chauhan
 *
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.beingjavaguys.hbn.HibernateUtil;

public class App
{
    public static void main(String[] args)
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Student student = new Student("Nagesh", "Daij", "beingjavaguy@gmail.com", "8789876765");
        StudentAddress studentAddress = new StudentAddress("g-147, sec-44", "new delhi", "new delhi", "india");

        student.setStudentAddress(studentAddress);
        studentAddress.setStudent(student);

        session.save(student);

        session.getTransaction().commit();
        session.close();
    }
}

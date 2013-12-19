/*
 * FILENAME
 *     HibernateMain.java
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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateMain
{

    public static void main(String[] args)
    {

        Shape shape = new Shape("Sqaure");
        Rectangle rectangle = new Rectangle("Rectangle", 10, 20);
        Circle circle = new Circle("Circle", 4);

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry sr =
            new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sf = configuration.buildSessionFactory(sr);
        Session ss = sf.openSession();

        ss.beginTransaction();
        ss.save(shape);
        ss.save(rectangle);
        ss.save(circle);
        ss.getTransaction().commit();
        ss.close();

    }
}

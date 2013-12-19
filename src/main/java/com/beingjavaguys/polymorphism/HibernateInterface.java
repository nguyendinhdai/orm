/*
 * FILENAME
 *     HibernateInterface.java
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

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateInterface
{

    final static Configuration CONFIGURATION = new AnnotationConfiguration().configure();
    final static SessionFactory SESSION_FACTORY = CONFIGURATION.buildSessionFactory();

    public static void saveEntities(final Object entity)
    {
        final Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        try
        {
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally
        {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Object> getRecordsOfType(@SuppressWarnings("rawtypes") final Class classObject)
    {
        final Session session = SESSION_FACTORY.openSession();
        try
        {
            return session.createCriteria(classObject).list();
        }
        finally
        {
            session.close();
        }
    }

    public static int exectueQuery(final String hqlQuery)
    {
        int effectedRecords = 0;
        final Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        try
        {
            effectedRecords = session.createQuery(hqlQuery).executeUpdate();
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally
        {
            session.close();
        }
        return effectedRecords;
    }

}

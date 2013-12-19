package com.beingjavaguys.hbn;

import java.util.ArrayList;
import org.hibernate.Session;

/**
 * @author Nagesh Chauhan!
 * 
 */
public class App
{
    public static void main(String[] args)
    {
        App app = new App();

        // create user data object
        User user = new User();
        user.setUserId(1);
        user.setFirstName("nagesh");
        user.setLastName("chauhan");
        user.setGender("male");
        user.setCity("gurgaon");

        User user1 = new User();
        user1.setUserId(2);
        user1.setFirstName("ankush");
        user1.setLastName("thakur");
        user1.setGender("male");
        user1.setCity("delhi");

        // save user in db
        app.saveUser(user);
        app.saveUser(user1);

        // update user data
        user.setCity("noida");
        app.updateUser(user);

        // delete user data
        app.deleteUser(user1);

        // get user data
        app.getUser();
    }

    public void saveUser(User user)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();
    }

    public void updateUser(User user)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.merge(user);

        session.getTransaction().commit();
    }

    public void deleteUser(User user)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(user);

        session.getTransaction().commit();
    }

    public void getUser()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        ArrayList<User> list = (ArrayList<User>) session.createQuery("from User").list();
        if (list != null)
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.println("User Data : " + list.get(i).getUserId());
                System.out.println("User First Name : " + list.get(i).getFirstName());
                System.out.println("User Last Name : " + list.get(i).getLastName());
                System.out.println("User Gender : " + list.get(i).getGender());
                System.out.println("User City : " + list.get(i).getCity());
            }
        }
        session.getTransaction().commit();
    }
}

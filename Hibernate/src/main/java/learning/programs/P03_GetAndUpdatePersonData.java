package learning.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import learning.entity.Person;
import learning.utils.HibernateUtil;

/**
 *
 */
public class P03_GetAndUpdatePersonData
{
    public static void main(final String[] args)
    {
        final SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        final Person p1 = session.get(Person.class, 1);
        session.close();

        p1.setHeight(6.5);
        session = factory.openSession();
        session.beginTransaction();
        session.merge(p1);
        session.getTransaction().commit();
        session.close();

    }

}

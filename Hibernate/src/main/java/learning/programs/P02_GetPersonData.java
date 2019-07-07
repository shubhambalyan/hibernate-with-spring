package learning.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import learning.entity.Person;
import learning.utils.HibernateUtil;

/**
 *
 */
public class P02_GetPersonData
{
    public static void main(final String[] args)
    {
        final SessionFactory factory = HibernateUtil.getSessionFactory();
        final Session session = factory.openSession();
        System.out.println("------ pass 1");
        final Person p1 = session.get(Person.class, 1);
        System.out.println("------ pass 2");
        System.out.println(p1);
        System.out.println("------ pass 3");
        session.close();
        factory.close();
    }
}

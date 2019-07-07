package learning.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import learning.entity.Person;
import learning.utils.HibernateUtil;

/**
 *
 */
public class P04_DeletePerson
{

    public static void main(final String[] args)
    {
        final SessionFactory factory = HibernateUtil.getSessionFactory();
        final Session session = factory.openSession();

        final Person p1 = session.get(Person.class, 4);

        if (p1 != null)
        {
            session.remove(p1);
            session.beginTransaction().commit();
            session.close();
        }
    }
}

package learning.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import learning.entity.Professor;
import learning.entity.Student;
import learning.utils.HibernateUtil;

public class P15_InheritanceDemo
{

    public static void main(final String[] args)
    {
        final SessionFactory factory = HibernateUtil.getSessionFactory();
        final Session session = factory.openSession();

        final Student st = new Student(12, "Ramesh", "ramesh@exmaple.com", "Maths", 4.8);
        final Professor pf = new Professor(77, "Kumar", "kumar@example.com", 45000.0);

        session.persist(st);
        session.persist(pf);

        session.beginTransaction().commit();
        session.close();

        System.out.println("Done!");
    }
}
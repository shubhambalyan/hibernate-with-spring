package learning.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import learning.entity.Employee;
import learning.utils.HibernateUtil;

/**
 *
 */
public class P09_GetEmployeeData
{

    /**
     * @param args
     */
    public static void main(final String[] args)
    {
        final SessionFactory factory = HibernateUtil.getSessionFactory();
        final Session session = factory.openSession();

        final Employee e1 = session.get(Employee.class, 5);

        System.out.println("Employee Details");
        System.out.println("Name: " + e1.getFirst_name() + " " + e1.getLast_name());
        System.out.println("Work: " + e1.getTitle());

        System.out.println("---------------");
        System.out.println("Manager Details");
        final Employee m1 = e1.getManager();
        System.out.println("Name: " + m1.getFirst_name() + " " + m1.getLast_name());
        System.out.println("Work: " + m1.getTitle());

        System.out.println("---------------");
        System.out.println("Subordibates Details");
        for (final Employee e : e1.getSubordinates())
        {
            System.out.println("Name: " + e.getFirst_name() + " " + e.getLast_name());
        }
    }

}

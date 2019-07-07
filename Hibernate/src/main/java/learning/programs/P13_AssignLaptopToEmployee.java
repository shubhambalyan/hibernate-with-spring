package learning.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import learning.entity.Employee;
import learning.entity.Laptop;
import learning.utils.HibernateUtil;

/**
 *
 */
public class P13_AssignLaptopToEmployee
{

    /**
     * @param args
     */
    public static void main(final String[] args)
    {
        final SessionFactory factory = HibernateUtil.getSessionFactory();
        final Session session = factory.openSession();

        final Laptop lt = new Laptop();
        lt.setMake("Dell");
        lt.setModel("Inspiron 15");
        lt.setSerialNumber("DELL12311");

        final Employee emp = session.get(Employee.class, 4);
        emp.setLaptop(lt);
        lt.setOwner(emp);

        session.persist(lt);

        session.beginTransaction().commit();
        session.close();

    }

}

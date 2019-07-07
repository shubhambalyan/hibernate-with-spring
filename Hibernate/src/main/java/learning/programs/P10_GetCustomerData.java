package learning.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import learning.entity.Customer;
import learning.entity.Employee;
import learning.utils.HibernateUtil;

/**
 *
 */
public class P10_GetCustomerData
{

    /**
     * @param args
     */
    public static void main(final String[] args)
    {
        final SessionFactory factory = HibernateUtil.getSessionFactory();
        final Session session = factory.openSession();

        final Customer c1 = session.get(Customer.class, "AROUT");

        System.out.println("Name " + c1.getCompany_name());
        System.out.println("POC " + c1.getContact_name());
        System.out.println("City " + c1.getContactDetails().getCity());

        System.out.println("Employees who have processed this customer order");
        for (final Employee e : c1.getEmployees())
        {
            System.out.println(e.getFirst_name() + " " + e.getLast_name());
        }
        session.close();
    }

}

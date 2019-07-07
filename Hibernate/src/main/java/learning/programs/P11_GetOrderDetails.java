package learning.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import learning.entity.Order;
import learning.utils.HibernateUtil;

/**
 *
 */
public class P11_GetOrderDetails
{

    /**
     * @param args
     */
    public static void main(final String[] args)
    {
        final SessionFactory factory = HibernateUtil.getSessionFactory();
        final Session session = factory.openSession();

        final Order o1 = session.get(Order.class, 10248);

        System.out.println("Customer Name: " + o1.getCustomer().getCompany_name());
        System.out.println("Employee Name: " + o1.getEmployee().getFirst_name());
        System.out.println("Freight: $" + o1.getFreight());
        System.out.println("Ship Address: " + o1.getShipDetails().getCity() + ", " + o1.getShipDetails().getCountry());

        //        System.out.println("Line item in this order are: ");
        //        for (final LineItem l : o1.getItems())
        //        {
        //            System.out.println(l.getOrder_id());
        //        }

        System.out.println("Shipped By: " + o1.getShippedBy().getCompany_name());
        session.close();
    }

}

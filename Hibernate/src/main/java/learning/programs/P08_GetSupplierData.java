package learning.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import learning.entity.ContactDetails;
import learning.entity.Supplier;
import learning.utils.HibernateUtil;

/**
 *
 */
public class P08_GetSupplierData
{
    public static void main(final String[] args)
    {

        final SessionFactory factory = HibernateUtil.getSessionFactory();
        final Session session = factory.openSession();

        final Supplier s1 = session.get(Supplier.class, 7);
        session.close();

        System.out.println("Company Name: " + s1.getCompanyName());
        System.out.println("Contact Person: " + s1.getContactName());
        final ContactDetails cd = s1.getContactDetails();
        System.out.println("City: " + cd.getCity());
        System.out.println("Region: " + cd.getRegion());
        System.out.println("COuntry: " + cd.getCountry());
    }
}

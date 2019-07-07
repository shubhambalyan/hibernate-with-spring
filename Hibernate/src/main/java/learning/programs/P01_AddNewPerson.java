package learning.programs;

import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import learning.entity.Person;
import learning.utils.HibernateUtil;

/**
 *
 */
public class P01_AddNewPerson
{
    public static void main(final String[] args)
            throws Exception
    {
        final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        final Person p1 = new Person();
        p1.setName("Shubham");
        p1.setAge(24);
        p1.setHeight(6.9);
        p1.setBirthDate(sdf.parse("30-03-1994"));

        final SessionFactory factory = HibernateUtil.getSessionFactory();
        //Get a session object (represents a connection to DB)
        final Session session = factory.openSession();

        //Perform CRUD operations
        //1. begin transaction
        final Transaction tx = session.beginTransaction();
        try
        {
            //2. perform INSERT/UPDATE/DELETE operations
            session.persist(p1);
            //3. try committing the transaction
            tx.commit();
        }
        catch (final Exception e)
        {
            //4. in case of error, roll back
            tx.rollback();
            System.out.println("Could not save the data");
        }
        session.close();
        factory.close(); //in practice, should be singleton
    }

}

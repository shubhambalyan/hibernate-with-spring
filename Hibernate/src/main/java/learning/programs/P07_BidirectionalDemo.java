package learning.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import learning.entity.Category;
import learning.entity.Product;
import learning.utils.HibernateUtil;

// http://bit.ly/20190422
public class P07_BidirectionalDemo
{

    public static void main(final String[] args)
    {

        final SessionFactory factory = HibernateUtil.getSessionFactory();
        final Session session = factory.openSession();

        final Category c1 = new Category();
        c1.setCategoryName("Stationaries");
        c1.setDescription("Paper, pen etc.");

        Product p1 = new Product();
        p1.setProductName("Pustak books");
        p1.setQuantityPerUnit("50 units of 100 pages book");
        p1.setUnitPrice(450.0);
        p1.setDiscontinued(0);
        c1.addProduct(p1);

        p1 = new Product();
        p1.setProductName("Hero pens");
        p1.setQuantityPerUnit("25 units");
        p1.setUnitPrice(700.0);
        p1.setDiscontinued(0);
        c1.addProduct(p1);

        session.persist(c1); // persists c1, and associated products

        session.beginTransaction().commit();
        session.close();
    }
}







package learning.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import learning.entity.Product;
import learning.entity.Supplier;
import learning.utils.HibernateUtil;

public class P05_GetOneProduct
{

    public static void main(final String[] args)
    {
        final SessionFactory factory = HibernateUtil.getSessionFactory();
        final Session session = factory.openSession();

        final Product p1 = session.get(Product.class, 1);


        System.out.println("Name= " + p1.getProductName());
        System.out.println("Price= $" + p1.getUnitPrice());
        System.out.println("Desc= " + p1.getQuantityPerUnit());
        System.out.println("Category= " + p1.getCategory().getCategoryName());
        final Supplier s1 = p1.getSupplier();
        System.out.println("Supplied By= " + s1.getCompanyName());

        System.out.println("Other products");
        for (final Product p : s1.getProducts())
        {
            System.out.println(p.getProductName() + " (" + p.getCategory().getCategoryName() + ")");
        }
        session.close();
    }

}

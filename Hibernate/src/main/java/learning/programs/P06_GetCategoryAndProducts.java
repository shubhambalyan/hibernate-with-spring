package learning.programs;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import learning.entity.Category;
import learning.entity.Product;
import learning.utils.HibernateUtil;

/**
 *
 */
public class P06_GetCategoryAndProducts
{

    /**
     * @param args
     */
    public static void main(final String[] args)
    {
        final SessionFactory factory = HibernateUtil.getSessionFactory();
        final Session session = factory.openSession();

        final Category c1 = session.get(Category.class, 3);
        System.out.println("Name =" + c1.getCategoryName());
        System.out.println("Desc =" + c1.getDescription());
        System.out.println("Products =" + c1.getProducts());
        for (final Product p : c1.getProducts())
        {
            System.out.println(p.getProductName());
        }
    }

}

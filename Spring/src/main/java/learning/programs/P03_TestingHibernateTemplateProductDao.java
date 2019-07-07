package learning.programs;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import learning.cfg.AppConfig6;
import learning.dao.DaoException;
import learning.dao.ProductDao;
import learning.entity.Product;

public class P03_TestingHibernateTemplateProductDao
{
    public static void main(final String[] args)
            throws DaoException
    {
        AnnotationConfigApplicationContext ctx;
        ctx = new AnnotationConfigApplicationContext(AppConfig6.class);
        final ProductDao dao = ctx.getBean("htDao", ProductDao.class);
        System.out.println("dao is an instanceof " + dao.getClass());

        final int pc = dao.count();
        System.out.println("Total " + pc + " products.");

        final Product p1 = dao.getProduct(14);
        System.out.println("Product Name: " + p1.getProductName());

        try
        {
            p1.setUnitPrice(p1.getUnitPrice() + 1);
            dao.updateProduct(p1);
            System.out.println("Product updated successfully");
        }
        catch (final DaoException e)
        {
            System.out.println("Unable to update the product...");
            System.out.println(e.getMessage());
        }

        System.out.println("Unit price is: " + p1.getUnitPrice());

        List<Product> list = dao.getProductByPriceRange(50.0, 100.0);
        System.out.println("Total products: " + list.size());

        final List<Product> list1 = dao.getProductByPriceRange(100.0, 50.0);
        System.out.println("Total products: " + list1.size());

        list = dao.getProductsBySupplier(p1.getSupplier().getSupplierId());
        System.out.println(p1.getSupplier().getCompanyName() + " supplies " + list.size() + " products");

        ctx.close();
    }
}

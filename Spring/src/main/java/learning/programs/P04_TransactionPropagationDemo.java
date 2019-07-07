package learning.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import learning.cfg.AppConfig6;
import learning.dao.DaoException;
import learning.service.ProductManager;

public class P04_TransactionPropagationDemo
{
    public static void main(final String[] args)
            throws DaoException
    {
        AnnotationConfigApplicationContext ctx;
        ctx = new AnnotationConfigApplicationContext(AppConfig6.class);

        //non-transactional context

        final ProductManager pm = ctx.getBean(ProductManager.class);
        pm.updateProducts();
        System.out.println("Product prices updated successfully!!!");

        ctx.close();
    }
}

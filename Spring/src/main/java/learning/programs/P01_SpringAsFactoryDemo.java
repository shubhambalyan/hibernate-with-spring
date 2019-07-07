package learning.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import learning.cfg.AppConfig6;
import learning.dao.DaoException;
import learning.dao.ProductDao;

/**
 *
 */
public class P01_SpringAsFactoryDemo
{

    /**
     * @param args
     * @throws DaoException
     */
    public static void main(final String[] args)
            throws DaoException
    {
        //spring container
        final AnnotationConfigApplicationContext ctx;
        //object representing spring container based on AppConfig1
        ctx = new AnnotationConfigApplicationContext(AppConfig6.class);

        final ProductDao dao1 = ctx.getBean("htDao", ProductDao.class);
        final int pc = dao1.count();
        System.out.println(pc);
        //close the container
        ctx.close();
    }

}

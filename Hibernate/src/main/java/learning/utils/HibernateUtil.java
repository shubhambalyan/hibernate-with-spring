package learning.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 */
public final class HibernateUtil
{
    private HibernateUtil()
    {

    }

    private static SessionFactory factory;

    public static SessionFactory getSessionFactory()
    {
        if (factory == null)
        {
            //Empty configuration object
            final Configuration cfg = new Configuration();
            //Read from hibernate.cfg.xml file in the build path (Added to resources folder)
            cfg.configure();
            //            cfg.addAnnotatedClass(Category.class);
            //Build the session factory (represents a DB)
            factory = cfg.buildSessionFactory();
        }
        return factory;
    }

}

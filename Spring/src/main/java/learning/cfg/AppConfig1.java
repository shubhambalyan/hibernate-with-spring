package learning.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import learning.dao.ProductDao;
import learning.dao.impl.DummyProductDao;
import learning.dao.impl.JDBCProductDao;

@Configuration
public class AppConfig1
{
    /**
     *
     */
    public AppConfig1()
    {
        System.out.println("Creating an object of AppConfig1");
        //        System.out.println(this.getClass()); //Proxy Object
    }

    @Bean
    public ProductDao dummy()
    {
        System.out.println("Returning an instanceof DummyProductDao...");
        //        for (int i = 0; i < 5; i++)
        //        {
        //            this.jdbc();
        //        }
        return new DummyProductDao();
    }

    @Bean
    public ProductDao jdbc()
    {
        System.out.println("Returning an instanceof JDBCProductDao...");
        return new JDBCProductDao();
    }
}

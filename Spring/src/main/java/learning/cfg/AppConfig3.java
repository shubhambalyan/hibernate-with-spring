package learning.cfg;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import learning.dao.ProductDao;
import learning.dao.impl.JDBCProductDao;

@Configuration
public class AppConfig3
{
    //@Bean
    public ProductDao jdbc()
    {
        //Constructor based Injection
        return new JDBCProductDao("org.h2.Driver", "jdbc:h2:tcp://localhost/~/DB20190422", "sa", "");
    }

    @Bean
    public Connection connection()
            throws Exception
    {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/DB20190422");
    }

    @Bean
    public ProductDao dao(final Connection conn) //dependency injection
    {
        final JDBCProductDao d = new JDBCProductDao();
        d.setConnection(conn); //manual wiring
        return d;
    }
}

package learning.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import learning.dao.ProductDao;
import learning.dao.impl.JDBCProductDao;

@Configuration
public class AppConfig2
{
    @Scope("singleton")
    //    @Scope("prototype")
    @Bean
    public ProductDao jdbc()
    {
        //Manual Injection
        final JDBCProductDao dao = new JDBCProductDao();
        dao.setDriverClassName("org.h2.Driver");
        dao.setUsername("sa");
        dao.setPassword("");
        dao.setUrl("jdbc:h2:tcp://localhost/~/DB20190422");
        return dao;
    }
}

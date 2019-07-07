package learning.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import learning.dao.ProductDao;
import learning.dao.impl.JDBCProductDao;

@Configuration
public class AppConfig4
{

    @Bean
    public DataSource dataSource()
    {
        final BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("org.h2.Driver");
        bds.setUrl("jdbc:h2:tcp://localhost/~/DB20190422");
        bds.setUsername("sa");
        bds.setPassword("");
        bds.setInitialSize(10);
        bds.setMaxTotal(100);
        bds.setMaxIdle(50);
        bds.setMinIdle(5);
        return bds;
    }

    @Bean(autowire = Autowire.BY_NAME)
    //    @Bean(autowire = Autowire.BY_TYPE)
    public ProductDao dao()
    {
        return new JDBCProductDao();
    }
}

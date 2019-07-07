package learning.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAspectJAutoProxy //to enable aspectj auto proxy
@EnableTransactionManagement //to enable transaction management
@Configuration
@ComponentScan(basePackages = {
        "training.dao",
        "training.aop",
        "training.service"
})
public class AppConfig6
{
    //this bean is equivalent of an Aspect object
    @Bean
    public HibernateTransactionManager txMgr(final SessionFactory factory)
    {
        return new HibernateTransactionManager(factory);
    }

    @Bean
    public LocalSessionFactoryBean factory(final DataSource ds)
    {
        final LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(ds);
        sf.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
        return sf;
    }

    @Bean
    public HibernateTemplate ht(final SessionFactory factory)
    {
        return new HibernateTemplate(factory);
    }

    @Bean
    public DataSource ds()
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

}
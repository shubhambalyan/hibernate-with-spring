package learning.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import learning.dao.DaoException;
import learning.dao.ProductDao;
import learning.entity.Product;

@Component
public class JDBCProductDao implements ProductDao
{

    // parameters for a new connection
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    // ready to use connection
    private Connection connection;

    // connection pool
    @Autowired(required = false)
    private DataSource dataSource;

    public JDBCProductDao()
    {
        System.out.println("I'm called!");
    }

    public JDBCProductDao(final String driverClassName, final String url, final String username, final String password)
    {
        super();
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public JDBCProductDao(final DataSource dataSource)
    {
        super();
        this.dataSource = dataSource;
    }

    //mutator or setter property - writable property
    //spring can inject a dependency via this setter.
    public void setDriverClassName(final String driverClassName)
    {
        this.driverClassName = driverClassName;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(final String url)
    {
        this.url = url;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(final String username)
    {
        this.username = username;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(final String password)
    {
        this.password = password;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(final Connection connection)
    {
        this.connection = connection;
    }

    /**
     * @param dataSource the dataSource to set
     */
    public void setDataSource(final DataSource dataSource)
    {
        System.out.println("Called");
        this.dataSource = dataSource;
    }

    private Connection openConnection()
            throws Exception
    {
        if (dataSource != null)
        {
            return dataSource.getConnection();
        }
        if (connection != null && !connection.isClosed())
        {
            return connection;
        }
        Class.forName(driverClassName);
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public int count()
            throws DaoException
    {
        final String sql = "select count(*) from products";
        try (Connection conn = openConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();)
        {
            rs.next();
            return rs.getInt(1);
        }
        catch (final Exception e)
        {
            //exception funneling
            throw new DaoException(e);
        }
    }

    @Override
    public void addProduct(final Product product)
            throws DaoException
    {
        throw new DaoException("Method not implemented");

    }

    @Override
    public Product getProduct(final Integer id)
            throws DaoException
    {
        throw new DaoException("Method not implemented");
    }

    @Override
    public void updateProduct(final Product product)
            throws DaoException
    {
        throw new DaoException("Method not implemented");

    }

    @Override
    public void deleteProduct(final Integer id)
            throws DaoException
    {
        throw new DaoException("Method not implemented");

    }

    @Override
    public List<Product> getAllProducts()
            throws DaoException
    {
        throw new DaoException("Method not implemented");
    }

    @Override
    public List<Product> getProductByPriceRange(final Double min, final Double max)
            throws DaoException
    {
        throw new DaoException("Method not implemented");
    }

    @Override
    public List<Product> getProductsByCategory(final Integer categoryId)
            throws DaoException
    {
        throw new DaoException("Method not implemented");
    }

    @Override
    public List<Product> getProductsBySupplier(final Integer supplierId)
            throws DaoException
    {
        throw new DaoException("Method not implemented");
    }

    @Override
    public List<Product> getOutOfStockProducts()
            throws DaoException
    {
        throw new DaoException("Method not implemented");
    }

}

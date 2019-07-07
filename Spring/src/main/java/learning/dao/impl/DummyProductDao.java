package learning.dao.impl;

import java.util.List;

import learning.dao.DaoException;
import learning.dao.ProductDao;
import learning.entity.Product;

public class DummyProductDao implements ProductDao
{

    @Override
    public int count()
            throws DaoException
    {
        return -50;
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

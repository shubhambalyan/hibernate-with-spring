package learning.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import learning.dao.DaoException;
import learning.dao.ProductDao;
import learning.entity.Product;

@Repository("htDao")
public class HibernateTemplateProductDao implements ProductDao
{

    @Autowired(required = false)
    private HibernateTemplate template;

    @Override
    public void addProduct(final Product product)
            throws DaoException
    {
        // we must handle exception from 'persist' function and rethrow them in the form of DaoException
        // We will use AOP to remove this cross-cutting concern.
        template.persist(product);
    }

    @Override
    public Product getProduct(final Integer id)
            throws DaoException
    {
        return template.get(Product.class, id);
    }

    @Override
    public void updateProduct(final Product product)
            throws DaoException
    {
        if (product.getUnitPrice() < 0)
        {
            throw new DaoException("Price cannot be negative");
        }
        template.merge(product);
    }

    @Override
    public void deleteProduct(final Integer id)
            throws DaoException
    {
        final Product p1 = getProduct(id);
        if (p1 == null)
        {
            throw new DaoException("Invlid id for deletion " + id);
        }
        template.delete(p1);
    }

    @Override
    public List<Product> getAllProducts()
            throws DaoException
    {
        final String hql = "from Products";
        final List<Product> list = template.execute(sess -> sess.createQuery(hql, Product.class).list());
        return list;
    }

    @Override
    public List<Product> getProductByPriceRange(final Double min, final Double max)
            throws DaoException
    {
        final DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
        //        dc.add(Restrictions.ge("unitPrice", min));
        //        dc.add(Restrictions.le("unitPrice", max));
        dc.add(Restrictions.between("unitPrice", min, max));
        return (List<Product>) template.findByCriteria(dc);
    }

    @Override
    public List<Product> getProductsByCategory(final Integer categoryId)
            throws DaoException
    {
        final List<Product> list = template.execute(
                session -> {
                    final String hql = "from Product where category.categoryId=:CAT_ID";
                    final Query<Product> qry = session.createQuery(hql, Product.class);
                    qry.setParameter("CAT_ID", categoryId);
                    return qry.getResultList();
                });
        return list;
    }

    @Override
    public List<Product> getProductsBySupplier(final Integer supplierId)
            throws DaoException
    {

        final List<Product> list = template.execute(
                session -> {
                    final String hql = "from Product where supplier.supplierId=:SUP_ID";
                    final Query<Product> qry = session.createQuery(hql, Product.class);
                    qry.setParameter("SUP_ID", supplierId);
                    return qry.getResultList();
                });
        return list;
    }

    @Override
    public List<Product> getOutOfStockProducts()
            throws DaoException
    {
        final String hql = "from Product where unitsInStock=0";
        final List<Product> list = template.execute(
                session -> session.createQuery(hql, Product.class).list());
        return list;
    }

    @Override
    public int count()
            throws DaoException
    {
        final String hql = "select count(p) from Product p";
        final Long p = template.execute(
                session -> session.createQuery(hql, Long.class).uniqueResult());
        return p.intValue();
    }

}

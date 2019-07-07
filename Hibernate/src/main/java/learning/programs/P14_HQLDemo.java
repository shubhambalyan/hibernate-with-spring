package learning.programs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import learning.entity.Product;
import learning.entity.Shipper;
import learning.utils.HibernateUtil;

/**
 *
 */
public class P14_HQLDemo
{

    private static Session session;
    /**
     * @param args
     */
    public static void main(final String[] args)
    {
        final SessionFactory factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();

        //        printAllShippers();
        //        printProductsByPage(4); // records 31-40
        //        printProductsByPriceRange(50.0, 250.0);
        //        printSupplierNames();
        //        printProductAndCategoryNames();
        //        printSupplierWithProductNames();
        //        printCategoryWiseAggregateData();
        increaseProductPriceBy(1.0);

        session.close();
    }

    static void increaseProductPriceBy(final double incBy)
    {
        Product p1 = session.get(Product.class, 1);
        System.out.println("Price= " + p1.getUnitPrice());
        final String hql = "update Product set unitPrice = unitPrice + :INC_BY";
        final Query<?> qry = session.createQuery(hql);
        qry.setParameter("INC_BY", incBy);
        final Transaction tx = session.beginTransaction();
        final int n = qry.executeUpdate();
        tx.commit();
        System.out.println("Price Updated for " + n + " products");
        session.refresh(p1);
        p1 = session.get(Product.class, 1);
        System.out.println("Price= " + p1.getUnitPrice());
    }

    static void printCategoryWiseAggregateData()
    {
        final String hql = "select category.categoryName, count(p), avg(unitPrice), min(unitPrice), "
                + "max(unitPrice) from Product p "
                + "group by category.categoryName having count(p) >= 10 "
                + "order by category.categoryName";

        final Query<Object[]> qry = session.createQuery(hql, Object[].class);
        final List<Object[]> list = qry.list();
        for (final Object[] data : list)
        {
            System.out.printf("%-20s %3d %10.2f %10.2f %10.2f\n", data[0], data[1], data[2], data[3], data[4]);
        }
    }

    static void printSupplierWithProductNames()
    {
        final String hql = "select s.companyName, p.productName from Supplier s join s.products as p";
        final Query<Object[]> qry = session.createQuery(hql, Object[].class);
        final List<Object[]> list = qry.list();
        for (final Object[] data : list)
        {
            System.out.println(data[0] + "-->" + data[1]);
        }
    }

    static void printProductAndCategoryNames()
    {
        final String hql = "select productName, category.categoryName from Product";
        final Query<Object[]> qry = session.createQuery(hql, Object[].class);
        final List<Object[]> list = qry.list();
        for (final Object[] data : list)
        {
            System.out.println(data[0] + "-->" + data[1]);
        }
    }

    static void printSupplierNames()
    {
        final String hql = "select companyName from Supplier";
        final Query<String> qry = session.createQuery(hql, String.class);
        final List<String> list = qry.list();
        for (final String name : list)
        {
            System.out.println(name);
        }
    }

    static void printProductsByPriceRange(final double min, final double max)
    {
        final String hql = "from Product where unitPrice between :MIN_PRICE and :MAX_PRICE order by unitPrice";
        final Query<Product> qry = session.createQuery(hql, Product.class);
        qry.setParameter("MIN_PRICE", min);
        qry.setParameter("MAX_PRICE", max);
        final List<Product> list = qry.getResultList();
        for (final Product s : list)
        {
            System.out.println(s.getProductName() + " " + s.getUnitPrice());
        }
    }


    static void printProductsByPage(final int pageNum)
    {
        final String hql = "select p from Product p order by p.productId";
        final Query<Product> qry = session.createQuery(hql, Product.class);
        qry.setMaxResults(10);
        qry.setFirstResult((pageNum-1)*10);
        final List<Product> list = qry.getResultList();
        for (final Product s : list)
        {
            System.out.println(s.getProductId() + " " + s.getProductName() + " " + s.getCategory().getCategoryName());
        }
    }

    static void printAllShippers()
    {
        final String hql = "from Shipper";
        final Query<Shipper> qry = session.createQuery(hql, Shipper.class);
        final List<Shipper> list = qry.getResultList();
        for (final Shipper s : list)
        {
            System.out.println(s.getCompany_name() + " " + s.getPhone());
        }
    }

}


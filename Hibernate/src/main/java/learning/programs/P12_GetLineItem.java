package learning.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import learning.entity.LineItem;
import learning.utils.HibernateUtil;

/**
 *
 */
public class P12_GetLineItem
{
    public static void main(final String[] args)
    {
        final SessionFactory factory = HibernateUtil.getSessionFactory();
        final Session session = factory.openSession();

        final LineItem id = new LineItem(10250, 51);
        final LineItem item = session.get(LineItem.class, id);

        System.out.println(item);
        session.close();
    }
}

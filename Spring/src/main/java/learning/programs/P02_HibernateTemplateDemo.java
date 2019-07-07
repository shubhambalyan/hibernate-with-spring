package learning.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import learning.cfg.AppConfig6;
import learning.entity.Product;

public class P02_HibernateTemplateDemo
{
    public static void main(final String[] args)
    {
        AnnotationConfigApplicationContext ctx;
        ctx = new AnnotationConfigApplicationContext(AppConfig6.class);

        final HibernateTemplate tpl = ctx.getBean(HibernateTemplate.class);
        final Product p1 = tpl.get(Product.class, 17);
        System.out.println("Name: " + p1.getProductName());
        System.out.println("Price: " + p1.getUnitPrice());
        System.out.println("Category: " + p1.getCategory().getCategoryName());
        System.out.println("Supplier: " + p1.getSupplier().getCompanyName());
        ctx.close();
    }
}

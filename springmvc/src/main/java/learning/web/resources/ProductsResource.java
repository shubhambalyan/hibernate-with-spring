package learning.web.resources;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learning.dao.DaoException;
import learning.dao.ProductDao;
import learning.entity.Product;

@RestController
@RequestMapping("/api/products")
public class ProductsResource
{

    @Autowired
    private ProductDao dao;

    @RequestMapping(path = "/{pid}", method = RequestMethod.GET, produces = {
            "application/json",
            "application/xml"
    })
    public Product getOneProduct(@PathVariable("pid") final Integer id)
            throws DaoException
    {
        return dao.getProduct(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = {
            "application/json"
    })
    public List<Product> getProducts(
            @RequestParam(required = false) final Double min,
            @RequestParam(required = false) final Double max)
            throws DaoException
    {
        if (min == null && max == null)
        {
            return dao.getAllProducts();
        }
        else if (min == null)
        {
            return dao.getProductsByPriceRange(0.0, max);
        }
        else if (max == null)
        {
            return dao.getProductsByPriceRange(min, 1000000.0);
        }
        else
        {
            return dao.getProductsByPriceRange(min, max);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {
            "application/json",
            "application/xml"
    }, produces = "application/json")
    public Map<String, Object> addProduct(@RequestBody final Product pr)
            throws DaoException
    {
        final Map<String, Object> m = new LinkedHashMap<>();

        try
        {
            dao.addProduct(pr);
            m.put("success", true);
            m.put("generated-id", pr.getProductId());
        }
        catch (final Exception e)
        {
            m.put("success", false);
            m.put("reason", e.getMessage());
        }
        return m;
    }

}

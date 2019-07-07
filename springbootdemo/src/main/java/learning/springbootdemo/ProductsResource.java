package learning.springbootdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductsResource
{
    @Autowired
    private ProductDao dao;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = {
            "application/json",
            "application/xml"
    })
    public Product getOneProduct(@PathVariable("id") final Integer id)
    {
        return dao.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.GET, produces = {
            "application/json"
    })
    public List<Product> getProducts(
            @RequestParam(required = false) final Double min,
            @RequestParam(required = false) final Double max)
    {
            return dao.getProductsByPriceRange(min, max);
    }

    @RequestMapping("/info")
    public String info()
    {
        return "REST endpoint /api/products created by Shubham";
    }
}

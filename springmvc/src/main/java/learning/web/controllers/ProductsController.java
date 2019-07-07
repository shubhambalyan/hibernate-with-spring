package learning.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import learning.dao.DaoException;
import learning.dao.ProductDao;

@Controller
public class ProductsController
{
    @Autowired
    private ProductDao dao;

    //Request Handler
    @RequestMapping("/info")
    public String info(final Model model)
    {
        //Model data is kept in request scope
        model.addAttribute("Name", "Shubham Balyan");
        model.addAttribute("Email", "shubhambalyan@hpe.com");
        model.addAttribute("Phone", "9971559931");
        model.addAttribute("Place", "Bangalore");
        return "info";
    }

    @RequestMapping(path = "/get-products-by-price", method = RequestMethod.GET)
    public String getProductsByPrice(
            @RequestParam("min_price") final Double min,
            @RequestParam("max_price") final Double max,
            final Model model)
            throws DaoException
    {
        model.addAttribute("data", dao.getProductsByPriceRange(min, max));
        return "show-products";
    }

}

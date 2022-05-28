package com.example.springstartherepart2.controller;

import com.example.springstartherepart2.model.Product;
import com.example.springstartherepart2.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Through a browser’s HTML form process directly, you can use only HTTP GET and HTTP
 * POST. To use other HTTP methods such as DELETE or PUT, you need to implement the
 * call using a client language such as JavaScript.
 */
@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @RequestMapping("/products")   //uses GET method by default
    @GetMapping("/products")
    public String viewProducts(Model model) {
        var products = productService.getProducts();
        /*Returns products list from controller to view resolver*/
        model.addAttribute("products", products);
        return "products.html";
    }

    /*For POST query parameters are sent in the body of query
//    @RequestMapping(path = "/products", method = RequestMethod.POST)
    @PostMapping("/products")
    public String addProduct(@RequestParam String name,
                             @RequestParam double price,
                             Model model) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct(p);

        var products = productService.getProducts();
        model.addAttribute("products", products);
        return "products.html";
    }
    */

    /*Because of Product class has name and price attributes,
    * Spring can create Product instance automatically with data
    * from <input> tags. Compare it with commented method above*/
    @PostMapping("/products")
    public String addProduct(Product p,     //instead of name and price parameters
                             Model model) {
        productService.addProduct(p);

        var products = productService.getProducts();
        model.addAttribute("products", products);
        return "products.html";
    }
}

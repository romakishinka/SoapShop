package ru.vsu.soapshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vsu.soapshop.model.Product;
import ru.vsu.soapshop.service.ProductService;
import ru.vsu.soapshop.service.UserService;

import java.util.List;

/**
 * Created by Александр on 21.05.2017.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @RequestMapping(value="/products", method = RequestMethod.GET)
    public String showProduct(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "adminProducts";
    }


    @RequestMapping(value = "/products/{productId}/delete", method = RequestMethod.GET)
    public String deleteItem(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
        return "redirect:/admin/products";
    }


    @RequestMapping(value = "/products/new", method = RequestMethod.POST)
    public String addProduct(@RequestParam("productName") String productName,@RequestParam("price") int price,@RequestParam("description") String description ){
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setDescription(description);
        productService.addProduct(product);
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "/products/new", method = RequestMethod.GET)
    public String addProduct(Model model){
        return "addProduct";
    }


    @RequestMapping(value="/products/{productId}", method = RequestMethod.GET)
    public String editProduct(@PathVariable("productId") Long productId, Model model){
        model.addAttribute("product",productService.getProduct(productId));
        return "editProduct";
    }

    @RequestMapping(value="/products/{productId}", method = RequestMethod.POST)
    public String editProduct(@PathVariable("productId") Long productId, @RequestParam("productName") String productName,@RequestParam("price") int price,@RequestParam("description") String description ){
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setDescription(description);
        product.setProductId(productId);
        productService.editProduct(product);
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "usersAdmin";
    }
}

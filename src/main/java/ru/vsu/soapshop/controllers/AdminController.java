package ru.vsu.soapshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vsu.soapshop.model.Product;
import ru.vsu.soapshop.service.ProductService;

import java.util.List;

/**
 * Created by Александр on 21.05.2017.
 */
@Controller
public class AdminController {

    @Autowired
    ProductService productService;

    @RequestMapping(value="/admin/products", method = RequestMethod.GET)
    public String showProduct(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "adminProducts";
    }

    @RequestMapping(value = "/admin/products/new", method = RequestMethod.POST)
    public String addProduct(@RequestParam("productName") String productName,@RequestParam("price") int price,@RequestParam("description") String description ){
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setDescription(description);
        productService.addProduct(product);
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "/admin/products/new", method = RequestMethod.GET)
    public String addProduct(Model model){
        return "addProduct";
    }

    @RequestMapping(value = "/admin/products/{productId}/delete", method = RequestMethod.GET)
    public String deleteItem(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
        return "redirect:/admin/products";
    }
    @RequestMapping(value="/admin/products/{productId}", method = RequestMethod.GET)
    public String editProduct(@PathVariable("productId") Long productId, Model model){
        model.addAttribute("product",productService.getProduct(productId));
        return "editProduct";
    }
    @RequestMapping(value="/admin/products/{productId}", method = RequestMethod.POST)
    public String editProduct(@PathVariable("productId") Long productId, @RequestParam("productName") String productName,@RequestParam("price") int price,@RequestParam("description") String description ){
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setDescription(description);
        product.setProductId(productId);
        productService.editProduct(product);
        return "redirect:/admin/products";
    }
}

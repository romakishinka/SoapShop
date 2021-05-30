package ru.vspu.soapshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vspu.soapshop.model.Product;
import ru.vspu.soapshop.model.Orders;
import ru.vspu.soapshop.model.User;
import ru.vspu.soapshop.service.OrderService;
import ru.vspu.soapshop.service.ProductService;
import ru.vspu.soapshop.service.SecurityService;
import ru.vspu.soapshop.service.UserService;

import java.util.List;

/**
 * Created by Roman Kishinka on 20.04.2021.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    SecurityService securityService;

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

    @RequestMapping(value ="/users/changeStatus/{orderId}" , method =RequestMethod.GET)
    public String changeOrder(@PathVariable("orderId") Long orderId){
        orderService.changeStatus(orderId,3);
        return "redirect:/admin/users";
    }

    @RequestMapping(value ="/users/delete/{orderId}" , method =RequestMethod.GET)
    public String deleteOrder(@PathVariable("orderId") Long orderId){
        orderService.deleteOrder(orderId);
        return "redirect:/admin/users";
    }

    @RequestMapping(value ="/users/{userId}" , method =RequestMethod.GET)
    public String deleteUsersOrder(@PathVariable("userId") Long userId){
        List<Orders> orders = orderService.findAllUserOrders(userId);
        for (Orders order: orders) {
            orderService.deleteOrder(order.getOrderId());
        }
        return "redirect:/admin/users";
    }

    @RequestMapping(value ="/location/{username}" , method =RequestMethod.GET)
    public String showUsersLocation(@PathVariable("username") String username, Model model){
        User user = userService.findByUsername(username);
        model.addAttribute("location", user.getLocation());
        return "locationAdmin";
    }
}

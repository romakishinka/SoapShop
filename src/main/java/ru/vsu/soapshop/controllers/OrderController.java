package ru.vsu.soapshop.controllers;

import javafx.util.Pair;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vsu.soapshop.model.OrderItems;
import ru.vsu.soapshop.model.Orders;
import ru.vsu.soapshop.model.Product;
import ru.vsu.soapshop.service.OrderItemsService;
import ru.vsu.soapshop.service.OrderService;
import ru.vsu.soapshop.service.ProductService;
import ru.vsu.soapshop.service.UserService;
import ru.vsu.soapshop.service.impl.SecurityServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 20.05.2017.
 */
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    SecurityServiceImpl securityService;

    @Autowired
    OrderItemsService orderItemsService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String showAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping(value = "/products/addToBasket", method = RequestMethod.POST)
    public String addOrder(Model model, @RequestParam("code") Long productId) {
        Long orderId;
        Long userId = userService.findByUsername(securityService.findLoggedInUsername()).getId();
        Orders order = orderService.findUserBasket(userId);
        if (order == null) {
            Orders newOrder = new Orders();
            newOrder.setUserId(userId);
            newOrder.setStatus(1);
            orderService.addOrder(newOrder);
            orderId = newOrder.getOrderId();
        } else
            orderId = order.getOrderId();
        OrderItems orderItem = new OrderItems();
        orderItem.setOrderId(orderId);
        orderItem.setAmount(1);
        orderItem.setProductId(productId);
        orderItemsService.addOrderItems(orderItem);

        return "redirect:/products";
    }


    @RequestMapping(value = "/userOrders", method = RequestMethod.GET)
    public String userOrders(Model model) {
        String username = securityService.findLoggedInUsername();
        List<Orders> orders = orderService.findAllUserOrders(userService.findByUsername(username).getId());
        model.addAttribute("orders", orders);
        return "userOrders";
    }

    @RequestMapping(value ="/userOrders/{orderId}", method =RequestMethod.GET)
    public String confirmOrder(@PathVariable("orderId") Long orderId){
        orderService.changeStatus(orderId,4);
        return "redirect:/userOrders";
    }
}

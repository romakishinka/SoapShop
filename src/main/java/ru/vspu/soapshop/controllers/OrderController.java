package ru.vspu.soapshop.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vspu.soapshop.model.Product;
import ru.vspu.soapshop.model.OrderItems;
import ru.vspu.soapshop.model.Orders;
import ru.vspu.soapshop.service.OrderItemsService;
import ru.vspu.soapshop.service.OrderService;
import ru.vspu.soapshop.service.ProductService;
import ru.vspu.soapshop.service.UserService;
import ru.vspu.soapshop.service.impl.SecurityServiceImpl;

import java.util.List;

/**
 * Created by Roman Kishinka on 20.04.2021.
 */
@Controller
@Slf4j
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
        log.info("Количество товаров в заказе: {}", products.size());
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

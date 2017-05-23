package ru.vsu.soapshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vsu.soapshop.model.OrderItems;
import ru.vsu.soapshop.model.Orders;
import ru.vsu.soapshop.service.OrderItemsService;
import ru.vsu.soapshop.service.OrderService;
import ru.vsu.soapshop.service.UserService;
import ru.vsu.soapshop.service.impl.SecurityServiceImpl;

/**
 * Created by Александр on 23.05.2017.
 */
@Controller
public class BasketController {

    @Autowired
    OrderItemsService orderItemsService;

    @Autowired
    OrderService orderService;

    @Autowired
    SecurityServiceImpl securityService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String basket(Model model) {
        String userName = securityService.findLoggedInUsername();
        Orders basket = orderService.findUserBasket(userService.findByUsername(userName).getId());
        model.addAttribute("basket", basket);
        return "basket";
    }

    @RequestMapping(value = "/basket/{orderItemId}", method = RequestMethod.POST)
    public String changeItem(@PathVariable("orderItemId") Long itemId, @RequestParam("amount") int amount) {
        if (amount <= 0)
            orderItemsService.deleteOrderItems(itemId);
        else {
            OrderItems item = orderItemsService.getOrderItems(itemId);
            item.setAmount(amount);
            orderItemsService.editOrderItems(item);
        }

        return "redirect:/basket";
    }

    @RequestMapping(value = "/basket/{orderItemId}/delete", method = RequestMethod.GET)
    public String deleteItem(@PathVariable("orderItemId") Long itemId) {
        orderItemsService.deleteOrderItems(itemId);
        return "redirect:/basket";
    }

    @RequestMapping(value = "/basket/toorder", method = RequestMethod.GET)
    public String basketToOrder() {
        String userName = securityService.findLoggedInUsername();
        Orders basket = orderService.findUserBasket(userService.findByUsername(userName).getId());
        basket.setStatus(2);
        orderService.editOrder(basket);
        return "redirect:/main";
    }
}

package ru.vsu.soapshop.service;

import ru.vsu.soapshop.model.Orders;

import java.util.List;

/**
 * Created by Александр on 20.05.2017.
 */
public interface OrderService {

    List<Orders> findAllUserOrders(Long userId);
    Orders findUserBasket(Long userId);
    List<Orders> findUserOrdersByStatus(Long userId, int status);
    void deleteOrder(Long id);
    void editOrder(Orders order);
    void addOrder(Orders order);

}

package ru.vspu.soapshop.service;

import ru.vspu.soapshop.model.Orders;

import java.util.List;

/**
 * Created by Roman Kishinka on 20.05.2021.
 */
public interface OrderService {

    List<Orders> findAllUserOrders(Long userId);
    Orders findUserBasket(Long userId);
    List<Orders> findUserOrdersByStatus(Long userId, int status);
    void deleteOrder(Long id);
    void editOrder(Orders order);
    void addOrder(Orders order);
    void changeStatus(Long id, int newStatus);
    Orders fingById(Long id);

}

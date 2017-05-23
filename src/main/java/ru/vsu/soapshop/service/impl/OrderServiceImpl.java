package ru.vsu.soapshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.soapshop.model.Orders;
import ru.vsu.soapshop.repository.OrderRepository;
import ru.vsu.soapshop.service.OrderService;

import java.util.List;

/**
 * Created by Александр on 20.05.2017.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Orders> findAllUserOrders(Long userId) {
        return orderRepository.findAllUserOrders(userId);
    }

    @Override
    public Orders findUserBasket(Long userId) {
        List<Orders> out = orderRepository.findUserOrdersByStatus(userId, 1);
        if(out.isEmpty())
            return null;
        return out.get(0);
    }

    @Override
    public List<Orders> findUserOrdersByStatus(Long userId, int status) {
        return orderRepository.findUserOrdersByStatus(userId, status);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.delete(id);
    }

    @Override
    public void editOrder(Orders order) {
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void addOrder(Orders order) {
        orderRepository.saveAndFlush(order);
    }
}

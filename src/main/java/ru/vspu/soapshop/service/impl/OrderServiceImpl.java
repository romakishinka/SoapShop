package ru.vspu.soapshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vspu.soapshop.repository.OrderItemsRepository;
import ru.vspu.soapshop.model.OrderItems;
import ru.vspu.soapshop.model.Orders;
import ru.vspu.soapshop.repository.OrderRepository;
import ru.vspu.soapshop.service.OrderService;

import java.util.List;

/**
 * Created by Roman Kishinka on 20.05.2021.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemsRepository orderItemsRepository;

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
        Orders order = orderRepository.findById(id);
        for (OrderItems item: order.getOrderItems()) {
            orderItemsRepository.delete(item.getId());
        }
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

    @Override
    public void changeStatus(Long id, int newStatus) {
        Orders editOrder = orderRepository.findById(id);
        editOrder.setStatus(newStatus);
        orderRepository.saveAndFlush(editOrder);
    }

    @Override
    public Orders fingById(Long id) {
        return orderRepository.findById(id);
    }
}

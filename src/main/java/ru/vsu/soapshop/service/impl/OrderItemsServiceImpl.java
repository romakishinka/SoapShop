package ru.vsu.soapshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.soapshop.model.OrderItems;
import ru.vsu.soapshop.model.Orders;
import ru.vsu.soapshop.repository.OrderItemsRepository;
import ru.vsu.soapshop.service.OrderItemsService;
import ru.vsu.soapshop.service.OrderService;

import java.util.List;

/**
 * Created by Александр on 23.05.2017.
 */
@Service
public class OrderItemsServiceImpl implements OrderItemsService{

    @Autowired
    OrderItemsRepository orderItemsRepository;

    @Autowired
    OrderService orderService;
    @Override
    public void deleteOrderItems(Long id) {
        Orders order = orderService.fingById(orderItemsRepository.findById(id).getOrderId());
        orderItemsRepository.delete(id);
        if (order.getOrderItems() == null)
            orderService.deleteOrder(order.getOrderId());
    }

    @Override
    public OrderItems getOrderItems(Long id) {
        return orderItemsRepository.findById(id);
    }

    @Override
    public void editOrderItems(OrderItems orderItems) {
        orderItemsRepository.saveAndFlush(orderItems);
    }

    @Override
    public void addOrderItems(OrderItems orderItems) {
        orderItemsRepository.saveAndFlush(orderItems);
    }

    @Override
    public List<OrderItems> findByOrderId(Long orderId) {
        return orderItemsRepository.findByOrderId(orderId);
    }
}

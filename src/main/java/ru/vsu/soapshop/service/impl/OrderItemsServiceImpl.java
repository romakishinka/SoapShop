package ru.vsu.soapshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.soapshop.model.OrderItems;
import ru.vsu.soapshop.repository.OrderItemsRepository;
import ru.vsu.soapshop.service.OrderItemsService;

import java.util.List;

/**
 * Created by Александр on 23.05.2017.
 */
@Service
public class OrderItemsServiceImpl implements OrderItemsService{
    @Autowired
    OrderItemsRepository orderItemsRepository;
    @Override
    public void deleteOrderItems(Long id) {
        orderItemsRepository.delete(id);
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

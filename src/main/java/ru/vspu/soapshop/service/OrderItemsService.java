package ru.vspu.soapshop.service;


import ru.vspu.soapshop.model.OrderItems;


import java.util.List;

/**
 * Created by Roman Kishinka on 20.04.2021.
 */
public interface OrderItemsService {
    void deleteOrderItems(Long id);
    OrderItems getOrderItems(Long id);
    void editOrderItems(OrderItems orderItmes);
    void addOrderItems(OrderItems orderItems);
    List<OrderItems> findByOrderId(Long orderId);
}

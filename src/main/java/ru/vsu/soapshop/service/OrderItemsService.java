package ru.vsu.soapshop.service;


import ru.vsu.soapshop.model.OrderItems;

import javax.persistence.criteria.Order;
import java.util.List;

/**
 * Created by Александр on 23.05.2017.
 */
public interface OrderItemsService {
    void deleteOrderItems(Long id);
    OrderItems getOrderItems(Long id);
    void editOrderItems(OrderItems orderItmes);
    void addOrderItems(OrderItems orderItems);
    List<OrderItems> findByOrderId(Long orderId);
}

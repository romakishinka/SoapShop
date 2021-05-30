package ru.vspu.soapshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vspu.soapshop.model.OrderItems;

import java.util.List;

/**
 * Created by Roman Kishinka on 11.05.2021.
 */
public interface OrderItemsRepository extends JpaRepository<OrderItems,Long> {

    @Query("select o from OrderItems o where o.orderId =:orderId")
    List<OrderItems> findByOrderId(@Param("orderId") Long orderId);

    @Query("select o from OrderItems o where o.id =:itemId")
    OrderItems findById(@Param("itemId") Long itemId);
}

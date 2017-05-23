package ru.vsu.soapshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vsu.soapshop.model.OrderItems;

import java.util.List;

/**
 * Created by Александр on 23.05.2017.
 */
public interface OrderItemsRepository extends JpaRepository<OrderItems,Long> {

    @Query("select o from OrderItems o where o.orderId =:orderId")
    List<OrderItems> findByOrderId(@Param("orderId") Long orderId);

    @Query("select o from OrderItems o where o.id =:itemId")
    OrderItems findById(@Param("itemId") Long itemId);
}

package ru.vspu.soapshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vspu.soapshop.model.Orders;


import java.util.List;

/**
 * Created by Roman Kishinka on 20.05.2021.
 */
public interface OrderRepository extends JpaRepository<Orders,Long> {

    @Query("select o from Orders o where o.userId=:userId")
    List<Orders> findAllUserOrders(@Param("userId")Long userId);

    @Query("select o from Orders o where o.userId=:userId and o.status=:status")
    List<Orders> findUserOrdersByStatus(@Param("userId")Long userId,@Param("status") int status);

    @Query("select o from Orders o where o.orderId=?1 ")
    Orders findById(Long orderId);

}

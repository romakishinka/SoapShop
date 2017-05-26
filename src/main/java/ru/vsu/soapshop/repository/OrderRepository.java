package ru.vsu.soapshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vsu.soapshop.model.Orders;


import java.util.List;

/**
 * Created by Александр on 20.05.2017.
 */
public interface OrderRepository extends JpaRepository<Orders,Long> {

    @Query("select o from Orders o where o.userId=:userId")
    List<Orders> findAllUserOrders(@Param("userId")Long userId);

    @Query("select o from Orders o where o.userId=?1 and o.status=?2")
    List<Orders> findUserOrdersByStatus(Long userId, int status);

    @Query("select o from Orders o where o.orderId=?1 ")
    Orders findById(Long orderId);

}

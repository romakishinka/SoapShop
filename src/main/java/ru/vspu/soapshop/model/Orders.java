package ru.vspu.soapshop.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Roman Kishinka on 20.04.2021.
 */
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "order", fetch= FetchType.EAGER)
    private List<OrderItems> orderItems;

    @ManyToOne
    @JoinColumn(name ="user_id",insertable = false, updatable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getScore(){
        int result=0;
        for (OrderItems item:orderItems) {
            result+=item.getScore();
        }
        return result;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }
}

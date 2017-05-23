package ru.vsu.soapshop.model;

import javax.persistence.*;

/**
 * Created by Александр on 23.05.2017.
 */


@Entity
@Table(name="order_items")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="order_id")
    private Long orderId;

    @Column(name="product_id")
    private Long productId;

    @Column(name="amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name="product_id", insertable = false, updatable = false)
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name ="order_id",insertable = false, updatable = false)
    private Orders order;

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public int getScore(){
        return amount*product.getPrice();
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long product_id) {
        this.productId = product_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package ru.vsu.soapshop.model;

import javax.persistence.*;

/**
 * Created by Александр on 18.05.2017.
 */
@Entity
@Table(name ="order")
public class Order {
    private int itemId;
    private int productId;

    @Id
    @Column(name = "item_id")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

}

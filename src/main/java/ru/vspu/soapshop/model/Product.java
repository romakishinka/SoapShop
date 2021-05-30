package ru.vspu.soapshop.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Roman Kishinka on 20.04.2021.
 */
@Entity
@Table(name ="product")
public class Product {
    private Long productId;
    private String productName;
    private int price;
    private String photo;
    private String description;

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

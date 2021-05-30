package ru.vspu.soapshop.model;

import javax.persistence.*;

/**
 * Created by Roman Kishinka on 20.04.2021.
 */
@Entity
@Table(name="users_location")
public class Location {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="user_id")
    private Long userId;

    @Column(name="contry")
    private String contry;

    @Column(name="city")
    private String city;

    @Column(name="street")
    private String street;

    @Column(name="house_number")
    private String houseNumber;

    @OneToOne
    @JoinColumn(name ="user_id",insertable = false, updatable = false)
    private User user;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}

package ru.vspu.soapshop.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Roman Kishinka on 20.04.2021.
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name= "FIO")
    private String fio;

    @Transient
    private String confirmPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "user", fetch= FetchType.EAGER)
    private List<Orders> orders;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @OneToOne(mappedBy = "user")
    private Location location;

    public Location getLocation() {

        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}

package com.del.demosprint.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
// Annotation pour spécifier le nom de la table correspondante dans la base de
// données
@Table(name = "agencies")
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    // Constructeur par défaut
    public Agence() {
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getManager() {
        return manager;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}

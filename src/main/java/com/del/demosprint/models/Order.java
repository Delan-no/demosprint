package com.del.demosprint.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
// Annotation pour spécifier le nom de la table correspondante dans la base de
// données
@Table(name = "orders")
public class Order {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      private String name;

      @Enumerated(EnumType.STRING)
      private OrderStatus status;

      @Temporal(TemporalType.TIMESTAMP)
      private Date created;

      @Temporal(TemporalType.TIMESTAMP)
      private Date deadline;

      @ManyToOne
      @JoinColumn(name = "agency_id")
      private Agence agence;

      @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
      private Intervention intervention;

      @ManyToOne
      @JoinColumn(name = "expert_id")
      private User expert;

      // Constructeur par défaut
      public Order() {
      }

      // Getters
      public Long getId() {
            return id;
      }

      public String getName() {
            return name;
      }

      public OrderStatus getStatus() {
            return status;
      }

      public Date getCreated() {
            return created;
      }

      public Date getDeadline() {
            return deadline;
      }

      public Agence getAgency() {
            return agence;
      }

      public Intervention getIntervention() {
            return intervention;
      }

      public User getExpert() {
            return expert;
      }

      // Setters
      public void setId(Long id) {
            this.id = id;
      }

      public void setName(String name) {
            this.name = name;
      }

      public void setStatus(OrderStatus status) {
            this.status = status;
      }

      public void setCreated(Date created) {
            this.created = created;
      }

      public void setDeadline(Date deadline) {
            this.deadline = deadline;
      }

      public void setAgency(Agence agence) {
            this.agence = agence;
      }

      public void setIntervention(Intervention intervention) {
            this.intervention = intervention;
      }

      public void setExpert(User expert) {
            this.expert = expert;
      }
}

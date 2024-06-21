package com.del.demosprint.models;

import java.util.List;

// Importations nécessaires pour les annotations de validation et de persistance
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

// Annotation pour indiquer que cette classe est une entité
@Entity
@Table(name = "users")

// Annotations pour l'ID auto-généré
public class User {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @NotBlank(message = "Le nom d'utilisateur ne peut pas être vide")
      @Size(min = 3, max = 50, message = "Le nom d'utilisateur doit comporter entre 3 et 50 caractères")
      private String username;

      @NotBlank(message = "Le mot de passe ne peut pas être vide")
      private String password;

      @Enumerated(EnumType.STRING)
      private UserRole role;

      @NotBlank(message = "Le prénom ne peut pas être vide")
      private String name;

      @NotBlank(message = "Le nom de famille ne peut pas être vide")
      private String lastname;

      @Email(message = "L'email doit être valide")
      private String mail;

      @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Le numéro de téléphone doit être valide")
      private String phonenumber;

      @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true)
      private List<Agence> managedAgencies;

      // Constructeur par défaut
      public User() {
      }

      // Getters
      public Long getId() {
            return id;
      }

      public String getUsername() {
            return username;
      }

      public String getPassword() {
            return password;
      }

      public UserRole getRole() {
            return role;
      }

      public String getName() {
            return name;
      }

      public String getLastName() {
            return lastname;
      }

      public String getMail() {
            return mail;
      }

      public String getPhoneNumber() {
            return phonenumber;
      }

      public List<Agence> getManagedAgencies() {
            return managedAgencies;
      }

      // Setters
      public void setId(Long id) {
            this.id = id;
      }

      public void setUsername(String username) {
            this.username = username;
      }

      public void setPassword(String password) {
            this.password = password;
      }

      public void setRole(UserRole role) {
            this.role = role;
      }

      public void setName(String name) {
            this.name = name;
      }

      public void setLastName(String lastname) {
            this.lastname = lastname;
      }

      public void setMail(String mail) {
            this.mail = mail;
      }

      public void setPhoneNumber(String phonenumber) {
            this.phonenumber = phonenumber;
      }

      public void setManagedAgencies(List<Agence> managedAgencies) {
            this.managedAgencies = managedAgencies;
      }

}

package com.tts.daBlog.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private Long id;

  @Email(message = "Please provide a valid email")
  @NotEmpty(message = "Please provide an email")
  private String email;

  @Length(min = 3, message = "Your username must have at least 3 characters")
  @Length(max = 15, message = "Your username cannot have more than 15 characters")
  @Pattern(regexp = "[^\\s]+", message = "Your username cannot contain spaces")
  private String username;

  @Length(min = 5, message = "Your password must have at least 5 characters")
  private String password;

  @NotEmpty(message = "Please provide your first name")
  private String firstName;

  @NotEmpty(message = "Please provide your last name")
  private String lastName;

  private int active;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

  public User() {
  }

  public User(
      @Email(message = "Please provide a valid email") 
      @NotEmpty(message = "Please provide an email") String email,
      @Length(min = 3, message = "Your username must have at least 3 characters") 
      @Length(max = 15, message = "Your username cannot have more than 15 characters") 
      @Pattern(regexp = "[^\\s]+", message = "Your username cannot contain spaces") 
        String username,
      @Length(min = 5, message = "Your password must have at least 5 characters") 
        String password,
      @NotEmpty(message = "Please provide your first name") String firstName,
      @NotEmpty(message = "Please provide your last name") String lastName,
      int active, LocalDateTime createdAt,
      LocalDateTime updatedAt, Set<Role> roles) {
    this.email = email;
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.active = active;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.roles = roles;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getActive() {
    return active;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setActive(int active) {
    this.active = active;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

}

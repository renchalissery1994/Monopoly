package com.monopoly.gameapi.model;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "REGISTERED_ON", nullable = false)
    private OffsetDateTime registeredOn;

    @Column(name = "LAST_LOGIN")
    private OffsetDateTime lastLogin;

    @Column(name = "DELETED_ON")
    private OffsetDateTime deletedOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public OffsetDateTime getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(OffsetDateTime registeredOn) {
        this.registeredOn = registeredOn;
    }

    public OffsetDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(OffsetDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public OffsetDateTime getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(OffsetDateTime deletedOn) {
        this.deletedOn = deletedOn;
    }
}

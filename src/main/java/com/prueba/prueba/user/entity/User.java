package com.prueba.prueba.user.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;


import java.sql.Timestamp;
import java.util.UUID;


@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "user_name", nullable = false, length = 38, unique = true)
    private String userName;

    @Column(name = "user_person_name", nullable = false, length = 100)
    private String userPersonName;
    @Column(name = "user_person_lastname", nullable = false, length = 100)
    private String userPersonLastname;
    @Column(name = "user_password", nullable = false)
    private String userPassword;
    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPersonName() {
        return userPersonName;
    }

    public void setUserPersonName(String userPersonName) {
        this.userPersonName = userPersonName;
    }

    public String getUserPersonLastname() {
        return userPersonLastname;
    }

    public void setUserPersonLastname(String userPersonLastname) {
        this.userPersonLastname = userPersonLastname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
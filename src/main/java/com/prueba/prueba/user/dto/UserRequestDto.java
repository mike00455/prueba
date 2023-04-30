package com.prueba.prueba.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UserRequestDto {
    @JsonProperty(value = "user_id", access = JsonProperty.Access.READ_ONLY)
    private UUID userId;

    @JsonProperty(value = "user_name")
    private String userName;

    @JsonProperty(value = "user_person_name")
    private String userPersonName;

    @JsonProperty(value = "user_person_lastname")
    private String userPersonLastname;

    @JsonProperty(value = "user_password")
    private String userPassword;

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
}

package com.prueba.prueba.payment_method.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class PaymentMethodRequestDto {

    @JsonProperty(value = "payment_method_id")
    private UUID paymentMethodId;

    @JsonProperty(value = "payment_method_type")
    private String paymentMethodType;

    @JsonProperty(value = "payment_method_card_number")
    private String cardNumber;

    @JsonProperty(value = "user_id")
    private UUID user;

    public UUID getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(UUID paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public UUID getUser() {
        return user;
    }

    public void setUser(UUID user) {
        this.user = user;
    }
}

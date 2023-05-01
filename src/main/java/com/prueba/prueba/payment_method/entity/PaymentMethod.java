package com.prueba.prueba.payment_method.entity;

import com.prueba.prueba.user.entity.User;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "payment_method", schema = "public")
public class PaymentMethod {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "payment_method_id", nullable = false)
    private UUID paymentMethodId;

    @Column(name = "payment_method_type", nullable = false)
    private String paymentMethodType;

    @Column(name = "card_number", length = 16)
    private String cardNumber;

    @Column(name = "payment_method_status", nullable = false)
    private String paymentMethodStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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

    public String getPaymentMethodStatus() {
        return paymentMethodStatus;
    }

    public void setPaymentMethodStatus(String paymentMethodStatus) {
        this.paymentMethodStatus = paymentMethodStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

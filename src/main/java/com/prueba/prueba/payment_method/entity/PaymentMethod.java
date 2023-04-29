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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UUID getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(UUID paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

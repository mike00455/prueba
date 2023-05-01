package com.prueba.prueba.payment_method.repository;

import com.prueba.prueba.payment_method.dto.PaymentMethodResponseDto;
import com.prueba.prueba.payment_method.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, UUID> {

    @Query("SELECT new com.prueba.prueba.payment_method.dto.PaymentMethodResponseDto(pm.paymentMethodId, pm.paymentMethodType, pm.cardNumber) FROM PaymentMethod pm WHERE pm.paymentMethodStatus = 'Activo' AND pm.user.userId = :userId")
    List<PaymentMethodResponseDto> getAllPaymentMethodByUser(UUID userId);

    @Query("SELECT pm FROM PaymentMethod pm WHERE pm.paymentMethodId = :paymentMethodId AND pm.paymentMethodStatus = 'Activo'")
    PaymentMethod getPaymentMethodByPaymentMethodId(UUID paymentMethodId);

}

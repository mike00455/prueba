package com.prueba.prueba.payment_method.service;

import com.prueba.prueba.payment_method.dto.PaymentMethodRequestDto;
import com.prueba.prueba.payment_method.dto.PaymentMethodResponseDto;
import com.prueba.prueba.payment_method.entity.PaymentMethod;
import com.prueba.prueba.payment_method.repository.PaymentMethodRepository;
import com.prueba.prueba.user.entity.User;
import com.prueba.prueba.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaymentMethodService {
    private final ModelMapper modelMapper;
    private final PaymentMethodRepository paymentMethodRepository;
    private final UserRepository userRepository;

    public PaymentMethodService(ModelMapper modelMapper, PaymentMethodRepository paymentMethodRepository, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.paymentMethodRepository = paymentMethodRepository;
        this.userRepository = userRepository;
    }

    public Map<String, String> savePaymentMethod(PaymentMethodRequestDto paymentMethodRequestDto){
        Map<String, String> map = new HashMap<>();
        User user = userRepository.getByUserId(paymentMethodRequestDto.getUser());
        PaymentMethod paymentMethod = modelMapper.map(paymentMethodRequestDto, PaymentMethod.class);
        paymentMethod.setPaymentMethodStatus("Activo");
        paymentMethod.setUser(user);
        paymentMethodRepository.save(paymentMethod);
        map.put("message", "Metodo de pago agrado exitosamente");
        return map;
    }

    public List<PaymentMethodResponseDto> getAllPaymentMethodByUser(UUID userId) {
        return paymentMethodRepository.getAllPaymentMethodByUser(userId);
    }

    public Map<String, String> updatePaymentMethodByUser(PaymentMethodRequestDto paymentMethodRequestDto){
        Map<String, String> map = new HashMap<>();
        UUID paymentMethodId = paymentMethodRequestDto.getPaymentMethodId();
        PaymentMethod paymentMethod = paymentMethodRepository.getPaymentMethodByPaymentMethodId(paymentMethodId);
        paymentMethod.setPaymentMethodType(paymentMethodRequestDto.getPaymentMethodType());
        paymentMethod.setCardNumber(paymentMethodRequestDto.getCardNumber());
        paymentMethodRepository.save(paymentMethod);
        map.put("message", "metodo de pago actualizado exitosamente");
        return map;
    }

    public Map<String, String> deletePaymentMethod(UUID paymentMethodId){
        Map<String, String> map = new HashMap<>();
        PaymentMethod paymentMethod = paymentMethodRepository.getPaymentMethodByPaymentMethodId(paymentMethodId);
        paymentMethod.setPaymentMethodStatus("Eliminado");
        paymentMethodRepository.save(paymentMethod);
        map.put("message", "metodo de pago eliminado");
        return map;
    }
}

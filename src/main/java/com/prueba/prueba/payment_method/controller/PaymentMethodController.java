package com.prueba.prueba.payment_method.controller;

import com.prueba.prueba.payment_method.dto.PaymentMethodRequestDto;
import com.prueba.prueba.payment_method.dto.PaymentMethodResponseDto;
import com.prueba.prueba.payment_method.service.PaymentMethodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/payment_method")
public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;

    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> savePaymentMethod(@RequestBody PaymentMethodRequestDto paymentMethodRequestDto){
        return new ResponseEntity<>(paymentMethodService.savePaymentMethod(paymentMethodRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/get_payment_method/{id}")
    public ResponseEntity<List<PaymentMethodResponseDto>> getAllPaymentMethodByUser(@PathVariable("id")UUID userId){
        return new ResponseEntity<>(paymentMethodService.getAllPaymentMethodByUser(userId), HttpStatus.OK);
    }

    @PostMapping("/update_payment_method")
    public ResponseEntity<Map<String, String>> updatePaymentMethodByUser(@RequestBody PaymentMethodRequestDto paymentMethodRequestDto){
        return new ResponseEntity<>(paymentMethodService.updatePaymentMethodByUser(paymentMethodRequestDto), HttpStatus.OK);
    }

    @GetMapping("/delete_payment_method/{id}")
    public ResponseEntity<Map<String, String>> deletePaymentMethod(@PathVariable("id")UUID paymentMethodId){
        return new ResponseEntity<>(paymentMethodService.deletePaymentMethod(paymentMethodId), HttpStatus.OK);
    }
}

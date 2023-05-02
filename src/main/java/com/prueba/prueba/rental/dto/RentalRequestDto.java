package com.prueba.prueba.rental.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.time.LocalDateTime;
import java.util.UUID;

public class RentalRequestDto {
    @JsonProperty(value = "rental_id")
    private UUID rentalId;
    @JsonProperty(value = "start_date")
    private LocalDateTime startDate;
    @JsonProperty(value = "rental_status")
    private String rentalStatus;
    @JsonProperty(value = "user_id")
    private UUID userId;
    @JsonProperty(value = "vehicle_id")
    private UUID vehicleId;
    @JsonProperty(value = "payment_method_id")
    private UUID paymentMethodId;

    public UUID getRentalId() {
        return rentalId;
    }

    public void setRentalId(UUID rentalId) {
        this.rentalId = rentalId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public String getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(UUID vehicleId) {
        this.vehicleId = vehicleId;
    }

    public UUID getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(UUID paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
}

package com.prueba.prueba.rental.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UpdateRentalStatusDto {
    @JsonProperty(value = "renta_id")
    private UUID rentalId;

    @JsonProperty(value = "rental_status")
    private String rentalStatus;

    public UUID getRentalId() {
        return rentalId;
    }

    public void setRentalId(UUID rentalId) {
        this.rentalId = rentalId;
    }

    public String getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }
}

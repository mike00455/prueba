package com.prueba.prueba.vehicle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class VehicleResponseDto {
    @JsonProperty(value = "vehicle_id", access = JsonProperty.Access.READ_ONLY)
    private UUID vehicleId;

    @JsonProperty(value = "vehicle_make")
    private String vehicleMake;

    @JsonProperty(value = "vehicle_model")
    private String vehicleModel;

    @JsonProperty(value = "vehicle_year")
    private String vehicleYear;

    @JsonProperty(value = "vehicle_registration_number")
    private String vehicleRegistrationNumber;

    @JsonProperty(value = "price_hour")
    private Double priceHour;

    @JsonProperty(value = "vehicle_status")
    private String vehicleStatus;

    public UUID getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(UUID vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(String vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public Double getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(Double priceHour) {
        this.priceHour = priceHour;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}

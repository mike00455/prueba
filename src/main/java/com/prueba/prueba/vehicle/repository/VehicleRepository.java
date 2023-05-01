package com.prueba.prueba.vehicle.repository;

import com.prueba.prueba.vehicle.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
    Boolean existsByVehicleRegistrationNumber(String vehicleRegistrationNumber);

    List<Vehicle> findAll();

    Vehicle getByVehicleId(UUID vehicleId);
}

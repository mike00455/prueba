package com.prueba.prueba.vehicle.controller;


import com.prueba.prueba.user.dto.UserRequestDto;
import com.prueba.prueba.user.dto.UserResponseDto;
import com.prueba.prueba.vehicle.dto.VehicleRequestDto;
import com.prueba.prueba.vehicle.dto.VehicleResponseDto;
import com.prueba.prueba.vehicle.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> saveVehicle(@RequestBody VehicleRequestDto vehicleRequestDto){
        return new ResponseEntity<>(vehicleService.saveVehicle(vehicleRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/get_all")
    public ResponseEntity<?> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDto> getVehicleById(@PathVariable("id") UUID vehicleId){
        return new ResponseEntity<>(vehicleService.getVehicleById(vehicleId), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Map<String, String>> updateVehicle(@RequestBody VehicleRequestDto vehicleRequestDto, @PathVariable("id") UUID vehicleId){
        return new ResponseEntity<>(vehicleService.updateVehicle(vehicleId, vehicleRequestDto), HttpStatus.OK);
    }
}

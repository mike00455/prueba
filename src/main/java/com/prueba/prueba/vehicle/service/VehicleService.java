package com.prueba.prueba.vehicle.service;

import com.prueba.prueba.vehicle.dto.VehicleRequestDto;
import com.prueba.prueba.vehicle.dto.VehicleResponseDto;
import com.prueba.prueba.vehicle.entity.Vehicle;
import com.prueba.prueba.vehicle.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VehicleService {

    private final ModelMapper modelMapper;
    private final VehicleRepository vehicleRepository;

    public VehicleService(ModelMapper modelMapper, VehicleRepository vehicleRepository) {
        this.modelMapper = modelMapper;
        this.vehicleRepository = vehicleRepository;
    }

    public Map<String, String> saveVehicle(VehicleRequestDto vehicleRequestDto){
        Map<String, String> map = new HashMap<>();

        /*** Convertimos el Dto en entidad ***/
        Vehicle vehicle = modelMapper.map(vehicleRequestDto, Vehicle.class);
        vehicle.setVehicleStatus("Disponible");

        /*** Verificamos si el vehiculo existe ***/
        if (vehicleRepository.existsByVehicleRegistrationNumber(vehicle.getVehicleRegistrationNumber())){
            map.put("message", "No se puede agregar porque ya el número de placa esta en uso");
            return map;
        }

        vehicleRepository.save(vehicle);
        map.put("message", "Vehiculo creado con exito");
        return map;
    }

    public ResponseEntity<?> getAllVehicles(){
        /*** Listamos usuarios activos ***/
        List<Vehicle> vehicles = vehicleRepository.findAll();

        /*** almacen de vehiculos como dto ***/
        List<VehicleResponseDto> vehicleResponseDto = new ArrayList<>();

        /*** Convertimos la entidad en dto ***/
        for (Vehicle vehicle : vehicles){
            vehicleResponseDto.add(convertToDto(vehicle));
        }

        /*** si la lista de vehiculos es vacia retornamos mensaje ***/
        if (vehicles.isEmpty()){
            Map<String, String> map = new HashMap<>();
            map.put("message", "No hay vehiculos registrados");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(vehicleResponseDto, HttpStatus.OK);
    }

    public VehicleResponseDto getVehicleById(UUID vehicleId){
        return modelMapper.map(vehicleRepository.getByVehicleId(vehicleId), VehicleResponseDto.class);
    }

    /*** Metodo para convertir Vehicle a DTO***/
    private VehicleResponseDto convertToDto(Vehicle vehicle){
        return modelMapper.map(vehicle, VehicleResponseDto.class);
    }

    public Map<String, String> updateVehicle(UUID vehicleId, VehicleRequestDto vehicleRequestDto){
        Map<String, String> map = new HashMap<>();
        Vehicle vehicle = vehicleRepository.getByVehicleId(vehicleId);
        vehicle.setVehicleMake(vehicleRequestDto.getVehicleMake());
        vehicle.setVehicleModel(vehicleRequestDto.getVehicleModel());
        vehicle.setVehicleYear(vehicleRequestDto.getVehicleYear());
        vehicle.setVehicleRegistrationNumber(vehicleRequestDto.getVehicleRegistrationNumber());
        vehicle.setPriceHour(vehicleRequestDto.getPriceHour());
        vehicleRepository.save(vehicle);
        map.put("message", "Vehiculo actualizado con exito");
        return map;
    }
}

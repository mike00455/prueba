package com.prueba.prueba.rental.service;

import com.prueba.prueba.payment_method.entity.PaymentMethod;
import com.prueba.prueba.payment_method.repository.PaymentMethodRepository;
import com.prueba.prueba.rental.Repository.RentalRepository;
import com.prueba.prueba.rental.dto.RentalRequestDto;
import com.prueba.prueba.rental.dto.UpdateRentalStatusDto;
import com.prueba.prueba.rental.entity.Rental;
import com.prueba.prueba.user.entity.User;
import com.prueba.prueba.user.repository.UserRepository;
import com.prueba.prueba.vehicle.entity.Vehicle;
import com.prueba.prueba.vehicle.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final VehicleRepository vehicleRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public RentalService(RentalRepository rentalRepository, VehicleRepository vehicleRepository, PaymentMethodRepository paymentMethodRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.rentalRepository = rentalRepository;
        this.vehicleRepository = vehicleRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public Map<String, String> saveRental(RentalRequestDto rentalRequestDto){
        HashMap<String, String> map = new HashMap<>();
        Vehicle vehicle = vehicleRepository.getByVehicleId(rentalRequestDto.getVehicleId());
        PaymentMethod paymentMethod = paymentMethodRepository.getPaymentMethodByPaymentMethodId(rentalRequestDto.getPaymentMethodId());
        User user = userRepository.getByUserId(rentalRequestDto.getUserId());

        if (vehicle.getVehicleStatus().equals("Ocupado")){
            map.put("message", "El Vehiculo no esta disponible");
            return map;
        }

        if (paymentMethod.getPaymentMethodStatus().equals("Eliminado")){
            map.put("message", "Por favor usa otro metodo de pago");
            return map;
        }

        if (!user.getUserActive()){
            map.put("message", "El usuario no existe");
            return map;
        }

        Rental rental = modelMapper.map(rentalRequestDto, Rental.class);
        rental.setVehicle(vehicle);
        rental.setPaymentMethod(paymentMethod);
        rental.setUser(user);

        rentalRepository.save(rental);
        map.put("message", "Alquiler creado");
        return map;
    }

    public List<Rental> getAllRentals(){
        return rentalRepository.findAll();
    }

    public Map<String, String> updateStatus(UpdateRentalStatusDto updateRentalStatusDto){
        Map<String, String> map = new HashMap<>();
        UUID rentalId = updateRentalStatusDto.getRentalId();
        Rental rental= rentalRepository.getReferenceById(rentalId);
        if(updateRentalStatusDto.getRentalStatus().equals("Cerrado")){
            rental.setEndDate(LocalDateTime.now());
        }
        rental.setRentalStatus(updateRentalStatusDto.getRentalStatus());
        rentalRepository.save(rental);
        map.put("message", "Estado actualizado");
        return map;
    }
}

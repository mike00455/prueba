package com.prueba.prueba.rental.controller;


import com.prueba.prueba.rental.dto.RentalRequestDto;
import com.prueba.prueba.rental.dto.UpdateRentalStatusDto;
import com.prueba.prueba.rental.entity.Rental;
import com.prueba.prueba.rental.service.RentalService;
import com.prueba.prueba.user.dto.UserRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rental")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> saveRental(@RequestBody RentalRequestDto rentalRequestDto){
        return new ResponseEntity<>(rentalService.saveRental(rentalRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<Rental>> getAllRentals(){
        return new ResponseEntity<>(rentalService.getAllRentals(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, String>> updateStatus(@RequestBody UpdateRentalStatusDto updateRentalStatusDto){
        return new ResponseEntity<>(rentalService.updateStatus(updateRentalStatusDto), HttpStatus.OK);
    }
}

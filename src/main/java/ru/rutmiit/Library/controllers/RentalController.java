package ru.rutmiit.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.Library.dtos.RentalDto;
import ru.rutmiit.Library.services.RentalService;

import java.util.List;

@RestController
public class RentalController {
    @Autowired
    private RentalService rentalService;


    public RentalController() {
    }

    @GetMapping("/rentals")
    Iterable<RentalDto> all() {
        return this.rentalService.getAllRentals();
    }

    @GetMapping("/rentals/{id}")
    RentalDto one(@PathVariable("id") Integer rentalId) throws Throwable {
        return (RentalDto)this.rentalService.findRental(rentalId)
                .orElseThrow(() -> new RentalNotFoundException("Could not find rental with id: " + rentalId));
    }

    @PostMapping("/rentals")
    RentalDto newRental(@RequestBody RentalDto newRental) {
        return this.rentalService.addRental(newRental);
    }

    @DeleteMapping("/rentals/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable Integer rentalId) {
        rentalService.deleteRental(rentalId);
        return ResponseEntity.noContent().build();
    }
}

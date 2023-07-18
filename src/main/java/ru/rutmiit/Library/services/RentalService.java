package ru.rutmiit.Library.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.Library.dtos.RentalDto;
import ru.rutmiit.Library.entities.RentalBook;
import ru.rutmiit.Library.repositories.RentalRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public RentalService() {
    }

    public List<RentalDto> getAllRentals() {
        List<RentalBook> rentals = rentalRepository.findAll();
        return rentals.stream()
                .map(rental -> modelMapper.map(rental, RentalDto.class))
                .collect(Collectors.toList());
    }

    public Optional<RentalBook> getRentalById(Integer rentalId) {
        return rentalRepository.findById(rentalId);
    }

    public RentalBook createRental(RentalBook rentalBook) {
        return rentalRepository.save(rentalBook);
    }

    public RentalBook updateRental(Integer rentalId, RentalBook updatedRental) {
        Optional<RentalBook> existingRentalOptional = rentalRepository.findById(rentalId);
        if (existingRentalOptional.isPresent()) {
            RentalBook existingRental = existingRentalOptional.get();
            existingRental.setRentalDate(updatedRental.getRentalDate());
            existingRental.setBook(updatedRental.getBook());
            existingRental.setReader(updatedRental.getReader());
            return rentalRepository.save(existingRental);
        } else {
            throw new IllegalArgumentException("Rental with ID " + rentalId + " not found.");
        }
    }

    public void deleteRental(Integer rentalId) {
        rentalRepository.deleteById(rentalId);
    }

    public Optional<RentalDto> findRental(Integer rentalId) {
        return Optional.ofNullable((RentalDto)this.modelMapper.map(this.rentalRepository.findById(rentalId), RentalDto.class));
    }

    public RentalDto addRental(RentalDto newRental) {
        RentalBook ren = (RentalBook) this.modelMapper.map(newRental, RentalBook.class);
        return (RentalDto) this.modelMapper.map(this.rentalRepository.save(ren), RentalDto.class);
    }
}

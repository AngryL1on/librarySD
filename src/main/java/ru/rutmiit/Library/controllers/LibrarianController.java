package ru.rutmiit.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.Library.dtos.LibrarianDto;
import ru.rutmiit.Library.services.LibrarianService;

import java.util.List;


@RestController
public class LibrarianController {
    @Autowired
    private LibrarianService librarianService;

    public LibrarianController(){
    }

    @GetMapping("/librarians")
    Iterable<LibrarianDto> all() {
        return this.librarianService.getAll();
    }

    @GetMapping("/librarians/{id}")
    LibrarianDto one(@PathVariable Integer id) throws Throwable {
        return (LibrarianDto)this.librarianService.findLibrarian(id)
                .orElseThrow(() -> new LibrarianNotFoundException("Could not find librarian with id: " + id));
    }

    @GetMapping("/librarians/name/{name}")
    List<LibrarianDto> librariansByName(@PathVariable String name) {
        List<LibrarianDto> librarians = librarianService.findLibrariansByName(name);
        if (librarians.isEmpty()) {
            throw new LibrarianNotFoundException("Could not find librarians with name: " + name);
        }
        return librarians;
    }


    @GetMapping("/librarians/email/{email}")
    LibrarianDto librariansByEmail(@PathVariable("email") String email) throws Throwable {
        return (LibrarianDto) this.librarianService.findLibrarianByEmail(email)
                .orElseThrow(() -> new LibrarianNotFoundException("Could not find librarian with email: " + email));
    }

    @GetMapping("/librarians/address/{address}")
    LibrarianDto oneByAddress(@PathVariable String address) throws Throwable {
        return (LibrarianDto) this.librarianService.findLibrarianByAddress(address)
                .orElseThrow(() -> new LibrarianNotFoundException("Could not find librarian with address: " + address));
    }

    @GetMapping("/librarians/phone/{phoneNumber}")
    LibrarianDto oneByphoneNumber(@PathVariable String phoneNumber) throws Throwable {
        return (LibrarianDto) this.librarianService.findLibrarianByphoneNumber(phoneNumber)
                .orElseThrow(() -> new LibrarianNotFoundException("Could not find librarian with phoneNumber: " + phoneNumber));
    }

    @PostMapping("/librarians")
    LibrarianDto newLibrarian(@RequestBody LibrarianDto newLibrarian) {
        return this.librarianService.addLibrarian(newLibrarian);
    }

    @DeleteMapping("/librarians/{librarianId}")
    public ResponseEntity<Void> deleteLibrarian(@PathVariable Integer librarianId) {
        librarianService.deleteLibrarian(librarianId);
        return ResponseEntity.noContent().build();
    }

}
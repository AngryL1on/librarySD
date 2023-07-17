package ru.rutmiit.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.Library.dtos.LibrarianDto;
import ru.rutmiit.Library.services.LibrarianService;


import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/librarians")
public class LibrarianController {
    @Autowired
    private LibrarianService librarianService;

    public LibrarianController(){}

    @GetMapping("/librarians")
    Iterable<LibrarianDto> all() {
        return this.librarianService.getAll();
    }

    @GetMapping("/librarians/{id}")
    LibrarianDto one(@PathVariable Integer librarianId) throws Throwable {
        return (LibrarianDto)this.librarianService.findLibrarian(librarianId).orElseThrow(() -> {
            return new LibrarianNotFoundException("Could not find librarian with id: " + librarianId);
        });
    }

    @GetMapping("/librarians/name/{name}")
    List<LibrarianDto> librariansByName(@RequestParam("name") String name) throws Throwable {
        return Collections.singletonList((LibrarianDto) this.librarianService.findLibrarianByName(name).orElseThrow(() -> {
            return new LibrarianNotFoundException("Could not find librarian with title: " + name);
        }));
    }

    @GetMapping("/librarians/email/{email}")
    List<LibrarianDto> librariansByEmail(@RequestParam("email") String email) throws Throwable {
        return Collections.singletonList((LibrarianDto) this.librarianService.findLibrarianByEmail(email).orElseThrow(() -> {
            return new LibrarianNotFoundException("Could not find librarian with email: " + email);
        }));
    }

    @GetMapping("/librarians/address/{address}")
    LibrarianDto oneByAddress(@PathVariable String address) throws Throwable {
        return (LibrarianDto) this.librarianService.findLibrarianByAddress(address)
                .orElseThrow(() -> new LibrarianNotFoundException("Could not find librarian with address: " + address));
    }

    @GetMapping("/librarians/phoneNumber/{phoneNumber}")
    LibrarianDto oneByPhone(@PathVariable String phoneNumber) throws Throwable {
        return (LibrarianDto) this.librarianService.findLibrarianByPhone(phoneNumber)
                .orElseThrow(() -> new LibrarianNotFoundException("Could not find librarian with phoneNumber: " + phoneNumber));
    }

    @PostMapping({"/librarians"})
    LibrarianDto newLibrarian(@RequestBody LibrarianDto newLibrarian) {
        return this.librarianService.addLibrarian(newLibrarian);
    }

    @DeleteMapping("/{librarianId}")
    public ResponseEntity<Void> deleteLibrarian(@PathVariable Integer librarianId) {
        librarianService.deleteLibrarian(librarianId);
        return ResponseEntity.noContent().build();
    }

}
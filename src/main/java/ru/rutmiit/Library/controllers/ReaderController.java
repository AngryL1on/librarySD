package ru.rutmiit.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.Library.dtos.ReaderDto;
import ru.rutmiit.Library.entities.Reader;
import ru.rutmiit.Library.services.ReaderService;

import java.util.List;

@RestController
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    public ReaderController(){}

    @GetMapping("/readers")
    Iterable<ReaderDto> all() {
        return this.readerService.getAll();
    }

    @GetMapping("/readers/{id}")
    ReaderDto one(@PathVariable Integer id) throws Throwable {
        return (ReaderDto)this.readerService.findReader(id)
                .orElseThrow(() -> new ReaderNotFoundException("Could not find librarian with id: " + id));
    }

    @GetMapping("/readers/name/{name}")
    List<Reader> readersByName(@PathVariable String name) {
        List<Reader> readers = readerService.findReadersByName(name);
        if (readers.isEmpty()) {
            throw new LibrarianNotFoundException("Could not find librarians with name: " + name);
        }
        return readers;
    }

    @GetMapping("/readers/email/{email}")
    ReaderDto readersByEmail(@PathVariable("email") String email) throws Throwable {
        return (ReaderDto) this.readerService.findReaderByEmail(email)
                .orElseThrow(() -> new ReaderNotFoundException("Could not find librarian with email: " + email));
    }

    @GetMapping("/readers/address/{address}")
    ReaderDto oneByAddress(@PathVariable String address) throws Throwable {
        return (ReaderDto) this.readerService.findReaderByAddress(address)
                .orElseThrow(() -> new ReaderNotFoundException("Could not find librarian with address: " + address));
    }

    @GetMapping("/readers/phone/{phoneNumber}")
    ReaderDto oneByphoneNumber(@PathVariable String phoneNumber) throws Throwable {
        return (ReaderDto) this.readerService.findReaderByphoneNumber(phoneNumber)
                .orElseThrow(() -> new ReaderNotFoundException("Could not find librarian with phoneNumber: " + phoneNumber));
    }

    @PostMapping({"/readers"})
    ReaderDto newReader(@RequestBody ReaderDto newReader) {
        return this.readerService.addReader(newReader);
    }

    @DeleteMapping("/readers/{readerId}")
    public ResponseEntity<Void> deleteReader(@PathVariable Long readerId) {
        readerService.deleteReader(readerId);
        return ResponseEntity.noContent().build();
    }
}


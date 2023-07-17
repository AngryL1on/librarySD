package ru.rutmiit.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.Library.dtos.BookDto;
import ru.rutmiit.Library.dtos.ReaderDto;
import ru.rutmiit.Library.entities.Reader;
import ru.rutmiit.Library.services.BookService;
import ru.rutmiit.Library.services.ReaderService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/readers")
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    public ReaderController(){}

    @GetMapping("/readers")
    Iterable<ReaderDto> all() {
        return this.readerService.getAll();
    }

    @GetMapping("/readers/{id}")
    ReaderDto one(@PathVariable Integer readerId) throws Throwable {
        return (ReaderDto)this.readerService.findReader(readerId).orElseThrow(() -> {
            return new ReaderNotFoundException("Could not find reader with id: " + readerId);
        });
    }

    @GetMapping("/readers/name/{name}")
    List<ReaderDto> readersByName(@RequestParam("name") String name) throws Throwable {
        return Collections.singletonList((ReaderDto) this.readerService.findReaderByName(name).orElseThrow(() -> {
            return new ReaderNotFoundException("Could not find reader with title: " + name);
        }));
    }

    @GetMapping("/readers/email/{email}")
    List<ReaderDto> readersByEmail(@RequestParam("email") String email) throws Throwable {
        return Collections.singletonList((ReaderDto) this.readerService.findReaderByEmail(email).orElseThrow(() -> {
            return new ReaderNotFoundException("Could not find reader with email: " + email);
        }));
    }

    @GetMapping("/readers/address/{address}")
    ReaderDto oneByAddress(@PathVariable String address) throws Throwable {
        return (ReaderDto) this.readerService.findReaderByAddress(address)
                .orElseThrow(() -> new ReaderNotFoundException("Could not find reader with address: " + address));
    }

    @GetMapping("/readers/phoneNumber/{phoneNumber}")
    ReaderDto oneByPhone(@PathVariable String phoneNumber) throws Throwable {
        return (ReaderDto) this.readerService.findReaderByPhone(phoneNumber)
                .orElseThrow(() -> new ReaderNotFoundException("Could not find reader with phoneNumber: " + phoneNumber));
    }

    @PostMapping({"/readers"})
    ReaderDto newReader(@RequestBody ReaderDto newReader) {
        return this.readerService.addReader(newReader);
    }

    @DeleteMapping("/{readerId}")
    public ResponseEntity<Void> deleteReader(@PathVariable Long readerId) {
        readerService.deleteReader(readerId);
        return ResponseEntity.noContent().build();
    }

}


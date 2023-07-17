package ru.rutmiit.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.Library.dtos.BookDto;
import ru.rutmiit.Library.entities.Book;
import ru.rutmiit.Library.services.BookService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    public BookController() {
    }

    @GetMapping("/books")
    Iterable<BookDto> all() {
        return this.bookService.getAll();
    }

    @GetMapping("/books/{id}")
    BookDto one(@PathVariable Integer bookId) throws Throwable {
        return (BookDto)this.bookService.findBook(bookId).orElseThrow(() -> {
            return new BookNotFoundException("Could not find book with id: " + bookId);
        });
    }

    @GetMapping("/books/title/{title}")
    List<BookDto> booksByTitle(@RequestParam("title") String title) throws Throwable {
        return Collections.singletonList((BookDto) this.bookService.findBookByTitle(title).orElseThrow(() -> {
            return new BookNotFoundException("Could not find book with title: " + title);
        }));
    }

    @GetMapping("/books/autor/{autor}")
    List<BookDto> booksByAuthor(@RequestParam("author") String author) throws Throwable {
        return Collections.singletonList((BookDto) this.bookService.findBooksByAuthor(author).orElseThrow(() -> {
            return new BookNotFoundException("Could not find book with author: " + author);
        }));
    }

    @GetMapping("/books/publicationyear/{publicationYear}")
    BookDto oneByPublicationYear(@PathVariable Integer publicationYear) throws Throwable {
        return (BookDto) this.bookService.findBookByPublicationYear(publicationYear)
                .orElseThrow(() -> new BookNotFoundException("Could not find book with publication year: " + publicationYear));
    }

    @GetMapping("/books/genre/{genre}")
    BookDto oneByGenre(@PathVariable String genre) throws Throwable {
        return (BookDto) this.bookService.findBookByGenre(genre)
                .orElseThrow(() -> new BookNotFoundException("Could not find book with genre: " + genre));
    }

    @PostMapping({"/books"})
    BookDto newBook(@RequestBody BookDto newBook) {
        return this.bookService.addBook(newBook);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }
}

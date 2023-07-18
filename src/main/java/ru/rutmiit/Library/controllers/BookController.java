package ru.rutmiit.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.Library.dtos.BookDto;
import ru.rutmiit.Library.services.BookService;

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
    BookDto one(@PathVariable Integer id) throws Throwable {
        return (BookDto) this.bookService.findBook(id)
                .orElseThrow(() -> new BookNotFoundException("Could not find book with id: " + id));
    }

    @GetMapping("/books/title/{title}")
    BookDto booksByTitle(@PathVariable("title") String title) throws Throwable {
        return (BookDto) this.bookService.findBookByTitle(title)
                .orElseThrow(() -> new BookNotFoundException("Could not find book with title: " + title));
    }


    @GetMapping("/books/author/{author}")
    BookDto booksByAuthor(@PathVariable("author") String author) throws Throwable {
        return (BookDto) this.bookService.findBooksByAuthor(author)
                .orElseThrow(() -> new BookNotFoundException("Could not find book with author: " + author));
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

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }
}

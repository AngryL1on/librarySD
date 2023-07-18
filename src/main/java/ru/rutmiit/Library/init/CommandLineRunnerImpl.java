package ru.rutmiit.Library.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.rutmiit.Library.dtos.BookDto;
import ru.rutmiit.Library.dtos.LibrarianDto;
import ru.rutmiit.Library.dtos.ReaderDto;
import ru.rutmiit.Library.entities.Reader;
import ru.rutmiit.Library.services.BookService;
import ru.rutmiit.Library.services.LibrarianService;

import java.util.List;
import java.util.Optional;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private BookService bookService;
    @Autowired
    private LibrarianService librarianService;

    public CommandLineRunnerImpl() {

    }

    public void run(String... args) throws Exception {
        this.seedData();
    }

    private void seedData() {
        BookDto b1 = new BookDto(1, "The Great Gatsby", "F. Scott Fitzgerald", 1925, "Classic");
        BookDto b2 = new BookDto(2, "To Kill a Mockingbird", "Harper Lee", 1960, "Fiction");
        this.bookService.addBook(b1); // Сохранение книги b1 в базе данных
        this.bookService.addBook(b2); // Сохранение книги b2 в базе данных
        this.printBookById(1);
    }

    private void printBookById(int id) {
        Optional<BookDto> book = this.bookService.findBook(id);
        book.ifPresent(System.out::println);
    }
}

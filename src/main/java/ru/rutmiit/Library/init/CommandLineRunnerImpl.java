package ru.rutmiit.Library.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.rutmiit.Library.dtos.BookDto;
import ru.rutmiit.Library.services.BookService;

import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Autowired
    private BookService bookService;

    public CommandLineRunnerImpl() {

    }

    public void run(String... args) throws Exception {
        this.seedData();
    }

    private void seedData() {
        BookDto b1 = new BookDto(0, "The Great Gatsby", "F. Scott Fitzgerald", "1925", "Classic");
        BookDto b2 = new BookDto(1, "To Kill a Mockingbird", "Harper Lee", "1960", "Fiction");
        this.printAllBooksById(1);

    }

    private void printAllBooksById(int id) {
        List var10000 = this.bookService.findBook(id);
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
    }

}

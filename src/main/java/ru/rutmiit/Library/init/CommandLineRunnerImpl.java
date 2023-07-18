package ru.rutmiit.Library.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.rutmiit.Library.dtos.*;
import ru.rutmiit.Library.entities.Librarian;
import ru.rutmiit.Library.entities.Reader;
import ru.rutmiit.Library.entities.Review;
import ru.rutmiit.Library.services.BookService;
import ru.rutmiit.Library.services.LibrarianService;
import ru.rutmiit.Library.services.ReaderService;
import ru.rutmiit.Library.services.ReviewService;

import java.util.List;
import java.util.Optional;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private BookService bookService;
    @Autowired
    private ReaderService readerService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private LibrarianService librarianService;


    public CommandLineRunnerImpl() {

    }

    public void run(String... args) throws Exception {
        this.seedData();
    }

    private void seedData() {
        LibrarianDto l1= new LibrarianDto(1,"Linda","lindalibrarian@gmail.com","Scary str, 13", "4986532");
        this.librarianService.addLibrarian(l1);
        BookDto b1 = new BookDto(1, "The Great Gatsby", "F. Scott Fitzgerald", 1925, "Classic");
        BookDto b2 = new BookDto(2, "To Kill a Mockingbird", "Harper Lee", 1960, "Fiction");
        ReaderDto r1 = new ReaderDto(1,"Ithan","readerIt@gmail.com", "None str, 0","4657890", l1);
        ReaderDto r2 = new ReaderDto(2,"Rithan","readerIt1@gmail.com", "None str, 1","4657891", l1);
        this.bookService.addBook(b1); // Сохранение книги b1 в базе данных
        this.bookService.addBook(b2); // Сохранение книги b2 в базе данных
        this.readerService.addReader(r1);
        this.readerService.addReader(r2);
        ReviewDto review= new ReviewDto(1,r1,b1, "This book is amazing");
        ReviewDto review2= new ReviewDto(2,r1,b2, "This book is amazing");
        this.reviewService.addReview(review);
        this.reviewService.addReview(review2);
        this.printBookById(1);
        printfindByReader(1);
        printfindByLibrarian(1);

    }

    private void printBookById(int id) {
        Optional<BookDto> book = this.bookService.findBook(id);
        book.ifPresent(System.out::println);
    }

    private void printfindByReader(int id) {
        reviewService
                .findByReader(id)
                .forEach(System.out::println);
    }

    private void printfindByLibrarian(int id) {
        readerService
                .findByLibrarian(id)
                .forEach(System.out::println);
    }

}

package ru.rutmiit.Library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.Library.entities.Book;
import ru.rutmiit.Library.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long bookId, Book updatedBook) {
        Optional<Book> existingBookOptional = bookRepository.findById(bookId);
        if (existingBookOptional.isPresent()) {
            Book existingBook = existingBookOptional.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPublicationYear(updatedBook.getPublicationYear());
            existingBook.setGenre(updatedBook.getGenre());
            return bookRepository.save(existingBook);
        } else {
            throw new IllegalArgumentException("Book with ID " + bookId + " not found.");
        }
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}

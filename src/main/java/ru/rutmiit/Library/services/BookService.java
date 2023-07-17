package ru.rutmiit.Library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.Library.dtos.BookDto;
import ru.rutmiit.Library.entities.Book;
import ru.rutmiit.Library.repositories.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public BookService() {
    }

    public List<BookDto> getAll() {
        return (List)this.bookRepository.findAll().stream().map((s) -> {
            return (BookDto)this.modelMapper.map(s, BookDto.class);
        }).collect(Collectors.toList());
    }

    public Optional<Book> getBookById(Integer bookId) {
        return bookRepository.findById(bookId);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Integer bookId, Book updatedBook) {
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

    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }

    public BookDto addBook(BookDto newBook) {
        Book b = (Book)this.modelMapper.map(newBook, Book.class);
        return (BookDto)this.modelMapper.map(this.bookRepository.save(b), BookDto.class);
    }

    public Optional<BookDto> findBook(Integer bookId) {
        return Optional.ofNullable((BookDto)this.modelMapper.map(this.bookRepository.findById(bookId), BookDto.class));
    }

    public Optional<BookDto> findBookByTitle(String title) {
        return Optional.ofNullable((BookDto) this.modelMapper.map(this.bookRepository.findByTitle(title), BookDto.class));
    }

    public Optional<BookDto> findBooksByAuthor(String author) {
        return Optional.ofNullable((BookDto) this.modelMapper.map(this.bookRepository.findByAutor(author), BookDto.class));
    }

    public Optional<Object> findBookByPublicationYear(Integer publicationYear) {
        return Optional.ofNullable((BookDto) this.modelMapper.map(this.bookRepository.findByPublicationYear(publicationYear), BookDto.class));
    }

    public Optional<Object> findBookByGenre(String genre) {
        return Optional.ofNullable((BookDto) this.modelMapper.map(this.bookRepository.findByGenre(genre), BookDto.class));
    }
}

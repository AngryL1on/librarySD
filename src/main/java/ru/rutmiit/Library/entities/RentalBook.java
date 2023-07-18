package ru.rutmiit.Library.entities;

import jakarta.persistence.*;
import ru.rutmiit.Library.entities.Book;
import ru.rutmiit.Library.entities.Reader;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "rental_book")
public class RentalBook implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "book_Id", insertable = false, updatable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "reader_Id", insertable = false, updatable = false)
    private Reader reader;

    @Column(updatable = true)
    private Timestamp rentalDate;

    public RentalBook(Integer id, Book book, Reader reader,Timestamp rentalDate) {
        this.id = id;
        this.book = book;
        this.reader = reader;
        this.rentalDate = rentalDate;
    }

    public RentalBook() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }
}

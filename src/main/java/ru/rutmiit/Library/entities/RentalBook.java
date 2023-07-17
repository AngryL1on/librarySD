package ru.rutmiit.Library.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "rental_book")
public class RentalBook implements Serializable {

    @EmbeddedId
    private RentalBookId id;

    @Column(updatable = false)
    private Timestamp rentalDate;

    @Column(updatable = false)
    private Timestamp dueDate;

    @ManyToOne
    @JoinColumn(name = "bookId", insertable = false, updatable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "readerId", insertable = false, updatable = false)
    private Reader reader;

    public RentalBook() {
    }

    public RentalBook(RentalBookId id, Timestamp rentalDate, Timestamp dueDate, Book book, Reader reader) {
        this.id = id;
        this.rentalDate = rentalDate;
        this.dueDate = dueDate;
        this.book = book;
        this.reader = reader;
    }

    // Геттеры и сеттеры

    public RentalBookId getId() {
        return id;
    }

    public void setId(RentalBookId id) {
        this.id = id;
    }

    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
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
}

@Embeddable
class RentalBookId implements Serializable {

    @Column(name = "bookId")
    private Integer bookId;

    @Column(name = "readerId")
    private Integer readerId;

    public RentalBookId() {
    }

    public RentalBookId(Integer bookId, Integer readerId) {
        this.bookId = bookId;
        this.readerId = readerId;
    }

    // Геттеры и сеттеры

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    // Переопределение equals() и hashCode() (если необходимо)
}

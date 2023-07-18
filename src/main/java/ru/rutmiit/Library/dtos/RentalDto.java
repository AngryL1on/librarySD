package ru.rutmiit.Library.dtos;

import ru.rutmiit.Library.entities.Book;
import ru.rutmiit.Library.entities.Reader;

import java.sql.Timestamp;

public class RentalDto {
    private int rentalId;
    private Book book;
    private Reader reader;
    private Timestamp rentalDate;

    public RentalDto(int rentalId, Book book, Reader reader, Timestamp rentalDate) {
        this.rentalId = rentalId;
        this.book = book;
        this.reader = reader;
        this.rentalDate = rentalDate;
    }

    public RentalDto() {
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
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

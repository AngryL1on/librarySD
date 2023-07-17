package ru.rutmiit.Library.dtos;

import java.sql.Timestamp;

public class RentalDto {
    private Integer bookId;
    private Integer readerId;
    private Timestamp rentalDate;
    private Timestamp dueDate;

    public RentalDto(Integer bookId, Integer readerId, Timestamp rentalDate, Timestamp dueDate) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.rentalDate = rentalDate;
        this.dueDate = dueDate;;
    }

    public RentalDto() {
    }

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
}

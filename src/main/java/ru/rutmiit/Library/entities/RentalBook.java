package ru.rutmiit.Library.entities;



import jakarta.persistence.*;


import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@Table(name = "rental_book")

public class RentalBook {

    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "bookId")
        private Long bookId;
        @Column(name = "readerId")
        private Long readerId;

        public Id() {
        }

        public Id(Long bookId, Long readerId) {
            this.bookId = bookId;
            this.readerId = readerId;
        }

    }

    @EmbeddedId
    private Id id = new Id();
    @Column(updatable = false)
    private Timestamp rental_date;
    @Column(updatable = false)
    private Timestamp due_date;
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "readerId")
    private Reader reader;

    public RentalBook(Id id, Timestamp rental_date, Timestamp due_date, Book book, Reader reader) {
        this.id = id;
        this.rental_date = rental_date;
        this.due_date = due_date;
        this.book = book;
        this.reader = reader;
        this.id.bookId = book.getBookId();
        this.id.readerId = reader.getReaderId();
    }

    protected RentalBook() {
    }

    public Timestamp getRental_date() {
        return rental_date;
    }

    public void setRental_date(Timestamp rental_date) {
        this.rental_date = rental_date;
    }

    public Timestamp getDue_date() {
        return due_date;
    }

    public void setDue_date(Timestamp due_date) {
        this.due_date = due_date;
    }
}
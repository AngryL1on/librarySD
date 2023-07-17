package ru.rutmiit.Library.entities;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String title;

    private String author;

    @Column(name = "publication_year")
    private Integer publicationYear;

    private String genre;

    @OneToMany(mappedBy = "book")
    private Set<RentalBook> rentalbooks = new HashSet<>();

    public Book(Integer bookId, String title, String author, Integer publicationYear, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre = genre;
    }

    protected Book(){}

    public Integer getBookId() {
        return bookId;
    }
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book { bookId=" + bookId + ", title=" + title + ", author=" + author + ", publicationYear="
                + publicationYear + ", genre=" + genre + " }";
    }

}

package ru.rutmiit.Library.dtos;

public class BookDto {
    private int bookId;
    private String title;
    private String author;
    private Integer publicationYear;
    private String genre;

    public BookDto(int bookId, String title, String author, Integer publicationYear, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre = genre;
    }

    public BookDto() {
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPublicationDate() {
        return publicationYear;
    }

    public String getGenre() {
        return genre;
    }
}

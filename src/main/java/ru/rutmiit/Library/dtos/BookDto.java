package ru.rutmiit.Library.dtos;

public class BookDto {
    private int bookId;
    private String title;
    private String author;
    private String publicationDate;
    private String genre;

    public BookDto(int bookId, String title, String author, String publicationDate, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.genre = genre;
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

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getGenre() {
        return genre;
    }
}

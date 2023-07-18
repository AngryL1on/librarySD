package ru.rutmiit.Library.dtos;

import ru.rutmiit.Library.entities.Book;
import ru.rutmiit.Library.entities.Reader;

public class ReviewDto {
    private int commentId;
    private Reader reader;
    private Book book;
    private String comment;

    public ReviewDto(int commentId, Reader reader, Book book, String comment) {
        this.commentId = commentId;
        this.reader = reader;
        this.book = book;
        this.comment = comment;
    }

    public ReviewDto() {
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

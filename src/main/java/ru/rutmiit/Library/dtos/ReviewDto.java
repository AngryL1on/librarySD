package ru.rutmiit.Library.dtos;

import ru.rutmiit.Library.entities.Book;

public class ReviewDto {
    private int commentId;
    private int readerId;
    private Book book;
    private String comment;

    public ReviewDto(int commentId, int readerId, Book book, String comment) {
        this.commentId = commentId;
        this.readerId = readerId;
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

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
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

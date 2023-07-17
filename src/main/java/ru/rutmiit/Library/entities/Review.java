package ru.rutmiit.Library.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    private Integer readerId;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "bookId")
    private Book book;

    private String comment;

    public Review(Integer commentId, Integer readerId, Integer bookId, String comment) {
        this.commentId = commentId;
        this.readerId = readerId;
        this.book = book;
        this.comment = comment;
    }

    protected Review() {

    }

    public Integer getCommentId() {
        return commentId;
    }
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getReaderId() {
        return readerId;
    }
    public void setReaderId(Integer readerId) {
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

    @Override
    public String toString() {
        return "Review { readerId=" + readerId + ", bookId=" + book.getBookId() + ", comment=" + comment + " }";
    }
}

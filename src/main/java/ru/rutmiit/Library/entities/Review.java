package ru.rutmiit.Library.entities;

import jakarta.persistence.*;

@Entity
@Table(
        name = "Reviews"
)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private Long readerId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private String comment;

    public Review(Long commentId, Long readerId, Long bookId, String comment) {
        this.commentId = commentId;
        this.readerId = readerId;
        this.book = book;
        this.comment = comment;
    }

    public Review() {

    }

    public Long getCommentId() {
        return commentId;
    }
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getReaderId() {
        return readerId;
    }
    public void setReaderId(Long readerId) {
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

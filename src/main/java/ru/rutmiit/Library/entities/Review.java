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

    private Long bookId;

    private String comment;

    public Review(Long commentId, Long readerId, Long bookId, String comment) {
        this.commentId = commentId;
        this.readerId = readerId;
        this.bookId = bookId;
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

    public Long getBookId() {
        return bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}

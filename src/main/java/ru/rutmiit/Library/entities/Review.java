package ru.rutmiit.Library.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;

    @ManyToOne
    @JoinColumn(name = "reader_id", referencedColumnName = "readerId")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "bookId")
    private Book book;

    private String comment;

    public Review(Integer commentId, Reader reader, Book book, String comment) {
        this.commentId = commentId;
        this.reader = reader;
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

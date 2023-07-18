package ru.rutmiit.Library.dtos;

import org.springframework.data.repository.query.Param;
import ru.rutmiit.Library.entities.Book;
import ru.rutmiit.Library.entities.Reader;
import ru.rutmiit.Library.entities.Review;

import java.util.List;

public class ReviewDto {
    private int commentId;
    private ReaderDto reader;
    private BookDto book;
    private String comment;

    public ReviewDto(int commentId, ReaderDto reader, BookDto book, String comment) {
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

    public ReaderDto getReader() {
        return reader;
    }

    public void setReader(ReaderDto reader) {
        this.reader = reader;
    }

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto book) {
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
        return "ReviewDto{" +
                "commentId=" + commentId +
                ", reader=" + reader +
                ", book=" + book +
                ", comment='" + comment + '\'' +
                '}';
    }
}

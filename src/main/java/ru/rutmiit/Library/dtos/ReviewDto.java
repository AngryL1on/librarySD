package ru.rutmiit.Library.dtos;

public class ReviewDto {
    private int reviewId;
    private int readerId;
    private int bookId;
    private String comment;

    public ReviewDto(int reviewId, int readerId, int bookId, int rating, String comment) {
        this.reviewId = reviewId;
        this.readerId = readerId;
        this.bookId = bookId;
        this.comment = comment;
    }

    public int getReviewId() {
        return reviewId;
    }

    public int getReaderId() {
        return readerId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getComment() {
        return comment;
    }
}

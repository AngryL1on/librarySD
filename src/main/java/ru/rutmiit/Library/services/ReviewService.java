package ru.rutmiit.Library.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.Library.dtos.ReviewDto;
import ru.rutmiit.Library.entities.Review;
import ru.rutmiit.Library.repositories.ReviewRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ReviewService() {
    }

    public List<ReviewDto> getAll(){
        return (List)this.reviewRepository.findAll().stream().map((s) -> {
            return (ReviewDto)this.modelMapper.map(s, ReviewDto.class);
        }).collect(Collectors.toList());
    }

    public Optional<Review> getReviewById (Integer reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public Review updateReview(Integer reviewId, Review updatedReview) {
        Optional<Review> existingReviewOptional = reviewRepository.findById(reviewId);
        if (existingReviewOptional.isPresent()) {
            Review existingReview = existingReviewOptional.get();
            existingReview.setComment(updatedReview.getComment());
            return reviewRepository.save(existingReview);
        } else {
            throw new IllegalArgumentException("Review with ID " + reviewId + " not found.");
        }
    }

    public Review createReview(Review review){
        return reviewRepository.save(review);
    }

    public void deleteReview(Integer reviewId){
        reviewRepository.deleteById(reviewId);
    }

    public ReviewDto addReview(ReviewDto newReview) {
        Review b = (Review)this.modelMapper.map(newReview, Review.class);
        return (ReviewDto)this.modelMapper.map(this.reviewRepository.save(b), ReviewDto.class);
    }

    public Optional<ReviewDto> findReview(Integer reviewId) {
        return Optional.ofNullable((ReviewDto)this.modelMapper.map(this.reviewRepository.findById(reviewId), ReviewDto.class));
    }

    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }
}

package ru.rutmiit.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.Library.dtos.ReviewDto;
import ru.rutmiit.Library.services.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

        @Autowired
        private ReviewService reviewService;

        public ReviewController(){}

        @GetMapping("/review")
        Iterable<ReviewDto> all() {
            return this.reviewService.getAll();
        }

        @GetMapping("/review/{id}")
        ReviewDto one(@PathVariable Integer reviewId) throws Throwable {
            return (ReviewDto)this.reviewService.findReview(reviewId).orElseThrow(() -> {
                return new ReviewNotFoundException("Could not find review with id: " + reviewId);
            });
        }


        @PostMapping({"/reviews"})
        ReviewDto newReview(@RequestBody ReviewDto newReview) {
            return this.reviewService.addReview(newReview);
        }

        @DeleteMapping("/{reviewId}")
        public ResponseEntity<Void> deleteReview(@PathVariable Integer reviewId) {
            reviewService.deleteReview(reviewId);
            return ResponseEntity.noContent().build();
        }

}

package ru.rutmiit.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.Library.dtos.ReviewDto;
import ru.rutmiit.Library.services.ReviewService;

@RestController
public class ReviewController {

        @Autowired
        private ReviewService reviewService;

        public ReviewController(){
        }

        @GetMapping("/reviews")
        Iterable<ReviewDto> all() {
            return this.reviewService.getAll();
        }

        @GetMapping("/reviews/{reviewId}")
        ReviewDto one(@PathVariable Integer reviewId) throws Throwable {
            return (ReviewDto)this.reviewService.findReview(reviewId)
                    .orElseThrow(() -> new ReviewNotFoundException("Could not find review with id: " + reviewId));
        }


        @PostMapping({"/reviews"})
        ReviewDto newReview(@RequestBody ReviewDto newReview) {
            return this.reviewService.addReview(newReview);
        }

        @DeleteMapping("/reviews/{reviewId}")
        public ResponseEntity<Void> deleteReview(@PathVariable Integer reviewId) {
            reviewService.deleteReview(reviewId);
            return ResponseEntity.noContent().build();
        }

}

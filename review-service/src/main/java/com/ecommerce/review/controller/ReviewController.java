package com.ecommerce.review.controller;

import com.ecommerce.common.dto.ApiResponse;
import com.ecommerce.review.entity.Review;
import com.ecommerce.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ApiResponse<Review> createReview(
            @RequestBody Review review) {

        return new ApiResponse<>(
                true,
                "Review Created Successfully",
                reviewService.createReview(review)
        );
    }

    @GetMapping
    public ApiResponse<List<Review>> getAllReviews() {

        return new ApiResponse<>(
                true,
                "Reviews Retrieved Successfully",
                reviewService.getAllReviews()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<Review> getReview(
            @PathVariable Long id) {

        return new ApiResponse<>(
                true,
                "Review Found",
                reviewService.getReview(id)
        );
    }

    @GetMapping("/product/{productId}")
    public ApiResponse<List<Review>> getReviewsByProduct(
            @PathVariable Long productId) {

        return new ApiResponse<>(
                true,
                "Product Reviews Retrieved",
                reviewService.getReviewsByProduct(productId)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteReview(
            @PathVariable Long id) {

        reviewService.deleteReview(id);

        return new ApiResponse<>(
                true,
                "Review Deleted Successfully",
                null
        );
    }
}
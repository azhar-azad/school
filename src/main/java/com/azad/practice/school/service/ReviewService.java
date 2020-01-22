package com.azad.practice.school.service;

import java.util.List;

import com.azad.practice.school.shared.dto.ReviewDto;

public interface ReviewService {

	ReviewDto createReview(ReviewDto reviewDto);

	ReviewDto getReviewByReviewId(String reviewId);

	List<ReviewDto> getAll(int page, int limit);

	void deleteReview(String reviewId);

	ReviewDto updateReview(String reviewId, ReviewDto updatedReviewDto);

}

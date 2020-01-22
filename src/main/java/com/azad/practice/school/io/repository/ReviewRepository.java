package com.azad.practice.school.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.azad.practice.school.io.entity.ReviewEntity;

@Repository
public interface ReviewRepository extends PagingAndSortingRepository<ReviewEntity, Long> {

	ReviewEntity findByReviewId(String reviewId);

}

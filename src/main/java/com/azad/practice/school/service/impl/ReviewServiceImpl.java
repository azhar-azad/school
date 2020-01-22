package com.azad.practice.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.azad.practice.school.exception.CourseServiceException;
import com.azad.practice.school.exception.ReviewServiceException;
import com.azad.practice.school.io.entity.CourseEntity;
import com.azad.practice.school.io.entity.ReviewEntity;
import com.azad.practice.school.io.repository.ReviewRepository;
import com.azad.practice.school.service.CourseService;
import com.azad.practice.school.service.ReviewService;
import com.azad.practice.school.shared.dto.CourseDto;
import com.azad.practice.school.shared.dto.ReviewDto;
import com.azad.practice.school.shared.utils.ReviewUtils;
import com.azad.practice.school.ui.model.response.ErrorMessages;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	ReviewUtils reviewUtils;
	
	@Autowired
	CourseService courseService;

	@Override
	public ReviewDto createReview(ReviewDto reviewDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		ReviewEntity reviewEntity = modelMapper.map(reviewDto, ReviewEntity.class);
		
		if (reviewEntity.getReviewId() == null) {
			reviewEntity.setReviewId(reviewUtils.generateReviewId(10));
		}
				
		courseService.saveCourse(new CourseDto(reviewDto.getCourseCode()));
		reviewEntity.setCourseEntity(courseService.getCourseByCourseCode(reviewDto.getCourseCode()));
		
		ReviewEntity createdReview = reviewRepository.save(reviewEntity);
		
		ReviewDto returnValue = modelMapper.map(createdReview, ReviewDto.class);
		
		return returnValue;
	}

	@Override
	public ReviewDto getReviewByReviewId(String reviewId) {
	
		ReviewEntity reviewEntity = reviewRepository.findByReviewId(reviewId);
		
		ModelMapper modelMapper = new ModelMapper();
		ReviewDto returnValue = modelMapper.map(reviewEntity, ReviewDto.class);
		
		return returnValue;
	}

	@Override
	public List<ReviewDto> getAll(int page, int limit) {
		
		if (page > 0) {
			page--;
		}
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<ReviewEntity> reviewPage = reviewRepository.findAll(pageableRequest);
		List<ReviewEntity> reviewEntityList = reviewPage.getContent();
		
		List<ReviewDto> returnValueList = new ArrayList<ReviewDto>();
		
		ModelMapper modelMapper = new ModelMapper();
		for (ReviewEntity reviewEntity : reviewEntityList) {
			ReviewDto reviewDto = modelMapper.map(reviewEntity, ReviewDto.class);
			returnValueList.add(reviewDto);
		}
		
		return returnValueList;
	}

	@Override
	public void deleteReview(String reviewId) {
		
		ReviewEntity reviewEntity = reviewRepository.findByReviewId(reviewId);

		if (reviewEntity == null) {
			throw new ReviewServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
		reviewRepository.delete(reviewEntity);
	}

	@Override
	public ReviewDto updateReview(String reviewId, ReviewDto updatedReviewDto) {
		
//		ModelMapper modelMapper = new ModelMapper();
		
//		ReviewEntity reviewEntity = reviewRepository.findByReviewId(reviewId);
		deleteReview(reviewId);
		
//		reviewEntity.setRating(updatedReviewDto.getRating());
//		reviewEntity.setDescription(updatedReviewDto.getDescription());
		
//		ReviewEntity updatedReview = reviewRepository.save(reviewEntity);
		
		updatedReviewDto.setReviewId(reviewId);
		ReviewDto returnValue = createReview(updatedReviewDto);
		
		return returnValue;
	}

}

package com.azad.practice.school.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azad.practice.school.service.CourseService;
import com.azad.practice.school.service.ReviewService;
import com.azad.practice.school.shared.dto.CourseDto;
import com.azad.practice.school.shared.dto.ReviewDto;
import com.azad.practice.school.shared.dto.StudentDto;
import com.azad.practice.school.ui.model.request.CourseDetailsRequestModel;
import com.azad.practice.school.ui.model.request.ReviewDetailsRequestModel;
import com.azad.practice.school.ui.model.request.StudentDetailsRequestModel;
import com.azad.practice.school.ui.model.response.CourseRest;
import com.azad.practice.school.ui.model.response.OperationStatusModel;
import com.azad.practice.school.ui.model.response.RequestOperationName;
import com.azad.practice.school.ui.model.response.RequestOperationStatus;
import com.azad.practice.school.ui.model.response.ReviewRest;
import com.azad.practice.school.ui.model.response.StudentRest;

@RestController
@RequestMapping("reviews")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;

	@PostMapping
	public ReviewRest createReview(@RequestBody ReviewDetailsRequestModel reviewDetails) {
		
		ModelMapper modelMapper = new ModelMapper();
		ReviewDto reviewDto = modelMapper.map(reviewDetails, ReviewDto.class);
		
		ReviewDto createdReview = reviewService.createReview(reviewDto);
		
		ReviewRest returnValue = modelMapper.map(createdReview, ReviewRest.class);
		return returnValue;
	}
	
	@GetMapping(path = "/{reviewId}")
	public ReviewRest getReview(@PathVariable String reviewId) {
		
		ReviewDto reviewDto = reviewService.getReviewByReviewId(reviewId);
		
		ModelMapper modelMapper = new ModelMapper();
		ReviewRest returnValue = modelMapper.map(reviewDto, ReviewRest.class);
		
		return returnValue;
	}
	
	@GetMapping
	public List<ReviewRest> getAllReview(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit) {
		
		List<ReviewDto> reviewDtoList = reviewService.getAll(page, limit);
		
		List<ReviewRest> returnValueList = new ArrayList<ReviewRest>();
		
		ModelMapper modelMapper = new ModelMapper();
		for (ReviewDto reviewDto : reviewDtoList) {
			ReviewRest reviewRest = modelMapper.map(reviewDto, ReviewRest.class);
			returnValueList.add(reviewRest);
		}
		
		return returnValueList;
	}
	
	@DeleteMapping(path = "/{reviewId}")
    public OperationStatusModel deleteReview(@PathVariable String reviewId) {
    	
    	OperationStatusModel returnValue = new OperationStatusModel();
    	
    	returnValue.setOperationName(RequestOperationName.DELETE.name());
    	reviewService.deleteReview(reviewId);
    	returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
    	
        return returnValue;
    }
	
	@PutMapping(path = "/{reviewId}")
	public ReviewRest updateReview(@PathVariable String reviewId, @RequestBody ReviewDetailsRequestModel updatedReviewDetails) {
		
		ModelMapper modelMapper = new ModelMapper();
		ReviewDto updatedReviewDto = modelMapper.map(updatedReviewDetails, ReviewDto.class);
		
		ReviewDto updatedReview = reviewService.updateReview(reviewId, updatedReviewDto);
		
		ReviewRest returnValue = modelMapper.map(updatedReview, ReviewRest.class);
		return returnValue;
	}
}

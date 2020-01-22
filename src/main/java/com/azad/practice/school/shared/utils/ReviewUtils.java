package com.azad.practice.school.shared.utils;

import org.springframework.stereotype.Component;

@Component
public class ReviewUtils extends Utils {

	public String generateReviewId(int length) {
		return "review" + Utils.generateRandomString(length);
	}
}

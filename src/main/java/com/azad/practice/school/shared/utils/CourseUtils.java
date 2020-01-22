package com.azad.practice.school.shared.utils;

import org.springframework.stereotype.Component;

@Component
public class CourseUtils extends Utils {

	public String generateCourseId(int length) {
		return "course" + Utils.generateRandomString(length);
	}
}

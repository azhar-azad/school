package com.azad.practice.school.shared.utils;

import org.springframework.stereotype.Component;

@Component
public class StudentUtils extends Utils {

    public String generateStudentId(int length) {
        return "student" + Utils.generateRandomString(length);
    }
}

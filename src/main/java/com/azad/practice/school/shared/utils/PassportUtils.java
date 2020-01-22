package com.azad.practice.school.shared.utils;

import org.springframework.stereotype.Component;

@Component
public class PassportUtils extends Utils {

    public String generatePassportId(int length) {
        return "passport" + Utils.generateRandomString(length);
    }
}

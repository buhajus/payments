package com.mmm.payments.model.config;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class TokenGenerator {

    public java.lang.String getToken() {

        int length = 20;
        boolean useLetters = true;
        boolean useNumbers = true;
        java.lang.String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

      return generatedString;
    }
}

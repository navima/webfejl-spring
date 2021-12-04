package com.example.demo.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmailTakenException  extends RuntimeException {
    public EmailTakenException() {
        super("This email is already taken.");
    }

}

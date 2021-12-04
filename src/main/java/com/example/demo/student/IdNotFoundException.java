package com.example.demo.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException() {
        super("Student not found.");
    }
}

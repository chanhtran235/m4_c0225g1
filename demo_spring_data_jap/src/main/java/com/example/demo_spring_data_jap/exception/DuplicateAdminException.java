package com.example.demo_spring_data_jap.exception;

public class DuplicateAdminException extends Exception {
    public DuplicateAdminException(String message) {
        super(message);
    }
}

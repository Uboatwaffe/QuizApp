package com.example.quizapp.error.exception;

/**
 * <p>Created on 23.04.2025</p>
 *
 * @author Maciej
 * @version 0.1
 */
public class DataLoadingException extends RuntimeException {
    public DataLoadingException(String message) {
        super(message);
    }
}

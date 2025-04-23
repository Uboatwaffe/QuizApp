package com.example.quizapp.error.exception;

/**
 * <p>Created on 23.04.2025</p>
 * Custom exception class for handling data loading errors in the application.
 * This exception is thrown when there is an issue loading data, such as when no more questions are available.
 * It extends the RuntimeException class, allowing it to be used as an unchecked exception.
 *
 * @author Maciej
 * @version 0.1
 */
public class DataLoadingException extends RuntimeException {

    /**
     * Constructs a new DataLoadingException with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    public DataLoadingException(String message) {
        super(message);
    }
}
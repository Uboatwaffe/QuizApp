package com.example.quizapp.db.enums;

/**
 * <p>Created on 25.03.2025</p>
 * The QuestionType enum represents the different types of questions available in the quiz application.
 * It defines four possible values:
 * <ul>
 *     <li>CLOSED - Represents a closed question type (e.g., multiple-choice or true/false).</li>
 *     <li>OPEN - Represents an open-ended question type where users provide a free-text answer.</li>
 *     <li>DATE - Represents a date-based question type.</li>
 *     <li>NONE - Represents the absence of a specific question type.</li>
 * </ul>
 * This enum is used to categorize and handle different types of questions in the application.
 *
 * @author Maciej
 * @version 0.1
 */
public enum QuestionType {
    /**
     * Represents a closed question type (e.g., multiple-choice or true/false).
     */
    CLOSED,

    /**
     * Represents an open-ended question type where users provide a free-text answer.
     */
    OPEN,

    /**
     * Represents a date-based question type.
     */
    DATE,

    /**
     * Represents the absence of a specific question type.
     */
    NONE
}
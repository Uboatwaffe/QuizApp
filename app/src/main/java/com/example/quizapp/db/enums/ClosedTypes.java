package com.example.quizapp.db.enums;

/**
 * <p>Created on 23.03.2025</p>
 * The ClosedTypes enum represents the type of closed questions in the quiz application.
 * It defines three possible types:
 * <ul>
 *     <li>ABCD - Questions with multiple-choice answers (A, B, C, D).</li>
 *     <li>TRUE_FALSE - Questions with true or false answers.</li>
 *     <li>NONE - Represents the absence of a question type.</li>
 * </ul>
 * This enum is used to categorize and handle different types of closed questions.
 *
 * @author Maciej
 * @version 0.1
 */
public enum ClosedTypes {
    /**
     * Represents a multiple-choice question type (A, B, C, D).
     */
    ABCD,

    /**
     * Represents a true or false question type.
     */
    TRUE_FALSE,

    /**
     * Represents the absence of a specific question type.
     */
    NONE
}
package com.example.quizapp.ui.questions;

/**
 * <p>Created on 23.03.2025</p>
 * The EnumOfABCD enum represents the number of correct answers in a question.
 * It defines three possible values:
 * <ul>
 *     <li>SINGLE - Indicates that the question has a single correct answer.</li>
 *     <li>MULTIPLE - Indicates that the question has multiple correct answers.</li>
 *     <li>NONE - Represents the absence of a specific answer type.</li>
 * </ul>
 * This enum is used to categorize and handle the number of correct answers in a question.
 *
 * @author Maciej
 * @version 0.1
 */
public enum EnumOfABCD {
    /**
     * Indicates that the question has a single correct answer.
     */
    SINGLE,

    /**
     * Indicates that the question has multiple correct answers.
     */
    MULTIPLE,

    /**
     * Represents the absence of a specific answer type.
     */
    NONE
}
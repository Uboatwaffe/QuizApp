package com.example.quizapp.db;

import com.example.quizapp.ui.questions.ClosedTypes;
import com.example.quizapp.ui.questions.EnumOfABCD;
import com.example.quizapp.ui.questions.QuestionType;

import java.util.List;

/**
 * <p>Created on 23.03.2025</p>
 * Class for storing and managing quiz data.
 * This class contains static fields and methods for handling questions, options, and their types.
 * It is intended to be replaced by a proper implementation in the future.
 *
 * @author Maciej
 * @version 0.1
 */
public class Data {

    // Static fields for storing question data
    private static String question = null; // The current question text
    private static String optionA = null; // Option A for the current question
    private static String optionB = null; // Option B for the current question
    private static String optionC = null; // Option C for the current question
    private static String optionD = null; // Option D for the current question
    private static String correctAnswer = null; // The correct answer for the current question
    private static ClosedTypes closedType = ClosedTypes.NONE; // The type of closed question
    private static EnumOfABCD ABCDType = EnumOfABCD.NONE; // The type of ABCD question
    private static QuestionType questionType = QuestionType.NONE; // The type of the question (e.g., open, closed)

    /**
     * A static list of question IDs.
     * This is a placeholder and should be replaced with a proper implementation.
     */
    public static final List<String> questionList = List.of(
            "1",
            "2",
            "3",
            "4"
    );

    /**
     * A static list of default sets.
     * This is a placeholder and should be replaced with a proper implementation.
     */
    public static final List<String> setsList = List.of(
            "Default set 1",
            "Default set 2"
    );

    /**
     * A counter used for cycling through predefined questions.
     * This is a placeholder and should be replaced with a proper implementation.
     */
    private static int i = 0;

    /**
     * Updates the static fields with predefined question data based on the current counter value.
     *
     * @return true if the data was updated, false if no more updates are available.
     */
    public static boolean update() {
        switch (i) {
            case 4:
            case 9:
                question = "Single choice";
                optionA = "Berlin";
                optionB = "Madrid";
                optionC = "Paris";
                optionD = "Rome";
                correctAnswer = "Paris";
                closedType = ClosedTypes.ABCD;
                ABCDType = EnumOfABCD.SINGLE;
                questionType = QuestionType.CLOSED;
                i++;
                return true;
            case 1:
            case 6:
                question = "Multiple choice";
                optionA = "Berlin";
                optionB = "Madrid";
                optionC = "Paris";
                optionD = "Rome";
                correctAnswer = "Berlin";
                closedType = ClosedTypes.ABCD;
                ABCDType = EnumOfABCD.MULTIPLE;
                questionType = QuestionType.CLOSED;
                i++;
                return true;
            case 2:
            case 7:
                question = "True/False";
                optionA = "Berlin";
                optionB = "Madrid";
                optionC = "Paris";
                optionD = "Rome";
                correctAnswer = "Madrid";
                closedType = ClosedTypes.TRUE_FALSE;
                ABCDType = EnumOfABCD.SINGLE;
                questionType = QuestionType.CLOSED;
                i++;
                return true;
            case 3:
            case 8:
                question = "Date";
                optionA = "Berlin";
                optionB = "Madrid";
                optionC = "Paris";
                optionD = "Rome";
                correctAnswer = "Rome";
                closedType = ClosedTypes.ABCD;
                ABCDType = EnumOfABCD.SINGLE;
                questionType = QuestionType.DATE;
                i++;
                return true;
            case 0:
            case 5:
                question = "What is the capital of Poland?";
                correctAnswer = "Warsaw";
                closedType = ClosedTypes.NONE;
                ABCDType = EnumOfABCD.NONE;
                questionType = QuestionType.OPEN;
                i++;
                return true;
            default:
                return false;
        }
    }

    /**
     * Retrieves the current question text.
     *
     * @return the current question.
     */
    public static String getQuestion() {
        return question;
    }

    /**
     * Retrieves option A for the current question.
     *
     * @return option A.
     */
    public static String getOptionA() {
        return optionA;
    }

    /**
     * Retrieves option B for the current question.
     *
     * @return option B.
     */
    public static String getOptionB() {
        return optionB;
    }

    /**
     * Retrieves option C for the current question.
     *
     * @return option C.
     */
    public static String getOptionC() {
        return optionC;
    }

    /**
     * Retrieves option D for the current question.
     *
     * @return option D.
     */
    public static String getOptionD() {
        return optionD;
    }

    /**
     * Retrieves the correct answer for the current question.
     *
     * @return the correct answer.
     */
    public static String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Retrieves the type of closed question.
     *
     * @return the closed question type.
     */
    public static ClosedTypes getClosedType() {
        return closedType;
    }

    /**
     * Retrieves the type of ABCD question.
     *
     * @return the ABCD question type.
     */
    public static EnumOfABCD getABCDType() {
        return ABCDType;
    }

    /**
     * Retrieves the type of the question.
     *
     * @return the question type.
     */
    public static QuestionType getQuestionType() {
        return questionType;
    }
}
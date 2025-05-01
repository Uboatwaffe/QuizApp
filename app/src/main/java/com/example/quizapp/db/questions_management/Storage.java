package com.example.quizapp.db.questions_management;

import android.content.Context;
import com.example.quizapp.R;
import com.example.quizapp.db.data.Data;
import com.example.quizapp.error.exception.DataLoadingException;
import com.example.quizapp.db.enums.ClosedTypes;
import com.example.quizapp.db.enums.EnumOfABCD;
import com.example.quizapp.db.enums.QuestionType;

/**
 * <p>Created on 25.03.2025</p>
 * The Storage class is responsible for holding the current question data and updating it
 * from the Data class. It acts as a temporary storage for quiz-related information.
 * If no more questions are available, it throws a DataLoadingException.
 * <p>
 * This class contains static fields and methods for managing the current question state.
 *
 * @version 0.1
 */
public class Storage {

    // Static fields for storing the current question data
    public static String question = null; // The current question text
    public static String optionA = null; // Option A for the current question
    public static String optionB = null; // Option B for the current question
    public static String optionC = null; // Option C for the current question
    public static String optionD = null; // Option D for the current question
    public static String correctAnswer = null; // The correct answer for the current question
    public static ClosedTypes closedType = ClosedTypes.NONE; // The type of closed question
    public static EnumOfABCD ABCDType = EnumOfABCD.NONE; // The type of ABCD question
    public static QuestionType questionType = QuestionType.NONE; // The type of the question (e.g., open, closed)

    /**
     * Updates the static fields with new question data from the Data class.
     * If no more questions are available, a DataLoadingException is thrown.
     *
     * @param context The context used to retrieve string resources.
     * @throws DataLoadingException if there are no more questions to load.
     */
    public static void setNew(Context context) {
        if (Data.update()) {
            // Update the static fields with the new question data
            Storage.question = Data.getQuestion();
            Storage.optionA = Data.getOptionA();
            Storage.optionB = Data.getOptionB();
            Storage.optionC = Data.getOptionC();
            Storage.optionD = Data.getOptionD();
            Storage.correctAnswer = Data.getCorrectAnswer();
            Storage.questionType = Data.getQuestionType();
            Storage.closedType = Data.getClosedType();
            Storage.ABCDType = Data.getABCDType();
        } else {
            // Throw an exception if no more questions are available
            throw new DataLoadingException(context.getString(R.string.no_questions));
        }
    }
}
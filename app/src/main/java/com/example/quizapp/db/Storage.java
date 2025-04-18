package com.example.quizapp.db;

import com.example.quizapp.ui.questions.ClosedTypes;
import com.example.quizapp.ui.questions.EnumOfABCD;
import com.example.quizapp.ui.questions.QuestionType;

/**
 * <p>Created on 25.03.2025</p>
 *
 * @author Maciej
 * @version 0.1
 */
public class Storage {
    public static String question = null;
    public static String optionA = null;
    public static String optionB = null;
    public static String optionC = null;
    public static String optionD = null;
    public static String correctAnswer = null;
    public static ClosedTypes closedType = ClosedTypes.NONE;
    public static EnumOfABCD ABCDType = EnumOfABCD.NONE;
    public static QuestionType questionType = QuestionType.NONE;

    /**
     * Function to set parameters
     */
    public static void setParameters(String question, String optionA, String optionB, String optionC, String optionD, String correctAns, ClosedTypes closedType, EnumOfABCD ABCD_type_new, QuestionType questionType_new){
        Storage.question = question;
        Storage.optionA = optionA;
        Storage.optionB = optionB;
        Storage.optionC = optionC;
        Storage.optionD = optionD;
        Storage.correctAnswer = correctAns;
        Storage.closedType = closedType;
        Storage.ABCDType = ABCD_type_new;
        Storage.questionType = questionType_new;
    }

    /**
     * Function to set parameters
     */
    public static void setParameters(String question, String correctAns, ClosedTypes closedType, EnumOfABCD ABCD_type_new, QuestionType questionType_new){
        Storage.question = question;
        Storage.correctAnswer = correctAns;
        Storage.closedType = closedType;
        Storage.ABCDType = ABCD_type_new;
        Storage.questionType = questionType_new;
    }

    //TODO: After this is used make the fragment call this again to update the question, after question is answered check if the next question is of the same type if yes then proceed if no then navigate to the correct fragment

}

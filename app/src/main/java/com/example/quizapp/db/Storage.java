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
    public static String question = "";
    public static String optionA = "";
    public static String optionB = "";
    public static String optionC = "";
    public static String optionD = "";
    public static String correctAnswer = "";
    public static ClosedTypes closedType = ClosedTypes.NONE;
    public static EnumOfABCD ABCDType = EnumOfABCD.NONE;
    public static QuestionType questionType = QuestionType.NONE;

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

}

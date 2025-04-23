package com.example.quizapp.db;

import com.example.quizapp.ui.questions.ClosedTypes;
import com.example.quizapp.ui.questions.EnumOfABCD;
import com.example.quizapp.ui.questions.QuestionType;

import java.util.List;

/**
 * <p>Created on 23.03.2025</p>
 * Class for storing data (to be replaced by proper class)
 * @author Maciej
 * @version 0.1
 */
public class Data {
    private static String question = null;
    private static String optionA = null;
    private static String optionB = null;
    private static String optionC = null;
    private static String optionD = null;
    private static String correctAnswer = null;
    private static ClosedTypes closedType = ClosedTypes.NONE;
    private static EnumOfABCD ABCDType = EnumOfABCD.NONE;
    private static QuestionType questionType = QuestionType.NONE;

    public static final List<String> questionList = List.of(
            "1",
            "2",
            "3",
            "4"
    );

    public static final List<String> setsList = List.of(
            "Default set 1",
            "Default set 2"
    );

    private static int i = 0;

    public static boolean update(){
        switch (i){
            case 0:
            case 5:
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
            case 4:
            case 9:
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

    public static String getQuestion() {
        return question;
    }

    public static String getOptionA() {
        return optionA;
    }

    public static String getOptionB() {
        return optionB;
    }

    public static String getOptionC() {
        return optionC;
    }

    public static String getOptionD() {
        return optionD;
    }

    public static String getCorrectAnswer() {
        return correctAnswer;
    }

    public static ClosedTypes getClosedType() {
        return closedType;
    }

    public static EnumOfABCD getABCDType() {
        return ABCDType;
    }

    public static QuestionType getQuestionType() {
        return questionType;
    }



}

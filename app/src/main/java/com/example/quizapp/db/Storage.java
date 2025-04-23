package com.example.quizapp.db;

import com.example.quizapp.error.exception.DataLoadingException;
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

    public static void setNew(){
        if(Data.update()){
            Storage.question = Data.getQuestion();
            Storage.optionA = Data.getOptionA();
            Storage.optionB = Data.getOptionB();
            Storage.optionC = Data.getOptionC();
            Storage.optionD = Data.getOptionD();
            Storage.correctAnswer = Data.getCorrectAnswer();
            Storage.questionType = Data.getQuestionType();
            Storage.closedType = Data.getClosedType();
            Storage.ABCDType = Data.getABCDType();
        }else{
            throw new DataLoadingException("No more questions");
        }
    }

}

package com.example.quizapp.db;

import com.example.quizapp.ui.questions.ClosedTypes;
import com.example.quizapp.ui.questions.EnumOfABCD;
import com.example.quizapp.ui.questions.QuestionType;

/**
 * <p>Created on 23.03.2025</p>
 * Class for storing data (to be replaced by proper class)
 * @author Maciej
 * @version 0.1
 */
public class Data {
    public final String question;
    public final String optionA;
    public final String optionB;
    public final String optionC;
    public final String optionD;
    public final String correctAnswer;
    public final ClosedTypes closedType;
    public final EnumOfABCD ABCDType;
    public final QuestionType questionType;

    /**
     * Constructor
     */
    public Data(ClosedTypes closedType, EnumOfABCD ABCDType, QuestionType questionType) {
        question = "nan";
        optionA = "nan";
        optionB = "nan";
        optionC = "nan";
        optionD = "nan";
        correctAnswer = "nan";
        this.closedType = closedType;
        this.ABCDType = ABCDType;
        this.questionType = questionType;
    }


}

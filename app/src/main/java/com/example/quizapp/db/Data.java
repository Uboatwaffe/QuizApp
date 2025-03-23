package com.example.quizapp.db;

import com.example.quizapp.ui.questions.ClosedTypes;
import com.example.quizapp.ui.questions.EnumOfABCD;

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
    public final ClosedTypes questionType;
    public final EnumOfABCD ABCDType;

    /**
     * Constructor
     */
    public Data(ClosedTypes questionType, EnumOfABCD ABCDType) {
        question = "nan";
        optionA = "nan";
        optionB = "nan";
        optionC = "nan";
        optionD = "nan";
        correctAnswer = "nan";
        this.questionType = questionType;
        this.ABCDType = ABCDType;
    }


}

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
    public String question;
    public String optionA;
    public String optionB;
    public String optionC;
    public String optionD;
    public String correctAnswer;
    public ClosedTypes questionType;
    public EnumOfABCD ABCDType;

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

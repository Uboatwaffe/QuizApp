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

    public static class Builder{
        // Question parameters
        private final String question;
        private final String correctAnswer;
        private final QuestionType questionType;

        // Options for closed questions
        private String optionA = null;
        private String optionB = null;
        private String optionC = null;
        private String optionD = null;
        private ClosedTypes closedType = ClosedTypes.NONE;
        private EnumOfABCD ABCDType = EnumOfABCD.NONE;


        public Builder(String question, String correctAnswer, QuestionType questionType) {
            this.question = question;
            this.correctAnswer = correctAnswer;
            this.questionType = questionType;
        }

        public Builder setOptionA(String optionA) {
            this.optionA = optionA;
            return this;
        }

        public Builder setOptionB(String optionB) {
            this.optionB = optionB;
            return this;
        }

        public Builder setOptionC(String optionC) {
            this.optionC = optionC;
            return this;
        }

        public Builder setOptionD(String optionD) {
            this.optionD = optionD;
            return this;
        }

        public Builder setClosedType(ClosedTypes closedType) {
            this.closedType = closedType;
            return this;
        }

        public Builder setABCDType(EnumOfABCD ABCDType) {
            this.ABCDType = ABCDType;
            return this;
        }

        public void build() {
            Storage.question = this.question;
            Storage.correctAnswer = this.correctAnswer;
            Storage.questionType = this.questionType;
            Storage.optionA = this.optionA;
            Storage.optionB = this.optionB;
            Storage.optionC = this.optionC;
            Storage.optionD = this.optionD;
            Storage.closedType = this.closedType;
            Storage.ABCDType = this.ABCDType;
        }

    }

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

    //TODO: After this is used make the fragment call this again to update the question, after question is answered check if the next question is of the same type if yes then proceed if no then navigate to the correct fragment

}

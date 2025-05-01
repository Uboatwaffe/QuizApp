package com.example.quizapp.db.data;

import android.content.Context;
import com.example.quizapp.db.enums.DataTables;
import com.example.quizapp.db.enums.ClosedTypes;
import com.example.quizapp.db.enums.EnumOfABCD;
import com.example.quizapp.db.enums.QuestionType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private static Integer score = 0; // The score for the quiz

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


    public static void resetI() {
        Data.i = 0;
    }

    /**
     * A counter used for cycling through predefined questions.
     * This is a placeholder and should be replaced with a proper implementation.
     */
    private static int i = 0;

    /**
     * A static method to set data in a file.
     * This method appends the provided data to the existing data in the file.
     *
     * @param data   The data to be saved.
     * @param dataTables   The type of data (e.g., "user", "tables", "questions").
     * @param context The context of the application.
     * @return true if the data was successfully saved, false otherwise.
     */
    public static boolean setData(String data, DataTables dataTables, Context context){
        String oldData = getData(dataTables , context);

        try (FileOutputStream fos = context.openFileOutput(dataTables.getTableName(), Context.MODE_PRIVATE)) {
            String fullData = oldData + data;

            fos.write(fullData.getBytes());
        } catch (IOException e) {
            return false;
        } catch (NullPointerException ignore) {
            // Handle the case where the file name is not found in the map
            return false;
        }
        return true;
    }

    /**
     * A static method to get data from a file.
     * This method reads the data from the specified file and returns it as a string.
     *
     * @param dataTables   The type of data (e.g., "user", "tables", "questions").
     * @param context The context of the application.
     * @return The data read from the file, or null if an error occurred.
     */
    public static String getData(DataTables dataTables, Context context) {
        StringBuilder data = new StringBuilder();

        try (FileInputStream fis = context.openFileInput(dataTables.getTableName())) {
            int c;
            while ((c = fis.read()) != -1) {
                data.append((char) c);
            }
        } catch (IOException e) {
            return null;
        }
        return data.toString();
    }

    /**
     * A static method to clear data in a file.
     * This method overwrites the existing data in the specified file with an empty string.
     *
     * @param dataTables    The type of data (e.g., "user", "tables", "questions").
     * @param context The context of the application.
     */
    public static void clearData(DataTables dataTables, Context context) {
        try (FileOutputStream fos = context.openFileOutput(dataTables.getTableName(), Context.MODE_PRIVATE)) {
            fos.write("".getBytes());
        } catch (IOException ignored) {
        } catch (NullPointerException ignore) {
            // Handle the case where the file name is not found in the map
        }
    }

    /**
     * A static method to initialize default data in the questions file.
     * This method writes predefined question data to the specified file.
     *
     * @param context The context of the application.
     */
    public static void initializeDefaultData(Context context) {
        clearData(DataTables.USER, context);
        clearData(DataTables.TABLES, context);
        clearData(DataTables.QUESTIONS, context);

        String data = "Whats the capital of France?,Berlin,Madrid,Paris,Rome,Paris,ABCD,SINGLE,CLOSED;" +
                "Whats the capital of Germany?,Berlin,Madrid,Paris,Rome,Berlin;Rome,ABCD,MULTIPLE,CLOSED;" +
                "Germany is in Europe?,true,false,true,ABCD,SINGLE,CLOSED;" +
                "When is the independence day of Poland?,11,11,1918,ABCD,SINGLE,DATE;" +
                "What is the capital of Poland?,Warsaw,Warsaw,NONE,NONE,NONE,OPEN;";

        setData(data, DataTables.QUESTIONS, context);

        data = "admin,admin;user,password;";

        setData(data, DataTables.USER, context);


    }

    /**
     * Updates the static fields with predefined question data based on the current counter value.
     *
     * @return true if the data was updated, false if no more updates are available.
     */
    public static boolean update() {
        switch (i) {
            case 0:
                question = "Whats the capital of France?";
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
                question = "Whats the capital of Germany?";
                optionA = "Berlin";
                optionB = "Madrid";
                optionC = "Paris";
                optionD = "Rome";
                correctAnswer = "Berlin;Rome";
                closedType = ClosedTypes.ABCD;
                ABCDType = EnumOfABCD.MULTIPLE;
                questionType = QuestionType.CLOSED;
                i++;
                return true;
            case 2:
                question = "Germany is in Europe?";
                correctAnswer = "true";
                closedType = ClosedTypes.TRUE_FALSE;
                ABCDType = EnumOfABCD.SINGLE;
                questionType = QuestionType.CLOSED;
                i++;
                return true;
            case 3:
                question = "When is the independence day of Poland?";
                correctAnswer = "11;11;1918";
                closedType = ClosedTypes.ABCD;
                ABCDType = EnumOfABCD.SINGLE;
                questionType = QuestionType.DATE;
                i++;
                return true;
            case 4:
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
     * Retrieves the current score.
     *
     * @return the current score.
     */
    public static Integer getScore() {
        return score;
    }

    /**
     * Sets the score to a new value.
     *
     * @param score the new score to set.
     */
    public static void setScore(Integer score) {
        Data.score = score;
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
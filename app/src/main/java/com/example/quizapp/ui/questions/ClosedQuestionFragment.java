package com.example.quizapp.ui.questions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentClosedQuestionBinding;
import com.example.quizapp.db.Data;
import com.example.quizapp.db.Storage;
import com.example.quizapp.error.exception.DataLoadingException;

/**
 * <p>Created on [unknown date]</p>
 * The ClosedQuestionFragment class is responsible for displaying and managing
 * questions with single/multiple/true or false choice answers.
 * <p>
 * This fragment uses view binding to access its layout elements and handles
 * user interactions through button click listeners.
 *
 * @version 1.0
 * @noinspection DataFlowIssue
 */
public class ClosedQuestionFragment extends Fragment {

    /**
     * The binding object for the fragment.
     * Used to access the views defined in the layout file.
     */
    private FragmentClosedQuestionBinding binding;

    /**
     * The type of ABCD question (single or multiple).
     */
    private EnumOfABCD ABCD_type = EnumOfABCD.NONE;

    /**
     * The type of question (ABCD or true/false).
     */
    private ClosedTypes question_type = ClosedTypes.NONE;

    /**
     * The correct answer to the current question.
     * @noinspection FieldCanBeLocal, unused
     */
    private String answer;

    /**
     * An array of checkboxes used for displaying answer options.
     */
    private CheckBox[] checkBoxes;

    /**
     * Called to create the view hierarchy associated with the fragment.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate views in the fragment.
     * @param container          The parent view that the fragment's UI should be attached to, or null if not attached.
     * @param savedInstanceState A Bundle containing the saved state of the fragment, or null if no state is saved.
     * @return The root view of the fragment's layout.
     */
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        binding = FragmentClosedQuestionBinding.inflate(inflater, container, false);

        // Initialize the checkboxes array
        checkBoxes = new CheckBox[]{binding.checkBoxA, binding.checkBoxB, binding.checkBoxC, binding.checkBoxD};

        // Retrieve arguments passed to the fragment
        Bundle args = getArguments();
        //noinspection DataFlowIssue
        boolean first = args.getBoolean("first");

        // If this is the first question, initialize the storage
        if (first) {

            try {
                Storage.setNew(getContext());
            } catch (DataLoadingException e) {
                // Navigate to the score fragment if no more questions are available
                NavHostFragment.findNavController(this)
                        .navigate(R.id.scoreFragment);
            }finally{
                Data.setScore(0);
            }
        }

        // Load the next question
        NextQuestion();

        return binding.getRoot();
    }

    /**
     * Sets the parameters for the current question.
     *
     * @param question          The question text.
     * @param optionA           The text for option A (or true).
     * @param optionB           The text for option B (or false).
     * @param optionC           The text for option C (or null).
     * @param optionD           The text for option D (or null).
     * @param correctAns        The correct answer.
     * @param question_type_new The type of question (ABCD or true/false).
     * @param ABCD_type_new     The type of ABCD question (single or multiple).
     */
    private void setParameters(String question, String optionA, String optionB, String optionC, String optionD, String correctAns, ClosedTypes question_type_new, EnumOfABCD ABCD_type_new) {
        ABCD_type = ABCD_type_new;
        question_type = question_type_new;
        answer = correctAns;

        // Configure the UI based on the question type
        if (question_type == ClosedTypes.ABCD) {
            binding.questionText.setText(question);
            binding.checkBoxA.setText(optionA);
            binding.checkBoxB.setText(optionB);
            binding.checkBoxC.setText(optionC);
            binding.checkBoxD.setText(optionD);

            binding.checkBoxC.setVisibility(View.VISIBLE);
            binding.checkBoxD.setVisibility(View.VISIBLE);
            binding.typeOfQuestionText.setVisibility(View.VISIBLE);

            if (ABCD_type == EnumOfABCD.MULTIPLE) {
                binding.typeOfQuestionText.setText(R.string.question_multiple_text);
            } else if (ABCD_type == EnumOfABCD.SINGLE) {
                binding.typeOfQuestionText.setText(R.string.question_single_text);
            } else {
                NavHostFragment.findNavController(this)
                        .navigate(R.id.problemFragment);
            }
        } else if (question_type == ClosedTypes.TRUE_FALSE) {
            binding.questionText.setText(question);
            binding.checkBoxA.setText(R.string.option_true);
            binding.checkBoxB.setText(R.string.option_false);

            binding.checkBoxC.setVisibility(View.GONE);
            binding.checkBoxD.setVisibility(View.GONE);
            binding.typeOfQuestionText.setVisibility(View.GONE);
        } else {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.problemFragment);
        }
    }

    /**
     * Called immediately after the view is created.
     * Sets up listeners for checkboxes and the "Next Question" button.
     *
     * @param view               The view returned by onCreateView.
     * @param savedInstanceState A Bundle containing the saved state of the fragment, or null if no state is saved.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up listeners for checkboxes
        binding.checkBoxA.setOnClickListener(v -> Update(binding.checkBoxA));
        binding.checkBoxB.setOnClickListener(v -> Update(binding.checkBoxB));
        binding.checkBoxC.setOnClickListener(v -> Update(binding.checkBoxC));
        binding.checkBoxD.setOnClickListener(v -> Update(binding.checkBoxD));

        // Set up listener for the "Next Question" button
        binding.buttonNextQuestion.setOnClickListener(v -> {

            // Check whether user selected correct answer
            if(isCorrectAnswer()) {
                Data.setScore(Data.getScore() + 1);
            }

            // Check if there are more questions available
            try {
                // Load the next question
                Storage.setNew(getContext());
            } catch (DataLoadingException e) {
                NavHostFragment.findNavController(this)
                        .navigate(R.id.scoreFragment);
            }

            NextQuestion();
        });
    }

    /**
     * Loads the next question from the database and updates the UI.
     */
    private void NextQuestion() {
        if (Storage.questionType == QuestionType.CLOSED) {
            setParameters(Storage.question, Storage.optionA, Storage.optionB, Storage.optionC, Storage.optionD, Storage.correctAnswer, Storage.closedType, Storage.ABCDType);
        } else if (Storage.questionType == QuestionType.OPEN) {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.openQuestionFragment);
        } else if (Storage.questionType == QuestionType.DATE) {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.dateQuestionFragment);
        }

        // Uncheck all checkboxes
        for (CheckBox checkBox : checkBoxes) {
            checkBox.setChecked(false);
        }
    }

    /**
     * Updates the state of checkboxes based on the current selection.
     * If the question type is single or true/false, unchecks all other checkboxes.
     *
     * @param current The currently selected checkbox.
     */
    private void Update(CheckBox current) {
        if (ABCD_type == EnumOfABCD.SINGLE || question_type == ClosedTypes.TRUE_FALSE) {
            for (CheckBox checkBox : checkBoxes) {
                if (checkBox.isChecked() && checkBox != current) {
                    checkBox.setChecked(false);
                }
            }
        }
    }

    /**
     * Checks if the selected answer is correct.
     * For single choice questions, checks if the selected checkbox matches the correct answer.
     * For multiple choice questions, checks if all selected checkboxes match the correct answers.
     *
     * @return true if the selected answer is correct, false otherwise.
     */
    private boolean isCorrectAnswer() {

        if (ABCD_type == EnumOfABCD.SINGLE || question_type == ClosedTypes.TRUE_FALSE) {

            // Check if the selected checkbox matches the correct answer
            for (CheckBox checkBox : checkBoxes) {
                if (checkBox.isChecked() && checkBox.getText().toString().equalsIgnoreCase(answer)) {
                    return true;
                }
            }


        }else if(ABCD_type == EnumOfABCD.MULTIPLE) {

            // Check if all selected checkboxes match the correct answers
            String[] correctAnswers = answer.split(";");

            for (String correctAnswer : correctAnswers) {

                boolean found = false;

                for (CheckBox checkBox : checkBoxes) {
                    if (checkBox.isChecked() && checkBox.getText().equals(correctAnswer)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return false;
                }
            }
            return true;
        }
        // If no checkboxes are checked or the answer is incorrect
        return false;
    }

    /**
     * Called when the view hierarchy associated with the fragment is being removed.
     * Cleans up the binding object to prevent memory leaks.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
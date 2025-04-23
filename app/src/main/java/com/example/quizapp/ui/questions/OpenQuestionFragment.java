package com.example.quizapp.ui.questions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentOpenQuestionBinding;
import com.example.quizapp.db.Storage;
import com.example.quizapp.error.exception.DataLoadingException;

/**
 * <p>Created on [unknown date]</p>
 * The OpenQuestionFragment class is responsible for displaying and managing
 * open-ended questions in the quiz application.
 * <p>
 * This fragment uses view binding to access its layout elements and handles
 * user interactions through button click listeners.
 *
 * @version 1.0
 */
public class OpenQuestionFragment extends Fragment {

    /**
     * The binding object for the fragment.
     * Used to access the views defined in the layout file.
     */
    private FragmentOpenQuestionBinding binding;

    /**
     * The correct answer to the current question.
     * @noinspection FieldCanBeLocal, unused
     */
    private String answer;

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
        binding = FragmentOpenQuestionBinding.inflate(inflater, container, false);

        // Retrieve arguments passed to the fragment
        Bundle args = getArguments();
        //noinspection DataFlowIssue
        boolean first = args.getBoolean("first");

        // If this is the first question, initialize the storage
        if (first) {
            try {
                Storage.setNew();
            } catch (DataLoadingException e) {
                // Navigate to the score fragment if no more questions are available
                NavHostFragment.findNavController(this)
                        .navigate(R.id.scoreFragment);
            }
        }

        // Load the next question
        NextQuestion();

        return binding.getRoot();
    }

    /**
     * Called immediately after the view is created.
     * Sets up listeners for the "Next" button.
     *
     * @param view               The view returned by onCreateView.
     * @param savedInstanceState A Bundle containing the saved state of the fragment, or null if no state is saved.
     */
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up a click listener for the "Next" button
        binding.buttonNext.setOnClickListener(v -> {
            // TODO: Check if the answer is correct and if there are more questions
            try {
                Storage.setNew();
            } catch (DataLoadingException e) {
                // Navigate to the score fragment if no more questions are available
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
            NavHostFragment.findNavController(this)
                    .navigate(R.id.closedQuestionFragment);
        } else if (Storage.questionType == QuestionType.OPEN) {
            setParameters(Storage.question, Storage.correctAnswer);
        } else if (Storage.questionType == QuestionType.DATE) {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.dateQuestionFragment);
        }
    }

    /**
     * Sets the parameters for the current question.
     *
     * @param question   The question text to be displayed.
     * @param correctAns The correct answer to the question.
     */
    private void setParameters(String question, String correctAns) {
        // Set the text of the question
        binding.openQuestionText.setText(question);

        // Store the correct answer
        answer = correctAns;
    }

    /**
     * Called when the view hierarchy associated with the fragment is being removed.
     * Cleans up the binding object to prevent memory leaks.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Clear the binding reference
    }
}
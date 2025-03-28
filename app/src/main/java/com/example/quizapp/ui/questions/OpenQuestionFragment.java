package com.example.quizapp.ui.questions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.quizapp.databinding.FragmentOpenQuestionBinding;
import com.example.quizapp.db.Storage;


/**
 * This fragment is used to display open questions.
 */
public class OpenQuestionFragment extends Fragment {

    /**
     * The binding object for the fragment.
     */
    private FragmentOpenQuestionBinding binding;

    /**
     * Answer to the question.
     */
    private String answer;

    /**
     * This method is called when the fragment is created.
     *
     * @param inflater           The layout inflater.
     * @param container          The view group container.
     * @param savedInstanceState The saved instance state.
     * @return The view of the fragment.
     */
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        binding = FragmentOpenQuestionBinding.inflate(inflater, container, false);

        setParameters(Storage.question, Storage.correctAnswer);
        return binding.getRoot();

    }

    /**
     * This method is called when the view is created.
     * @param view The view of the fragment.
     * @param savedInstanceState The saved instance state.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Listeners

    }

    /**
     * This method is used to set the parameters of the question.
     *
     * @param question   The question to be displayed.
     * @param correctAns The correct answer to the question.
     */
    private void setParameters(String question, String correctAns) {

        // Set the text of the question and the options
        binding.openQuestionText.setText(question);

        answer = correctAns;
    }

    /**
     * This method is called when the view is destroyed.
     */
    @Override
    public void onDestroyView() {

        // Set the binding to null
        super.onDestroyView();
        binding = null;
    }

}
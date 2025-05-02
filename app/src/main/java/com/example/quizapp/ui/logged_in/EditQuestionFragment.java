package com.example.quizapp.ui.logged_in;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentEditQuestionBinding;

import java.util.*;

/**
 * <p>Created on 23.04.2025</p>
 * The EditQuestionFragment class is responsible for providing a user interface
 * to edit or add questions in the quiz application. It allows users to select
 * question types, configure options, and manage question details.
 * <p>
 * This fragment uses view binding to access its layout elements.
 * It also handles user interactions such as selecting question types and
 * updating visibility of UI elements based on the selected options.
 *
 * @author Uboatwaffe
 * @version 1.0
 */
public class EditQuestionFragment extends Fragment {

    /**
     * The binding object for the fragment.
     * Used to access the views defined in the layout file.
     */
    private FragmentEditQuestionBinding binding;

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
        binding = FragmentEditQuestionBinding.inflate(inflater, container, false);

        // Initialize the question type list
        List<String> questionTypeList = List.of(
                getString(R.string.select_question_type),
                getString(R.string.open_question),
                getString(R.string.closed_question),
                getString(R.string.date_question)
        );

        // Initialize the spinner with an adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_spinner_item,
                questionTypeList
        );

        // Set the layout for the spinner dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter for the spinner
        binding.spinnerTypeOfQuestion.setAdapter(adapter);

        // Retrieve arguments passed from the previous fragment
        int questionId = getArguments() != null ? getArguments().getInt("question_id") : -1;
        String action = getArguments() != null ? getArguments().getString("action") : null;

        // Set the question text or initialize for adding a new question
        assert action != null;
        if (action.equals("add")) {
            binding.editQuestion.setText(R.string.type_here_text);
            HideAbcd();
        } else {
            binding.editQuestion.setText(String.valueOf(questionId));
        }

        return binding.getRoot();
    }

    /**
     * Called immediately after the view is created.
     * Sets up listeners for user interactions such as checkbox clicks and spinner selections.
     *
     * @param view               The view returned by onCreateView.
     * @param savedInstanceState A Bundle containing the saved state of the fragment, or null if no state is saved.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up listeners for checkboxes
        binding.checkBoxAbcd.setOnClickListener(v -> Update(binding.checkBoxAbcd));
        binding.checkBoxTf.setOnClickListener(v -> Update(binding.checkBoxTf));
        binding.checkBoxSingle.setOnClickListener(v -> Update(binding.checkBoxSingle));
        binding.checkBoxMultiple.setOnClickListener(v -> Update(binding.checkBoxMultiple));

        // Set up listener for the delete button
        binding.buttonDelete.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_editQuestionFragment_to_manageQuestionsFragment)
        );

        // Set up listener for the spinner
        binding.spinnerTypeOfQuestion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Set();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        binding.buttonReturnEdit.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_editQuestionFragment_to_manageQuestionsFragment)
        );
    }

    /**
     * Updates the visibility of UI elements based on the selected question type.
     */
    private void Set() {
        String selectedQuestionType = binding.spinnerTypeOfQuestion.getSelectedItem().toString();

        if (selectedQuestionType.equals(getString(R.string.select_question_type))) {
            ShowAbcd();
        } else if (selectedQuestionType.equals(getString(R.string.closed_question))) {
            binding.checkBoxAbcd.setVisibility(View.VISIBLE);
            binding.checkBoxTf.setVisibility(View.VISIBLE);
            binding.closedTypeText.setVisibility(View.VISIBLE);
            ShowAbcd();
        } else {
            binding.checkBoxAbcd.setVisibility(View.GONE);
            binding.checkBoxTf.setVisibility(View.GONE);
            binding.closedTypeText.setVisibility(View.GONE);
            HideAbcd();
        }
    }

    /**
     * Updates the state of checkboxes and visibility of related UI elements.
     *
     * @param current The checkbox that was clicked.
     */
    private void Update(CheckBox current) {
        if (current == binding.checkBoxAbcd) {
            binding.checkBoxTf.setChecked(false);
            ShowAbcd();
        } else if (current == binding.checkBoxTf) {
            binding.checkBoxAbcd.setChecked(false);
            HideAbcd();
        } else if (current == binding.checkBoxSingle) {
            binding.checkBoxMultiple.setChecked(false);
        } else if (current == binding.checkBoxMultiple) {
            binding.checkBoxSingle.setChecked(false);
        }
    }

    /**
     * Hides the UI elements related to ABCD options.
     */
    private void HideAbcd() {
        binding.checkBoxSingle.setVisibility(View.GONE);
        binding.checkBoxMultiple.setVisibility(View.GONE);
        binding.singleOrMultipleText.setVisibility(View.GONE);
        binding.editOptionA.setVisibility(View.GONE);
        binding.editOptionB.setVisibility(View.GONE);
        binding.editOptionC.setVisibility(View.GONE);
        binding.editOptionD.setVisibility(View.GONE);
        binding.dividerHorizontal.setVisibility(View.GONE);
        binding.optionAText.setVisibility(View.GONE);
        binding.optionBText.setVisibility(View.GONE);
        binding.optionCText.setVisibility(View.GONE);
        binding.optionDText.setVisibility(View.GONE);
        binding.optionsText.setVisibility(View.GONE);
    }

    /**
     * Shows the UI elements related to ABCD options.
     */
    private void ShowAbcd() {
        binding.checkBoxSingle.setVisibility(View.VISIBLE);
        binding.checkBoxMultiple.setVisibility(View.VISIBLE);
        binding.singleOrMultipleText.setVisibility(View.VISIBLE);
        binding.editOptionA.setVisibility(View.VISIBLE);
        binding.editOptionB.setVisibility(View.VISIBLE);
        binding.editOptionC.setVisibility(View.VISIBLE);
        binding.editOptionD.setVisibility(View.VISIBLE);
        binding.dividerHorizontal.setVisibility(View.VISIBLE);
        binding.optionAText.setVisibility(View.VISIBLE);
        binding.optionBText.setVisibility(View.VISIBLE);
        binding.optionCText.setVisibility(View.VISIBLE);
        binding.optionDText.setVisibility(View.VISIBLE);
        binding.optionsText.setVisibility(View.VISIBLE);
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
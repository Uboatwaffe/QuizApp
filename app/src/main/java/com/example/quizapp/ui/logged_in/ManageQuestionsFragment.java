package com.example.quizapp.ui.logged_in;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentManageQuestionsBinding;
import com.example.quizapp.db.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created on [unknown date]</p>
 * The ManageQuestionsFragment class is responsible for managing quiz questions.
 * It provides a user interface to add, edit, or navigate between questions.
 *
 * This fragment uses view binding to access its layout elements and handles
 * user interactions through button click listeners and spinner item selection.
 *
 * @version 1.0
 */
public class ManageQuestionsFragment extends Fragment {

    /**
     * The binding object for the fragment.
     * Used to access the views defined in the layout file.
     */
    private FragmentManageQuestionsBinding binding;

    /**
     * The selected question from the spinner.
     */
    private String selectedQuestion;

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
        binding = FragmentManageQuestionsBinding.inflate(inflater, container, false);

        // Initialize the list of questions
        List<String> setsList = new ArrayList<>(Data.questionList);

        // Initialize the spinner adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_spinner_item,
                setsList
        );

        // Set the layout for the spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter for the spinner
        binding.spinnerQuestions.setAdapter(adapter);

        return binding.getRoot();
    }

    /**
     * Called immediately after the view is created.
     * Sets up click listeners for buttons and item selection for the spinner.
     *
     * @param view               The view returned by onCreateView.
     * @param savedInstanceState A Bundle containing the saved state of the fragment, or null if no state is saved.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up a click listener for the "Exit" button to navigate to the LoggedInFragment
        binding.buttonExit.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_manageQuestionsFragment_to_loggedInFragment));

        // Set up a click listener for the "Add" button to navigate to the EditQuestionFragment
        binding.buttonAdd.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("action", "add");
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_manageQuestionsFragment_to_editQuestionFragment, bundle);
        });

        // Set up a listener for the spinner to handle item selection
        binding.spinnerQuestions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Update the selected question when an item is selected
                selectedQuestion = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Clear the selected question when no item is selected
                selectedQuestion = null;
            }
        });

        // Set up a click listener for the "Edit" button to navigate to the EditQuestionFragment
        binding.buttonEdit.setOnClickListener(v -> {
            if (selectedQuestion != null) {
                // Pass the selected question ID and action to the EditQuestionFragment
                Bundle bundle = new Bundle();
                bundle.putInt("question_id", Integer.parseInt(selectedQuestion));
                bundle.putString("action", "edit");
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_manageQuestionsFragment_to_editQuestionFragment, bundle);
            }
        });
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
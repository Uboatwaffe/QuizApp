package com.example.quizapp.ui.logged_in;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentManageQuestionsBinding;
import com.example.quizapp.db.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * This fragment is used to manage questions.
 */
public class ManageQuestionsFragment extends Fragment {

    /**
     * The binding object for the fragment.
     */
    private FragmentManageQuestionsBinding binding;

    /**
     * The adapter for the spinner.
     */
    private ArrayAdapter<String> adapter;

    /**
     * The list of sets.
     */
    private List<String> setsList;

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
        binding = FragmentManageQuestionsBinding.inflate(inflater, container, false);

        // Initialize the list
        setsList = new ArrayList<>(Data.questionList);

        // Initialize the spinner
        adapter = new ArrayAdapter<>(
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
     * This method is called when the view is created.
     * @param view The view of the fragment.
     * @param savedInstanceState The saved instance state.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Listeners
        binding.buttonExit.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_manageQuestionsFragment_to_loggedInFragment));
    }

    /**
     * Method to update the spinner data.
     *
     * @param db The new data to be displayed in the spinner.
     */
    private void updateSpinnerData(String ... db) {
        // Clear the current list
        setsList.clear();

        // Add the new data to the list
        setsList.addAll(Arrays.asList(db));

        // Notify the adapter that the data has changed
        adapter.notifyDataSetChanged();
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
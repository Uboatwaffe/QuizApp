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
import com.example.quizapp.databinding.FragmentChangeSetsBinding;
import com.example.quizapp.db.data.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Created on [unknown date]</p>
 * The ManageSetsFragment class is responsible for displaying and managing
 * available sets of questions. It provides a user interface to refresh the
 * list of sets or navigate back to the logged-in menu.
 * <p>
 * This fragment uses view binding to access its layout elements and handles
 * user interactions through button click listeners.
 *
 * @version 1.0
 */
public class ManageSetsFragment extends Fragment {

    /**
     * The binding object for the fragment.
     * Used to access the views defined in the layout file.
     */
    private FragmentChangeSetsBinding binding;

    /**
     * The adapter for the spinner that displays the list of sets.
     */
    private ArrayAdapter<String> adapter;

    /**
     * The list of sets displayed in the spinner.
     */
    private List<String> setsList;

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
        binding = FragmentChangeSetsBinding.inflate(inflater, container, false);

        // Initialize the list of sets from the database
        setsList = new ArrayList<>(Data.setsList);

        // Initialize the spinner adapter with the list of sets
        adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_spinner_item,
                setsList
        );

        // Set the layout for the spinner dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter for the spinner
        binding.sets.setAdapter(adapter);

        return binding.getRoot();
    }

    /**
     * Called immediately after the view is created.
     * Sets up click listeners for the refresh and return buttons.
     *
     * @param view               The view returned by onCreateView.
     * @param savedInstanceState A Bundle containing the saved state of the fragment, or null if no state is saved.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up a click listener for the "Refresh" button to update the spinner data
        binding.buttonRefresh.setOnClickListener(v -> {
            // Update the spinner data with new sets
            updateSpinnerData("Set1", "Set2", "Set3", "Set4", "Set5");
        });

        // Set up a click listener for the "Return" button to navigate back to the LoggedInFragment
        binding.buttonReturn.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_changeSetsFragment_to_loggedInFragment)
        );
    }

    /**
     * Updates the spinner data with the provided list of sets.
     *
     * @param db The new data to be displayed in the spinner.
     */
    private void updateSpinnerData(String... db) {
        // Clear the current list of sets
        setsList.clear();

        // Add the new data to the list of sets
        setsList.addAll(Arrays.asList(db));

        // Notify the adapter that the data has changed
        adapter.notifyDataSetChanged();
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
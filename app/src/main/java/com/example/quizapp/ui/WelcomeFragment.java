package com.example.quizapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentWelcomeBinding;

import java.util.Objects;

/**
 * <p>WelcomeFragment represents the welcome screen of the QuizApp.</p>
 *
 * This fragment serves as the entry point of the application, providing users with options
 * to start the quiz or close the app. It uses view binding to access its layout elements
 * and sets up click listeners for user interactions.
 *
 * @version 1.0
 */
public class WelcomeFragment extends Fragment {

    /**
     * The binding object for the fragment.
     * Used to access the views defined in the layout file.
     */
    private FragmentWelcomeBinding binding;

    /**
     * Called to have the fragment instantiate its user interface view.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container          If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     * @return The root view of the fragment's layout.
     */
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Called after the view is created.
     * Sets up the click listeners for the buttons in the fragment.
     *
     * @param view               The view returned by onCreateView.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up a click listener for the "Start" button to navigate to the main menu
        binding.buttonStart.setOnClickListener(v ->
                NavHostFragment.findNavController(WelcomeFragment.this)
                        .navigate(R.id.action_welcomeFragment_to_mainMenuFragment)
        );

        // Set up a click listener for the "Close" button to close the app
        try {
            binding.buttonClose.setOnClickListener(v -> Objects.requireNonNull(getActivity()).finish());
        } catch (Exception ignore) {
            // Navigate to a problem fragment if an exception occurs
            NavHostFragment.findNavController(WelcomeFragment.this)
                    .navigate(R.id.problemFragment);
        }
    }

    /**
     * Called when the view previously created by onCreateView has been detached from the fragment.
     * Cleans up the binding object to prevent memory leaks.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Clear the binding reference
    }
}
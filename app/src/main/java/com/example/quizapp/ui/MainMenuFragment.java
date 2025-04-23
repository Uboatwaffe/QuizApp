package com.example.quizapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentMainMenuBinding;

/**
 * <p>Created on [unknown date]</p>
 * The MainMenuFragment class represents the main menu of the QuizApp.
 * <p>
 * This fragment provides navigation options to other parts of the application, such as the welcome screen,
 * credits screen, and login screen. It uses view binding to access its layout elements and sets up
 * click listeners for the buttons in the main menu.
 *
 * @version 1.0
 */
public class MainMenuFragment extends Fragment {

    /**
     * The binding object for the fragment.
     * Used to access the views defined in the layout file.
     */
    private FragmentMainMenuBinding binding;

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
        binding = FragmentMainMenuBinding.inflate(inflater, container, false);
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

        // Set up a click listener for the "Return" button
        binding.buttonReturnSecond.setOnClickListener(v ->
                NavHostFragment.findNavController(MainMenuFragment.this)
                        .navigate(R.id.action_mainMenuFragment_to_welcomeFragment)
        );

        // Set up a click listener for the "Credits" button
        binding.buttonCredits.setOnClickListener(v ->
                NavHostFragment.findNavController(MainMenuFragment.this)
                        .navigate(R.id.action_mainMenuFragment_to_creditsFragment)
        );

        // Set up a click listener for the "Login" button
        binding.buttonLogin.setOnClickListener(v ->
                NavHostFragment.findNavController(MainMenuFragment.this)
                        .navigate(R.id.action_mainMenuFragment_to_loginFragment)
        );
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
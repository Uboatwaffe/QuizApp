package com.example.quizapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentCreditsBinding;

/**
 * <p>Created on [unknown date]</p>
 * The CreditsFragment class is responsible for displaying the credits of the application.
 *
 * This fragment uses view binding to access its layout elements and handles user interactions
 * through button click listeners.
 *
 * @version 1.0
 */
public class CreditsFragment extends Fragment {

    /**
     * The binding object for the fragment.
     * Used to access the views defined in the layout file.
     */
    private FragmentCreditsBinding binding;

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
        binding = FragmentCreditsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Called immediately after the view is created.
     * Sets up listeners for the "Return" button.
     *
     * @param view               The view returned by onCreateView.
     * @param savedInstanceState A Bundle containing the saved state of the fragment, or null if no state is saved.
     */
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up a click listener for the "Return" button
        binding.buttonReturn.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_creditsFragment_to_mainMenuFragment)
        );
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
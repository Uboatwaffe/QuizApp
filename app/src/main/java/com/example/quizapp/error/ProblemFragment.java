package com.example.quizapp.error;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.quizapp.databinding.FragmentProblemBinding;

/**
 * <p>Created on 23.04.2025</p>
 * The ProblemFragment class is responsible for displaying an error message
 * when the application encounters an error. It provides a button for the user
 * to acknowledge the error and exit the application.
 *
 * This fragment uses view binding to access its layout elements.
 *
 * @author Uboatwaffe
 * @version 1.0
 */
public class ProblemFragment extends Fragment {

    /**
     * The binding object for the fragment.
     * Used to access the views defined in the layout file.
     */
    private FragmentProblemBinding binding;

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
        // Inflate the layout for this fragment and initialize the binding object
        binding = FragmentProblemBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Called immediately after the view is created.
     * Sets up a click listener for the "Understood" button to exit the application.
     *
     * @param view               The view returned by onCreateView.
     * @param savedInstanceState A Bundle containing the saved state of the fragment, or null if no state is saved.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up a click listener for the "Understood" button to terminate the app
        binding.buttonUnderstood.setOnClickListener(v ->
                System.exit(0)
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
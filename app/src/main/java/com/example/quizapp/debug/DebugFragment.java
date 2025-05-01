package com.example.quizapp.debug;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentDebugBinding;
import com.example.quizapp.db.data.Data;

/**
 * This fragment is used to test fragments that are not accessible during normal app usage.
 * It provides navigation to various fragments for debugging purposes.
 */
public class DebugFragment extends Fragment {

    /**
     * The binding object for the fragment.
     * Used to access the views defined in the layout file.
     */
    private FragmentDebugBinding binding;

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
        binding = FragmentDebugBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Called immediately after the view is created.
     * Sets up click listeners for the buttons to navigate to different fragments.
     *
     * @param view               The view returned by onCreateView.
     * @param savedInstanceState A Bundle containing the saved state of the fragment, or null if no state is saved.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up navigation to the ProblemFragment
        binding.buttonProblem.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.problemFragment)
        );

        // Set up navigation to the ClosedQuestionFragment
        binding.buttonAbcd.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.closedQuestionFragment)
        );

        // Set up navigation to the DateQuestionFragment
        binding.buttonDate.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.dateQuestionFragment)
        );

        // Set up navigation to the OpenQuestionFragment
        binding.buttonOpen.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.openQuestionFragment)
        );

        binding.buttonReset.setOnClickListener(v ->{
            Data.initializeDefaultData(getContext());
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
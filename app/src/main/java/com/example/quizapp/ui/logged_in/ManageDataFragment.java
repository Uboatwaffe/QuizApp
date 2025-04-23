package com.example.quizapp.ui.logged_in;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentManageDataBinding;

/**
 * <p>Created on 23.04.2025</p>
 * The ManageDataFragment class is responsible for providing a user interface
 * to manage user data within the quiz application. It allows users to navigate
 * back to the logged-in menu or perform other data-related actions.
 * <p>
 * This fragment uses view binding to access its layout elements and handles
 * user interactions through button click listeners.
 *
 * @author Uboatwaffe
 * @version 1.0
 */
public class ManageDataFragment extends Fragment {

    /**
     * The binding object for the fragment.
     * Used to access the views defined in the layout file.
     */
    private FragmentManageDataBinding binding;

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
        binding = FragmentManageDataBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Called immediately after the view is created.
     * Sets up a click listener for the "Scratch" button to navigate back to the logged-in menu.
     *
     * @param view               The view returned by onCreateView.
     * @param savedInstanceState A Bundle containing the saved state of the fragment, or null if no state is saved.
     */
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up a click listener for the "Scratch" button to navigate to the LoggedInFragment
        binding.buttonScratch.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_manageDataFragment_to_loggedInFragment)
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
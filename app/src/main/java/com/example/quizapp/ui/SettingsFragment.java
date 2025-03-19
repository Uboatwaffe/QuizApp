package com.example.quizapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.quizapp.databinding.FragmentSettingsBinding;

/**
 * This fragment represents the settings menu of the QuizApp.
 */
public class SettingsFragment extends Fragment {

    /**
     * The binding object for the fragment.
     */
    private FragmentSettingsBinding binding;

    /**
     * Called to have the fragment instantiate its user interface view.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    /**
     * This method is called after the view is created.
     * It sets up the click listeners for the buttons in the fragment.
     *
     * @param view               The view returned by onCreateView.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Listeners

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
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
 * This fragment represents the welcome screen of the QuizApp.
 */
public class WelcomeFragment extends Fragment {

    /**
     * The binding object for the fragment.
     */
    private FragmentWelcomeBinding binding;

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
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
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
        binding.buttonStart.setOnClickListener(v ->
                NavHostFragment.findNavController(WelcomeFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );

        // Close the app (listener)
        try {
            binding.buttonClose.setOnClickListener(v -> Objects.requireNonNull(getActivity()).finish());
        } catch (Exception ignore) {
            NavHostFragment.findNavController(WelcomeFragment.this)
                    .navigate(R.id.problemFragment);
        }

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
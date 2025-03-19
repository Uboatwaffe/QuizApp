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
 * This fragment represents the main menu of the QuizApp.
 */
public class MainMenuFragment extends Fragment {

    /**
     * The binding object for the fragment.
     */
    private FragmentMainMenuBinding binding;

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
        binding = FragmentMainMenuBinding.inflate(inflater, container, false);
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
        binding.buttonReturnSecond.setOnClickListener(v ->
                NavHostFragment.findNavController(MainMenuFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );

        binding.buttonCredits.setOnClickListener(v ->
                NavHostFragment.findNavController(MainMenuFragment.this)
                        .navigate(R.id.action_SecondFragment_to_creditsFragment)
        );

        binding.buttonLogin.setOnClickListener(v ->
                NavHostFragment.findNavController(MainMenuFragment.this)
                        .navigate(R.id.action_SecondFragment_to_loginFragment)
        );
    }

    /**
     * Called when the view previously created by onCreateView has been detached from the fragment.
     */
    @Override
    public void onDestroyView() {

        // Set the binding to null
        super.onDestroyView();
        binding = null;
    }

}
package com.example.quizapp.ui.logged_in;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentLoggedInBinding;
import com.example.quizapp.db.user_management.CurrentUserData;

/**
 * <p>Created on 23.04.2025</p>
 * The LoggedInFragment class is responsible for displaying the menu for logged-in users.
 * It provides navigation options to various features of the application, such as managing
 * sets, modifying questions, and starting a quiz.
 * <p>
 * This fragment uses view binding to access its layout elements and handles user interactions
 * through button click listeners.
 *
 * @author Uboatwaffe
 * @version 1.0
 */
public class LoggedInFragment extends Fragment {

    /**
     * The binding object for the fragment.
     * Used to access the views defined in the layout file.
     */
    private FragmentLoggedInBinding binding;

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
        binding = FragmentLoggedInBinding.inflate(inflater, container, false);

        CharSequence charSequence = getResources().getText(R.string.hello_text) + ", " + CurrentUserData.getUsername() + "!";

        binding.yourLoginText.setText(charSequence);

        return binding.getRoot();
    }

    /**
     * Called immediately after the view is created.
     * Sets up click listeners for the buttons to navigate to different fragments or perform actions.
     *
     * @param view               The view returned by onCreateView.
     * @param savedInstanceState A Bundle containing the saved state of the fragment, or null if no state is saved.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up navigation to the MainMenuFragment
        binding.buttonLogOut.setOnClickListener(v -> {
            CurrentUserData.setLoggedIn(false);
            CurrentUserData.setUsername(null);

            NavHostFragment.findNavController(this)
                    .navigate(R.id.mainMenuFragment);
        });

        // Set up navigation to the ManageSetsFragment
        binding.buttonChangeSets.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.manageSetsFragment)
        );

        // Set up navigation to the ManageQuestionsFragment
        binding.buttonModifyQuestions.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.manageQuestionsFragment)
        );

        // Set up navigation to the ManageDataFragment
        binding.buttonModifyData.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.manageDataFragment)
        );

        // Set up navigation to the ClosedQuestionFragment with arguments
        binding.buttonStartQuiz.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putBoolean("first", true);
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_loggedInFragment_to_closedQuestionFragment, args);
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
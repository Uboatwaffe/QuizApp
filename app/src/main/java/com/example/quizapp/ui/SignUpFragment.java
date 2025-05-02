package com.example.quizapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentSignUpBinding;
import com.example.quizapp.db.user_management.ManageUsers;

/**
 * <p>Created on [unknown date]</p>
 * The SignUpFragment class represents the sign-up screen of the QuizApp.
 * <p>
 * This fragment allows users to create a new account. It uses view binding to access
 * its layout elements and sets up click listeners for user interactions.
 *
 * @version 1.0
 */
public class SignUpFragment extends Fragment {

    /**
     * The binding object for the fragment.
     * Used to access the views defined in the layout file.
     */
    private FragmentSignUpBinding binding;

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
        binding = FragmentSignUpBinding.inflate(inflater, container, false);

        binding.textViewError.setVisibility(View.GONE);

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

        binding.buttonSignUp.setOnClickListener(v ->{
            // Handle sign-up button click
            String username = binding.usernameFirst.getText().toString();
            String password = binding.passwordFirst.getText().toString();
            String confirmPassword = binding.passwordSecond.getText().toString();

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                // Show error message for empty fields
                binding.textViewError.setText(R.string.fill_in_all_fields);
                binding.textViewError.setVisibility(View.VISIBLE);
            } else if (!password.equals(confirmPassword)) {
                // Show error message for password mismatch
                binding.textViewError.setText(R.string.passwords_not_matching);
                binding.textViewError.setVisibility(View.VISIBLE);
            } else if (!binding.checkBoxAgreement.isChecked()) {
                binding.textViewError.setText(R.string.check_all_checkboxes);
                binding.textViewError.setVisibility(View.VISIBLE);
            } else {
                if (ManageUsers.addUser(username, password, getContext())){
                    NavHostFragment.findNavController(this)
                            .navigate(R.id.action_signUpFragment_to_loginFragment);
                }
            }
        });

        binding.buttonReturnSignUp.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_signUpFragment_to_loginFragment)
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
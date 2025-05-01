package com.example.quizapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentLoginBinding;
import com.example.quizapp.db.user_management.UserAuthentication;

/**
 * <p>Created on [unknown date]</p>
 * The LoginFragment class is responsible for managing the login screen of the application.
 * It handles user interactions such as login and navigation to the sign-up screen.
 * <p>
 * This fragment uses view binding to access its layout elements and provides basic
 * authentication functionality for demonstration purposes.
 *
 * @version 1.0
 */
public class LoginFragment extends Fragment {

    /**
     * The binding object for the fragment.
     * Used to access the views defined in the layout file.
     */
    private FragmentLoginBinding binding;

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
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Called immediately after the view is created.
     * Sets up listeners for the login and sign-up buttons and handles user authentication.
     *
     * @param view               The view returned by onCreateView.
     * @param savedInstanceState A Bundle containing the saved state of the fragment, or null if no state is saved.
     */
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setting the error text to invisible
        binding.errorText.setVisibility(View.INVISIBLE);

        // Set up a click listener for the "Sign Up" button
        binding.buttonSignup.setOnClickListener(v ->
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_loginFragment_to_signUpFragment));

        // Set up a click listener for the "Login" button
        binding.buttonLoginLogin.setOnClickListener(v -> {
            // TODO: implement user authentication

            // Retrieve the username and password from the input fields
            String username = binding.usernameInput.getText().toString();
            String password = binding.passwordInput.getText().toString();

            // Check if the user provided correct credentials (default: admin, admin)
            if (UserAuthentication.authenticateUser(
                    binding.usernameInput.getText().toString(),
                    binding.passwordInput.getText().toString(),
                    getContext())) {

                // Navigate to the logged-in fragment
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_loginFragment_to_loggedInFragment);

                // Clear the input fields
                binding.usernameInput.setText("");
                binding.passwordInput.setText("");
            } else {
                // Display an error message for invalid credentials
                binding.errorText.setText(R.string.invalid_username_or_password);
                binding.errorText.setVisibility(View.VISIBLE);
            }
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
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


/**
 * This fragment is responsible for the login screen.
 */
public class LoginFragment extends Fragment {

    /**
     * The binding object for the fragment.
     */
    private FragmentLoginBinding binding;

    /**
     * This method is called when the fragment is created.
     *
     * @param inflater           The layout inflater.
     * @param container          The view group container.
     * @param savedInstanceState The saved instance state.
     * @return The view of the fragment.
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
     * This method is called when the view is created.
     * @param view The view of the fragment.
     * @param savedInstanceState The saved instance state.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setting the error text to invisible
        binding.errorText.setVisibility(View.INVISIBLE);

        // Listeners
        binding.buttonSignup.setOnClickListener(v ->
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_loginFragment_to_signUpFragment));

        binding.buttonLoginLogin.setOnClickListener(v -> {
            // TODO: implement user authentication

            // Getting the username and password from the input fields
            String username = binding.usernameInput.getText().toString();
            String password = binding.passwordInput.getText().toString();

            // Checking whether user gave correct data (set to admin, admin)
            if (authentication(username, password)) {
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_loginFragment_to_loggedInFragment);

                // Clearing the input fields
                binding.usernameInput.setText("");
                binding.passwordInput.setText("");
            }else{

                // Showing the error text
                binding.errorText.setText(R.string.invalid_username_or_password);
                binding.errorText.setVisibility(View.VISIBLE);
            }
        });

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

    /**
     * This method is used to authenticate the user.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return True if the user is authenticated, false otherwise.
     */
    boolean authentication(String username, String password) {
        return (username.equals("admin") && password.equals("admin")) ||
                (username.isEmpty() && password.isEmpty());
    }
}
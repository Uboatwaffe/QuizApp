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



/**
 * This fragment is used to display the menu for logged-in users.
 */
public class LoggedInFragment extends Fragment {

    /**
     * The binding object for the fragment.
     */
    private FragmentLoggedInBinding binding;

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
        binding = FragmentLoggedInBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    /**
     * This method is called when the view is created.
     *
     * @param view               The view of the fragment.
     * @param savedInstanceState The saved instance state.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Listeners
        binding.buttonLogOut.setOnClickListener(v ->
            NavHostFragment.findNavController(this)
                    .navigate(R.id.mainMenuFragment)
        );

        binding.buttonChangeSets.setOnClickListener(v ->
            NavHostFragment.findNavController(this)
                    .navigate(R.id.changeSetsFragment)
        );

        binding.buttonModifyQuestions.setOnClickListener(v ->
            NavHostFragment.findNavController(this)
                    .navigate(R.id.manageQuestionsFragment)
        );

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
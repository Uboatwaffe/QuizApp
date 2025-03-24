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



/**
 * This fragment is used to test fragments unreachable during normal app usage.
 */
public class DebugFragment extends Fragment {

    /**
     * The binding object for the fragment.
     */
    private FragmentDebugBinding binding;

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
        binding = FragmentDebugBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    /**
     * This method is called when the view is created.
     * @param view The view of the fragment.
     * @param savedInstanceState The saved instance state.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Listeners
        binding.buttonProblem.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.problemFragment)
        );

        binding.buttonAbcd.setOnClickListener(v ->
                    NavHostFragment.findNavController(this)
                            .navigate(R.id.closedQuestionFragment)
        );

        binding.buttonDate.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.dateQuestionFragment)
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
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

public class MainMenuFragment extends Fragment {

    private FragmentMainMenuBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentMainMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
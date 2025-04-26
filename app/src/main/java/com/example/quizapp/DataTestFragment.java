package com.example.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentCreditsBinding;
import com.example.quizapp.databinding.FragmentDataTestBinding;
import com.example.quizapp.db.Data;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>Created on [unknown date]</p>
 * The DataTestFragment class is responsible for testing the data of the application.
 * <p>
 * This fragment uses view binding to access its layout elements and handles user interactions
 * through button click listeners.
 *
 * @version 1.0
 */
public class DataTestFragment extends Fragment {

    /**
     * The binding object for the fragment.
     * Used to access the views defined in the layout file.
     */
    private FragmentDataTestBinding binding;

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
        binding = FragmentDataTestBinding.inflate(inflater, container, false);


        binding.dataTestText.setText(Data.getData(getContext()));
        return binding.getRoot();
    }

    /**
     * Called immediately after the view is created.
     *
     * @param view               The view returned by onCreateView.
     * @param savedInstanceState A Bundle containing the saved state of the fragment, or null if no state is saved.
     */
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSaveDataTest.setOnClickListener(v ->{

            // Save the data to a file
            if(Data.setData(binding.dataTestText.getText().toString(), getContext())) {
                Toast.makeText(getContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Failed to save data", Toast.LENGTH_SHORT).show();
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
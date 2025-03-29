package com.example.quizapp.ui.logged_in;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentEditQuestionBinding;

import java.util.*;


/**
 * This fragment is used to edit and add questions.
 */
public class EditQuestionFragment extends Fragment {

    /**
     * The binding object for the fragment.
     */
    private FragmentEditQuestionBinding binding;


    /**
     * The adapter for the spinner.
     */
    private ArrayAdapter<String> adapter;

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
        binding = FragmentEditQuestionBinding.inflate(inflater, container, false);

        // Initialize the questionTypeList
        List<String> questionTypeList = List.of(
                getString(R.string.open_question),
                getString(R.string.closed_question),
                getString(R.string.date_question)
        );


        // Initialize the spinner
        adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_spinner_item,
                questionTypeList
        );

        // Set the layout for the spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter for the spinner
        binding.spinnerTypeOfQuestion.setAdapter(adapter);

        // Set correct visibility for the checkboxes and text
        Set();

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
        binding.checkBoxAbcd.setOnClickListener(v ->{
            // Update other checkboxes according to the type of question
            Update(binding.checkBoxAbcd);
        });

        binding.checkBoxTf.setOnClickListener(v ->{
            // Update other checkboxes according to the type of question
            Update(binding.checkBoxTf);
        });

        binding.checkBoxSingle.setOnClickListener(v ->{
            // Update other checkboxes according to the type of question
            Update(binding.checkBoxSingle);
        });

        binding.checkBoxMultiple.setOnClickListener(v ->{
            // Update other checkboxes according to the type of question
            Update(binding.checkBoxMultiple);
        });

        binding.spinnerTypeOfQuestion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Set correct visibility for the checkboxes and text
                Set();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void Set(){
        // Get the selected question type
        String selectedQuestionType = binding.spinnerTypeOfQuestion.getSelectedItem().toString();

        // Check if the question type is closed
        if (selectedQuestionType.equals(getString(R.string.closed_question))) {
            binding.checkBoxAbcd.setVisibility(View.VISIBLE);
            binding.checkBoxTf.setVisibility(View.VISIBLE);
            binding.closedTypeText.setVisibility(View.VISIBLE);
            ShowAbcd();
        } else {
            binding.checkBoxAbcd.setVisibility(View.GONE);
            binding.checkBoxTf.setVisibility(View.GONE);
            binding.closedTypeText.setVisibility(View.GONE);
            HideAbcd();
        }
    }

    /**
     * This method is called when any checkbox is clicked.
     *
     * @param current The current checkbox.
     */
    private void Update(CheckBox current){
        if(current == binding.checkBoxAbcd) {
            binding.checkBoxTf.setChecked(false);
            ShowAbcd();
        }else if(current == binding.checkBoxTf){
            binding.checkBoxAbcd.setChecked(false);
            HideAbcd();
        }else if(current == binding.checkBoxSingle){
            binding.checkBoxMultiple.setChecked(false);
        }else if(current == binding.checkBoxMultiple){
            binding.checkBoxSingle.setChecked(false);
        }

    }

    /**
     * This method is called to hide the abcd options.
     */
    private void HideAbcd(){
        binding.checkBoxSingle.setVisibility(View.GONE);
        binding.checkBoxMultiple.setVisibility(View.GONE);
        binding.singleOrMultipleText.setVisibility(View.GONE);
        binding.editOptionA.setVisibility(View.GONE);
        binding.editOptionB.setVisibility(View.GONE);
        binding.editOptionC.setVisibility(View.GONE);
        binding.editOptionD.setVisibility(View.GONE);
        binding.dividerHorizontal.setVisibility(View.GONE);
        binding.optionAText.setVisibility(View.GONE);
        binding.optionBText.setVisibility(View.GONE);
        binding.optionCText.setVisibility(View.GONE);
        binding.optionDText.setVisibility(View.GONE);
        binding.optionsText.setVisibility(View.GONE);
    }

    /**
     * This method is called to show the abcd options.
     */
    private void ShowAbcd(){
        binding.checkBoxSingle.setVisibility(View.VISIBLE);
        binding.checkBoxMultiple.setVisibility(View.VISIBLE);
        binding.singleOrMultipleText.setVisibility(View.VISIBLE);
        binding.editOptionA.setVisibility(View.VISIBLE);
        binding.editOptionB.setVisibility(View.VISIBLE);
        binding.editOptionC.setVisibility(View.VISIBLE);
        binding.editOptionD.setVisibility(View.VISIBLE);
        binding.dividerHorizontal.setVisibility(View.VISIBLE);
        binding.optionAText.setVisibility(View.VISIBLE);
        binding.optionBText.setVisibility(View.VISIBLE);
        binding.optionCText.setVisibility(View.VISIBLE);
        binding.optionDText.setVisibility(View.VISIBLE);
        binding.optionsText.setVisibility(View.VISIBLE);
    }

    //TODO: Force user to not leave without checking boxes

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
package com.example.quizapp.ui.questions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentAbcdQuestionBinding;



/**
 * This fragment is used to display questions with multiple choice answers.
 */
public class abcdQuestionFragment extends Fragment {

    /**
     * The binding object for the fragment.
     */
    private FragmentAbcdQuestionBinding binding;

    private EnumOfABCD type = EnumOfABCD.NONE;

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
        binding = FragmentAbcdQuestionBinding.inflate(inflater, container, false);


        return binding.getRoot();

    }

    /** @noinspection unused*/
    public void setParameters(String question, String optionA, String optionB, String optionC, String optionD, EnumOfABCD set_type) {
        // Set the text of the question and the options
        binding.questionText.setText(question);
        binding.checkBoxA.setText(optionA);
        binding.checkBoxB.setText(optionB);
        binding.checkBoxC.setText(optionC);
        binding.checkBoxD.setText(optionD);

        if(type == EnumOfABCD.MULTIPLE) {
            binding.typeOfQuestionText.setText(R.string.question_multiple_text);
        } else if (type == EnumOfABCD.SINGLE) {
            binding.typeOfQuestionText.setText(R.string.question_single_text);
        }else{

            NavHostFragment.findNavController(this)
                    .navigate(R.id.problemFragment);

        }

        // Set the type of the question
        type = set_type;
    }

    /**
     * This method is called when the view is created.
     * @param view The view of the fragment.
     * @param savedInstanceState The saved instance state.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Listeners
        binding.checkBoxA.setOnClickListener(v ->{
            // Update other checkboxes according to the type of question
            Update(binding.checkBoxA);
        });
        binding.checkBoxB.setOnClickListener(v ->{
            // Update other checkboxes according to the type of question
            Update(binding.checkBoxB);
        });
        binding.checkBoxC.setOnClickListener(v ->{
            // Update other checkboxes according to the type of question
            Update(binding.checkBoxC);
        });
        binding.checkBoxD.setOnClickListener(v ->{
            // Update other checkboxes according to the type of question
            Update(binding.checkBoxD);
        });
        binding.buttonNextQuestion.setOnClickListener(v->{

        });

    }

    private void Update(CheckBox current){
        CheckBox[] checkBoxes = new CheckBox[]{binding.checkBoxA, binding.checkBoxB, binding.checkBoxC, binding.checkBoxD};

        if (type == EnumOfABCD.SINGLE){
            for (CheckBox checkBox : checkBoxes){
                if (checkBox.isChecked() && checkBox != current){
                    checkBox.setChecked(false);
                }
            }
        }
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
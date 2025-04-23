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
import com.example.quizapp.databinding.FragmentClosedQuestionBinding;
import com.example.quizapp.db.Data;
import com.example.quizapp.db.Storage;


/**
 * This fragment is used to display questions with single/multiple/true or false choice answers.
 */
public class ClosedQuestionFragment extends Fragment {

    /**
     * The binding object for the fragment.
     */
    private FragmentClosedQuestionBinding binding;

    /**
     * Type of ABCD question (single or multiple).
     */
    private EnumOfABCD ABCD_type = EnumOfABCD.NONE;

    /**
     * Type of question (ABCD or true/false).
     */
    private ClosedTypes question_type = ClosedTypes.NONE;

    /**
     * Array of checkboxes. (not initialized yet)
     */
    private CheckBox[] checkBoxes;


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
        binding = FragmentClosedQuestionBinding.inflate(inflater, container, false);

        // Get the checkboxes (used by the Update method)
        checkBoxes = new CheckBox[]{binding.checkBoxA, binding.checkBoxB, binding.checkBoxC, binding.checkBoxD};

        // Get the arguments from the bundle
        Bundle args = getArguments();
        boolean first = args.getBoolean("first");


        if(first){
            Storage.setNew();
        }

        NextQuestion();

        return binding.getRoot();

    }

    /**
     * Sets parameters.
     *
     * @param question          the question
     * @param optionA           the option a (or true)
     * @param optionB           the option b (or false)
     * @param optionC           the option c (or null)
     * @param optionD           the option d (or null)
     * @param correctAns        the correct ans
     * @param question_type_new the question type new (abcd or true/false)
     * @param ABCD_type_new     the abcd type new (single or multiple)
     * @noinspection unused
     */
    private void setParameters(String question, String optionA, String optionB, String optionC, String optionD, String correctAns, ClosedTypes question_type_new, EnumOfABCD ABCD_type_new) {
        ABCD_type = ABCD_type_new;
        question_type = question_type_new;

        // Set the text of the question and the options
        if (question_type == ClosedTypes.ABCD){
            // Setting the text of the question and the options
            binding.questionText.setText(question);
            binding.checkBoxA.setText(optionA);
            binding.checkBoxB.setText(optionB);
            binding.checkBoxC.setText(optionC);
            binding.checkBoxD.setText(optionD);

            // Setting the visibility of the checkboxes
            binding.checkBoxC.setVisibility(View.VISIBLE);
            binding.checkBoxD.setVisibility(View.VISIBLE);
            binding.typeOfQuestionText.setVisibility(View.VISIBLE);

            // Adjusting the text according to the type of question (single or multiple)
            if(ABCD_type == EnumOfABCD.MULTIPLE) {
                binding.typeOfQuestionText.setText(R.string.question_multiple_text);
            } else if (ABCD_type == EnumOfABCD.SINGLE) {
                binding.typeOfQuestionText.setText(R.string.question_single_text);
            }else{
                // If the type of question is not valid, navigate to the problem fragment
                NavHostFragment.findNavController(this)
                        .navigate(R.id.problemFragment);
            }

        } else if (question_type == ClosedTypes.TRUE_FALSE){
            // Setting the text of the question and the options
            binding.questionText.setText(question);
            binding.checkBoxA.setText(R.string.option_true);
            binding.checkBoxB.setText(R.string.option_false);

            // Setting the visibility of the checkboxes and the type of question text
            binding.checkBoxC.setVisibility(View.GONE);
            binding.checkBoxD.setVisibility(View.GONE);
            binding.typeOfQuestionText.setVisibility(View.GONE);
        } else {
            // If the type of question is not valid, navigate to the problem fragment
            NavHostFragment.findNavController(this)
                    .navigate(R.id.problemFragment);
        }
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
            // TODO: Check if the answer is correct and if there are more questions
            //noinspection ConstantValue
            if(true){
                Storage.setNew();
                NextQuestion();
            }
        });

    }

    /**
     * This method is used to get the next question from the database.
     */
    private void NextQuestion(){


        if (Storage.questionType == QuestionType.CLOSED) {
            // Set the parameters of the question
            setParameters(Storage.question, Storage.optionA, Storage.optionB, Storage.optionC, Storage.optionD, Storage.correctAnswer, Storage.closedType, Storage.ABCDType);
        } else if (Storage.questionType == QuestionType.OPEN) {
            new Storage.Builder(Storage.question, Storage.correctAnswer, Storage.questionType).build();

            NavHostFragment.findNavController(this)
                    .navigate(R.id.openQuestionFragment);
        } else if (Storage.questionType == QuestionType.DATE) {
            new Storage.Builder(Storage.question, Storage.correctAnswer, Storage.questionType).build();

            NavHostFragment.findNavController(this)
                    .navigate(R.id.dateQuestionFragment);
        }

        // Uncheck all checkboxes
        for (CheckBox checkBox : checkBoxes){
            if (checkBox.isChecked()){
                checkBox.setChecked(false);
            }
        }
    }

    /**
     * This method is called when a checkbox is clicked.
     * If the type is single or true/false, it unchecks all other checkboxes.
     * @param current The current checkbox.
     */
    private void Update(CheckBox current){

        if (ABCD_type == EnumOfABCD.SINGLE || question_type == ClosedTypes.TRUE_FALSE){
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
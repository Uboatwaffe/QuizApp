package com.example.quizapp.ui.logged_in;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quizapp.R;
import com.example.quizapp.databinding.FragmentManageQuestionsBinding;
import com.example.quizapp.db.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * This fragment is used to manage questions.
 */
public class ManageQuestionsFragment extends Fragment {

    /**
     * The binding object for the fragment.
     */
    private FragmentManageQuestionsBinding binding;

    /**
     * The selected question.
     */
    private String selectedQuestion;

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
        binding = FragmentManageQuestionsBinding.inflate(inflater, container, false);

        // Initialize the list
        List<String> setsList = new ArrayList<>(Data.questionList);

        // Initialize the spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_spinner_item,
                setsList
        );

        // Set the layout for the spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter for the spinner
        binding.spinnerQuestions.setAdapter(adapter);

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
        binding.buttonExit.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_manageQuestionsFragment_to_loggedInFragment));

        binding.buttonAdd.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("action", "add");
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_manageQuestionsFragment_to_editQuestionFragment, bundle);
        });

        binding.spinnerQuestions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedQuestion = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedQuestion = null;
            }
        });

        binding.buttonEdit.setOnClickListener(v -> {
            if (selectedQuestion != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("question_id", Integer.parseInt(selectedQuestion));
                bundle.putString("action", "edit");
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_manageQuestionsFragment_to_editQuestionFragment, bundle);
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

}
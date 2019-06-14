package com.ivanbudos.kvizkolegija;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.Delayed;


/**
 * A simple {@link Fragment} subclass.
 */
public class StartQuizFragment extends Fragment {


private TextView questionTextView;
private TextView scoreTextView;
private Button confirmAnswerButton;
int myInt;


    public StartQuizFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_quiz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        questionTextView = view.findViewById(R.id.textViewQuestion);
        scoreTextView = view.findViewById(R.id.textViewScore);
        confirmAnswerButton = view.findViewById(R.id.buttonConfirmNext);



        /*GenerateQuiz mquiz = new GenerateQuiz(myInt);*/
        Bundle bundle = this.getArguments();
        if (bundle != null) {
             myInt = bundle.getInt("quiz");
        }

        GenerateQuiz mquiz = new GenerateQuiz(myInt);
        //mquiz.getQuiz()[0].getQuestion();
       questionTextView.setText(mquiz.getQuiz()[0].getQuestion());




    }



}

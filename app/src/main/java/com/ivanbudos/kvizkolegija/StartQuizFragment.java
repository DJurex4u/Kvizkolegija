package com.ivanbudos.kvizkolegija;


import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Delayed;


/**
 * A simple {@link Fragment} subclass.
 */
public class StartQuizFragment extends Fragment {


private TextView questionTextView;
private TextView scoreTextView;
private Button confirmAnswerButton;
private TextView countDownTextView;
private RadioGroup radioGroup;
private RadioButton rButton1;
private RadioButton rButton2;
private RadioButton rButton3;
private RadioButton rButton4;
int myInt;

private ColorStateList textColorDefaultRb;
private int questionCounter = 0;
private int questionCountTotal;
private QuestionModel currentQuestion;

private int score;
private boolean answered;
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
        countDownTextView = view.findViewById(R.id.textViewQuestionCount);
        radioGroup = view.findViewById(R.id.radioGroup);
        rButton1 = view.findViewById(R.id.radioButton1);
        rButton2 = view.findViewById(R.id.radioButton2);
        rButton3 = view.findViewById(R.id.radioButton3);
        rButton4 = view.findViewById(R.id.radioButton4);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
             myInt = bundle.getInt("quiz");
        }

        GenerateQuiz mquiz = new GenerateQuiz(myInt);
        textColorDefaultRb = rButton1.getTextColors();
        questionCountTotal = mquiz.getQuiz().length;
        //mquiz.ShuffleQuiz();            // KASNIJE PROBAJ SHUFFLEAT DA VIDIŠ JEL RADI



        //mquiz.getQuiz()[questionCounter].getQuestion();
        //questionTextView.setText(mquiz.getQuiz()[0].getQuestion());
        ShowNextQuestion(mquiz);

        confirmAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered){
                    if ((rButton1.isChecked())||(rButton2.isChecked())||(rButton3.isChecked())||(rButton4.isChecked())){
                        ChechAnswer();
                    } else {
                                                        /*PROBLEEEEM */
                        Toast.makeText(getActivity(), "Odaberite jedan od ponuđenih odgovora.", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

    private void ShowNextQuestion(GenerateQuiz mquiz){
        rButton1.setTextColor(textColorDefaultRb);
        rButton2.setTextColor(textColorDefaultRb);
        rButton3.setTextColor(textColorDefaultRb);
        rButton4.setTextColor(textColorDefaultRb);
        radioGroup.clearCheck();


        if (questionCounter < questionCountTotal){

            currentQuestion = mquiz.getQuiz()[0];
            rButton1.setText(currentQuestion.getPosibleAnswers()[0]);
            rButton2.setText(currentQuestion.getPosibleAnswers()[1]);
            rButton3.setText(currentQuestion.getPosibleAnswers()[2]);
            rButton4.setText(currentQuestion.getPosibleAnswers()[3]);
            questionTextView.setText(currentQuestion.getQuestion());

            questionCounter ++;
            countDownTextView.setText("Pitanje: " +questionCounter +"/"+ questionCountTotal );
            answered = false;
            confirmAnswerButton.setText("Potvrdi");
        } else finishQuiz();
    }

    private void finishQuiz(){

    }

    private void ChechAnswer(){}

}

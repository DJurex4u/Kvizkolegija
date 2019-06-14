package com.ivanbudos.kvizkolegija;


import android.content.res.ColorStateList;
import android.graphics.Color;
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
public GenerateQuiz mquiz;

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
        //RadioButton sadf = view.findViewById(radioGroup.getCheckedRadioButtonId());


        Bundle bundle = this.getArguments();
        if (bundle != null) {
             myInt = bundle.getInt("quiz");
        }
        mquiz = new GenerateQuiz(myInt);
        textColorDefaultRb = rButton1.getTextColors();
        questionCountTotal = mquiz.getQuiz().length;
        //mquiz.ShuffleQuiz();// KASNIJE PROBAJ SHUFFLEAT DA VIDIŠ JEL RADI



        //mquiz.getQuiz()[questionCounter].getQuestion();
        //questionTextView.setText(mquiz.getQuiz()[0].getQuestion());
        ShowNextQuestion();

        confirmAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered){
                    if ((rButton1.isChecked())||(rButton2.isChecked())||(rButton3.isChecked())||(rButton4.isChecked())){
                        CheckAnswer();
                    } else {                                                       /*PROBLEEEEM */
                        Toast.makeText(getActivity(), "Odaberite jedan od ponuđenih odgovora.", Toast.LENGTH_SHORT).show();
                    }
                } else { ShowNextQuestion();}
            }
        });
    }//izvan Created:

    private void ShowNextQuestion(){
        rButton1.setTextColor(textColorDefaultRb);
        rButton2.setTextColor(textColorDefaultRb);
        rButton3.setTextColor(textColorDefaultRb);
        rButton4.setTextColor(textColorDefaultRb);
        radioGroup.clearCheck();


        if (questionCounter < questionCountTotal ){

            currentQuestion = mquiz.getQuiz()[questionCounter];
            rButton1.setText(currentQuestion.getPosibleAnswers()[0]);
            rButton2.setText(currentQuestion.getPosibleAnswers()[1]);
            rButton3.setText(currentQuestion.getPosibleAnswers()[2]);
            rButton4.setText(currentQuestion.getPosibleAnswers()[3]);
            questionTextView.setText(currentQuestion.getQuestion());

            questionCounter ++;
            countDownTextView.setText("Pitanje: " +questionCounter +"/"+ questionCountTotal );
            answered = false;
            confirmAnswerButton.setText("Potvrdi");
        } else {
            finishQuiz();
        }


    }



    private void CheckAnswer(){
        answered = true;
                            // jeeej :D napokon valja
        RadioButton rbSelected = getView().findViewById(radioGroup.getCheckedRadioButtonId());

        int answerNum = radioGroup.indexOfChild(rbSelected) +1;
        //samoprovjera pokazuje li dobro
        //Toast.makeText(getActivity(), String.valueOf(answerNum ), Toast.LENGTH_SHORT).show();

        if (answerNum == currentQuestion.getRightAnswer()){
            score++;
            scoreTextView.setText("Score: "+score);
        }
        ShowSolution();
    }

    private void ShowSolution(){

        rButton1.setTextColor(Color.RED);
        rButton2.setTextColor(Color.RED);
        rButton3.setTextColor(Color.RED);
        rButton4.setTextColor(Color.RED);


        switch (currentQuestion.getRightAnswer()){
            case 1:
                rButton1.setTextColor(Color.GREEN);
                questionTextView.setText("Odgovor 1 je točan!");
                break;
            case 2:
                rButton2.setTextColor(Color.GREEN);
                questionTextView.setText("Odgovor 2 je točan!");
                break;
            case 3:
                rButton3.setTextColor(Color.GREEN);
                questionTextView.setText("Odgovor 3 je točan!");
                break;
            case 4:
                rButton4.setTextColor(Color.GREEN);
                questionTextView.setText("Odgovor 4 je točan!");
                break;
        }

        if (questionCounter < questionCountTotal){
            confirmAnswerButton.setText("Sljedeće pitanje");
        }else{
            confirmAnswerButton.setText("Završi kviz");
        }

    }

    private void finishQuiz(){
        getActivity().finish();
    }

}

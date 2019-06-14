package com.ivanbudos.kvizkolegija;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
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
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Delayed;


/**
 * A simple {@link Fragment} subclass.
 */
public class StartQuizFragment extends Fragment {

private static final long COUNTDOWN_IN_MILLIS = 30000;

private TextView questionTextView;
private TextView scoreTextView;
private Button confirmAnswerButton;

private TextView questionCountTextView;
private TextView countDownTextView;

private RadioGroup radioGroup;
private RadioButton rButton1;
private RadioButton rButton2;
private RadioButton rButton3;
private RadioButton rButton4;

int myInt;
long timeLeftInMillis;
public GenerateQuiz mquiz;

private ColorStateList textColorDefaultRb;
private ColorStateList textColorDefaultTimer;

private CountDownTimer countDownTimer;

private int questionCounter = 0;
private int questionCountTotal;
private QuestionModel currentQuestion;

private int score = 0;
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
        questionCountTextView = view.findViewById(R.id.textViewQuestionCount);
        countDownTextView = view.findViewById(R.id.textViewCountdown);
        radioGroup = view.findViewById(R.id.radioGroup);
        rButton1 = view.findViewById(R.id.radioButton1);
        rButton2 = view.findViewById(R.id.radioButton2);
        rButton3 = view.findViewById(R.id.radioButton3);
        rButton4 = view.findViewById(R.id.radioButton4);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
             myInt = bundle.getInt("quiz");        }
        mquiz = new GenerateQuiz(myInt);

        textColorDefaultRb = rButton1.getTextColors();
        textColorDefaultTimer = countDownTextView.getTextColors();

        questionCountTotal = mquiz.getQuiz().length;
        //mquiz.ShuffleQuiz();// KASNIJE PROBAJ SHUFFLEAT DA VIDIŠ JEL RADI
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
            questionCountTextView.setText("Pitanje: " +questionCounter +"/"+ questionCountTotal );
            answered = false;
            confirmAnswerButton.setText("Potvrdi");
            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            StartCountDown();
        } else {
            finishQuiz();
        }
    }



    private void StartCountDown(){

        countDownTimer = new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                UpdateCountDownTextView();
            }
            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                UpdateCountDownTextView();
                CheckAnswer();
            }
        }.start();
    }


    private void UpdateCountDownTextView(){

        int minutes = (int) (timeLeftInMillis/1000)/60;
        int seconds = (int) (timeLeftInMillis/1000)%60;

        String timeFormated = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        countDownTextView.setText(timeFormated);

        if(timeLeftInMillis < 10000){

            countDownTextView.setTextColor(Color.RED);
        }else{
            countDownTextView.setTextColor(textColorDefaultTimer);
        }
    }



    private void CheckAnswer(){


            countDownTimer.cancel();
            answered = true;                            // jeeej :D napokon valja
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

        radioGroup.setVisibility(View.INVISIBLE);
        questionCountTextView.setVisibility(View.INVISIBLE);
        countDownTextView.setVisibility(View.INVISIBLE);

        questionTextView.setText("OSVOJIO SI: "+score+" OD "+questionCountTotal+" BODOVA!");
        confirmAnswerButton.setText("Natrag na početni izbornik");
        confirmAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuFragment menuFragment = new MenuFragment();
                getFragmentManager().beginTransaction().replace(R.id.container,menuFragment).commit();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null){
            countDownTimer.cancel();
        }
    }
}

package com.ivanbudos.kvizkolegija;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View;
import android.support.v4.app.FragmentManager;



/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    Button quiz1Button,quiz2Button,quiz3Button,quiz4Button;
    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);

       /* quiz1Button = (Button) findViewById(R.id.buttonQuiz1);
        quiz2Button = (Button) findViewById(R.id.buttonQuiz2);
        quiz3Button = (Button) findViewById(R.id.radioButton3);
        quiz4Button = (Button) findViewById(R.id.radioButton4);


        quiz1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StartQuizFragment StartQuiz = new StartQuizFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.container, StartQuiz).commit();

            }
        });*/
    }

}

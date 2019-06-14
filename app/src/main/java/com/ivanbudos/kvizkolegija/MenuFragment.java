package com.ivanbudos.kvizkolegija;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View;
import android.support.v4.app.FragmentManager;
/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment{

    private Button quiz1Button;
    private Button quiz2Button;
    private Button quiz3Button;
    private Button quiz4Button;




    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        quiz1Button = view.findViewById(R.id.buttonQuiz1);
        quiz2Button = view.findViewById(R.id.buttonQuiz2);
        quiz3Button = view.findViewById(R.id.buttonQuiz3);
        quiz4Button = view.findViewById(R.id.buttonQuiz4);
        setUpListeners();
    }

    private void setUpListeners(){
        quiz1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StartQuizFragment StartQuiz = new StartQuizFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("quiz",1);
                StartQuiz.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container, StartQuiz).commit();

            }
        });

        quiz2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartQuizFragment StartQuiz = new StartQuizFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("quiz",2);
                StartQuiz.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container, StartQuiz).commit();
            }
        });

        quiz3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartQuizFragment StartQuiz = new StartQuizFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("quiz",3);
                StartQuiz.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container, StartQuiz).commit();
            }
        });



        quiz4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartQuizFragment StartQuiz = new StartQuizFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("quiz",4);
                StartQuiz.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container, StartQuiz).commit();
            }
        });
    }
}

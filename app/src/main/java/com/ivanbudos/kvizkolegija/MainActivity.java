package com.ivanbudos.kvizkolegija;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;

public class MainActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          MenuFragment Menu = new MenuFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, Menu).commit();


    }


}

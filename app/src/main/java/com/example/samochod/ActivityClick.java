package com.example.samochod;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


public class ActivityClick extends AppCompatActivity {
    String s1[], s2[];
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        s1 = getResources().getStringArray(R.array.car_brand);
//        recyclerView = findViewById(R.id.recyclerView);


    }

}
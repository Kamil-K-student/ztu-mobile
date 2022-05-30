package com.example.samochod;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListCar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_car);

        ListView listview = findViewById(R.id.listview);

        List<Object> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        Car ford = new Car(1, "Ford", "Mondeo",
                "@drawable/ic_launcher_background.xml");
        list.add(ford);
        list1.add(ford.getBrand() + " " + ford.getModel());


        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list1);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    startActivity(new Intent(ListCar.this, ActivityClick.class));
                }else if (position==1) {
                    startActivity(new Intent(ListCar.this, ActivityClick.class));
                }
            }
        });

    }
}

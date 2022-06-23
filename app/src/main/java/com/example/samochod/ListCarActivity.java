package com.example.samochod;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListCarActivity extends AppCompatActivity {

    private ArrayList<Car> cars;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_car);
        recyclerView = findViewById(R.id.recyclerView);
        cars = new ArrayList<>();

        cars.add(new Car(10, "Audi", "A3"));
        setAdapter();
    }

    private void setAdapter(){
        CarListAdapter adapter = new CarListAdapter(cars);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}

package com.example.samochod;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListCar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_car);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        List<Object> listCar = new ArrayList<>();
        List<String> listOfBrands = new ArrayList<>();
        List<String> listOfModels = new ArrayList<>();
        List<String> listOfPictures = new ArrayList<>();

//        String[] listOfBrands1, listOfModels1, listOfPictures1;



        Car ford = new Car(1, "Ford", "Mondeo",
                "@drawable/ford.jpg");
        listCar.add(ford);
        listOfBrands.add(ford.getBrand());
        listOfModels.add(ford.getModel());
        listOfPictures.add(ford.getPicture());

        Car clio = new Car (2,"Renault", "Clio", "@drawable/ford.jpg");
        listCar.add(clio);
        listOfBrands.add(clio.getBrand());
        listOfModels.add(clio.getModel());
        listOfPictures.add(clio.getPicture());

        Car audi = new Car (2,"Audi", "A3", "@drawable/ford.jpg");
        listCar.add(audi);
        listOfBrands.add(audi.getBrand());
        listOfModels.add(audi.getModel());
        listOfPictures.add(audi.getPicture());

        int listOfPictures1[] = {R.drawable.ford, R.drawable.ford, R.drawable.ford};

        String[] listOfBrands1 = {"Ford", "Audi", "Citroen"}; //listOfBrands.toArray(new String[0]);
        String[] listOfModels1 = {"Ford", "Audi", "Citroen"}; //listOfModels.toArray(new String[0]);

        MyAdapter myAdapter = new MyAdapter(this, listOfBrands1, listOfModels1, listOfPictures1);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));








    }
}

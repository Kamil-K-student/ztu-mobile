package com.example.samochod;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddCarActivity extends AppCompatActivity {

    String isEmpty = "Uzupełnij wszystkie pola";
    String error = "Operacja zakończona niepowodzeniem";
    String added = "Dodano pojazd: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        RetrofitService retrofitService = new RetrofitService();
        CarApi carApi = retrofitService.getRetrofit().create(CarApi.class);

        Button addBtn = findViewById(R.id.addBtn);
        EditText brandETxt = findViewById(R.id.modelTxt);
        EditText modeETxt = findViewById(R.id.brandTxt);
        brandETxt.setText(null);
        modeETxt.setText(null);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String brand = brandETxt.getText().toString();
                String model = modeETxt.getText().toString();

                if (brand.isEmpty() || model.isEmpty()){

                    Toast.makeText(AddCarActivity.this, isEmpty, Toast.LENGTH_LONG).show();

                } else {

                    Car carNew = new Car(brand, model);
                    carApi.postCar(carNew).enqueue(new Callback<Car>() {
                        @Override
                        public void onResponse(Call<Car> call, Response<Car> response) {
                            Toast.makeText(AddCarActivity.this, added + brand + " " + model, Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<Car> call, Throwable t) {
                            Toast.makeText(AddCarActivity.this, error, Toast.LENGTH_LONG).show();
                            brandETxt.setText(null);
                            modeETxt.setText(null);
                        }
                    });}
            }
        });}}

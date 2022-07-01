package com.example.samochod;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String brand = getIntent().getStringExtra("brand");
        System.out.println("dcccccccccccccccccccc" + brand);
        String model = getIntent().getStringExtra("model");
        System.out.println(model);
        Integer id = getIntent().getIntExtra("id", 0);
        System.out.println(id);
        EditText brandTxt = findViewById(R.id.brandTxt);
        EditText modelTxt = findViewById(R.id.modelTxt);
        brandTxt.setText(brand);
        modelTxt.setText(model);

        Button deleteBtn = findViewById(R.id.deleteBtn);

        RetrofitService retrofitService = new RetrofitService();
        CarApi carApi = retrofitService.getRetrofit().create(CarApi.class);


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<Void> call = carApi.deleteCar(id);
                System.out.println(id);
                System.out.println(brand);
                System.out.println(model);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        Toast.makeText(DetailsActivity.this, "Usunięto" + brand + " " + model, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                        Toast.makeText(DetailsActivity.this, "Błąd usuwania ", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        Button update = findViewById(R.id.updateBtn);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<Void> call = carApi.deleteCar(id);
                System.out.println(id);
                System.out.println(brand);
                System.out.println(model);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                        Toast.makeText(DetailsActivity.this, "Błąd operacji ", Toast.LENGTH_SHORT).show();
                    }
                });

                String brandSec;
                String modelSec;
                EditText brandTxt = findViewById(R.id.brandTxt);
                EditText modelTxt = findViewById(R.id.modelTxt);
                brandSec = brandTxt.getText().toString();
                modelSec = modelTxt.getText().toString();

                if (brandSec.isEmpty() || modelSec.isEmpty()){

                    Toast.makeText(DetailsActivity.this, "Uzupełnij", Toast.LENGTH_LONG).show();

                } else {

                    Car carNew = new Car(brandSec, modelSec);
                    carApi.postCar(carNew).enqueue(new Callback<Car>() {
                        @Override
                        public void onResponse(Call<Car> call, Response<Car> response) {
                            Toast.makeText(DetailsActivity.this, "Zaktualizowano " + brandSec + " " + modelSec, Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<Car> call, Throwable t) {
                            Toast.makeText(DetailsActivity.this, "Błąd aktualizacji", Toast.LENGTH_LONG).show();
                        }
                    });}

            }
        });

        Button addNew = findViewById(R.id.addBtn);
        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this, AddCarActivity.class);
                startActivity(intent);
            }
        });
    }
}

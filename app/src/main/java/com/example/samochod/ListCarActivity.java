package com.example.samochod;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCarActivity extends AppCompatActivity implements RecyclerViewInterface {

    private ArrayList<Car> carsList;
    private RecyclerView recyclerView;
    String error = "Bład odczytu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_car);
        recyclerView = findViewById(R.id.recyclerView);
        carsList = new ArrayList<>();

        RetrofitService retrofitService = new RetrofitService();
        CarApi carApi = retrofitService.getRetrofit().create(CarApi.class);
        Call<List<Car>> callArray = carApi.getAllCars();

        callArray.enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(@NonNull Call<List<Car>> call, @NonNull Response<List<Car>> response) {

                if (response.isSuccessful()) {
                    List<Car> cars = response.body();

                    assert cars != null;
                    for (Car car : cars){
                        carsList.add(new Car(car.getId(), car.getBrand(), car.getModel()));

                        if(carsList.size() == 0){
                            Intent intent = new Intent(ListCarActivity.this, AddCarActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
                setAdapter();
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {

                Toast.makeText(ListCarActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });

    }



    private void setAdapter(){
        CarListAdapter adapter = new CarListAdapter(carsList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);

        intent.putExtra("brand", carsList.get(position).getBrand());
        System.out.println(carsList.get(position).getBrand());
        intent.putExtra("model", carsList.get(position).getModel());
        System.out.println(carsList.get(position).getModel());
        intent.putExtra("id", carsList.get(position).getId());
        System.out.println(carsList.get(position).getId());

        startActivity(intent);
    }
}

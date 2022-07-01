package com.example.samochod;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CarApi {

    @GET("/car/all")
    Call<List<Car>> getAllCars();

    @GET("/car/get/{id}")
    Call<Car> getCar();

    @POST("/car/post")
    Call<Car> postCar(@Body Car car);

    @DELETE("/car/delete/{id}")
    Call<Void> deleteCar(@Path("id") Integer id);

    @PUT("/car/put/{id}")
    Call<Car> updateCar(@Path("id") Integer id, @Body Car car);

}

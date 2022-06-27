package com.example.samochod;

public class Car {

    private int id;
    private String brand;
    private String model;
    private String picture;

    Car(Integer id, String brand, String model){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getPicture() {
        return picture;
    }

    public String getModel() {
        return model;
    }

    public String getInformation(){
        return brand + " " + model;
    }

}

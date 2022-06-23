package com.example.samochod;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarListHolder> {

    private ArrayList<Car> carList;

    public CarListAdapter(ArrayList<Car> carList){
        this.carList = carList;
    }

    @NonNull
    @Override
    public CarListAdapter.CarListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new CarListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarListAdapter.CarListHolder holder, int position) {
        String name = carList.get(position).getBrand();
        holder.textViewBrand.setText(name);
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public static class CarListHolder extends RecyclerView.ViewHolder {
        TextView textViewBrand, textViewModel;
        ImageView imageViewCar;

        public CarListHolder(@NonNull View itemView) {
            super(itemView);
            textViewBrand = itemView.findViewById(R.id.textViewBrand);
            textViewModel = itemView.findViewById(R.id.textViewModel);
//            imageViewCar = itemView.findViewById(R.id.imageViewCar);
        }
    }
}

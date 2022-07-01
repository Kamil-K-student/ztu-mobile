package com.example.samochod;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarListHolder> {

    private final ArrayList<Car> carList;
    private final RecyclerViewInterface recyclerViewInterface;

    public CarListAdapter(ArrayList<Car> carList, RecyclerViewInterface recyclerViewInterface){
        this.carList = carList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public CarListAdapter.CarListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new CarListHolder(itemView, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull CarListAdapter.CarListHolder holder, int position) {
        String name = carList.get(position).getBrand();
        String name2 = carList.get(position).getModel();
        Integer name3 = carList.get(position).getId();
        holder.textViewBrand.setText(name);
        holder.textViewModel.setText(name2);
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public static class CarListHolder extends RecyclerView.ViewHolder{
        TextView textViewBrand, textViewModel;

        public CarListHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            textViewBrand = itemView.findViewById(R.id.textViewBrand);
            textViewModel = itemView.findViewById(R.id.textViewModel);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int pos = getBindingAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }}}});
        }}}
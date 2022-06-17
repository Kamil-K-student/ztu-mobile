package com.example.samochod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public MyAdapter(Context ct, String s1[], String s2[], int img[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textViewBrand.setText(data1[position]);
        holder.textViewModel.setText(data2[position]);
        holder.imageViewCar.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewBrand, textViewModel;
        ImageView imageViewCar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewBrand = itemView.findViewById(R.id.textViewBrand);
            textViewModel = itemView.findViewById(R.id.textViewModel);
            imageViewCar = itemView.findViewById(R.id.imageViewCar);
        }
    }
}

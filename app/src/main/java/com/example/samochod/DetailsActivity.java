package com.example.samochod;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String brand = getIntent().getStringExtra("brand");
        String model = getIntent().getStringExtra("model");
        EditText brandTxt = findViewById(R.id.brandTxt);
        EditText modelTxt = findViewById(R.id.modelTxt);
        brandTxt.setText(brand);
        modelTxt.setText(model);

        Button deleteBtn = findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button update = findViewById(R.id.updateBtn);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button addNew = findViewById(R.id.addBtn);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this, WelcomeActivity.class);
                startActivity(intent);
            }
        });
    }
}

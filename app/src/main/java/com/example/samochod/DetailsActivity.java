package com.example.samochod;

import android.os.Bundle;
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
    }
}

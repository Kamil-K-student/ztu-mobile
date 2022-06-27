package com.example.samochod;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginBtn = findViewById(R.id.btnLogin);
        TextView regTxtView = findViewById(R.id.toRegisterBtn);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            finish();
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        regTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void loginUser(){
        EditText emailETxt = findViewById(R.id.emailETxt);
        EditText passRTxt = findViewById(R.id.passETxt);

        String pass = passRTxt.getText().toString();
        String email = emailETxt.getText().toString();
        String isEmpty = "Uzupełnij wszystkie pola";
        String error = "Błąd uwierzytelniania";

        if(pass.isEmpty() || email.isEmpty()){

            Toast.makeText(this, isEmpty, Toast.LENGTH_LONG).show();

        } else {

            firebaseAuth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });}
        emailETxt.setText(null);
        passRTxt.setText(null);
    }
}

package com.example.samochod;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.*;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import java.util.concurrent.Executor;


public class MainActivity extends AppCompatActivity {

    String authError = "Błąd uwierzytelniania: ";
    String authSucceeded = "Zakończono sukcesem";
    String authFiled = "Zakończono niepowodzeniem";
    String titlePrompt = "Uwierzytelnianie biometryczne";
    String btnPrompt = "Zakończ";
    Button nextBtn;
    Executor executor;
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextBtn = findViewById(R.id.authBioBtn);
        firebaseAuth = FirebaseAuth.getInstance();

        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(MainActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(getApplicationContext(), authError + errString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);

                if (firebaseAuth.getCurrentUser() != null) {
                    openWelcomeActivity();
                } else {
                    openLoginActivity();
                    Toast.makeText(getApplicationContext(), authSucceeded, Toast.LENGTH_SHORT).show();
                }
                finish();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(getApplicationContext(), authFiled, Toast.LENGTH_SHORT).show();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle(titlePrompt)
                .setNegativeButtonText(btnPrompt).build();

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                biometricPrompt.authenticate(promptInfo);
            }
        });
    }

    void openLoginActivity(){
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    void openWelcomeActivity(){
        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
        startActivity(intent);
    }
}

package com.example.samochod;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.*;
import androidx.core.content.ContextCompat;
import android.content.Intent;

import android.os.Bundle;
import android.widget.Toast;

import java.util.concurrent.Executor;

import static androidx.biometric.BiometricManager.Authenticators.*;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToNext();
        Executor executor = ContextCompat.getMainExecutor(this);
        BiometricPrompt biometricPrompt = new BiometricPrompt(MainActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(getApplicationContext(),
                                "Authentication error: " + errString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(),
                        "Authentication succeeded!" , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(getApplicationContext(), "Authentication failed", Toast.LENGTH_SHORT).show();
            }
        });

        BiometricPrompt.PromptInfo.Builder promptInfo = promptInfo();
        promptInfo.setNegativeButtonText("Cancel");
        biometricPrompt.authenticate(promptInfo.build());

    }

    BiometricPrompt.PromptInfo.Builder promptInfo()
    {
        return new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric login")
                .setSubtitle("Log in using your biometric credential");
    }

    void goToNext()
    {
        BiometricManager manager = BiometricManager.from(this);
        switch (manager.canAuthenticate(BIOMETRIC_WEAK | BIOMETRIC_STRONG))
        {
            case BiometricManager.BIOMETRIC_SUCCESS:
                Intent intent = new Intent(this, ListCar.class);
                startActivity(intent);
                break;
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                break;
            default:

        }

    }

}

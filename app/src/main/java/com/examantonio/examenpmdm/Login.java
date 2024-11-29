package com.examantonio.examenpmdm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.loginButton);
        TextInputLayout loginUsernameTIL = findViewById(R.id.loginUsernameTIL);
        TextInputLayout loginPasswordTIL = findViewById(R.id.loginPasswordTIL);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = String.valueOf(loginUsernameTIL.getEditText().getText()).trim();
                String userPassword = "examenpmdm".trim();

                // Validación de campos vacíos
                if (userName.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor, ingrese su nombre de usuario", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (userPassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Por favor, ingrese su contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Verificación de credenciales
                SharedPreferences preferences = getSharedPreferences("Usuario", MODE_PRIVATE);
                String savedUsername = preferences.getString("username", userName);
                String savedPassword = preferences.getString("password", userPassword);

                if (userName.equals(savedUsername) && userPassword.equals(savedPassword)) {
                    launchMain();
                } else {
                    Toast.makeText(getApplicationContext(), "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void launchMain() {
        Intent intent = new Intent(Login.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}

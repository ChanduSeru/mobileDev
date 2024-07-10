package com.example.vehicle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    private EditText username_register, email_register, password_register;
    private Button btn_register, btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username_register = findViewById(R.id.username_register);
        email_register = findViewById(R.id.email_register);
        password_register = findViewById(R.id.password_register);
        btn_register = findViewById(R.id.btn_register);
        btnback = findViewById(R.id.btnback);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void register() {
        String username = username_register.getText().toString().trim();
        String email = email_register.getText().toString().trim();
        String password = password_register.getText().toString().trim();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(Register.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
          
            saveUserCredentials(username, password);

            Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();


            Intent intent = new Intent(Register.this, Home.class);
            startActivity(intent);
            finish();
        }
    }


    private void saveUserCredentials(String username, String password) {

    }
}

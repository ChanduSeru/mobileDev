package com.example.vehicle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText username_login, pswd_login;
    private Button login_btnlog, login_regbtn, login_btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username_login = findViewById(R.id.username_login);
        pswd_login = findViewById(R.id.pswd_login);
        login_btnlog = findViewById(R.id.login_btnlog);
        login_btnback = findViewById(R.id.login_btnback);
        login_regbtn = findViewById(R.id.login_regbtn);

        // Go Back
        login_btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Register
        login_regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
                finish();
            }
        });


        login_btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginusername = username_login.getText().toString().trim();
                String loginpassword = pswd_login.getText().toString().trim();

                if (isValidCredentials(loginusername, loginpassword)) {
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                    finish();
                } else if (loginusername.isEmpty() || loginpassword.isEmpty()) {
                    Toast.makeText(Login.this, "Enter the Fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

        // Validation Method
    private boolean isValidCredentials(String username, String password) {
        return username.equals("rock@example.com") && password.equals("rocket");
    }
}

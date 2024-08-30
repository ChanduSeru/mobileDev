package com.example.vehicle;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Claims extends AppCompatActivity{
    private Button btn_all_plans,btn_third_party,btn_own_damage,btn_trending_plans,btn_submit,btn_back;
    private EditText text_user_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claims);

        btn_all_plans = findViewById(R.id.btn_all_plans);
        btn_third_party = findViewById(R.id.btn_third_party);
        btn_own_damage = findViewById(R.id.btn_own_damage);
        btn_trending_plans = findViewById(R.id.btn_trending_plans);
        btn_submit = findViewById(R.id.btn_submit);
        btn_back = findViewById(R.id.btn_back);

        btn_all_plans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Claims.this, "No Active Plans", Toast.LENGTH_SHORT).show();
            }
        });

        btn_third_party.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Claims.this, "No Active Plans", Toast.LENGTH_SHORT).show();
            }
        });

        btn_own_damage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Claims.this, "No Active Plans", Toast.LENGTH_SHORT).show();
            }
        });

        btn_trending_plans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Claims.this, "No Active Plans", Toast.LENGTH_SHORT).show();
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = text_user_input.getText().toString().trim();
                if (userInput.isEmpty()) {
                    Toast.makeText(Claims.this, "Please Write Something", Toast.LENGTH_SHORT).show();
                } else {
                    // Assuming you want to handle user input here, e.g., save it or process it
                    Toast.makeText(Claims.this, "Submitted", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Claims.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

    }
}

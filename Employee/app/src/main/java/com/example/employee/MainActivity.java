package com.example.employee;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Employee> employees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addEmployeeButton = findViewById(R.id.addEmployeeButton);
        Button showEmployeesButton = findViewById(R.id.showEmployeesButton);
        TextView employeesTextView = findViewById(R.id.employeesTextView);

        addEmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddEmployeeDialog();
            }
        });

        showEmployeesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayEmployeeList(employeesTextView);
            }
        });
    }

    private void showAddEmployeeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Employee");

        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.activity_add_emp, null);
        builder.setView(dialogView);

        final EditText nameEditText = dialogView.findViewById(R.id.nameEditText);
        final EditText positionEditText = dialogView.findViewById(R.id.positionEditText);

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = nameEditText.getText().toString().trim();
                String position = positionEditText.getText().toString().trim();

                if (!name.isEmpty() && !position.isEmpty()) {
                    employees.add(new Employee(name, position));
                    Toast.makeText(MainActivity.this, "Employee added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter valid details", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    private void displayEmployeeList(TextView textView) {
        if (!employees.isEmpty()) {
            StringBuilder employeeDetails = new StringBuilder();
            for (Employee employee : employees) {
                employeeDetails.append(employee.getName()).append(" - ").append(employee.getPosition()).append("\n");
            }
            textView.setText(employeeDetails.toString());
        } else {
            textView.setText("No employees added yet.");
        }
    }
}


package com.example.dbhandler;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private AirplaneModeChangeReceiver airplaneReceiver = new AirplaneModeChangeReceiver();
    private EditText courseName, courseTracks, courseDuration, courseDesc;
    private Button addcourse, viewCourses;
    private TextView coursesList;
    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseName = findViewById(R.id.coursename);
        courseTracks = findViewById(R.id.courseTracks);
        courseDuration = findViewById(R.id.courseDuration);
        courseDesc = findViewById(R.id.coursedesc);
        addcourse = findViewById(R.id.addcourse);
        viewCourses = findViewById(R.id.viewCourses);
        coursesList = findViewById(R.id.coursesList);

        dbHandler = new DbHandler(MainActivity.this);

        addcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cName = courseName.getText().toString();
                String cTracks = courseTracks.getText().toString();
                String cDesc = courseDesc.getText().toString();
                String cDuration = courseDuration.getText().toString();

                // validation
                if (cName.isEmpty() || cDesc.isEmpty() || cDuration.isEmpty() || cTracks.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter all the data", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewCourse(cName, cDuration, cDesc, cTracks);
                Toast.makeText(MainActivity.this, "Course Added Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        viewCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCourses();
            }
        });
    }

    private void displayCourses() {
        Cursor cursor = dbHandler.getAllCourses();
        if (cursor.getCount() == 0) {
            coursesList.setText("No courses found.");
            return;
        }

        StringBuilder courses = new StringBuilder();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(DbHandler.NAME_COL));
            @SuppressLint("Range") String duration = cursor.getString(cursor.getColumnIndex(DbHandler.DURATION_COL));
            @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex(DbHandler.DESCRIPTION_COL));
            @SuppressLint("Range") String tracks = cursor.getString(cursor.getColumnIndex(DbHandler.TRACKS_COL));

            courses.append("Course Name: ").append(name).append("\n")
                    .append("Duration: ").append(duration).append("\n")
                    .append("Description: ").append(description).append("\n")
                    .append("Tracks: ").append(tracks).append("\n\n");
        }

        coursesList.setText(courses.toString());
        cursor.close();
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(airplaneReceiver);
    }
}

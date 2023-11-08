package com.example.mgit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button timetable, notification, board, course;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timetable = findViewById(R.id.timetable);
        notification = findViewById(R.id.notification);
        board = findViewById(R.id.board);
        course = findViewById(R.id.course);

        timetable.setOnClickListener(v-> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });

        notification.setOnClickListener(v-> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        board.setOnClickListener(v-> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });

        course.setOnClickListener(v-> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}
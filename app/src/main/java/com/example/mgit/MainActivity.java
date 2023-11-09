package com.example.mgit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton timetable, notification, board, course;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timetable = (ImageButton)findViewById(R.id.timetable);
        notification = (ImageButton)findViewById(R.id.notification);
        board = (ImageButton)findViewById(R.id.board);
        course = (ImageButton)findViewById(R.id.course);


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
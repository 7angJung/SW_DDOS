package com.example.onlineboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PostActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        // Intent에서 데이터를 받아온다
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("post")) {
            Post post = (Post) intent.getSerializableExtra("post");

            // Post 객체의 정보를 화면에 표시
            TextView titleTextView = findViewById(R.id.TitleText);
            TextView authorTextView = findViewById(R.id.AuthorText);
            TextView timeStampTextView = findViewById(R.id.timeStampText);
            TextView contentTextView = findViewById(R.id.ContentText);

            titleTextView.setText(post.getTitle());
            authorTextView.setText(post.getAuthor());
            timeStampTextView.setText(post.getTimeStamp());
            contentTextView.setText(post.getContent());
        }
    }
}
package com.example.onlineboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PostActivity extends AppCompatActivity {
    private Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        // Intent에서 데이터를 받아온다
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("post")) {
            post = (Post) intent.getSerializableExtra("post");

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

        EditText commentEditText = findViewById(R.id.comment_et);
        Button registerButton = findViewById(R.id.reg_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commentContent = commentEditText.getText().toString();
                if (!commentContent.isEmpty()) {
                    // 댓글 생성
                    String commentId = generateCommentId(); // 댓글 고유 ID 생성
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String timeStamp = dateFormat.format(new Date()); // 현재 시간을 시간 문자열로 변환

                    Comment comment = new Comment(commentId, timeStamp, commentContent, "사용자명");

                    // Post 객체에 댓글 추가
                    post.addComment(comment);

                    // 댓글 목록을 화면에 표시
                    updateCommentUI(post.getComments());

                    // 댓글 입력란 초기화
                    commentEditText.setText("");
                }
            }
        });
    }

    private void updateCommentUI(ArrayList<Comment> comments) {
        LinearLayout commentLayout = findViewById(R.id.comment_layout);
        commentLayout.removeAllViews(); // 댓글 목록 뷰를 초기화

        // 댓글 목록을 동적으로 생성하여 추가
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (Comment comment : comments) {
            View commentView = inflater.inflate(R.layout.create_comment, null);
            // 댓글 내용 설정
            TextView commentContentTextView = commentView.findViewById(R.id.comment_content);
            commentContentTextView.setText(comment.getContent());

            // 댓글 작성자 및 작성 시간 설정
            TextView userIdTextView = commentView.findViewById(R.id.comment_userid);
            userIdTextView.setText(comment.getAuthor());
            TextView timeStampTextView = commentView.findViewById(R.id.comment_timestamp);
            timeStampTextView.setText(comment.getTimeStamp());

            // 댓글 목록 뷰에 추가
            commentLayout.addView(commentView);
        }
    }

    // 댓글 고유 ID를 생성하는 메서드 (원하는 방식으로 수정 가능)
    private String generateCommentId() {
        // 여기에 원하는 댓글 ID 생성 로직을 추가하세요.
        // 예를 들어, 현재 시간을 기반으로 한 고유 ID 생성 등을 할 수 있습니다.
        return "comment_" + System.currentTimeMillis();
    }
}
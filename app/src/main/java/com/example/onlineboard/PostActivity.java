package com.example.onlineboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PostActivity extends AppCompatActivity {
    private Post post; // post 객체
    EditText commentEditText; // 댓글 내용이 담길 EditText
    Button registerButton; // 댓글 달기 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 화면 생성
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        // Intent에서 데이터를 받아오는 작업
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("post")) {
            post = (Post) intent.getSerializableExtra("post"); // post 객체를 동기화함

            // Post 객체의 정보를 화면에 표시
            TextView titleTextView = findViewById(R.id.TitleText); // 제목
            TextView authorTextView = findViewById(R.id.AuthorText); // 작가
            TextView timeStampTextView = findViewById(R.id.timeStampText); // 작성시간
            TextView contentTextView = findViewById(R.id.ContentText); // 내용
            titleTextView.setText(post.getTitle());
            authorTextView.setText(post.getAuthor());
            timeStampTextView.setText(post.getTimeStamp());
            contentTextView.setText(post.getContent());
            // post 객체에서 내용들을 받아와 setText
            
            commentEditText = findViewById(R.id.comment_et); // 댓글 내용
            registerButton = findViewById(R.id.reg_button); // 작성 버튼

            updateCommentUI(post.getComments()); // 댓글 목록을 화면에 표시 (후에 DB로 재구성할 예정)
        }




        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commentContent = commentEditText.getText().toString(); // 댓글 내용 받아와서 문자열로 저장
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.post_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                //editPost();
                return true;
            case R.id.action_delete:

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateCommentUI(ArrayList<Comment> comments) {
        LinearLayout commentLayout = findViewById(R.id.comment_layout); // 댓글이 담길 선형 레이아웃 객체
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

    // 댓글 고유 ID를 생성하는 메서드
    private String generateCommentId() {
        // 댓글 ID는 후에 회원가입 화면 연동 후 변경할 예정
        return "comment_" + System.currentTimeMillis();
    }

    private void editPost() {
        Intent editIntent = new Intent(this, CreatePostActivity.class);
        editIntent.putExtra("edit_mode", true); // 수정 모드임을 전달
        editIntent.putExtra("post", post); // 현재 글의 정보 전달
        startActivity(editIntent);
    }

}
package com.example.onlineboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CreatePostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_post);

        EditText createTitleEditText = findViewById(R.id.create_title); // 제목 작성용 EditText
        EditText createContentEditText = findViewById(R.id.create_content); // 내용 작성용 EditText
        Button registerButton = findViewById(R.id.reg_button2); // 작성 후 누를 버튼

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("post") && intent.getBooleanExtra("isEdit", false)) {
            Post editPost = (Post) intent.getSerializableExtra("post");

            // 기존 게시물 정보를 가져와 화면에 표시
            createTitleEditText.setText(editPost.getTitle());
            createContentEditText.setText(editPost.getContent());

            registerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 수정 버튼 클릭 시 처리
                    // 기존 포스트의 정보를 업데이트하고 PostActivity로 돌아가기
                    editPost.setTitle(createTitleEditText.getText().toString());
                    editPost.setContent(createContentEditText.getText().toString());
                    editPost.setTimeStamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));

                    // MainActivity의 데이터셋도 업데이트합니다.
                    int index = findPostIndexById(editPost.getPost_id());
                    if (index != -1) {
                        MainActivity.testDataSet.set(index, editPost);
                        MainActivity.customAdapter.notifyDataSetChanged();
                    }

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("updatedPost", editPost);
                    setResult(RESULT_OK, resultIntent);
                    finish(); // 현재 화면 종료
                }
            });
        } else {
            // 작성 버튼 클릭 시 처리
            // 새로운 포스트 생성 및 MainActivity에 추가
            registerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String title = createTitleEditText.getText().toString();
                    String content = createContentEditText.getText().toString();

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    String timeStamp = sdf.format(new Date());

                    int id = MainActivity.testDataSet.size(); // 새로운 ID 할당

                    Post post = new Post(id, title, content, timeStamp);

                    // MainActivity에 추가된 포스트를 전달
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("newPost", post);
                    setResult(RESULT_OK, resultIntent);

                    finish(); // 작성 완료 후 원래 화면으로 복귀
                }
            });
        }
    }

    private int findPostIndexById(int postId) {
        for (int i = 0; i < MainActivity.testDataSet.size(); i++) {
            if (MainActivity.testDataSet.get(i).getPost_id() == postId) {
                return i;
            }
        }
        return -1;
    }
}
package com.example.onlineboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Post> testDataSet; // Post 클래스를 저장하는 ArrayList, DB 연동시 변경 예정
    static CustomAdapter customAdapter; // RecyclerView 관리를 위한 Adapter
    static final int CREATE_POST_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 화면 생성
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        } // 상단 바 숨김


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //----- 테스트를 위한 더미 데이터 생성 --------------------

        testDataSet = new ArrayList<>(); // ArrayList 할당

        int id = 0; String title = "안녕하세요?";
        String content = "당신이 원하는 내용을 작성하고 정리하여 기록하세요!";    String author = "개발자";
        // post 요소들 (id, 제목, 내용, 작성자) 설정
        long currentTimeMillis = System.currentTimeMillis(); // 시간 정ㄷ보 저장


        // 밀리초를 Date 객체로 변환
        Date date = new Date(currentTimeMillis);

        // Date 객체를 원하는 형식의 문자열로 변환
        String timeStamp = dateFormat.format(date);

        // post 객체 생성한 후 ArrayList에 추가
        Post post = new Post(id, title, content, timeStamp);
        testDataSet.add(post);
        //--------------------------------------------------------

        // recyclerView 객체
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // 선형 리스트 LayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context) this);
        recyclerView.setLayoutManager(linearLayoutManager);  // LayoutManager 설정

        // recyclerView 연결용 customAdapter 객체 생성
        customAdapter = new CustomAdapter(this, testDataSet);

        //===== [Click 이벤트 구현을 위해 추가된 코드] ==============
        customAdapter.setOnItemClickListener(new CustomAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int position, Post post) {
                // 클릭한 항목의 데이터를 PostActivity로 전달하는 Intent 생성
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                intent.putExtra("post", post); // "post"라는 키로 Post 객체를 전달
                startActivity(intent); // PostActivity를 시작하고 데이터를 전달
            }
        });
        //==========================================================
        recyclerView.setAdapter(customAdapter); // 어댑터 설정

        //-----------------------------------------------------------
        Button createPostButton = findViewById(R.id.reg_button1); // 글 작성 버튼
        createPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // "글 작성" 버튼을 클릭하면 CreatePostActivity로 이동
                Intent intent = new Intent(MainActivity.this, CreatePostActivity.class);
                startActivityForResult(intent, CREATE_POST_REQUEST); // Start activity for result
            }
        }); // 글 작성 버튼 누를 시 처리

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_POST_REQUEST && resultCode == RESULT_OK && data != null) {

            if (data.hasExtra("newPost")) {
                Post newPost = (Post) data.getSerializableExtra("newPost");
                testDataSet.add(newPost);
                customAdapter.notifyDataSetChanged();
            }

            if (data.hasExtra("updatedPost")) {
                Post updatedPost = (Post) data.getSerializableExtra("updatedPost");
                // Update the post in the testDataSet
                int index = findPostIndexById(updatedPost.getPost_id());
                if (index != -1) {
                    testDataSet.set(index, updatedPost);
                    customAdapter.notifyDataSetChanged();
                }
            }
        }

    }
    
    private int findPostIndexById(int postId) {
        for (int i = 0; i < testDataSet.size(); i++) {
            if (testDataSet.get(i).getPost_id() == postId) {
                return i;
            }
        }
        return -1; // 포스트 발견 실패시
    }
}
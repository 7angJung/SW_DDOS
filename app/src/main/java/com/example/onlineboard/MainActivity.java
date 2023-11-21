package com.example.onlineboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Post> testDataSet; // Post 클래스를 저장하는 ArrayList, DB 연동시 변경 예정
    static CustomAdapter customAdapter; // RecyclerView 관리를 위한 Adapter
    private static final int CREATE_POST_REQUEST = 1;
    private static final int EDIT_POST_REQUEST = 2;
    private static final int DELETE_POST_REQUEST = 3;

    Post post;

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

        //--------------------------------------------------------

        loadPosts();

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

        Button deleteButton = findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 리스트의 맨 끝 파일 삭제
                if (!testDataSet.isEmpty()) {
                    Post lastPost = testDataSet.get(testDataSet.size() - 1);
                    testDataSet.remove(lastPost);
                    customAdapter.notifyDataSetChanged();
                    Log.d("DeletePost", "Deleted last post: " + lastPost.getTitle());
                } else {
                    Log.d("DeletePost", "List is empty. Nothing to delete.");
                }
            }
        }); // 글 삭제 버튼 처리
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("requestCode","Received requestCode: " + requestCode);

        if (requestCode == CREATE_POST_REQUEST && resultCode == RESULT_OK && data != null) {
            // 글 작성 또는 수정이 완료된 경우, 데이터 갱신
            if (data.hasExtra("newPost")) {
                Post newPost = (Post) data.getSerializableExtra("newPost");
                testDataSet.add(newPost);
                customAdapter.notifyDataSetChanged();
            } else if (data.hasExtra("updatedPost")) {
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

    private void savePosts() {
        // SharedPreferences 객체 생성
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // 데이터를 JSON 형식으로 변환하여 저장
        Gson gson = new Gson();
        String json = gson.toJson(testDataSet);
        editor.putString("posts", json);

        // 변경사항을 적용하고 저장
        editor.apply();
    }

    private void loadPosts() {
        // SharedPreferences 객체 생성
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        // 저장된 JSON 데이터 불러오기
        String json = sharedPreferences.getString("posts", null);

        if (json != null) {
            // JSON을 객체로 변환하여 testDataSet에 저장
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Post>>() {}.getType();
            testDataSet = gson.fromJson(json, type);
        } else {
            // 저장된 데이터가 없을 경우 빈 ArrayList 생성
            testDataSet = new ArrayList<>();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        savePosts();
    }
}
package com.example.onlineboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    int newDataNumber = 21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //----- 테스트를 위한 더미 데이터 생성 --------------------
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ArrayList<Post> testDataSet = new ArrayList<>();
        for (int i = 1; i<=20; i++) {
            String id = "" + i; String title = "제목" + i;
            String content = "test" + i;    String author = "작가" + i;
            long currentTimeMillis = System.currentTimeMillis();

            // 밀리초를 Date 객체로 변환
            Date date = new Date(currentTimeMillis);

            // Date 객체를 원하는 형식의 문자열로 변환
            String formattedDate = dateFormat.format(date);
            String timeStamp = "작성일: " + formattedDate;

            Post post = new Post(id, title, content, author, timeStamp);
            testDataSet.add(post);
        }
        //--------------------------------------------------------

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context) this);
        recyclerView.setLayoutManager(linearLayoutManager);  // LayoutManager 설정

        CustomAdapter customAdapter = new CustomAdapter(this, testDataSet);

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


        //----- 데이터 추가/삭제 버튼 -------------------------------
        Button buttonAddItem = findViewById(R.id.buttonAddItem);
        Button buttonDeleteItem = findViewById(R.id.buttonDeleteItem);

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "" + newDataNumber; String title = "제목" + newDataNumber;
                String content = "test" + newDataNumber;    String author = "작가" + newDataNumber;
                long currentTimeMillis = System.currentTimeMillis();

                // 밀리초를 Date 객체로 변환
                Date date = new Date(currentTimeMillis);

                // Date 객체를 원하는 형식의 문자열로 변환
                String formattedDate = dateFormat.format(date);
                String timeStamp = "현재 시간: " + formattedDate;

                Post post = new Post(id, title, content, author, timeStamp);

                testDataSet.add(post);
                customAdapter.notifyItemInserted(testDataSet.size());
                newDataNumber++;
            }
        });

        buttonDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testDataSet.remove(testDataSet.size()-1);
                customAdapter.notifyDataSetChanged();
                newDataNumber--;
            }
        });
        //-----------------------------------------------------------
        Button createPostButton = findViewById(R.id.reg_button1);
        createPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // "글 작성" 버튼을 클릭하면 CreatePostActivity로 이동
                Intent intent = new Intent(MainActivity.this, CreatePostActivity.class);
                startActivity(intent);
            }
        });

    }
}
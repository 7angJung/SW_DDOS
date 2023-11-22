package com.example.mgit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OnlineBoardActivity extends AppCompatActivity {

    static ArrayList<Post> testDataSet; // Firebase와 연결되면 변경될 Post 클래스를 저장하는 ArrayList
    static CustomAdapter customAdapter; // RecyclerView 관리를 위한 Adapter
    int newDataNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_board);

        // Firebase 초기화
        FirebaseDatabase BoardDB = FirebaseDatabase.getInstance();
        DatabaseReference BoardRef = BoardDB.getReference("posts"); // Firebase 데이터베이스의 참조를 가져옵니다.

        // RecyclerView 설정
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context) this);
        recyclerView.setLayoutManager(linearLayoutManager);
        testDataSet = new ArrayList<>(); // 데이터셋 초기화

        // Firebase에서 데이터 읽어오기
        BoardRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                testDataSet.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Post post = snapshot.getValue(Post.class);
                    testDataSet.add(post);
                }
                customAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // 에러 처리
                Toast.makeText(getApplicationContext(), "DB연동 오류", Toast.LENGTH_SHORT).show();
            }
        });

        // RecyclerView와 CustomAdapter 연결
        customAdapter = new CustomAdapter(this, testDataSet);
        recyclerView.setAdapter(customAdapter);

        // 게시물 추가 버튼과 삭제 버튼
        Button buttonDeleteItem = findViewById(R.id.buttonDeleteItem);

        buttonDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (testDataSet.size() > 0) {
                    String lastItemId = testDataSet.get(testDataSet.size() - 1).getId();
                    BoardRef.child(lastItemId).removeValue();
                    newDataNumber--;
                }
            }
        });

        // 게시물 작성 버튼
        Button createPostButton = findViewById(R.id.reg_button1);
        createPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnlineBoardActivity.this, CreatePostActivity.class);
                startActivity(intent);
            }
        });
    }
}
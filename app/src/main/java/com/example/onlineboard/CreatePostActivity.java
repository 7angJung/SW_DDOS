package com.example.onlineboard;

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

        EditText createTitleEditText = findViewById(R.id.create_title);
        EditText createContentEditText = findViewById(R.id.create_content);
        Button registerButton = findViewById(R.id.reg_button2);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = createTitleEditText.getText().toString();
                String content = createContentEditText.getText().toString();

                // 현재 시간을 가져오는 예시 코드 (실제로 사용할 때는 적절한 방법으로 시간을 가져와야 함)
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                String timeStamp = sdf.format(new Date());

                // 새로운 포스트 객체 생성
                Post post = new Post("22", title, content, "test", timeStamp);

                // MainActivity의 ArrayList에 포스트 추가
                MainActivity.testDataSet.add(post);
                MainActivity.customAdapter.notifyItemInserted(MainActivity.testDataSet.size());

                // 작성이 완료되면 이전 화면으로 돌아가도록 처리하고 싶다면 아래 코드를 사용합니다.
                finish();
                finish();
            }
        });
    }
}

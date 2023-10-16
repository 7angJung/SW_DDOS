package com.example.onlineboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

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

                // 여기서 title과 content를 사용하여 원하는 동작을 수행하면 됩니다.
                // 예를 들어, 데이터베이스에 글을 저장하거나 서버에 전송할 수 있습니다.

                // 작성이 완료되면 이전 화면으로 돌아가도록 처리하고 싶다면 아래 코드를 사용합니다.
                finish();
            }
        });
    }
}

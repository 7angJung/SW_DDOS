package co.kr.M_Git_Project;

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
    protected void onCreate(Bundle savedInstanceState) { // 화면 생성
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_post);

        EditText createTitleEditText = findViewById(R.id.create_title); // 제목 작성용 EditText
        EditText createContentEditText = findViewById(R.id.create_content); // 내용 작성용 Edit
        Button registerButton = findViewById(R.id.reg_button2); // 작성 후 누를 버튼

        registerButton.setOnClickListener(new View.OnClickListener() { // 작성 버튼 눌렀을 경우 처리 리스너
            @Override
            public void onClick(View v) { // 클릭 처리 함수
                String title = createTitleEditText.getText().toString(); // 제목 저장
                String content = createContentEditText.getText().toString(); // 내용 저장

                // 현재 시간을 가져오는 코드
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                String timeStamp = sdf.format(new Date());

                // 새로운 포스트 객체 생성
                Post post = new Post("22", title, content, "test", timeStamp);

                // MainActivity의 ArrayList에 포스트 추가
                OnlineBoardActivity.testDataSet.add(post);
                OnlineBoardActivity.customAdapter.notifyItemInserted(OnlineBoardActivity.testDataSet.size());
                
                finish(); // 작성 완료 후 원래 화면으로 복귀
            }
        });
    }
}

package co.kr.M_Git_Project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
// 로그인 화면 액티비티
public class LoginActivity extends AppCompatActivity {
    TextView sign;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sign = (TextView)findViewById(R.id.signin);  //회원가입 버튼 수행
        login = (Button)findViewById(R.id.loginButton);  //로그인 버튼 수행

        // 인텐트 시작, 회원가입 액티비티 시작
        sign.setOnClickListener(v-> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });

        // 인텐트 시작, 로그인 액티비티 시작
        login.setOnClickListener(v-> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}
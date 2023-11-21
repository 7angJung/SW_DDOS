package co.kr.M_Git_Project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

// 로그인 화면 액티비티
public class LoginActivity extends AppCompatActivity {
    TextView sign;
    EditText Id;
    EditText Pw;
    Button login;
    private FirebaseAuth mfirebaseAuth;// 파이어베이스 인증처리
    private DatabaseReference mDatabaseRef; //실시간 데이터베이스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mfirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("M-GIT");

        sign = (TextView)findViewById(R.id.signin);  //회원가입 버튼 수행
        login = (Button)findViewById(R.id.loginButton);  //로그인 버튼 수행
        Id = (EditText)findViewById(R.id.editID);
        Pw = (EditText)findViewById(R.id.editPassword);

        // 인텐트 시작, 회원가입 액티비티 시작
        sign.setOnClickListener(v-> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });

        // 인텐트 시작, 로그인 액티비티 시작
        login.setOnClickListener(v-> {
            String strId = Id.getText().toString()+ "@mmu.com";
            String strPw = Pw.getText().toString();

            mfirebaseAuth.signInWithEmailAndPassword(strId,strPw).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("ID",strId);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"등록되지 않은 Id 입니다.",Toast.LENGTH_SHORT).show();
                    }
                }
            });


        });
    }
}
package co.kr.M_Git_Project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    private EditText id, pw;
    private TextView sign;
    private Button login;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseDatabase UserDB = FirebaseDatabase.getInstance();
    DatabaseReference UserRef = UserDB.getReference("M-GIT");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id = (EditText)findViewById(R.id.editID);
        pw = (EditText)findViewById(R.id.editPassword);
        sign = (TextView)findViewById(R.id.signin);
        login = (Button)findViewById(R.id.loginButton);

        sign.setOnClickListener(v-> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });

        login.setOnClickListener(v-> {
            attemptLogin();
        });

    }

    private void attemptLogin() {
        id.setError(null);
        pw.setError(null);

        String userID = id.getText().toString()+"@mmu.com";
        String userPwd = pw.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // 패스워드의 유효성 검사
        if (userPwd.isEmpty()) {
            pw.setError("비밀번호를 입력해주세요.");
            focusView = pw;
            cancel = true;
        } else if (!isPasswordValid(userPwd)) {
            pw.setError("6자 이상의 비밀번호를 입력해주세요.");
            focusView = pw;
            cancel = true;
        }

        // ID의 유효성 검사
        if (userID.isEmpty()) {
            id.setError("아이디를 입력해주세요.");
            focusView = id;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            startLogin(userID, userPwd);
        }
    }

    private void startLogin(String ID, String Pwd) {
        // 인텐트 시작, 로그인 액티비티 시작
        mAuth.signInWithEmailAndPassword(ID,Pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("ID",ID);
                    startActivity(intent);
                } else {
                    id.setError("");
                    pw.setError("");
                    Toast.makeText(getApplicationContext(), "존재하지 않는 학번이거나 비밀빈호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 6;
    }
}
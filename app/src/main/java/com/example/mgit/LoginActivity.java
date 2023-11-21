package com.example.mgit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    private EditText id, pw;
    private TextView sign;
    private Button login;
    FirebaseDatabase UserDB = FirebaseDatabase.getInstance();
    DatabaseReference UserRef = UserDB.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        try {
            //FirebaseApp.initializeApp(this);
            //UserDB = FirebaseDatabase.getInstance();
            //UserRef = UserDB.getReference();

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
        } catch (Throwable e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("FirebaseInitError", "Firebase 초기화 오류: " + e.getMessage());
        }

    }
    private void attemptLogin() {
        id.setError(null);
        pw.setError(null);

        String userID = id.getText().toString();
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
        UserRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String passwordFromDB = snapshot.child("UserPwd").getValue(String.class);
                    if (passwordFromDB.length() != 0 && passwordFromDB.equals(Pwd)) {
                        // 비밀번호 일치, 로그인 성공
                        id.setError(null);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                    // 비밀번호 불일치
                    pw.setError("비밀번호가 틀렸습니다.");
                    pw.requestFocus();
                    }
                } else {
                    // 해당 아이디의 사용자가 존재하지 않음
                    id.setError("존재하지 않는 아이디입니다.");
                    id.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"데이터 읽기에 실패했습니다.",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 6;
    }
}
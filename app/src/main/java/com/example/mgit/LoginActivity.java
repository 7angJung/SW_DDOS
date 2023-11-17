package com.example.mgit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText id, pw;
    private TextView sign, findPwd;
    private Button login;
    private ServiceAPI service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id = (EditText)findViewById(R.id.editID);
        pw = (EditText)findViewById(R.id.editPassword);
        sign = (TextView)findViewById(R.id.signin);
        login = (Button)findViewById(R.id.loginButton);
        service = RetrofitClient.getClient().create(ServiceAPI.class);

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
            startLogin(new LoginData(userID, userPwd));
        }
    }

    private void startLogin(LoginData data) {
        service.userLogin(data).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse result = response.body();

                if (result != null) {
                    if (result.getCode() == 200) {
                        // 로그인 성공 처리
                        Toast.makeText(LoginActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        // 로그인 실패 처리
                        Toast.makeText(LoginActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // 서버 응답이 없을 경우 처리
                    Toast.makeText(LoginActivity.this, "서버 응답 없음", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "로그인 에러 발생", Toast.LENGTH_SHORT).show();
                Log.e("로그인 에러 발생", t.getMessage());
            }
        });
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 6;
    }
}
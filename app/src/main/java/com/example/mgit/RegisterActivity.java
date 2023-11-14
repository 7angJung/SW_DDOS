package com.example.mgit;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private TextView back;
    private EditText name,id,pw,pw2,birth;
    private Button pwcheck, submit;
    private ServiceAPI service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //뒤로 가기 버튼
        back = findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed() );

        //기입 항목
        name = findViewById(R.id.signName);
        id=findViewById(R.id.signID);
        pw=findViewById(R.id.signPW);
        pw2=findViewById(R.id.signPW2);
        birth=findViewById(R.id.signBirth);

        service = RetrofitClient.getClient().create(ServiceAPI.class);

        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        String myFormat = "yyyy/MM/dd";
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);
                        String selMonth, selDay;

                        if ((month + 1) <= 10)
                            selMonth = "0" + (month + 1);
                        else
                            selMonth = Integer.toString(month + 1);

                        if (dayOfMonth <= 10)
                            selDay = "0" + dayOfMonth;
                        else
                            selDay = Integer.toString(dayOfMonth);

                        birth.setText(Integer.toString(year) + "/" + selMonth + "/" + selDay);
                    }
                };
                DatePickerDialog pickerDialog = new DatePickerDialog(RegisterActivity.this, listener, year, month, day);
                pickerDialog.show();
            }
        });

        //비밀번호 확인 버튼
        pwcheck = findViewById(R.id.pwcheckbutton);
        pwcheck.setOnClickListener(v -> {
            if(pw.getText().toString().equals(pw2.getText().toString())){
                pwcheck.setText("일치");
            }else{
                Toast.makeText(this, "비밀번호가 다릅니다.", Toast.LENGTH_LONG).show();
            }
        });

        //회원가입 완료 버튼
        submit = findViewById(R.id.signupbutton);
        submit.setOnClickListener(v -> {
            attemptRegister();
        });
    }

    private void attemptRegister() {
        name.setError(null);
        id.setError(null);
        pw.setError(null);
        birth.setError(null);

        String userName = name.getText().toString();
        String userID = id.getText().toString();
        String userBirth = birth.getText().toString();
        String userPwd = pw.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // 패스워드의 유효성 검사
        if (userPwd.isEmpty()) {
            id.setError("비밀번호를 입력해주세요.");
            focusView = id;
            cancel = true;
        } else if (!isPasswordValid(userPwd)) {
            pw.setError("6자 이상의 비밀번호를 입력해주세요.");
            focusView = pw;
            cancel = true;
        }

        // 이메일의 유효성 검사
        if (userID.isEmpty()) {
            id.setError("이메일을 입력해주세요.");
            focusView = id;
            cancel = true;
        }

        // 생년월일 유효성 검사
        if (userBirth.isEmpty()) {
            id.setError("생년월일을 입력해주세요.");
            focusView = id;
            cancel = true;
        }

        // 이름의 유효성 검사
        if (userName.isEmpty()) {
            name.setError("이름을 입력해주세요.");
            focusView = name;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            startRegister(new RegisterData(userName, userID, userBirth, userPwd));
        }
    }

    private void startRegister(RegisterData data) {
        service.userRegister(data).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                RegisterResponse result = response.body();

                if (result.getCode() == 200) {
                    finish();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "회원가입 에러 발생", Toast.LENGTH_SHORT).show();
                Log.e("회원가입 에러 발생", t.getMessage());
            }
        });
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 6;
    }
}
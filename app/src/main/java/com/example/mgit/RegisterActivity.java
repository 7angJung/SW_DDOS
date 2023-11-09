package com.example.mgit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {
    TextView back;
    EditText name,id,pw,pw2,birth;
    Button pwcheck, submit;

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
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });
    }
}
package co.kr.M_Git_Project;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {
    TextView back;
    private EditText name,id,pw,pw2,birth;
    private Button pwcheck, submit;
    private FirebaseAuth mfirebaseAuth;// 파이어베이스 인증처리
    private DatabaseReference mDatabaseRef; //실시간 데이터베이스


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        FirebaseApp.initializeApp(this);

        mfirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("M-GIT");

        //기입 항목
        name = findViewById(R.id.signName);  // 이름
        id=findViewById(R.id.signID);        // 아이디
        pw=findViewById(R.id.signPW);        // 비밀번호
        pw2=findViewById(R.id.signPW2);      // 비밀번호 확인
        birth=findViewById(R.id.signBirth);  // 생년월일

        // 생년월일 버튼 기능
        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();     // 캘린더 객체 생성
                int year = calendar.get(Calendar.YEAR);         // 현재 년도
                int month = calendar.get(Calendar.MONTH);       // 현재 달
                int day = calendar.get(Calendar.DAY_OF_MONTH);  // 현재 월의 날짜

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
            String userId = id.getText().toString()+ "@mmu.com";
            String userPw = pw.getText().toString();

            mfirebaseAuth.createUserWithEmailAndPassword(userId, userPw)
                    .addOnCompleteListener(RegisterActivity.this, task -> {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = mfirebaseAuth.getCurrentUser();
                            if (firebaseUser != null) {
                                UserAccount account = new UserAccount();
                                account.setIdToken(firebaseUser.getUid());
                                account.setUserId(firebaseUser.getEmail());
                                account.setUserPw(userPw);

                                // setvalue : database에 insert (삽입) 행위
                                mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                                Toast.makeText(RegisterActivity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();

                                // 회원가입 성공 시 LoginActivity로 이동
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else {
                                // 사용자 생성은 성공했지만, getCurrentUser()가 null인 경우에 대한 처리
                                // 사용자에게 알림 등을 통해 오류를 전달하거나, 다른 적절한 조치를 취할 수 있음
                            }
                        } else {
                            // 사용자 생성 실패
                            // task.getException()을 통해 실패한 이유에 대한 정보를 얻을 수 있음
                            Toast.makeText(RegisterActivity.this, "회원가입 실패", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }

}
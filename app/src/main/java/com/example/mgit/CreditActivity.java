package com.example.mgit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreditActivity extends AppCompatActivity {
    private EditText currentCredit1, currentCredit2;
    private TextView currentGrade;
    private Button insertButton;
    private ServiceAPI service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        currentCredit1 = (EditText) findViewById(R.id.currentCredit1);
        currentCredit2 = (EditText) findViewById(R.id.currentCredit2);
        currentGrade = (TextView) findViewById(R.id.currentGrade);
        insertButton = (Button) findViewById(R.id.insertButton);
        service = RetrofitClient.getClient().create(ServiceAPI.class);

        registerForContextMenu(currentGrade);

        currentGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getApplicationContext(), currentGrade);
                popup.inflate(R.menu.popup);
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_grade1:
                                currentGrade.setText("1");
                                break;
                            case R.id.menu_grade2:
                                currentGrade.setText("2");
                                break;
                            case R.id.menu_grade3:
                                currentGrade.setText("3");
                                break;
                            case R.id.menu_grade4:
                                currentGrade.setText("4");
                                break;
                        }
                        return false;
                    }
                });
            }
        });

        insertButton.setOnClickListener(v -> {
            insertInformation();
        });

    }

    private void insertInformation() {
        currentCredit1.setError(null);
        currentCredit2.setError(null);
        currentGrade.setError(null);

        String userCredit1 = currentCredit1.getText().toString();
        String userCredit2 = currentCredit2.getText().toString();
        String userGrade = currentGrade.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // 전공 학점 유효성 검사
        if (userCredit1.isEmpty()) {
            currentCredit1.setError("현재 이수 학점(전공)을 입력해주세요.");
            focusView = currentCredit1;
            cancel = true;
        } else if (!isCreditValid(userCredit1)) {
            currentCredit1.setError("적합하지 않은 숫자를 입력하였습니다.");
            focusView = currentCredit1;
            cancel = true;
        }

        // 교양 학점 유효성 검사
        if (userCredit1.isEmpty()) {
            currentCredit2.setError("현재 이수 학점(교양)을 입력해주세요.");
            focusView = currentCredit2;
            cancel = true;
        } else if (!isCreditValid(userCredit2)) {
            currentCredit2.setError("적합하지 않은 숫자를 입력하였습니다.");
            focusView = currentCredit2;
            cancel = true;
        }

        // 학년 유효성 검사
        if (userGrade.isEmpty()) {
            currentGrade.setError("현재 학년을 입력해주세요.");
            focusView = currentGrade;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            startInsert(new CreditData(userCredit1, userCredit2, userGrade));
        }
    }

    private void startInsert(CreditData data) {
        service.userCredit(data).enqueue(new Callback<CreditResponse>() {
            @Override
            public void onResponse(Call<CreditResponse> call, Response<CreditResponse> response) {
                Intent intent = new Intent(CreditActivity.this, RoadmapActivity.class);
                startActivity(intent);
                CreditResponse result = response.body();

                if (result.getCode() == 200) {
                    finish();
                }
            }

            @Override
            public void onFailure(Call<CreditResponse> call, Throwable t) {
                Toast.makeText(CreditActivity.this, "정보 기입 에러 발생", Toast.LENGTH_SHORT).show();
                Log.e("정보 기입 에러 발생", t.getMessage());
            }
        });
    }

    private boolean isCreditValid(String credit) {
        return (credit.length() >= 0 || credit.length()<=140);
    }
}
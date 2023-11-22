package com.example.mgit;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CreditActivity extends AppCompatActivity {
    private EditText currentCredit1, currentCredit2;
    private TextView currentGrade, currentSemester;
    private Button insertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        currentCredit1 = (EditText) findViewById(R.id.currentCredit1); // 전공
        currentCredit2 = (EditText) findViewById(R.id.currentCredit2); // 교양
        currentGrade = (TextView) findViewById(R.id.currentGrade);
        currentSemester = (TextView) findViewById(R.id.currentSemester);
        insertButton = (Button) findViewById(R.id.insertButton);

        registerForContextMenu(currentGrade);
        registerForContextMenu(currentSemester);

        currentGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getApplicationContext(), currentGrade);
                popup.inflate(R.menu.popup_grade);
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_grade1:
                                currentGrade.setText("1학년");
                                break;
                            case R.id.menu_grade2:
                                currentGrade.setText("2학년");
                                break;
                            case R.id.menu_grade3:
                                currentGrade.setText("3학년");
                                break;
                            case R.id.menu_grade4:
                                currentGrade.setText("4학년");
                                break;
                        }
                        return false;
                    }
                });
            }
        });

        currentSemester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getApplicationContext(), currentSemester);
                popup.inflate(R.menu.popup_semester);
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_semester1:
                                currentSemester.setText("1학기");
                                break;
                            case R.id.menu_semester2:
                                currentSemester.setText("2학기");
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
        currentSemester.setError(null);

        String userCredit1 = currentCredit1.getText().toString();
        String userCredit2 = currentCredit2.getText().toString();
        String userGrade = currentGrade.getText().toString();
        String userSemester = currentSemester.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // 전공 학점 유효성 검사
        if (userCredit1.isEmpty()) {
            currentCredit1.setError("현재 이수 학점(전공)을 입력해주세요.");
            focusView = currentCredit1;
            cancel = true;
        } else if (Integer.parseInt(userCredit1)<0) {
            currentCredit1.setError("적합하지 않은 숫자를 입력하였습니다.");
            focusView = currentCredit1;
            cancel = true;
        }

        // 교양 학점 유효성 검사
        if (userCredit2.isEmpty()) {
            currentCredit2.setError("현재 이수 학점(교양)을 입력해주세요.");
            focusView = currentCredit2;
            cancel = true;
        } else if (Integer.parseInt(userCredit2)<0) {
            currentCredit2.setError("적합하지 않은 숫자를 입력하였습니다.");
            focusView = currentCredit2;
            cancel = true;
        }

        // 학년 유효성 검사
        if (userGrade.isEmpty()) {
            currentGrade.setError("현재 학년을 선택해주세요.");
            focusView = currentGrade;
            cancel = true;
        }
        // 학기 유효성 검사
        if(userSemester.isEmpty()) {
            currentSemester.setError("현재 학기를 선택해주세요.");
            focusView = currentSemester;
            cancel = true;
        }
        if (cancel) {
            focusView.requestFocus();
        } else {
            Intent intent = new Intent(CreditActivity.this, RoadmapActivity.class);
            intent.putExtra("credit1", userCredit1);
            intent.putExtra("credit2", userCredit1);
            intent.putExtra("grade", userGrade);
            intent.putExtra("semester", userSemester);

            startActivity(intent);
        }
    }
}
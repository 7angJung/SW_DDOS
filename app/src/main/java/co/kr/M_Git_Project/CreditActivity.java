package co.kr.M_Git_Project;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreditActivity extends AppCompatActivity {
    private EditText currentCredit1, currentCredit2;
    private TextView currentGrade, currentSemester;
    private Button insertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        currentCredit1 = (EditText) findViewById(R.id.currentCredit1);
        currentCredit2 = (EditText) findViewById(R.id.currentCredit2);
        currentGrade = (TextView) findViewById(R.id.currentGrade);
        currentSemester = (TextView) findViewById(R.id.currentSemester);
        insertButton = (Button) findViewById(R.id.insertButton);

        registerForContextMenu(currentGrade);
        registerForContextMenu(currentSemester);

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

        currentSemester.setOnClickListener(new View.OnClickListener() {
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
                                currentSemester.setText("1");
                                break;
                            case R.id.menu_grade2:
                                currentSemester.setText("2");
                                break;
                        }
                        return false;
                    }
                });
            }
        });

        insertButton.setOnClickListener(v -> {
            //Intent intent = getIntent();
            //Intent intent1 = new Intent(getApplicationContext(),RoadmapActivity.class);

            //String result = intent.getStringExtra("result");
            //intent1.putExtra("result", result);

            insertInformation();
            //Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
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
        } else if (!isCreditValid(userCredit1)) {
            currentCredit1.setError("적합하지 않은 숫자를 입력하였습니다.");
            focusView = currentCredit1;
            cancel = true;
        }

        // 교양 학점 유효성 검사
        if (userCredit2.isEmpty()) {
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
        // 학기 유효성 검사
        if(userSemester.isEmpty()) {
            currentSemester.setError("현재 학기를 입력해주세요.");
            focusView = currentSemester;
            cancel = true;
        }
        if (cancel) {
            focusView.requestFocus();
        } else {
            Intent intent = new Intent(CreditActivity.this, RoadmapActivity.class);
            Intent intent1 = getIntent();
            intent.putExtra("credit1", userCredit1);
            intent.putExtra("credit2", userCredit1);
            intent.putExtra("grade", userGrade);
            intent.putExtra("semester", userSemester);
            String result = intent1.getStringExtra("result");
            intent.putExtra("result", result);
            startActivity(intent);
        }
    }

    private boolean isCreditValid(String credit) {
        return (credit.length() >= 0 || credit.length()<=140);
    }
}
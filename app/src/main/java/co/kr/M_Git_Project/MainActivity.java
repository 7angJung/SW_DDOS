package co.kr.M_Git_Project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySet;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton timetable, notification, board, course;
    String useId;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timetable = (ImageButton)findViewById(R.id.timetable);
        notification = (ImageButton)findViewById(R.id.notification);
        board = (ImageButton)findViewById(R.id.board);
        course = (ImageButton)findViewById(R.id.course);
        Intent intent3 = getIntent();
        useId = intent3.getStringExtra("ID");


        timetable.setOnClickListener(v-> {
            Intent intent = new Intent(this, TimeTableActivity.class);
            intent.putExtra("ID",useId);
            startActivity(intent);
        });

        notification.setOnClickListener(v-> {
            Intent intent = new Intent(this, NotificationActivity.class);
            startActivity(intent);
        });
        board.setOnClickListener(v-> {
            Intent intent = new Intent(this, OnlineBoardActivity.class);
            intent.putExtra("ID",useId);
            startActivity(intent);
        });

        course.setOnClickListener(v-> {
            AlertDialog.Builder Dialog = new AlertDialog.Builder(this);
            Intent intent1 = new Intent(this, CareerExplorationActivity.class);
            intent1.putExtra("ID",useId);

            Intent intent2 = new Intent(this, UserInformActivity.class);
            intent2.putExtra("ID",useId);
            Dialog.setTitle("사용자 정보 확인");
            Dialog.setMessage("진로 탐색을 위한 정보를 수집 하시려면 설문문 버튼을 눌러 주세요\n");
            Dialog.setPositiveButton("진로 탐색 기능", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    startActivity(intent1);
                }
            });

            Dialog.setNegativeButton("설문", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    startActivity(intent2);
                }
            });
            Dialog.show();
        });

    }
}
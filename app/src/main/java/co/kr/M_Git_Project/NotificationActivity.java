package co.kr.M_Git_Project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        TextView nofText1, nofText2, nofText3, nofText4, nofText5;
        nofText1 = findViewById(R.id.nof1);
        nofText2 = findViewById(R.id.nof2);
        nofText3 = findViewById(R.id.nof3);
        nofText4 = findViewById(R.id.nof4);
        nofText5 = findViewById(R.id.nof5);
        nofText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                intent.putExtra("type",0);
                startActivity(intent);
            }
        });
        nofText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                intent.putExtra("type",4);
                startActivity(intent);

            }
        });
        nofText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                intent.putExtra("type",3);
                startActivity(intent);

            }
        });
        nofText4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                intent.putExtra("type",5);
                startActivity(intent);

            }
        });
        nofText5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MealActivity.class);
                startActivity(intent);
            }
        });

    }
}
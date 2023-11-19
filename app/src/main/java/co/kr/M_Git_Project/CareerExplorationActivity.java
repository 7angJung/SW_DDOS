package co.kr.M_Git_Project;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CareerExplorationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_exploration);
        TextView career1,career2,career3,career4,career5, career6;

        career1 = (TextView) findViewById(R.id.careerEx1);
        career2 = (TextView) findViewById(R.id.careerEx2);
        career3 = (TextView) findViewById(R.id.careerEx3);
        career4 = (TextView) findViewById(R.id.careerEx4);
        career5 = (TextView) findViewById(R.id.careerEx5);
        career6 = (TextView) findViewById(R.id.careerEx6);
        Intent intent = getIntent();

        int A,B,C,D,E,F,G,H,I;
        A = intent.getIntExtra("A",0);
        B = intent.getIntExtra("B",0);
        C = intent.getIntExtra("C",0);
        D = intent.getIntExtra("D",0);
        E = intent.getIntExtra("E",0);
        F = intent.getIntExtra("F",0);
        G = intent.getIntExtra("G",0);
        H = intent.getIntExtra("H",0);
        I = intent.getIntExtra("I",0);
        String result="";
        String result1;

        int numArray[] = {A,B,C,D,E,F,G,H,I};
        int maxNum = -100;
        for (int i = 0; i < 9; i++) {
            if (numArray[i] > maxNum) {
                maxNum = numArray[i];
                switch (i) {
                    case 0:
                        result = "A";
                        break;
                    case 1:
                        result = "B";
                        break;
                    case 2:
                        result = "C";
                        break;
                    case 3:
                        result = "D";
                        break;
                    case 4:
                        result = "E";
                        break;
                    case 5:
                        result = "F";
                        break;
                    case 6:
                        result = "G";
                        break;
                    case 7:
                        result = "H";
                        break;
                    case 8:
                        result = "I";
                        break;
                }
            }
        }
        result1 = result;

        career1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomClassActivity.class);
                intent.putExtra("A",A);
                intent.putExtra("B",B);
                intent.putExtra("C",C);
                intent.putExtra("D",D);
                intent.putExtra("E",E);
                intent.putExtra("F",F);
                intent.putExtra("G",G);
                intent.putExtra("H",H);
                intent.putExtra("I",I);
                Toast.makeText(getApplicationContext(),result1+" A값:"+A+" B값:"+B+" C값:"+C+" D값:"+D+" E값:"+E+" F값:"+F+" G값:"+G+" H값:"+H+" I값:"+I,Toast.LENGTH_SHORT).show();
                intent.putExtra("result",result1);
                startActivity(intent);
            }
        });
        career2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreditActivity.class);
                //Intent intent1 = new Intent(getApplicationContext(), RoadmapActivity.class);
                //Toast.makeText(getApplicationContext(),result1,Toast.LENGTH_SHORT).show();
                intent.putExtra("result",result1);
                //intent1.putExtra("result",result);
                startActivity(intent);
            }
        });
        career3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                intent.putExtra("type",1);
                startActivity(intent);
            }
        });
        career4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                intent.putExtra("type",2);
                startActivity(intent);
            }
        });
        career5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomClassActivity.class);
                startActivity(intent);
            }
        });
        career6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                career6.setText("A값 :"+A+" B값 :"+B+" C값 :"+C+" D값 :"+D+" E값 :"+E+" F값 :"+F+" G값 :"+G+" H값 :"+H+" I값 :"+I);
            }
        });

    }
}
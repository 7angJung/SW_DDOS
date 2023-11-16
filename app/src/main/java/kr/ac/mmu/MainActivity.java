package kr.ac.mmu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView monday, tuesday, wednesday, thursday, friday, saturday, sunday;
    TextView monday_morning, tuesday_morning, wednesday_morning, thursday_morning, friday_morning, saturday_morning, sunday_morning;
    TextView monday_lunch, tuesday_lunch, wednesday_lunch, thursday_lunch, friday_lunch, saturday_lunch, sunday_lunch;
    TextView monday_night, tuesday_night, wednesday_night, thursday_night, friday_night, saturday_night, sunday_night;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        monday = findViewById(R.id.monday_column);  tuesday = findViewById(R.id.tuesday_column);
        wednesday = findViewById(R.id.wednesday_column);    thursday = findViewById(R.id.thursday_column);
        friday = findViewById(R.id.friday_column);  saturday = findViewById(R.id.saturday_column);  sunday = findViewById(R.id.sunday_column);

        monday_morning = findViewById(R.id.monday_morning);  tuesday_morning = findViewById(R.id.tuesday_morning);
        wednesday_morning = findViewById(R.id.wednesday_morning);    thursday_morning = findViewById(R.id.thursday_morning);
        friday_morning = findViewById(R.id.friday_morning);  saturday_morning = findViewById(R.id.saturday_morning);
        sunday_morning = findViewById(R.id.sunday_morning);

        monday_lunch = findViewById(R.id.monday_lunch);  tuesday_lunch = findViewById(R.id.tuesday_lunch);
        wednesday_lunch = findViewById(R.id.wednesday_lunch);    thursday_lunch = findViewById(R.id.thursday_lunch);
        friday_lunch = findViewById(R.id.friday_lunch);  saturday_lunch = findViewById(R.id.saturday_lunch);
        sunday_lunch = findViewById(R.id.sunday_lunch);

        monday_night = findViewById(R.id.monday_night);  tuesday_night = findViewById(R.id.tuesday_night);
        wednesday_night = findViewById(R.id.wednesday_night);    thursday_night = findViewById(R.id.thursday_night);
        friday_night = findViewById(R.id.friday_night);  saturday_night = findViewById(R.id.saturday_night);
        sunday_night = findViewById(R.id.sunday_night);

        monday.setText("11/20 \n 월요일"); tuesday.setText("11/21 \n 화요일");    wednesday.setText("11/22 \n 수요일");
        thursday.setText("11/23 \n 목요일");   friday.setText("11/24 \n 금요일"); saturday.setText("11/25 \n 토요일");   sunday.setText("11/26 \n 일요일");

        monday_morning.setText(""); tuesday_morning.setText("");
        wednesday_morning.setText("");  thursday_morning.setText("");
        friday_morning.setText(""); saturday_morning.setText("");
        sunday_morning.setText("");

        monday_lunch.setText(""); tuesday_lunch.setText("");
        wednesday_lunch.setText("");  thursday_lunch.setText("");
        friday_lunch.setText(""); saturday_lunch.setText("");
        sunday_lunch.setText("");

        monday_night.setText(""); tuesday_night.setText("");
        wednesday_night.setText("");  thursday_night.setText("");
        friday_night.setText(""); saturday_night.setText("");
        sunday_night.setText("");


    }
}
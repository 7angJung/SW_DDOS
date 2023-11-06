package co.kr.mmu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class scheduleActivity extends AppCompatActivity{
    ActivityResultLauncher<Intent> launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_layout);

        Button button = findViewById(R.id.add_schedule);

        TextView mon1 = findViewById(R.id.monday1);
        TextView mon2 = findViewById(R.id.monday2);
        TextView mon3 = findViewById(R.id.monday3);
        TextView mon4 = findViewById(R.id.monday4);
        TextView mon5 = findViewById(R.id.monday5);
        TextView mon6 = findViewById(R.id.monday6);
        TextView mon7 = findViewById(R.id.monday7);
        TextView mon8 = findViewById(R.id.monday8);
        TextView mon9 = findViewById(R.id.monday9);

        TextView tue1 = findViewById(R.id.tuesday1);
        TextView tue2 = findViewById(R.id.tuesday2);
        TextView tue3 = findViewById(R.id.tuesday3);
        TextView tue4 = findViewById(R.id.tuesday4);
        TextView tue5 = findViewById(R.id.tuesday5);
        TextView tue6 = findViewById(R.id.tuesday6);
        TextView tue7 = findViewById(R.id.tuesday7);
        TextView tue8 = findViewById(R.id.tuesday8);
        TextView tue9 = findViewById(R.id.tuesday9);

        TextView wen1 = findViewById(R.id.wednesday1);
        TextView wen2 = findViewById(R.id.wednesday2);
        TextView wen3 = findViewById(R.id.wednesday3);
        TextView wen4 = findViewById(R.id.wednesday4);
        TextView wen5 = findViewById(R.id.wednesday5);
        TextView wen6 = findViewById(R.id.wednesday6);
        TextView wen7 = findViewById(R.id.wednesday7);
        TextView wen8 = findViewById(R.id.wednesday8);
        TextView wen9 = findViewById(R.id.wednesday9);

        TextView thu1 = findViewById(R.id.thursday1);
        TextView thu2 = findViewById(R.id.thursday2);
        TextView thu3 = findViewById(R.id.thursday3);
        TextView thu4 = findViewById(R.id.thursday4);
        TextView thu5 = findViewById(R.id.thursday5);
        TextView thu6 = findViewById(R.id.thursday6);
        TextView thu7 = findViewById(R.id.thursday7);
        TextView thu8 = findViewById(R.id.thursday8);
        TextView thu9 = findViewById(R.id.thursday9);

        TextView fri1 = findViewById(R.id.friday1);
        TextView fri2 = findViewById(R.id.friday2);
        TextView fri3 = findViewById(R.id.friday3);
        TextView fri4 = findViewById(R.id.friday4);
        TextView fri5 = findViewById(R.id.friday5);
        TextView fri6 = findViewById(R.id.friday6);
        TextView fri7 = findViewById(R.id.friday7);
        TextView fri8 = findViewById(R.id.friday8);
        TextView fri9 = findViewById(R.id.friday9);

        mon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Spinner spinner1 = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);


       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(scheduleActivity.this);

            LayoutInflater inflater = getLayoutInflater();
            View addschView = inflater.inflate(R.layout.addschedule_layout, null);

            builder.setView(addschView);

            AlertDialog dialog = builder.show();

            Button close = addschView.findViewById(R.id.close);

               spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                   @Override
                   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                   }

                   @Override
                   public void onNothingSelected(AdapterView<?> parent) {

                   }
               });
               spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                   @Override
                   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                   }

                   @Override
                   public void onNothingSelected(AdapterView<?> parent) {

                   }
               });

            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
           }
       });


    }
}


package co.kr.M_Git_Project;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TimeTableActivity extends AppCompatActivity{
    ActivityResultLauncher<Intent> launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        Button showDialog = findViewById(R.id.add_schedule);

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

        TextView informClassName = findViewById(R.id.className);
        TextView informProfessor = findViewById(R.id.professorName);
        TextView informClassRomm = findViewById(R.id.classRoomName);

        mon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder infor = new AlertDialog.Builder(TimeTableActivity.this);
                View informView = getLayoutInflater().inflate(R.layout.schedule_inform, null);
                infor.setTitle("강의정보");

                infor.setView(informView);
                AlertDialog informdialog = infor.create();
                infor.show();

                TextView name = findViewById(R.id.className);
                TextView professor = findViewById(R.id.professorName);
                TextView classroom = findViewById(R.id.classRoomName);

            }

        });


        // 시간표 추가 버튼 눌렀을시 수행하는 다이얼로그
        showDialog = (Button) findViewById(R.id.add_schedule);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(TimeTableActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.addschedule_layout, null);
                mBuilder.setTitle("강의 정보 추가");

                //스피너 생성
                Spinner spinner1 = (Spinner) mView.findViewById(R.id.spinner1);
                Spinner spinner2 = (Spinner) mView.findViewById(R.id.spinner2);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(TimeTableActivity.this,
                        android.R.layout.simple_spinner_item,
                        getResources().getStringArray(R.array.day));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // 첫번째 스피너, 요일을 정하는 기능
                spinner1.setAdapter(adapter);
                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                // 두번째 스피너, 수업시간(몇교시인지)을 정하는 기능
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(TimeTableActivity.this,
                        android.R.layout.simple_spinner_item,
                        getResources().getStringArray(R.array.time));

                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(adapter2);
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();

                Button addschedule = mView.findViewById(R.id.addsch);
                Button closebut = mView.findViewById(R.id.cancel);
                // 강의 정보 추가 버튼 기능
                //
                addschedule.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView name = mView.findViewById(R.id.editTextTextPersonName);
                        TextView professor = mView.findViewById(R.id.editTextTextPersonName2);
                        TextView classroom = mView.findViewById(R.id.editTextTextPersonName3);


                        String ClassName = name.getText().toString();
                        String professorName = professor.getText().toString();
                        String classroomName = classroom.getText().toString();

                        //스피너 값 변수화
                        String selectDay = "";
                        selectDay = (String) spinner1.getAdapter().getItem(spinner1.getSelectedItemPosition());
                        String selectTime = "";
                        selectTime = (String) spinner2.getAdapter().getItem(spinner2.getSelectedItemPosition());

                        //월요일 시간 넣기
                        if ("월".equals(selectDay)&&"1교시".equals(selectTime)) {
                            mon1.setText(name.getText());
                        } else if ("월".equals(selectDay)&&"2교시".equals(selectTime)) {
                            mon2.setText(name.getText());
                        } else if ("월".equals(selectDay)&&"3교시".equals(selectTime)) {
                            mon3.setText(name.getText());
                        } else if ("월".equals(selectDay)&&"4교시".equals(selectTime)) {
                            mon4.setText(name.getText());
                        } else if ("월".equals(selectDay)&&"5교시".equals(selectTime)) {
                            mon5.setText(name.getText());
                        } else if ("월".equals(selectDay)&&"6교시".equals(selectTime)) {
                            mon6.setText(name.getText());
                        } else if ("월".equals(selectDay)&&"7교시".equals(selectTime)) {
                            mon7.setText(name.getText());
                        } else if ("월".equals(selectDay)&&"8교시".equals(selectTime)) {
                            mon8.setText(name.getText());
                        } else if ("월".equals(selectDay)&&"9교시".equals(selectTime)) {
                            mon9.setText(name.getText());
                        }

                        //화요일 시간 넣기
                        if ("화".equals(selectDay)&&"1교시".equals(selectTime)) {
                            tue1.setText(name.getText());
                        } else if ("화".equals(selectDay)&&"2교시".equals(selectTime)) {
                            tue2.setText(name.getText());
                        } else if ("화".equals(selectDay)&&"3교시".equals(selectTime)) {
                            tue3.setText(name.getText());
                        } else if ("화".equals(selectDay)&&"4교시".equals(selectTime)) {
                            tue4.setText(name.getText());
                        } else if ("화".equals(selectDay)&&"5교시".equals(selectTime)) {
                            tue5.setText(name.getText());
                        } else if ("화".equals(selectDay)&&"6교시".equals(selectTime)) {
                            tue6.setText(name.getText());
                        } else if ("화".equals(selectDay)&&"7교시".equals(selectTime)) {
                            tue7.setText(name.getText());
                        } else if ("화".equals(selectDay)&&"8교시".equals(selectTime)) {
                            tue8.setText(name.getText());
                        } else if ("화".equals(selectDay)&&"9교시".equals(selectTime)) {
                            tue9.setText(name.getText());
                        }

                        //수요일 시간 넣기
                        if ("수".equals(selectDay)&&"1교시".equals(selectTime)) {
                            wen1.setText(name.getText());
                        } else if ("수".equals(selectDay)&&"2교시".equals(selectTime)) {
                            wen2.setText(name.getText());
                        } else if ("수".equals(selectDay)&&"3교시".equals(selectTime)) {
                            wen3.setText(name.getText());
                        } else if ("수".equals(selectDay)&&"4교시".equals(selectTime)) {
                            wen4.setText(name.getText());
                        } else if ("수".equals(selectDay)&&"5교시".equals(selectTime)) {
                            wen5.setText(name.getText());
                        } else if ("수".equals(selectDay)&&"6교시".equals(selectTime)) {
                            wen6.setText(name.getText());
                        } else if ("수".equals(selectDay)&&"7교시".equals(selectTime)) {
                            wen7.setText(name.getText());
                        } else if ("수".equals(selectDay)&&"8교시".equals(selectTime)) {
                            wen8.setText(name.getText());
                        } else if ("수".equals(selectDay)&&"9교시".equals(selectTime)) {
                            wen9.setText(name.getText());
                        }

                        //목요일 시간 넣기
                        if ("목".equals(selectDay)&&"1교시".equals(selectTime)) {
                            thu1.setText(name.getText());
                        } else if ("목".equals(selectDay)&&"2교시".equals(selectTime)) {
                            thu2.setText(name.getText());
                        } else if ("목".equals(selectDay)&&"3교시".equals(selectTime)) {
                            thu3.setText(name.getText());
                        } else if ("목".equals(selectDay)&&"4교시".equals(selectTime)) {
                            thu4.setText(name.getText());
                        } else if ("목".equals(selectDay)&&"5교시".equals(selectTime)) {
                            thu5.setText(name.getText());
                        } else if ("목".equals(selectDay)&&"6교시".equals(selectTime)) {
                            thu6.setText(name.getText());
                        } else if ("목".equals(selectDay)&&"7교시".equals(selectTime)) {
                            thu7.setText(name.getText());
                        } else if ("목".equals(selectDay)&&"8교시".equals(selectTime)) {
                            thu8.setText(name.getText());
                        } else if ("목".equals(selectDay)&&"9교시".equals(selectTime)) {
                            thu9.setText(name.getText());
                        }

                        //금요일 시간 넣기
                        if ("금".equals(selectDay)&&"1교시".equals(selectTime)) {
                            fri1.setText(name.getText());
                        } else if ("금".equals(selectDay)&&"2교시".equals(selectTime)) {
                            fri2.setText(name.getText());
                        } else if ("금".equals(selectDay)&&"3교시".equals(selectTime)) {
                            fri3.setText(name.getText());
                        } else if ("금".equals(selectDay)&&"4교시".equals(selectTime)) {
                            fri4.setText(name.getText());
                        } else if ("금".equals(selectDay)&&"5교시".equals(selectTime)) {
                            fri5.setText(name.getText());
                        } else if ("금".equals(selectDay)&&"6교시".equals(selectTime)) {
                            fri6.setText(name.getText());
                        } else if ("금".equals(selectDay)&&"7교시".equals(selectTime)) {
                            fri7.setText(name.getText());
                        } else if ("금".equals(selectDay)&&"8교시".equals(selectTime)) {
                            fri8.setText(name.getText());
                        } else if ("금".equals(selectDay)&&"9교시".equals(selectTime)) {
                            fri9.setText(name.getText());
                        }

                        dialog.dismiss();

                        // informClassName.setText(name.getText());
                        //informProfessor.setText(professor.getText());
                        //informClassRomm.setText(classroom.getText());
                    }

                });

            }
        });

        }
}
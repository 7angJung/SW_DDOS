package co.kr.M_Git_Project;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class UserInformActivity extends AppCompatActivity {
    int Acount,Bcount,Ccount,Dcount,Ecount
            ,Fcount,Gcount,Hcount,Icount,test; // 우선순위를 정하기 위한 변수 카운트

    String FirstUserDepartment, SecondUserDepartment, ThirdUserDepartment; //사용자에게 추천할 분야 1,2,3 순위



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_inform);
        TextView testtext = (TextView)findViewById(R.id.testtext);
        Button startbut = (Button) findViewById(R.id.startButton);
        Button subMit = (Button)findViewById(R.id.submit);
        RadioGroup rGroup1, rGroup2, rGroup3, rGroup4, rGroup5
                ,rGroup6, rGroup7, rGroup8, rGroup9, rGroup10
                ,rGroup11, rGroup12, rGroup13, rGroup14, rGroup15
                ,rGroup16, rGroup17, rGroup18, rGroup19, rGroup20
                ,rGroup21 ,rGroup22, rGroup23, rGroup24, rGroup25
                ,rGroup26 ,rGroup27, rGroup28, rGroup29, rGroup30
                ,rGroup31 ,rGroup32, rGroup33, rGroup34;

        rGroup1 =(RadioGroup) findViewById(R.id.rGroup1);
        rGroup2 =(RadioGroup) findViewById(R.id.rGroup2);
        rGroup3 =(RadioGroup) findViewById(R.id.rGroup3);
        rGroup4 =(RadioGroup) findViewById(R.id.rGroup4);
        rGroup5 =(RadioGroup) findViewById(R.id.rGroup5);
        rGroup6 =(RadioGroup) findViewById(R.id.rGroup6);
        rGroup7 =(RadioGroup) findViewById(R.id.rGroup7);
        rGroup8 =(RadioGroup) findViewById(R.id.rGroup8);
        rGroup9 =(RadioGroup) findViewById(R.id.rGroup9);
        rGroup10 =(RadioGroup) findViewById(R.id.rGroup10);
        rGroup11 =(RadioGroup) findViewById(R.id.rGroup11);
        rGroup12 =(RadioGroup) findViewById(R.id.rGroup12);
        rGroup13 =(RadioGroup) findViewById(R.id.rGroup13);
        rGroup14 =(RadioGroup) findViewById(R.id.rGroup14);
        rGroup15 =(RadioGroup) findViewById(R.id.rGroup15);
        rGroup16 =(RadioGroup) findViewById(R.id.rGroup16);
        rGroup17 =(RadioGroup) findViewById(R.id.rGroup17);
        rGroup18 =(RadioGroup) findViewById(R.id.rGroup18);
        rGroup19 =(RadioGroup) findViewById(R.id.rGroup19);
        rGroup20 =(RadioGroup) findViewById(R.id.rGroup20);
        rGroup21 =(RadioGroup) findViewById(R.id.rGroup21);
        rGroup22 =(RadioGroup) findViewById(R.id.rGroup22);
        rGroup23 =(RadioGroup) findViewById(R.id.rGroup23);
        rGroup24 =(RadioGroup) findViewById(R.id.rGroup24);
        rGroup25 =(RadioGroup) findViewById(R.id.rGroup25);
        rGroup26 =(RadioGroup) findViewById(R.id.rGroup26);
        rGroup27 =(RadioGroup) findViewById(R.id.rGroup27);
        rGroup28 =(RadioGroup) findViewById(R.id.rGroup28);
        rGroup29 =(RadioGroup) findViewById(R.id.rGroup29);
        rGroup30 =(RadioGroup) findViewById(R.id.rGroup30);
        rGroup31 =(RadioGroup) findViewById(R.id.rGroup31);
        rGroup32 =(RadioGroup) findViewById(R.id.rGroup32);
        rGroup33 =(RadioGroup) findViewById(R.id.rGroup33);
        rGroup34 =(RadioGroup) findViewById(R.id.rGroup34);

        startbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), CareerExplorationActivity.class);
                intent.putExtra("A",Acount);
                intent.putExtra("B",Bcount);
                intent.putExtra("C",Ccount);
                intent.putExtra("D",Dcount);
                intent.putExtra("E",Ecount);
                intent.putExtra("F",Fcount);
                intent.putExtra("G",Gcount);
                intent.putExtra("H",Hcount);
                intent.putExtra("I",Icount);
                startActivity(intent);
            }
        });

        subMit.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          CountClean();
                                          int selectedId1 = rGroup1.getCheckedRadioButtonId();
                                          if (selectedId1 != -1) {
                                              switch (selectedId1) {
                                                  case R.id.rBut1_1:
                                                      Acount += 8;
                                                      break;
                                                  case R.id.rBut1_2:
                                                      Acount += 6;
                                                      break;
                                                  case R.id.rBut1_3:
                                                      Acount += 4;
                                                      break;
                                                  case R.id.rBut1_4:
                                                      Acount += 2;
                                                      break;
                                                  case R.id.rBut1_5:
                                                      Acount += 0;
                                                      break;
                                              }
                                          }
                                          int selectedId2 = rGroup2.getCheckedRadioButtonId();
                                          if (selectedId2 != -1) {
                                              switch (selectedId2) {
                                                  case R.id.rBut2_1:
                                                      Acount += 8;
                                                      break;
                                                  case R.id.rBut2_2:
                                                      Acount += 6;
                                                      break;
                                                  case R.id.rBut2_3:
                                                      Acount += 4;
                                                      break;
                                                  case R.id.rBut2_4:
                                                      Acount += 2;
                                                      break;
                                                  case R.id.rBut2_5:
                                                      Acount += 0;
                                                      break;
                                              }
                                          }
                                          int selectedId3 = rGroup3.getCheckedRadioButtonId();
                                          if (selectedId3 != -1) {
                                              switch (selectedId3) {
                                                  case R.id.rBut3_1:
                                                      Bcount += 8;
                                                      break;
                                                  case R.id.rBut3_2:
                                                      Bcount += 6;
                                                      break;
                                                  case R.id.rBut3_3:
                                                      Bcount += 4;
                                                      break;
                                                  case R.id.rBut3_4:
                                                      Bcount += 2;
                                                      break;
                                                  case R.id.rBut3_5:
                                                      Bcount += 0;
                                                      break;
                                              }
                                          }
                                          int selectedId4 = rGroup4.getCheckedRadioButtonId();
                                          if (selectedId4 != -1) {
                                              switch (selectedId4) {
                                                  case R.id.rBut4_1:
                                                      Ccount += 8;
                                                      break;
                                                  case R.id.rBut4_2:
                                                      Ccount += 6;
                                                      break;
                                                  case R.id.rBut4_3:
                                                      Ccount += 4;
                                                      break;
                                                  case R.id.rBut4_4:
                                                      Ccount += 2;
                                                      break;
                                                  case R.id.rBut4_5:
                                                      Ccount += 0;
                                                      break;
                                              }
                                          }
                                          int selectedId5 = rGroup5.getCheckedRadioButtonId();
                                          if (selectedId5 != -1) {
                                              switch (selectedId5) {
                                                  case R.id.rBut5_1:
                                                      Dcount += 10;
                                                      break;
                                                  case R.id.rBut5_2:
                                                      Dcount += 8;
                                                      break;
                                                  case R.id.rBut5_3:
                                                      Dcount += 6;
                                                      break;
                                                  case R.id.rBut5_4:
                                                      Dcount += 4;
                                                      break;
                                                  case R.id.rBut5_5:
                                                      Dcount += 2;
                                                      break;
                                              }
                                          }
                                          int selectedId6 = rGroup6.getCheckedRadioButtonId();
                                          if (selectedId6 != -1) {
                                              switch (selectedId6) {
                                                  case R.id.rBut6_1:
                                                      Ecount += 8;
                                                      break;
                                                  case R.id.rBut6_2:
                                                      Ecount += 6;
                                                      break;
                                                  case R.id.rBut6_3:
                                                      Ecount += 4;
                                                      break;
                                                  case R.id.rBut6_4:
                                                      Ecount += 2;
                                                      break;
                                                  case R.id.rBut6_5:
                                                      Ecount += 0;
                                                      break;
                                              }
                                          }
                                          int selectedId7 = rGroup7.getCheckedRadioButtonId();
                                          if (selectedId7 != -1) {
                                              switch (selectedId7) {
                                                  case R.id.rBut7_1:
                                                      Ecount += 8;
                                                      break;
                                                  case R.id.rBut7_2:
                                                      Ecount += 6;
                                                      break;
                                                  case R.id.rBut7_3:
                                                      Ecount += 4;
                                                      break;
                                                  case R.id.rBut7_4:
                                                      Ecount += 2;
                                                      break;
                                                  case R.id.rBut7_5:
                                                      Ecount += 0;
                                                      break;
                                              }
                                          }
                                          int selectedId8 = rGroup8.getCheckedRadioButtonId();
                                          if (selectedId8 != -1) {
                                              switch (selectedId8) {
                                                  case R.id.rBut8_1:
                                                      Fcount += 10;
                                                      break;
                                                  case R.id.rBut8_2:
                                                      Fcount += 8;
                                                      break;
                                                  case R.id.rBut8_3:
                                                      Fcount += 6;
                                                      break;
                                                  case R.id.rBut8_4:
                                                      Fcount += 4;
                                                      break;
                                                  case R.id.rBut8_5:
                                                      Fcount += 2;
                                                      break;
                                              }
                                          }
                                          int selectedId9 = rGroup9.getCheckedRadioButtonId();
                                          if (selectedId9 != -1) {
                                              switch (selectedId9) {
                                                  case R.id.rBut9_1:
                                                      Fcount += 10;
                                                      break;
                                                  case R.id.rBut9_2:
                                                      Fcount += 8;
                                                      break;
                                                  case R.id.rBut9_3:
                                                      Fcount += 6;
                                                      break;
                                                  case R.id.rBut9_4:
                                                      Fcount += 4;
                                                      break;
                                                  case R.id.rBut9_5:
                                                      Fcount += 2;
                                                      break;
                                              }
                                          }
                                          int selectedId10 = rGroup10.getCheckedRadioButtonId();
                                          if (selectedId10 != -1) {
                                              switch (selectedId10) {
                                                  case R.id.rBut10_1:
                                                      Gcount += 12;
                                                      break;
                                                  case R.id.rBut10_2:
                                                      Gcount += 10;
                                                      break;
                                                  case R.id.rBut10_3:
                                                      Gcount += 8;
                                                      break;
                                                  case R.id.rBut10_4:
                                                      Gcount += 3;
                                                      break;
                                                  case R.id.rBut10_5:
                                                      Gcount += 1;
                                                      break;
                                              }
                                          }
                                          int selectedId11 = rGroup11.getCheckedRadioButtonId();
                                          if (selectedId11 != -1) {
                                              switch (selectedId11) {
                                                  case R.id.rBut11_1:
                                                      Hcount += 8;
                                                      break;
                                                  case R.id.rBut11_2:
                                                      Hcount += 6;
                                                      break;
                                                  case R.id.rBut11_3:
                                                      Hcount += 4;
                                                      break;
                                                  case R.id.rBut11_4:
                                                      Hcount += 2;
                                                      break;
                                                  case R.id.rBut11_5:
                                                      Hcount += 0;
                                                      break;
                                              }
                                          }
                                          int selectedId12 = rGroup12.getCheckedRadioButtonId();
                                          if (selectedId12 != -1) {
                                              switch (selectedId12) {
                                                  case R.id.rBut12_1:
                                                      Hcount += 8;
                                                      break;
                                                  case R.id.rBut12_2:
                                                      Hcount += 6;
                                                      break;
                                                  case R.id.rBut12_3:
                                                      Hcount += 4;
                                                      break;
                                                  case R.id.rBut12_4:
                                                      Hcount += 2;
                                                      break;
                                                  case R.id.rBut12_5:
                                                      Hcount += 0;
                                                      break;
                                              }
                                          }
                                          int selectedId13 = rGroup13.getCheckedRadioButtonId();
                                          if (selectedId13 != -1) {
                                              switch (selectedId13) {
                                                  case R.id.rBut13_1:
                                                      Icount += 14;
                                                      break;
                                                  case R.id.rBut13_2:
                                                      Icount += 11;
                                                      break;
                                                  case R.id.rBut13_3:
                                                      Icount += 8;
                                                      break;
                                                  case R.id.rBut13_4:
                                                      Icount += 5;
                                                      break;
                                                  case R.id.rBut13_5:
                                                      Icount += 2;
                                                      break;
                                              }
                                          }
                                          CheckBox checkBox14_1 = findViewById(R.id.rBut14_1);
                                          CheckBox checkBox14_2 = findViewById(R.id.rBut14_2);
                                          CheckBox checkBox14_3 = findViewById(R.id.rBut14_3);
                                          CheckBox checkBox14_4 = findViewById(R.id.rBut14_4);
                                          CheckBox checkBox14_5 = findViewById(R.id.rBut14_5);
                                          if (checkBox14_1.isChecked()) {
                                              Acount += 3;
                                          }
                                          if (checkBox14_2.isChecked()) {
                                              Acount += 3;
                                          }
                                          if (checkBox14_3.isChecked()) {
                                              Bcount += 6;
                                          }
                                          if (checkBox14_4.isChecked()) {
                                              Ccount += 3;
                                          }
                                          if (checkBox14_5.isChecked()) {
                                              Ccount += 3;
                                          }

                                          CheckBox checkBox15_1 = findViewById(R.id.rBut15_1);
                                          CheckBox checkBox15_2 = findViewById(R.id.rBut15_2);
                                          CheckBox checkBox15_3 = findViewById(R.id.rBut15_3);
                                          CheckBox checkBox15_4 = findViewById(R.id.rBut15_4);
                                          CheckBox checkBox15_5 = findViewById(R.id.rBut15_5);
                                          if (checkBox14_1.isChecked()) {
                                              Dcount += 4;
                                          }
                                          if (checkBox14_2.isChecked()) {
                                              Dcount += 4;
                                          }
                                          if (checkBox14_3.isChecked()) {
                                              Ecount += 3;
                                          }
                                          if (checkBox14_4.isChecked()) {
                                              Ecount += 3;
                                          }
                                          if (checkBox14_5.isChecked()) {
                                              Fcount += 6;
                                          }
                                          CheckBox checkBox16_1 = findViewById(R.id.rBut16_1);
                                          CheckBox checkBox16_2 = findViewById(R.id.rBut16_2);
                                          CheckBox checkBox16_3 = findViewById(R.id.rBut16_3);
                                          CheckBox checkBox16_4 = findViewById(R.id.rBut16_4);
                                          CheckBox checkBox16_5 = findViewById(R.id.rBut16_5);
                                          if (checkBox14_1.isChecked()) {
                                              Gcount += 10;
                                          }
                                          if (checkBox14_2.isChecked()) {
                                              Hcount += 4;
                                          }
                                          if (checkBox14_3.isChecked()) {
                                              Hcount += 4;
                                          }
                                          if (checkBox14_4.isChecked()) {
                                              Icount += 6;
                                          }
                                          if (checkBox14_5.isChecked()) {
                                              Icount += 6;
                                          }
                                          int selectedId17 = rGroup17.getCheckedRadioButtonId();
                                          if (selectedId17 != -1) {
                                              switch (selectedId17) {
                                                  case R.id.rBut17_1:
                                                      Acount += 5;
                                                      break;
                                                  case R.id.rBut17_2:
                                                      Acount += 4;
                                                      break;
                                                  case R.id.rBut17_3:
                                                      Acount += 3;
                                                      break;
                                                  case R.id.rBut17_4:
                                                      Acount += 2;
                                                      break;
                                                  case R.id.rBut17_5:
                                                      Acount += 1;
                                                      break;
                                              }
                                          }
                                          int selectedId18 = rGroup18.getCheckedRadioButtonId();
                                          if (selectedId18 != -1) {
                                              switch (selectedId18) {
                                                  case R.id.rBut18_1:
                                                      Bcount += 8;
                                                      break;
                                                  case R.id.rBut18_2:
                                                      Bcount += 6;
                                                      break;
                                                  case R.id.rBut18_3:
                                                      Bcount += 4;
                                                      break;
                                                  case R.id.rBut18_4:
                                                      Bcount += 2;
                                                      break;
                                                  case R.id.rBut18_5:
                                                      Bcount += 0;
                                                      break;
                                              }
                                          }
                                          int selectedId19 = rGroup19.getCheckedRadioButtonId();
                                          if (selectedId19 != -1) {
                                              switch (selectedId19) {
                                                  case R.id.rBut19_1:
                                                      Ccount += 5;
                                                      break;
                                                  case R.id.rBut19_2:
                                                      Ccount += 4;
                                                      break;
                                                  case R.id.rBut19_3:
                                                      Ccount += 3;
                                                      break;
                                                  case R.id.rBut19_4:
                                                      Ccount += 2;
                                                      break;
                                                  case R.id.rBut19_5:
                                                      Ccount += 1;
                                                      break;
                                              }
                                          }
                                          int selectedId20 = rGroup20.getCheckedRadioButtonId();
                                          if (selectedId20 != -1) {
                                              switch (selectedId20) {
                                                  case R.id.rBut20_1:
                                                      Dcount += 10;
                                                      break;
                                                  case R.id.rBut20_2:
                                                      Dcount += 8;
                                                      break;
                                                  case R.id.rBut20_3:
                                                      Dcount += 6;
                                                      break;
                                                  case R.id.rBut20_4:
                                                      Dcount += 4;
                                                      break;
                                                  case R.id.rBut20_5:
                                                      Dcount += 2;
                                                      break;
                                              }
                                          }
                                          int selectedId21 = rGroup21.getCheckedRadioButtonId();
                                          if (selectedId21 != -1) {
                                              switch (selectedId21) {
                                                  case R.id.rBut21_1:
                                                      Ecount += 8;
                                                      break;
                                                  case R.id.rBut21_2:
                                                      Ecount += 6;
                                                      break;
                                                  case R.id.rBut21_3:
                                                      Ecount += 4;
                                                      break;
                                                  case R.id.rBut21_4:
                                                      Ecount += 2;
                                                      break;
                                                  case R.id.rBut21_5:
                                                      Ecount += 0;
                                                      break;
                                              }
                                          }
                                          int selectedId22 = rGroup22.getCheckedRadioButtonId();
                                          if (selectedId22 != -1) {
                                              switch (selectedId22) {
                                                  case R.id.rBut22_1:
                                                      Fcount += 10;
                                                      break;
                                                  case R.id.rBut22_2:
                                                      Fcount += 8;
                                                      break;
                                                  case R.id.rBut22_3:
                                                      Fcount += 6;
                                                      break;
                                                  case R.id.rBut22_4:
                                                      Fcount += 4;
                                                      break;
                                                  case R.id.rBut22_5:
                                                      Fcount += 2;
                                                      break;
                                              }
                                          }
                                          int selectedId23 = rGroup23.getCheckedRadioButtonId();
                                          if (selectedId23 != -1) {
                                              switch (selectedId23) {
                                                  case R.id.rBut23_1:
                                                      Gcount += 10;
                                                      break;
                                                  case R.id.rBut23_2:
                                                      Gcount += 8;
                                                      break;
                                                  case R.id.rBut23_3:
                                                      Gcount += 6;
                                                      break;
                                                  case R.id.rBut23_4:
                                                      Gcount += 4;
                                                      break;
                                                  case R.id.rBut23_5:
                                                      Gcount += 2;
                                                      break;
                                              }
                                          }
                                          int selectedId24 = rGroup24.getCheckedRadioButtonId();
                                          if (selectedId24 != -1) {
                                              switch (selectedId24) {
                                                  case R.id.rBut24_1:
                                                      Hcount += 10;
                                                      break;
                                                  case R.id.rBut24_2:
                                                      Hcount += 8;
                                                      break;
                                                  case R.id.rBut24_3:
                                                      Hcount += 6;
                                                      break;
                                                  case R.id.rBut24_4:
                                                      Hcount += 4;
                                                      break;
                                                  case R.id.rBut24_5:
                                                      Hcount += 2;
                                                      break;
                                              }
                                          }
                                          int selectedId25 = rGroup25.getCheckedRadioButtonId();
                                          if (selectedId25 != -1) {
                                              switch (selectedId25) {
                                                  case R.id.rBut25_1:
                                                      Icount += 12;
                                                      break;
                                                  case R.id.rBut25_2:
                                                      Icount += 10;
                                                      break;
                                                  case R.id.rBut25_3:
                                                      Icount += 8;
                                                      break;
                                                  case R.id.rBut25_4:
                                                      Icount += 6;
                                                      break;
                                                  case R.id.rBut25_5:
                                                      Icount += 2;
                                                      break;
                                              }
                                          }
                                          CheckBox checkBox26_1 = findViewById(R.id.rBut26_1);
                                          CheckBox checkBox26_2 = findViewById(R.id.rBut26_2);
                                          CheckBox checkBox26_3 = findViewById(R.id.rBut26_3);
                                          CheckBox checkBox26_4 = findViewById(R.id.rBut26_4);
                                          CheckBox checkBox26_5 = findViewById(R.id.rBut26_5);
                                          if (checkBox26_1.isChecked()) {
                                              Acount += 6;
                                          }
                                          if (checkBox26_2.isChecked()) {
                                              Bcount += 7;
                                          }
                                          if (checkBox26_3.isChecked()) {
                                              Ccount += 7;
                                          }
                                          if (checkBox26_4.isChecked()) {
                                              Dcount += 8;
                                          }
                                          if (checkBox26_5.isChecked()) {
                                              Ecount += 8;
                                          }
                                          CheckBox checkBox27_1 = findViewById(R.id.rBut27_1);
                                          CheckBox checkBox27_2 = findViewById(R.id.rBut27_2);
                                          CheckBox checkBox27_3 = findViewById(R.id.rBut27_3);
                                          CheckBox checkBox27_4 = findViewById(R.id.rBut27_4);
                                          CheckBox checkBox27_5 = findViewById(R.id.rBut27_5);
                                          if (checkBox26_1.isChecked()) {
                                              Fcount += 8;
                                          }
                                          if (checkBox26_2.isChecked()) {
                                              Gcount += 9;
                                          }
                                          if (checkBox26_3.isChecked()) {
                                              Hcount += 8;
                                          }
                                          if (checkBox26_4.isChecked()) {
                                              Icount += 8;
                                          }
                                          if (checkBox26_5.isChecked()) {
                                          }
                                          int selectedId28 = rGroup28.getCheckedRadioButtonId();
                                          if (selectedId28 != -1) {
                                              switch (selectedId28) {
                                                  case R.id.rBut28_1:
                                                      Dcount += 4;
                                                      Ecount += 3;
                                                      break;
                                                  case R.id.rBut28_2:
                                                      Dcount += 2;
                                                      Ecount += 2;
                                                      break;
                                                  case R.id.rBut28_3:
                                                      Gcount += 4;
                                                      break;
                                                  case R.id.rBut28_4:
                                                      Bcount += 1;
                                                      Ccount += 1;
                                                      Fcount += 1;
                                                      Hcount += 1;
                                                      Icount += 2;
                                                      break;
                                                  case R.id.rBut28_5:
                                                      Bcount += 3;
                                                      Ccount += 3;
                                                      Fcount += 3;
                                                      Hcount += 3;
                                                      Icount += 4;
                                                      break;
                                              }
                                          }
                                          int selectedId29 = rGroup29.getCheckedRadioButtonId();
                                          if (selectedId29 != -1) {
                                              switch (selectedId29) {
                                                  case R.id.rBut29_1:
                                                      Bcount += 3;
                                                      Ccount += 3;
                                                      Hcount += 4;
                                                      break;
                                                  case R.id.rBut29_2:
                                                      Bcount += 1;
                                                      Ccount += 1;
                                                      Hcount += 2;
                                                      break;
                                                  case R.id.rBut29_3:
                                                      Dcount += 2;
                                                      Ecount += 2;
                                                      Icount += 2;
                                                      break;
                                                  case R.id.rBut29_4:
                                                      Acount += 1;
                                                      Fcount += 2;
                                                      Gcount += 2;
                                                      break;
                                                  case R.id.rBut29_5:
                                                      Acount += 2;
                                                      Fcount += 4;
                                                      Gcount += 4;
                                                      break;
                                              }
                                          }
                                          int selectedId30 = rGroup30.getCheckedRadioButtonId();
                                          if (selectedId30 != -1) {
                                              switch (selectedId30) {
                                                  case R.id.rBut30_1:
                                                      Acount += 2;
                                                      Fcount += 3;
                                                      Gcount += 4;
                                                      break;
                                                  case R.id.rBut30_2:
                                                      Acount += 1;
                                                      Fcount += 1;
                                                      Gcount += 2;
                                                      break;
                                                  case R.id.rBut30_3:
                                                      Ecount += 1;
                                                      Icount += 3;
                                                      break;
                                                  case R.id.rBut30_4:
                                                      Bcount += 2;
                                                      Ccount += 2;
                                                      Dcount += 2;
                                                      Hcount += 2;
                                                      break;
                                                  case R.id.rBut30_5:
                                                      Bcount += 4;
                                                      Ccount += 4;
                                                      Dcount += 4;
                                                      Hcount += 4;
                                                      break;
                                              }
                                          }
                                          int selectedId31 = rGroup31.getCheckedRadioButtonId();
                                          if (selectedId31 != -1) {
                                              switch (selectedId31) {
                                                  case R.id.rBut31_1:
                                                      Ecount += 4;
                                                      break;
                                                  case R.id.rBut31_2:
                                                      Ecount += 2;
                                                      break;
                                                  case R.id.rBut31_3:
                                                      Acount += 2;
                                                      Gcount += 3;
                                                      break;
                                                  case R.id.rBut31_4:
                                                      Bcount += 2;
                                                      Ccount += 2;
                                                      Dcount += 2;
                                                      Fcount += 2;
                                                      Icount += 2;
                                                      Hcount += 1;
                                                      break;
                                                  case R.id.rBut31_5:
                                                      Bcount += 4;
                                                      Ccount += 4;
                                                      Dcount += 4;
                                                      Fcount += 4;
                                                      Icount += 4;
                                                      Hcount += 3;
                                                      break;
                                              }
                                          }
                                          int selectedId32 = rGroup32.getCheckedRadioButtonId();
                                          if (selectedId32 != -1) {
                                              switch (selectedId32) {
                                                  case R.id.rBut32_1:
                                                      Dcount += 4;
                                                      break;
                                                  case R.id.rBut32_2:
                                                      Dcount += 2;
                                                      break;
                                                  case R.id.rBut32_3:
                                                      Ecount += 4;
                                                      break;
                                                  case R.id.rBut32_4:
                                                      Acount += 1;
                                                      Bcount += 1;
                                                      Ccount += 2;
                                                      Fcount += 2;
                                                      Gcount += 2;
                                                      Icount += 2;
                                                      Hcount += 2;
                                                      break;
                                                  case R.id.rBut32_5:
                                                      Acount += 3;
                                                      Bcount += 3;
                                                      Ccount += 4;
                                                      Fcount += 4;
                                                      Gcount += 4;
                                                      Icount += 4;
                                                      Hcount += 4;
                                                      break;
                                              }
                                          }
                                          int selectedId33 = rGroup33.getCheckedRadioButtonId();
                                          if (selectedId33 != -1) {
                                              switch (selectedId33) {
                                                  case R.id.rBut33_1:
                                                      Bcount += 4;
                                                      Ccount += 4;
                                                      Hcount += 4;
                                                      break;
                                                  case R.id.rBut33_2:
                                                      Bcount += 2;
                                                      Ccount += 2;
                                                      Hcount += 2;
                                                      break;
                                                  case R.id.rBut33_3:
                                                      Dcount += 2;
                                                      Icount += 3;
                                                      break;
                                                  case R.id.rBut33_4:
                                                      Acount += 2;
                                                      Ecount += 2;
                                                      Gcount += 2;
                                                      Fcount += 2;
                                                      break;
                                                  case R.id.rBut33_5:
                                                      Acount += 4;
                                                      Ecount += 4;
                                                      Gcount += 4;
                                                      Fcount += 4;
                                                      break;
                                              }
                                          }
                                          int selectedId34 = rGroup34.getCheckedRadioButtonId();
                                          if (selectedId34 != -1) {
                                              switch (selectedId34) {
                                                  case R.id.rBut34_1:
                                                      Acount += 4;
                                                      Gcount += 4;
                                                      break;
                                                  case R.id.rBut34_2:
                                                      Acount += 2;
                                                      Gcount += 2;
                                                      break;
                                                  case R.id.rBut34_3:
                                                      Fcount += 2;
                                                      Icount += 2;
                                                      break;
                                                  case R.id.rBut34_4:
                                                      Bcount += 2;
                                                      Ccount += 2;
                                                      Dcount += 2;
                                                      Ecount += 2;
                                                      Hcount += 2;
                                                      break;
                                                  case R.id.rBut34_5:
                                                      Bcount += 4;
                                                      Ccount += 4;
                                                      Dcount += 4;
                                                      Ecount += 4;
                                                      Hcount += 4;
                                                      break;
                                              }
                                          }
                                          testtext.setText(String.valueOf(Acount+" "+Bcount+" "+Ccount+" "+Dcount+" "+Ecount+" "+Fcount+" "+Gcount+" "+Hcount+" "));
                                      }

        });

    }



    //변수 초기화 함수
    public void CountClean(){
        Acount = 0 ;
        Bcount = 0 ;
        Ccount = 0 ;
        Dcount = 0 ;
        Ecount = 0 ;
        Fcount = 0 ;
        Gcount = 0 ;
        Hcount = 0 ;
        Icount = 0 ;

    }



}


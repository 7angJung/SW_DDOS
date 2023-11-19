package co.kr.M_Git_Project;

import static co.kr.M_Git_Project.R.id.class2;
import static co.kr.M_Git_Project.R.id.submanual2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;



import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class CustomClassActivity extends AppCompatActivity {
    ArrayList<Integer> jsonList = new ArrayList<>(); // ArrayList 선언
    ArrayList<String> labelList = new ArrayList<>(); // ArrayList 선언
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_class);

        Intent intent = getIntent();
        int A, B, C, D, E, F, G, H, I;
        String result;
        result = intent.getStringExtra("result");
        A = intent.getIntExtra("A", 0);
        B = intent.getIntExtra("B", 0);
        C = intent.getIntExtra("C", 0);
        D = intent.getIntExtra("D", 0);
        E = intent.getIntExtra("E", 0);
        F = intent.getIntExtra("F", 0);
        G = intent.getIntExtra("G", 0);
        H = intent.getIntExtra("H", 0);
        I = intent.getIntExtra("I", 0);
        TextView class1, class2, class3, class4, class5, manual, submanual,submanual2;
        class1 = (TextView) findViewById(R.id.class1);
        class2 = (TextView) findViewById(R.id.class2);
        class3 = (TextView) findViewById(R.id.class3);
        class4 = (TextView) findViewById(R.id.class4);
        class5 = (TextView) findViewById(R.id.class5);
        manual = (TextView) findViewById(R.id.manual);
        submanual = (TextView) findViewById(R.id.submanual);
        submanual2 = (TextView)findViewById(R.id.submanual2);
        barChart = (BarChart) findViewById(R.id.fragment_bluetooth_chat_barchart);
        graphInitSetting(A, B, C, D, E, F, G, H, I);       //그래프 기본 세팅

        BarChartGraph(labelList, jsonList);
        barChart.setTouchEnabled(false); //확대하지못하게 막아버림! 별로 안좋은 기능인 것 같아~
        barChart.getAxisRight().setAxisMaxValue(100);
        barChart.getAxisLeft().setAxisMaxValue(100);
        switch (result){
            case "A":
                class1.setText("창의 공학 설계");
                class2.setText("윈도우 프로그래밍 및 실습");
                class3.setText("프로그래밍 언어론");
                class4.setText("모바일 프로그래밍");
                class5.setText("자바 응용 및 실습");
                break;
            case "B":
                class1.setText("정보 보안");
                class2.setText("정보 보안 및 실습");
                class3.setText("");
                class4.setText("");
                class5.setText("");
                break;
            case "C":
                class1.setText("UNIX 프로그래밍 및 실습");
                class2.setText("네트워크 프로그램 설계");
                class3.setText("");
                class4.setText("");
                class5.setText("");
                break;
            case "D":
                class1.setText("데이터베이스 응용 및 설계");
                class2.setText("");
                class3.setText("");
                class4.setText("");
                class5.setText("");
                break;
            case "E":
                class1.setText("확률과 통계");
                class2.setText("데이터분석 및 실습");
                class3.setText("기계 학습");
                class4.setText("인공지능");
                class5.setText("");
                break;
            case "F":
                class1.setText("임베디드 및 시스템 설계");
                class2.setText("");
                class3.setText("");
                class4.setText("");
                class5.setText("");
                break;
            case "G":
                class1.setText("웹 프로그래밍 및 실습");
                class2.setText("웹 프로그래밍 응용 및 실습");
                class3.setText("");
                class4.setText("");
                class5.setText("");
                break;
            case "H":
                class1.setText("전력 ICT 네트워크");
                class2.setText("");
                class3.setText("");
                class4.setText("");
                class5.setText("");
                break;
            case "I":
                class1.setText("영상 처리");
                class2.setText("차세대 컴퓨팅 세미나");
                class3.setText("공학 글쓰기");
                class4.setText("");
                class5.setText("");
                break;
        }
        class1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 switch (result){
                     case "A":
                         manual.setText("*창의 공학 설계\n\n" +
                                 "교과목 소개 \n창의적인 문제 해결 방법과 컴퓨팅 사고 방법을 학습하고, 문제 해결을 위해 창의성을 바탕으로 도출된 기본적인 아이디어를 설계하는 방법을 학습하고, 다양한 도구를 이용해 아이디어를 구현하는 방법을 학습한다.\n" +
                                 "\n" +
                                 "본 과목은 기초설계교과목으로서 컴퓨터공학과에 입학한 학생들에게 창의적인 컴퓨팅 사고 과정을 교육하고 창의성을 바탕으로 도출된 기본적인 아이디어를 설계한다.\n" +
                                 "\n" +
                                 "적합한 이유  \n따라서 기본적인 소프트웨어 개발에 기본이 되는 교육을 받을 수 있고 개발에 필요한 프로그램 언어 중 하나인 파이썬을 배울 수 있다. 또한, 소프트웨어 개발의 기본적인 방법들을 학습할 수 있다.");
                         manual.requestLayout();
                         submanual.setText("강의 정보\n\n- 실습형 수업\n- 프로젝트형 수업\n- 팀플레이 유무 : 있음\n- 과제 형식 : 주차별 과제를 통한 예복습\n");
                         submanual.requestLayout();
                         submanual2.setText("@ 김기원 교수님 짱짱맨\n@ 파이썬 학습에 좋아요");
                         submanual2.requestLayout();
                         break;
                     case "B":
                         manual.setText("*정보 보안 \n\n" +
                                 "교과목 소개 \n운영체제, 컴퓨터 네트워크, 인터넷프로토콜 등에 대한 지식을 바탕으로 암호화, 인증, 전자서명 등의 기본 개념과 주요 해킹 기법, 시스템 및 망 취약성 등을 익히고, 이를 통해 시스템 보안, 네트워크 보안, 모바일 보안 등을 학습한다.\n" +
                                 "\n" +
                                 "적합한 이유  \n정보보안에 기본 개념이 되는 개념을 이해할 수 있고 여러 정보 보안 시스템과 프로토콜 등 전반적인 정보보안에 관한 지식을 갖출 수 있는 기회다.");
                         manual.requestLayout();
                         submanual.setText("강의 정보\n\n- 이론형 수업\n- 프로젝트형 수업\n- 팀플레이 유무 : 없음\n- 과제 형식 : 주차별 과제를 통한 예복습\n");
                         submanual.requestLayout();
                         submanual2.setText("@ 김건웅 교수님 수업은 항상 좋습니다\n@ 수업을 통해 정보보안에 기초를 다지게됨");
                         submanual2.requestLayout();
                         break;
                     case "C":
                         manual.setText("*UNIX 프로그래밍 및 실습\n\n" +
                                 "교과목 소개 \n서버 환경의 대표적인 운영체제인 UNIX(LINUX)의 기본 명령어와 다양한 유틸리티, 쉘 프로그래밍, UNIX 환경에서의 프로그램 개발 방법 등을 학습한다.\n" +
                                 "\n" +
                                 "적합한 이유\n 서버 환경에 기본적인 이해, 운영체제에 대한 기초 등 UNIX를 통해 전반적인 쉘 프로그래밍 지식을 학습할 수 있고, 사전에 배운 유닉스를 좀더 복습하면서 심화 학습을 할 수 있는 좋은 기회를 제공한다 ");
                         manual.requestLayout();
                         submanual.setText("강의정보\n\n- 이론형 수업\n" +
                                 "- 팀플레이 유무 : 없음\n" +
                                 "- 과제 형식 : 강의별 과제를 통한 예복습\n");
                         submanual.requestLayout();
                         submanual2.setText("@ 기말 응용문제 4개 이상풀면 고수 \n@어렵지만 문제를 해결했을 때 쾌감은 2배이다");
                         submanual2.requestLayout();
                         break;
                     case "D":
                         manual.setText("*데이터베이스 응용 및 설계\n\n" +
                                 "교과목 소개\nNoSQL의 하나인 MongoDB 명령어들을 학습함으로써 관계형 데이터베이스가 아닌 다른 유형의 DBMS의 특징을 배운다. 고급 언어인 PHP와 Python에서 MySQL, MongoDB의 연동법을 학습함으로써 고급 응용 프로그램에서 데이터베이스가 설계되고 연동되는 방법을 이해한다." +
                                 "\n" +
                                 "적합한 이유 \n데이터베이스에 관심있는 사람은 기존에 Mysql과는 다른 유형의 Nosql중 하나인 MongoDB를 학습할 수 있는 좋은 기회이며, 데이터베이스를 서버와 연동하는 학습을 통해 나중 진로에 도움이 되는 지식을 쌓을 수 있는 좋은 기회를 제공한다");
                         manual.requestLayout();
                         submanual.setText("강의정보\n\n- 실습형 수업(이론 학습후 실습 진행)\n" +
                                           "- 팀플레이 유무 : 없음 \n" +
                                           "- 과제 형식 : 주차별 과제를 통한 예복습\n");
                         submanual.requestLayout();
                         submanual2.setText("@ 데이터베이스에 관한 견문을 넓히려면 필수로 들어야 하는 강의\n@ 몽고디비는 어렵지만 유용한거같아 배우는데 의미가 있다.");
                         submanual2.requestLayout();
                         break;
                     case "E":
                         manual.setText("*확률과 통계\n\n" +
                                 "교과목 소개\n정보통신 분야에서 기본이 되는 확률 이론과 이의 통계학적 응용에 대해 학습한다. 이를 위하여 확률의 기본 개념과 조건부 확률, 확률적 독립성, 확률 분포, 확률과정 등을 소개한다. 또한 통계적 추정 및 검정, 분산분석, 회귀분석 등에 관하여 소개한다." +
                                 "\n" +
                                 "적합한 이유 \n여러 확률 이론의 기초를 익힐 수 있고 R을 통한 실습으로 데이터 처리 및 분석을 학습할 수 있음");
                         manual.requestLayout();
                         submanual.setText("*강의정보\n\n- 실습형 수업(이론 학습후 실습 진행)\n" +
                                 "- 팀플레이 유무 : 없음\n" +
                                 "- 과제 형식 : 강의별 과제를 통한 예복습\n");
                         submanual.requestLayout();
                         submanual2.setText("@ 확률과 통계가 이런과목인지 몰랐습니다\n@ R언어가 생소하긴한데 재미있어요");
                         submanual2.requestLayout();
                         break;
                     case "F":
                         manual.setText("*임베디드 및 시스템 설계\n\n" +
                                 "교과목 소개\n컴퓨터공학 엔지니어로서 마이크로컨트롤러의 활용에 대한 실무능력을 배양하는 것을 목표로 한다. AVR 계열의 마이크로컨트롤러를 중심으로 직병렬 I/O포트, 인터럽트, 타이머/카운터, Display 등에 대한 다양한 프로젝트를 수행하고 응용분야에 필요한 주변회로의 설계 제작과 프로그램을 학습한다." +
                                 "\n" +
                                 "적합한 이유 \n");
                         manual.requestLayout();
                         submanual.setText("강의정보\n\n- 실습형 수업\n-  프로젝트형 수업\n" +
                                 "- 팀플레이 유무 : 있음\n" +
                                 "- 과제 형식 : \n");
                         submanual.requestLayout();
                         submanual2.setText("@ \n@");
                         submanual2.requestLayout();
                         break;
                     case "G":
                         manual.setText("*웹 프로그래밍 및 실습\n\n" +
                                 "교과목 소개\n웹 프로그래밍에 필요한 프런트엔드 기초 기술을 다룬다. HTML5, CSS3, 자바 스크립트의 사용법을 배우고, 그들을 조합하여 웹 프로그램을 완성하는 방법을 학습한다." +
                                 "\n" +
                                 "적합한 이유 \n 프런트엔드에 대한 기초지식을 학습할 수 있고, 자신만의 사이트를 만들어보며 웹 개발에 대한 연습을 할 수 있음 ");
                         manual.requestLayout();
                         submanual.setText("강의정보\n\n- 실습형 수업\n" +
                                 "- 팀플레이 유무 : 없음\n" +
                                 "- 과제 형식 : 강의별 과제를 통한 예복습\n");
                         submanual.requestLayout();
                         submanual2.setText("@ 웹 개발이 생각보다 재미있어요 \n@ 프런트엔드 개발에 관심이 있다면 무조건 들어야하는 과목");
                         submanual2.requestLayout();
                         break;
                     case "H":
                         manual.setText("*스마트 전력 ICT 개론\n\n" +
                                 "교과목 소개\n전력ICT는 전력 기술에 정보통신 기술을 융복합화 하여 전력 기기와 전력 시스템을 디지털화, 지능화하고, 이를 통해 전력 공급의 신뢰도 향상, 전력 품질 개선, 전기화재 비율 감소, 전력 거래의 활성화, 대규모 수용가 중심의 전기 절약 등을 도모하기 위한 기술이다. 본 강의는 발전, 변전, 송전, 배전, 전력판매, 전력거래, 전력보안, 전력정보시스템 등의 전력계통과 이와 관련된 ICT 기술을 소개함으로써, 전력 ICT 분야에 대한 폭넓은 기초 지식을 갖추도록 하는데 그 목적이 있다. " +
                                 "\n" +
                                 "적합한 이유 \n 실제 한전 kdn에서 실무를 뛰고 있는 전문가들의 수준높은 강의를 들을 수 있고, 전력 ICT 분야에 기술 뿐만 아니라 한전 kdn에 대해서도 질문하고 알아볼 수 있는 좋은 기회이다.");
                         manual.requestLayout();
                         submanual.setText("강의정보\n\n- 이론형 수업\n" +
                                 "- 팀플레이 유무 : 없음\n" +
                                 "- 과제 형식 : 없음\n");
                         submanual.requestLayout();
                         submanual2.setText("@ 한전 취업에 관심이 있다면 무조건 들어야 하는 강의\n@ 실제 현장에서 뛰고 있는 전문가들의 강의여서 더욱더 잘 설명해주시는거 같아요");
                         submanual2.requestLayout();
                         break;
                     case "I":
                         manual.setText("영상처리\n\n" +
                                 "교과목 소개\n 2차원 디지털 영상처리의 기본 개념과 그 이론을 이해하고 실제적으로 응용할 수 있는 능력을 배양함을 목표로 한다. 이를 위하여 영상의 표현, 잡음 제거, 명암 대조 개선, 히스토그램 분석 등의 화질 개선 분야, 이진화, 영상 분할, 영상 표현 등의 영상 특징 추출 분야, 영상 해석을 포함하는 영상 이해 분야, 그리고 주파수 도메인의 영상 처리, 비디오 압축, 움직임 추정 등의 주제를 학습한다." +
                                 "\n" +
                                 "적합한 이유 \n");
                         manual.requestLayout();
                         submanual.setText("강의정보\n\n- 이론형 수업\n-  수업\n" +
                                 "- 팀플레이 유무 : \n" +
                                 "- 과제 형식 : \n");
                         submanual.requestLayout();
                         submanual2.setText("@ \n@");
                         submanual2.requestLayout();
                         break;
                 }

            }
        });
        class2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (result){
                    case "A":
                        manual.setText("*윈도우 프로그래밍 및 실습\n\n" +
                                "*교과목 소개 \n소프트웨어 사용의 편리성을 위한 GUI(Graphic User Interface)는 소프트웨어 개발에 있어 중요한 요소이다. 이 과목은 GUI를 기본으로 하는 윈도우즈 운영체제에서 실행되는 응용프로그램 개발을 위한 프로그래밍 기술을 익히고 활용 할 수 있도록 하는데 그 목적이 있다. 이를 위해 윈도우즈API와 MFC 라이브러리를 이용한 프로그래밍 기법을 다룬다.\n" +
                                "\n" +
                                "*추천 이유 \n소프트웨어과 관련된 GUI에 대해 학습 가능하며, GUI와 관련된 MFC를 이해하고 학습할 수 있음");
                        manual.requestLayout();
                        submanual.setText("*강의 정보\n\n- 실습형 수업\n- 프로젝트형 수업\n- 팀플레이 유무 : 없음\n- 과제 형식 : 주차별 과제를 통한 예복습\n");
                        submanual.requestLayout();
                        submanual2.setText("@ 이미라 교수님 살려주세요\n@ 뭐가 뭔지 모르는데 나만 모르는게 아님");
                        submanual2.requestLayout();
                        break;
                    case "B":
                        manual.setText("*정보보안 응용 및 실습\n\n*교과목 소개 \n정보보안의 최신 기술을 응용하고 활용하는 방법에 대해 학습한다. 특히, 클라우드 환경에 대한 이해와 기본적인 가상 인프라 구축, 클라우드 보안을 위한 위협 모니터링, 보안 아키텍처 구축 등을 학습한다\n" +
                                "\n" +
                                "*추천 이유 \n1학기 때 배운 정보보안에 대한 이론을 복습하면서 실습할수 있는 좋은 기회이며, 정보보안에 대해 좀 더 학습할 수 있는 기회임");
                        manual.requestLayout();
                        submanual.setText("*강의 정보\n\n- 실습형 수업\n- 프로젝트형 수업\n- 팀플레이 유무 : 없음\n- 과제 형식 : 주차별 과제를 통한 예복습\n");
                        submanual.requestLayout();
                        submanual2.setText("@ 수업에 난이도가 있습니다. 많이 어려워요\n@ 클라우드가 저를 뚜드러 팹니다.");
                        submanual2.requestLayout();
                        break;
                    case "C":
                        manual.setText("네트워크 프로그램 설계\n\n" +
                                "교과목 소개\n컴퓨터 네트워크, 프로그래밍 언어 등에 대한 지식을 바탕으로 인터넷 주요 응용 프로토콜의 동작과 구성을 학습하고 이를 바탕으로 응용 프로그램을 설계하고 구현한다." +
                                "\n" +
                                "*적합한 이유 \n네트워크 관련 진로에 도움이 될 수있는 실질적인 프로그래밍 기회를 배울 수 있다. 또한 선수학습으로 배웠을 네트워크 프로그램에 대한 이해를 실습을 통해 지식을 강화 할 수 있다.");
                        manual.requestLayout();
                        submanual.setText("*강의정보\n\n- 실습형 수업\n" +
                                "- 팀플레이 유무 : 없음\n" +
                                "- 과제 형식 : 강의별 과제를 통한 예복습\n");
                        submanual.requestLayout();
                        submanual2.setText("@ \n@");
                        submanual2.requestLayout();
                        break;
                    case "D":
                        manual.setText("\n\n" +
                                "교과목 소개\n " +
                                "\n" +
                                "*적합한 이유 \n");
                        manual.requestLayout();
                        submanual.setText("*강의정보\n\n- 형 수업\n" +
                                "- 팀플레이 유무 : 없음\n" +
                                "- 과제 형식 : 강의별 과제를 통한 예복습\n");

                        break;
                    case "E":
                        manual.setText("데이터 분석 및 실습\n\n" +
                                "교과목 소개\n데이터 분석은 데이터에서 의미 있는 패턴과 통찰을 획득하여 의사결정을 지원하기 위한 기술이다. 이 과목은 데이터 수집, 가공, 분석, 시각화 등 데이터를 효과적으로 다룰 수 있는 방법들을 학습하여 실제 데이터 분석에 활용 할 수 있는 능력을 키우는데 그 목적이 있다. " +
                                "\n" +
                                "*적합한 이유 \n 데이터 분석의 기초를 다질 수 있고, 데이터 분석이란 분야의 전반적인 흐름을 알 수 있다.");
                        manual.requestLayout();
                        submanual.setText("*강의정보\n\n- 실습형 수업\n" +
                            "- 팀플레이 유무 : 없음\n" +
                            "- 과제 형식 : 주차별 과제를 통한 예복습\n");
                        submanual.requestLayout();
                        submanual2.setText("@ 좀 어려운 과목이지만 실습이 재밌습니다.\n@ 책을 잘 읽고 실습을 진행해야 어려움이 없어요" );
                        submanual2.requestLayout();
                        break;
                    case "F":
                        manual.setText("\n\n" +
                                "교과목 소개\n " +
                                "\n" +
                                "*적합한 이유 \n");
                        manual.requestLayout();
                        submanual.setText("*강의정보\n\n- 형 수업\n" +
                                "- 팀플레이 유무 : 없음\n" +
                                "- 과제 형식 : 강의별 과제를 통한 예복습\n");
                        break;
                    case "G":
                        manual.setText("웹 프로그래밍 응용 및 실습\n\n" +
                                "교과목 소개\n웹 프로그래밍을 위한 백엔드 기술인 PHP와, 자바 스크립트 라이브러리인 JQuery 프로그래밍 기법을 학습한다. PHP를 통해 서버 사이드 프로그램의 기능과 데이터베이스 연동 방법을 학습하고, JQuery를 통해 애니메이션과 이펙트, DOM 다루기, 객체, 함수의 활용법을 학습한다. " +
                                "\n" +
                                "*적합한 이유 \n 백엔드에 대해 전반적인 느낌을 배울 수 있고, 서버와 프로그램이 통신하는 문법에 대한 기초를 배울 수 있다.");
                        manual.requestLayout();
                        submanual.setText("*강의정보\n\n- 형 수업\n" +
                                "- 팀플레이 유무 : 없음\n" +
                                "- 과제 형식 : 강의별 과제를 통한 예복습\n");
                        break;
                    case "H":
                        manual.setText("\n\n" +
                                "교과목 소개\n " +
                                "\n" +
                                "*적합한 이유 \n");
                        manual.requestLayout();
                        submanual.setText("*강의정보\n\n- 형 수업\n" +
                                "- 팀플레이 유무 : 없음\n" +
                                "- 과제 형식 : 강의별 과제를 통한 예복습\n");
                        break;
                    case "I":manual.setText("차세대 컴퓨팅 세미나\n\n" +
                            "교과목 소개\n 4차 산업 혁명과 관련된 스마트 기술에 대해 학습한다. 인공지능, 빅데이터, IoT, 블록체인, VR/AR/MR/XR, 자율자동차, 스마트홈/스마트팩토리/스마트헬스케어, 3D 프린터, 드론 등의 최신 기술의 기본 개념과 특징들을 학습함으로써 미래 사회에 필요한 기술들을 이해하고 활용하는 방법을 배운다." +
                            "\n" +
                            "*적합한 이유 \n미래기술들을 알아볼수 있고 다양한 분야에 기본적인 지식을 배우면서 분야에 대한 호기심과 지식을 한번에 배울 수 있다.");
                        manual.requestLayout();
                        submanual.setText("*강의정보\n\n- 이론형 수업\n" +
                                "- 팀플레이 유무 : 없음\n" +
                                "- 과제 형식 : 강의별 과제를 통한 예복습\n");
                        break;
                }

            }
        });
        class3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (result){
                    case "A":
                        manual.setText("*프로그래밍 언어론\n\n" +
                                "*교과목 소개 \n컴퓨터공학 전공자로서 접하게 되는 다양한 프로그래밍 언어가 갖는 공통적인 구조와 개념에 대해 총괄적으로 학습한다. 변수, 제어 구조, 객체, 함수 등 다양한 부류의 프로그래밍 언어가 갖는 특징과 개념을 이해함으로써 프로그래밍 언어의 기능에 대한 이해를 넓히는 것을 목표로 한다.\n" +
                                "\n" +
                                "*적합한 이유 \n소프트웨어 개발에 필수적인 프로그래밍 언어들에 대한 기본적인 특징과 개념에 대해 학습할 수 있다");
                        manual.requestLayout();
                        submanual.setText("*강의 정보\n\n- 이론형 수업\n- 팀플레이 유무 : 없음\n- 과제 형식 : 주차별 과제를 통한 예복습\n");
                        submanual.requestLayout();
                        submanual2.setText("@ 과제의 왕 김치연 교수님\\n@ 프로그래밍 언어론 탈주 하고 싶어요\"");
                        submanual2.requestLayout();
                        break;
                    case "B":
                        break;
                    case "C":
                        break;
                    case "D":
                        break;
                    case "E":
                        manual.setText("*기계 학습\n\n" +
                                "*교과목 소개 \n기계학습은 새로운 경험(데이터)을 통해 성능을 향상시켜 나가는 것과 관련한 인공지능 기술이다. 이 과목은 기계학습의 개념과 용어, 회귀, 분류, 군집 등의 주요 알고리즘과 최근 뛰어난 성능을 발휘하고 있는 딥러닝 기술을 이해하고, 이를 문제해결에 활용 할 수 있는 능력을 키우는데 그 목적이 있다." +
                                "\n" +
                                "적합한 이유 \n머신러닝과 딥러닝에 기초를 학습하고 실제 사례와 비슷한 상황에서 가정하는 학습을 통해 활용능력을 키울수 있음");
                        manual.requestLayout();
                        submanual.setText("*강의 정보\n\n- 실습형 수업(이론 학습후)\n- 팀플레이 유무 : 없음\n- 과제 형식 : 주차별 과제를 통한 예복습\n");
                        submanual.requestLayout();
                        submanual2.setText("@ 내용이 어려운 편인거같다\\n@ 새로운 용어에 대한 학습을 하지 않으면 따라갈 수가 없다\"");
                        submanual2.requestLayout();
                        break;
                    case "F":
                        break;
                    case "G":
                        break;
                    case "H":
                        break;
                    case "I":
                        break;
                }

            }
        });
        class4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (result){
                    case "A":
                        manual.setText("*모바일 프로그래밍\n\n" +
                                "교과목 소개 \n대표적인 모바일 프레임워크인 안드로이드 플랫폼에 대한 이해와 위젯, 이벤트 처리, 액티비티와 같은 컴포넌트에 대해 학습한다. 또한, 기초 안드로이드 앱에서부터 센서, 지도 등을 활용한 고급 프로그래밍을 통해 안드로이드 플랫폼이 제공하는 다양한 서비스를 활용할 수 있는 기반 지식을 갖춘다.\n" +
                                "\n" +
                                "적합한 이유 \n소프트웨어 개발 분야 중 하나인 모바일 앱 개발에 관해 학습할 수 있다. 또한 선수 과목인 JAVA를 이용하여 앱 개발을 할 수 있다");
                        manual.requestLayout();
                        submanual.setText("*강의 정보\n\n- 실습형 수업\n- 프로젝트형 수업\n- 팀플레이 유무 : 없음\n- 과제 형식 : 주차별 과제를 통한 예복습\n");
                        submanual.requestLayout();
                        submanual2.setText("@ 박철수 교수님 수업은 듣고 봐야합니다\n@ 프로그램 설치만 3주 걸려요");
                        submanual2.requestLayout();
                        break;
                    case "B":
                        break;
                    case "C":
                        break;
                    case "D":
                        break;
                    case "E":
                        break;
                    case "F":
                        break;
                    case "G":
                        break;
                    case "H":
                        break;
                    case "I":
                        break;
                }

            }
        });
        class5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (result){
                    case "A":
                        manual.setText("*JAVA 응용 및 실습\n\n" +
                                "교과목 소개 \nJava SDK에서 제공하는 다양한 주제의 라이브러리 패키지를 이용한 고급 프로그램 개발 능력을 기른다. 주요 내용으로 멀티쓰레딩, 네트워크 프로그래밍, JDBC 등을 다루고, 실습 및 과제물을 통해 구체적인 문제에 적용하는 방법을 익힌다. 선수과목으로 운영체제, 컴퓨터네트워크, 데이터베이스, Java및실습 이수가 필요하다\n" +
                                "\n" +
                                "적합한 이유 \n사용자가 어느 정도 프로그래밍에 자신이 생긴다면 더욱 추천하는 과목으로 다양한 컴퓨터 분야를 사용하여 이전에 배웠던 프로그래밍 보다 업그레이드된 개발 능력을 기를 수 있다");
                        manual.requestLayout();
                        submanual.setText("*강의 정보\n\n- 실습형 수업\n- 프로젝트형 수업\n- 팀플레이 유무 : 있음\n- 과제 형식 : 주차별 과제를 통한 예복습\n");
                        submanual.requestLayout();
                        submanual2.setText("@ 목해대 컴공과의 인생은 자바 응용을 듣기전과 들은 후로 나뉩니다\n@ 당신은 그저 김동관 교수님을 만나기전 범부에 불과해");
                        submanual2.requestLayout();
                        break;
                    case "B":
                        break;
                    case "C":
                        break;
                    case "D":
                        break;
                    case "E":
                        break;
                    case "F":
                        break;
                    case "G":
                        break;
                    case "H":
                        break;
                    case "I":
                        break;
                }

            }
        });

    }

    public void graphInitSetting(int A, int B, int C, int D, int E, int F, int G, int H, int I) {

        labelList.add("소프트웨어");
        labelList.add("정보보안");
        labelList.add("네트워크");
        labelList.add("DB");
        labelList.add("AI,ML");
        labelList.add("임베디드");
        labelList.add("웹 개발");
        labelList.add("전력 계통");
        labelList.add("나머지");

        jsonList.add(A * 2 - 8);
        jsonList.add(B * 2 - 8);
        jsonList.add(C * 2 - 8);
        jsonList.add(D * 2 - 8);
        jsonList.add(E * 2 - 8);
        jsonList.add(F * 2 - 8);
        jsonList.add(G * 2 - 8);
        jsonList.add(H * 2 - 8);
        jsonList.add(I * 2 - 8);


        BarChartGraph(labelList, jsonList);
        barChart.setTouchEnabled(false); //확대하지못하게 막아버림! 별로 안좋은 기능인 것 같아~
        //barChart.setRendererLeftYAxis();
//        barChart.setMaxVisibleValueCount(50);
//        barChart.setTop(50);
//        barChart.setBottom(0);
//        barChart.setAutoScaleMinMaxEnabled(true);
        barChart.getAxisRight().setAxisMaxValue(100);
        barChart.getAxisLeft().setAxisMaxValue(100);
    }

    private void BarChartGraph(ArrayList<String> labelList, ArrayList<Integer> valList) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < valList.size(); i++) {
            entries.add(new BarEntry(i, (Integer) valList.get(i)));
        }


        BarDataSet depenses = new BarDataSet(entries, "분야"); // 변수로 받아서 넣어줘도 됨
        depenses.setAxisDependency(YAxis.AxisDependency.LEFT);
        barChart.getDescription().setText("  ");

        ArrayList<String> labels = new ArrayList<String>();
        for (int i = 0; i < labelList.size(); i++) {
            labels.add((String) labelList.get(i));
        }

        BarData data = new BarData(depenses);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels)); // 라이브러리 v3.x 사용하면 에러 발생함
        depenses.setColors(ColorTemplate.LIBERTY_COLORS); //
        xAxis.setGranularity(1f);
        xAxis.setLabelRotationAngle(45);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
        xAxis.setLabelCount(labelList.size());

        barChart.setData(data);
        barChart.animateXY(1000, 1000);
        barChart.invalidate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.A:
                break;
            case R.id.B:
                break;
            case R.id.C:
                break;
            case R.id.D:
                break;
            case R.id.E:
                break;
            case R.id.F:
                break;
            case R.id.G:
                break;
            case R.id.H:
                break;
            case R.id.I:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}



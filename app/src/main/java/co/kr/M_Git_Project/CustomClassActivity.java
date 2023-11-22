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
    TextView manual,submanual,submanual2,submanual3;
    String result, result2;
    TextView class1, class2, class3, class4, class5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_class);

        Intent intent = getIntent();
        int A, B, C, D, E, F, G, H, I;

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

        class1 = (TextView) findViewById(R.id.class1);
        class2 = (TextView) findViewById(R.id.class2);
        class3 = (TextView) findViewById(R.id.class3);
        class4 = (TextView) findViewById(R.id.class4);
        class5 = (TextView) findViewById(R.id.class5);
        manual = (TextView) findViewById(R.id.manual);
        submanual = (TextView) findViewById(R.id.submanual);
        submanual2 = (TextView)findViewById(R.id.submanual2);
        submanual3 = (TextView)findViewById(R.id.submanual3);
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
                class3.setText("UNIX 및 실습");
                class4.setText("컴퓨터 네트워크");
                class5.setText("");
                break;
            case "D":
                class1.setText("데이터베이스 응용 및 설계");
                class2.setText("데이터베이스");
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
                class2.setText("논리회로");
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
                class4.setText("전공영어");
                class5.setText("");
                break;
        }
        class1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 switch (result){
                     case "A":
                         manual.setText("*창의 공학 설계\n\n" +
                                 "수업 개요 \n본 과목은 기초설계교과목으로서 컴퓨터공학과에 입학한 학생들에게 창의적인 컴퓨팅 사고 과정을 교육하고 창의성을 바탕으로 도출된 기본적인 아이디어를 설계한다. 설계한 것을 파이썬을 이용해 구현해 봄으로써 향후 접하게 될 전공 과목에 대한 흥미를 가지도록 한다.\n" +
                                 "\n" +
                                 "수업 목표  \n파이썬을 활용하여 다양한 예제 문제를 창의적으로 해결하는 방법을 학습하고 실천한다\n1.프로그램 작성을 위한 창의적 사고 및 컴퓨팅 사고 과정 학습\n2.파이썬의 기본 문법 리뷰 및 다양한 문제 실습\n3.파이썬을 이용한 다양한 프로젝트 실습\n");
                         manual.requestLayout();
                         submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                         submanual.requestLayout();
                         submanual2.setText("정보\n\n- 실험 실습\n- 김기원 교수님\n- 3학점\n- 중간평가:34/기말평가:34\n- 과제:16/출석:16\n\n\n");
                         submanual2.requestLayout();
                         submanual3.setText("");
                         submanual3.requestLayout();
                         break;
                     case "B":
                         manual.setText("*정보보안\n\n" +
                                 "수업 개요 \n본 교과목은 정보 보안 관련 기술 지식이 필요한 대학생들에게 정보보안의 전반적인 이해를 돕는다.\n본 과목을 통하여 정보 보안 지식을 습득하여 개인 정보 보호 능력을 향상할 수 있다.\n본 과목의 학습 주제는 개인정보 보호를 위한 PC 관리 기법, 암호기술, 네트워크 및 인터넷 보안, 모바일 보안등이 있다.\n" +
                                 "\n" +
                                 "수업 목표  \n운영체제, 컴퓨터 네트워크, 인터넷 프로토콜 등에 대한 지식을 바탕으로 암호화, 인증, 전자서명 등의 기본 개념을 이해할 수 있다.\n주요 해킹 기법, 시스템 및 네트워크 취약성 등을 익힐수 있고, 이를 통해 시스템 보안과 네트워크 보안, 미디어 보안, 소프트웨어 보호 등에 관한 내용을 학습할 수 있다.\n");
                         manual.requestLayout();
                         submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                         submanual.requestLayout();
                         submanual2.setText("정보\n\n- 이론\n- 김기원 교수님\n- 3학점\n- 중간평가:34/기말평가:34\n- 과제:16/출석:16\n\n");
                         submanual2.requestLayout();
                         submanual3.setText("");
                         submanual3.requestLayout();
                         break;
                     case "C":
                         manual.setText("*UNIX 프로그래밍 및 실습\n\n" +
                                 "수업 개요 \n유닉스(리눅스)에 대한 기본 지식(개요, 사용법)을 바탕으로 유닉스(리눅스) 시스템 콜과 C언어를 이용한 프로그래밍 이론과 실제를 학습한다.\n" +
                                 "\n" +
                                 "수업 목표  \n(1)시스템 콜과 표준 라이브러리 함수의 차이점을 이해하고 설명할 수 있다.\n(2)파일 및 디렉토리 처리과정, 시스템 및 프로세스 정보 검색에 대해 학습하고 이해할 수 있다.\n\n");
                         manual.requestLayout();
                         submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                         submanual.requestLayout();
                         submanual2.setText("정보\n\n- 실험실습\n- 김건웅 교수님\n- 3학점\n- 실험실습 실기:54/과제:25\n- 수업참여(태도):5/출석:16\n\n");
                         submanual2.requestLayout();
                         submanual3.setText("- 유닉스로 다루는게 너무 번거롭고 힘들어요.. 게다가 수업도 배울 게 많아서 어려워요\n" +
                                 "- 같은 유닉스지만 체급이 말도 안 됨\n" +
                                 "- 실습 과제를 끝낼 수 있는 당신 가능성 있어! 그대로만 해!"+
                                 "- 기말 응용 문제 절반이상 끝내면 성적 잘나옵니다.\n\n\n");
                         submanual3.requestLayout();
                         break;
                     case "D":
                         manual.setText("*데이터베이스 응용 및 설계\n\n" +
                                 "수업 개요 \n데이터베이스 기본 개념을 응용 프로그램에 활용하는 방법을 학습하고, NoSQL의 하나인 MongoDB의 활묭법을 학습한다.\n" +
                                 "\n" +
                                 "수업 목표  \nPHP, Python등에서 데이터베이스를 연동하는 방법을 이해하고, MongoDB를 활용하여 응용 프로그램을 작성할 수 있다.\n");
                         manual.requestLayout();
                         submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                         submanual.requestLayout();
                         submanual2.setText("정보\n\n- 실험실습\n- 김치연 교수님\n- 3학점\n- 중간평가:30/기말평가:30\n- 실험실습 실기:10/과제:14/출석:16\n\n");
                         submanual2.requestLayout();
                         submanual3.setText("- 데이터베이스를 들었으며, 데이터베이스에 대해 추가로 관심이 있는 분들에게 추천!\n" +
                                 "- DB의 심화과정이다 보니 할 일이 되게 많습니다. 과제 수행을 열심히 하실 수 있는 분들에게 적합한 것 같아요.\n" +
                                 "- 1학기 때와는 다른 종류의 DBMS를 사용해서 색다르다.\n" +
                                 "- 이 과목 또한 필기가 정말 많지만, 필기 시간이 부족하다.\n" +
                                 "- DB가 싫어도 그래도 들어보는것을 추천합니다.\n\n\n");
                         submanual3.requestLayout();
                         break;
                     case "E":
                         manual.setText("*확률과 통계\n\n" +
                                 "수업 개요 \n공학에서의 데이터 처리와 분석에 필요한 통계와 확률의 기본 개념을 이해하여 여러 응용에 활용한다.\n" +
                                 "\n" +
                                 "수업 목표  \n데이터 처리와 분석을 위해 확률 이론의 기초, 이산확률 변수 및 분포, 연속확률 변수 및 분포를 익히고 표본 추출, 모수 추정 및 가설 검증을 이해하고 응용한다.\n");
                         manual.requestLayout();
                         submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                         submanual.requestLayout();
                         submanual2.setText("정보\n\n- 이론\n- 박철수 교수님\n- 3학점\n- 중간평가:34/기말평가:34\n- 과제:16/출석:16\n\n");
                         submanual2.requestLayout();
                         submanual3.setText("- 확통이 이렇게 어려운 거였나..? 대학은 역시 다른건지 제가 부족한건지 모르겠다\n" +
                                 "- R Studio를 다운로드 했지만 실습횟수는 단 한번\n" +
                                 "- 꽤나 어려웠던 과목이였다\n\n\n");
                         submanual3.requestLayout();
                         break;
                     case "F":
                         manual.setText("*임베디드 시스템 설계\n\n" +
                                 "수업 개요 \n컴퓨터 공학 엔지니어로서 마이크로프로세서의 활용에 대한 실무능력을 충실하게 배양하는 것을 목표로 한다. AVR 계열의 임베디드를 중심으로 직병렬 I/O포트, 타이머/카운터, Display등에 대한 다양한 프로젝트를 설정하고 응용분야에 필요한 주변회로의 설계 제작과 프로그램의 작성을 직접 수행하는 실험실습을 통해  임베디드 시스템 설계에 대한 능력을 기른다\n" +
                                 "\n" +
                                 "수업 목표  \n임베디드 시스템 설계에 필요한 마이크로컨트롤러 및 주변회로에 대한 지식을 이론과 실습을 통해 이해하는데 중점을 둔다.\n");
                         manual.requestLayout();
                         submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                         submanual.requestLayout();
                         submanual2.setText("정보\n\n- 실험실습\n- 김기원 교수님\n- 3학점\n- 중간평가:30/기말평가:38\n- 과제:16/출석:16\n\n");
                         submanual2.requestLayout();
                         submanual3.setText("");
                         submanual3.requestLayout();
                         break;
                     case "G":
                         manual.setText("*웹 프로그래밍 및 실습\n\n" +
                                 "수업 개요\n 웹의 기초 개념과 응용 분야에 대해 이해하고, 프로그래밍의 기초가 되는 HTML5, CSS3, 자바 스크립트를 이용하여 웹 페이지 작성 방법에 대해 배운다.\n" +
                                 "\n" +
                                 "수업 목표  \n HTML5, CSS3, 자바스크립트를 이해하고 습득하여 홈페이지를 구축한다.\n");
                         manual.requestLayout();
                         submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                         submanual.requestLayout();
                         submanual2.setText("정보\n\n- 실험실습\n- 박철수 교수님\n- 3학점\n- 중간평가:30/기말평가:30\n- 과제:24/출석:16\n\n");
                         submanual2.requestLayout();
                         submanual3.setText("- 웹프로그래밍에 대한 기본기를 다질수 있었으며, 웹 프로그래밍이라는 과목이 무엇인지 알 수 있었습니다. \n" +
                                 "- 기초적인 웹 HTML, XML 등 다양한 언어를 사용해보고 배워보는 즐거운 시간이었습니다.\n\n\n");
                         submanual3.requestLayout();
                         break;
                     case "H":
                         manual.setText("*스마트 전력 ICT 개론\n\n" +
                                 "수업 개요 \n국내 유일의 전력 ICT 전문 공기업인 (주)한전 KDN의 현직 직원이 우리대학에서 출장 강의하는 형식으로 진행된다. 중간, 기말 시험없이 출석만으로 Pass/Fail로 평가하는 과목이다.\n한전 KDN(주)와 그 협력 업체에 취업할 수 있는 능력을 함양함을 목표로 한다.\n" +
                                 "\n" +
                                 "수업 목표  \n전력 발전, 송전, 변전, 전력 거래, 배전, 스마트 그리드, 전력판매 등에 이르는 전력 IT 기술에 전반에 관하여 다룸으로써, 수강학생들이 전력 발전부터 소비 전반에 이르는 IT 기술의 역할과 중요성을 이해하고 더 나아가 한전 KDN(주)와 그 협력 업체에 취업할 수 있는 능력을 함양함을 그 목표로 한다.\n");
                         manual.requestLayout();
                         submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                         submanual.requestLayout();
                         submanual2.setText("정보\n\n- 이론\n- 정종면 교수님\n- 1학점\n- 수업참여:84/출석:16\n\n");
                         submanual2.requestLayout();
                         submanual3.setText("- 꿀강의, 매 주 2시간씩 특강 듣고 유용한 정보 얻어가세요!\n" +
                                 "- 자신이 한전 KDN을 노리는 것이 아니더라도 유용한 정보가 가득하기에 추천\n" +
                                 "- 한전KDN 가고 싶으면 들으세요.\n" +
                                 "- 한전의 시스템에 궁금증이 많다면 추천\n\n\n");
                         submanual3.requestLayout();
                         break;
                     case "I":
                         manual.setText("*영상처리\n\n" +
                                 "수업 개요 \n 본 수업은 영상처리 기본 알고리즘을 이해한다.\n또한 OpenCV의 기본 문법을 이해한 다음, 이를 이용한 영상처리 기본 알고리즘을 실습함으로써, OpenCV를 활용한 문제 해결 능력을 함양한다.\n" +
                                 "\n" +
                                 "수업 목표  \n영상처리 개념, OpenCV 기본 문법, 영상의 내부 구조, 영상처리 기본 알고리즘을 이해한다.\n");
                         manual.requestLayout();
                         submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                         submanual.requestLayout();
                         submanual2.setText("정보\n\n- 실험실습\n- 정종면 교수님\n- 3학점\n- 중간평가:30/기말평가:35\n- 과제:14/수업참여(태도):5/출석:16\n\n");
                         submanual2.requestLayout();
                         submanual3.setText("- 블랙박스, 사물인식카메라 등이 어떻게 작동하는지 직접 경험해 볼 수 있었습니다. 실습이 재밌어요\n" +
                                 "- MLB에서 공이 어떻게 날아가는지 궁금했는데 이 과목을 배우니 확실히 알 수 있었습니다.\n\n\n");
                         submanual3.requestLayout();
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
                                "수업 개요 \n소프트웨어 사용의 편의성을 위한 GUI(Graphic User Interface)는 소프트웨어 구성의 필수적인 요소가 되었다.이 강좌는 GUI를 기본으로 하는 윈도우즈 운영체제에서 실행되는 응용프로그램 개발을 위한 프로그래밍 기술을 익히고 활용할 수 있도록 해준다.\n" +
                                "\n" +
                                "수업 목표  \n소프트웨어 사용의 편리성을 위해 GUI와 멀티태스킹을 갖춘 윈도우즈 운영체제의 동작원리를 이해한다.\n윈도우즈 API를 이해하고, 이를 이용한 윈도우 응용 프로그램을 작성할 수 있다.\n");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 실험 실습\n- 이미라 교수님\n- 3학점\n- 중간평가:15/기말평가:15\n- 과제:54/출석:16\n\n\n");
                        submanual2.requestLayout();
                        submanual3.setText("- 처음에는 Microsoft Window를 다루는 줄 알았는데 조금 다르다\n" +
                                "- 수업만으로는 따라가기 쉽지 않아 개인 공부가 필요한 과목\n" +
                                "- 실습으로 시험을 본다? 그럼 다같이 못 보니 안심하세요.\n" +
                                "- 나만 못하는줄 알았는데 모두 못한다.\n\n\n");
                        submanual3.requestLayout();
                        break;
                    case "B":
                        manual.setText("*정보보안 응용 및 실습\n\n" +
                                "수업 개요 \n본 교과목은 정보보안에서 최근 이슈가 되는 분야를 학습한다. 최근 4차 산업혁명, 디지털 전환, 빅데이터등으로 클라우드가 각광을 받고 있으며, 클라우드 보안은 기존의 온프레미스에서의 보안과 차이점이 존재한다. 본 교과목을 통해서 클라우드에 대한 기본 개념을 학습하고, 클라우드보안에 대한 기초적인 사항들을 학습한다.\n" +
                                "\n" +
                                "수업 목표  \n정보보안의 최신기술을 응용하고 활용할 수 있다.\n클라우드 환경에서의 보안을 위해 기본적인 가상 인프라 구축, 보안 위협 모니터링, 보안 아키텍쳐 구축을 할 수 있다.\nAWS를 활용하여 클라우드 기본 개념과 기초적인 보안에 대해 학습한다.");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 실험실습\n- 김기원 교수님\n- 3학점\n- 중간평가:26/기말평가:26\n- 과제:16/출석:16\n\n");
                        submanual2.requestLayout();
                        submanual3.setText("");
                        submanual3.requestLayout();
                        break;
                    case "C":
                        manual.setText("*네트워크 프로그램 설계\n\n" +
                                "수업 개요 \n통시 프로토콜에 대한 기본 이론을 습득ㅎ고, 이를 바탕으로 통신 응용 프로그램을 작성할 수 있는 소양을 기른다. 정보통신망과 인터넷에 대한 기초 이론을 기반으로, 유닉스 시스템 프로그래밍과 네트워크 프로그래밍을 결합하여 정보통신 응용프로그램 개발 능력을 배양한다.\n" +
                                "\n" +
                                "수업 목표  \n(1)LINUX 설치 및 기본 관리를 할 수 있다.\n(2)네트워크 데몬 서비스의 등록/시작/중지를 이해하고 활용할 수 있다.\n(3)소켓 프로그래밍 인터페이스를 이해하고 활용할 수 있다.\n(4) DNS를 이해하고 활용할 수 있다.\n");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 실험실습\n- 김건웅 교수님\n- 3학점\n- 실험실습 실기:50/과제:24\n- 발표:5/수업참여(태도):5/출석:16\n\n");
                        submanual2.requestLayout();
                        submanual3.setText("");
                        submanual3.requestLayout();
                        break;
                    case "D":
                        manual.setText("*데이터베이스\n\n" +
                                "수업 개요 \n데이터베이스의 기본 개념, 관계 데이터베이스의 특징, 설계 및 구현 방법에 대해 학습한다.\n" +
                                "\n" +
                                "수업 목표  \n데이터베이스의 기본 개념을 이해하고, 실제로 구현하여 활용할 수 있다.\n");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 이론\n- 김치연 교수님\n- 3학점\n- 중간평가:30/기말평가:30\n- 수시평가:10/과제:10\n- 수업참여(태도):4/출석:16\n\n");
                        submanual2.requestLayout();
                        submanual3.setText("- DB의 기초를 제대로 알고 싶다면 이 수업입니다!! 워낙 꼼꼼한 수업으로 잘 알려주시는 것 같아요!\n" +
                                "- 수업이 되게 체계적으로 진행되고 공부에 도움이 되는 자료도 많이 나눠주십니다.\n" +
                                "- 꽤나 중요한 과목이므로, 신중하게 들으세요.\n" +
                                "- 필기가 정말 많은데, 필기 시간이 부족하다...\n"+
                                "- 나중에 정말 많이 쓰이니 잘해두는것이 좋을겁니다.\n\n\n");
                        submanual3.requestLayout();
                        break;
                    case "E":
                        manual.setText("*데이터 분석 및 실습\n\n" +
                                "수업 개요 \n데이터 분석은 데이터에서 의미 있는 패턴과 통찰을 획득하여 의사결정을 지원하기 위한 기술이다. 이과목은 데이터를 수집, 가공, 분석 시각화 등 대용량의 데이터를 효과적으로 다룰 수 있는 방법들을 학습하여 실제 데이터 분석에 활용할 수 있는 능력을 키우는데 그 목적이 있더.\n" +
                                "\n" +
                                "수업 목표  \n- 데이터 분석 전체 과정 및 단계별 필요한 개념을 이해할 수 있다.\n- 데이터 수지브 가공, 분석, 시각화에 유용한 파이썬 기초와 라이브러리들을 익히고 활용할 수 있다.\n- 기존의 데이터 분석 사례들을 익히고 새로운 문제가 제시되면 그에 필요한 데이터 분석을 할 수 있다.");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 실험실습\n- 이미라 교수님\n- 3학점\n- 중간평가:30/기말평가:30\n- 과제:24/출석:16\n\n");
                        submanual2.requestLayout();
                        submanual3.setText("- 데이터를 처리하고 다루는 과정을 알 수 있었습니다.\n" +
                                "- 이 과목을 배우면서 가장 놀란게 우리 주변에 되게 많은 정보가 알게 모르게 저장이 되어있다는 사실이다.\n" +
                                "- 구글 코랩을 통해 실습을 하는데, 에러를 잡기가 어렵다는 단점이 존재한다.\n" +
                                "- 이 과목 또한 개인 공부가 필수이다.\n"+
                                "- 꽤 재미있고 쉽지는 않은 과목이다.\n\n\n");
                        submanual3.requestLayout();
                        break;
                    case "F":
                        manual.setText("*논리회로\n\n" +
                                "수업 개요 \n디지털 논리회로의 기본적인 논리 게이트들의 특성, 플리플롭의 특성, 카운터, 레지스터의 기본 특성을 이해, 조합 논리와 순차회로를 해석하여 원하는 디지털 논리회로 설계 학습\n 아두이노 우노와 센서, 입출력 장치 등을 이용하여 기본적인 디지털 회로 설계 실습\n" +
                                "\n" +
                                "수업 목표  \n논리회로에서 논리식에 대한 이론과 조합회로, 순차회로, 레지스터와 카운터, 메모리 등에 대한 구성과 함께 논리회로 설계 방법 이해\n아두이노를 활용한 실습을 통하여 컴퓨터 공학의 이해에 필요한 기본적인 하드웨어 요소에 대한 지식과 실무 겸비\n");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 이론\n- 김기원 교수님\n- 3학점\n- 중간평가:34/기말평가:34\n- 과제:16/출석:16\n\n");
                        submanual2.requestLayout();
                        submanual3.setText("- 전자부품이 어떻게 구성되고 작동하는지 어릴 적엔 궁금했는데 공부로 마주하니 궁금하지 않네요..\n" +
                                "- 논리적인 전자회로외 논리적이지 않은 내 두뇌회로\n" +
                                "- 개인적으로 이해하는 데까지 정말 오래 걸린 과목\n" +
                                "- 플립플롭은 정말 레전드였다.\n\n\n");
                        submanual3.requestLayout();
                        break;
                    case "G":
                        manual.setText("*웹 프로그래밍 응용 및 실습\n\n" +
                                "수업 개요 \n웹의 back-end 프로그래밍 기술을 학습하기 위해 서버측 스크립트인 PHP 프로그래밍을 다루고, 자바 스크립트 라이브러리의 하나인 제이쿼리 사용법을 다룬다.\n" +
                                "\n" +
                                "수업 목표  \n웹의 클라이언트 서버의 상호 연동 방법에 대하여 학습한다.\n제이쿼리를 통해 자바 스크립트의 고급 활용법을 학습한다.");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 실험실습\n- 김치연 교수님\n- 3학점\n- 중간평가:30/기말평가:30\n- 실험실습 실기:10/과제:14/출석:16\n\n");
                        submanual2.requestLayout();
                        submanual3.setText("");
                        submanual3.requestLayout();
                        break;
                    case "H":
                        break;
                    case "I":
                        manual.setText("*차세대 컴퓨팅 세미나\n\n" +
                                "수업 개요 \n4차 산업 혁명의 15대 핵심 기술을 중심으로 각 기술의 기본 개념과 트렌드를 소개함으로써 미래 기술에 대한 이해도를 높인다.\n" +
                                "\n" +
                                "수업 목표  \n4차 산업 혁명으로 대두된 핵심 기술들을 이해함으로써 미래 기술에 대비할 수 있는 역량을 키운다.\n");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 이론\n- 김치연 교수님\n- 3학점\n- 중간평가:30/기말평가:30\n- 과제:14/발표:10/출석:16\n\n");
                        submanual2.requestLayout();
                        submanual3.setText("- 현재 IT계열에서 트렌드 동향을 알 수 있었으며, 다양한 분야들의 정보들을 접할 수 있는 기회가 되었다. \n" +
                                "- 이슈가 될만한 IT계열 정보를 알 수 있고 어떻게 미래사회를 대처할 지 고심할 수 있는 수업이라 생각합니다.\n" +
                                "- 발빠르게 4차 산업의 발전에 따라가기 위해서는 이 수업 강추!\n" +
                                "- 정신 차리고보면 진도를 말도 안 되게 많이 나간 과목이다.\n" +
                                "- 필기가 많은데 시간이 부족하다.\n\n\n");
                        submanual3.requestLayout();
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
                                "수업 개요 \n절차형, 객체지향형, 함수형 등의 패러다임을 갖는 언어의 구조 설계 고려 사항을 학습하며, 패러다임별 언어의 특징을 학습한다.\n" +
                                "\n" +
                                "수업 목표  \n프로그래밍 언어의 기본개념, 역사, 구문과 의미론, 식 타입, 부프로그램 등의 설계 고려사항을 이해하고, 그 특징을 설명할 수 있다.\n");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 이론\n- 김치연 교수님\n- 3학점\n- 중간평가:30/기말평가:30\n- 과제:14/출석:16\n\n\n");
                        submanual2.requestLayout();
                        submanual3.setText("- 코딩보다는 암기 과목이 낫다 생각했는데 이 과목을 경험하고 코딩이 좋아졌어요\n" +
                                "- 이거 벼락치기 하다가 점수에 벼락 맞습니다 성실하게 공부하세요\n" +
                                "- 프로그래밍 언어의 역사, 중요한 특징들을 알 수 있는 과목이다.\n" +
                                "- 필기가 너무 많고 빠르다...\n\n\n");
                        submanual3.requestLayout();
                        break;
                    case "B":
                        break;
                    case "C":
                        manual.setText("*UNIX 및 실습\n\n" +
                                "수업 개요 \nUNIX(LINUX)환경에서 필요한 기본 명령과 유틸리티 및 개발도구를 익히고 이를 바탕으로 스크립트 프로그래밍 능력을 배양한다. 주로 리눅스 표준 디렉터리, 셸의 기능과 기본 명령ㅇ어, 리눅스의 부팅 사용자 계정의 관리, 텍스트 편집, 파일 시스템과 프로세스의 관리, 패키지 관리, 셸 스크립트, 네트워크 설정 및 서버를 학습하고 이해한다.\n" +
                                "\n" +
                                "수업 목표  \n- UNIX(LINUX)기본 명령을 익히고 활용할 수 있는 능력을 갖춘다.\n- UNIX(LINUX)의 셀, 사용자 관리, 파일 시스템 및 패키지 관리, 네트워크 설정 및 서버 관리 등의 능력을 갖춘다.\n");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 실험실습\n- 박철수 교수님\n- 3학점\n- 중간평가:30/기말평가:30\n- 과제:24/출석:16\n\n");
                        submanual2.requestLayout();
                        submanual3.setText("- 외울 게 많습니다!! 그래도 열심히 하면.. 그래도 외울 게 많아요!!\n" +
                                "- 유닉스쪽으로 갈 생각 있으면 한 번 쯤은 들어볼만한 강의\n" +
                                "- vim 명령어들을 잘 익히도록\n" +
                                "- 뭔가 많이 배우는 것 같지만, 다 명령어들이다.\n"+
                                "- 쉽지 않은 친구다.");
                        submanual3.requestLayout();
                        break;
                    case "D":
                        break;
                    case "E":
                        manual.setText("*기계 학습\n\n" +
                                "수업 개요 \n기계학습은 새로운 경험에 해당하는 데이터들로 성능을 향상시켜 나가는 것과 관련한 인공지능 기술이다. 이 과목은 기계학습의 개념과 용어, 회귀, 분류, 군집 등의 주요 알고리즘과 최근 많은 영역에서 뛰어난 학습능력을 발휘하고 있는 딥러닝 기술을 이해하고, 이를 문제해결에 활용할 수 있는 능력을 기른다. \n" +
                                "\n" +
                                "수업 목표  \n- 기계학습의 기본 개념과 관련 용어들을 이해한다.\n- 기계학습의 지도학습, 비지도학습 관련 주요 알고리즘들을 이해하고, 이를 구체적인 문제해결에 활용할 수 있다.\n- 인공신경망 기반의 딥러닝 기술 관련 주요 알고리즘들을 이해하고, 이를 구체적인 문제해결에 활용할 수 있다.\n");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 실험실습\n- 이미라 교수님\n- 3학점\n- 중간평가:30/기말평가:30\n- 수시평가:10/과제:14/출석:16\n\n");
                        submanual2.requestLayout();
                        submanual3.setText("- AI에 관심이 있다! 그러면 인공지능을 듣기 전 이 과목이 필수다!!\n" +
                                "- 확실히 어렵습니다.. 개념 자체가 어려워서 공부를 열심히 해야 하는 과목이에요\n" +
                                "- 인공지능 분야에 관심이 많다면 필수로 들어야 하는 과목이다.\n" +
                                "- 개인 공부가 필수인 과목이다.\n"+
                                "- 머신러닝, 딥러닝에 관심이 있다면 들어보기를 추천\n\n");
                        submanual3.requestLayout();
                        break;
                    case "F":
                        break;
                    case "G":
                        break;
                    case "H":
                        break;
                    case "I":
                        manual.setText("*공학글쓰기\n\n" +
                                "수업 개요 \n공학 관련 보고서, 논술식 리포트, 졸업 논문 등의 작성에 필요한 글쓰기 능력을 향상시키기 위해 주제작성, 글의 구성과 전개, 문장과 표현 등의 방법을 배우는 것을 목적으로 한다. 이를 위해, 글쓰기와 문제해결, 공학적 사고, 다섯단락 글쓰기 등을 학습한다\n" +
                                "\n" +
                                "수업 목표  \n- 문제 해결을 위한 글쓰기와 말하기를 이해한다.\n- 글로벌 사회와 과학기술의 연관성을 이해하고, 자기의 관점을 글로 표현할 수 있다.\n관심있는 주제에 대해 다섯 단락 분량의 글쓰기를 할 수 있다.\n- 제품 제안서 및 설명서를 작성하고 발표할 수 있다.\n");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 이론\n- 이미라 교수님\n- 3학점\n- 중간평가:30/기말평가:30\n- 과제:24/출석:16\n\n");
                        submanual2.requestLayout();
                        submanual3.setText("");
                        submanual3.requestLayout();
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
                                "수업 개요 \nJAVA를 이용하여 안드로이드 앱의 설계와 개발을 경험한다.\n" +
                                "\n" +
                                "수업 목표  \n앱의 개념과 작동원리를 이용하여 안드로이드 프로그래밍의 기초 능력을 키우는 것을 목표로 한다.\n또한 아이디어가 앱으로 제작되기 위해 필요한 기획과 설계를 경험해 보고, 자바와 XML에 대한 기초 지식을 이용하여 앱을 개발할 수 있는 능력을 갖추고자 한다.\n\n");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 실험 실습\n- 박철수 교수님\n- 3학점\n- 중간평가:34/기말평가:34\n- 실험실습실기:16/출석:16\n\n\n");
                        submanual2.requestLayout();
                        submanual3.setText("- 앱을 직접 만들어보고 싶은 학생들에게 추천합니다. 쉽고 빠르게 앱을 배울 수 있어요!\n" +
                                "- 박철수 교수님의 수업진행이 워낙 시원시원하셔서 듣기 편합니다.\n" +
                                "- 꿀팁: 컴퓨터 실습실 자리를 잘 잡아라\n" +
                                "- 박철수 교수님 말씀만 잘 들으면 막히는 부분없이 잘 돼요. 아시겠지요?\n"+
                                "- 수업에 집중하고 안하고 차이가 좀 큰과목\n\n");
                        submanual3.requestLayout();
                        break;
                    case "B":
                        break;
                    case "C":
                        manual.setText("*컴퓨터 네트워크\n\n" +
                                "수업 개요 \nOSI 7계층을 기본으로 하위 물리계츨부터 상위 응용 계층까지, 데이터 통신 및 네트워크 관련 이론을 교수하며, 이를 바탕으로 인터넷에서 사용되는 서비스 프로토콜들을 이해하고 학습할 수 있다.\n" +
                                "\n" +
                                "수업 목표  \n(1) OSI 7 계층의 역할과 기능을 이해하고, 설명할 수 있다.\n(2)물리계층과 데이터링크 계층에 관련된 개념, 기술들을 이해하고 설명할 수 있다.\n(3)네트워크 계층과 트랜스포트 계층 프로토콜을 이해하고 설명할 수 있다.\n(4)세션 계층부터 응용 계층에 이르는 상위 계층 프로토콜을 이해하고 설명할 수 있다.\n");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 이론\n- 김건웅 교수님\n- 3학점\n- 중간평가:15/기말평가:15/\n- 수시평가:30/과제:20\n- 수업참여(태도):4/출석:16\n");
                        submanual2.requestLayout();
                        submanual3.setText("- 네트워크에 대해 충실한 기본을 잘 설명해주는 수업입니다. 수업 진행이 깔끔합니다.\n" +
                                "- 진행에 막힘이 없으십니다. 매 주 정리하고 문제를 푸는 게 조금 힘들 수 있습니다..\n" +
                                "- 과목 자체는 체급이 높지만 수업은 되게 편하게 들을 수 있다.\n" +
                                "- 이 과목 많이 빡세다고 하는데 으으음.. 전 잘 모르겠네요.\n"+
                                "- 공부 많이 해두면 분명 도움될 과목입니다. 많이 하세요\n\n");
                        submanual3.requestLayout();
                        break;
                    case "D":
                        break;
                    case "E":
                        manual.setText("*인공지능\n\n" +
                                "수업 개요 \n인간의 지적 능력을 컴퓨터를 통해 실현시키고자하는 다양한 기술들을 이해하고, 이를 이용한 응용 예들을 살펴봄으로써 지능 시스템 구현방법을 이해할 수 있다. 인공지능의 기술 중 탐색, 전문가 시스템, 퍼지, 유전알고리즘 등을 개념적으로 이해하고, 관련 예시들을 통해 실제 해결 가능한 문제들을 해결하고 이해한다.\n" +
                                "\n" +
                                "수업 목표  \n(1) 지능을 갖는 인공 시스템의 개념을 이해하고 설명 할 수 있다.\n(2) 지능 시스템을 실현 시키고자하는 다양한 기술들과 그 예들을 이해한다\n(3) 주어진 문제를 해결하기 위해 어떠한 인공지능 기술을 활용할 수 있는지 분석하여 의견을 제시할 수 있다.\n");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 이론\n- 이미라 교수님\n- 3학점\n- 중간평가:30/기말평가:30\n- 수시평가:10/과제:14/출석:16\n\n");
                        submanual2.requestLayout();
                        submanual3.setText("");
                        submanual3.requestLayout();
                        break;
                    case "F":
                        break;
                    case "G":
                        break;
                    case "H":
                        break;
                    case "I":
                        manual.setText("*전공영어\n\n" +
                                "수업 개요 \n컴퓨터 기술에 대한 전문용어 및 기술 설명을 한글 번역본이 아닌 영문을 그대로 이해함으로써 새로운 기술에 대한 신속하고 정확한 이해를 돕는다.\n" +
                                "\n" +
                                "수업 목표  \n 영문으로 작성된 전공서적, 기술 보고서, 온라인 IT 기사, 프로그래밍 매뉴얼 등을 이해하기 위한 기본적인 문법, 표현, 컴퓨터 전문 용어를 학습한다. 아울러 전공 교과목과 관련된 최신 IT 신기술에 대한 독해 능력도 배양한다.\n");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 이론\n- 김동관 교수님\n- 3학점\n- 중간평가:20/기말평가:20\n- 과제:44/출석:16\n\n");
                        submanual2.requestLayout();
                        submanual3.setText("- 나도 미국에서 태어났었으면.. 이라는 생각이 드는 시간이었습니다. 영어 정말 어렵네요.\n" +
                                "- 전공과 관련된 영어를 배워서 그런지 체급이 꽤나 높다.\n" +
                                "- 시험이 상상 이상으로 많이 빡세므로 개인 공부는 필수!\n\n");
                        submanual3.requestLayout();
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
                                "수업 개요 \n'JAVA 및 실습'교과목의 연계과목으로 이미 학습한 자바 기본 문법을 복습하고 프로젝트 기반으로 소프트웨어 시스템 분석 및 설계, 자바 언어를 사용한 구현 및 테스트 과정을 수행한다.\n" +
                                "\n" +
                                "수업 목표  \nJAVA 언어에 대한 기본 지식을 바탕으로 쓰레드 프로그래밍, JDBC 프로그래밍, 네트워크 프로그래밍 등 보다 고급의 JAVA 기술들을 실습한다.\n자바 언어 중심의 서버 프레임 워크인 스프링 부트 핵심 기능의 개념을 이해한다.\nhands-on 문제나 프로젝트를 통해 스프링 부트의 기능을 구현한다.\n");
                        manual.requestLayout();
                        submanual.setText("강의 방식\n\n- 수업 유형\n- 담당 교수님\n- 학점 \n- 성적평가 비율(23년도기준)\n\n\n ");
                        submanual.requestLayout();
                        submanual2.setText("정보\n\n- 실험 실습\n- 김동관 교수님\n- 3학점\n- 실험실습 실기:20/과제:44\n- 수업참여(태도):20/출석:16\n\n\n");
                        submanual2.requestLayout();
                        submanual3.setText("- 자신이 코딩에 자신이 있고 코딩을 즐긴다 하는 분들은 이 과목 추천드립니다\n" +
                                "- 매 주 코딩 프로젝트가 나가서 시간이 정말 많이 드는 과목입니다.. 신중히 선택하시길 추천드려요\n" +
                                "- 극한으로 바쁘게 산다는 것을 체험할 수 있는 과목\n" +
                                "- 과제 끝!!!(해 뜨는 장면을 보며)" +
                                "- 나는 자바를 잘하는 줄 알았다. 자바 응용을 듣기 전까지는(자바 및 실습 A+수강생)\n"+
                                "- 완강 한다면 분명 실력이 늘것입니다\n\n");
                        submanual3.requestLayout();
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

        jsonList.add(A * 2);
        jsonList.add(B * 2);
        jsonList.add(C * 2);
        jsonList.add(D * 2);
        jsonList.add(E * 2);
        jsonList.add(F * 2);
        jsonList.add(G * 2);
        jsonList.add(H * 2);
        jsonList.add(I * 2);


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
                result = "A";
                class1.setText("창의 공학 설계");
                class2.setText("윈도우 프로그래밍 및 실습");
                class3.setText("프로그래밍 언어론");
                class4.setText("모바일 프로그래밍");
                class5.setText("자바 응용 및 실습");
                manual.setText("과목을 눌러주세요");
                submanual.setText("");
                submanual2.setText("");
                submanual3.setText("");
                break;
            case R.id.B:
                result = "B";
                class1.setText("정보 보안");
                class2.setText("정보 보안 및 실습");
                class3.setText("");
                class4.setText("");
                class5.setText("");
                manual.setText("과목을 눌러주세요");
                submanual.setText("");
                submanual2.setText("");
                submanual3.setText("");
                break;
            case R.id.C:
                result = "C";
                class1.setText("UNIX 프로그래밍 및 실습");
                class2.setText("네트워크 프로그램 설계");
                class3.setText("UNIX 및 실습");
                class4.setText("컴퓨터 네트워크");
                class5.setText("");
                manual.setText("과목을 눌러주세요");
                submanual.setText("");
                submanual2.setText("");
                submanual3.setText("");
                break;
            case R.id.D:
                result = "D";
                class1.setText("데이터베이스 응용 및 설계");
                class2.setText("데이터베이스");
                class3.setText("");
                class4.setText("");
                class5.setText("");
                manual.setText("과목을 눌러주세요");
                submanual.setText("");
                submanual2.setText("");
                submanual3.setText("");
                break;
            case R.id.E:
                result = "E";
                class1.setText("확률과 통계");
                class2.setText("데이터분석 및 실습");
                class3.setText("기계 학습");
                class4.setText("인공지능");
                class5.setText("");
                manual.setText("과목을 눌러주세요");
                submanual.setText("");
                submanual2.setText("");
                submanual3.setText("");
                break;
            case R.id.F:
                result = "F";
                class1.setText("임베디드 및 시스템 설계");
                class2.setText("논리회로");
                class3.setText("");
                class4.setText("");
                class5.setText("");
                manual.setText("과목을 눌러주세요");
                submanual.setText("");
                submanual2.setText("");
                submanual3.setText("");
                break;
            case R.id.G:
                result = "G";
                class1.setText("웹 프로그래밍 및 실습");
                class2.setText("웹 프로그래밍 응용 및 실습");
                class3.setText("");
                class4.setText("");
                class5.setText("");
                manual.setText("과목을 눌러주세요");
                submanual.setText("");
                submanual2.setText("");
                submanual3.setText("");
                break;
            case R.id.H:
                result = "H";
                class1.setText("전력 ICT 네트워크");
                class2.setText("");
                class3.setText("");
                class4.setText("");
                class5.setText("");
                manual.setText("과목을 눌러주세요");
                submanual.setText("");
                submanual2.setText("");
                submanual3.setText("");
                break;
            case R.id.I:
                result = "I";
                class1.setText("영상 처리");
                class2.setText("차세대 컴퓨팅 세미나");
                class3.setText("공학 글쓰기");
                class4.setText("전공영어");
                class5.setText("");
                manual.setText("과목을 눌러주세요");
                submanual.setText("");
                submanual2.setText("");
                submanual3.setText("");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateViews(String manualText, String submanualText, String submanual2Text) {
        manual.setText(manualText);
        submanual.setText(submanualText);
        submanual3.setText(submanual2Text);
    }

}



package co.kr.M_Git_Project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RoadmapActivity extends AppCompatActivity {
    private TextView required, major, ge; // 필수, 전공, 교양
    private String credit1;
    private String credit2;
    private String grade; // 학년
    private String semester; // 학기
    private String result = "";
    private String[][] requiredSubject = {{"컴퓨터 공학 개론","파이썬 및 실습"},{"이산 수학","C언어 및 실습"},
            {"논리 회로","자료 구조 및 실습","C++ 및 실습"},{"컴퓨터 구조","알고리즘 및 실습","UNIX 프로그래밍 및 실습"},
            {"운영체제","데이터베이스","JAVA 및 실습"},{"소프트웨어 공학","컴퓨터 네트워크"},{"캡스톤 디자인"},{}};
    private String[][] A = {{},{"창의 공학 설계"},{},{"윈도우 프로그래밍"},
            {"프로그래밍 언어론"},{"JAVA응용 및 실습","모바일 프로그래밍"},{},{}};
    private String[][] B = {{},{},{},{},{},{},{"정보보안"},{"정보보안 응용 및 실습"}};
    private String[][] C = {{},{},{"UNIX 및 실습"},{},{},{},{"네트워크 프로그램 설계"},{}};
    private String[][] D = {{},{},{},{},{},{"데이터베이스 응용 및 실습"},{},{}};
    private String[][] E = {{},{},{},{"확률과 통계"},{"데이터분석 및 실습"},{"기계 학습"},{},{"인공지능"}};
    private String[][] F = {{},{},{},{},{"임베디드 시스템 설계"},{},{},{}};
    private String[][] G = {{},{},{"웹프로그래밍 및 실습"},{"웹 프로그래밍 응용 및 실습"},{},{},{},{}};
    private String[][] H = {{},{},{},{},{},{},{"전력 계통 자동화"},{"ICT 창업 전략","전력 ICT 네트워크"}};
    private String[][] I = {{},{},{"전공 영어"},{},{"영상 처리"},{"차세대 컴퓨팅 세미나"},{"공학 글쓰기"},{}};
    private int max_credit, min_credit, max_ge, min_ge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roadmap);

        required = findViewById(R.id.required);
        major = findViewById(R.id.major);
        ge = findViewById(R.id.ge);


        Intent intent = getIntent();
        result = intent.getStringExtra("result");

        if (intent != null) {
            credit1 = intent.getStringExtra("credit1");
            credit2 = intent.getStringExtra("credit2");
            grade = intent.getStringExtra("grade");
            semester = intent.getStringExtra("semester");

            max_credit = 105 - Integer.parseInt(credit1);
            min_credit = 100 - Integer.parseInt(credit1);
            max_ge = 40 - Integer.parseInt(credit2);
            min_ge = 35 - Integer.parseInt(credit2);
        }

        // 이차원 배열 접근을 위한 시작점과 끝점 설정
        int start = Integer.parseInt(grade) * (Integer.parseInt(semester) - 1) + Integer.parseInt(semester) - 1;
        int end = 8;

        // 필수 과목들 나열을 위한 StringBuilder
        StringBuilder requiredSub = new StringBuilder();
        for (int i = start; i < end; i++) {
            for (String subject : requiredSubject[i]) {
                if (!subject.isEmpty()) {
                    requiredSub.append(subject).append("\n");
                }
            }
        }

        // 교약 과목 남은 학점 나열
        String geSub = "교양 학점은 최대 " + max_ge + "점, 최소 " + min_ge + " 남았습니다.";
        if (result != null) {
            switch (result) {
                case "A":
                    required.setText(requiredSub.toString());

                    StringBuilder majorA = new StringBuilder();
                    for (int i = start; i < end; i++) {
                        for (String subject : A[i]) {
                            if (!subject.isEmpty()) {
                                majorA.append(subject).append("\n");
                            }
                        }
                    }
                    major.setText(majorA.toString());

                    ge.setText(geSub);

                    break;
                case "B":
                    required.setText(requiredSub.toString());

                    StringBuilder majorB = new StringBuilder();
                    for (int i = start; i < end; i++) {
                        for (String subject : B[i]) {
                            if (!subject.isEmpty()) {
                                majorB.append(subject).append("\n");
                            }
                        }
                    }
                    major.setText(majorB.toString());

                    ge.setText(geSub);

                    break;
                case "C":
                    required.setText(requiredSub.toString());

                    StringBuilder majorC = new StringBuilder();
                    for (int i = start; i < end; i++) {
                        for (String subject : C[i]) {
                            if (!subject.isEmpty()) {
                                majorC.append(subject).append("\n");
                            }
                        }
                    }
                    major.setText(majorC.toString());

                    ge.setText(geSub);

                    break;
                case "D":
                    required.setText(requiredSub.toString());

                    StringBuilder majorD = new StringBuilder();
                    for (int i = start; i < end; i++) {
                        for (String subject : D[i]) {
                            if (!subject.isEmpty()) {
                                majorD.append(subject).append("\n");
                            }
                        }
                    }
                    major.setText(majorD.toString());

                    ge.setText(geSub);
                    break;
                case "E":
                    required.setText(requiredSub.toString());

                    StringBuilder majorE = new StringBuilder();
                    for (int i = start; i < end; i++) {
                        for (String subject : E[i]) {
                            if (!subject.isEmpty()) {
                                majorE.append(subject).append("\n");
                            }
                        }
                    }
                    major.setText(majorE.toString());

                    ge.setText(geSub);

                    break;
                case "F":
                    required.setText(requiredSub.toString());

                    StringBuilder majorF = new StringBuilder();
                    for (int i = start; i < end; i++) {
                        for (String subject : F[i]) {
                            if (!subject.isEmpty()) {
                                majorF.append(subject).append("\n");
                            }
                        }
                    }
                    major.setText(majorF.toString());

                    ge.setText(geSub);

                    break;
                case "G":
                    required.setText(requiredSub.toString());

                    StringBuilder majorG = new StringBuilder();
                    for (int i = start; i < end; i++) {
                        for (String subject : G[i]) {
                            if (!subject.isEmpty()) {
                                majorG.append(subject).append("\n");
                            }
                        }
                    }
                    major.setText(majorG.toString());

                    ge.setText(geSub);

                    break;
                case "H":
                    required.setText(requiredSub.toString());

                    StringBuilder majorH = new StringBuilder();
                    for (int i = start; i < end; i++) {
                        for (String subject : H[i]) {
                            if (!subject.isEmpty()) {
                                majorH.append(subject).append("\n");
                            }
                        }
                    }
                    major.setText(majorH.toString());

                    ge.setText(geSub);

                    break;
                case "I":
                    required.setText(requiredSub.toString());

                    StringBuilder majorI = new StringBuilder();
                    for (int i = start; i < end; i++) {
                        for (String subject : I[i]) {
                            if (!subject.isEmpty()) {
                                majorI.append(subject).append("\n");
                            }
                        }
                    }
                    major.setText(majorI.toString());

                    ge.setText(geSub);

                    break;
            }
        } else {
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
        }
    }
}
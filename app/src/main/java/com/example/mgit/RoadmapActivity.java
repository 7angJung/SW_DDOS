package com.example.mgit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RoadmapActivity extends AppCompatActivity {
    private TextView required, major, reference; // 필수, 전공, 알림텍스트
    private String credit1;
    private String credit2;
    private String grade; // 학년
    private String semester; // 학기
    private String result = "";
    private String[][] requiredSubject = {{"<1-1>","● 컴퓨터 공학 개론","● 파이썬 및 실습"},{"<1-2>","● 이산 수학","● C언어 및 실습"},
            {"<2-1>","● 논리 회로","● 자료 구조 및 실습","● C++ 및 실습"},{"<2-2>","● 컴퓨터 구조","● 알고리즘 및 실습","● UNIX 프로그래밍 및 실습"},
            {"<3-1>","● 운영체제","● 데이터베이스","● JAVA 및 실습"},{"<3-2>","● 소프트웨어 공학","● 컴퓨터 네트워크"},{"<4-1>","● 캡스톤 디자인"},{}};
    private String[][] A = {{},{"<1-2>","● 창의 공학 설계"},{},{"<2-2>","● 윈도우 프로그래밍"},
            {"<3-1>","● 프로그래밍 언어론"},{"<3-2>","● JAVA응용 및 실습","● 모바일 프로그래밍"},{},{}};
    private String[][] B = {{},{},{},{},{},{},{"<4-1>","● 정보보안"},{"4-2","● 정보보안 응용 및 실습"}};
    private String[][] C = {{},{},{"<2-1>","● UNIX 및 실습"},{},{},{},{"<4-1>","● 네트워크 프로그램 설계"},{}};
    private String[][] D = {{},{},{},{},{},{"<3-2>","● 데이터베이스 응용 및 실습"},{},{}};
    private String[][] E = {{},{},{},{"<2-2>","● 확률과 통계"},{"<3-1>","● 데이터분석 및 실습"},{"<3-2>","● 기계 학습"},{},{"<4-2>","● 인공지능"}};
    private String[][] F = {{},{},{},{},{"<3-1>","● 임베디드 시스템 설계"},{},{},{}};
    private String[][] G = {{},{},{"<2-1>","● 웹프로그래밍 및 실습"},{"<2-2>","● 웹 프로그래밍 응용 및 실습"},{},{},{},{}};
    private String[][] H = {{},{},{},{},{},{},{"<4-1>","● 전력 계통 자동화"},{"<4-2>","● ICT 창업 전략","● 전력 ICT 네트워크"}};
    private String[][] I = {{},{},{"<2-1>","● 전공 영어"},{},{"<3-1>","● 영상 처리"},{"<3-2>","● 차세대 컴퓨팅 세미나"},{"<4-1>","● 공학 글쓰기"},{}};
    private int max_major, min_major, max_ge, min_ge;
    private int current_credit, left_credit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roadmap);

        required = findViewById(R.id.required);
        major = findViewById(R.id.major);
        reference = findViewById(R.id.referenceText);

        Intent intent = getIntent();
        if(intent != null) {
            credit1 = intent.getStringExtra("credit1");
            credit2 = intent.getStringExtra("credit2");
            grade = intent.getStringExtra("grade");
            semester = intent.getStringExtra("semester");

            current_credit = Integer.parseInt(credit1) + Integer.parseInt(credit2);
            left_credit = 140 - current_credit;

            max_major = 105 - Integer.parseInt(credit1);
            min_major = 100 - Integer.parseInt(credit1);
            max_ge = 40 - Integer.parseInt(credit2);
            min_ge = 35 - Integer.parseInt(credit2);
        }

        // 이차원 배열 접근을 위한 시작점과 끝점 설정
        int start = Integer.parseInt(grade) * (Integer.parseInt(semester)-1) + Integer.parseInt(semester) - 1;
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
        String leftCredit = "사용자는 현재 " + current_credit + "학점을 이수하셨고, 앞으로 " + left_credit +
        "학점을 이수하셔야 졸업이 가능합니다. 전공은 최대 " + max_major + "학점, 최소 " + min_major + "학점을 채워야 합니다.";
        String interest = "사용자는 현재 " + result + "분야에 관심이 많으므로 위에 나열된 전공들을 수강하는 것을 적극 추천합니다.";
        String leftGE = "";
        if(min_ge<0 && max_ge>0) {
            leftGE = "사용자는 졸업요건 교양 최소 이수학점을 이행하셨습니다. 교양으로 채울 수 있는 남은 학점은 " + max_ge + "학점입니다.";
        } else if(min_ge<0 && max_ge<0) {
            leftGE = "사용자는 현재 교양으로 채울 수 있는 최대, 최소 학점을 모두 채우셨습니다.";
        } else {
            leftGE = "사용자는 졸업요건까지 교양 학점을 최대 " + max_ge + "학점, 최소 " + min_ge + "학점을 이수할 수 있습니다. 그 이상은 졸업학점에 포함되지 않습니다.";
        }


        reference.setText("● " + leftCredit + "\n" + "● " + leftGE + "\n" + "● " + interest);

        switch(result) {
            case "A":
                required.setText(requiredSub.toString());

                StringBuilder majorA = new StringBuilder();
                for (int i = start; i < end; i++) {
                    for (String subject : A[i]) {
                        if (!subject.isEmpty()) {
                            majorA.append(subject).append("\n");
                        }
                    }
                    majorA.append("\n");
                }
                major.setText(majorA.toString());

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
                    majorB.append("\n");
                }
                major.setText(majorB.toString());

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
                    majorC.append("\n");
                }
                major.setText(majorC.toString());

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
                    majorD.append("\n");
                }
                major.setText(majorD.toString());

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
                    majorE.append("\n");
                }
                major.setText(majorE.toString());

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
                    majorF.append("\n");
                }
                major.setText(majorF.toString());

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
                    majorG.append("\n");
                }
                major.setText(majorG.toString());

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
                    majorH.append("\n");
                }
                major.setText(majorH.toString());

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
                    majorI.append("\n");
                }
                major.setText(majorI.toString());

                break;
        }
    }
}
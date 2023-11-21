package co.kr.M_Git_Project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MealActivity extends AppCompatActivity {

    TextView monday, tuesday, wednesday, thursday, friday, saturday, sunday;
    TextView monday_morning, tuesday_morning, wednesday_morning, thursday_morning, friday_morning, saturday_morning, sunday_morning;
    TextView monday_lunch, tuesday_lunch, wednesday_lunch, thursday_lunch, friday_lunch, saturday_lunch, sunday_lunch;
    TextView monday_night, tuesday_night, wednesday_night, thursday_night, friday_night, saturday_night, sunday_night;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);


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

        monday_morning.setText("북어채계란국\n" +
                "쭈꾸미야채볶음\n" +
                "김구이\n" +
                "팽이버섯나물\n" +
                "오븐에구운도넛&우유\n" +
                "김치");
        tuesday_morning.setText("전복죽\n" +
                "계란장조림\n" +
                "치킨너겟&머스터드소스\n" +
                "멸치볶음\n" +
                "씨리얼&우유,김치");
        wednesday_morning.setText("꽃게탕\n" +
                "동그랑땡계란부침\n" +
                "비엔나소세지볶음\n" +
                "사과,구운계란\n" +
                "모닝빵&쨈&우유");
        thursday_morning.setText("굴림만두떡국\n" +
                "한입떡갈비구이&케찹\n" +
                "두부양념조림\n" +
                "진미채볶음\n" +
                "미니치즈케익&두유\n" +
                "김치");
        friday_morning.setText("쇠고기미역국\n" +
                "야채계란말이\n" +
                "참치김치볶음&찐두부\n" +
                "후랑크케찹볶음\n" +
                "모닝빵&쨈&우유\n" +
                "김치");
        saturday_morning.setText("포테이토스프\n" +
                "허브소세지구이\n" +
                "식빵&햄&치즈&계란\n" +
                "씨리얼&우유\n" +
                "사과");
        sunday_morning.setText("쇠고기떡국\n" +
                "고추송송고기말이&케찹\n" +
                "계란후라이\n" +
                "김구이\n" +
                "떠먹는요거트,김치");

        monday_lunch.setText("콩나물밥\n" +
                "근대된장국\n" +
                "넙적당면찜닭\n" +
                "곱창김구이&양념장\n" +
                "오이무침\n" +
                "흑임자드레싱야채샐러드,김치");
        tuesday_lunch.setText("돈뼈해장국\n" +
                "생선까스&콘타르소스\n" +
                "볶음파래\n" +
                "오징어미나리초무침\n" +
                "시금치나물\n" +
                "김치");
        wednesday_lunch.setText("조개살미역국\n" +
                "삼겹살버섯구이\n" +
                "상추,명이나물장아찌&쌈장\n" +
                "메밀야채비빔국수\n" +
                "숙주나물\n" +
                "김치");
        thursday_lunch.setText("부추계란국\n" +
                "해물볶음짜장\n" +
                "찹쌀꿔바로우\n" +
                "단무지\n" +
                "요구르트,김치");
        friday_lunch.setText("새우살야채볶음밥\n" +
                "쌀국수\n" +
                "야채춘권&칠리소스\n" +
                "백오이무침\n" +
                "김치");
        saturday_lunch.setText("사골곰탕\n" +
                "치킨너겟&머스터드소스\n" +
                "골뱅이오이초무침\n" +
                "시금치나물\n" +
                "김치");
        sunday_lunch.setText("북어채두부국\n" +
                "쇠고기버섯야채볶음\n" +
                "통살치킨샐러드\n" +
                "오이양파무침\n" +
                "김치");

        monday_night.setText("햄야채볶음밥\n" +
                "유부장국\n" +
                "김가루볶음\n" +
                "양파맛떡갈비구이\n" +
                "치커리사과무침\n" +
                "허쉬쵸코,김치");
        tuesday_night.setText("콩나물매운국\n" +
                "돼지갈비찜\n" +
                "미니만두샐러드&오리엔탈D\n" +
                "미역오이초무침\n" +
                "크림치즈휘낭시에,김치");
        wednesday_night.setText("모듬순대국밥\n" +
                "스페니쉬오믈렛\n" +
                "부추양파무침\n" +
                "오징어젓갈무침\n" +
                "피크닉,김치");
        thursday_night.setText("대구매운탕\n" +
                "고구마닭갈비\n" +
                "참나물무침\n" +
                "콘치즈오븐구이\n" +
                "바나나,김치");
        friday_night.setText("꽃게탕\n" +
                "돈육메추리장조림\n" +
                "매운꼬지어묵\n" +
                "돗나물초무침\n" +
                "요거트푸딩,김치");
        saturday_night.setText("감자수제비국\n" +
                "오리훈제야채볶음\n" +
                "쥐포채볶음\n" +
                "다시마&초장\n" +
                "김치");
        sunday_night.setText("돈육김치찌개\n" +
                "오징어야채볶음\n" +
                "야채계란찜\n" +
                "김말이튀김&양념소스\n" +
                "김치");


    }
}
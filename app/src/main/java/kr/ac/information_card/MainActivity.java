package kr.ac.information_card;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Information> information_list;
    int information_id = 0;
    ImageView imageView;
    TextView title, content1_TV, content2_TV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        information_list = new ArrayList<Information>();

        imageView = (ImageView)findViewById(R.id.card_image);
        title = (TextView)findViewById(R.id.card_title);
        content1_TV = (TextView)findViewById(R.id.card_content1);
        content2_TV = (TextView)findViewById(R.id.card_content2);

        information_add(information_list, "IoT의 증가와 사회의 변환", "@drawable/iot_news",
                "IoT 산업의 전망은? (부제목용)", "들어갈 내용은 IoT 산업 기사에 대한 기사가 들어갈 예정");
        information_add(information_list, "6G 통신", "@drawable/sixg_communication",
                "6G 통신 시대가 온다! (부제목용)", "5G 시대를 넘어선 6G 시대가 온다!");
        information_add(information_list, "스마트 의류의 확산?", "@drawable/smart_clothes",
                "이제는 컴퓨터를 직접 입는다! (부제목용)", "사물인터넷(IoT), 인공지능(AI) 등 첨단정보통신기술(ICT)을 탑재한 ‘스마트 의류’ 산업 규모가 급성장하고 있다. 글로벌 시장조사기관 ‘팩트.MR’은 스마트 의류 시장 규모가 오는 2032년엔 232억8,000만달러(약 30조9,344억원) 규모에 이를 전망이다. 이 같은 글로벌 시장 추세에 맞춰, 국내 연구진이 국가 산업 경쟁력을 대폭 높일 수 있는 신개념 스마트 의류 기술 개발에 성공했다.\n" +
                        "\n" +
                        "송철현 한국과학기술연구원(KIST) 전자재료연구센터 책임연구원·장지수 선임연구원팀은 마찰전기섬유와 땀 전지 섬유로 다양한 습도 조건에서 전기 발생이 가능한 신개념 스마트 의류용 섬유 기술을 개발했다고 15일 밝혔다. \n" +
                        "\n" +
                        "일반적으로 스마트 의류에 사용되는 마찰전기섬유는 습도에 취약해 주변의 습기나 인체의 땀에 의해 전력 효율이 낮아진다는 문제가 있다. 또 땀 전지는 발생 전력이 작아 활용도 어렵다.\n" +
                        "\n" +
                        "이 같은 문제를 해결하고자 KIST 연구진은 탄성중합체와 혼합된 용질(설탕)을 녹이는 간단한 제조 공정으로 새로운 마찰전기섬유를 개발했다. 마찰 표면적을 증가시켜 에너지 효율을 향상시키는 방법이다. \n" +
                        "\n" +
                        "또한 땀 전지 섬유에 이온 염(ionic salt) 및 파릴렌(parylene-C)을 코팅해 발전 성능을 향상시켜, 비대칭 습윤성을 유지하도록 했다. 이후 이들 섬유를 직조방식으로 결합해 습기에 취약한 마찰전기 섬유와 전력 효율이 낮은 땀 전지 섬유의 한계를 극복한 스마트 의류용 기능성 섬유를 개발했다.\n" +
                        "\n" +
                        "출처 : 시사위크(http://www.sisaweek.com)");
        information_call(information_list, information_id, imageView, title, content1_TV, content2_TV);
    }

    public void information_add(ArrayList<Information> information_list, String name, String Imgsrc,
                                String content1, String content2){
        Information info;

        info = new Information(information_list.size()+1, name, Imgsrc, content1, content2);
        information_list.add(info);
    }

    public void information_call(ArrayList<Information> information_list, int id, ImageView imageView,
                                 TextView title, TextView content1_TV, TextView content2_TV){
        Information info;
        info = information_list.get(id);

        int imgResId = getResources().getIdentifier(info.getImgSrc(), "drawable", getPackageName());

        imageView.setImageResource(imgResId);
        title.setText(info.getTitle());
        content1_TV.setText(info.getContent1());
        content2_TV.setText(info.getContent2());
    }

    public void onLeftArrowClicked(View v){
        if(information_id <= 0){

        } else {
            information_id--;
            information_call(information_list, information_id, imageView, title, content1_TV, content2_TV);
        }

    }

    public void onRightArrowClicked(View v){
        if(information_id >= information_list.size()-1){

        } else {
            information_id++;
            information_call(information_list, information_id, imageView, title, content1_TV, content2_TV);
        }
    }

}
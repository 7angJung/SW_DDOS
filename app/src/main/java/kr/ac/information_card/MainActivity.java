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
                "이제는 컴퓨터를 직접 입는다! (부제목용)", "스마트 워치를 넘어선 생활의류의 IT화");
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
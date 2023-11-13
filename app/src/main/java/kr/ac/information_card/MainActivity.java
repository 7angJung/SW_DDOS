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

        init_newsletter();
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

    public void onHomeButtonClicked(View v){

    }

    public void onRightArrowClicked(View v){
        if(information_id >= information_list.size()-1){

        } else {
            information_id++;
            information_call(information_list, information_id, imageView, title, content1_TV, content2_TV);
        }
    }

    public void init_newsletter(){

        information_add(information_list, "누가 더 똑똑한 두뇌 달았나… 내년 ‘AI 스마트폰’ 쏟아진다", "@drawable/smartphone_ai",
                "내년부터 인공지능(AI) 스마트폰 시대가 본격적으로 온다!",
                        "삼성전자가 내년 갤럭시S24 시리즈에 AI 기능을 대거 탑재할 예정인 가운데 애플도 내년 아이폰16 시리즈에 AI 기능을 탑재할 것으로 전망된다. 이에 따라 모바일 애플리케이션프로세서(AP) 업체들의 AP 기술 경쟁이 가열되고 있다.\n" +
                        "\n" +
                        "13일 업계에 따르면 삼성전자는 이르면 내년 1월 공개하는 갤럭시S24에 생성형 AI '삼성 가우스'를 도입할 예정이다. 특히 단말기 안에서 자체적으로 정보를 수집하고 연산할 수 있는 '온디바이스 AI' 개발에 박차를 가하고 있다. 온디바이스 AI는 기기가 수집한 정보를 클라우드로 전송하지 않아도 되기 때문에 소비자는 개인정보 전송 없이 기기 제어, 문장 요약, 문법 교정 등을 더 쉽고 편리하게 이용할 수 있다. 중앙 서버를 통하지 않으므로 보안에서도 클라우드 기반 AI 대비 우위를 갖는다.\n" +
                        "\n" +
                        "그 일환으로 삼성전자는 갤럭시S24부터 실시간 통역 통화인 'AI 라이브 통역 콜' 기능을 탑재할 것으로 예상된다. 스마트폰 사용자가 통화 중 자신의 언어로 말하면 기기 내 탑재된 갤럭시 AI가 실시간으로 상대방 언어로 통역해 전달하는 형태다. 별도 앱 설치도 필요 없다.\n" +
                        "\n" +
                        "이를 위해서는 고성능 연산 능력이 필요한데, AI 처리 역량을 강화한 AP가 최근 잇따라 출시되고 있다.\n" +
                        "\n" +
                        "삼성전자가 지난달 초 공개한 차세대 모바일 프로세서 '엑시노스 2400'의 경우 전작 대비 중앙처리장치(CPU) 성능이 1.7배, 인공지능 성능이 14.7배 개선됐다. 퀄컴 스냅드래곤8 3세대도 생성 인공지능 구동을 위해 설계를 바꿨고 신경망처리장치(NPU) 처리 성능을 2세대 대비 98％ 늘렸다. 두 AP 모두 갤럭시 S24 시리즈 탑재가 유력하다.\n" +
                        "\n" +
                        "대만 반도체 기업 미디어텍도 이달 초 디멘시티9300을 공개하며 AI 칩 기술 경쟁에 뛰어들었다. 미디어텍은 디멘시티9300이 초당 토큰 20개의 속도로 매개변수 최대 70억개에 달하는 LLM을 지원한다. 특히 디멘시티9300은 최근 각종 성능실험에서 엑시노스2400, 스냅드래곤8 3세대보다 높은 점수를 보이고 있다. 오포, 비보 등 중국 제조사들은 디멘시티9300을 자사 스마트폰에 채용하기로 했다.\n" +
                        "\n" +
                        "애플도 내년 아이폰16에 AI를 본격 장착할 것이라는 전망이 나온다. 애플은 내년 연례 개발자 대회인 WWDC를 통해 새 LLM 기반의 생성 AI 기술을 탑재한 iOS 18, 아이패드OS 18을 선보일 예정이며 이 기능은 아이폰16에서만 쓸 수 있을 것으로 보인다.\n" +
                        "\n" +
                        "업계 관계자는 \"내년 CES만 해도 많은 업체들의 AI 경연장이 될 가능성이 높다\"며 \"AI 시대가 본격화되면서 스마트폰은 온디바이스 AI 기술이 구현되는 필수 기기가 될 것이며 AI 기술력에 따라 업체들의 경쟁력도 좌우될 것\"이라고 말했다.\n" +
                                "\n" +
                                "출처 : 파이낸셜뉴스(https://www.fnnews.com/news/202311131827577011)");

        information_add(information_list, "네이버, '클로바노트' 정식 서비스 돌입", "@drawable/clova",
                "초거대규모 AI '하이퍼클로바' 적용", "네이버가 인공지능(AI) 기반 회의록 관리 서비스 '클로바노트'를 지난 6일 정식 출시하고 업데이트를 진행했다고 13일 밝혔다.\n" +
                        "\n" +
                        "클로바노트는 음성인식, 자연어처리를 비롯한 네이버의 다양한 AI 기술이 접목된 서비스다. 길고 비정형화된 문장을 인식하는 데 특화한 음성인식 엔진, 참석자 목소리 차이를 구분하는 화자분리 기술 등 자체 음성 AI 기술을 적용해 2020년 'AI 음성기록' 서비스로 출발한 바 있다.\n" +
                        "\n" +
                        "이번 정식 서비스는 초대규모 AI '하이퍼클로바'(HyperCLOVA)가 적용된 회의록 요약을 비롯해 노트 공유, 하이라이트 표시, 메모 등의 기능 추가로 특히 업무 환경에서의 사용성 증가와 함께 'AI 회의록 관리' 서비스로 진화했다.\n" +
                        "\n" +
                        "정식 버전 업데이트를 통해선 회의록 요약을 넘어 AI가 회의나 대화 내용을 바탕으로 핵심 주제와 다음 할 일까지 정리하는 기능이 제공된다. 이를 통해 업무 도구로서의 사용성이 더욱 향상될 전망이다.\n" +
                        "\n" +
                        "이와 함께 클로바노트로 직접 회의를 녹음하고, 녹음이 진행되는 동안 중요한 내용을 메모할 수 있는 기능을 PC와 모바일 앱에서 모두 지원한다. 노트를 더욱 체계적으로 관리할 수 있도록 사용성도 개선됐다.\n" +
                        "\n" +
                        "한익상 네이버클라우드 이사는 \"다양한 사용자 수요를 고려해 개인, 기업용 서비스 플랜을 각각 준비하고 있다\"며 \"기능 확대와 초대규모 언어모델을 활용한 사용자 편의 향상도 지속할 것\"이라고 말했다.\n" +
                        "\n" +
                        "출처 : 비즈와치(https://news.bizwatch.co.kr/article/mobile/2023/11/13/0018)");

        information_add(information_list, "삼성, 스마트빌딩 솔루션 수출 채비… ‘스마트싱스’ B2B 강화", "@drawable/samsung_smart_building",
                "네이버와 협력…사우디 '네옴시티' 스마트빌딩 분야 진출 힘써", "삼성전자가 스마트 오피스빌딩 솔루션을 강화해 해외시장에 진출한다. 기존에 운영하고 있는 빌딩관리시스템(BMS) 솔루션과 빌딩 통합 솔루션 '삼성 b.IoT' 등을 통합, 발전시켜 '스마트싱스' B2B용 솔루션으로 탈바꿈한다. 이를 통해 국내외 스마트 오피스빌딩 솔루션 시장을 공략한다. 최근 사우디아라비아에 1억달러(한화 1350억원) 규모로 디지털 트윈 기술을 수출한 네이버와 손잡고 관련 사업을 공동 추진한다. 사우디의 첨단 미래도시 '네옴시티'에 디지털 트윈, 스마트 빌딩 구축의 공동 수주 가능성도 열린다.\n" +
                        "\n" +
                        "13일 업계와 삼성전자에 따르면 회사는 네이버클라우드와 서울시 강남구 N클라우드 스페이스에서 국내외 미래 지능형 오피스빌딩 사업 성장 가속을 위한 업무협약(MOU)을 체결했다. 삼성전자는 전력·가전 등을 통합 연결·제어하는 스마트싱스와 5G 등 보유한 최신 기술에 네이버클라우드의 자체 솔루션을 연동해 B2B 솔루션을 통합 판매에 나선다는 계획이다.\n" +
                        "\n" +
                        "네이버클라우드의 자체 솔루션은 '테크 컨버전스 빌딩' 콘셉트로 건축된 세계 최초의 로봇 친화형 건물 네이버 1784 신사옥에 적용됐다. 네이버의 업무 공간인 동시에 로봇과 자율주행, 이음5G, 클라우드 등 네이버가 연구·축적한 모든 선행기술의 테스트베드다. 특히 이 신사옥을 기반으로 네이버는 최근 사우디에서 1억 달러 규모로 수도 리야드를 비롯해 메디나, 제다, 담맘, 메카 5개 도시 대상으로 클라우드 기반 3D 디지털모델링, 디지털트윈 플랫폼을 구축·운영 사업을 수주했다.\n" +
                        "\n" +
                        "앞으로 삼성전자는 네이버와 함께 사우디뿐만 아니라 국내외를 망라한 기술 수출을 본격 이어간다는 방침이다. 국내 오피스빌딩에 솔루션을 우선 적용한 후 성공사례를 기반으로 해외 시장에도 단계적으로 접목한다. 이를 위해 양사는 B2B 고객대상 특화패키지 상품화와 공동영업 추진을 위한 워킹그룹을 발족했다.\n" +
                        "\n" +
                        "MOU를 통해 삼성전자는 오피스빌딩 내 모든 기기와 내·외부 솔루션, 서비스를 연동하고 효율적으로 통합 관리하는 디바이스·솔루션·서비스로 스마트한 '캄테크(Calm-Tech)'를 실현한다는 목표다. 빌딩관리시스템(BMS)의 제어를 넘어 사용자 중심으로 확장, 빌딩통합제어 에너지 출입과 보안 관리까지 가능한 미래 지능형 오피스빌딩을 위한 토탈플랫폼을 구축한다.\n" +
                        "\n" +
                        "스마트 오피스빌딩 솔루션 사업은 삼성전자가 지난해 신설한 B2B통합오퍼링사무국에서 주도적으로 추진한다. B2B통합오퍼링사무국은 각 사업부별로 전문화된 디바이스와 솔루션을 B2B 고객에게 통합적으로 제안하기 위해 신설됐다. 강봉구 삼성전자 한국총괄 겸 B2B통합오퍼링사무국장 부사장은 \"AI·로봇·클라우드 분야에서 높은 경쟁력을 갖춘 네이버클라우드와 B2B 특화 제품·솔루션·서비스·5G 네트워크 1위 기술력을 보유한 삼성전자가 협력해 우수한 솔루션을 선보일 계획\"이라고 설명했다.\n" +
                        "\n" +
                        "업계 관계자는 \"최근 오피스 환경이 다양화되는 가운데, 시장 경쟁이 심화되고 생산성 확보가 기업 운영의 필수 요소로 자리 잡으며 급격히 늘어나는 플랫폼 서비스와 스마트 디바이스를 관리하기 위한 효과적 통합 솔루션의 필요성이 커지고 있다\"고 설명했다." +
                        "\n" +
                        "\n출처 : 아시아투데이(https://www.asiatoday.co.kr/view.php?key=20231113010008175)");

        information_add(information_list, "한전, 전력설비 전주기 빅데이터 기반 자산관리시스템 운영", "@drawable/korea_electric_big_data",
                "고장·진단·부하량 등 설비 데이터 통합", "한국전력이 지난 7일 본사 비전홀에서 빅데이터 기반 전력설비 자산관리시스템(AMS)의 오픈식을 개최하고 본격적인 운영에 들어갔다고 9일 밝혔다.\n" +
                        "\n" +
                        "AMS(Asset Management system)는 전력설비 생애주기 빅데이터 기반의 고장확률과 고장발생 시 영향을 종합 평가하고 최적 교체 대상 우선순위를 제공해 효율적 설비투자 의사결정을 지원하는 시스템이다.\n" +
                        "\n" +
                        "한전뿐 아니라 대부분의 글로벌 전력회사는 노후 설비의 증가로 인해 안정적인 설비 운영에 어려움을 겪고 있다. 한전은 이러한 문제에 선제적으로 대응키 위해 합리적인 투자로 낮은 설비 위험도를 유지할 수 있는 전력설비 자산관리시스템 구축을 추진했다.\n" +
                        "\n" +
                        "특히 한전에 특화된 리스크 평가 알고리즘을 개발키 위해 사내 전문가 역량을 결집해 설비 운영 노하우를 반영하고 최적화했으며, 사용자 맞춤형 UI와 기능을 전면 개발하는 등 자산관리 핵심기술과 역량을 확보했다.\n" +
                        "\n" +
                        "AMS 적용 대상 전력설비는 송배전 주요설비 10종(250만대, 8만c-km)이며, 분산된 운영시스템의 데이터(1150억건)를 연계 및 정제하여 고품질의 통합 DB를 구축했다.\n" +
                        "\n" +
                        "김동철 한전사장은\"최적의 설비 교체 시기를 선정하여, 전력공급 신뢰도를 높이면서도 투자 비용을 크게 낮출 수 있는 자산관리시스템은 회사가 겪고 있는 재무위기 해소에 크게 기여할 것이다\"고 기대했다."+
                        "\n" +
                        "\n출처 : 일렉트릭파워(https://www.epj.co.kr/news/articleView.html?idxno=33290)");

        information_add(information_list, "로블록스, 메타버스에 '생성 AI' 도입...저커버그도 개발 중", "@drawable/roblox_ai",
                "텍스트로 캐릭터·건물 제작...메타버스 '모먼텀'으로 주목", "계 최대의 메타버스 및 게임 플랫폼인 로블록스가 메타버스에 생성 인공지능(AI)을 도입한다. 메타도 똑같은 계획을 밝힌 터라, 생성 AI가  메타버스 플랫폼의 모먼텀이 될지 주목된다.\n" +
                        "\n" +
                        "자연어 프롬프트 기반으로 로블록스 월드 내에서 가상 개체를 구축할 수 있는 생성 AI 도구와 텍스트 기반 코드를 생성할 수 있는 생성 AI 두 가지가 현재 테스트 중이라고 20일(현지시간) 테크크런치가 보도했다.\n" +
                        "\n" +
                        "공개된 영상에 따르면 개발자는 별도의 코딩 없이 텍스트만으로 로블록스 내 가상 세계에서 물체나 건물을 생성하고 움직일 수 있다. 비를 내리는 등 기상 조건도 바꿀 수 있다.\n" +
                        "\n" +
                        "다니엘 스터만 로블록스 CTO는 \"일부 크리에이터는 코딩 방법을 알고 있지만 높은 수준의 3D 모델을 만드는 경험이 적을 수 있고, 반대로 일부 디자이너는 코딩 경험이 적을 수 있다\"며 두 가지 버전의 생성 AI 도구를 준비했다고 설명했다. 또 \"코딩도 디자인 경험도 없는 초보자도 이 도구들을 사용하면 로블록스에서 상상력을 실현할 수 있다\"고 덧붙였다.\n" +
                        "\n" +
                        "몇 주 안에 로블록스 스튜디오를 통해 생성 AI 도구를 공개할 예정이다. 또 다음 달 열리는 게임개발자콘퍼런스(GDC) 2023에서 생성 AI에 대한 발표도 예고했다.\n" +
                        "\n" +
                        "테크크런치는 전 세계 하루 이용자가 5880만명에 달하는 로블록스의 움직임은 중요한 의미를 가지며, 이미 예고된 것이라고 설명했다. 최근 몇 년 동안 로블록스는 메타버스 플랫폼 역할을 넘어 메타버스를 구축하는 인프라가 되겠다는 목표를 거듭 밝혔다는 것.\n" +
                        "\n" +
                        "또 생성 AI의 도입은 많은 초보 개발자를 끌어들일 수 있으며 젊은 사용자에도 매력적일 수 있다고 분석했다.\n" +
                        "\n" +
                        "이처럼 생성 AI는 최근 메타버스 업계에서도 뜨거운 이슈다.\n" +
                        "\n" +
                        "마크 저커버그 메타 CEO는 최근 \"메타가 생성  AI 의 선두주자가 되겠다\"며 \"이미지나 비디오, 아바타 및 3D 자산을 생성하는 AI 기술을 제품 전반에 걸쳐 도입 중\"이라고 밝혔다. 메타의 '호라이즌 월드'에 생성 AI가 도입되는 것은 시간문제다.\n" +
                        "\n" +
                        "더불어 지난해 11월에는 엔비디아가 메타버스용 3D 이미지 생성 AI 모델 '겟3D'를, 12월에는 오픈AI가 '포인트-E'를 공개하는 등 메타버스를 겨냥한 생성 AI 모델이 잇달아 출시됐다. 또 아르투르 시초프 솜니움 스페이스 CEO는 챗GPT를 도입해 망자와 대화할 수 있게 만든다는 메타버스를 구축 중이라고 밝혀 화제가 됐다.\n" +
                        "\n" +
                        "이에 대해 젠슨 황 엔비디아 CEO는 지난해 말 \"생성 AI가 없다면 소비자가 어떻게 가상 세계를 만들 수 있겠는가\"라며 \"이 기술은 이제 시작 단계로, 앞으로 가상 세계를 3D로 구축하는 데 필수적이 될 것\"이라고 강조했다.\n" +
                        "\n" +
                        "출처 : AI타임스(https://www.aitimes.com)");

        information_add(information_list, "[UDC 2023] \"블록체인 대중화는 아시아에서 시작\"", "@drawable/ubit_conferrence",
                "\"인류의 60%가 아시아에 있다. 블록체인의 매스어돕션은 아시아에서 시작할 것이다\"", "소타 와타나베 아스타재단 대표(CEO)는 13일 그랜드 워커힐 서울에서 열린 '업비트 D 콘퍼런스(UDC) 2023'에서 아스타네트워크의 성과와 전략을 공유했다.\n" +
                        "\n" +
                        "와타나베 대표는 \"아스타 네트워크는 일본에서 시가총액 1위 프로젝트\"라며 \"일본의 대표 기업들과 협업을 하면서 대표적인 웹3 프로젝트로 인식되고 있다\"고 말했다. 아스타 네트워크와 협업을 한 대기업은 소니, 도요타, 도코모, 소프트뱅크. 세븐일레븐, 가루비 등이다.\n" +
                        "\n" +
                        "대체불가능토큰(NFT) 발행 사례도 공유했다. 그는 \"394개 글로벌 기업과 손잡고 니케이 신문을 통해 NFT를 배포했다\"며 \"니케이 신문은 구독자가 260만 명에 달해 일본에서 가장 영향력이 있는 일간지\"라고 설명했다.\n" +
                        "\n" +
                        "철도회사인 JR은 아스타 네트워크와 손잡고 NFT를 발행하고 있다. 일본 감자칩 회사인 가루비는 소비자 로열티 캠페인에 활용하기 위해 아스타 네트워크를 활용했다. \n" +
                        "\n" +
                        "아스타 네트워크는 내년 1분기 메인넷 출시를 목표로 하고 있다. 와타나베 대표는 \"아스타 네트워크는 폴카닷에서 시작해 생태계 내에서 최대 프로그램이 됐다\"며 \"이더리움을 도입하는 등 더 많은 블록체인과 연결할 계획\"이라고 말했다.\n" +
                        "\n" +
                        "와타나베 대표는 \"암호화폐 시장과 전통 금융시장의 다리 역할을 하게 될 것\"이라며 \"일본에서 시작해서 아시아 전역, 그리고 글로벌하게 이용하게 되는 로드맵을 구상하고 있다\"고 말했다."+
                        "\n" +
                        "\n출처 : 코인데스크코리아(https://www.coindeskkorea.com/news/articleView.html?idxno=93302)");

        information_add(information_list, "K2코리아, “클라우드 도입으로 인프라 측면에서 비즈니스 연속성 향상”", "@drawable/k2korea",
                "베스핀글로벌, 클라우드 도입부터 멀티 클라우드 환경 구축 및 운영까지 지원\n", "베스핀글로벌은 국내 종합 패션 기업 ‘K2코리아’가 클라우드 도입으로 인프라 측면에서 비즈니스 연속성 향상 등의 효과를 누리고 있다고 밝혔다.\n" +
                        "\n" +
                        "K2코리아는 아웃도어 브랜드 ‘K2’, ‘아이더’와 골프웨어 브랜드 ‘와이드앵글’, ‘피레티’, 스포츠 브랜드 ‘다이나핏’, 안전화 브랜드 ‘K2세이프티’, ‘아이더세이프티’ 등을 보유한 종합 패션 기업이다. 전국 1,000여 곳 이상의 매장과 통합 온라인 쇼핑몰을 운영하고 있다.\n" +
                        "\n" +
                        "과거 모든 인프라를 온프레미스로 운영했던 K2코리아는 2018년부터 점차적으로 클라우드를 도입하기 시작했다. 특히 RFID를 클라우드 상에 구축해 전사 적용함으로써 모든 브랜드 제품의 생산부터 입고, 출고, 판매 CS까지 전 이력을 체계적으로 관리할 수 있게 됐다. 이를 통해 물류 업무를 효율화하고 비용 절감까지 달성할 수 있었다. 또한 K2코리아 신발연구소에서 실시하는 사용성 평가 설문조사도 클라우드 상의 온라인 플랫폼으로 전환해 문서 관리 업무의 생산성을 향상시키기도 했다.\n" +
                        "\n" +
                        "현재 K2코리아는 여러 클라우드 플랫폼을 활용하는 멀티 클라우드와 함께, 온프레미스 서버와 클라우드를 같이 사용하는 하이브리드 클라우드를 운영 중이다. K2코리아는 이전의 온프레미스 환경에서 종종 발생하던 인프라 상의 오류들이 클라우드 도입 이후에는 단 한 번도 발생하지 않았다고 밝혔다.\n" +
                        "\n" +
                        "K2코리아는 이처럼 클라우드를 활용하면서 무중단 시스템 구축이 가능해졌고 인프라 측면에서 비즈니스 연속성이 50% 이상 향상됐다. 안정적이면서 유연한 클라우드 인프라 운영을 경험한 후, K2코리아는 ERP의 클라우드 전환도 고려하게 되었고 안정성과 비용 등을 고려해 멀티 클라우드 플랫폼 운영을 결정했다.\n" +
                        "\n" +
                        "베스핀글로벌은 K2코리아의 클라우드 도입 초기부터 멀티 클라우드 운영까지 지속적인 클라우드 전환을 지원하고 있다. 베스핀글로벌의 도움을 바탕으로 K2코리아는 클라우드 플랫폼 선택과 스펙 비교부터 클라우드 아키텍처 설계, 실제 구성, 서버 이중화 등을 순조롭게 진행할 수 있었다. 회계, 인사, 기획, 영업 등 사내뿐만 아니라 전국 각지에서 운영 중인 1,000여 곳의 매장과 창고 관리까지 통합된 ERP 시스템을 클라우드로 전환해 인프라의 유연성과 민첩성을 확보할 수 있게 됐다.\n" +
                        "\n" +
                        "베스핀글로벌은 옵스나우의 클라우드 보안 형상 관리 플랫폼(CSPM)인 ‘옵스나우 시큐리티’를 추천해 K2코리아의 클라우드 보안 환경을 더욱 체계적으로 관리할 수 있도록 지원했다. K2코리아는 옵스나우 시큐리티를 통해 맞춤형 정책에 따른 지속적인 모니터링과 다양한 개선 가이드를 안내받음으로써 클라우드 보안 환경을 강화할 수 있었다.\n" +
                        "\n" +
                        "K2코리아 전산실의 문기석 이사는 “고객들에게 안정적인 서비스를 제공하기 위해 멀티 클라우드 활용을 결정했다. 새로운 클라우드 플랫폼 활용에 대한 걱정을 비롯해 복잡한 정책과 보안 등 다양한 우려가 있었으나, 멀티 클라우드 관련 노하우가 풍부한 베스핀글로벌과의 협력으로 현재 성공적으로 운영 중이다. 특히 온프레미스 환경에서 종종 발생하던 문제가 현재까지 한 차례도 발생하지 않아 매우 만족스럽다”고 전했다.\n" +
                        "\n" +
                        "이번 프로젝트를 담당한 베스핀글로벌의 이동훈 팀장은 “패션 업계, 특히 상품 재고 관리 분야에서 디지털 역량을 통해 효율성과 생산성을 높이려는 추세가 계속되고 있다”며, “K2코리아는 RFID에 이어 전사 ERP 시스템을 클라우드로 전환하며 효율성 강화는 물론, 비용도 대폭 절감할 수 있었다. 베스핀글로벌은 앞으로도 고객의 클라우드 혁신에 적극 협력할 것”이라고 밝혔다.\n" +
                        "\n" +
                        "출처 : 디지털경제뉴스(http://www.denews.co.kr)");

        information_add(information_list, "메타, 텐센트 통해 中서 VR 출시 추진… 15년만에 재진출하나", "@drawable/vr_device",
                "WSJ \"내년 말 판매 위한 계약…정부 승인 여부 미지수\"", "페이스북 모회사 메타가 중국의 정보기술(IT) 대기업 텐센트 홀딩스와 저가 버전의 가상현실(VR) 헤드셋 판매를 위한 예비 계약을 체결했다.\n" +
                        "\n" +
                        "10일(현지시간) 월스트리트저널(WSJ)에 따르면 텐센트가 메타의 VR 헤드셋에 대한 중국 독점 판매권을 확보했다. 내년 말부터 메타는 본격적으로 중국에서 판매를 시작할 예정이다. 이를 위해 두 회사는 앞으로 1년간 협상을 통해 최종 계약을 체결할 예정이다.\n" +
                        "\n" +
                        "메타의 VR 헤드셋이 중국에서 판매되면 메타는 15년 만에 중국 시장에 진출하게 된다. 메타의 페이스북은 지난 2009년 7월 5일 중국 신장 위구르자치구 우루무치에서 발생한 유혈사태를 계기로 중국에서 접속이 차단됐다. 당시 위구르계 반체제 인사가 페이스북을 통해 시위를 독려하는 글을 남긴 것이 빌미가 됐다.\n" +
                        "\n" +
                        "\n" +
                        "다만, 중국 정부의 승인 여부가 마지막 관문으로 남아 있다. WSJ은 닌텐도 등 다른 비디오 게임처럼 메타의 VR 헤드셋 판매를 위해 중국 정부 승인이 필요한 지 등은 아직 불확실하다고 전했다. 중국 정부가 최근 게임과 디지털 콘텐츠 관련 규제를 강화하고 있다는 점에서 메타의 헤드셋이 중국 시장에 진출할 수 있을지는 미지수다.\n" +
                        "\n" +
                        "중국 시장을 겨냥한 VR 헤드셋은 메타의 최신 모델인 ‘퀘스트 3’보다 저렴한 렌즈가 탑재될 것으로 알려졌다. 이에 따라 메타가 지난 9월 출시한 ‘퀘스트 3’(499달러·65만9000원)보다 가격은 낮아질 전망이다.\n" +
                        "\n" +
                        "시장 분석 업체 카운터포인트리서치에 따르면 올해 1분기 기준 전 세계 VR 시장 점유율은 메타가 49%로 가장 높다. 이어 소니가 32%로 뒤를 잇고 있다. 그러나 이 기간 전 세계 헤드셋 출하량은 전년 동기 대비 33% 감소했다.\n" +
                        "\n" +
                        "출처 : 씨데일리(https://www.sedaily.com/NewsView/29X70CZK32)");

        information_add(information_list, "\"6G 선도할 자리 잡아라\"…통신3사, 분주한 이유", "@drawable/telecom_6g",
                "통신업계, 6G 기술·서비스 개발 집중", "통신3사가 6세대 이동통신(6G) 기술을 선도하기 위해 발 빠르게 움직이고 있다. 6G가 단순히 모바일 기기 간 통신 기술에만 쓰이지 않고 도심항공교통(UAM)을 비롯한 차세대 기술을 뒷받침하는 근간 역할을 하기 때문이다. 다음달 아랍에미레이트(UAE)에서 처음으로 6G 주파수 후보대역을 논의하는 세계전파통신회의(WRC23)가 열리는 만큼 통신3사는 6G 기술력에서 우위를 점하려는 시도를 앞서기 위해 잰걸음을 옮길 계획이다.\n" +
                        "\n" +
                        "11일 통신업계에 따르면 통신3사는 6G 상용화를 대비하기 위해 관련 기술과 서비스 개발에 집중하고 있다.\n" +
                        "\n" +
                        "6G는 5G를 잇는 차세대 통신 기술이다. 최소 초당 100기가비트(Gbps), 최대 초당 1테라비트(Tbps)의 속도를 자랑한다. 이는 5G의 이론적 최대 속도인 20Gbps보다 적어도 5배 빠르다. 속도가 빠른 만큼 대용량 정보도 짧은 시간 내에 처리할 수 있다. 이러한 특징으로 인해 6G는 모바일 통신뿐 아니라 도심항공교통, 인공지능(AI), 가상현실(VR) 등에 쓰일 핵심 기술로 꼽힌다. \n" +
                        "\n" +
                        "SK텔레콤은 5G의 백본(기간망) 대비 전송 속도를 4배 늘린 400Gbps급 유선망을 상용 도입하기로 했다. 6G의 트래픽(사용량)을 대비하기 위해서다. SK텔레콤은 추후 전국 기간망에 400Gbps 유선망을 확대 적용할 계획이다.\n" +
                        "\n" +
                        "앞서 SK텔레콤은 지난해 7월 6G 개발팀을 만들고 지난 8월에는 국내 최초로 6G 표준화와 초기 생태계의 목표를 담은 6G 백서를 내놓기도 했다. 또 6G가 건물을 잘 통과하도록 지난 2월 6G 후보 주파수에 대한 지능형반사표면(RIS) 기술을 개발하기도 했다. SK텔레콤은 6G 후보 주파수 대역을 4기가헤르츠(㎓)~10㎓ 사이로 검토하고 있다.\n" +
                        "\n" +
                        "KT도 6G 관련 기술 개발에 분주하다. 지난 6월 오픈랜 가상화 기지국의 멀티벤더(여러 업체의 제품이나 서비스를 함께 쓰는 것) 연동에 성공했다. 오픈랜은 서로 다른 통신 장비의 소프트웨어와 하드웨어를 연동할 수 있는 기술이다. 가상화 기지국은 다양한 망 기능을 소프트웨어 형태로 구현하는 것을 뜻한다.  KT는 이를 통해 통신 장비 간 호환성을 높이고 장비 설치 비용과 시간을 줄일 수 있다고 설명했다. KT 역시 지난해 11월 RIS 기술 실증에 성공하기도 했다.\n" +
                        "\n" +
                        "LG유플러스는 지난 2일 지속 가능성과 지능화, 확장성을 6G 비전으로 하는 6G 백서를 발간했다. 지속 가능성은 친환경과 함께 에너지·자원 이용이 지속 가능해야 한다는 측면을 강조하는 의미를 담고 있다. 지능화는 AI와 머신러닝을 바탕으로 망 기반 시설을 운영하고 관리해 서비스 제공 수준을 높이는 것을 뜻한다. 확장성은 상공이나 해상, 깊은 산 속 등에서도 원활한 통신 서비스를 이용하는 것이다.\n" +
                        "\n" +
                        "또 LG유플러스는 지난달 한국과학기술원(KAIST), 국내 양자 컴퓨팅 소프트웨어 개발업체 '큐노바'와 함께 양자 컴퓨터를 활용해 6G 저궤도 위성망을 최적화하는 연구에 성공했다. 이를 통해 위성과 지상, 지상과 위성을 잇는 전 구간을 초고속·초저지연 서비스로 제공할 수 있게 됐다는 게 회사측 설명이다.\n" +
                        "\n" +
                        "이처럼 통신3사가 6G 기술 개발에 분주한 이유는 다음달 20일(현지시각 기준) UAE에서 처음으로 6G 후보 주파수 대역을 논의하는 WRC23이 열리기 때문이다. WRC23은 국제전기통신연합(ITU)이 주최하는 회의로, 전 세계 주파수 분배와 전파 통신 분야의 중요 사항을 결정한다. 이 회의에는 우리나라를 비롯한 193개국이 참여한다.\n" +
                        "\n" +
                        "특히 6G에 대한 기술이나 관련 서비스 개발의 진척도에 따라 6G 시장의 초반 주도권이 결정된다. 이러한 이유로 통신3사가 6G 기술 개발에 몰두하고 있는 것이다.\n" +
                        "\n" +
                        "통신업계 관계자는 \"특정 대역의 6G 관련 기술, 서비스 등 시연이나 개념이 검증되면 상용화 대역으로 채택될 때 유리한 측면이 있다\"며 \"앞으로 통신3사는 도서·산간 지역, 먼바다 등에서 6G를 활용해 지상과 동일한 품질의 서비스를 제공할 수 있도록 하는 기술 개발에 집중할 것으로 보인다\"고 말했다." +
                        "\n" +
                        "\n출처 : 비즈와치(https://www.bizwatch.co.kr/)");

        information_add(information_list, "”챗GPT가 자율주행도 가능”...고스트, LMM 기반 자율주행 소프트웨어 구축", "@drawable/ghost_car",
                "자율 주행 기술과 생성형 AI가 만났다!", "언어모델이 텍스트 생성을 넘어 자율 주행에도 활용될 것으로 보인다. 텍스트와 이미지를 이해할 수 있는 멀티모달 대형언어모델(LLM), 이른바 대형멀티모달모델(LMM)을 활용해 차량 카메라의 도로 장면 사진을 읽고 도로 상황을 이해해 차량을 제어하는 자율 주행 소프트웨어가 화제다.\n" +
                        "\n" +
                        "테크크런치는 9일(현지시간) 자율주행 소프트웨어 전문 스타트업 고스트 오토노미(Ghost Autonomy)가 LMM을 자율주행에 적용하는 방법을 모색 중이라고 보도했다. \n" +
                        "\n" +
                        "고스트는 오픈AI의 스타트업 펀드를 통해 500만달러(약 66억원)를 투자받아 설립한 회사로, 마이크로소프트(MS) 애저 클라우드에서 오픈AI 시스템을 활용 중이다. 또 자율주행 소프트웨어 구축을 위해 멀티모달 기능을 갖춘 'GPT-4V' 및 'GPT-4 터보'를 활용하는 것으로 알려졌다.\n" +
                        "\n" +
                        "존 헤이스 고스트 CEO는 \"LMM은 '롱테일(longtail)'을 이해하는 새로운 방법을 제공, 현재 모델의 약점인 복잡한 장면에 대한 추론이 가능하게 한다”라며 \"이런 사례는 LMM이 더 빠르고 더 많은 기능을 수행함에 따라 증가할 것\"이라고 설명했다.\n" +
                        "\n" +
                        "통계학에 근원을 둔 '롱테일'이란 단어는 발생 가능성이 낮은 다수의 사건이 통계분포의 한쪽에 길게 분포된 현상을 말한다. 롱테일은 AI 시스템의 설계와 운영에도 큰 영향을 미친다. 현재 AI 시스템은 롱테일 데이터에 특히 취약한데, 이는 발생 가능성이 낮아 대량의 데이터를 필요로 하는 AI 학습 데이터에 포함돼 있지 않기 때문이다.\n" +
                        "\n" +
                        "고스트는 복잡한 장면을 해석 및 설명하고 텍스트를 생성해 자율 주행 차량을 제어하도록 훈련된 LMM을 사용하는 소프트웨어를 시험하고 있다. 예를 들어 차량에 장착된 카메라의 도로 장면 사진을 기반으로 차량 제어 하드웨어에 ‘오른쪽 차선으로 이동’과 같은 명령을 내리는 식이다.\n" +
                        "\n" +
                        "헤이스 CEO는 “고스트에서는 기존 모델을 미세조정하고 자체 모델을 훈련해 도로에서의 안정성과 성능을 극대화하기 위해 노력할 것”이라고 말했다. \n" +
                        "\n" +
                        "실제로 LMM이 유용할 것이라는 예도 내놓았다. 건설 구역에는 임시 차선이나 변경 표지판, 다른 도로의 상황 등 간단한 모델로는 탐색하기 어려울 수 있는 복잡하고 특이한 구성 요소가 있지만, LMM은 인간과 같은 수준의 추론으로 이런 모든 변수를 처리할 수 있는 것으로 나타났다고 밝혔다.\n" +
                        "\n" +
                        "그러나 대부분 전문가들은 회의적인 반응을 보였다. \n" +
                        "\n" +
                        "오스 케이예스 워싱턴 대학 교수는 “LMM은 자율주행을 위해 설계되거나 훈련되지 않았으며, 몇가지 과제를 해결하는 데 덜 효율적인 방법일 수 있다”라며 “LMM이 자율주행에 어울리지 않는다고 확신한다”라고 주장했다.\n" +
                        "\n" +
                        "마이크 쿡 킹스칼리지 런던 교수 역시 “오픈AI의 주력 모델은 환각을 만들고 텍스트를 잘못 복사하거나 색상을 잘못 입력하는 등 인간이 하지 않을 기본적인 실수를 저지른다”라며 “자동차 운전처럼 위험하고 복잡한 일에 LMM을 배치할 이유가 전혀 없다. 종종 예측할 수 없고 불안정한 이 기술을 자율 주행에 적용해야 한다는 생각은 시기상조”라고 못 박았다.\n" +
                        "\n" +
                        "그러나 브레드 라이트캡 오픈AI COO는 \"LMM은 자동차를 포함한 많은 새로운 사용 사례로 확장될 수 있는 잠재력을 가지고 있다\"라며 \"비디오, 이미지, 오디오를 결합해 결론을 이해하고 도출할 수 있는 능력을 갖춘 LMM은 장면을 이해하고 복잡하거나 특이한 환경을 탐색하는 새로운 방법을 만들 수 있다\"라고 반박했다.\n" +
                        "\n" +
                        "헤이스 CEO도 시기상조라는 점에는 동의했다. “물론 현재 모델은 자동차에 상업적으로 사용될 준비가 안 됐다”라며 “신뢰성과 성능을 향상하기 위해서는 아직 해야 할 일이 많다”라고 말했다.\n" +
                        "\n" +
                        "출처 : AI타임스(https://www.aitimes.com)");
    }



}
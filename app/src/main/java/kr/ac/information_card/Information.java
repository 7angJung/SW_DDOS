package kr.ac.information_card;

public class Information {
    private int information_Id;
    private String title;
    private String ImgSrc;
    private String content1, content2, content3;

    Information(int information_Id, String title, String Imgsrc, String content1){
        this.information_Id = information_Id;
        this.title = title;
        this.ImgSrc = Imgsrc;
        this.content1 = content1;
    }

    Information(int information_Id, String title, String Imgsrc, String content1, String content2){
        this.information_Id = information_Id;
        this.title = title;
        this.ImgSrc = Imgsrc;
        this.content1 = content1;
        this.content2 = content2;
    }
    Information(int information_Id, String title, String Imgsrc, String content1, String content2, String content3){
        this.information_Id = information_Id;
        this.title = title;
        this.ImgSrc = Imgsrc;
        this.content1 = content1;
        this.content2 = content2;
        this.content3 = content3;
    }

    public int getInformation_Id() {
        return information_Id;
    }

    public String getTitle() {
        return title;
    }

    public String getImgSrc() {
        return ImgSrc;
    }

    public String getContent1() {
        return content1;
    }

    public String getContent2() {
        return content2;
    }

    public String getContent3() { return content3; }

    public void setInformation_Id(int information_Id) {
        this.information_Id = information_Id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImgSrc(String imgSrc) {
        ImgSrc = imgSrc;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public void setContent3(String content3) { this.content3 = content3; }
}

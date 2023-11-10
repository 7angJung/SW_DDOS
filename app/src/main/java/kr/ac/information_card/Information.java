package kr.ac.information_card;

public class Information {
    private int information_Id;
    private String name;
    private String ImgSrc;
    private String content1, content2;

    Information(int information_Id, String name, String Imgsrc, String content1, String content2){
        this.information_Id = information_Id;
        this.name = name;
        this.ImgSrc = Imgsrc;
        this.content1 = content1;
        this.content2 = content2;
    }

    public int getInformation_Id() {
        return information_Id;
    }

    public String getName() {
        return name;
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

    public void setInformation_Id(int information_Id) {
        this.information_Id = information_Id;
    }

    public void setName(String name) {
        this.name = name;
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
}

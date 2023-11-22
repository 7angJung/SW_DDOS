package co.kr.M_Git_Project;

import java.io.Serializable;

public class Post implements Serializable { // 게시판의 글 객체를 표현하기 위한 Post 클래스
    private int post_id; // 포스트 고유번호
    private String title; // 글 제목
    private String content; // 글 내용
    private String timeStamp; // 글 쓴 시간

    Post(int post_id, String title, String content, String timeStamp){
        this.post_id = post_id; this.title = title; this.content = content;
        this.timeStamp = timeStamp;
    } // 생성자 (메모장용)

    //==================================================================
    int getPost_id() {return post_id;}
    String getTitle() {return title;}
    String getContent() {return content;}
    String getTimeStamp() {return timeStamp;}
    void setPost_id(int post_id) {this.post_id = post_id;}
    void setTitle(String title) {this.title = title;}
    void setContent(String content) {this.content = content;}
    void setTimeStamp(String timeStamp) {this.timeStamp = timeStamp;}
    // ============= getter 함수, setter 함수 설정 ========================
}
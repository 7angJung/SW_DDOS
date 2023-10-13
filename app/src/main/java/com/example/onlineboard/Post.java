package com.example.onlineboard;

import java.io.Serializable;

public class Post implements Serializable { // 게시판의 글 객체를 표현하기 위한 Post 클래스
    private String post_id; // 포스트 고유번호
    private String title; // 글 제목
    private String content; // 글 내용
    private String author; // 글 쓴 사람
    private String timeStamp; // 글 쓴 시간

    Post(String post_id, String title, String content, String author, String timeStamp){
        this.post_id = post_id; this.title = title; this.content = content;
        this.author = author;   this.timeStamp = timeStamp;
    } // 생성자

    String getPost_id() {return post_id;}
    void setPost_id(String post_id) {this.post_id = post_id;}
    String getTitle() {return title;}
    void setTitle(String title) {this.title = title;}
    String getContent() {return content;}
    void setContent(String content) {this.content = content;}
    String getAuthor() {return author;}
    void setAuthor(String author) {this.author = author;}
    String getTimeStamp() {return timeStamp;}
    void setTimeStamp(String timeStamp) {this.timeStamp = timeStamp;}
    // getter 함수, setter 함수 설정
    
}

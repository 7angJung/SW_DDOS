package com.example.onlineboard;

import java.io.Serializable;
import java.util.ArrayList;

public class Post implements Serializable { // 게시판의 글 객체를 표현하기 위한 Post 클래스
    private String post_id; // 포스트 고유번호
    private String title; // 글 제목
    private String content; // 글 내용
    private String author; // 글 쓴 사람
    private String timeStamp; // 글 쓴 시간
    private ArrayList<Comment> comments; // 댓글 리스트


    Post(String post_id, String title, String content, String author, String timeStamp){
        this.post_id = post_id; this.title = title; this.content = content;
        this.author = author;   this.timeStamp = timeStamp;
        comments = new ArrayList<>();
    } // 생성자

    //==================================================================
    String getPost_id() {return post_id;}
    String getTitle() {return title;}
    String getContent() {return content;}
    String getAuthor() {return author;}
    String getTimeStamp() {return timeStamp;}
    void setPost_id(String post_id) {this.post_id = post_id;}
    void setTitle(String title) {this.title = title;}
    void setContent(String content) {this.content = content;}
    void setAuthor(String author) {this.author = author;}
    void setTimeStamp(String timeStamp) {this.timeStamp = timeStamp;}
    // ============= getter 함수, setter 함수 설정 ========================

    //=======================================================================
    public void addComment(Comment comment) {
        comments.add(comment);
    } // 댓글 추가
    public void setComment(ArrayList<Comment> comments) {this.comments = comments;} // 댓글 리스트 설정
    public ArrayList<Comment> getComments() {
        return comments;
    } // 댓글 반환
    //======================Comments용 함수===================================
}

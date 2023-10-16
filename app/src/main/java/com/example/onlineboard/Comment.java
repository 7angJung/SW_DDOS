package com.example.onlineboard;
import java.io.Serializable;

public class Comment implements Serializable {
    private String commentId;
    private String content;
    private String author;
    private String timeStamp;

    public Comment(String commentId, String timeStamp, String content, String author) {
        this.commentId = commentId;
        this.timeStamp = timeStamp;
        this.content = content;
        this.author = author;
    }

    public String getCommentIdId() {return commentId;}
    public String getTimeStamp() {return timeStamp;}
    public String getContent() {return content;}
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
    public void setCommentId(String commentId) {this.commentId = commentId;}
    public void setTimeStamp(String timeStamp) {this.timeStamp = timeStamp;}
    public void setContent(String content) {this.content = content;}
}

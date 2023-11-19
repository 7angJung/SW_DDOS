package co.kr.M_Git_Project;
import java.io.Serializable;

public class Comment implements Serializable { // 댓글 구현을 위한 Comment 클래스
    private String commentId; // 댓글번호
    private String content; // 댓글 내용
    private String author; // 댓글 작성자
    private String timeStamp; // 작성시간

    public Comment(String commentId, String timeStamp, String content, String author) {
        this.commentId = commentId;
        this.timeStamp = timeStamp;
        this.content = content;
        this.author = author;
    } // 생성자

    //=============================================================
    public String getCommentIdId() {return commentId;}
    public String getTimeStamp() {return timeStamp;}
    public String getContent() {return content;}
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
    public void setCommentId(String commentId) {this.commentId = commentId;}
    public void setTimeStamp(String timeStamp) {this.timeStamp = timeStamp;}
    public void setContent(String content) {this.content = content;}
    //================ get, setter 설정============================
}

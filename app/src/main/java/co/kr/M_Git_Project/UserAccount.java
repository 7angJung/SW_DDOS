package co.kr.M_Git_Project;

/*
*사용자 계정 정보 모델 클래스
 */
public class UserAccount {
    private String idToken; //Firebase Uid (고유 토큰 정보)
    private String userId;
    private String userPw;
    private String userAlpha; //사용자 변수

    public UserAccount(){ }

    public void setUserAlpha(String userAlpha) {
        this.userAlpha = userAlpha;
    }

    public String getUserAlpha() {
        return userAlpha;
    }

    public String getUserId() {
        return userId;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIdToken() {
        return idToken;
    }
}

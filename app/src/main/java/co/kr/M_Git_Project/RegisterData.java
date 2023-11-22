package co.kr.M_Git_Project;


public class RegisterData {
    private String idToken; //Firebase Uid (고유 토큰 정보)
    private String userName;
    private String userID;
    private String userBirth;
    private String userPwd;
    private String userInterest;
    private String userAuthority;

    public String IdToken(String idToken) { return idToken; }

    public String getUserName() {
        return userName;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public String getUserInterest() { return userInterest; }

    public String getAuthority() {return userAuthority; }

    public void setIdToken(String idToken) { this.idToken = idToken; }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public void setUserInterest(String userInterest) {
        this.userInterest = userInterest;
    }

    public void setUserAuthority(String userAuthority) { this.userAuthority = userAuthority; }

    public RegisterData(String idToken, String userName, String userID, String userBirth, String userPwd, String userInterest, String userAuthority) {
        this.idToken = idToken;
        this.userName = userName;
        this.userID = userID;
        this.userBirth = userBirth;
        this.userPwd = userPwd;
        this.userInterest = userInterest;
        this.userAuthority = userAuthority;
    }

    public RegisterData() {}
}

package com.example.mgit;


public class RegisterData {
    private String userName;
    private String userID;
    private String userBirth;
    private String userPwd;

    public String getName() {
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

    public RegisterData(String userName, String userID, String userBirth, String userPwd) {
        this.userName = userName;
        this.userID = userID;
        this.userBirth = userBirth;
        this.userPwd = userPwd;
    }

    public RegisterData() {}
}

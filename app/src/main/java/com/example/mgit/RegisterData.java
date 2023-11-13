package com.example.mgit;

import com.google.gson.annotations.SerializedName;

public class RegisterData {
    @SerializedName("userName")
    private String userName;

    @SerializedName("userID")
    private String userID;

    @SerializedName("userBirth")
    private String userBirth;

    @SerializedName("userPwd")
    private String userPwd;

    public RegisterData(String userName, String userID, String userBirth, String userPwd) {
        this.userName = userName;
        this.userID = userID;
        this.userBirth = userBirth;
        this.userPwd = userPwd;
    }
}

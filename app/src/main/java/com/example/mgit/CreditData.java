package com.example.mgit;

import com.google.gson.annotations.SerializedName;

public class CreditData {
    @SerializedName("userCredit1")
    private String userCredit1;

    @SerializedName("userCredit2")
    private String userCredit2;

    @SerializedName("userGrade")
    private String userGrade;

    public CreditData(String userCredit1, String userCredit2, String userGrade) {
        this.userCredit1 = userCredit1;
        this.userCredit2 = userCredit2;
        this.userGrade = userGrade;
    }
}

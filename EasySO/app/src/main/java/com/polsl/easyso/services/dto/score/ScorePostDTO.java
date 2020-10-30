package com.polsl.easyso.services.dto.score;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ScorePostDTO {

    @Expose
    @SerializedName("username")
    private String userName;

    @Expose
    @SerializedName("score")
    private Integer score;

    @Expose
    @SerializedName("authKey")
    private String authKey;

    public ScorePostDTO() {
    }

    public ScorePostDTO(String userName, Integer score, String authKey) {
        this.userName = userName;
        this.score = score;
        this.authKey = authKey;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }
}

package com.xly.moblogin.enity;

/**
 * Created by nil on 2016/5/26.
 */
public class UserInfo {
    private String accessToken;
    private String expiresIn;
    private String UserId;
    private String nickname;

    public UserInfo(String accessToken, String expiresIn, String userId, String nickname) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        UserId = userId;
        this.nickname = nickname;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn='" + expiresIn + '\'' +
                ", UserId='" + UserId + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

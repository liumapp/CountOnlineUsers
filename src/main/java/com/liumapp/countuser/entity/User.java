package com.liumapp.countuser.entity;

/**
 * Created by liumapp on 6/6/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class User {

    private String lastLoginTime;

    private String sessionId;

    private String ip;

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getIp() {
        return ip;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

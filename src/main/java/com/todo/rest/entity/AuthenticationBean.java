package com.todo.rest.entity;

public class AuthenticationBean {

    private String loginMessage;

    public AuthenticationBean(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    @Override
    public String toString() {
        return "AuthenticationBean{" +
                "loginMessage='" + loginMessage + '\'' +
                '}';
    }
}

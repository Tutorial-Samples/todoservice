package com.todo.rest.entity;

public class HelloWorldBean {
    private String helloMessage;

    public HelloWorldBean(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    public String getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "helloMessage='" + helloMessage + '\'' +
                '}';
    }
}

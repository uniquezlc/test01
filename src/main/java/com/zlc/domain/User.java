package com.zlc.domain;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 邹陆川
 * @Date: 2021/06/04/4:49 下午
 * @Description:
 */
public class User {
    private String id;
    private String name;
    private String content;
    private String state;
    private String phone;
    private String class_1;

    public String getClass_1() {
        return class_1;
    }

    public void setClass_1(String class_1) {
        this.class_1 = class_1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", state='" + state + '\'' +
                ", phone='" + phone + '\'' +
                ", class_1='" + class_1 + '\'' +
                '}';
    }
}

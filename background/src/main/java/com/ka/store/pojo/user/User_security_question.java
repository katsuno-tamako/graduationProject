package com.ka.store.pojo.user;

import org.springframework.stereotype.Component;

@Component
public class User_security_question {

    private int id;
    private String user_id;
    private String que_id;
    private String ans;
    private Security_question security_question;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getQue_id() {
        return que_id;
    }

    public void setQue_id(String que_id) {
        this.que_id = que_id;
    }

    public Security_question getSecurity_question() {
        return security_question;
    }

    public void setSecurity_question(Security_question security_question) {
        this.security_question = security_question;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }


    @Override
    public String toString() {
        return "User_security_question{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", que_id='" + que_id + '\'' +
                ", ans='" + ans + '\'' +
                ", security_question=" + security_question +
                '}';
    }
}

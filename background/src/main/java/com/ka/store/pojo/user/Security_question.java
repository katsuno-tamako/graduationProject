package com.ka.store.pojo.user;

import org.springframework.stereotype.Component;

@Component
public class Security_question {

    private int id;
    private String que_id;
    private String question;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQue_id() {
        return que_id;
    }

    public void setQue_id(String que_id) {
        this.que_id = que_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}

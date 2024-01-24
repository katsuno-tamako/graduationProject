package com.ka.store.pojo.comment;

import com.ka.store.pojo.user.User_info;
import org.springframework.stereotype.Component;

@Component
public class Comment {

    private int id;
    private String comment_id;
    private String commodity_id;
    private String user_id;
    private String user_name;
    private String comment_date;
    private String content;
    private String grade;
    private int likeNum;
    private User_info user_info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getComment_date() {
        return comment_date;
    }

    public void setComment_date(String comment_date) {
        this.comment_date = comment_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public User_info getUser_info() {
        return user_info;
    }

    public void setUser_info(User_info user_info) {
        this.user_info = user_info;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment_id='" + comment_id + '\'' +
                ", commodity_id='" + commodity_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", comment_date='" + comment_date + '\'' +
                ", content='" + content + '\'' +
                ", grade='" + grade + '\'' +
                ", likeNum=" + likeNum +
                ", user_info=" + user_info +
                '}';
    }
}

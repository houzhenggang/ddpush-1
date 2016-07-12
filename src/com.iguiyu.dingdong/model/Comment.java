//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import java.sql.Timestamp;

public class Comment {
    public static final int TYPE_MESSAGE = 0;
    public static final int TYPE_HOMEWORK = 1;
    public static final int TYPE_SCORE = 2;
    private int id;
    private int type;
    private int info_id;
    private int comment_id;
    private String reviewer_openid;
    private String reviewer_name;
    private String reviewer_headimgurl;
    private String author_openid;
    private String author_name;
    private String author_headimgurl;
    private String content;
    private Timestamp create_time;

    public Comment() {
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getInfo_id() {
        return this.info_id;
    }

    public void setInfo_id(int info_id) {
        this.info_id = info_id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getComment_id() {
        return this.comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getReviewer_openid() {
        return this.reviewer_openid;
    }

    public void setReviewer_openid(String reviewer_openid) {
        this.reviewer_openid = reviewer_openid;
    }

    public String getAuthor_openid() {
        return this.author_openid;
    }

    public void setAuthor_openid(String author_openid) {
        this.author_openid = author_openid;
    }

    public String getReviewer_name() {
        return this.reviewer_name;
    }

    public void setReviewer_name(String reviewer_name) {
        this.reviewer_name = reviewer_name;
    }

    public String getReviewer_headimgurl() {
        return this.reviewer_headimgurl;
    }

    public void setReviewer_headimgurl(String reviewer_headimgurl) {
        this.reviewer_headimgurl = reviewer_headimgurl;
    }

    public String getAuthor_name() {
        return this.author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_headimgurl() {
        return this.author_headimgurl;
    }

    public void setAuthor_headimgurl(String author_headimgurl) {
        this.author_headimgurl = author_headimgurl;
    }

    public Timestamp getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }
}

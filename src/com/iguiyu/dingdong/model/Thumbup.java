//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import java.sql.Timestamp;

public class Thumbup {
    public static final int TYPE_MESSAGE = 0;
    public static final int TYPE_HOMEWORK = 1;
    public static final int TYPE_SCORE = 2;
    private int id;
    private int type;
    private int info_id;
    private String reviewer_openid;
    private String reviewer_name;
    private String reviewer_headimgurl;
    private Timestamp create_time;

    public Thumbup() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReviewer_openid() {
        return this.reviewer_openid;
    }

    public void setReviewer_openid(String reviewer_openid) {
        this.reviewer_openid = reviewer_openid;
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

    public Timestamp getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }
}

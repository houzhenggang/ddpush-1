//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;


public class AttendanceRecord extends Base {
    String author_openid;
    String author_headimgurl;
    String content;
    int class_id;
    String remark;

    public AttendanceRecord() {
    }

    public String getAuthor_headimgurl() {
        return this.author_headimgurl;
    }

    public void setAuthor_headimgurl(String author_headimgurl) {
        this.author_headimgurl = author_headimgurl;
    }

    public String getAuthor_openid() {
        return this.author_openid;
    }

    public void setAuthor_openid(String author_openid) {
        this.author_openid = author_openid;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getClass_id() {
        return this.class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

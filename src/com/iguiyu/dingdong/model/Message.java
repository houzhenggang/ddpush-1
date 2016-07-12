//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import com.iguiyu.dingdong.model.Base;
import com.iguiyu.dingdong.model.Image;
import java.util.List;

public class Message extends Base {
    public static final int TYPE_CLASS = 0;
    public static final int TYPE_STUDENT = 1;
    private int rela_id;
    private String headimgurl;
    private String content;
    private int type;
    private String author_openid;
    private String author_name;
    private int thumbup_count;
    private int comment_count;
    private int homework_id;
    private int attendance_id;
    private int class_id;
    private int student_id;
    private int hasUp;
    private List<Image> images;

    public Message() {
    }

    public List<Image> getImages() {
        return this.images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getHeadimgurl() {
        return this.headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getAuthor_openid() {
        return this.author_openid;
    }

    public void setAuthor_openid(String author_openid) {
        this.author_openid = author_openid;
    }

    public String getAuthor_name() {
        return this.author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public int getHasUp() {
        return this.hasUp;
    }

    public void setHasUp(int hasUp) {
        this.hasUp = hasUp;
    }

    public int getRela_id() {
        return this.rela_id;
    }

    public void setRela_id(int rela_id) {
        this.rela_id = rela_id;
    }

    public int getHomework_id() {
        return this.homework_id;
    }

    public void setHomework_id(int homework_id) {
        this.homework_id = homework_id;
    }

    public int getAttendance_id() {
        return this.attendance_id;
    }

    public void setAttendance_id(int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public int getClass_id() {
        return this.class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getStudent_id() {
        return this.student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
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

    public int getThumbup_count() {
        return this.thumbup_count;
    }

    public void setThumbup_count(int thumbup_count) {
        this.thumbup_count = thumbup_count;
    }

    public int getComment_count() {
        return this.comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import com.iguiyu.dingdong.model.Image;
import java.sql.Timestamp;
import java.util.List;

public class HomeworkDetail {
    private int id;
    private String teacher_name;
    private String teacher_type;
    private String course;
    private String content;
    private int type;
    private Timestamp finish_time;
    private String teacher_openid;
    private Timestamp create_time;
    private String class_name;
    private int current_level;
    private String school_type;
    private int thumbup_count;
    private int comment_count;
    private int hasUp;
    private String headimgurl;
    private List<Image> images;

    public HomeworkDetail() {
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

    public int getHasUp() {
        return this.hasUp;
    }

    public void setHasUp(int hasUp) {
        this.hasUp = hasUp;
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

    public String getTeacher_type() {
        return this.teacher_type;
    }

    public void setTeacher_type(String teacher_type) {
        this.teacher_type = teacher_type;
    }

    public String getTeacher_name() {
        return this.teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return this.course;
    }

    public String getClass_name() {
        return this.class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getCurrent_level() {
        return this.current_level;
    }

    public void setCurrent_level(int current_level) {
        this.current_level = current_level;
    }

    public String getSchool_type() {
        return this.school_type;
    }

    public void setSchool_type(String school_type) {
        this.school_type = school_type;
    }

    public void setCourse(String course) {
        this.course = course;
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

    public Timestamp getFinish_time() {
        return this.finish_time;
    }

    public void setFinish_time(Timestamp finish_time) {
        this.finish_time = finish_time;
    }

    public String getTeacher_openid() {
        return this.teacher_openid;
    }

    public void setTeacher_openid(String teacher_openid) {
        this.teacher_openid = teacher_openid;
    }

    public Timestamp getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }
}

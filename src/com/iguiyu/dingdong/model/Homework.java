//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;
import java.util.List;

public class Homework extends Base {
    private String course;
    private String content;
    private int class_id;
    private String class_name;
    private int current_level;
    private String school_type;
    private String teacher_openid;
    private int hasUp;
    private List<Image> images;

    public Homework() {
    }

    public List<Image> getImages() {
        return this.images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public int getHasUp() {
        return this.hasUp;
    }

    public void setHasUp(int hasUp) {
        this.hasUp = hasUp;
    }

    public String getTeacher_openid() {
        return this.teacher_openid;
    }

    public void setTeacher_openid(String teacher_openid) {
        this.teacher_openid = teacher_openid;
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

    public int getClass_id() {
        return this.class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }
}

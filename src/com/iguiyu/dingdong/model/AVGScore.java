//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import java.sql.Timestamp;

public class AVGScore {
    private String exam_name;
    private int class_id;
    private String exam_code;
    private String course;
    private double score;
    private Timestamp start_time;

    public AVGScore() {
    }

    public String getExam_name() {
        return this.exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public String getExam_code() {
        return this.exam_code;
    }

    public void setExam_code(String exam_code) {
        this.exam_code = exam_code;
    }

    public int getClass_id() {
        return this.class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getScore() {
        return this.score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Timestamp getStart_time() {
        return this.start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }
}

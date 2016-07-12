//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import java.sql.Timestamp;

public class StudentScore {
    private int id;
    private int class_id;
    private String exam_code;
    private double score;
    private int student_id;
    private String student_no;
    private String student_name;
    private String student_headimgurl;
    private Timestamp start_time;

    public StudentScore() {
    }

    public String getStudent_headimgurl() {
        return this.student_headimgurl;
    }

    public void setStudent_headimgurl(String student_headimgurl) {
        this.student_headimgurl = student_headimgurl;
    }

    public String getStudent_name() {
        return this.student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_no() {
        return this.student_no;
    }

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    public int getStudent_id() {
        return this.student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import com.iguiyu.dingdong.model.Base;

public class PointsAction extends Base {
    String teacher_openid;
    int student_id;
    String parent_openid;
    String action;
    int order_id;
    int record_id;
    int score;

    public PointsAction() {
    }

    public int getRecord_id() {
        return this.record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTeacher_openid() {
        return this.teacher_openid;
    }

    public void setTeacher_openid(String teacher_openid) {
        this.teacher_openid = teacher_openid;
    }

    public int getStudent_id() {
        return this.student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getParent_openid() {
        return this.parent_openid;
    }

    public void setParent_openid(String parent_openid) {
        this.parent_openid = parent_openid;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}

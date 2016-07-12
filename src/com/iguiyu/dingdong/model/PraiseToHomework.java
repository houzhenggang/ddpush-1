//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import java.sql.Timestamp;

public class PraiseToHomework {
    private int id;
    private int homework_id;
    private int parent_openid;
    private int teacher_openid;
    private Timestamp create_time;

    public PraiseToHomework() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHomework_id() {
        return this.homework_id;
    }

    public void setHomework_id(int homework_id) {
        this.homework_id = homework_id;
    }

    public int getParent_openid() {
        return this.parent_openid;
    }

    public void setParent_openid(int parent_openid) {
        this.parent_openid = parent_openid;
    }

    public int getTeacher_openid() {
        return this.teacher_openid;
    }

    public void setTeacher_openid(int teacher_openid) {
        this.teacher_openid = teacher_openid;
    }

    public Timestamp getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }
}

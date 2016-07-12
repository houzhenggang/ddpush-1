//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import java.sql.Timestamp;

public class PraiseToMessage {
    private int id;
    private int message_id;
    private int parent_openid;
    private int teacher_openid;
    private Timestamp create_time;

    public PraiseToMessage() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMessage_id() {
        return this.message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
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

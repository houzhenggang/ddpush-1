//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import java.sql.Timestamp;

public class Base {
    private int id;
    private Timestamp finish_time;
    private Timestamp create_time;
    private Timestamp update_time;

    public Base() {
    }

    public Timestamp getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFinish_time() {
        return this.finish_time;
    }

    public void setFinish_time(Timestamp finish_time) {
        this.finish_time = finish_time;
    }

    public Timestamp getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }
}

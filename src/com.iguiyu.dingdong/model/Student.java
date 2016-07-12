//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import java.sql.Timestamp;
import java.util.Date;

public class Student {
    public static final int VIP_TYPE_NOT = 0;
    public static final int VIP_TYPE_COMMON = 1;
    public static final int VIP_TYPE_FAMILY = 2;
    private int id;
    private int class_id;
    private String student_no;
    private String name;
    private int vip_type;
    private Timestamp vip_time;
    private String headimgurl;

    public Student() {
    }

    public String getHeadimgurl() {
        return this.headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClass_id() {
        return this.class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getStudent_no() {
        return this.student_no;
    }

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVip_type() {
        return this.vip_type;
    }

    public void setVip_type(int vip_type) {
        this.vip_type = vip_type;
    }

    public Timestamp getVip_time() {
        return this.vip_time;
    }

    public void setVip_time(Timestamp vip_time) {
        this.vip_time = vip_time;
    }

    public boolean isVip() {
        return (this.vip_type == 1 || this.vip_type == 2) && (new Date()).getTime() < this.vip_time.getTime();
    }
}

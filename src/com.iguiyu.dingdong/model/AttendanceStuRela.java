//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import com.iguiyu.dingdong.model.Student;
import java.sql.Timestamp;

public class AttendanceStuRela extends Student {
    int type;
    int record_id;
    int student_id;
    String student_name;
    String student_no;
    String student_headimgurl;
    String remark;
    int class_id;
    private Timestamp finish_time;

    public AttendanceStuRela() {
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getFinish_time() {
        return this.finish_time;
    }

    public void setFinish_time(Timestamp finish_time) {
        this.finish_time = finish_time;
    }

    public int getClass_id() {
        return this.class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRecord_id() {
        return this.record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public String getStudent_headimgurl() {
        return this.student_headimgurl;
    }

    public void setStudent_headimgurl(String student_headimgurl) {
        this.student_headimgurl = student_headimgurl;
    }

    public String getStudent_no() {
        return this.student_no;
    }

    public void setStudent_no(String student_no) {
        this.student_no = student_no;
    }

    public String getStudent_name() {
        return this.student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public int getStudent_id() {
        return this.student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getTypeDesc() {
        String desc = "";
        switch(this.type) {
        case 0:
            desc = "正常";
            break;
        case 1:
            desc = "迟到";
            break;
        case 2:
            desc = "请假";
            break;
        case 3:
            desc = "旷课";
            break;
        default:
            desc = "正常";
        }

        return desc;
    }
}

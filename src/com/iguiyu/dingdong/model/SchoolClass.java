//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

public class SchoolClass {
    private int class_id;
    private String school_name;
    private String school_type;
    private String class_name;
    private int current_level;
    private String desc;
    public static final String[] GRADE = {"一年级","二年级","三年级","四年级","五年级","六年级","七年级","八年级","九年级"};

    public SchoolClass() {
    }

    public int getClass_id() {
        return this.class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getSchool_name() {
        return this.school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getSchool_type() {
        return this.school_type;
    }

    public void setSchool_type(String school_type) {
        this.school_type = school_type;
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

    public String getDesc() {
        if(current_level<1)
            return class_name;

        return (current_level>0?GRADE[current_level-1]:"")+class_name;
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import com.iguiyu.dingdong.model.Student;

public class StudentParentRela extends Student {
    public static final int ISMAIN = 1;
    private int parent_id;
    private String parent_openid;
    private int ismain;

    public StudentParentRela() {
    }

    public int getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getParent_openid() {
        return this.parent_openid;
    }

    public void setParent_openid(String parent_openid) {
        this.parent_openid = parent_openid;
    }

    public int getIsmain() {
        return this.ismain;
    }

    public void setIsmain(int ismain) {
        this.ismain = ismain;
    }
}

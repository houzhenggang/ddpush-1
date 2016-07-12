//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import com.iguiyu.dingdong.model.Base;

public class WXLogAccess extends Base {
    private String access_token;
    private int expire_time = 7000;
    private int type = 0;

    public WXLogAccess() {
    }

    public String getAccess_token() {
        return this.access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpire_time() {
        return this.expire_time;
    }

    public void setExpire_time(int expire_time) {
        this.expire_time = expire_time;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

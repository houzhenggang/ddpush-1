//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import com.iguiyu.dingdong.model.Base;

public class WXLogTicket extends Base {
    private String ticket;
    private int expire_time = 7000;
    private int type = 0;

    public WXLogTicket() {
    }

    public String getTicket() {
        return this.ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
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

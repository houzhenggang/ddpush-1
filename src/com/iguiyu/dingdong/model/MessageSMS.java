//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import com.iguiyu.dingdong.model.SMSBase;

public class MessageSMS extends SMSBase {
    private String name;
    private String content;

    public MessageSMS() {
        this.setSms_template_code("SMS_5725147");
        this.setSms_type("normal");
        this.setSmsFreeSignName("校园叮咚");
        this.setFormat("json");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

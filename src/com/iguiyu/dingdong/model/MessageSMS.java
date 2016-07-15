//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import com.iguiyu.dingdong.model.SMSBase;
import com.iguiyu.dingdong.sms.SmsUtil;

import java.util.HashMap;
import java.util.Map;

public class MessageSMS extends SMSBase {
    private String name;
    private String content;

    public MessageSMS() {
        this.setSms_template_code("SMS_5725147");
        this.setSms_type("normal");
        this.setSmsFreeSignName("校园叮咚");
        this.setFormat("json");
    }

    @Override
    public String getParams() {
        super.getParams();
        Map<String,String> m = new HashMap<String,String>();
        m.put("name",this.getName());
        m.put("content",this.getContent());
        return SmsUtil.generateParams(m);
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

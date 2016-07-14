//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import com.iguiyu.dingdong.sms.SmsInfo;

import java.sql.Timestamp;

public class SMSBase implements SmsInfo {
    int id;
    String extend;
    String sms_type;
    String rec_num;
    String sms_template_code;
    Timestamp create_time;
    String smsFreeSignName;
    String format;

    public SMSBase() {
    }

    @Override
    public String getParams() {
        return "";
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExtend() {
        return this.extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getSms_type() {
        return this.sms_type;
    }

    public void setSms_type(String sms_type) {
        this.sms_type = sms_type;
    }

    public String getRec_num() {
        return this.rec_num;
    }

    public void setRec_num(String rec_num) {
        this.rec_num = rec_num;
    }

    public String getSms_template_code() {
        return this.sms_template_code;
    }

    public void setSms_template_code(String sms_template_code) {
        this.sms_template_code = sms_template_code;
    }

    public Timestamp getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public String getSmsFreeSignName() {
        return this.smsFreeSignName;
    }

    public void setSmsFreeSignName(String smsFreeSignName) {
        this.smsFreeSignName = smsFreeSignName;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}

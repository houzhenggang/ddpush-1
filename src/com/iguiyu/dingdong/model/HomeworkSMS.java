//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;
import com.iguiyu.dingdong.sms.SMSConst;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeworkSMS extends SMSBase {
    private String name;
    private String homework;
    private String finishTime;
    @Autowired
    SMSConst smsConst;

    public HomeworkSMS() {
        this.setSms_template_code("SMS_5480161");
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

    public String getHomework() {
        return this.homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public String getFinishTime() {
        return this.finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }
}

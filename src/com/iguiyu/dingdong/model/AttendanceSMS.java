//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;


import com.iguiyu.dingdong.sms.SmsUtil;

import java.util.HashMap;
import java.util.Map;

public class AttendanceSMS extends SMSBase {
    private String name;
    private String attendance;
    private String finishTime;
    private String remark;

    public AttendanceSMS() {
        this.setSms_template_code("SMS_5490218");
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

    public String getAttendance() {
        return this.attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFinishTime() {
        return this.finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public String getParams() {
        super.getParams();
        Map<String,String> m = new HashMap<String,String>();
        m.put("name",this.getName());
        m.put("attendance",this.getAttendance());
        m.put("finishTime",this.getFinishTime());
        m.put("remark",this.getRemark());
        return SmsUtil.generateParams(m);
    }
}

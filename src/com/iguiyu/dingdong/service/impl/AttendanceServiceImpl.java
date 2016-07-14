//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.service.impl;

import com.iguiyu.dingdong.dao.AttendanceDao;
import com.iguiyu.dingdong.model.AttendanceSMS;
import com.iguiyu.dingdong.model.AttendanceStuRela;
import com.iguiyu.dingdong.model.PushInfo;
import com.iguiyu.dingdong.service.AttendanceService;
import com.iguiyu.dingdong.sms.SmsUtil;
import com.iguiyu.dingdong.util.DDWeixinUtil;
import com.iguiyu.dingdong.util.DateUtil;
import com.iguiyu.dingdong.weixin.TemplateData;
import com.iguiyu.dingdong.weixin.WxTemplate;
import com.taobao.api.ApiException;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceDao attendanceDao;
    @Autowired
    DDWeixinUtil ddWeixinUtil;

    public AttendanceServiceImpl() {
    }

    public void sendWXTemplate(PushInfo pushInfo) {
        HashMap params = new HashMap();
        params.put("record_id", Integer.valueOf(pushInfo.getOwnerId()));
        params.put("student_id", Integer.valueOf(pushInfo.getStudentId()));
        AttendanceStuRela rela = this.attendanceDao.getStuAttendance(params);
        this.ddWeixinUtil.sendTempMsg(this.getAttendanceTemplate(pushInfo, rela));
    }

    public void sendSms(PushInfo pushInfo) {
        HashMap params = new HashMap();
        params.put("record_id", Integer.valueOf(pushInfo.getOwnerId()));
        params.put("student_id", Integer.valueOf(pushInfo.getStudentId()));
        AttendanceStuRela rela = this.attendanceDao.getStuAttendance(params);
        AttendanceSMS attendanceSMS = new AttendanceSMS();
        attendanceSMS.setName(pushInfo.getStudentName());
        attendanceSMS.setAttendance(rela.getTypeDesc());
        attendanceSMS.setRemark(rela.getRemark());
        attendanceSMS.setRec_num(pushInfo.getTo());
        attendanceSMS.setFinishTime(DateUtil.dateFormat(rela.getFinish_time(), "yyyy-MM-dd"));

        try {
            SmsUtil.sendInfoSms(attendanceSMS);
        } catch (ApiException var6) {
            var6.printStackTrace();
        }

    }

    private WxTemplate getAttendanceTemplate(PushInfo pushInfo, AttendanceStuRela record) {
        WxTemplate template = new WxTemplate();
        template.setUrl(pushInfo.getUrl());
        template.setTemplate_id("49abyJbEVRXVKtnW4CcO9LNYuCFCbXsgWPK6sCZUFQM");
        template.setTopcolor("#04be02");
        template.setTouser(pushInfo.getTo());
        HashMap dataMap = new HashMap();
        TemplateData first = new TemplateData();
        first.setColor("#04be02");
        first.setValue("叮咚提醒您,有新的考勤通知啦!");
        dataMap.put("first", first);
        TemplateData keyword1 = new TemplateData();
        keyword1.setColor("#04be02");
        keyword1.setValue(record.getStudent_name());
        dataMap.put("keyword1", keyword1);
        TemplateData keyword2 = new TemplateData();
        keyword2.setColor("#04be02");
        keyword2.setValue(DateUtil.dateFormat(record.getFinish_time(), "yyyy年MM月dd日"));
        dataMap.put("keyword2", keyword2);
        TemplateData keyword3 = new TemplateData();
        keyword3.setColor("#04be02");
        keyword3.setValue("学校");
        dataMap.put("keyword3", keyword3);
        TemplateData remark = new TemplateData();
        remark.setColor("#1");
        remark.setValue(record.getRemark() + "\n点击进入校园叮咚");
        dataMap.put("remark", remark);
        template.setData(dataMap);
        return template;
    }
}

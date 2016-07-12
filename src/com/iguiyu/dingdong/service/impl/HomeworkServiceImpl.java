//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.service.impl;

import com.iguiyu.dingdong.dao.HomeworkDao;
import com.iguiyu.dingdong.model.Homework;
import com.iguiyu.dingdong.model.HomeworkSMS;
import com.iguiyu.dingdong.model.PushInfo;
import com.iguiyu.dingdong.service.HomeworkService;
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
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    HomeworkDao homeworkDao;
    @Autowired
    DDWeixinUtil ddWeixinUtil;

    public HomeworkServiceImpl() {
    }

    public void sendWXTemplate(PushInfo pushInfo) {
        Homework homework = this.homeworkDao.getHomeworkById(pushInfo.getOwnerId());
        this.ddWeixinUtil.sendTempMsg(this.getHomeworkTemplate(pushInfo, homework));
    }

    public void sendSms(PushInfo pushInfo) {
        Homework homework = this.homeworkDao.getHomeworkById(pushInfo.getOwnerId());
        HomeworkSMS homeworkSMS = new HomeworkSMS();
        homeworkSMS.setName(pushInfo.getStudentName());
        String content = homework.getContent();
        if(content == null || content.length() <= 0) {
            content = "进入叮咚查看详情";
        }

        homeworkSMS.setHomework(homework.getCourse() + " " + content);
        homeworkSMS.setFinishTime(DateUtil.dateFormat(homework.getFinish_time(), "yyyy-MM-dd"));
        homeworkSMS.setRec_num(pushInfo.getTo());

        try {
            SmsUtil.sendHomework(homeworkSMS);
        } catch (ApiException var6) {
            var6.printStackTrace();
        }

    }

    private WxTemplate getHomeworkTemplate(PushInfo pushInfo, Homework homework) {
        WxTemplate template = new WxTemplate();
        template.setUrl(pushInfo.getUrl());
        template.setTemplate_id("rV2rke4wnc9NaPV6qvZldJr-_hfaBXrNUgfjRbD1B0g");
        template.setTopcolor("#04be02");
        template.setTouser(pushInfo.getTo());
        HashMap dataMap = new HashMap();
        TemplateData first = new TemplateData();
        first.setColor("#04be02");
        first.setValue("叮咚提醒您,有新的作业发布啦!");
        dataMap.put("first", first);
        TemplateData name = new TemplateData();
        name.setColor("#04be02");
        name.setValue(pushInfo.getStudentName());
        dataMap.put("name", name);
        TemplateData subject = new TemplateData();
        subject.setColor("#04be02");
        subject.setValue(homework.getCourse());
        dataMap.put("subject", subject);
        TemplateData content = new TemplateData();
        content.setColor("#1");
        content.setValue("\n进入校园叮咚,查看作业详情");
        dataMap.put("content", content);
        template.setData(dataMap);
        return template;
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.service.impl;

import com.iguiyu.dingdong.dao.MessageDao;
import com.iguiyu.dingdong.model.Message;
import com.iguiyu.dingdong.model.MessageSMS;
import com.iguiyu.dingdong.model.PushInfo;
import com.iguiyu.dingdong.service.MessageService;
import com.iguiyu.dingdong.sms.SmsUtil;
import com.iguiyu.dingdong.util.DDWeixinUtil;
import com.iguiyu.dingdong.util.DateUtil;
import com.iguiyu.dingdong.weixin.TemplateData;
import com.iguiyu.dingdong.weixin.WxTemplate;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageDao messageDao;
    @Autowired
    DDWeixinUtil ddWeixinUtil;

    public MessageServiceImpl() {
    }

    public void sendWXTemplate(PushInfo pushInfo) {
        Message message = this.messageDao.getMessage(pushInfo.getOwnerId());
        this.ddWeixinUtil.sendTempMsg(this.getMessageTemplate(pushInfo, message));
    }

    public void sendSms(PushInfo pushInfo) {
        MessageSMS sms = new MessageSMS();
        sms.setName(pushInfo.getStudentName());
        switch (pushInfo.getOwnerType()){
            case PushInfo.OWNER_TYPE_APPRAISE:
                sms.setContent(pushInfo.getRemark());
                break;
            case PushInfo.OWNER_TYPE_SCHEDULE:
                sms.setContent(pushInfo.getRemark());
                break;
        }

    }

    private WxTemplate getMessageTemplate(PushInfo pushInfo, Message message) {
        WxTemplate template = new WxTemplate();
        template.setUrl(pushInfo.getUrl());
        template.setTemplate_id("8CPVWodmmeNVjJpswfQ4ueNF4eNso-MNZwH8XYa1vx8");
        template.setTopcolor("#04be02");
        template.setTouser(pushInfo.getTo());
        HashMap dataMap = new HashMap();
        TemplateData first = new TemplateData();
        first.setColor("#04be02");
        first.setValue("叮咚提醒您,有新的消息啦!");
        dataMap.put("first", first);
        TemplateData keyword1 = new TemplateData();
        keyword1.setColor("#04be02");
        keyword1.setValue(message.getAuthor_name());
        dataMap.put("keyword1", keyword1);
        TemplateData keyword2 = new TemplateData();
        keyword2.setColor("#04be02");
        keyword2.setValue(DateUtil.dateFormat(message.getCreate_time(), "yyyy年MM月dd HH:mm:ss"));
        dataMap.put("keyword2", keyword2);
        TemplateData keyword3 = new TemplateData();
        keyword3.setColor("#04be02");
        keyword3.setValue("\n进入校园叮咚查看消息内容");
        dataMap.put("keyword3", keyword3);
        TemplateData remark = new TemplateData();
        remark.setColor("#1");
        remark.setValue("\n点击进入校园叮咚");
        dataMap.put("remark", remark);
        template.setData(dataMap);
        return template;
    }
}

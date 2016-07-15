package com.iguiyu.dingdong.service.impl;

import com.iguiyu.dingdong.dao.StudentDao;
import com.iguiyu.dingdong.model.MessageSMS;
import com.iguiyu.dingdong.model.PushInfo;
import com.iguiyu.dingdong.model.Student;
import com.iguiyu.dingdong.service.InfoService;
import com.iguiyu.dingdong.util.DDWeixinUtil;
import com.iguiyu.dingdong.util.DateUtil;
import com.iguiyu.dingdong.weixin.TemplateData;
import com.iguiyu.dingdong.weixin.WxTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by XmacZone on 16/7/13.
 */
@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    DDWeixinUtil ddWeixinUtil;

    @Override
    public void sendWXTemplate(PushInfo info) {
        ddWeixinUtil.sendTempMsg(this.getInfoTemplate(info));
    }

    @Override
    public void sendSms(PushInfo info) {
        MessageSMS sms = new MessageSMS();
        sms.setName(info.getStudentName());
        switch (info.getOwnerType()){
            case PushInfo.OWNER_TYPE_APPRAISE:
                sms.setContent(info.getRemark());
                break;
            case PushInfo.OWNER_TYPE_SCHEDULE:
                sms.setContent(info.getRemark());
                break;
        }
    }

    private WxTemplate getInfoTemplate(PushInfo pushInfo) {
        WxTemplate template = new WxTemplate();
        template.setUrl(pushInfo.getUrl());
        template.setTemplate_id("2A47I3hNeeiFV2D7EWJxMLEeIjm25FHdSAy9DqmnhoM");
        template.setTopcolor("#04be02");
        template.setTouser(pushInfo.getTo());
        String firstStr = "";
        switch (pushInfo.getOwnerType()) {
            case PushInfo.OWNER_TYPE_APPRAISE:
                firstStr = pushInfo.getStudentName()+"获得了新的奖评!";
                break;
            case PushInfo.OWNER_TYPE_SCHEDULE:
                firstStr = pushInfo.getStudentName()+"所在班级的课表更新啦!";
                break;
            default:
                break;
        }
        HashMap dataMap = new HashMap();
        TemplateData first = new TemplateData();
        first.setColor("#04be02");
        first.setValue(firstStr);
        dataMap.put("first", first);

        TemplateData keyword1 = new TemplateData();
        keyword1.setValue(DateUtil.dateFormat(new Date().getTime()));
        dataMap.put("keyword1", keyword1);

         TemplateData keyword2 = new TemplateData();
        keyword1.setValue("详情请进入校园叮咚");
        dataMap.put("keyword2", keyword2);

        TemplateData remark = new TemplateData();
        remark.setValue(StringUtils.isEmpty(pushInfo.getRemark())?"校园叮咚, 关爱学生成长!":pushInfo.getRemark());
        dataMap.put("remark", remark);
        template.setData(dataMap);
        return  template;
    }

    public static void main(String[] args) {
        String a = new String();
        System.out.println(StringUtils.isEmpty(a));
        a="";
        System.out.println(StringUtils.isEmpty(a));
        a= "a";
        System.out.println(StringUtils.isEmpty(a));

    }
}

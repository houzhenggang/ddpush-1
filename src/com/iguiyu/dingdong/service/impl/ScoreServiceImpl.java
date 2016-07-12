//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.service.impl;

import com.iguiyu.dingdong.dao.ScoreDao;
import com.iguiyu.dingdong.model.PushInfo;
import com.iguiyu.dingdong.model.StudentScore;
import com.iguiyu.dingdong.service.ScoreService;
import com.iguiyu.dingdong.util.DDWeixinUtil;
import com.iguiyu.dingdong.weixin.TemplateData;
import com.iguiyu.dingdong.weixin.WxTemplate;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreDao scoreDao;
    @Autowired
    DDWeixinUtil ddWeixinUtil;

    public ScoreServiceImpl() {
    }

    public void sendWXTemplate(PushInfo pushInfo) {
        StudentScore studentScore = this.scoreDao.getById(pushInfo.getOwnerId());
        this.ddWeixinUtil.sendTempMsg(this.geScoreTemplate(pushInfo, studentScore));
    }

    public void sendSms(PushInfo pushInfo) {
    }

    private WxTemplate geScoreTemplate(PushInfo pushInfo, StudentScore studentScore) {
        WxTemplate template = new WxTemplate();
        template.setUrl(pushInfo.getUrl());
        template.setTemplate_id("Ru7cyocccXkaEKc9n1c5HjFKclITTe8Of6C-2IZSnGk");
        template.setTopcolor("#04be02");
        template.setTouser(pushInfo.getTo());
        HashMap dataMap = new HashMap();
        TemplateData first = new TemplateData();
        first.setColor("#04be02");
        first.setValue("叮咚提醒您,成绩出来啦!");
        dataMap.put("first", first);
        TemplateData childName = new TemplateData();
        childName.setColor("#04be02");
        childName.setValue(pushInfo.getStudentName());
        dataMap.put("childName", childName);
        TemplateData courseName = new TemplateData();
        courseName.setColor("#04be02");
        courseName.setValue(pushInfo.getRemark());
        dataMap.put("courseName", courseName);
        TemplateData score = new TemplateData();
        score.setColor("#04be02");
        score.setValue(studentScore.getScore() + "");
        dataMap.put("score", score);
        TemplateData remark = new TemplateData();
        remark.setColor("#1");
        remark.setValue("\n点击进入校园叮咚");
        dataMap.put("remark", remark);
        template.setData(dataMap);
        return template;
    }
}

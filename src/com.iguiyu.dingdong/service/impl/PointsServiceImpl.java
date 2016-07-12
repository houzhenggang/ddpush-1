//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.service.impl;

import com.iguiyu.dingdong.dao.PointsActionDao;
import com.iguiyu.dingdong.dao.TeacherDao;
import com.iguiyu.dingdong.model.PointsAction;
import com.iguiyu.dingdong.model.PushInfo;
import com.iguiyu.dingdong.service.PointsService;
import com.iguiyu.dingdong.util.DDWeixinUtil;
import com.iguiyu.dingdong.weixin.TemplateData;
import com.iguiyu.dingdong.weixin.WxTemplate;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointsServiceImpl implements PointsService {
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    PointsActionDao pointsActionDao;
    @Autowired
    DDWeixinUtil ddWeixinUtil;

    public PointsServiceImpl() {
    }

    public void sendWXTemplate(PushInfo pushInfo) {
        PointsAction pointsAction = this.pointsActionDao.getPointsAction(pushInfo.getOwnerId());
        this.ddWeixinUtil.sendTempMsg(this.getPointsTemplate(pushInfo, pointsAction));
    }

    public void sendSms(PushInfo pushInfo) {
    }

    private WxTemplate getPointsTemplate(PushInfo pushInfo, PointsAction pointsAction) {
        WxTemplate template = new WxTemplate();
        template.setUrl(pushInfo.getUrl());
        template.setTemplate_id("lX4EijYSe9DJB87SDxGYAQuqFGr_khGQDje0KPEGUrI");
        template.setTopcolor("#04be02");
        template.setTouser(pushInfo.getTo());
        HashMap dataMap = new HashMap();
        TemplateData first = new TemplateData();
        first.setColor("#04be02");
        first.setValue("叮咚提醒您,您的积分有变动!");
        dataMap.put("first", first);
        TemplateData keyword1 = new TemplateData();
        keyword1.setColor("#04be02");
        keyword1.setValue(pointsAction.getAction());
        dataMap.put("keyword1", keyword1);
        TemplateData keyword2 = new TemplateData();
        keyword2.setColor("#04be02");
        keyword2.setValue(pointsAction.getScore() + "");
        dataMap.put("keyword2", keyword2);
        TemplateData keyword3 = new TemplateData();
        keyword3.setColor("#04be02");
        keyword3.setValue(this.teacherDao.getTeacherByOpenId(pushInfo.getTo()).getPoints() + "");
        dataMap.put("keyword3", keyword3);
        TemplateData remark = new TemplateData();
        remark.setColor("#1");
        remark.setValue((pushInfo.getRemark() != null?pushInfo.getRemark():"") + "\n点击进入校园叮咚");
        dataMap.put("remark", remark);
        template.setData(dataMap);
        return template;
    }
}

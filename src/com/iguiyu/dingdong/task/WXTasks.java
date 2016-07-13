//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.task;

import com.iguiyu.dingdong.dao.ConstantDao;
import com.iguiyu.dingdong.dao.PushInfoDao;
import com.iguiyu.dingdong.model.PushInfo;
import com.iguiyu.dingdong.service.*;

import java.util.Iterator;
import java.util.List;

import com.iguiyu.dingdong.service.impl.InfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class WXTasks {
    @Autowired
    PushInfoDao pushInfoDao;
    @Autowired
    AttendanceService attendanceService;
    @Autowired
    MessageService messageService;
    @Autowired
    PointsService pointsService;
    @Autowired
    ScoreService scoreService;
    @Autowired
    InfoServiceImpl infoService;
    @Autowired
    HomeworkService homeworkService;
    @Autowired
    ConstantDao constantDao;

    public WXTasks() {
    }

    @Scheduled(
        fixedRate = 1000L
    )
    public void sendWXMessage() {
        System.out.println(">>>>>>>>>>>>>>>>> WXTask");
        List list = this.pushInfoDao.getWXTemplateInfos(Integer.parseInt(this.constantDao.getValueByKey("SEND_WX_TEMPLATE_LIMIT")));

        PushInfo item;
        for(Iterator i$ = list.iterator(); i$.hasNext(); this.pushInfoDao.setSended(item.getId())) {
            item = (PushInfo)i$.next();
            switch(item.getOwnerType()) {
            case PushInfo.OWNER_TYPE_MESSAGE:
                this.messageService.sendWXTemplate(item);
                break;
            case PushInfo.OWNER_TYPE_ATTENDANCE:
                this.attendanceService.sendWXTemplate(item);
                break;
            case PushInfo.OWNER_TYPE_HOMEWORK:
                this.homeworkService.sendWXTemplate(item);
                break;
            case PushInfo.OWNER_TYPE_POINTEVENT:
                this.pointsService.sendWXTemplate(item);
                break;
            case PushInfo.OWNER_TYPE_SCORE:
                this.scoreService.sendWXTemplate(item);
            case PushInfo.OWNER_TYPE_APPRAISE:
                this.infoService.sendWXTemplate(item);
            case PushInfo.OWNER_TYPE_SCHEDULE:
                this.infoService.sendWXTemplate(item);


            }
        }

    }
}

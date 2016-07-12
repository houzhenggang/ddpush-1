//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.task;

import com.iguiyu.dingdong.dao.ConstantDao;
import com.iguiyu.dingdong.dao.PushInfoDao;
import com.iguiyu.dingdong.model.PushInfo;
import com.iguiyu.dingdong.service.AttendanceService;
import com.iguiyu.dingdong.service.HomeworkService;
import com.iguiyu.dingdong.service.MessageService;
import com.iguiyu.dingdong.service.PointsService;
import com.iguiyu.dingdong.service.ScoreService;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
            case 0:
                this.messageService.sendWXTemplate(item);
                break;
            case 1:
                this.attendanceService.sendWXTemplate(item);
                break;
            case 2:
                this.homeworkService.sendWXTemplate(item);
                break;
            case 3:
                this.pointsService.sendWXTemplate(item);
                break;
            case 4:
                this.scoreService.sendWXTemplate(item);
            }
        }

    }
}

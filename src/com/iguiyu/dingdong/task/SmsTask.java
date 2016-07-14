//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.task;

import com.iguiyu.dingdong.dao.AttendanceDao;
import com.iguiyu.dingdong.dao.HomeworkDao;
import com.iguiyu.dingdong.dao.PushInfoDao;
import com.iguiyu.dingdong.model.PushInfo;
import com.iguiyu.dingdong.service.AttendanceService;
import com.iguiyu.dingdong.service.HomeworkService;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SmsTask {
    @Autowired
    PushInfoDao pushInfoDao;
    @Autowired
    AttendanceDao attendanceDao;
    @Autowired
    HomeworkDao homeworkDao;
    @Autowired
    AttendanceService attendanceService;
    @Autowired
    HomeworkService homeworkService;

    public SmsTask() {
    }

    @Scheduled(
        fixedRate = 1000L
    )
    public void sendSmsMessage() {
        System.out.println(">>>>>>>>>>> SmsTask");
        List list = this.pushInfoDao.getSmsInfos();

        PushInfo item;
        for(Iterator i$ = list.iterator(); i$.hasNext(); this.pushInfoDao.setSended(item.getId())) {
            item = (PushInfo)i$.next();
            switch(item.getOwnerType()) {
                case PushInfo.OWNER_TYPE_ATTENDANCE:
                    this.attendanceService.sendSms(item);
                    break;
                case PushInfo.OWNER_TYPE_HOMEWORK:
                    this.homeworkService.sendSms(item);
                    break;
            }
        }

    }
}

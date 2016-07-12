//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.service.impl;

import com.iguiyu.dingdong.dao.ConstantDao;
import com.iguiyu.dingdong.dao.WXDao;
import com.iguiyu.dingdong.model.WXLogAccess;
import com.iguiyu.dingdong.model.WXLogTicket;
import com.iguiyu.dingdong.service.impl.WXService;
import com.iguiyu.dingdong.util.WeixinUtil;
import com.iguiyu.dingdong.weixin.pojo.AccessToken;
import com.iguiyu.dingdong.weixin.pojo.WeiXinStatic;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WXServiceImpl implements WXService {
    @Autowired
    WXDao wxDao;
    @Autowired
    ConstantDao constantDao;

    public WXServiceImpl() {
    }

    public WXLogTicket getWXLogTicket() {
        List list = this.wxDao.getWXLogTicket();
        boolean isOk = true;
        WXLogTicket ticket = new WXLogTicket();
        if(list == null || list.size() <= 0) {
            isOk = false;
        }

        long limit = Long.parseLong(this.constantDao.getValueByKey("WX_EXPIRE_TIME"));
        if(isOk) {
            ticket = (WXLogTicket)list.get(0);
            Date util = new Date();
            if(ticket.getTicket() == null || util.getTime() - ticket.getCreate_time().getTime() >= limit) {
                isOk = false;
            }
        }

        if(!isOk) {
            WeixinUtil util1 = new WeixinUtil();
            String ticket_str = util1.getJSAPITicket(this.getWXLogAccess().getAccess_token());
            ticket.setTicket(ticket_str);
            ticket.setType(1);
            this.wxDao.insertWXLogTicket(ticket);
        }

        return ticket;
    }

    public int insertWXLogTicket(WXLogTicket logTicket) {
        return this.wxDao.insertWXLogTicket(logTicket);
    }

    public int insertWXLogAccess(WXLogAccess logAccess) {
        return this.wxDao.insertWXLogAccess(logAccess);
    }

    public WXLogAccess getWXLogAccess() {
        List list = this.wxDao.getWXLogAccess();
        boolean isOk = true;
        WXLogAccess access = new WXLogAccess();
        long limit = Long.parseLong(this.constantDao.getValueByKey("WX_EXPIRE_TIME"));
        if(list == null || list.size() <= 0) {
            isOk = false;
        }

        if(isOk) {
            access = (WXLogAccess)list.get(0);
            Date util = new Date();
            if(access.getAccess_token() == null || util.getTime() - access.getCreate_time().getTime() >= limit) {
                isOk = false;
            }
        }

        if(!isOk) {
            WeixinUtil util1 = new WeixinUtil();
            AccessToken accessToken = util1.getAccessToken(WeiXinStatic.appId, WeiXinStatic.appSecret);
            access = new WXLogAccess();
            access.setAccess_token(accessToken.getToken());
            access.setType(1);
            access.setExpire_time(accessToken.getExpiresIn());
            this.wxDao.insertWXLogAccess(access);
        }

        return access;
    }

    public AccessToken getAccessToken() {
        WXLogAccess access = this.getWXLogAccess();
        AccessToken accessToken = new AccessToken();
        accessToken.setExpiresIn(access.getExpire_time());
        accessToken.setToken(access.getAccess_token());
        return accessToken;
    }
}

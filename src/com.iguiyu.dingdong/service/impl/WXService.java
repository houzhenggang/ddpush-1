//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.service.impl;

import com.iguiyu.dingdong.model.WXLogAccess;
import com.iguiyu.dingdong.model.WXLogTicket;
import com.iguiyu.dingdong.weixin.pojo.AccessToken;

public interface WXService {
    int insertWXLogTicket(WXLogTicket var1);

    WXLogTicket getWXLogTicket();

    int insertWXLogAccess(WXLogAccess var1);

    WXLogAccess getWXLogAccess();

    AccessToken getAccessToken();
}

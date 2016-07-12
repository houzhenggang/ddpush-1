//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.service;

import com.iguiyu.dingdong.model.PushInfo;

public interface InfoService {
    void sendWXTemplate(PushInfo var1);

    void sendSms(PushInfo var1);
}

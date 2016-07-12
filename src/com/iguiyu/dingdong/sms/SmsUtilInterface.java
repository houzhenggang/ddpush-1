//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.sms;

import com.iguiyu.dingdong.model.VerifyCode;
import com.taobao.api.ApiException;

public interface SmsUtilInterface {
    void sendRegVerifyCode(VerifyCode var1) throws ApiException;
}

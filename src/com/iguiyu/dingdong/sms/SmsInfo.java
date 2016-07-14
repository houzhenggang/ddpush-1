package com.iguiyu.dingdong.sms;

/**
 * Created by XmacZone on 16/7/14.
 */
public interface SmsInfo {
    String getSmsFreeSignName();
    String getExtend();
    String getSms_type();
    String getRec_num();
    String getSms_template_code();
    String getParams();
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.sms;

import com.iguiyu.dingdong.model.AttendanceSMS;
import com.iguiyu.dingdong.model.HomeworkSMS;
import com.iguiyu.dingdong.model.MessageSMS;
import com.iguiyu.dingdong.model.VerifyCode;
import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class SmsUtil {
    public SmsUtil() {
    }

    public static AlibabaAliqinFcSmsNumSendResponse sendInfoSms(SmsInfo sms) throws ApiException {
        TaobaoClient client = TaoBaoClientSingle.getTaobaoClientInstance();
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        if(sms.getExtend() != null) {
            req.setExtend(sms.getExtend());
        } else {
            req.setExtend("");
        }

        req.setSmsType(sms.getSms_type());
        req.setSmsFreeSignName(sms.getSmsFreeSignName());
        req.setSmsParam(sms.getParams());
        req.setRecNum(sms.getRec_num());
        req.setSmsTemplateCode(sms.getSms_template_code());
        AlibabaAliqinFcSmsNumSendResponse response = (AlibabaAliqinFcSmsNumSendResponse)client.execute(req);
        System.out.println(response.getBody());
        return response;
    }

    public static void main(String[] args) {
        AttendanceSMS attendanceSMS = new AttendanceSMS();
        attendanceSMS.setName("胡国静");
        attendanceSMS.setRec_num("15150552538");
        attendanceSMS.setAttendance("你猜不猜得到我?");
        attendanceSMS.setRemark("本周考勤");
        attendanceSMS.setFinishTime("2015-03-09");

        try {
            sendInfoSms(attendanceSMS);
        } catch (ApiException var3) {
            var3.printStackTrace();
        }

    }
}

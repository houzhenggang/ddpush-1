//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.sms;

import com.iguiyu.dingdong.model.AttendanceSMS;
import com.iguiyu.dingdong.model.HomeworkSMS;
import com.iguiyu.dingdong.model.VerifyCode;
import com.taobao.api.ApiException;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class SmsUtil {
    public SmsUtil() {
    }

    public static AlibabaAliqinFcSmsNumSendResponse sendRegVerifyCode(VerifyCode verifyCode) throws ApiException {
        TaobaoClient client = TaoBaoClientSingle.getTaobaoClientInstance();
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        if(verifyCode.getExtend() != null) {
            req.setExtend(verifyCode.getExtend());
        } else {
            req.setExtend("");
        }

        req.setSmsType(verifyCode.getSms_type());
        req.setSmsFreeSignName(verifyCode.getSmsFreeSignName());
        req.setSmsParam("{\"code\":\"" + verifyCode.getCode() + "\",\"product\":\"" + verifyCode.getProduct() + "\"}");
        req.setRecNum(verifyCode.getRec_num());
        req.setSmsTemplateCode(verifyCode.getSms_template_code());
        System.out.println("send verify code" + verifyCode.getCode() + " to " + verifyCode.getRec_num());
        AlibabaAliqinFcSmsNumSendResponse response = (AlibabaAliqinFcSmsNumSendResponse)client.execute(req);
        System.out.println(response.getBody());
        return response;
    }

    public static AlibabaAliqinFcSmsNumSendResponse sendHomework(HomeworkSMS homeworkSMS) throws ApiException {
        TaobaoClient client = TaoBaoClientSingle.getTaobaoClientInstance();
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        if(homeworkSMS.getExtend() != null) {
            req.setExtend(homeworkSMS.getExtend());
        } else {
            req.setExtend("");
        }

        req.setSmsType(homeworkSMS.getSms_type());
        req.setSmsFreeSignName(homeworkSMS.getSmsFreeSignName());
        String param = "{\"name\":\"" + homeworkSMS.getName() + "\"," + "\"homework\":\"" + homeworkSMS.getHomework() + "\",\"finishTime\":\"" + homeworkSMS.getFinishTime() + "\"}";
        System.out.println(param);
        req.setSmsParam(param);
        req.setRecNum(homeworkSMS.getRec_num());
        req.setSmsTemplateCode(homeworkSMS.getSms_template_code());
        System.out.println("send homework " + homeworkSMS.getHomework() + " to " + homeworkSMS.getRec_num());
        AlibabaAliqinFcSmsNumSendResponse response = (AlibabaAliqinFcSmsNumSendResponse)client.execute(req);
        System.out.println(response.getBody());
        return response;
    }

    public static AlibabaAliqinFcSmsNumSendResponse sendAttendance(AttendanceSMS attendanceSMS) throws ApiException {
        TaobaoClient client = TaoBaoClientSingle.getTaobaoClientInstance();
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        if(attendanceSMS.getExtend() != null) {
            req.setExtend(attendanceSMS.getExtend());
        } else {
            req.setExtend("");
        }

        req.setSmsType(attendanceSMS.getSms_type());
        req.setSmsFreeSignName(attendanceSMS.getSmsFreeSignName());
        String param = "{\"name\":\"" + attendanceSMS.getName() + "\"," + "\"attendance\":\"" + attendanceSMS.getAttendance() + "\"," + "\"finishTime\":\"" + attendanceSMS.getFinishTime() + "\"," + "\"remark\":\"" + attendanceSMS.getRemark() + "\"}";
        System.out.println(param);
        req.setSmsParam(param);
        req.setRecNum(attendanceSMS.getRec_num());
        req.setSmsTemplateCode(attendanceSMS.getSms_template_code());
        System.out.println("send attendance " + attendanceSMS.getAttendance() + " to " + attendanceSMS.getRec_num());
        AlibabaAliqinFcSmsNumSendResponse response = (AlibabaAliqinFcSmsNumSendResponse)client.execute(req);
        System.out.println(response.getBody());
        return response;
    }

    public static void main(String[] args) {
        AttendanceSMS attendanceSMS = new AttendanceSMS();
        attendanceSMS.setName("胡国静");
        attendanceSMS.setRec_num("18862242553");
        attendanceSMS.setAttendance("你猜不猜得到我?");
        attendanceSMS.setRemark("本周考勤");
        attendanceSMS.setFinishTime("2015-03-09");

        try {
            sendAttendance(attendanceSMS);
        } catch (ApiException var3) {
            var3.printStackTrace();
        }

    }
}

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

import java.util.HashMap;
import java.util.Map;

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
        System.out.println("    >>>>>>  sms send "+sms.getParams()+"   "+sms.getRec_num());

        req.setSmsType(sms.getSms_type());
        req.setSmsFreeSignName(sms.getSmsFreeSignName());
        req.setSmsParam(sms.getParams());
        req.setRecNum(sms.getRec_num());
        req.setSmsTemplateCode(sms.getSms_template_code());
        AlibabaAliqinFcSmsNumSendResponse response = (AlibabaAliqinFcSmsNumSendResponse)client.execute(req);
        System.out.println("    >>>>>>  sms send "+response.getBody());
        return response;
    }

    public static String generateParams(Map<String,String> m){
        String re = "{";
        for (Map.Entry<String,String> t: m.entrySet()) {
            re+=("\""+t.getKey()+"\":\""+t.getValue()+"\",");
        }
        re = re.substring(0,re.length()-1);
        re+="}";

        return re;
    }
    public static void main(String[] args) {
//        AttendanceSMS attendanceSMS = new AttendanceSMS();
//        attendanceSMS.setName("胡国静");
//        attendanceSMS.setRec_num("15150552538");
//        attendanceSMS.setAttendance("你猜不猜得到我?");
//        attendanceSMS.setRemark("本周考勤");
//        attendanceSMS.setFinishTime("2015-03-09");
        MessageSMS sms = new MessageSMS();
        sms.setName("wangyi");
        sms.setContent("neirong");
//        sms.setFinishTime("yyyy-MM-dd");
        sms.setRec_num("15150552538");

        try {
            sendInfoSms(sms);
        } catch (ApiException var3) {
            var3.printStackTrace();
        }
//        Map<String,String> m = new HashMap<String,String>();
//        m.put("a","a1");
//        m.put("b","b1");
//        m.put("c","c1");
//        System.out.println(generateParams(m));
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import com.iguiyu.dingdong.model.SMSBase;
import com.iguiyu.dingdong.sms.SmsUtil;

import java.util.HashMap;
import java.util.Map;

public class VerifyCode extends SMSBase {
    private String code;
    private String product;

    public VerifyCode() {
        this.setSms_template_code("SMS_5355504");
        this.setSms_type("normal");
        this.setSmsFreeSignName("注册验证");
        this.setFormat("json");
    }

    @Override
    public String getParams() {
        super.getParams();
        Map<String,String> m = new HashMap<String,String>();
        m.put("code",this.getCode());
        m.put("product",this.getProduct());
        return SmsUtil.generateParams(m);
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

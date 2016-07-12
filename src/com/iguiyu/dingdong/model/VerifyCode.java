//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.model;

import com.iguiyu.dingdong.model.SMSBase;

public class VerifyCode extends SMSBase {
    private String code;
    private String product;

    public VerifyCode() {
        this.setSms_template_code("SMS_5355504");
        this.setSms_type("normal");
        this.setSmsFreeSignName("注册验证");
        this.setFormat("json");
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

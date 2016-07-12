//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.weixin;

import com.iguiyu.dingdong.weixin.TemplateData;
import java.util.Map;

public class WxTemplate {
    public static final String HOMEWORK_TEMPLATE_ID = "rV2rke4wnc9NaPV6qvZldJr-_hfaBXrNUgfjRbD1B0g";
    public static final String ATTENDANCE_TEMPLATE_ID = "49abyJbEVRXVKtnW4CcO9LNYuCFCbXsgWPK6sCZUFQM";
    public static final String MESSAGE_TEMPLATE_ID = "8CPVWodmmeNVjJpswfQ4ueNF4eNso-MNZwH8XYa1vx8";
    public static final String POINTS_TEMPLATE_ID = "lX4EijYSe9DJB87SDxGYAQuqFGr_khGQDje0KPEGUrI";
    public static final String SCORE_TEMPLATE_ID = "Ru7cyocccXkaEKc9n1c5HjFKclITTe8Of6C-2IZSnGk";
    private String template_id;
    private String touser;
    private String url;
    private String topcolor;
    private Map<String, TemplateData> data;

    public WxTemplate() {
    }

    public String getTemplate_id() {
        return this.template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getTouser() {
        return this.touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopcolor() {
        return this.topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public Map<String, TemplateData> getData() {
        return this.data;
    }

    public void setData(Map<String, TemplateData> data) {
        this.data = data;
    }
}

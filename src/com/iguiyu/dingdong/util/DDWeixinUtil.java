//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.util;

import com.iguiyu.dingdong.service.impl.WXService;
import com.iguiyu.dingdong.util.WeixinUtil;
import com.iguiyu.dingdong.weixin.WxTemplate;
import java.util.Iterator;
import java.util.List;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DDWeixinUtil extends WeixinUtil {
    @Autowired
    WXService wxService;

    public DDWeixinUtil() {
    }

    public int sendTempMsg(WxTemplate template) {
        JSONObject json = JSONObject.fromObject(template);
        String requestUrl = this.send_template_msg.replace("ACCESS_TOKEN", this.wxService.getWXLogAccess().getAccess_token());
        JSONObject jsonObject = this.httpRequest(requestUrl, "POST", json.toString());
        System.out.println(jsonObject.toString());
        int result = 1;
        if(null != jsonObject && 0 != jsonObject.getInt("errcode")) {
            result = jsonObject.getInt("errcode");
        }

        return result;
    }

    public int sendTempMsgs(List<WxTemplate> templates) {
        int result = 0;

        WxTemplate template;
        for(Iterator i$ = templates.iterator(); i$.hasNext(); result += this.sendTempMsg(template)) {
            template = (WxTemplate)i$.next();
        }

        return result;
    }
}

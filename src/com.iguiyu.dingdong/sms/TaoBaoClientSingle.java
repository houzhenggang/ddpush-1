//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.sms;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;

public class TaoBaoClientSingle {
    private static TaobaoClient client;

    private TaoBaoClientSingle(TaobaoClient client) {
        client = client;
    }

    public static TaobaoClient getTaobaoClientInstance() {
        if(client == null) {
            client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "23319793", "6c6522222a83ca42e59d65db9846af65");
        }

        return client;
    }

    public static TaobaoClient getVerifyCodeClientInstance() {
        if(client == null) {
            client = new DefaultTaobaoClient("taobao.open.sms.sendvercode", "23319793", "6c6522222a83ca42e59d65db9846af65");
        }

        return client;
    }
}

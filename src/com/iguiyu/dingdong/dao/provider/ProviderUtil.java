//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao.provider;

import java.util.Map;

public class ProviderUtil {
    public ProviderUtil() {
    }

    public static boolean isInMap(Map map, String key) {
        return map != null && map.get(key) != null?map.get(key).toString().length() > 0:false;
    }
}

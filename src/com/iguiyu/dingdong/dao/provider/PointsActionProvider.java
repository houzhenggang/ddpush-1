//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao.provider;

import com.iguiyu.dingdong.dao.provider.ProviderUtil;
import java.util.Map;

public class PointsActionProvider {
    public PointsActionProvider() {
    }

    public String getPointsActions(Map map) {
        StringBuilder sql = new StringBuilder("select * from point_action where teacher_openid =#{teacher_openid}");
        sql.append(" ORDER BY id");
        if(ProviderUtil.isInMap(map, "index") && ProviderUtil.isInMap(map, "count")) {
            sql.append(" limit #{index},#{count}");
        }

        return sql.toString();
    }
}

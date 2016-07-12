//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao.provider;

import com.iguiyu.dingdong.dao.provider.ProviderUtil;
import java.util.Map;

public class HomeworkProvider {
    public HomeworkProvider() {
    }

    public String searchHomeworks(Map map) {
        StringBuilder sql = new StringBuilder(" SELECT H.ID,S.CLASS_NAME,S.CURRENT_LEVEL,S.CLASS_ID,H.COURSE,H.CONTENT,H.FINISH_TIME  FROM HOMEWORK H,SCHOOL_CLASS_RELA S,TEACHER_CLASS_RELA TC WHERE H.CLASS_ID=TC.CLASS_ID AND S.CLASS_ID=TC.CLASS_ID AND TC.TEACHER_OPENID = #{teacher_openid}");
        if(ProviderUtil.isInMap(map, "start_time")) {
            sql.append(" AND H.FINISH_TIME>#{start_time}");
        }

        sql.append(" ORDER BY H.FINISH_TIME DESC");
        if(ProviderUtil.isInMap(map, "index")) {
            if(!ProviderUtil.isInMap(map, "count")) {
                map.put("count", Integer.valueOf(10));
            }

            sql.append(" LIMIT #{index},#{count}");
        }

        return sql.toString();
    }

    public String countHomeworks(Map map) {
        StringBuilder sql = new StringBuilder(" SELECT COUNT(H.ID)  FROM HOMEWORK H,SCHOOL_CLASS_RELA S,TEACHER_CLASS_RELA TC WHERE H.CLASS_ID=TC.CLASS_ID AND S.CLASS_ID=TC.CLASS_ID AND TC.TEACHER_OPENID = #{teacher_openid}");
        return sql.toString();
    }

    public String getHomeworkById(int homework_id) {
        StringBuilder sql = new StringBuilder(" SELECT H.ID,S.CLASS_NAME,S.CURRENT_LEVEL,S.CLASS_ID,H.COURSE,H.CONTENT,H.FINISH_TIME  FROM HOMEWORK H,SCHOOL_CLASS_RELA S WHERE H.CLASS_ID=S.CLASS_ID AND H.ID=#{homwork_id}");
        return sql.toString();
    }
}

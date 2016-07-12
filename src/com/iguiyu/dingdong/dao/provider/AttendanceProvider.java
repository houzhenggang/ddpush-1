//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao.provider;

import com.iguiyu.dingdong.dao.provider.ProviderUtil;
import java.util.Map;

public class AttendanceProvider {
    public AttendanceProvider() {
    }

    public String getAttendancesByTeacher(Map map) {
        StringBuilder sql = new StringBuilder(" select ar.*,t.name author_name,w.headimgurl author_headimgurl from `attendance_record` ar,teacher t,`wx_user` w where ar.`author_openid`= t.openid and t.openid = w.`OPENID` and ar.class_id in (select tr.class_id from teacher_class_rela tr where t.openid = #{teacher_openid})");
        if(ProviderUtil.isInMap(map, "start_time")) {
            sql.append(" AND AR.FINISH_TIME>=#{start_time}");
        }

        if(ProviderUtil.isInMap(map, "end_time")) {
            sql.append(" AND AR.FINISH_TIME<#{end_time}");
        }

        sql.append(" ORDER BY AR.FINISH_TIME DESC,AR.CLASS_ID ASC,AR.AUTHOR_OPENID ASC");
        return sql.toString();
    }
}

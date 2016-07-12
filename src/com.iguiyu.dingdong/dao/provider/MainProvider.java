//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao.provider;

import com.iguiyu.dingdong.dao.provider.ProviderUtil;
import java.util.Map;

public class MainProvider {
    public MainProvider() {
    }

    public String searchSchoolByParam(Map map) {
        StringBuilder sql = new StringBuilder(" SELECT distinct SCHOOL_NAME,SCHOOL_TYPE FROM SCHOOL_CLASS_RELA where 1=1");
        if(ProviderUtil.isInMap(map, "SCHOOL_TYPE")) {
            sql.append(" and SCHOOL_TYPE=#{SCHOOL_TYPE}");
        }

        if(ProviderUtil.isInMap(map, "SCHOOL_NAME")) {
            sql.append(" and SCHOOL_NAME = #{SCHOOL_NAME}");
        }

        sql.append(" ORDER BY SCHOOL_NAME");
        return sql.toString();
    }

    public String searchClassByParam(Map map) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT DISTINCT * FROM SCHOOL_CLASS_RELA WHERE 1=1 ");
        if(ProviderUtil.isInMap(map, "SCHOOL_TYPE")) {
            sql.append(" and SCHOOL_TYPE=#{SCHOOL_TYPE}");
            System.out.println("SCHOOL_TYPE=" + map.get("SCHOOL_TYPE"));
        }

        if(ProviderUtil.isInMap(map, "SCHOOL_NAME")) {
            sql.append(" and SCHOOL_NAME like concat(concat(\'%\',#{SCHOOL_NAME}),\'%\')");
            System.out.println("SCHOOL_NAME=" + map.get("SCHOOL_NAME"));
        }

        if(ProviderUtil.isInMap(map, "CURRENT_LEVEL")) {
            sql.append(" and CURRENT_LEVEL=#{CURRENT_LEVEL}");
            System.out.println("CURRENT_LEVEL=" + map.get("CURRENT_LEVEL"));
        }

        sql.append(" ORDER BY SCHOOL_NAME");
        System.out.println(sql.toString());
        return sql.toString();
    }

    public String example(Map map) {
        StringBuilder sql = new StringBuilder();
        return sql.toString();
    }
}

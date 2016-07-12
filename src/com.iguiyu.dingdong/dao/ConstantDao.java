//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface ConstantDao {
    @Select({"SELECT _VALUE FROM T_CONST WHERE _KEY=#{key} "})
    String getValueByKey(String var1);
}

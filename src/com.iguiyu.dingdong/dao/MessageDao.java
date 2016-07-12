//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao;

import com.iguiyu.dingdong.model.Message;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface MessageDao {
    @Select({" SELECT M.* FROM MESSAGE M WHERE M.id = #{id}"})
    Message getMessage(int var1);
}

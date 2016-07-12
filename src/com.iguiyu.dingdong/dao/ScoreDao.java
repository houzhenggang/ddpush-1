//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao;

import com.iguiyu.dingdong.model.StudentScore;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface ScoreDao {
    @Select({" select * from score where id = #{id}"})
    StudentScore getById(int var1);
}

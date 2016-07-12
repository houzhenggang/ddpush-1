//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao;

import com.iguiyu.dingdong.model.PointsAction;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface PointsActionDao {
    @Select({"select * from point_action where id=#{id}"})
    PointsAction getPointsAction(int var1);
}

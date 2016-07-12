//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao;

import com.iguiyu.dingdong.model.Teacher;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface TeacherDao {
    @Select({"SELECT T.ID TEACHER_ID,T.NAME,T.points,T.MOBILE,W.* FROM TEACHER T,WX_USER W WHERE W.OPENID = T.OPENID AND T.OPENID=#{OPENID}"})
    Teacher getTeacherByOpenId(String var1);
}

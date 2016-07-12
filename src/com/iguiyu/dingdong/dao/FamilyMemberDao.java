//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao;

import com.iguiyu.dingdong.model.FamilyMember;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Component;

@Component
public interface FamilyMemberDao {
    @Insert({" INSERT INTO `family_member` (`STUDENT_ID`, `NAME`, `SEX`, `HEADIMGURL`, `MOBILE`, `create_time`)\n VALUES (#{student_id},#{name},#{sex},#{headimgurl},#{mobile},now()) "})
    @SelectKey(
            before = false,
            keyProperty = "id",
            resultType = int.class,
            statement = {"SELECT LAST_INSERT_ID() "}
    )
    int insertMember(FamilyMember var1);

    @Select({" SELECT * FROM `family_member` WHERE STUDENT_ID = #{student_id}"})
    List<FamilyMember> getMemberByStudentId(int var1);

    @Select({" SELECT * FROM `family_member` WHERE ID = #{id}"})
    FamilyMember getMemberById(int var1);
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao;

import com.iguiyu.dingdong.dao.provider.MainProvider;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

@Component
public interface MainDao {
    @Select({"SELECT * FROM TEACHER where ID=#{ID}"})
    List<Map> searchTeacherById(String var1);

    @Select({"SELECT distinct SCHOOL_NAME,SCHOOL_TYPE FROM SCHOOL_CLASS_RELA where SCHOOL_TYPE=#{SCHOOL_TYPE}"})
    List<Map> searchSchoolByType(String var1);

    @SelectProvider(
            type = MainProvider.class,
            method = "searchSchoolByParam"
    )
    List<Map> searchSchoolByParam(Map var1);

    @SelectProvider(
            type = MainProvider.class,
            method = "searchClassByParam"
    )
    List<Map> searchClassByParam(Map var1);

    @Delete({"DELETE FROM TEACHER WHERE ID = #{TEACHER_ID}"})
    void delTeacher(int var1);

    @Insert({"INSERT INTO WX_USER(OPENID,NICKNAME,SEX,CITY,COUNTRY,PROVINCE,HEADIMGURL) VALUES(#{OPENID},#{NICKNAME},#{SEX},#{CITY},#{COUNTRY},#{PROVINCE},#{HEADIMGURL});"})
    void addWeiXinUser(Map var1);

    List<Map> test();

    @Select({"SELECT * FROM SCHOOL_CLASS_RELA"})
    List<Map> searchSchoolClass();

    @Select({"SELECT * FROM STUDENT WHERE CLASS_ID = #{CLASS_ID}"})
    List<Map> searchStudentList(int var1);

    @Delete({"DELETE FROM SCHOOL_CLASS_RELA WHERE CLASS_ID = #{CLASS_ID}"})
    void delSchoolClass(int var1);

    @Insert({"INSERT INTO STUDENT(CLASS_ID,STUDENT_NO,NAME) VALUES(#{CLASS_ID},#{STUDENT_NO},#{NAME})"})
    void addStudent(Map var1);

    void delStudent(int var1, String var2);

    @Select({"SELECT * FROM SCHOOL_CLASS_RELA"})
    List<Map> classStudentManager();

    @Insert({"INSERT INTO SCHOOL_CLASS_RELA(SCHOOL_NAME,CLASS_NAME,CURRENT_LEVEL) VALUES(#{SCHOOL_NAME},#{CLASS_NAME},#{CURRENT_LEVEL})"})
    void addClass(Map var1);

    List<Map> perfomanceManager();

    List<Map> searchPerfomanceList(Map var1);

    void delPerfomance(Map var1);

    void addPerfomance(Map var1);
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao;

import com.iguiyu.dingdong.model.Student;
import com.iguiyu.dingdong.model.StudentParentRela;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface StudentDao {
    @Select({"SELECT * FROM STUDENT WHERE STUDENT_NO = #{student_no}"})
    List<Student> getStudentsByNo(String var1);

    @Select({" SELECT S.*,P.ID PARENT_ID,P.PARENT_OPENID,P.ISMAIN FROM SCHOOL_CLASS_RELA SC,STUDENT S,PARENT_STUDENT_RELA P WHERE 1=1 AND S.CLASS_ID = SC.CLASS_ID AND P.STUDENT_ID = S.ID AND SC.CLASS_ID = #{class_id} "})
    List<StudentParentRela> getStudentParentRelaByClass(int var1);

    @Select({" SELECT S.*,P.ID PARENT_ID,P.PARENT_OPENID,P.ISMAIN  FROM MESSAGE_STUDENT_RELA M,STUDENT S,PARENT_STUDENT_RELA P WHERE 1=1 AND S.ID = M.STUDENT_ID AND P.STUDENT_ID = S.ID AND M.MESSAGE_ID = #{message_id} "})
    List<StudentParentRela> getStudentParentRelaByMessage(int var1);

    @Select({" SELECT S.*,P.ID PARENT_ID,P.PARENT_OPENID,P.ISMAIN FROM STUDENT S,PARENT_STUDENT_RELA P  WHERE 1=1  AND P.STUDENT_ID = S.ID AND S.ID=#{student_id}"})
    List<StudentParentRela> getStudentParentRelaByStudentId(int var1);

    @Select({"SELECT * FROM STUDENT WHERE CLASS_ID = #{class_id} ORDER BY STUDENT_NO"})
    List<Student> getStudentsByClassId(int var1);

    @Select({" SELECT S.* FROM STUDENT S,MESSAGE_STUDENT_RELA M  WHERE M.STUDENT_ID = S.ID  AND M.MESSAGE_ID=#{message_id} ORDER BY S.STUDENT_NO"})
    List<Student> getStudentsByMessageId(int var1);

    @Select({" SELECT * FROM STUDENT WHERE CLASS_ID IN (SELECT CLASS_ID FROM TEACHER_CLASS_RELA WHERE TEACHER_OPENID =#{open_id}"})
    List<Student> getStudentsByTeacherOpenId(String var1);
}

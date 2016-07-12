//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao;

import com.iguiyu.dingdong.model.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Component;

@Component
public interface MessageStudentRelaDao {
    @Insert({"INSERT INTO MESSAGE_STUDENT_RELA(MESSAGE_ID,STUDENT_ID,CLASS_ID,CREATE_TIME) VALUES(#{id},#{student_id},#{class_id},NOW())"})
    @SelectKey(
            before = false,
            keyProperty = "rela_id",
            resultType = int.class,
            statement = {"SELECT LAST_INSERT_ID() "}
    )
    int insertToMsgStuRela(Message var1);
}

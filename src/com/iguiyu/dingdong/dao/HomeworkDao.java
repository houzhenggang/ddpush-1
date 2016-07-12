//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao;

import com.iguiyu.dingdong.dao.provider.HomeworkProvider;
import com.iguiyu.dingdong.model.Homework;
import com.iguiyu.dingdong.model.HomeworkDetail;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
public interface HomeworkDao {
    @Select({" SELECT H.ID,H.COURSE,H.CONTENT,H.TYPE,H.FINISH_TIME, H.THUMBUP_COUNT,H.COMMENT_COUNT,H.CREATE_TIME,H.TEACHER_OPENID, T.NAME TEACHER_NAME,TC.TEACHER_TYPE,S.CLASS_NAME,S.CURRENT_LEVEL, T.HEADIMGURL FROM HOMEWORK H,SCHOOL_CLASS_RELA S,TEACHER T,TEACHER_CLASS_RELA TC WHERE H.CLASS_ID=TC.CLASS_ID  AND S.CLASS_ID=TC.CLASS_ID AND TC.TEACHER_OPENID = T.OPENID AND H.TEACHER_OPENID=T.OPENID AND H.ID=#{homework_id}"})
    List<HomeworkDetail> searchHomework(int var1);

    @SelectProvider(
            type = HomeworkProvider.class,
            method = "searchHomeworks"
    )
    List<Homework> searchHomeworks(Map var1);

    @SelectProvider(
            type = HomeworkProvider.class,
            method = "countHomeworks"
    )
    int countHomeworks(Map var1);

    @Select({" SELECT H.ID,S.CLASS_NAME,S.CURRENT_LEVEL,S.CLASS_ID,H.COURSE,H.CONTENT,H.FINISH_TIME  FROM HOMEWORK H,SCHOOL_CLASS_RELA S WHERE H.CLASS_ID=S.CLASS_ID AND H.ID=#{id}"})
    Homework getHomeworkById(int var1);

    @Insert({" INSERT INTO HOMEWORK(CONTENT,COURSE,TEACHER_OPENID,FINISH_TIME,CLASS_ID,CREATE_TIME) VALUES(#{content},#{course},#{teacher_openid},#{finish_time},#{class_id},NOW())"})
    @Options(
            useGeneratedKeys = true,
            keyProperty = "id"
    )
    int insertHomework(Homework var1);

    @Update({" update homework set comment_count = comment_count+1 where id=#{homework_id}"})
    int homeworkAddCommentCount(int var1);

    @Update({" update homework set thumbup_count = thumbup_count+1 where id=#{homework_id}"})
    int homeworkAddThumbUpCount(int var1);

    @Update({" update homework set comment_count = comment_count-1 where id=#{homework_id}"})
    int homeworkCancelCommentCount(int var1);

    @Update({" update homework set thumbup_count = thumbup_count-1 where id=#{homework_id}"})
    int homeworkCancelThumbUpCount(int var1);
}

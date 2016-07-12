//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao;

import com.iguiyu.dingdong.model.AttendanceStuRela;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface AttendanceDao {
    @Select({" select sr.*,asr.type\n from (select s.id student_id,s.name student_name,s.student_no,s.vip_type,s.vip_time,s.headimgurl student_headimgurl,r.class_id,r.id record_id,. r.remark remark\n from student s, attendance_record r\n where r.id = #{record_id}\n and s.class_id=r.class_id\n ) sr left join attendance_stu_rela asr\n on sr.record_id = asr.record_id and sr.student_id = asr.student_id\n order by sr.student_no"})
    List<AttendanceStuRela> getAttendanceByRecordId(int var1);

    @Select({" select sr.*,asr.type\n             from (select s.id student_id,s.name student_name,s.student_no,s.vip_type,s.vip_time,s.headimgurl student_headimgurl,             r.class_id,r.id record_id, r.remark remark, r.finish_time\n             from student s, attendance_record r\n             where r.id = #{record_id}\n             and s.class_id=r.class_id \n             and s.id = #{student_id}\n             ) sr left join attendance_stu_rela asr\n             on sr.record_id = asr.record_id\n              and sr.student_id = asr.student_id"})
    AttendanceStuRela getStuAttendance(Map<String, Integer> var1);
}

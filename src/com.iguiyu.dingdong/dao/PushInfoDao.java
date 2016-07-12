//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao;

import com.iguiyu.dingdong.model.PushInfo;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
public interface PushInfoDao {
    @Insert({" INSERT INTO `push_info` ( `ownerid`, `ownertype`,`infotype`, `title`, `from`, `to`, `fromdesc`, `todesc`,`studentid`, `studentname`, `url`,`templateid`,`remark`,`send_at`, `sendstatus`, `status`, `priority`, `create_at`)\n VALUES\n ( #{ownerId}, #{ownerType}, #{infoType},#{title},#{from}, #{to}, #{fromDesc}, #{toDesc}, #{studentId},#{studentName}, #{url},#{templateId},#{remark}, #{send_at}, #{sendStatus}, #{status},#{priority},#{create_at})"})
    @SelectKey(
            before = false,
            keyProperty = "id",
            resultType = int.class,
            statement = {"SELECT LAST_INSERT_ID() "}
    )
    int create(PushInfo var1);

    @Select({" select * from push_info where infotype=1 and sendstatus=0 order by create_at"})
    List<PushInfo> getSmsInfos();

    @Select({" select * from push_info where infotype=0 and sendstatus=0 order by create_at limit #{limit}"})
    List<PushInfo> getWXTemplateInfos(int var1);

    @Update({" update push_info set `sendstatus` = 1 where id = #{id}"})
    int setSended(int var1);
}

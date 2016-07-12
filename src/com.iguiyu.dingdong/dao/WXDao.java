//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao;

import com.iguiyu.dingdong.model.WXLogAccess;
import com.iguiyu.dingdong.model.WXLogTicket;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface WXDao {
    @Insert({" INSERT INTO `t_wx_log_access` (`access_token`, `expire_time`, `create_time`, `update_time`, `type`)\n VALUES(#{access_token},#{expire_time},now(),now(),#{type})"})
    @Options(
            useGeneratedKeys = true,
            keyProperty = "id"
    )
    int insertWXLogAccess(WXLogAccess var1);

    @Select({" select * from t_wx_log_access order by id desc"})
    List<WXLogAccess> getWXLogAccess();

    @Insert({" INSERT INTO `t_wx_log_ticket` (`ticket`, `expire_time`, `create_time`, `update_time`, `type`)\n VALUES(#{ticket},#{expire_time},now(),now(),#{type})"})
    @Options(
            useGeneratedKeys = true,
            keyProperty = "id"
    )
    int insertWXLogTicket(WXLogTicket var1);

    @Select({" select * from t_wx_log_ticket order by id desc"})
    List<WXLogTicket> getWXLogTicket();
}

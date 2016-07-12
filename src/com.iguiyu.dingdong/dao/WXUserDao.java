//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao;

import com.iguiyu.dingdong.model.WXUser;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
public interface WXUserDao {
    @Insert({" INSERT INTO `wx_user` (`OPENID`, `NICKNAME`, `SEX`, `CITY`, `COUNTRY`, `PROVINCE`, `HEADIMGURL`, `UNIONID`) VALUES(#{openid},#{nickName},#{sex},#{city},#{country},#{province},#{headimgurl},#{unionid})"})
    @Options(
            useGeneratedKeys = true,
            keyProperty = "id"
    )
    int addWXUser(WXUser var1);

    @Select({" SELECT * FROM WX_USER WHERE OPENID=#{openid}"})
    List<WXUser> getWXUser(String var1);

    @Select({" SELECT * FROM WX_USER "})
    List<WXUser> getWXUsers();

    @Update({" UPDATE WX_USER SET UNIONID=#{unionid} WHERE OPENID= #{openid} "})
    int updateUnionId(Map var1);
}

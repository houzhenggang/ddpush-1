//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao;

import com.iguiyu.dingdong.model.VerifyCode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface SMSDao {
    @Insert({"INSERT INTO `verify` (`extend`, `code`, `product`, `create_time`, `sms_type`, `rec_num`, `sms_template_code`, `sms_free_sign_name`, `format`)\nVALUES (#{extend},#{code},#{product},now(),#{sms_type},#{rec_num},#{sms_template_code},#{smsFreeSignName},#{format})"})
    @Options(
            useGeneratedKeys = true,
            keyProperty = "id"
    )
    void insertVerifyCode(VerifyCode var1);

    @Select({"SELECT V.CODE,V.CREATE_TIME FROM `verify` V WHERE V.ID=#{id} "})
    VerifyCode getVerifyCodeById(int var1);
}

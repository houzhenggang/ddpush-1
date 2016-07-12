//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.dao;

import com.iguiyu.dingdong.model.WithdrawPassword;
import com.iguiyu.dingdong.model.WithdrawRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
public interface WithdrawDao {
    @Insert({" INSERT INTO `withdraw_record` (`openid`, `partner_trade_no`, `nonce_str`, `sign`, `amount`, `desc`, `spbill_create_ip`, `create_time`, `update_time`, `status`)\n VALUES\n ( #{openid}, #{partner_trade_no}, #{nonce_str}, #{sign}, #{amount}, #{desc}, #{spbill_create_ip}, now(),  now(), #{status})\n"})
    @Options(
            useGeneratedKeys = true,
            keyProperty = "id"
    )
    int insertWithdrawRecord(WithdrawRecord var1);

    @Update({" update `withdraw_record` set STATUS = #{status} where id = #{id}"})
    int updateWithdrawoRecord(WithdrawPassword var1);
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.wx.demo;

import com.iguiyu.dingdong.util.WeixinUtil;
import com.iguiyu.dingdong.weixin.pojo.WeiXinStatic;
import com.iguiyu.dingdong.wx.demo.WxPayDto;
import com.iguiyu.dingdong.wx.utils.GetWxOrderno;
import com.iguiyu.dingdong.wx.utils.RequestHandler;
import com.iguiyu.dingdong.wx.utils.Sha1Util;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo {
    private static String appid;
    private static String appsecret;
    private static String partner;
    private static String partnerkey;
    private static String openId;
    private static String notifyurl;

    public Demo() {
    }

    public static void main(String[] args) {
        WxPayDto tpWxPay = new WxPayDto();
        tpWxPay.setOpenId(openId);
        tpWxPay.setBody("商品信息");
        tpWxPay.setOrderId(WeixinUtil.getNonceStr());
        tpWxPay.setSpbillCreateIp("127.0.0.1");
        tpWxPay.setTotalFee("0.01");
        getPackage(tpWxPay);
        WxPayDto tpWxPay1 = new WxPayDto();
        tpWxPay1.setBody("商品信息");
        tpWxPay1.setOrderId(WeixinUtil.getNonceStr());
        tpWxPay1.setSpbillCreateIp("127.0.0.1");
        tpWxPay1.setTotalFee("0.01");
        getCodeurl(tpWxPay1);
    }

    public static String getCodeurl(WxPayDto tpWxPayDto) {
        String orderId = tpWxPayDto.getOrderId();
        String attach = "";
        String totalFee = getMoney(tpWxPayDto.getTotalFee());
        String spbill_create_ip = tpWxPayDto.getSpbillCreateIp();
        String notify_url = notifyurl;
        String trade_type = "NATIVE";
        String mch_id = partner;
        String nonce_str = WeixinUtil.getNonceStr();
        String body = tpWxPayDto.getBody();
        TreeMap packageParams = new TreeMap();
        packageParams.put("appid", appid);
        packageParams.put("mch_id", mch_id);
        packageParams.put("nonce_str", nonce_str);
        packageParams.put("body", body);
        packageParams.put("attach", attach);
        packageParams.put("out_trade_no", orderId);
        packageParams.put("total_fee", totalFee);
        packageParams.put("spbill_create_ip", spbill_create_ip);
        packageParams.put("notify_url", notify_url);
        packageParams.put("trade_type", trade_type);
        RequestHandler reqHandler = new RequestHandler((HttpServletRequest)null, (HttpServletResponse)null);
        reqHandler.init(appid, appsecret, partnerkey);
        String sign = reqHandler.createSign(packageParams);
        String xml = "<xml><appid>" + appid + "</appid>" + "<mch_id>" + mch_id + "</mch_id>" + "<nonce_str>" + nonce_str + "</nonce_str>" + "<sign>" + sign + "</sign>" + "<body><![CDATA[" + body + "]]></body>" + "<out_trade_no>" + orderId + "</out_trade_no>" + "<attach>" + attach + "</attach>" + "<total_fee>" + totalFee + "</total_fee>" + "<spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>" + "<notify_url>" + notify_url + "</notify_url>" + "<trade_type>" + trade_type + "</trade_type>" + "</xml>";
        String code_url = "";
        String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        new GetWxOrderno();
        code_url = GetWxOrderno.getCodeUrl(createOrderURL, xml);
        System.out.println("code_url----------------" + code_url);
        return code_url;
    }

    public static SortedMap getPackage(WxPayDto tpWxPayDto) {
        String openId = tpWxPayDto.getOpenId();
        System.out.println(">>>>>>>>>openid = " + openId);
        String orderId = tpWxPayDto.getOrderId();
        String attach = "";
        String totalFee = getMoney(tpWxPayDto.getTotalFee());
        String spbill_create_ip = tpWxPayDto.getSpbillCreateIp();
        String notify_url = notifyurl;
        String trade_type = "JSAPI";
        String mch_id = partner;
        String nonce_str = WeixinUtil.getNonceStr();
        String body = tpWxPayDto.getBody();
        TreeMap packageParams = new TreeMap();
        packageParams.put("appid", appid);
        packageParams.put("mch_id", mch_id);
        packageParams.put("nonce_str", nonce_str);
        packageParams.put("body", body);
        packageParams.put("attach", attach);
        packageParams.put("out_trade_no", orderId);
        packageParams.put("total_fee", totalFee);
        packageParams.put("spbill_create_ip", spbill_create_ip);
        packageParams.put("notify_url", notify_url);
        packageParams.put("trade_type", trade_type);
        packageParams.put("openid", openId);
        RequestHandler reqHandler = new RequestHandler((HttpServletRequest)null, (HttpServletResponse)null);
        reqHandler.init(appid, appsecret, partnerkey);
        String sign = reqHandler.createSign(packageParams);
        String xml = "<xml><appid>" + appid + "</appid>" + "<mch_id>" + mch_id + "</mch_id>" + "<nonce_str>" + nonce_str + "</nonce_str>" + "<sign>" + sign + "</sign>" + "<body><![CDATA[" + body + "]]></body>" + "<out_trade_no>" + orderId + "</out_trade_no>" + "<attach>" + attach + "</attach>" + "<total_fee>" + totalFee + "</total_fee>" + "<spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>" + "<notify_url>" + notify_url + "</notify_url>" + "<trade_type>" + trade_type + "</trade_type>" + "<openid>" + openId + "</openid>" + "</xml>";
        String prepay_id = "";
        String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        System.out.println(xml);
        new GetWxOrderno();
        prepay_id = GetWxOrderno.getPayNo(createOrderURL, xml);
        System.out.println("获取到的预支付ID：" + prepay_id);
        TreeMap finalpackage = new TreeMap();
        String timestamp = Sha1Util.getTimeStamp();
        String packages = "prepay_id=" + prepay_id;
        finalpackage.put("appId", appid);
        finalpackage.put("timeStamp", timestamp);
        finalpackage.put("nonceStr", nonce_str);
        finalpackage.put("package", packages);
        finalpackage.put("signType", "MD5");
        String finalsign = reqHandler.createSign(finalpackage);
        finalpackage.put("paySign", finalsign);
        String finaPackage = "\"appId\":\"" + appid + "\",\"timeStamp\":\"" + timestamp + "\",\"nonceStr\":\"" + nonce_str + "\",\"package\":\"" + packages + "\",\"signType\" : \"MD5" + "\",\"paySign\":\"" + finalsign + "\"";
        System.out.println("V3 jsApi package:" + finaPackage);
        return finalpackage;
    }

    public static String getMoney(String amount) {
        if(amount == null) {
            return "";
        } else {
            String currency = amount.replaceAll("\\$|\\￥|\\,", "");
            int index = currency.indexOf(".");
            int length = currency.length();
            Long amLong = Long.valueOf(0L);
            if(index == -1) {
                amLong = Long.valueOf(currency + "00");
            } else if(length - index >= 3) {
                amLong = Long.valueOf(currency.substring(0, index + 3).replace(".", ""));
            } else if(length - index == 2) {
                amLong = Long.valueOf(currency.substring(0, index + 2).replace(".", "") + 0);
            } else {
                amLong = Long.valueOf(currency.substring(0, index + 1).replace(".", "") + "00");
            }

            return amLong.toString();
        }
    }

    static {
        appid = WeiXinStatic.appId;
        appsecret = WeiXinStatic.appSecret;
        partner = "1277859001";
        partnerkey = "709fseab8181b492ef9bc8c71b14511a";
        openId = "o0JmUxKifQV7lLFzK6XaOTAf9hiY";
        notifyurl = "http://192.168.199.199:8080/parent/index.html";
    }
}

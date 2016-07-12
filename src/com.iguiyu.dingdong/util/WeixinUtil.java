//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.util;

import com.iguiyu.dingdong.util.MyX509TrustManager;
import com.iguiyu.dingdong.util.UserInfo;
import com.iguiyu.dingdong.weixin.pojo.AccessToken;
import com.iguiyu.dingdong.weixin.pojo.Menu;
import com.iguiyu.dingdong.wx.utils.Sha1Util;
import com.iguiyu.dingdong.wx.utils.TenpayUtil;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class WeixinUtil {
    public String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    public String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    public String get_openid_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";
    public String get_userinfo_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    public String get_userinfo_url2 = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    public String send_template_msg = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
    public String deliver_notify_url = "https://api.weixin.qq.com/pay/delivernotify?access_token=ACCESS_TOKEN";
    public String get_jsapi_ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
    public static String upload_img_url = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
    public static HashMap tokenMap = new HashMap();
    public String jsapi_ticket = "";

    public WeixinUtil() {
    }

    public static String getUploadImgUrl(String access_token, String media_id) {
        return upload_img_url.replace("ACCESS_TOKEN", access_token).replace("MEDIA_ID", media_id);
    }

    public AccessToken getAccessToken(String appid, String appsecret) {
        AccessToken accessToken = null;
        Date d = new Date();
        String requestUrl = this.access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
        JSONObject jsonObject = this.httpRequest(requestUrl, "GET", (String)null);
        if(null != jsonObject) {
            try {
                accessToken = new AccessToken();
                accessToken.setToken(jsonObject.getString("access_token"));
                accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
            } catch (JSONException var8) {
                accessToken = null;
                var8.printStackTrace();
            }

            tokenMap.put("accessToken", accessToken);
            tokenMap.put("date", d);
        }

        return accessToken;
    }

    public JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();

        try {
            TrustManager[] e = new TrustManager[]{new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init((KeyManager[])null, e, new SecureRandom());
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection)url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestMethod(requestMethod);
            if("GET".equalsIgnoreCase(requestMethod)) {
                httpUrlConn.connect();
            }

            OutputStream inputStream;
            if(null != outputStr) {
                inputStream = httpUrlConn.getOutputStream();
                inputStream.write(outputStr.getBytes("UTF-8"));
                inputStream.close();
            }

            InputStream inputStream1 = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream1, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;

            while((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream1.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException var15) {
            ;
        } catch (Exception var16) {
            ;
        }

        return jsonObject;
    }

    public int createMenu(Menu menu, String accessToken) {
        int result = 0;
        String url = this.menu_create_url.replace("ACCESS_TOKEN", accessToken);
        String jsonMenu = JSONObject.fromObject(menu).toString();
        WeixinUtil util = new WeixinUtil();
        JSONObject jsonObject = util.httpRequest(url, "POST", jsonMenu);
        if(null != jsonObject && 0 != jsonObject.getInt("errcode")) {
            result = jsonObject.getInt("errcode");
        }

        return result;
    }

    public String getOpenId(String appid, String appsecret, String code) {
        try {
            String e = "";
            String requestUrl = this.get_openid_url.replace("APPID", appid).replace("APPSECRET", appsecret).replace("CODE", code);
            JSONObject jsonObject = this.httpRequest(requestUrl, "GET", (String)null);
            System.out.println(jsonObject);
            if(null != jsonObject) {
                e = jsonObject.getString("openid");
            }

            return e;
        } catch (Exception var7) {
            var7.printStackTrace();
            return "";
        }
    }

    public UserInfo getUserInfo(String access_token, String openid) {
        try {
            UserInfo e = new UserInfo();
            String requestUrl = this.get_userinfo_url.replace("ACCESS_TOKEN", access_token).replace("OPENID", openid);
            JSONObject jsonObject = this.httpRequest(requestUrl, "GET", (String)null);
            System.out.println(jsonObject);
            if(null != jsonObject) {
                e.setSubscribe(jsonObject.getString("subscribe"));
                e.setOpenid(jsonObject.getString("openid"));
                if(!e.getSubscribe().equals("1")) {
                    return null;
                }

                e.setNickname(jsonObject.getString("nickname"));
                e.setSex(jsonObject.getString("sex"));
                e.setLanguage(jsonObject.getString("language"));
                e.setCity(jsonObject.getString("city"));
                e.setProvince(jsonObject.getString("province"));
                e.setCountry(jsonObject.getString("country"));
                e.setHeadimgurl(jsonObject.getString("headimgurl"));
                e.setSubscribe_time(jsonObject.getString("subscribe_time"));
                e.setUnionid(jsonObject.getString("unionid"));
            }

            return e;
        } catch (Exception var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public UserInfo getUserInfo2(String appid, String appsecret, String code) {
        try {
            UserInfo e = new UserInfo();
            String openId = "";
            String accessToken = "";
            String requestUrl = this.get_openid_url.replace("APPID", appid).replace("APPSECRET", appsecret).replace("CODE", code);
            JSONObject jsonObject = this.httpRequest(requestUrl, "GET", (String)null);
            if(null != jsonObject) {
                openId = jsonObject.getString("openid");
                accessToken = jsonObject.getString("access_token");
            }

            requestUrl = this.get_userinfo_url2.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
            jsonObject = this.httpRequest(requestUrl, "GET", (String)null);
            if(null != jsonObject) {
                e.setOpenid(jsonObject.getString("openid"));
                e.setNickname(jsonObject.getString("nickname"));
                e.setSex(jsonObject.getString("sex"));
                e.setLanguage(jsonObject.getString("language"));
                e.setCity(jsonObject.getString("city"));
                e.setProvince(jsonObject.getString("province"));
                e.setCountry(jsonObject.getString("country"));
                e.setHeadimgurl(jsonObject.getString("headimgurl"));
            }

            return e;
        } catch (Exception var9) {
            var9.printStackTrace();
            return null;
        }
    }

    public String getJSAPITicket(String token) {
        if(this.jsapi_ticket == null || this.jsapi_ticket.length() <= 0) {
            String requestUrl = this.get_jsapi_ticket_url.replace("ACCESS_TOKEN", token);
            JSONObject jsonObject = this.httpRequest(requestUrl, "GET", (String)null);
            System.out.println(jsonObject);
            this.jsapi_ticket = jsonObject.getString("ticket");
        }

        return this.jsapi_ticket;
    }

    public String getSha1Sign(String timeStamp, String noncestr, String ticket, String create_sign_url) {
        String re = "";
        TreeMap map = new TreeMap();
        map.put("noncestr", noncestr);
        map.put("jsapi_ticket", ticket);
        map.put("timestamp", timeStamp);
        map.put("url", create_sign_url);

        try {
            return Sha1Util.createSHA1Sign(map);
        } catch (Exception var8) {
            var8.printStackTrace();
            return null;
        }
    }

    public String getSha1Sign(SortedMap map) {
        try {
            return Sha1Util.createSHA1Sign(map);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static String getNonceStr() {
        String currTime = TenpayUtil.getCurrTime();
        String strTime = currTime.substring(8, currTime.length());
        String strRandom = TenpayUtil.buildRandom(4) + "";
        return strTime + strRandom;
    }

    public static Map doXMLParse(String strxml) throws Exception {
        if(null != strxml && !"".equals(strxml)) {
            HashMap m = new HashMap();
            InputStream in = String2Inputstream(strxml);
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(in);
            Element root = doc.getRootElement();
            List list = root.getChildren();

            String k;
            String v;
            for(Iterator it = list.iterator(); it.hasNext(); m.put(k, v)) {
                Element e = (Element)it.next();
                k = e.getName();
                v = "";
                List children = e.getChildren();
                if(children.isEmpty()) {
                    v = e.getTextNormalize();
                } else {
                    v = getChildrenText(children);
                }
            }

            in.close();
            return m;
        } else {
            return null;
        }
    }

    public static InputStream String2Inputstream(String str) {
        return new ByteArrayInputStream(str.getBytes());
    }

    public static String getChildrenText(List children) {
        StringBuffer sb = new StringBuffer();
        if(!children.isEmpty()) {
            Iterator it = children.iterator();

            while(it.hasNext()) {
                Element e = (Element)it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List list = e.getChildren();
                sb.append("<" + name + ">");
                if(!list.isEmpty()) {
                    sb.append(getChildrenText(list));
                }

                sb.append(value);
                sb.append("</" + name + ">");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        WeixinUtil util1 = new WeixinUtil();
        System.out.println(util1.get_userinfo_url.replace("ACCESS_TOKEN", "112121"));
        System.out.println(util1.get_userinfo_url);
    }
}

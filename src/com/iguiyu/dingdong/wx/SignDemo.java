//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.wx;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Map.Entry;

public class SignDemo {
    public SignDemo() {
    }

    public static void main(String[] args) {
        TreeMap sortedMap = new TreeMap();
        sortedMap.put("jsapi_ticket", "kgt8ON7yVITDhtdwci0qeR4xrE1ThGlCOTMpJAkQVtK78_8qXAXSNalejasApaPXFx9NSLhinx1L9a090e8vNg");
        sortedMap.put("timestamp", "1459308509");
        sortedMap.put("nonceStr", "1128297683");
        sortedMap.put("url", "http://www.xiaoyuandingdong.com/dingdong/teacher/demo.html");
        String jsapi_ticket = "kgt8ON7yVITDhtdwci0qeR4xrE1ThGlCOTMpJAkQVtK78_8qXAXSNalejasApaPXFx9NSLhinx1L9a090e8vNg";
        String url = "http://www.xiaoyuandingdong.com/dingdong/teacher/demo.html";
        Map ret = sign(jsapi_ticket, url);
        Iterator i$ = ret.entrySet().iterator();

        while(i$.hasNext()) {
            Entry entry = (Entry)i$.next();
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

    }

    public static Map<String, String> sign(String jsapi_ticket, String url) {
        HashMap ret = new HashMap();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String signature = "";
        (new StringBuilder()).append("jsapi_ticket=").append(jsapi_ticket).append("&noncestr=").append(nonce_str).append("&timestamp=").append(timestamp).append("&url=").append(url).toString();
        String string1 = "jsapi_ticket=kgt8ON7yVITDhtdwci0qeR4xrE1ThGlCOTMpJAkQVtK78_8qXAXSNalejasApaPXFx9NSLhinx1L9a090e8vNg&noncestr=228894d2-c191-4e30-b6e9-310b60551b2f&timestamp=1459324266&url=http://www.xiaoyuandingdong.com/dingdong/teacher/demo.html";
        System.out.println(string1);

        try {
            MessageDigest e = MessageDigest.getInstance("SHA-1");
            e.reset();
            e.update(string1.getBytes());
            signature = byteToHex(e.digest());
        } catch (NoSuchAlgorithmException var8) {
            var8.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        return ret;
    }

    private static String byteToHex(byte[] hash) {
        Formatter formatter = new Formatter();
        byte[] result = hash;
        int len$ = hash.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            byte b = result[i$];
            formatter.format("%02x", new Object[]{Byte.valueOf(b)});
        }

        String var6 = formatter.toString();
        formatter.close();
        return var6;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000L);
    }
}

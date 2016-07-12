//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.wx.utils;

import com.iguiyu.dingdong.wx.utils.MD5Util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Map.Entry;

public class Sha1Util {
    public Sha1Util() {
    }

    public static String getNonceStr() {
        Random random = new Random();
        return MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)), "UTF-8");
    }

    public static String getTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000L);
    }

    public static String sha1(SortedMap<String, String> signParams) {
        StringBuffer sb = new StringBuffer();
        Set es = signParams.entrySet();
        Iterator it = es.iterator();

        String signature;
        while(it.hasNext()) {
            Entry string1 = (Entry)it.next();
            signature = (String)string1.getKey();
            String e = (String)string1.getValue();
            sb.append(signature + "=" + e + "&");
        }

        String string11 = sb.substring(0, sb.lastIndexOf("&"));
        System.out.println("before sha1 " + string11);
        signature = "";

        try {
            MessageDigest e1 = MessageDigest.getInstance("SHA-1");
            e1.reset();
            e1.update(string11.getBytes());
            signature = byteToHex(e1.digest());
        } catch (NoSuchAlgorithmException var7) {
            var7.printStackTrace();
        }

        System.out.println("after sha1 " + signature);
        return signature;
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

    public static String createSHA1Sign(SortedMap<String, String> signParams) throws Exception {
        StringBuffer sb = new StringBuffer();
        Set es = signParams.entrySet();
        Iterator it = es.iterator();

        while(it.hasNext()) {
            Entry params = (Entry)it.next();
            String k = (String)params.getKey();
            String v = (String)params.getValue();
            sb.append(k + "=" + v + "&");
        }

        String params1 = sb.substring(0, sb.lastIndexOf("&"));
        params1 = "jsapi_ticket=kgt8ON7yVITDhtdwci0qeR4xrE1ThGlCOTMpJAkQVtK78_8qXAXSNalejasApaPXFx9NSLhinx1L9a090e8vNg&noncestr=1128297683&timestamp=1459308509&url=http://www.xiaoyuandingdong.com/dingdong/teacher/demo.html";
        System.out.println("sha1之前:" + params1);
        System.out.println("SHA1签名为：" + getSha1(params1));
        return getSha1(params1);
    }

    public static String getSha1(String str) {
        if(str != null && str.length() != 0) {
            char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

            try {
                MessageDigest e = MessageDigest.getInstance("SHA1");
                e.update(str.getBytes());
                byte[] md = e.digest(str.getBytes());
                int j = md.length;
                char[] buf = new char[j * 2];
                int k = 0;

                for(int i = 0; i < j; ++i) {
                    byte byte0 = md[i];
                    buf[k++] = hexDigits[byte0 >>> 4 & 15];
                    buf[k++] = hexDigits[byte0 & 15];
                }

                return new String(buf);
            } catch (Exception var9) {
                return null;
            }
        } else {
            return null;
        }
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000L);
    }

    public static void main(String[] args) {
        TreeMap sortedMap = new TreeMap();
        sortedMap.put("jsapi_ticket", "kgt8ON7yVITDhtdwci0qeR4xrE1ThGlCOTMpJAkQVtK78_8qXAXSNalejasApaPXFx9NSLhinx1L9a090e8vNg");
        sortedMap.put("timestamp", "1459308509");
        sortedMap.put("noncestr", "1128297683");
        sortedMap.put("url", "http://www.xiaoyuandingdong.com/dingdong/teacher/demo.html");

        try {
            sha1(sortedMap);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }
}

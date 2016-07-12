//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.wx.utils;

import com.iguiyu.dingdong.wx.utils.http.HttpClientConnectionManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class GetWxOrderno {
    public static DefaultHttpClient httpclient = new DefaultHttpClient();

    public GetWxOrderno() {
    }

    public static String getPayNo(String url, String xmlParam) {
        DefaultHttpClient client = new DefaultHttpClient();
        client.getParams().setParameter("http.protocol.allow-circular-redirects", Boolean.valueOf(true));
        HttpPost httpost = HttpClientConnectionManager.getPostMethod(url);
        String prepay_id = "";

        try {
            httpost.setEntity(new StringEntity(xmlParam, "UTF-8"));
            CloseableHttpResponse e = httpclient.execute(httpost);
            String jsonStr = EntityUtils.toString(e.getEntity(), "UTF-8");
            if(jsonStr.indexOf("FAIL") != -1) {
                return prepay_id;
            }

            Map map = doXMLParse(jsonStr);
            prepay_id = (String)map.get("prepay_id");
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        return prepay_id;
    }

    public static String getCodeUrl(String url, String xmlParam) {
        DefaultHttpClient client = new DefaultHttpClient();
        client.getParams().setParameter("http.protocol.allow-circular-redirects", Boolean.valueOf(true));
        HttpPost httpost = HttpClientConnectionManager.getPostMethod(url);
        String code_url = "";

        try {
            httpost.setEntity(new StringEntity(xmlParam, "UTF-8"));
            CloseableHttpResponse e = httpclient.execute(httpost);
            String jsonStr = EntityUtils.toString(e.getEntity(), "UTF-8");
            if(jsonStr.indexOf("FAIL") != -1) {
                return code_url;
            }

            Map map = doXMLParse(jsonStr);
            code_url = (String)map.get("code_url");
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        return code_url;
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

    public static InputStream String2Inputstream(String str) {
        return new ByteArrayInputStream(str.getBytes());
    }

    static {
        httpclient = (DefaultHttpClient)HttpClientConnectionManager.getSSLInstance(httpclient);
    }
}

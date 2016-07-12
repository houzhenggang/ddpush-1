//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.wx.utils.http;

import com.iguiyu.dingdong.wx.utils.http.HttpResponse;
import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;

public class HttpConnect {
    private static HttpConnect httpConnect = new HttpConnect();
    MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();

    public HttpConnect() {
    }

    public static HttpConnect getInstance() {
        return httpConnect;
    }

    public HttpResponse doGetStr(String url) {
        String CONTENT_CHARSET = "GBK";
        long time1 = System.currentTimeMillis();
        HttpClient client = new HttpClient(this.connectionManager);
        client.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
        client.getHttpConnectionManager().getParams().setSoTimeout('훘');
        client.getParams().setParameter("http.protocol.content-charset", CONTENT_CHARSET);
        GetMethod method = new GetMethod(url);
        HttpResponse response = new HttpResponse();

        Object var9;
        try {
            client.executeMethod(method);
            System.out.println("调接口返回的时间:" + (System.currentTimeMillis() - time1));
            response.setStringResult(method.getResponseBodyAsString());
            return response;
        } catch (HttpException var14) {
            method.releaseConnection();
            var9 = null;
        } catch (IOException var15) {
            method.releaseConnection();
            var9 = null;
            return (HttpResponse)var9;
        } finally {
            method.releaseConnection();
        }

        return (HttpResponse)var9;
    }
}

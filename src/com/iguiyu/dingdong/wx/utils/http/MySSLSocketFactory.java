//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.wx.utils.http;

import com.iguiyu.dingdong.wx.utils.http.TrustAnyTrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class MySSLSocketFactory extends SSLSocketFactory {
    private static MySSLSocketFactory mySSLSocketFactory = new MySSLSocketFactory(createSContext());

    private static SSLContext createSContext() {
        SSLContext sslcontext = null;

        try {
            sslcontext = SSLContext.getInstance("SSL");
        } catch (NoSuchAlgorithmException var3) {
            var3.printStackTrace();
        }

        try {
            sslcontext.init((KeyManager[])null, new TrustManager[]{new TrustAnyTrustManager()}, (SecureRandom)null);
            return sslcontext;
        } catch (KeyManagementException var2) {
            var2.printStackTrace();
            return null;
        }
    }

    private MySSLSocketFactory(SSLContext sslContext) {
        super(sslContext);
        this.setHostnameVerifier(ALLOW_ALL_HOSTNAME_VERIFIER);
    }

    public static MySSLSocketFactory getInstance() {
        return mySSLSocketFactory != null?mySSLSocketFactory:(mySSLSocketFactory = new MySSLSocketFactory(createSContext()));
    }

    static {
        mySSLSocketFactory = null;
    }
}

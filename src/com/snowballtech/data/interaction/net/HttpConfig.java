package com.snowballtech.data.interaction.net;

import com.snowballtech.common.util.ValueUtil;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.OkHttpClient;
import okio.Buffer;

public class HttpConfig {
    private String cert = "-----BEGIN CERTIFICATE-----\nMIIDUzCCAjugAwIBAgIEWkk+jDANBgkqhkiG9w0BAQsFADBaMQswCQYDVQQGEwJjbjELMAkGA1UE\nCBMCc2gxCzAJBgNVBAcTAnNoMREwDwYDVQQKEwhzbm93YmFsbDERMA8GA1UECxMIc25vd2JhbGwx\nCzAJBgNVBAMTAndzMB4XDTE2MDEyODA4MTk1NVoXDTI2MDEyNTA4MTk1NVowWjELMAkGA1UEBhMC\nY24xCzAJBgNVBAgTAnNoMQswCQYDVQQHEwJzaDERMA8GA1UEChMIc25vd2JhbGwxETAPBgNVBAsT\nCHNub3diYWxsMQswCQYDVQQDEwJ3czCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAMbC\nlUwrBrkpEa3UNOusPk18lIYSJsOJm7FEZoa2pAT+n5FmDWZoz4R6uIW9yr0gGtLvBLecdNWbscK2\new8+0dVnlsAa9b7ryWdW5oaP+v585lKZ8mZxRNZZ/LXm0vzUl+k0unCOS5jXWfKFbKDVVksmkwml\n8WK+eqQfIM9Mr2Up35bxWpJ7SKFuPICGXC07iadhrgAjWxDqkFwi+LAEsB3PjYjBqkQjAatWcCeb\nPGRWnMDEIZIvZxndfKbS7nS5ybGFaRhqBzh6+VhK72/uxIDh899SCLO0MCH1zIlqRmORWo6uruIY\nzx0nDpQLTNwFF+33xYKycsBduBVdllQ7ZTsCAwEAAaMhMB8wHQYDVR0OBBYEFOsCRFl9rYKvsIgn\nvP+n1Hx/7AsDMA0GCSqGSIb3DQEBCwUAA4IBAQBLcT5ixGyRucANZquELd/+b2ZAcLbvy8uZx/zp\nOZpXdUbGJFrSIaODPEHP0iehXsMffbwUgwsWK++cT438ohEgBH1qbiDC5oxlDUS2qPJZ/XuAFilT\nASQyMdobPZbs5y9OcybwCjhwXPu1gZPNE1Iynq3aHvbAIF8c/OhuX5j4SB5O9AYwZSHoAV/CqOrn\n4JdY39Ocz6SMPn5nS9xmKU3ieniUbzjE6P3DIUiJzvuQ9q2zyhXdOUtc41N25Z51yfNkEAqJG+1j\nzFNBjaGNzEmYqyz5XtJx1rLKFeXyTw7cJl89CrVtVec0eKg5aHmZvgAwS8BauImsfcxRGGUHf3/4\n-----END CERTIFICATE-----";
    public OkHttpClient okHttpClient;

    class C62341 implements HostnameVerifier {
        C62341() {
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public HttpConfig() {
        configOkhttp();
    }

    public Headers buildHeadersForOk(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        Builder builder = new Builder();
        for (String str : map.keySet()) {
            if (!ValueUtil.isEmpty((String) map.get(str))) {
                try {
                    builder.add(str, URLEncoder.encode((String) map.get(str), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return builder.build();
    }

    public void configOkhttp() {
        if (this.okHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(10, TimeUnit.SECONDS).readTimeout(45, TimeUnit.SECONDS).writeTimeout(45, TimeUnit.SECONDS).hostnameVerifier(new C62341());
            InputStream inputStream = new Buffer().writeUtf8(this.cert).inputStream();
            new SetHttpCertificate(builder).setCertificates(inputStream);
            this.okHttpClient = builder.build();
        }
    }

    public OkHttpClient getOkHttpClient() {
        return this.okHttpClient;
    }

    public void release() {
        this.okHttpClient = null;
    }
}

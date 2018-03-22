package com.huawei.appmarket.sdk.service.p373c;

import com.sina.weibo.sdk.component.GameManager;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class C4295c {
    public static void m20725a(String str) {
        if (!C4296d.m20729b(str)) {
            try {
                HttpClient defaultHttpClient = new DefaultHttpClient();
                HttpUriRequest httpPost = new HttpPost("http://huskycdn.hicloud.com/cdn/report");
                httpPost.setEntity(new StringEntity(str, GameManager.DEFAULT_CHARSET));
                defaultHttpClient.execute(httpPost);
            } catch (ClientProtocolException e) {
            } catch (IOException e2) {
            }
        }
    }
}

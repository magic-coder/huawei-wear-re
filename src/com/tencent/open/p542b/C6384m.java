package com.tencent.open.p542b;

import android.os.Bundle;
import com.tencent.open.p532d.C6395h;
import com.tencent.open.p532d.C6396i;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p541a.C6367n;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;

/* compiled from: ProGuard */
class C6384m implements Runnable {
    final /* synthetic */ Bundle f22202a;
    final /* synthetic */ String f22203b;
    final /* synthetic */ boolean f22204c;
    final /* synthetic */ String f22205d;
    final /* synthetic */ C6378g f22206e;

    C6384m(C6378g c6378g, Bundle bundle, String str, boolean z, String str2) {
        this.f22206e = c6378g;
        this.f22202a = bundle;
        this.f22203b = str;
        this.f22204c = z;
        this.f22205d = str2;
    }

    public void run() {
        int i;
        Object obj = null;
        if (this.f22202a == null) {
            C6367n.m29112e("openSDK_LOG.ReportManager", "-->httpRequest, params is null!");
            return;
        }
        String encode;
        HttpUriRequest httpGet;
        int a = C6376e.m29149a();
        int i2 = a == 0 ? 3 : a;
        C6367n.m29107b("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + i2);
        HttpClient a2 = C6396i.m29195a(C6395h.m29184a(), null, this.f22203b);
        String a3 = C6396i.m29192a(this.f22202a);
        if (this.f22204c) {
            encode = URLEncoder.encode(a3);
        } else {
            encode = a3;
        }
        if (this.f22205d.toUpperCase().equals(HttpGet.METHOD_NAME)) {
            StringBuffer stringBuffer = new StringBuffer(this.f22203b);
            stringBuffer.append(encode);
            httpGet = new HttpGet(stringBuffer.toString());
        } else if (this.f22205d.toUpperCase().equals(HttpPost.METHOD_NAME)) {
            HttpPost httpPost = new HttpPost(this.f22203b);
            httpPost.setEntity(new ByteArrayEntity(C6412y.m29269k(encode)));
            Object obj2 = httpPost;
        } else {
            C6367n.m29112e("openSDK_LOG.ReportManager", "-->httpRequest unkonw request method return.");
            return;
        }
        httpGet.addHeader("Accept-Encoding", "gzip");
        httpGet.addHeader("Content-Type", URLEncodedUtils.CONTENT_TYPE);
        a = 0;
        do {
            a++;
            try {
                int statusCode = a2.execute(httpGet).getStatusLine().getStatusCode();
                C6367n.m29107b("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + statusCode);
                if (statusCode != 200) {
                    C6367n.m29107b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest : HttpStatuscode != 200");
                    break;
                }
                try {
                    C6367n.m29107b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread success");
                    i = 1;
                    break;
                } catch (ConnectTimeoutException e) {
                    i = 1;
                } catch (SocketTimeoutException e2) {
                    i = 1;
                    C6367n.m29107b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException");
                    continue;
                    if (a >= i2) {
                        if (obj == 1) {
                            C6367n.m29107b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request failed");
                        } else {
                            C6367n.m29107b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request success");
                        }
                    }
                } catch (Exception e3) {
                    i = 1;
                }
            } catch (ConnectTimeoutException e4) {
                try {
                    C6367n.m29107b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest ConnectTimeoutException");
                    continue;
                    if (a >= i2) {
                        if (obj == 1) {
                            C6367n.m29107b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request failed");
                        } else {
                            C6367n.m29107b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request success");
                        }
                    }
                } catch (Exception e5) {
                    C6367n.m29107b("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor.");
                    return;
                }
            } catch (SocketTimeoutException e6) {
                C6367n.m29107b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException");
                continue;
                if (a >= i2) {
                    if (obj == 1) {
                        C6367n.m29107b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request success");
                    } else {
                        C6367n.m29107b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request failed");
                    }
                }
            } catch (Exception e7) {
            }
        } while (a >= i2);
        if (obj == 1) {
            C6367n.m29107b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request success");
        } else {
            C6367n.m29107b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request failed");
        }
        C6367n.m29107b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception");
        if (obj == 1) {
            C6367n.m29107b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request success");
        } else {
            C6367n.m29107b("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Thread request failed");
        }
    }
}

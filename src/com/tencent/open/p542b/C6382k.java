package com.tencent.open.p542b;

import android.os.Bundle;
import com.tencent.open.p532d.C6395h;
import com.tencent.open.p532d.C6396i;
import com.tencent.open.p532d.C6403p;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p541a.C6367n;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ByteArrayEntity;

/* compiled from: ProGuard */
class C6382k implements Runnable {
    final /* synthetic */ C6378g f22200a;

    C6382k(C6378g c6378g) {
        this.f22200a = c6378g;
    }

    public void run() {
        Object obj = null;
        Bundle c = this.f22200a.m29164c();
        if (c != null) {
            int a = C6403p.m29203a(C6395h.m29184a(), null).m29212a("Common_HttpRetryCount");
            int i = a == 0 ? 3 : a;
            C6367n.m29107b("openSDK_LOG.ReportManager", "-->doReportCgi, retryCount: " + i);
            a = 0;
            do {
                a++;
                try {
                    HttpClient a2 = C6396i.m29195a(C6395h.m29184a(), null, "http://wspeed.qq.com/w.cgi");
                    HttpUriRequest httpPost = new HttpPost("http://wspeed.qq.com/w.cgi");
                    httpPost.addHeader("Accept-Encoding", "gzip");
                    httpPost.setHeader("Content-Type", URLEncodedUtils.CONTENT_TYPE);
                    httpPost.setEntity(new ByteArrayEntity(C6412y.m29269k(C6396i.m29192a(c))));
                    int statusCode = a2.execute(httpPost).getStatusLine().getStatusCode();
                    C6367n.m29107b("openSDK_LOG.ReportManager", "-->doReportCgi, statusCode: " + statusCode);
                    if (statusCode == 200) {
                        C6377f.m29151a().m29154b("report_cgi");
                        obj = 1;
                    }
                } catch (Throwable e) {
                    try {
                        C6367n.m29105a("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e);
                        continue;
                    } catch (Throwable e2) {
                        C6367n.m29105a("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception out.", e2);
                        return;
                    }
                } catch (Throwable e3) {
                    C6367n.m29105a("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e3);
                    continue;
                } catch (Throwable e22) {
                    C6367n.m29105a("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e22);
                }
                if (obj == null) {
                    C6377f.m29151a().m29153a("report_cgi", this.f22200a.f22182c);
                }
                this.f22200a.f22182c.clear();
            } while (a < i);
            if (obj == null) {
                C6377f.m29151a().m29153a("report_cgi", this.f22200a.f22182c);
            }
            this.f22200a.f22182c.clear();
        }
    }
}

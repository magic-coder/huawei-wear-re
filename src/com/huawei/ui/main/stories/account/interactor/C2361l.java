package com.huawei.ui.main.stories.account.interactor;

import com.huawei.p190v.C2538c;
import com.tencent.tauth.b;
import com.tencent.tauth.d;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: QQ */
class C2361l implements b {
    final /* synthetic */ CountDownLatch f8538a;
    final /* synthetic */ StringBuffer f8539b;
    final /* synthetic */ C2360k f8540c;

    C2361l(C2360k c2360k, CountDownLatch countDownLatch, StringBuffer stringBuffer) {
        this.f8540c = c2360k;
        this.f8538a = countDownLatch;
        this.f8539b = stringBuffer;
    }

    public void m11969a(d dVar) {
        this.f8538a.countDown();
    }

    public void m11970a(Object obj) {
        try {
            this.f8539b.append(((JSONObject) obj).getString("nickname"));
        } catch (JSONException e) {
            C2538c.m12680e(C2360k.f8534a, "onComplete JSONException");
        } catch (Exception e2) {
            C2538c.m12680e(C2360k.f8534a, "onComplete Exception");
        }
        this.f8538a.countDown();
    }

    public void m11968a() {
        this.f8538a.countDown();
    }
}

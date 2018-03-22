package com.huawei.ui.main.stories.account.interactor;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.p190v.C2538c;
import com.tencent.connect.a;
import com.tencent.connect.b.w;
import com.tencent.tauth.c;
import java.util.concurrent.CountDownLatch;

/* compiled from: QQ */
public class C2360k {
    private static final String f8534a = C2360k.class.getName();
    private Activity f8535b;
    private C2331j f8536c = null;
    private c f8537d;

    public C2360k(Activity activity, C2331j c2331j) {
        if (activity != null) {
            this.f8535b = activity;
            String str = "";
            C2538c.m12674b(f8534a, "QQ() context=" + activity + ", callback=" + c2331j);
            this.f8536c = c2331j;
            this.f8537d = c.a("209207", activity);
            if (this.f8537d != null) {
                this.f8536c.mo2655a(true);
            } else {
                this.f8536c.mo2655a(false);
            }
        }
    }

    public void m11967a() {
        this.f8537d.a(this.f8535b, "all", new C2362m());
    }

    public String m11966a(Context context, String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        w wVar = new w(str);
        wVar.a("209207");
        wVar.b(str2);
        wVar.a(str, System.currentTimeMillis() + "");
        new a(context, wVar).a(new C2361l(this, countDownLatch, stringBuffer));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            C2538c.m12680e(f8534a, "onComplete latch.await();");
        }
        if (TextUtils.isEmpty(stringBuffer.toString())) {
            return str3;
        }
        return stringBuffer.toString();
    }
}

package com.huawei.ui.main.stories.about.activity.legalinformation;

import android.content.Context;
import android.os.Message;
import com.huawei.p190v.C2538c;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: PrivacyPolicyActivity */
class C2319g implements Runnable {
    final /* synthetic */ Context f8406a;
    final /* synthetic */ PrivacyPolicyActivity f8407b;

    C2319g(PrivacyPolicyActivity privacyPolicyActivity, Context context) {
        this.f8407b = privacyPolicyActivity;
        this.f8406a = context;
    }

    public void run() {
        if (this.f8407b.m11844c(this.f8406a).startsWith("http://consumer.huawei.com/minisite/worldwide/privacy-policy")) {
            Object obj = "";
            try {
                C2538c.m12674b("PrivacyPolicyActivity", "===www==getFormatUrl(mContext)" + this.f8407b.m11844c(this.f8406a));
                obj = this.f8407b.m11831a(new URL(this.f8407b.m11844c(this.f8406a)));
            } catch (MalformedURLException e) {
                C2538c.m12674b("PrivacyPolicyActivity", "===www====MalformedURLException e" + e.getMessage());
            }
            if (this.f8407b.f8398k != null) {
                Message obtain = Message.obtain();
                if ("".equals(obj)) {
                    obtain.what = 2;
                } else {
                    obtain.what = 1;
                    obtain.obj = obj;
                }
                this.f8407b.f8398k.sendMessage(obtain);
            }
        }
    }
}

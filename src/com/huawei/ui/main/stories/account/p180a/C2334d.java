package com.huawei.ui.main.stories.account.p180a;

import android.app.Activity;
import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.C2329a;
import com.huawei.ui.main.stories.account.interactor.C2344c;
import com.huawei.ui.main.stories.account.interactor.WeChat;
import java.lang.ref.WeakReference;

/* compiled from: WeChatAccount */
public class C2334d implements C2329a {
    private static final String f8458a = C2334d.class.getSimpleName();
    private final WeakReference<Activity> f8459b;
    private WeChat f8460c;

    public C2334d(Activity activity) {
        this.f8459b = new WeakReference(activity);
    }

    public void mo2652a(C2344c c2344c) {
        Activity activity = (Activity) this.f8459b.get();
        if (activity == null) {
            C2538c.m12680e(f8458a, "MyOnWheelChangedListener UserInfoActivity =null");
            return;
        }
        this.f8460c = new WeChat(activity, new C2335e(this, c2344c));
        if (this.f8460c.isWXAppInstalled()) {
            this.f8460c.login();
        } else {
            c2344c.mo2656a(8, "weiXin app ERR_NOT_INSTALLED");
        }
    }

    public void mo2651a(int i, int i2, Intent intent) {
    }
}

package com.huawei.ui.main.stories.account.p180a;

import android.app.Activity;
import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.activity.SinaweiboLoginActivity;
import com.huawei.ui.main.stories.account.interactor.C2329a;
import com.huawei.ui.main.stories.account.interactor.C2344c;
import com.huawei.ui.main.stories.account.interactor.C2353b;
import java.lang.ref.WeakReference;

/* compiled from: SinaweiboAccount */
public class C2333c implements C2329a {
    private static final String f8455a = C2333c.class.getName();
    private final WeakReference<Activity> f8456b;
    private C2344c f8457c;

    public C2333c(Activity activity) {
        this.f8456b = new WeakReference(activity);
    }

    public void mo2652a(C2344c c2344c) {
        this.f8457c = c2344c;
        Activity activity = (Activity) this.f8456b.get();
        if (activity == null) {
            C2538c.m12680e(f8455a, "SinaweiboAccount Activity =null");
            return;
        }
        activity.startActivityForResult(new Intent(activity, SinaweiboLoginActivity.class), 10);
    }

    public void mo2651a(int i, int i2, Intent intent) {
        switch (i) {
            case 10:
                if (-1 == i2) {
                    try {
                        String stringExtra = intent.getStringExtra("sinaweibo_userid");
                        String stringExtra2 = intent.getStringExtra("sinaweibo_token");
                        String stringExtra3 = intent.getStringExtra("sinaweibo_username");
                        C2538c.m12674b(f8455a, "onActivityResult() strUserId=" + stringExtra + ", strAccessToken=**, strUserName=" + stringExtra3);
                        C2353b c2353b = new C2353b();
                        c2353b.m11938c(4);
                        c2353b.m11939c(stringExtra);
                        c2353b.m11936b(stringExtra2);
                        c2353b.m11941d(stringExtra3);
                        if (this.f8457c != null) {
                            this.f8457c.mo2657a(c2353b);
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        C2538c.m12674b(f8455a, "onActivityResult", e.getMessage());
                        return;
                    }
                } else if (this.f8457c != null) {
                    this.f8457c.mo2656a(i2, null);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}

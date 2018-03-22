package com.huawei.ui.main.stories.account.p180a;

import android.app.Activity;
import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.C2329a;
import com.huawei.ui.main.stories.account.interactor.C2344c;
import com.huawei.ui.main.stories.account.interactor.C2360k;
import java.lang.ref.WeakReference;

/* compiled from: QQAccount */
public class C2330a implements C2329a {
    private static final String f8450a = C2330a.class.getName();
    private final WeakReference<Activity> f8451b;
    private C2360k f8452c = null;

    public C2330a(Activity activity) {
        this.f8451b = new WeakReference(activity);
    }

    public void mo2652a(C2344c c2344c) {
        Activity activity = (Activity) this.f8451b.get();
        if (activity == null) {
            C2538c.m12680e(f8450a, "QQAccountPlugin Activity =null");
            return;
        }
        C2538c.m12677c(f8450a, "login");
        this.f8452c = new C2360k(activity, new C2332b(this, c2344c));
        this.f8452c.m11967a();
    }

    public void mo2651a(int i, int i2, Intent intent) {
    }
}

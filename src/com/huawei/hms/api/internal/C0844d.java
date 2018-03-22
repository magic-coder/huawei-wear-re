package com.huawei.hms.api.internal;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BindingFailedResolveMgr */
class C0844d {
    static final C0844d f1340a = new C0844d();
    List<Activity> f1341b = new ArrayList(1);

    C0844d() {
    }

    void m2993a(Activity activity) {
        for (Activity activity2 : this.f1341b) {
            if (!(activity2 == null || activity2 == activity || activity2.isFinishing())) {
                activity2.finish();
            }
        }
        this.f1341b.add(activity);
    }

    void m2994b(Activity activity) {
        this.f1341b.remove(activity);
    }
}

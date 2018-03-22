package com.huawei.hwcommonmodel.application;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* compiled from: BaseApplication */
class C0974a implements ActivityLifecycleCallbacks {
    final /* synthetic */ BaseApplication f1637a;

    C0974a(BaseApplication baseApplication) {
        this.f1637a = baseApplication;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        BaseApplication.m2634d();
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
        BaseApplication.m2635e();
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }
}

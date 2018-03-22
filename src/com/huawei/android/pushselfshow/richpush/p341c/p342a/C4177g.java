package com.huawei.android.pushselfshow.richpush.p341c.p342a;

import android.app.Activity;
import com.huawei.android.pushagent.c.a.e;

public class C4177g {
    public boolean f15713a = false;
    public boolean f15714b = false;
    public long f15715c = 2000;
    public int f15716d = 0;
    private Activity f15717e = null;

    public C4177g(Activity activity) {
        try {
            e.e("PushSelfShowLog", "init GeoBroker");
            this.f15717e = activity;
        } catch (Throwable e) {
            e.d("PushSelfShowLog", "init GeoBroker error ", e);
        }
    }
}

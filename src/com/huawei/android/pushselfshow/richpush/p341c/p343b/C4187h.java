package com.huawei.android.pushselfshow.richpush.p341c.p343b;

import android.app.Activity;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.richpush.p341c.p342a.C4171a;
import com.huawei.android.pushselfshow.richpush.p341c.p342a.C4173c;
import com.huawei.android.pushselfshow.richpush.p341c.p342a.C4174d;
import com.huawei.android.pushselfshow.richpush.p341c.p342a.C4176f;
import com.huawei.android.pushselfshow.richpush.p341c.p342a.C4177g;
import com.huawei.android.pushselfshow.richpush.p341c.p342a.C4178h;
import java.util.HashMap;

public class C4187h {
    public HashMap f15749a = new HashMap();

    public C4187h(Activity activity, boolean z) {
        try {
            this.f15749a.clear();
            this.f15749a.put("Audio", new C4174d(activity));
            this.f15749a.put("Video", new C4178h(activity));
            this.f15749a.put("App", new C4173c(activity));
            this.f15749a.put("Geo", new C4177g(activity));
            this.f15749a.put("Accelerometer", new C4171a(activity));
            this.f15749a.put("Device", new C4176f(activity, z));
        } catch (Throwable e) {
            e.c("PluginManager", e.toString(), e);
        }
    }
}

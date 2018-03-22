package com.huawei.hwdatamigrate.hihealth.p069e;

import android.os.RemoteCallbackList;
import android.util.SparseArray;
import com.huawei.hihealth.HiHealthClient;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.as;
import com.huawei.hihealth.data.c.f;
import com.huawei.hwdatamigrate.hihealth.e.b;
import com.huawei.hwdatamigrate.hihealth.e.c;
import com.huawei.hwdatamigrate.hihealth.p068d.C1002g;
import com.huawei.p190v.C2538c;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ListenerManager */
public class C1003a {
    private SparseArray<RemoteCallbackList<as>> f1697a;
    private HashMap<Integer, as> f1698b;
    private ExecutorService f1699c;

    private C1003a() {
        this.f1697a = new SparseArray();
        this.f1698b = new HashMap();
        this.f1699c = Executors.newSingleThreadExecutor();
    }

    public static C1003a m3690a() {
        return c.a;
    }

    public void m3692a(int i, String str, C1002g c1002g) {
        C2538c.m12677c("Debug_ListenerManager", "startListenerChange subscribeType = ", Integer.valueOf(i), ",changeKey = ", str, ",hiHealthContext = ", c1002g);
        m3691a(i, str, m3689a(c1002g), null);
    }

    private void m3691a(int i, String str, HiHealthClient hiHealthClient, HiHealthData hiHealthData) {
        if (!f.a(i)) {
            C2538c.m12679d("Debug_ListenerManager", "startListenerChange type is not valid subscribeType = ", Integer.valueOf(i));
        } else if (this.f1699c.isShutdown()) {
            C2538c.m12680e("Debug_ListenerManager", "startListenerChange subscribeThread is closed!");
        } else {
            this.f1699c.execute(new b(this, i, hiHealthClient, str, hiHealthData));
        }
    }

    private HiHealthClient m3689a(C1002g c1002g) {
        if (c1002g == null) {
            return null;
        }
        HiHealthClient hiHealthClient = new HiHealthClient();
        hiHealthClient.setPackageName(c1002g.m3678b());
        hiHealthClient.setAppID(c1002g.m3682d());
        return hiHealthClient;
    }
}

package com.huawei.hwdatamigrate.hihealth.p068d;

import android.content.Context;
import com.huawei.hihealth.HiAppInfo;
import com.huawei.hihealth.HiDeviceInfo;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p067c.C4847d;
import com.huawei.hwdatamigrate.hihealth.p067c.C4850g;
import com.huawei.hwdatamigrate.hihealth.p067c.C4868y;
import com.huawei.hwdatamigrate.hihealth.p067c.ak;
import com.huawei.hwdatamigrate.hihealth.p419i.C4938a;
import com.huawei.hwdatamigrate.hihealth.sync.a.h;
import com.huawei.hwdatamigrate.hihealth.sync.d.m;
import com.huawei.p190v.C2538c;

/* compiled from: SyncClient */
public class C4886r {
    private static Context f17904b;
    private C4870a f17905a;

    private C4886r() {
        this.f17905a = new C4870a();
    }

    public static C4886r m23660a(Context context) {
        f17904b = context.getApplicationContext();
        return C4888t.f17906a;
    }

    public g m23663a(int i, int i2, long j) throws h {
        return m23661b(i, i2, j);
    }

    private synchronized g m23661b(int i, int i2, long j) throws h {
        g a;
        if (m23662c(i, i2, j)) {
            String a2 = C4875f.m23636a(Integer.toString(i), Integer.toString(i2), Long.toString(j));
            a = this.f17905a.m23630a(a2);
            if (a == null) {
                int a3 = m23657a(i);
                if (a3 <= 0) {
                    C2538c.d("Debug_SyncClient", new Object[]{"syncHiHealthContext appID <= 0 appType =  ", Integer.valueOf(i)});
                    a = null;
                } else {
                    int a4 = m23658a(a3, j);
                    if (a4 <= 0) {
                        C2538c.d("Debug_SyncClient", new Object[]{"syncHiHealthContext deviceID is ", Integer.valueOf(a4)});
                        a = null;
                    } else {
                        a = m23659a(a3, i2, a4, j);
                        if (a.c() <= 0) {
                            C2538c.d("Debug_SyncClient", new Object[]{"syncHiHealthContext clientID <= 0  key = ", a2});
                            a = null;
                        } else {
                            this.f17905a.m23631a(a2, a);
                        }
                    }
                }
            }
        } else {
            C2538c.d("Debug_SyncClient", new Object[]{"syncHiHealthContext checkInput  = false"});
            a = null;
        }
        return a;
    }

    private int m23657a(int i) {
        String a = C4938a.m23801a(i);
        int a2 = C4847d.m23553a(f17904b).m23556a(a);
        if (a2 > 0) {
            return a2;
        }
        HiAppInfo hiAppInfo = new HiAppInfo();
        hiAppInfo.setPackageName(a);
        hiAppInfo.setAppName(C4938a.m23802b(a));
        return (int) C4847d.m23553a(f17904b).m23557a(hiAppInfo, 0);
    }

    private int m23658a(int i, long j) throws h {
        int a = ak.m23455a(f17904b).m23458a(j, i);
        if (a > 0) {
            return a;
        }
        HiDeviceInfo a2 = m.a(f17904b, j);
        C2538c.b("Debug_SyncClient", new Object[]{"syncOneDeviceByVersion hiDeviceInfo is", a2});
        if (a2 == null) {
            return a;
        }
        C4868y.m23620a(f17904b).m23629b(a2);
        return g.a(f17904b, a2.getDeviceUniqueCode());
    }

    private g m23659a(int i, int i2, int i3, long j) {
        g gVar = new g();
        gVar.c(i);
        gVar.a(j);
        gVar.d(i3);
        gVar.a(1);
        gVar.e(i2);
        gVar.b(C4850g.m23559a(f17904b).m23562a(gVar));
        return gVar;
    }

    private boolean m23662c(int i, int i2, long j) {
        if (i >= 0 && i2 > 0 && j > 0) {
            return true;
        }
        C2538c.d("Debug_SyncClient", new Object[]{"checkInput no such input appType is ", Integer.valueOf(i), " deviceCode is ", Long.valueOf(j)});
        return false;
    }
}

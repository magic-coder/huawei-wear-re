package com.huawei.hwdatamigrate.hihealth.p416h;

import android.content.Context;
import com.huawei.hihealth.HiAccountInfo;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p067c.C4844a;
import com.huawei.hwdatamigrate.hihealth.p067c.C4847d;
import com.huawei.hwdatamigrate.hihealth.p067c.bs;
import com.huawei.p190v.C2538c;

/* compiled from: HiUserDataStore */
public class C4935e {
    private static Context f18020a;
    private bs f18021b;
    private C4844a f18022c;

    private C4935e() {
        this.f18021b = bs.m23535a(f18020a);
        this.f18022c = C4844a.m23413a(f18020a);
    }

    public static C4935e m23795a(Context context) {
        f18020a = context.getApplicationContext();
        return C4937g.f18023a;
    }

    public boolean m23798a(HiAccountInfo hiAccountInfo, g gVar) {
        return m23796b(hiAccountInfo, gVar);
    }

    private synchronized boolean m23796b(HiAccountInfo hiAccountInfo, g gVar) {
        boolean z = true;
        synchronized (this) {
            C2538c.b("HiH_HiUserDataStore", new Object[]{"hiLogin accountInfo = ", hiAccountInfo});
            int d = gVar.d();
            String b = this.f18022c.m23420b(d);
            String huid = hiAccountInfo.getHuid();
            if (huid.equals(b)) {
                C2538c.b("HiH_HiUserDataStore", new Object[]{"hiLogin huid is already login  huid = ", huid});
            } else {
                hiAccountInfo.setAppId(d);
                hiAccountInfo.setLogin(1);
                int a = this.f18021b.m23537a(b, 0);
                C2538c.b("HiH_HiUserDataStore", new Object[]{"hiLogin oldHuid = ", b, ",oldUserID = ", Integer.valueOf(a)});
                this.f18022c.m23421c(d);
                z = this.f18022c.m23419a(hiAccountInfo);
                d = this.f18021b.m23537a(huid, 0);
                if (d <= 0) {
                    HiUserInfo hiUserInfo = new HiUserInfo();
                    hiUserInfo.setHuid(huid);
                    hiUserInfo.setRelateType(0);
                    hiUserInfo.setCreateTime(1);
                    d = (int) this.f18021b.m23538a(hiUserInfo, 0);
                }
                b = gVar.b();
                C2538c.c("HiH_HiUserDataStore", new Object[]{"hiLogin ans = ", Boolean.valueOf(z), ",newUser = ", Integer.valueOf(d), ",oldUser = ", Integer.valueOf(a), ",packageName = ", b});
            }
        }
        return z;
    }

    public String m23797a() {
        return this.f18022c.m23420b(C4847d.m23553a(f18020a).m23556a(f18020a.getPackageName()));
    }
}

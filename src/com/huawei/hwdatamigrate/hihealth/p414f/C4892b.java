package com.huawei.hwdatamigrate.hihealth.p414f;

import android.content.Context;
import com.huawei.hihealth.HiAccountInfo;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p067c.C4844a;
import com.huawei.hwdatamigrate.hihealth.p067c.C4847d;
import com.huawei.hwdatamigrate.hihealth.p067c.bs;
import com.huawei.hwdatamigrate.hihealth.p416h.C4935e;
import com.huawei.hwdatamigrate.hihealth.p419i.C4938a;
import com.huawei.hwdatamigrate.hihealth.sync.d.e;
import com.huawei.p190v.C2538c;

/* compiled from: MigrateCloud */
public class C4892b {
    private static Context f17913a;
    private C4847d f17914b;
    private C4844a f17915c;
    private bs f17916d;

    public static C4892b m23667a(Context context) {
        f17913a = context.getApplicationContext();
        return C4894d.f17917a;
    }

    private C4892b() {
        this.f17914b = C4847d.m23553a(f17913a);
        this.f17915c = C4844a.m23413a(f17913a);
        this.f17916d = bs.m23535a(f17913a);
    }

    private synchronized int m23666a(String str) {
        int a;
        a = this.f17914b.m23556a(str);
        if (a <= 0) {
            C2538c.c("HiH_MigrateCloud", new Object[]{"initBinder() app <= 0"});
            C2538c.c("HiH_MigrateCloud", new Object[]{"initBinder appInfo = ", C4938a.m23800a(f17913a, str)});
            a = (int) this.f17914b.m23557a(r0, 0);
        }
        C2538c.c("HiH_MigrateCloud", new Object[]{"initBinder() app = ", Integer.valueOf(a), ", packageName = ", str});
        if (this.f17915c.m23420b(a) == null) {
            HiAccountInfo hiAccountInfo = new HiAccountInfo();
            hiAccountInfo.setAppId(a);
            hiAccountInfo.setHuid(str);
            hiAccountInfo.setLogin(1);
            this.f17915c.m23419a(hiAccountInfo);
            HiUserInfo hiUserInfo = new HiUserInfo();
            hiUserInfo.setHuid(str);
            hiUserInfo.setRelateType(0);
            hiUserInfo.setCreateTime(1);
            long a2 = this.f17916d.m23538a(hiUserInfo, 0);
            C2538c.c("HiH_MigrateCloud", new Object[]{"initBinder() who = ", Long.valueOf(a2)});
        }
        return a;
    }

    public boolean m23669a(HiAccountInfo hiAccountInfo) {
        return C4935e.m23795a(f17913a).m23798a(hiAccountInfo, new g(m23666a(f17913a.getPackageName()), f17913a.getPackageName()));
    }

    public void m23668a() {
        e.a(f17913a).c(f17913a.getPackageName());
    }

    public int m23670b() {
        return e.a(f17913a).e();
    }
}

package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hihealth.HiAppInfo;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4814d;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4840e;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4842g;
import com.huawei.p190v.C2538c;

/* compiled from: AppInfoManager */
public class C4847d {
    private static Context f17864a;
    private C4814d f17865b;

    private C4847d() {
        this.f17865b = C4814d.m23206a(f17864a);
    }

    public static C4847d m23553a(@NonNull Context context) {
        f17864a = context.getApplicationContext();
        return C4849f.f17866a;
    }

    public long m23557a(HiAppInfo hiAppInfo, int i) {
        C2538c.b("Debug_AppInfoManager", new Object[]{"insertAppInfoData()"});
        return this.f17865b.mo4566a(C4836a.m23303a(hiAppInfo, i));
    }

    public HiAppInfo m23558a(int i) {
        return C4840e.m23347c(this.f17865b.mo4568a("_id =? ", new String[]{Integer.toString(i)}, null, null, null));
    }

    public int m23556a(String str) {
        C2538c.c("Debug_AppInfoManager", new Object[]{"getAppId() packageName is ", str, " current mContext packageName is ", f17864a.getPackageName()});
        if (C4539a.m21748a(str)) {
            return 0;
        }
        return C4842g.m23372b(this.f17865b.mo4568a(m23554a(), m23555b(str), null, null, null), "_id");
    }

    private String m23554a() {
        return "package_name =? ";
    }

    private String[] m23555b(String str) {
        return new String[]{str};
    }
}

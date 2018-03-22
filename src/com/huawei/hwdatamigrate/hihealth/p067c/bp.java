package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4809c;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.av;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.p190v.C2538c;

/* compiled from: SyncCacheManager */
public class bp {
    private static Context f17851b;
    private av f17852a;
    private final Object f17853c;

    private bp() {
        this.f17853c = new Object();
        this.f17852a = av.m23148a(f17851b);
    }

    public static bp m23532a(@NonNull Context context) {
        f17851b = context.getApplicationContext();
        return br.f17854a;
    }

    private long m23531a(C4809c c4809c) {
        if (c4809c == null) {
            C2538c.d("Debug_SyncCacheManager", new Object[]{"insertSyncCache syncCacheTable is null!"});
            return 0;
        }
        return this.f17852a.mo4566a(C4836a.m23312a(c4809c));
    }

    public boolean m23534a(int i, int i2, String str, long j) {
        boolean z = true;
        synchronized (this.f17853c) {
            C4809c c4809c = new C4809c();
            c4809c.m23057a(i);
            c4809c.m23061b(i2);
            c4809c.m23059a(str);
            c4809c.m23058a(j);
            C2538c.b("Debug_SyncCacheManager", new Object[]{"insert syncCacheTable count is", Long.valueOf(m23531a(c4809c))});
            if (m23531a(c4809c) <= 0) {
                z = false;
            }
        }
        return z;
    }

    public Cursor m23533a(int i) {
        C2538c.b("Debug_SyncCacheManager", new Object[]{"querySyncCache"});
        if (i < 0) {
            C2538c.d("Debug_SyncCacheManager", new Object[]{"querySyncCache userID is not right!"});
            return null;
        }
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(0)};
        return this.f17852a.mo4568a("userId =? and isDone =? ", strArr, null, null, "dataTime DESC ");
    }
}

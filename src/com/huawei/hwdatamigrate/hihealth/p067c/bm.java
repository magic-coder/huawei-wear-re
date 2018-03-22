package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4808b;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.as;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4837b;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4841f;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.huawei.p190v.C2538c;

/* compiled from: SyncAnchorManager */
public class bm {
    private static Context f17847b;
    private as f17848a;
    private final Object f17849c;

    private bm() {
        this.f17849c = new Object();
        this.f17848a = as.m23137a(f17847b);
    }

    public static bm m23521a(@NonNull Context context) {
        f17847b = context.getApplicationContext();
        return bo.f17850a;
    }

    public boolean m23528a(int i, long j, int i2) {
        return C4841f.m23368f(this.f17848a.mo4568a(m23522a(), m23525c(i, j, i2), null, null, null));
    }

    public C4808b m23530b(int i, long j, int i2) {
        return C4837b.m23330d(this.f17848a.mo4568a(m23522a(), m23525c(i, j, i2), null, null, null));
    }

    private long m23523b(C4808b c4808b) {
        C2538c.b("Debug_SyncAnchorManager", new Object[]{"insertSyncAnchor()"});
        return this.f17848a.mo4566a(C4836a.m23311a(c4808b));
    }

    private int m23524c(C4808b c4808b) {
        C2538c.b("Debug_SyncAnchorManager", new Object[]{"updateClientData() update  update = ", Integer.valueOf(this.f17848a.mo4565a(C4836a.m23311a(c4808b), m23522a(), m23525c(c4808b.m23055e(), c4808b.m23049b(), c4808b.m23046a())))});
        return this.f17848a.mo4565a(C4836a.m23311a(c4808b), m23522a(), m23525c(c4808b.m23055e(), c4808b.m23049b(), c4808b.m23046a()));
    }

    public boolean m23529a(C4808b c4808b) {
        boolean a;
        synchronized (this.f17849c) {
            long c;
            c.b("Debug_SyncAnchorManager", new Object[]{"saveVersionToDB syncAnchorTable is", c4808b});
            if (m23528a(c4808b.m23055e(), c4808b.m23049b(), c4808b.m23046a())) {
                c = (long) m23524c(c4808b);
            } else {
                c.b("Debug_SyncAnchorManager", new Object[]{"!!saveVersionToDB syncAnchorTable is", c4808b});
                c = m23523b(c4808b);
            }
            a = C4843h.m23395a(c);
        }
        return a;
    }

    public boolean m23527a(int i, int i2, long j, long j2) {
        C4808b c4808b = new C4808b();
        c4808b.m23051b(j);
        c4808b.m23053c(i);
        c4808b.m23047a(i2);
        c4808b.m23048a(j2);
        C2538c.b("Debug_SyncAnchorManager", new Object[]{"saveVersionToDB syncAnchorTable is", c4808b});
        return m23529a(c4808b);
    }

    public boolean m23526a(int i, int i2, int i3, long j) {
        C4808b c4808b = new C4808b();
        c4808b.m23050b(i3);
        c4808b.m23053c(i);
        c4808b.m23047a(i2);
        c4808b.m23048a(j);
        C2538c.b("Debug_SyncAnchorManager", new Object[]{"saveSyncTimeToDB syncAnchorTable is ", c4808b});
        return m23529a(c4808b);
    }

    private String m23522a() {
        return "main_user_id =? and cloud_code =? and sync_data_type =? ";
    }

    private String[] m23525c(int i, long j, int i2) {
        return new String[]{Integer.toString(i), Long.toString(j), Integer.toString(i2)};
    }
}

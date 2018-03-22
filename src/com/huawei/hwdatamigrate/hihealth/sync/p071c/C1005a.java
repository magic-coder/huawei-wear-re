package com.huawei.hwdatamigrate.hihealth.sync.p071c;

import android.content.Context;
import android.database.Cursor;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.c.e;
import com.huawei.hwdatamigrate.hihealth.b.d.h;
import com.huawei.hwdatamigrate.hihealth.c.bp;
import com.huawei.hwdatamigrate.hihealth.c.bs;
import com.huawei.hwdatamigrate.hihealth.f.o;
import com.huawei.hwdatamigrate.hihealth.h.a;
import com.huawei.hwdatamigrate.hihealth.sync.c.c;
import com.huawei.hwdatamigrate.hihealth.sync.d.l;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1015e;
import com.huawei.p190v.C2538c;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: HiSyncBackgroud */
public class C1005a implements Runnable {
    private Context f1701a;
    private int f1702b;
    private bp f1703c;
    private a f1704d;

    public C1005a(Context context, int i) {
        this.f1701a = context;
        this.f1702b = i;
    }

    private void m3719a() {
        this.f1703c = bp.a(this.f1701a);
        this.f1704d = a.a(this.f1701a);
    }

    public void run() {
        Cursor cursor = null;
        m3719a();
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.m12677c("HiH_HiSyncBackgroud", "insert time ");
        SQLiteDatabase c = com.huawei.hwdatamigrate.hihealth.b.a.a.a(this.f1701a).c();
        String a = h.a(1);
        String b = h.b(1);
        l.a(c, a);
        l.a(c, b);
        try {
            cursor = this.f1703c.a(this.f1702b);
            if (cursor == null) {
                C2538c.m12679d("HiH_HiSyncBackgroud", "query = null ");
                return;
            }
            int count = cursor.getCount();
            C2538c.m12674b("HiH_HiSyncBackgroud", "query count ", Integer.valueOf(count));
            while (cursor.moveToNext()) {
                a = cursor.getString(cursor.getColumnIndex("data"));
                if (a == null) {
                    C2538c.m12680e("HiH_HiSyncBackgroud", "data  = nul");
                } else {
                    int length = a.length();
                    C2538c.m12674b("HiH_HiSyncBackgroud", "data length is ", Integer.valueOf(length));
                    length = cursor.getInt(cursor.getColumnIndex("_id"));
                    List list = (List) e.a(a, new c(null).getType());
                    if (!(list == null || list.isEmpty())) {
                        this.f1704d.a(list, this.f1702b);
                        l.a(c, h.a(1, length));
                    }
                }
            }
            C2538c.m12677c("HiH_HiSyncBackgroud", "insert over ");
            if (cursor != null) {
                cursor.close();
            }
            C1015e.m3861b(false);
            a = h.a(1);
            String b2 = h.b(1);
            l.a(c, a);
            l.a(c, b2);
            C1015e.m3856a(this.f1701a).m3882b(Integer.toString(this.f1702b));
            m3721b();
            C2538c.m12677c("HiH_HiSyncBackgroud", "Background task is down! totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            C1015e.m3861b(false);
        }
    }

    public static void m3720a(Context context, List<HiHealthData> list, int i, int i2) {
        bp a = bp.a(context);
        long startTime = ((HiHealthData) list.get(0)).getStartTime();
        int size = list.size();
        C2538c.m12674b("HiH_HiSyncBackgroud", "hiHealthDatas size is ", Integer.valueOf(size));
        if (size <= 1000) {
            if (!a.a(i2, i, e.a(list), startTime)) {
                C2538c.m12679d("HiH_HiSyncBackgroud", "performDownloadByVersion saveVersionToDB failed ");
                return;
            }
            return;
        }
        int i3;
        int i4 = size / 1000;
        if (size % 1000 != 0) {
            i3 = i4 + 1;
        } else {
            i3 = i4;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            C2538c.m12674b("HiH_HiSyncBackgroud", "subhiHealthDatas begin page = ", Integer.valueOf(i5));
            List subList = list.subList(i5 * 1000, (i5 + 1) * 1000 > size ? size : ((i5 + 1) * 1000) - 1);
            if (subList == null || subList.isEmpty()) {
                C2538c.m12679d("HiH_HiSyncBackgroud", "subhiHealthDatas is null");
            } else {
                if (!a.a(i2, i, e.a(subList), startTime)) {
                    C2538c.m12679d("HiH_HiSyncBackgroud", "performDownloadByVersion saveVersionToDB failed ");
                }
                C2538c.m12677c("HiH_HiSyncBackgroud", "subhiHealthDatas over");
            }
        }
    }

    private void m3721b() {
        C2538c.m12677c("HiH_HiSyncBackgroud", "startMigrate");
        com.huawei.hwdatamigrate.hihealth.f.a a = o.a(this.f1701a, bs.a(this.f1701a).a(this.f1702b));
        if (a == null || a.a()) {
            C2538c.m12677c("HiH_HiSyncBackgroud", "startMigrate it is migrating");
            return;
        }
        a.b();
    }
}

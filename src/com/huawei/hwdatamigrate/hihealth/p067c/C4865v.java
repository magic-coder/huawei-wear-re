package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.ap;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4839d;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4840e;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.List;

/* compiled from: DataStatManager */
public class C4865v {
    private static Context f17882b;
    private ap f17883a;

    private C4865v() {
        this.f17883a = ap.m23126a(f17882b);
    }

    public static C4865v m23609a(@NonNull Context context) {
        f17882b = context.getApplicationContext();
        return C4867x.f17884a;
    }

    private long m23611b(C4807a c4807a) {
        return this.f17883a.mo4566a(C4836a.m23310a(c4807a));
    }

    public C4807a m23615a(int i, int i2, int i3) {
        return C4840e.m23343a(this.f17883a.mo4568a(m23610a(), m23612b(i, i2, i3), null, null, null));
    }

    private long m23613c(C4807a c4807a) {
        if (c4807a.m23025a() == C4540b.m21750a(System.currentTimeMillis())) {
            C2538c.c("Debug_DataStatManager", new Object[]{"updateStatData today stat need to upload, statTable is ", c4807a});
            c4807a.m23042g(0);
        }
        ContentValues b = C4836a.m23317b(c4807a);
        if (c4807a.m23044i() == 1) {
            b.remove("sync_status");
        }
        return (long) this.f17883a.mo4565a(b, m23610a(), m23612b(c4807a.m23025a(), c4807a.m23033c(), c4807a.m23039f()));
    }

    public boolean m23618a(C4807a c4807a) {
        C2538c.b("Debug_DataStatManager", new Object[]{"insertOrUpdateStatData() newStat =", c4807a});
        if (c4807a.m23045j() <= 0) {
            c4807a.m23032b(System.currentTimeMillis());
        }
        double d = c4807a.m23035d();
        C4807a a = m23615a(c4807a.m23025a(), c4807a.m23033c(), c4807a.m23039f());
        C2538c.b("Debug_DataStatManager", new Object[]{"insertOrUpdateStatData() oldStat =", a});
        if (a == null) {
            if (d > 0.0d) {
                return C4843h.m23395a(m23611b(c4807a));
            }
            C2538c.d("Debug_DataStatManager", new Object[]{"insertOrUpdateStatData() oldValue=null value <= 0 newStat =", c4807a});
            return false;
        } else if (bc.m23493a(a, c4807a)) {
            return C4843h.m23395a(m23613c(c4807a));
        } else {
            return false;
        }
    }

    public List<Integer> m23617a(int i, int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[(iArr.length + 2)];
        strArr[0] = Integer.toString(i);
        strArr[1] = Integer.toString(0);
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ");
        stringBuffer.append("sync_status").append(" =? ");
        C4843h.m23388a("stat_type", iArr, iArr.length, stringBuffer, strArr, 2);
        C4843h.m23390a(stringBuffer, "date");
        return C4840e.m23346b(this.f17883a.mo4568a(stringBuffer.toString(), strArr, null, null, null));
    }

    public int m23614a(int i, long j, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(1));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("date").append(" =? and ").append("stat_type").append(" =? ");
        return this.f17883a.mo4565a(contentValues, stringBuffer.toString(), new String[]{Integer.toString(i), Integer.toString(C4540b.m21750a(j)), Integer.toString(i2)});
    }

    private String m23610a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("date").append(" =? and ").append("stat_type").append(" =? and ").append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? ");
        return stringBuffer.toString();
    }

    private String[] m23612b(int i, int i2, int i3) {
        return new String[]{Integer.toString(i), Long.toString((long) i2), Integer.toString(i3)};
    }

    public List<HiHealthData> m23616a(int i, int i2, int i3, int i4) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(0)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("sync_status").append(" =? ");
        return C4839d.m23339b(this.f17883a.mo4568a(stringBuffer.toString(), strArr, null, null, C4843h.m23381a("date", i2, i3, i4)));
    }

    public List<HiHealthData> m23619b(int i, int i2, int i3, int i4) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? ");
        return C4839d.m23339b(this.f17883a.mo4568a(stringBuffer.toString(), strArr, null, null, C4843h.m23381a("date", i2, i3, i4)));
    }
}

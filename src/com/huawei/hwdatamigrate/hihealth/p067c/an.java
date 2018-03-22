package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.content.Context;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.ah;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4839d;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4841f;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.List;

/* compiled from: MDataCoreSessionManager */
public class an {
    private static Context f17824b;
    private ah f17825a;

    private an() {
        this.f17825a = ah.m23109a(f17824b);
    }

    public static an m23465a(Context context) {
        f17824b = context.getApplicationContext();
        return ap.f17826a;
    }

    public long m23471a(HiHealthData hiHealthData, int i, int i2) {
        return this.f17825a.mo4566a(C4836a.m23322d(hiHealthData, i, i2));
    }

    private boolean m23467b(long j, long j2, int i) {
        return C4841f.m23368f(this.f17825a.mo4568a(m23466a(), m23469c(j, j2, i), null, null, null));
    }

    private int m23468c(HiHealthData hiHealthData, int i, int i2) {
        ContentValues d = C4836a.m23321d(hiHealthData, i2);
        if (hiHealthData.getSyncStatus() == 1) {
            d.remove("sync_status");
        }
        return this.f17825a.mo4565a(d, m23466a(), m23469c(hiHealthData.getStartTime(), hiHealthData.getEndTime(), i));
    }

    private String[] m23469c(long j, long j2, int i) {
        return new String[]{Long.toString(j), Long.toString(j2), Integer.toString(i)};
    }

    public boolean m23475b(HiHealthData hiHealthData, int i, int i2) {
        long c;
        if (m23467b(hiHealthData.getStartTime(), hiHealthData.getEndTime(), i)) {
            c = (long) m23468c(hiHealthData, i, i2);
        } else {
            c = m23471a(hiHealthData, i, i2);
        }
        return C4843h.m23395a(c);
    }

    public int m23470a(long j, long j2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(i));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return this.f17825a.mo4565a(contentValues, "_id =? and modified_time =? ", new String[]{Long.toString(j), Long.toString(j2)});
    }

    private String m23466a() {
        return "start_time =? and end_time =? and client_id =? ";
    }

    public List<HiHealthData> m23473a(int i, List<Integer> list, int i2) {
        int size = list.size();
        String[] strArr = new String[(size + 2)];
        strArr[0] = Integer.toString(i);
        strArr[1] = Integer.toString(0);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("sync_status").append(" =? ");
        C4843h.m23387a("type_id", (List) list, size, stringBuffer, strArr, 2);
        return C4841f.m23362d(this.f17825a.mo4568a(stringBuffer.toString(), strArr, null, null, "start_time DESC  limit 0 ," + i2));
    }

    public List<HiHealthData> m23472a(int i, int i2, int i3, int i4, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(0)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("sync_status").append(" =? ");
        return C4839d.m23341c(this.f17825a.mo4568a(stringBuffer.toString(), strArr, null, null, C4843h.m23381a("start_time", i2, i3, i4)), str);
    }

    public List<HiHealthData> m23474b(int i, int i2, int i3, int i4, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? ");
        return C4839d.m23341c(this.f17825a.mo4568a(stringBuffer.toString(), strArr, null, null, C4843h.m23381a("start_time", i2, i3, i4)), str);
    }
}

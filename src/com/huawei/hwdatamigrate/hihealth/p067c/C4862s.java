package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.content.Context;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.ae;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4839d;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4841f;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.List;

/* compiled from: DataSessionManager */
public class C4862s {
    private static Context f17879b;
    private ae f17880a;

    private C4862s() {
        this.f17880a = ae.m23105a(f17879b);
    }

    public static C4862s m23598a(Context context) {
        f17879b = context.getApplicationContext();
        return C4864u.f17881a;
    }

    public long m23604a(HiHealthData hiHealthData, int i, int i2) {
        return this.f17880a.mo4566a(C4836a.m23320c(hiHealthData, i, i2));
    }

    private int m23602d(HiHealthData hiHealthData, int i, int i2) {
        ContentValues c = C4836a.m23319c(hiHealthData, i2);
        if (hiHealthData.getSyncStatus() == 1) {
            c.remove("sync_status");
        }
        return this.f17880a.mo4565a(c, m23599a(), m23601c(hiHealthData.getStartTime(), hiHealthData.getEndTime(), i));
    }

    public int m23603a(long j, long j2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(i));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return this.f17880a.mo4565a(contentValues, "_id =? and modified_time =? ", new String[]{Long.toString(j), Long.toString(j2)});
    }

    public int m23606b(HiHealthData hiHealthData, int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(i2));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return this.f17880a.mo4565a(contentValues, m23599a(), m23601c(hiHealthData.getStartTime(), hiHealthData.getEndTime(), i));
    }

    private boolean m23600b(long j, long j2, int i) {
        return C4841f.m23368f(this.f17880a.mo4568a(m23599a(), m23601c(j, j2, i), null, null, null));
    }

    public boolean m23608c(HiHealthData hiHealthData, int i, int i2) {
        long d;
        if (m23600b(hiHealthData.getStartTime(), hiHealthData.getEndTime(), i)) {
            d = (long) m23602d(hiHealthData, i, i2);
        } else {
            d = m23604a(hiHealthData, i, i2);
        }
        return C4843h.m23395a(d);
    }

    private String[] m23601c(long j, long j2, int i) {
        return new String[]{Long.toString(j), Long.toString(j2), Integer.toString(i)};
    }

    private String m23599a() {
        return "start_time =? and end_time =? and client_id =? ";
    }

    public List<HiHealthData> m23605a(int i, int i2, int i3, int i4, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(0)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("sync_status").append(" =? ");
        return C4839d.m23342d(this.f17880a.mo4568a(stringBuffer.toString(), strArr, null, null, C4843h.m23381a("start_time", i2, i3, i4)), str);
    }

    public List<HiHealthData> m23607b(int i, int i2, int i3, int i4, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? ");
        return C4839d.m23342d(this.f17880a.mo4568a(stringBuffer.toString(), strArr, null, null, C4843h.m23381a("start_time", i2, i3, i4)), str);
    }
}

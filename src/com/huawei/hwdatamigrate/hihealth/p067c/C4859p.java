package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.ab;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4839d;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4841f;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4842g;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.List;

/* compiled from: DataSequenceManager */
public class C4859p {
    private static Context f17876b;
    private ab f17877a;

    private C4859p() {
        this.f17877a = ab.m23083a(f17876b);
    }

    public static C4859p m23582a(@NonNull Context context) {
        f17876b = context.getApplicationContext();
        return C4861r.f17878a;
    }

    public long m23588a(HiHealthData hiHealthData, int i, int i2) {
        return this.f17877a.mo4566a(C4836a.m23324e(hiHealthData, i, i2));
    }

    private int m23586d(HiHealthData hiHealthData, int i, int i2) {
        ContentValues e = C4836a.m23323e(hiHealthData, i2);
        if (hiHealthData.getSyncStatus() == 1) {
            e.remove("sync_status");
        }
        return this.f17877a.mo4565a(e, m23583a(), m23585b(hiHealthData.getStartTime(), hiHealthData.getEndTime(), hiHealthData.getType(), i));
    }

    public long m23595b(HiHealthData hiHealthData, int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("merged", Integer.valueOf(i2));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return (long) this.f17877a.mo4565a(contentValues, m23583a(), m23585b(hiHealthData.getStartTime(), hiHealthData.getEndTime(), hiHealthData.getType(), i));
    }

    private boolean m23584a(long j, long j2, int i, int i2) {
        return C4841f.m23368f(this.f17877a.mo4568a(m23583a(), m23585b(j, j2, i, i2), null, null, null));
    }

    public boolean m23597c(HiHealthData hiHealthData, int i, int i2) {
        long d;
        if (m23584a(hiHealthData.getStartTime(), hiHealthData.getEndTime(), hiHealthData.getType(), i)) {
            d = (long) m23586d(hiHealthData, i, i2);
        } else {
            d = m23588a(hiHealthData, i, i2);
        }
        return C4843h.m23395a(d);
    }

    private String m23583a() {
        return "start_time =? and end_time =? and type_id =? and client_id =? ";
    }

    private String[] m23585b(long j, long j2, int i, int i2) {
        return new String[]{Long.toString(j), Long.toString(j2), Integer.toString(i), Integer.toString(i2)};
    }

    public List<HiHealthData> m23591a(List<Integer> list, long j, int i) {
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("start_time").append(" =? and ").append("type_id").append(" =? ");
        String[] strArr = new String[(size + 2)];
        strArr[0] = Long.toString(j);
        strArr[1] = Integer.toString(i);
        C4843h.m23387a(WBConstants.AUTH_PARAMS_CLIENT_ID, (List) list, size, stringBuffer, strArr, 2);
        return C4842g.m23373b(this.f17877a.m23093b(stringBuffer.toString(), strArr, null, null, null));
    }

    public List<String> m23592a(List<Integer> list, long j, long j2, int i) {
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("start_time").append(" >=? and ").append("start_time").append(" <=? and ").append("merged").append(" =? and ").append("type_id").append(" =? ");
        String[] strArr = new String[(size + 4)];
        strArr[0] = Long.toString(j);
        strArr[1] = Long.toString(j2);
        strArr[2] = Integer.toString(0);
        strArr[3] = Integer.toString(i);
        C4843h.m23387a(WBConstants.AUTH_PARAMS_CLIENT_ID, (List) list, size, stringBuffer, strArr, 4);
        return C4842g.m23370a(this.f17877a.m23093b(stringBuffer.toString(), strArr, null, null, null));
    }

    public List<HiHealthData> m23589a(int i, int i2, int i3, int i4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("type_id").append(" =? and ").append("sync_status").append(" =? ");
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("start_time").append(" limit ").append("0,").append(i4);
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)};
        return C4841f.m23354a(this.f17877a.mo4568a(stringBuffer.toString(), strArr, null, null, stringBuffer2.toString()), true);
    }

    public boolean m23593a(long j, long j2) {
        return C4841f.m23368f(this.f17877a.mo4568a("_id =? and modified_time =? ", new String[]{Long.toString(j), Long.toString(j2)}, null, null, null));
    }

    public int m23594b(long j, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(1));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("_id").append(" =? and ").append("modified_time").append(" =? ");
        return this.f17877a.mo4565a(contentValues, stringBuffer.toString(), new String[]{Long.toString(j), Long.toString(j2)});
    }

    public List<HiHealthData> m23590a(int i, int i2, int i3, int i4, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(0)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("sync_status").append(" =? ");
        return C4839d.m23340b(this.f17877a.mo4568a(stringBuffer.toString(), strArr, null, null, C4843h.m23381a("start_time", i2, i3, i4)), str);
    }

    public List<HiHealthData> m23596b(int i, int i2, int i3, int i4, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? ");
        return C4839d.m23340b(this.f17877a.mo4568a(stringBuffer.toString(), strArr, null, null, C4843h.m23381a("start_time", i2, i3, i4)), str);
    }

    public int m23587a(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(1));
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(0)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("sync_status").append(" =? ");
        return this.f17877a.mo4565a(contentValues, stringBuffer.toString(), strArr);
    }
}

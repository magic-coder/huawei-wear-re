package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.content.Context;
import com.huawei.hihealth.HiDataReadOption;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.ak;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4841f;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.List;

/* compiled from: HealthDataSessionManager */
public class ah {
    private static Context f17818b;
    private ak f17819a;

    private ah() {
        this.f17819a = ak.m23113a(f17818b);
    }

    public static ah m23444a(Context context) {
        f17818b = context.getApplicationContext();
        return aj.f17820a;
    }

    public List<HiHealthData> m23452a(long j, long j2, List<Integer> list) {
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[(size + 2)];
        stringBuffer.append("start_time").append(" =? and ").append("end_time").append(" =? ");
        strArr[0] = Long.toString(j);
        strArr[1] = Long.toString(j2);
        C4843h.m23387a(WBConstants.AUTH_PARAMS_CLIENT_ID, (List) list, size, stringBuffer, strArr, 2);
        stringBuffer.append(" ORDER BY ").append("start_time").append(" ASC ");
        return C4841f.m23362d(this.f17819a.mo4568a(stringBuffer.toString(), strArr, null, null, null));
    }

    public long m23450a(HiHealthData hiHealthData, int i, int i2) {
        return this.f17819a.mo4566a(C4836a.m23322d(hiHealthData, i, i2));
    }

    public List<HiHealthData> m23453a(HiDataReadOption hiDataReadOption, List<Integer> list, List<Integer> list2) {
        int size = list.size();
        int size2 = list2.size();
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[((size + size2) + 3)];
        stringBuffer.append("start_time").append(" >=? and ").append("start_time").append(" <=? and ").append("merged").append(" =? ");
        strArr[0] = Long.toString(hiDataReadOption.getStartTime());
        strArr[1] = Long.toString(hiDataReadOption.getEndTime());
        strArr[2] = Integer.toString(0);
        C4843h.m23387a(WBConstants.AUTH_PARAMS_CLIENT_ID, (List) list, size, stringBuffer, strArr, 3);
        C4843h.m23387a("type_id", (List) list2, size2, stringBuffer, strArr, size + 3);
        return C4841f.m23362d(this.f17819a.mo4568a(stringBuffer.toString(), strArr, null, null, C4843h.m23381a("start_time", hiDataReadOption.getSortOrder(), hiDataReadOption.getAnchor(), hiDataReadOption.getCount())));
    }

    private int m23447c(HiHealthData hiHealthData, int i, int i2) {
        ContentValues d = C4836a.m23321d(hiHealthData, i2);
        if (hiHealthData.getSyncStatus() == 1) {
            d.remove("sync_status");
        }
        return this.f17819a.mo4565a(d, m23445a(), m23446b(hiHealthData.getStartTime(), hiHealthData.getEndTime(), i));
    }

    public int m23449a(long j, long j2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(i));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return this.f17819a.mo4565a(contentValues, "_id =? and modified_time =? ", new String[]{Long.toString(j), Long.toString(j2)});
    }

    public boolean m23454b(HiHealthData hiHealthData, int i, int i2) {
        long c;
        if (m23448c(hiHealthData.getStartTime(), hiHealthData.getEndTime(), i)) {
            c = (long) m23447c(hiHealthData, i, i2);
        } else {
            c = m23450a(hiHealthData, i, i2);
        }
        return C4843h.m23395a(c);
    }

    private String[] m23446b(long j, long j2, int i) {
        return new String[]{Long.toString(j), Long.toString(j2), Integer.toString(i)};
    }

    private boolean m23448c(long j, long j2, int i) {
        return C4841f.m23368f(this.f17819a.mo4568a(m23445a(), m23446b(j, j2, i), null, null, null));
    }

    private String m23445a() {
        return "start_time =? and end_time =? and client_id =? ";
    }

    public List<HiHealthData> m23451a(int i, List<Integer> list, int i2) {
        int size = list.size();
        String[] strArr = new String[(size + 2)];
        strArr[0] = Integer.toString(i);
        strArr[1] = Integer.toString(0);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("sync_status").append(" =? ");
        C4843h.m23387a("type_id", (List) list, size, stringBuffer, strArr, 2);
        return C4841f.m23362d(this.f17819a.mo4568a(stringBuffer.toString(), strArr, null, null, "start_time DESC  limit 0 ," + i2));
    }
}

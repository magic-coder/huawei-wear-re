package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hihealth.HiDataReadOption;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4834y;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4841f;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.List;

/* compiled from: HealthDataPointManager */
public class ae {
    private static Context f17815b;
    private C4834y f17816a;

    private ae() {
        this.f17816a = C4834y.m23297a(f17815b);
    }

    public static ae m23430a(@NonNull Context context) {
        f17815b = context.getApplicationContext();
        return ag.f17817a;
    }

    public long m23437a(HiHealthData hiHealthData, int i, int i2) {
        return this.f17816a.mo4566a(C4836a.m23315b(hiHealthData, i, i2));
    }

    public void m23441a(long[] jArr) {
        for (long a : jArr) {
            m23435a(a);
        }
    }

    public int m23435a(long j) {
        String[] strArr = new String[]{Long.toString(j)};
        return this.f17816a.mo4570b("_id =? ", strArr);
    }

    public List<HiHealthData> m23440a(HiDataReadOption hiDataReadOption, int i, List<Integer> list) {
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[(size + 4)];
        stringBuffer.append("start_time").append(" >=? and ").append("start_time").append(" <=? and ").append("type_id").append(" =? and ").append("merged").append(" =? ");
        strArr[0] = Long.toString(hiDataReadOption.getStartTime());
        strArr[1] = Long.toString(hiDataReadOption.getEndTime());
        strArr[2] = Integer.toString(i);
        strArr[3] = Integer.toString(0);
        C4843h.m23387a(WBConstants.AUTH_PARAMS_CLIENT_ID, (List) list, size, stringBuffer, strArr, 4);
        return C4841f.m23353a(this.f17816a.mo4568a(stringBuffer.toString(), strArr, null, null, C4843h.m23381a("start_time", hiDataReadOption.getSortOrder(), hiDataReadOption.getAnchor(), hiDataReadOption.getCount())), hiDataReadOption.getDeviceUUID());
    }

    public List<HiHealthData> m23439a(long j, long j2, int i, List<Integer> list) {
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[(size + 3)];
        stringBuffer.append("start_time").append(" =? and ").append("end_time").append(" =? and ").append("type_id").append(" =? ");
        strArr[0] = Long.toString(j);
        strArr[1] = Long.toString(j2);
        strArr[2] = Integer.toString(i);
        C4843h.m23387a(WBConstants.AUTH_PARAMS_CLIENT_ID, (List) list, size, stringBuffer, strArr, 3);
        return C4841f.m23352a(this.f17816a.mo4568a(stringBuffer.toString(), strArr, null, null, null));
    }

    public int m23442b(HiHealthData hiHealthData, int i, int i2) {
        ContentValues b = C4836a.m23314b(hiHealthData, i2);
        if (hiHealthData.getSyncStatus() == 1) {
            b.remove("sync_status");
        }
        return this.f17816a.mo4565a(b, m23431a(), m23433b(hiHealthData.getStartTime(), hiHealthData.getEndTime(), hiHealthData.getType(), i));
    }

    private boolean m23432a(long j, long j2, int i, int i2) {
        return C4841f.m23368f(this.f17816a.mo4568a(m23431a(), m23433b(j, j2, i, i2), null, null, null));
    }

    public boolean m23443c(HiHealthData hiHealthData, int i, int i2) {
        long b;
        if (m23432a(hiHealthData.getStartTime(), hiHealthData.getEndTime(), hiHealthData.getType(), i)) {
            b = (long) m23442b(hiHealthData, i, i2);
        } else {
            b = m23437a(hiHealthData, i, i2);
        }
        return C4843h.m23395a(b);
    }

    private String[] m23433b(long j, long j2, int i, int i2) {
        return new String[]{Long.toString(j), Long.toString(j2), Integer.toString(i), Integer.toString(i2)};
    }

    private String m23431a() {
        return "start_time =? and end_time =? and type_id =? and client_id =? ";
    }

    public List<HiHealthData> m23438a(int i, List<Integer> list, int i2) {
        int size = list.size();
        String[] strArr = new String[(size + 2)];
        strArr[0] = Integer.toString(i);
        strArr[1] = Integer.toString(0);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("sync_status").append(" =? ");
        C4843h.m23387a("type_id", (List) list, size, stringBuffer, strArr, 2);
        return C4841f.m23356b(this.f17816a.mo4568a(stringBuffer.toString(), strArr, null, null, "start_time DESC  limit 0 ," + i2));
    }

    public int m23436a(long j, long j2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(i));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return this.f17816a.mo4565a(contentValues, "_id =? and modified_time =? ", new String[]{Long.toString(j), Long.toString(j2)});
    }

    public int m23434a(int i, long j, long j2, int i2, int i3) {
        String[] strArr = new String[]{Integer.toString(i), Long.toString(j), Long.toString(j2), Integer.toString(i2)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(i3));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return this.f17816a.mo4565a(contentValues, "client_id =? and start_time =? and end_time =? and type_id =? ", strArr);
    }
}

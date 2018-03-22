package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4831v;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4842g;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.List;

/* compiled from: DataPointManager */
public class C4856m {
    private static Context f17873b;
    private C4831v f17874a;

    private C4856m() {
        this.f17874a = C4831v.m23292a(f17873b);
    }

    public static C4856m m23573a(@NonNull Context context) {
        f17873b = context.getApplicationContext();
        return C4858o.f17875a;
    }

    public long m23579a(HiHealthData hiHealthData, int i, int i2) {
        return this.f17874a.mo4566a(C4836a.m23307a(hiHealthData, i, i2));
    }

    public int m23577a(long j, long j2, int i, int i2, int i3) {
        return this.f17874a.mo4565a(C4836a.m23301a(i3), m23574a(), m23575b(j, j2, i, i2));
    }

    public int m23578a(long j, long j2, int i, List<Integer> list, int i2) {
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[(size + 4)];
        stringBuffer.append("start_time").append(" >=? and ").append("start_time").append(" <=? and ").append("type_id").append(" =? and ").append("merged").append("!=?");
        strArr[0] = Long.toString(j);
        strArr[1] = Long.toString(j2);
        strArr[2] = Integer.toString(i);
        strArr[3] = Integer.toString(i2);
        C4843h.m23387a(WBConstants.AUTH_PARAMS_CLIENT_ID, (List) list, size, stringBuffer, strArr, 4);
        return this.f17874a.mo4565a(C4836a.m23301a(i2), stringBuffer.toString(), strArr);
    }

    public int m23581b(HiHealthData hiHealthData, int i, int i2) {
        ContentValues a = C4836a.m23306a(hiHealthData, i2);
        if (hiHealthData.getSyncStatus() == 1) {
            a.remove("sync_status");
        }
        return this.f17874a.mo4565a(a, m23574a(), m23575b(hiHealthData.getStartTime(), hiHealthData.getEndTime(), hiHealthData.getType(), i));
    }

    public Double m23580a(long j, long j2, int i, int i2) {
        return C4842g.m23369a(this.f17874a.mo4568a(m23574a(), m23575b(j, j2, i, i2), null, null, null), "value");
    }

    private String[] m23575b(long j, long j2, int i, int i2) {
        return new String[]{Long.toString(j), Long.toString(j2), Integer.toString(i), Integer.toString(i2)};
    }

    private String m23574a() {
        return "start_time =? and end_time =? and type_id =? and client_id =? ";
    }

    public int m23576a(int i, long j, long j2, int i2, int i3) {
        String[] strArr = new String[]{Integer.toString(i), Long.toString(j), Long.toString(j2), Integer.toString(i2)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(i3));
        contentValues.put("modified_time", Long.valueOf(System.currentTimeMillis()));
        return this.f17874a.mo4565a(contentValues, "client_id =? and start_time =? and end_time =? and type_id =? ", strArr);
    }
}

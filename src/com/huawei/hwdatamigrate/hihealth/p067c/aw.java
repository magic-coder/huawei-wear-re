package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4834y;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4839d;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4841f;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.List;

/* compiled from: MHealthDataPointManager */
public class aw {
    private static Context f17833b;
    private C4834y f17834a;

    private aw() {
        this.f17834a = C4834y.m23297a(f17833b);
    }

    public static aw m23483a(@NonNull Context context) {
        f17833b = context.getApplicationContext();
        return ay.f17835a;
    }

    public List<HiHealthData> m23486a(int i, int i2, List<Integer> list) {
        int size = list.size();
        String[] strArr = new String[(size + 2)];
        strArr[0] = Integer.toString(i);
        strArr[1] = Integer.toString(i2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("type_id").append(" =? and ").append("sync_status").append(" =? ");
        C4843h.m23387a(WBConstants.AUTH_PARAMS_CLIENT_ID, (List) list, size, stringBuffer, strArr, 2);
        return C4841f.m23352a(this.f17834a.mo4568a(stringBuffer.toString(), strArr, null, null, null));
    }

    public List<HiHealthData> m23485a(int i, int i2, int i3, int i4, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(0)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("sync_status").append(" =? ");
        return C4839d.m23337a(this.f17834a.mo4568a(stringBuffer.toString(), strArr, null, null, C4843h.m23381a("start_time", i2, i3, i4)), str);
    }

    public List<HiHealthData> m23487b(int i, int i2, int i3, int i4, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? ");
        return C4839d.m23337a(this.f17834a.mo4568a(stringBuffer.toString(), strArr, null, null, C4843h.m23381a("start_time", i2, i3, i4)), str);
    }

    public int m23484a(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(1));
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(0)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("sync_status").append(" =? ");
        return this.f17834a.mo4565a(contentValues, stringBuffer.toString(), strArr);
    }
}

package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4831v;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4841f;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.List;

/* compiled from: MDataPointManager */
public class aq {
    private static Context f17827b;
    private C4831v f17828a;

    private aq() {
        this.f17828a = C4831v.m23292a(f17827b);
    }

    public static aq m23476a(@NonNull Context context) {
        f17827b = context.getApplicationContext();
        return as.f17829a;
    }

    public List<HiHealthData> m23478a(int i, int i2, int i3, int i4, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(0)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("sync_status").append(" =? ");
        return C4841f.m23353a(this.f17828a.mo4568a(stringBuffer.toString(), strArr, null, null, C4843h.m23381a("start_time", i2, i3, i4)), str);
    }

    public List<HiHealthData> m23479b(int i, int i2, int i3, int i4, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? ");
        return C4841f.m23353a(this.f17828a.mo4568a(stringBuffer.toString(), strArr, null, null, C4843h.m23381a("start_time", i2, i3, i4)), str);
    }

    public int m23477a(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(1));
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(0)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("sync_status").append(" =? ");
        return this.f17828a.mo4565a(contentValues, stringBuffer.toString(), strArr);
    }
}

package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.content.Context;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.ae;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4841f;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.List;

/* compiled from: MDataSessionManager */
public class at {
    private static Context f17830b;
    private ae f17831a;

    private at() {
        this.f17831a = ae.m23105a(f17830b);
    }

    public static at m23480a(Context context) {
        f17830b = context.getApplicationContext();
        return av.f17832a;
    }

    public List<HiHealthData> m23482a(long j, long j2, List<Integer> list) {
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[(size + 2)];
        stringBuffer.append("start_time").append(" =? and ").append("end_time").append(" =? ");
        strArr[0] = Long.toString(j);
        strArr[1] = Long.toString(j2);
        C4843h.m23387a(WBConstants.AUTH_PARAMS_CLIENT_ID, (List) list, size, stringBuffer, strArr, 2);
        stringBuffer.append(" ORDER BY ").append("start_time").append(" ASC ");
        return C4841f.m23359c(this.f17831a.mo4568a(stringBuffer.toString(), strArr, null, null, null));
    }

    public int m23481a(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(1));
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(0)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("sync_status").append(" =? ");
        return this.f17831a.mo4565a(contentValues, stringBuffer.toString(), strArr);
    }
}

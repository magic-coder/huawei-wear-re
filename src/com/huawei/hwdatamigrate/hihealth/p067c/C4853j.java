package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.content.Context;
import com.huawei.hihealth.HiDataReadOption;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.ah;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4841f;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.List;

/* compiled from: DataCoreSessionManager */
public class C4853j {
    private static Context f17870b;
    private ah f17871a;

    private C4853j() {
        this.f17871a = ah.m23109a(f17870b);
    }

    public List<HiHealthData> m23571a(long j, long j2, List<Integer> list) {
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[(size + 2)];
        stringBuffer.append("start_time").append(" =? and ").append("end_time").append(" =? ");
        strArr[0] = Long.toString(j);
        strArr[1] = Long.toString(j2);
        C4843h.m23387a(WBConstants.AUTH_PARAMS_CLIENT_ID, (List) list, size, stringBuffer, strArr, 2);
        stringBuffer.append(" ORDER BY ").append("start_time").append(" ASC ");
        return C4841f.m23362d(this.f17871a.mo4568a(stringBuffer.toString(), strArr, null, null, null));
    }

    public static C4853j m23568a(Context context) {
        f17870b = context.getApplicationContext();
        return C4855l.f17872a;
    }

    public long m23570a(HiHealthData hiHealthData, int i, int i2) {
        return this.f17871a.mo4566a(C4836a.m23322d(hiHealthData, i, i2));
    }

    public List<HiHealthData> m23572a(HiDataReadOption hiDataReadOption, List<Integer> list, int i, int i2) {
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[(size + 5)];
        stringBuffer.append("start_time").append(" >=? and ").append("start_time").append(" <=? and ").append("type_id").append(" >=? and ").append("type_id").append(" <=? and ").append("merged").append(" =? ");
        strArr[0] = Long.toString(hiDataReadOption.getStartTime());
        strArr[1] = Long.toString(hiDataReadOption.getEndTime());
        strArr[2] = Integer.toString(i);
        strArr[3] = Integer.toString(i2);
        strArr[4] = Integer.toString(0);
        C4843h.m23387a(WBConstants.AUTH_PARAMS_CLIENT_ID, (List) list, size, stringBuffer, strArr, 5);
        return C4841f.m23362d(this.f17871a.mo4568a(stringBuffer.toString(), strArr, null, null, C4843h.m23381a("start_time", hiDataReadOption.getSortOrder(), hiDataReadOption.getAnchor(), hiDataReadOption.getCount())));
    }

    public int m23569a(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(1));
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(0)};
        stringBuffer.append(WBConstants.AUTH_PARAMS_CLIENT_ID).append(" =? and ").append("sync_status").append(" =? ");
        return this.f17871a.mo4565a(contentValues, stringBuffer.toString(), strArr);
    }
}

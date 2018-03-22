package com.huawei.hwdatamigrate.hihealth.sync.p420b;

import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hwcloudmodel.model.unite.MotionPathDetail;
import com.huawei.hwdatamigrate.hihealth.sync.a.h;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MotionPathDataSwitch */
public class C4954f {
    private C4955g f18032a = new C4955g(this.f18034c);
    private C4951c f18033b = new C4951c(this.f18034c);
    private Context f18034c;

    public C4954f(@NonNull Context context) {
        this.f18034c = context.getApplicationContext();
    }

    public List<HiHealthData> m23835a(List<MotionPathDetail> list, int i, int i2) throws h {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<HiHealthData> arrayList = new ArrayList();
        for (MotionPathDetail motionPathDetail : list) {
            if (motionPathDetail != null) {
                HiHealthData a = this.f18033b.m23823a(motionPathDetail, i, i2);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        }
        return arrayList;
    }

    public List<MotionPathDetail> m23834a(List<HiHealthData> list, int i) {
        switch (i) {
            case 2:
                return this.f18032a.m23837a((List) list);
            case 3:
                return this.f18032a.m23839b(list);
            default:
                C2538c.d("Debug_MotionPathDataSwitch", new Object[]{"localTrackToCloud no such hiSyncModel"});
                return null;
        }
    }
}

package com.huawei.openalliance.ad.p112a.p125g;

import android.content.Context;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.utils.db.C1357a;
import com.huawei.openalliance.ad.utils.db.bean.AdEventRecord;
import com.huawei.openalliance.ad.utils.db.bean.ThirdPartyEventRecord;

public class C1281e extends C1277a {
    public void mo2441a(Context context) {
        if (C1287e.m5689d() - 172800000 > 0) {
            C1357a a = C1357a.m5982a(context);
            a.m5987a(ThirdPartyEventRecord.class.getSimpleName(), " time < ? and adType = ?", new String[]{String.valueOf(r0), String.valueOf(1)});
            a.m5987a(AdEventRecord.class.getSimpleName(), " time < ? and adType = ?", new String[]{String.valueOf(r0), String.valueOf(1)});
            a.close();
        }
    }
}

package com.huawei.pluginkidwatch.common.entity.p143c;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.UploadTMIDIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1496p;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.sina.weibo.sdk.statistic.StatisticConfig;

/* compiled from: TmidUtil */
public class C1450e {
    private long f3332a = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private long f3333b = 10;

    public void m6689a(Context context, String str) {
        C2538c.m12674b("TmidUtil", "=========Enter uploadTMID===");
        C1496p.m6934a(context, "k1pushtokenflag", Boolean.valueOf(true));
        C1462f.m6738f(str);
        C1497q.m6943a(context, "push_access_token", str);
        new C1451f(this, context).start();
    }

    private void m6686a(Context context) {
        UploadTMIDIOEntityModel uploadTMIDIOEntityModel = new UploadTMIDIOEntityModel();
        uploadTMIDIOEntityModel.tmid = C1462f.m6756p();
        C1417a.m6594a(context).mo2500a(uploadTMIDIOEntityModel, new C1452g(this, context));
    }
}

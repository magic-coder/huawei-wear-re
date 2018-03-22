package com.huawei.openalliance.ad.p112a.p121e;

import android.content.Context;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.openalliance.ad.p112a.p113a.C1240g;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1212b;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1213c;
import com.huawei.openalliance.ad.p112a.p122h.C1250f;
import com.huawei.openalliance.ad.utils.db.C1357a;
import com.huawei.openalliance.ad.utils.db.bean.ThirdPartyEventRecord;
import com.huawei.openalliance.ad.utils.p129b.C1336d;

final class C1251c implements C1250f {
    final /* synthetic */ int f2668a;

    C1251c(int i) {
        this.f2668a = i;
    }

    public void mo2429a() {
    }

    public void mo2430a(Context context, C1212b c1212b, C1213c c1213c) {
        if (!(!(c1212b instanceof C1240g) || c1213c.responseCode == HttpStatus.SC_MOVED_TEMPORARILY || c1213c.responseCode == 200)) {
            C1240g c1240g = (C1240g) c1212b;
            C1357a a = C1357a.m5982a(context);
            try {
                a.m5988a(ThirdPartyEventRecord.class.getSimpleName(), new ThirdPartyEventRecord(this.f2668a, c1240g.getUrl()).m6004u());
            } catch (Exception e) {
                C1336d.m5888c("AdEventManager", "insert third party event fail");
            } finally {
                a.close();
            }
        }
        C1249b.m5540b(context, this.f2668a);
    }

    public void mo2431b() {
    }
}

package com.huawei.hwdatamigrate.hihealth.sync.p071c;

import android.content.Context;
import com.huawei.hihealth.HiSyncOption;
import com.huawei.hihealth.p394c.C4543e;
import com.huawei.hwcloudmodel.mgr.C4710a;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.hwcloudmodel.model.unite.GetSleepStatReq;
import com.huawei.hwcloudmodel.model.unite.GetSleepStatRsp;
import com.huawei.hwcloudmodel.model.unite.SleepTotal;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdatamigrate.hihealth.p067c.bm;
import com.huawei.hwdatamigrate.hihealth.p416h.C4924a;
import com.huawei.hwdatamigrate.hihealth.sync.a.h;
import com.huawei.hwdatamigrate.hihealth.sync.p070a.C4948g;
import com.huawei.hwdatamigrate.hihealth.sync.p420b.C4956h;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: HiSyncSleepStatUtil */
public class C4967l {
    private C4710a f18055a = C4710a.m22540a(BaseApplication.b());
    private HiSyncOption f18056b;
    private Context f18057c;
    private int f18058d;

    public C4967l(Context context, HiSyncOption hiSyncOption, int i) {
        this.f18057c = context.getApplicationContext();
        this.f18058d = i;
        this.f18056b = hiSyncOption;
    }

    public void m23880a(int i, int i2, bm bmVar, C4956h c4956h) throws h {
        if (i > i2 || i <= 0) {
            C2538c.d("Debug_HiSyncSleepStatUtil", new Object[]{"downloadSleepStatByTime the time is not right"});
            return;
        }
        C2538c.c("Debug_HiSyncSleepStatUtil", new Object[]{"downloadSleepStatByTime startTime is ", Integer.valueOf(i), " , endDay is ", Integer.valueOf(i2)});
        CloudCommonReponse a = m23877a(i, i2);
        if (C4948g.m23815a(a, false)) {
            List sleepTotals = a.getSleepTotals();
            bmVar.m23526a(this.f18058d, this.f18056b.getSyncDataType(), i2, 0);
            if (sleepTotals == null || sleepTotals.isEmpty()) {
                C2538c.d("Debug_HiSyncSleepStatUtil", new Object[]{"downloadSleepStatByTime sleepStats is null or empty"});
                return;
            }
            m23879a(sleepTotals, c4956h);
        }
    }

    private void m23879a(List<SleepTotal> list, C4956h c4956h) {
        for (SleepTotal a : list) {
            m23878a(a, c4956h);
        }
    }

    private GetSleepStatRsp m23877a(int i, int i2) {
        GetSleepStatReq getSleepStatReq = new GetSleepStatReq();
        getSleepStatReq.setStartTime(Integer.valueOf(i));
        getSleepStatReq.setEndTime(Integer.valueOf(i2));
        getSleepStatReq.setDataSource(Integer.valueOf(2));
        return this.f18055a.m22551a(getSleepStatReq);
    }

    private void m23878a(SleepTotal sleepTotal, C4956h c4956h) {
        C2538c.c("Debug_HiSyncSleepStatUtil", new Object[]{"saveStatToDB cloudSleepStat is ", C4543e.m21779a(sleepTotal)});
        List a = c4956h.m23842a(sleepTotal, this.f18058d);
        if (a != null && !a.isEmpty()) {
            C4924a.m23743a(this.f18057c).m23753a(a);
        }
    }
}

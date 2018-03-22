package com.huawei.hwdatamigrate.hihealth.p416h.p418b;

import android.content.Context;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.data.model.HiTrackMetaData;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hihealth.p394c.C4543e;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwdatamigrate.hihealth.p067c.C4859p;
import com.huawei.hwdatamigrate.hihealth.p068d.C4880l;
import com.huawei.hwdatamigrate.hihealth.p068d.C4883o;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: HiTrackStat */
public class C4931g extends C4925f {
    private C4859p f18014c;
    private C4883o f18015d = C4883o.m23650a(this.b);
    private C4880l f18016e = C4880l.m23643a(this.b);

    public C4931g(Context context) {
        super(context);
        this.f18014c = C4859p.m23582a(context);
    }

    public boolean m23794a(HiHealthData hiHealthData) {
        long currentTimeMillis = System.currentTimeMillis();
        int userID = hiHealthData.getUserID();
        C2538c.c("Debug_HiTrackStat", new Object[]{"stat() trackData = ", Long.valueOf(hiHealthData.getDay()), ",startTime = ", Long.valueOf(C4540b.m21754b(hiHealthData.getStartTime())), ",endTime = ", Long.valueOf(C4540b.m21756d(hiHealthData.getStartTime()))});
        int type = hiHealthData.getType();
        List a = this.f18016e.m23646a(userID);
        if (a == null || a.isEmpty()) {
            C2538c.d("Debug_HiTrackStat", new Object[]{"stat() clientIds is null"});
            return false;
        }
        m23792a(this.f18014c.m23592a(a, r2, r4, type), hiHealthData, userID, this.f18015d.m23656b(0, userID, 0));
        C2538c.b("Debug_HiTrackStat", new Object[]{"stat() totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return true;
    }

    private void m23792a(List<String> list, HiHealthData hiHealthData, int i, int i2) {
        if (i2 <= 0) {
            C2538c.d("Debug_HiTrackStat", new Object[]{"statDayTrack userClient <= 0"});
        } else if (list == null || list.isEmpty()) {
            C2538c.d("Debug_HiTrackStat", new Object[]{"statDayTrack sequenceMetaDatas is null"});
        } else {
            C2538c.c("Debug_HiTrackStat", new Object[]{"statDayTrack sequenceMetaDatas = ", Integer.valueOf(list.size()), ",statClient = ", Integer.valueOf(i2)});
            double d = 0.0d;
            double d2 = 0.0d;
            double d3 = 0.0d;
            double d4 = 0.0d;
            for (String a : list) {
                HiTrackMetaData hiTrackMetaData = (HiTrackMetaData) C4543e.m21777a(a, HiTrackMetaData.class);
                d += (double) hiTrackMetaData.getTotalCalories();
                d2 = ((double) hiTrackMetaData.getAvgPace()) + d2;
                d3 = ((double) hiTrackMetaData.getTotalTime()) + d3;
                d4 += (double) hiTrackMetaData.getTotalDistance();
            }
            int a2 = C4540b.m21750a(hiHealthData.getStartTime());
            int syncStatus = hiHealthData.getSyncStatus();
            m23793a(a2, 42002, i, i2, syncStatus, d, 3);
            m23793a(a2, 42003, i, i2, syncStatus, d4, 2);
            m23793a(a2, 42001, i, i2, syncStatus, d3, 13);
            m23793a(a2, 42004, i, i2, syncStatus, d2, 14);
            m23793a(a2, 42005, i, i2, syncStatus, (double) list.size(), 16);
        }
    }

    private boolean m23793a(int i, int i2, int i3, int i4, int i5, double d, int i6) {
        C2538c.c("Debug_HiTrackStat", new Object[]{"saveOneTrackStat statDate = ", Integer.valueOf(i), ",statClient = ", Integer.valueOf(i4), ", statType = ", Integer.valueOf(i2), ",statValue = ", Double.valueOf(d)});
        if (d <= 0.0d) {
            return false;
        }
        C4807a c4807a = new C4807a();
        c4807a.m23027a(i);
        c4807a.m23031b((int) PayStatusCodes.PAY_STATE_PARAM_ERROR);
        c4807a.m23038e(i4);
        c4807a.m23036d(i3);
        c4807a.m23042g(i5);
        c4807a.m23040f(i6);
        c4807a.m23034c(i2);
        c4807a.m23026a(d);
        return this.a.m23618a(c4807a);
    }
}

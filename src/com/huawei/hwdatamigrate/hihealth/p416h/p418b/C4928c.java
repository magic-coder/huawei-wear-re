package com.huawei.hwdatamigrate.hihealth.p416h.p418b;

import android.content.Context;
import com.huawei.hihealth.HiDataReadOption;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hwdatamigrate.hihealth.p067c.ae;
import com.huawei.hwdatamigrate.hihealth.p067c.bj;
import com.huawei.hwdatamigrate.hihealth.p068d.C4880l;
import com.huawei.hwdatamigrate.hihealth.p068d.C4883o;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: HiRestHeartRateStat */
public class C4928c extends C4925f {
    private bj f18004c;
    private ae f18005d = ae.m23430a(this.b);
    private C4883o f18006e = C4883o.m23650a(this.b);
    private C4880l f18007f = C4880l.m23643a(this.b);

    public C4928c(Context context) {
        super(context);
        this.f18004c = bj.m23507a(context);
    }

    public boolean m23775a(HiHealthData hiHealthData) {
        C2538c.c("Debug_HiRestHeartRateStat", new Object[]{"stat() day = ", Long.valueOf(hiHealthData.getDay())});
        return m23773b(hiHealthData);
    }

    private boolean m23773b(HiHealthData hiHealthData) {
        int userID = hiHealthData.getUserID();
        int b = this.f18006e.m23656b(0, userID, 0);
        if (b <= 0) {
            C2538c.d("Debug_HiRestHeartRateStat", new Object[]{"statRestHeartRateDataByUser()  statClient <= 0 day = ", Long.valueOf(hiHealthData.getDay())});
            return false;
        }
        List a = this.f18007f.m23646a(userID);
        if (C4539a.m21749a(a)) {
            C2538c.d("Debug_HiRestHeartRateStat", new Object[]{"statRestHeartRateDataByUser()  statClients <= 0 day = ", Long.valueOf(hiHealthData.getDay())});
            return false;
        }
        long b2 = C4540b.m21754b(hiHealthData.getStartTime());
        long d = C4540b.m21756d(hiHealthData.getStartTime());
        C2538c.c("Debug_HiRestHeartRateStat", new Object[]{"stat() statHeartRateDataByUser startTime = ", Long.valueOf(b2), ",endTime = ", Long.valueOf(d)});
        C2538c.b("Debug_HiRestHeartRateStat", new Object[]{"statRestHeartRateDataByUser()  statDatas is ", this.f18004c.m23515a(a, b2, d, 3, 2018, new String[]{"rest_heart_rate_avg", "rest_heart_rate_max", "rest_heart_rate_min"}, new int[]{3, 4, 5}, 0)});
        C4807a c4807a = new C4807a();
        c4807a.m23028a(b2);
        c4807a.m23036d(userID);
        c4807a.m23042g(hiHealthData.getSyncStatus());
        c4807a.m23031b(2018);
        c4807a.m23040f(8);
        c4807a.m23038e(b);
        C2538c.b("Debug_HiRestHeartRateStat", new Object[]{"statRestHeartRateDataByUser()  statTable is ", c4807a});
        boolean a2 = m23772a(r0, c4807a);
        HiDataReadOption hiDataReadOption = new HiDataReadOption();
        hiDataReadOption.setStartTime(b2);
        hiDataReadOption.setEndTime(d);
        hiDataReadOption.setSortOrder(1);
        hiDataReadOption.setCount(1);
        C2538c.b("Debug_HiRestHeartRateStat", new Object[]{"statRestHeartRateDataByUser()  statLastDatas is ", this.f18005d.m23440a(hiDataReadOption, 2018, a)});
        return m23774b(this.f18005d.m23440a(hiDataReadOption, 2018, a), c4807a) && a2;
    }

    private boolean m23772a(List<HiHealthData> list, C4807a c4807a) {
        if (C4539a.m21749a((List) list)) {
            C2538c.d("Debug_HiRestHeartRateStat", new Object[]{"statRestHeartRateDataByUser()  statDatas is null day = ", Integer.valueOf(c4807a.m23025a())});
            return false;
        }
        HiHealthData hiHealthData = (HiHealthData) list.get(0);
        boolean z = m23771a(c4807a, hiHealthData.getDouble("rest_heart_rate_avg"), 46011) && m23771a(c4807a, hiHealthData.getDouble("rest_heart_rate_max"), 46012) && m23771a(c4807a, hiHealthData.getDouble("rest_heart_rate_min"), 46013);
        return z;
    }

    private boolean m23774b(List<HiHealthData> list, C4807a c4807a) {
        if (!C4539a.m21749a((List) list)) {
            return m23771a(c4807a, ((HiHealthData) list.get(0)).getValue(), 46014);
        }
        C2538c.d("Debug_HiRestHeartRateStat", new Object[]{"saveLastHeartRateStat()  statLastDatas is null day = ", Integer.valueOf(c4807a.m23025a())});
        return false;
    }

    private boolean m23771a(C4807a c4807a, double d, int i) {
        if (d <= 0.0d) {
            C2538c.d("Debug_HiRestHeartRateStat", new Object[]{"saveOneStat()  statValue <= 0 statType = ", Integer.valueOf(i)});
            return false;
        }
        c4807a.m23026a(d);
        c4807a.m23034c(i);
        return this.a.m23618a(c4807a);
    }
}

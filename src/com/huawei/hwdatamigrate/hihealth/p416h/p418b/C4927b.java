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

/* compiled from: HiHeartRateStat */
public class C4927b extends C4925f {
    private bj f18000c;
    private ae f18001d = ae.m23430a(this.b);
    private C4883o f18002e = C4883o.m23650a(this.b);
    private C4880l f18003f = C4880l.m23643a(this.b);

    public C4927b(Context context) {
        super(context);
        this.f18000c = bj.m23507a(context);
    }

    public boolean m23770a(HiHealthData hiHealthData) {
        C2538c.c("Debug_HiHeartRateStat", new Object[]{"stat() day = ", Long.valueOf(hiHealthData.getDay())});
        return m23768b(hiHealthData);
    }

    private boolean m23768b(HiHealthData hiHealthData) {
        int userID = hiHealthData.getUserID();
        int b = this.f18002e.m23656b(0, userID, 0);
        if (b <= 0) {
            C2538c.d("Debug_HiHeartRateStat", new Object[]{"statHeartRateDataByUser()  statClient <= 0 day = ", Long.valueOf(hiHealthData.getDay())});
            return false;
        }
        List a = this.f18003f.m23646a(userID);
        if (C4539a.m21749a(a)) {
            C2538c.d("Debug_HiHeartRateStat", new Object[]{"statHeartRateDataByUser()  statClients <= 0 day = ", Long.valueOf(hiHealthData.getDay())});
            return false;
        }
        long b2 = C4540b.m21754b(hiHealthData.getStartTime());
        long d = C4540b.m21756d(hiHealthData.getStartTime());
        C2538c.c("Debug_HiHeartRateStat", new Object[]{"stat() statHeartRateDataByUser startTime = ", Long.valueOf(b2), ",endTime = ", Long.valueOf(d)});
        C2538c.b("Debug_HiHeartRateStat", new Object[]{"statHeartRateDataByUser()  statDatas is ", this.f18000c.m23515a(a, b2, d, 3, 2002, new String[]{"heart_rate_avg", "heart_rate_max", "heart_rate_min"}, new int[]{3, 4, 5}, 0)});
        C4807a c4807a = new C4807a();
        c4807a.m23028a(b2);
        c4807a.m23036d(userID);
        c4807a.m23042g(hiHealthData.getSyncStatus());
        c4807a.m23031b(2002);
        c4807a.m23040f(8);
        c4807a.m23038e(b);
        C2538c.b("Debug_HiHeartRateStat", new Object[]{"statHeartRateDataByUser()  statTable is ", c4807a});
        boolean a2 = m23767a(r0, c4807a);
        HiDataReadOption hiDataReadOption = new HiDataReadOption();
        hiDataReadOption.setStartTime(b2);
        hiDataReadOption.setEndTime(d);
        hiDataReadOption.setSortOrder(1);
        hiDataReadOption.setCount(1);
        C2538c.b("Debug_HiHeartRateStat", new Object[]{"statHeartRateDataByUser()  statLastDatas is ", this.f18001d.m23440a(hiDataReadOption, 2002, a)});
        return m23769b(this.f18001d.m23440a(hiDataReadOption, 2002, a), c4807a) && a2;
    }

    private boolean m23767a(List<HiHealthData> list, C4807a c4807a) {
        if (C4539a.m21749a((List) list)) {
            C2538c.d("Debug_HiHeartRateStat", new Object[]{"saveHeartRateStat()  statDatas is null day = ", Integer.valueOf(c4807a.m23025a())});
            return false;
        }
        HiHealthData hiHealthData = (HiHealthData) list.get(0);
        boolean z = m23766a(c4807a, hiHealthData.getDouble("heart_rate_avg"), 46001) && m23766a(c4807a, hiHealthData.getDouble("heart_rate_max"), 46002) && m23766a(c4807a, hiHealthData.getDouble("heart_rate_min"), 46003);
        return z;
    }

    private boolean m23769b(List<HiHealthData> list, C4807a c4807a) {
        if (!C4539a.m21749a((List) list)) {
            return m23766a(c4807a, ((HiHealthData) list.get(0)).getValue(), 46004);
        }
        C2538c.d("Debug_HiHeartRateStat", new Object[]{"saveLastHeartRateStat()  statLastDatas is null day = ", Integer.valueOf(c4807a.m23025a())});
        return false;
    }

    private boolean m23766a(C4807a c4807a, double d, int i) {
        if (d <= 0.0d) {
            C2538c.d("Debug_HiHeartRateStat", new Object[]{"saveOneStat()  statValue <= 0 statType = ", Integer.valueOf(i)});
            return false;
        }
        c4807a.m23026a(d);
        c4807a.m23034c(i);
        return this.a.m23618a(c4807a);
    }
}

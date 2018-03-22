package com.huawei.hwdatamigrate.hihealth.p416h.p418b;

import android.content.Context;
import com.amap.api.maps.model.WeightedLatLng;
import com.huawei.hihealth.HiDataReadOption;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hwdatamigrate.hihealth.p067c.C4853j;
import com.huawei.hwdatamigrate.hihealth.p068d.C4880l;
import com.huawei.hwdatamigrate.hihealth.p068d.C4883o;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: HiCoreSleepStat */
public class C4926a extends C4925f {
    private C4853j f17997c;
    private C4883o f17998d = C4883o.m23650a(this.b);
    private C4880l f17999e = C4880l.m23643a(this.b);

    public C4926a(Context context) {
        super(context);
        this.f17997c = C4853j.m23568a(context);
    }

    public boolean m23765a(HiHealthData hiHealthData) {
        C2538c.c("Debug_HiCoreSleepStat", new Object[]{"stat() sleepData = ", hiHealthData});
        long currentTimeMillis = System.currentTimeMillis();
        int userID = hiHealthData.getUserID();
        C2538c.c("Debug_HiCoreSleepStat", new Object[]{"stat() sleepStartTime = ", Long.valueOf(C4540b.m21762j(hiHealthData.getStartTime())), ", sleepEndTime = ", Long.valueOf(C4540b.m21763k(hiHealthData.getStartTime()))});
        C4807a c4807a = new C4807a();
        c4807a.m23028a(C4540b.m21761i(hiHealthData.getStartTime()));
        c4807a.m23036d(userID);
        c4807a.m23042g(hiHealthData.getSyncStatus());
        c4807a.m23031b(hiHealthData.getType());
        boolean a = m23760a(r2, r4, c4807a, userID);
        C2538c.c("Debug_HiCoreSleepStat", new Object[]{"stat() totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return a;
    }

    private boolean m23760a(long j, long j2, C4807a c4807a, int i) {
        int b = this.f17998d.m23656b(0, i, 0);
        c4807a.m23038e(b);
        if (b <= 0) {
            C2538c.d("Debug_HiCoreSleepStat", new Object[]{"statSleepDataByUser() statClient <= 0 userID = ", Integer.valueOf(i)});
            return false;
        }
        List a = this.f17999e.m23646a(i);
        if (C4539a.m21749a(a)) {
            C2538c.d("Debug_HiCoreSleepStat", new Object[]{"statSleepDataByUser() statClients is null userID = ", Integer.valueOf(i)});
            return false;
        }
        HiDataReadOption hiDataReadOption = new HiDataReadOption();
        hiDataReadOption.setStartTime(j);
        hiDataReadOption.setEndTime(j2);
        hiDataReadOption.setSortOrder(0);
        return m23762a(c4807a, this.f17997c.m23572a(hiDataReadOption, a, 22100, 22199));
    }

    private boolean m23762a(C4807a c4807a, List<HiHealthData> list) {
        if (C4539a.m21749a((List) list)) {
            C2538c.d("Debug_HiCoreSleepStat", new Object[]{"statSleepData() sleepDatas is null"});
            return false;
        }
        double d;
        C2538c.c("Debug_HiCoreSleepStat", new Object[]{"statSleepData() sleepDatas size = ", Integer.valueOf(list.size())});
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = list.size();
        int i = 0;
        while (i < size) {
            double d7;
            double d8;
            HiHealthData hiHealthData = (HiHealthData) list.get(i);
            switch (hiHealthData.getType()) {
                case 22101:
                    d = d5;
                    d7 = d4;
                    d5 = d2;
                    d8 = d6;
                    d6 = WeightedLatLng.DEFAULT_INTENSITY + d3;
                    break;
                case 22102:
                    d = WeightedLatLng.DEFAULT_INTENSITY + d5;
                    d7 = d4;
                    d5 = d2;
                    d8 = d6;
                    d6 = d3;
                    break;
                case 22103:
                    d = WeightedLatLng.DEFAULT_INTENSITY + d2;
                    arrayList.add(hiHealthData);
                    d8 = d6;
                    d7 = d4;
                    d6 = d3;
                    double d9 = d5;
                    d5 = d;
                    d = d9;
                    break;
                case 22104:
                    d = WeightedLatLng.DEFAULT_INTENSITY + d4;
                    arrayList2.add(hiHealthData);
                    d8 = d6;
                    d7 = d;
                    d = d5;
                    d6 = d3;
                    d5 = d2;
                    break;
                case 22105:
                    d8 = WeightedLatLng.DEFAULT_INTENSITY + d6;
                    d = d5;
                    d7 = d4;
                    d6 = d3;
                    d5 = d2;
                    break;
                default:
                    d8 = d6;
                    d = d5;
                    d7 = d4;
                    d6 = d3;
                    d5 = d2;
                    break;
            }
            i++;
            d3 = d6;
            d2 = d5;
            d4 = d7;
            d6 = d8;
            d5 = d;
        }
        C2538c.c("Debug_HiCoreSleepStat", new Object[]{"statSleepData() totalDuration = ", Double.valueOf((d2 + d3) + d5), ",deepDuration = ", Double.valueOf(d2), ",shallowDuration = ", Double.valueOf(d3), ",dreamDuration = ", Double.valueOf(d5), ",wakeDuration = ", Double.valueOf(d4), ",noonDuration = ", Double.valueOf(d6), ",date = ", Integer.valueOf(c4807a.m23025a())});
        m23761a(c4807a, d, 44105, 15);
        m23761a(c4807a, d2, 44102, 15);
        m23761a(c4807a, d3, 44103, 15);
        m23761a(c4807a, d5, 44101, 15);
        m23764b(c4807a, d4, 44104, 15);
        m23764b(c4807a, d6, 44108, 15);
        m23763a(c4807a, (List) arrayList, 20, 44106);
        m23763a(c4807a, (List) arrayList2, 3, 44107);
        return true;
    }

    private boolean m23763a(C4807a c4807a, List<HiHealthData> list, int i, int i2) {
        if (C4539a.m21749a((List) list)) {
            C2538c.d("Debug_HiCoreSleepStat", new Object[]{"statCount() sleepDatas is null"});
            return false;
        }
        C2538c.c("Debug_HiCoreSleepStat", new Object[]{"statCount() deepDatas size = ", Integer.valueOf(list.size()), ",minTime = ", Integer.valueOf(i), ",statType = ", Integer.valueOf(i2)});
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            int i6 = i3 + 1;
            long endTime = ((HiHealthData) list.get(i5)).getEndTime();
            if (i5 >= size - 1) {
                C2538c.b("Debug_HiCoreSleepStat", new Object[]{"statCount break i = " + i5, ",time = ", Integer.valueOf(i6)});
                if (i6 >= i) {
                    i4++;
                    C2538c.b("Debug_HiCoreSleepStat", new Object[]{"statCount break count 2 is ture count = " + i4, ",time = ", Integer.valueOf(i6)});
                }
                C2538c.c("Debug_HiCoreSleepStat", new Object[]{"statCount statType = " + i2, ",count = ", Integer.valueOf(i4), ",date = ", Integer.valueOf(c4807a.m23025a())});
                m23764b(c4807a, (double) i4, i2, 16);
                return true;
            }
            if ((((HiHealthData) list.get(i5 + 1)).getStartTime() - endTime) / FileWatchdog.DEFAULT_DELAY <= 0) {
                i3 = i6;
            } else {
                if (i6 >= i) {
                    i3 = i4 + 1;
                    C2538c.b("Debug_HiCoreSleepStat", new Object[]{"statCount count 1 is ture count = " + i3, ",time = ", Integer.valueOf(i6), ", duration = ", Long.valueOf(endTime)});
                } else {
                    i3 = i4;
                }
                i4 = i3;
                i3 = 0;
            }
        }
        C2538c.c("Debug_HiCoreSleepStat", new Object[]{"statCount statType = " + i2, ",count = ", Integer.valueOf(i4), ",date = ", Integer.valueOf(c4807a.m23025a())});
        m23764b(c4807a, (double) i4, i2, 16);
        return true;
    }

    private boolean m23761a(C4807a c4807a, double d, int i, int i2) {
        return d > 0.0d && m23764b(c4807a, d, i, i2);
    }

    private boolean m23764b(C4807a c4807a, double d, int i, int i2) {
        c4807a.m23026a(d);
        c4807a.m23034c(i);
        c4807a.m23040f(i2);
        return this.a.m23618a(c4807a);
    }
}

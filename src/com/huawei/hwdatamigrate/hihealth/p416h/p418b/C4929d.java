package com.huawei.hwdatamigrate.hihealth.p416h.p418b;

import android.content.Context;
import com.huawei.hihealth.HiDataReadOption;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hwdatamigrate.hihealth.p067c.ah;
import com.huawei.hwdatamigrate.hihealth.p068d.C4880l;
import com.huawei.hwdatamigrate.hihealth.p068d.C4883o;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: HiSleepStat */
public class C4929d extends C4925f {
    private ah f18008c;
    private C4883o f18009d = C4883o.m23650a(this.b);
    private C4880l f18010e = C4880l.m23643a(this.b);

    public C4929d(Context context) {
        super(context);
        this.f18008c = ah.m23444a(context);
    }

    private boolean m23776a(long j, long j2, C4807a c4807a, int i) {
        int b = this.f18009d.m23656b(0, i, 0);
        c4807a.m23038e(b);
        if (b <= 0) {
            C2538c.d("Debug_HiSleepStat", new Object[]{"statSleepDataByUser() statClient <= 0 userID == ", Integer.valueOf(i)});
            return false;
        }
        List a = this.f18010e.m23646a(i);
        if (C4539a.m21749a(a)) {
            C2538c.d("Debug_HiSleepStat", new Object[]{"statSleepDataByUser() statClients is null userID == ", Integer.valueOf(i)});
            return false;
        }
        HiDataReadOption hiDataReadOption = new HiDataReadOption();
        hiDataReadOption.setStartTime(j);
        hiDataReadOption.setEndTime(j2);
        hiDataReadOption.setSortOrder(0);
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(22001));
        arrayList.add(Integer.valueOf(22002));
        return m23778a(c4807a, this.f18008c.m23453a(hiDataReadOption, a, arrayList));
    }

    public boolean m23780a(HiHealthData hiHealthData) {
        C2538c.c("Debug_HiSleepStat", new Object[]{"stat() sleepData: = ", hiHealthData});
        long currentTimeMillis = System.currentTimeMillis();
        int userID = hiHealthData.getUserID();
        C2538c.c("Debug_HiSleepStat", new Object[]{":stat() sleepStartTime = ", Long.valueOf(C4540b.m21762j(hiHealthData.getStartTime())), ", sleepEndTime = ", Long.valueOf(C4540b.m21763k(hiHealthData.getStartTime()))});
        C4807a c4807a = new C4807a();
        c4807a.m23028a(C4540b.m21761i(hiHealthData.getStartTime()));
        c4807a.m23036d(userID);
        c4807a.m23042g(hiHealthData.getSyncStatus());
        c4807a.m23031b(hiHealthData.getType());
        boolean a = m23776a(r2, r4, c4807a, userID);
        C2538c.c("Debug_HiSleepStat", new Object[]{":stat() totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return a;
    }

    private boolean m23778a(C4807a c4807a, List<HiHealthData> list) {
        if (C4539a.m21749a((List) list)) {
            C2538c.d("Debug_HiSleepStat", new Object[]{"statSleepData() sleepDatas is null"});
            return false;
        }
        long endTime;
        double d;
        double d2;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        int i = 0;
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            HiHealthData hiHealthData = (HiHealthData) list.get(i2);
            int type = hiHealthData.getType();
            long startTime = hiHealthData.getStartTime();
            endTime = hiHealthData.getEndTime();
            switch (type) {
                case 22001:
                    d = d3 + (((double) (endTime - startTime)) / 1000.0d);
                    d3 = d4;
                    break;
                case 22002:
                    d = d3;
                    d3 = d4 + (((double) (endTime - startTime)) / 1000.0d);
                    break;
                default:
                    d = d3;
                    d3 = d4;
                    break;
            }
            if (i2 >= size - 1) {
                C2538c.b("Debug_HiSleepStat", new Object[]{"statSleepData break i = " + i2});
                d2 = d;
                d = d3;
                C2538c.c("Debug_HiSleepStat", new Object[]{"statSleepData() totalDuration = ", Double.valueOf(d2 + d), ",deepDuration = ", Double.valueOf(d2), ",shallowDuration = ", Double.valueOf(d), ",wakeDuration = ", Double.valueOf(d5), ",earliestTime = ", Long.valueOf(((HiHealthData) list.get(0)).getStartTime()), ",lastTime = ", Long.valueOf(((HiHealthData) list.get(size - 1)).getEndTime()), ",wakeCount = ", Integer.valueOf(i)});
                m23777a(c4807a, d4, 44004, 13);
                m23777a(c4807a, d2, 44001, 13);
                m23777a(c4807a, d, 44002, 13);
                m23779b(c4807a, d5, 44003, 13);
                m23777a(c4807a, (double) endTime, 44006, 5);
                m23777a(c4807a, (double) r20, 44007, 5);
                m23779b(c4807a, (double) i, 44005, 16);
                return true;
            }
            int i3;
            long startTime2 = ((HiHealthData) list.get(i2 + 1)).getStartTime() - endTime;
            if (startTime2 <= 180000) {
                i3 = i;
                d4 = d5;
            } else if (startTime2 >= 1800000) {
                i3 = i;
                d4 = d5;
            } else {
                C2538c.c("Debug_HiSleepStat", new Object[]{"statSleepData sleep wake is ture duration = " + (startTime2 / FileWatchdog.DEFAULT_DELAY)});
                d4 = (((double) startTime2) / 1000.0d) + d5;
                i3 = i + 1;
            }
            i2++;
            i = i3;
            d5 = d4;
            d4 = d3;
            d3 = d;
        }
        d = d4;
        d2 = d3;
        C2538c.c("Debug_HiSleepStat", new Object[]{"statSleepData() totalDuration = ", Double.valueOf(d2 + d), ",deepDuration = ", Double.valueOf(d2), ",shallowDuration = ", Double.valueOf(d), ",wakeDuration = ", Double.valueOf(d5), ",earliestTime = ", Long.valueOf(((HiHealthData) list.get(0)).getStartTime()), ",lastTime = ", Long.valueOf(((HiHealthData) list.get(size - 1)).getEndTime()), ",wakeCount = ", Integer.valueOf(i)});
        m23777a(c4807a, d4, 44004, 13);
        m23777a(c4807a, d2, 44001, 13);
        m23777a(c4807a, d, 44002, 13);
        m23779b(c4807a, d5, 44003, 13);
        m23777a(c4807a, (double) endTime, 44006, 5);
        m23777a(c4807a, (double) r20, 44007, 5);
        m23779b(c4807a, (double) i, 44005, 16);
        return true;
    }

    private boolean m23777a(C4807a c4807a, double d, int i, int i2) {
        return d > 0.0d && m23779b(c4807a, d, i, i2);
    }

    private boolean m23779b(C4807a c4807a, double d, int i, int i2) {
        c4807a.m23026a(d);
        c4807a.m23034c(i);
        c4807a.m23040f(i2);
        return this.a.m23618a(c4807a);
    }
}

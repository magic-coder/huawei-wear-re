package com.huawei.hwdatamigrate.hihealth.sync.p420b;

import android.content.Context;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hwcloudmodel.model.unite.SleepBasic;
import com.huawei.hwcloudmodel.model.unite.SleepTotal;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p068d.C4883o;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C4970b;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.helpers.UtilLoggingLevel;

/* compiled from: SleepStatSwitch */
public class C4956h {
    private Context f18037a;

    public C4956h(Context context) {
        this.f18037a = context.getApplicationContext();
    }

    public List<C4807a> m23842a(SleepTotal sleepTotal, int i) {
        if (sleepTotal.getDeviceCode().longValue() != 0) {
            C2538c.d("Debug_SleepStatSwitch", new Object[]{"the sportTotal's deviceCode should be 0, deviceCode is ", sleepTotal.getDeviceCode()});
            return null;
        }
        g a = C4883o.m23650a(this.f18037a).m23654a(0, i, 0);
        if (a == null) {
            return null;
        }
        List<C4807a> a2 = m23841a(sleepTotal.getSleepBasic());
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        int c = a.c();
        int intValue = sleepTotal.getRecordDay().intValue();
        String timeZone = sleepTotal.getTimeZone();
        for (int i2 = 0; i2 < a2.size(); i2++) {
            ((C4807a) a2.get(i2)).m23038e(c);
            ((C4807a) a2.get(i2)).m23029a(timeZone);
            ((C4807a) a2.get(i2)).m23027a(intValue);
            ((C4807a) a2.get(i2)).m23042g(1);
            ((C4807a) a2.get(i2)).m23031b((int) UtilLoggingLevel.SEVERE_INT);
        }
        return a2;
    }

    private List<C4807a> m23841a(SleepBasic sleepBasic) {
        if (sleepBasic == null) {
            return null;
        }
        List<C4807a> arrayList = new ArrayList();
        int intValue = sleepBasic.getDeepDuration().intValue();
        int intValue2 = sleepBasic.getLightDuration().intValue();
        int intValue3 = sleepBasic.getAwakeDuration().intValue();
        int intValue4 = sleepBasic.getAwakeTimes().intValue();
        int intValue5 = sleepBasic.getTotalDuration().intValue();
        if (intValue > 0) {
            arrayList.add(C4970b.m23889a(44001, (double) (intValue * 60), 13));
        }
        if (intValue2 > 0) {
            arrayList.add(C4970b.m23889a(44002, (double) (intValue2 * 60), 13));
        }
        if (intValue3 > 0) {
            arrayList.add(C4970b.m23889a(44003, (double) (intValue3 * 60), 13));
        }
        if (intValue4 > 0) {
            arrayList.add(C4970b.m23889a(44005, (double) intValue4, 16));
        }
        if (intValue5 <= 0) {
            return arrayList;
        }
        arrayList.add(C4970b.m23889a(44004, (double) (intValue5 * 60), 13));
        return arrayList;
    }

    public List<SleepTotal> m23843a(List<HiHealthData> list) {
        List<SleepTotal> arrayList = new ArrayList();
        for (HiHealthData hiHealthData : list) {
            SleepTotal sleepTotal = new SleepTotal();
            sleepTotal.setTimeZone(hiHealthData.getTimeZone());
            sleepTotal.setRecordDay(Integer.valueOf(C4540b.m21750a(hiHealthData.getStartTime())));
            sleepTotal.setDataSource(Integer.valueOf(2));
            SleepBasic a = m23840a(hiHealthData);
            if (a != null) {
                sleepTotal.setSleepBasic(a);
                arrayList.add(sleepTotal);
            }
        }
        return arrayList;
    }

    private SleepBasic m23840a(HiHealthData hiHealthData) {
        SleepBasic sleepBasic = new SleepBasic();
        long j = hiHealthData.getLong("stat_sleep_start_time");
        long j2 = hiHealthData.getLong("stat_sleep_end_time");
        if (j < 1 || j2 < 1) {
            C2538c.d("Debug_SleepStatSwitch", new Object[]{"getSleepBasic sleep data error ! hiHealthData is ", hiHealthData});
            return null;
        }
        sleepBasic.setStartTime(Long.valueOf(j));
        sleepBasic.setEndTime(Long.valueOf(j2));
        sleepBasic.setDeepDuration(Integer.valueOf(hiHealthData.getInt("stat_sleep_deep_duration") / 60));
        sleepBasic.setLightDuration(Integer.valueOf(hiHealthData.getInt("stat_sleep_shallow_duration") / 60));
        sleepBasic.setAwakeDuration(Integer.valueOf(hiHealthData.getInt("stat_sleep_wake_duration") / 60));
        sleepBasic.setAwakeTimes(Integer.valueOf(hiHealthData.getInt("stat_sleep_wake_count")));
        sleepBasic.setTotalDuration(Integer.valueOf(hiHealthData.getInt("stat_sleep_duration_sum") / 60));
        return sleepBasic;
    }
}

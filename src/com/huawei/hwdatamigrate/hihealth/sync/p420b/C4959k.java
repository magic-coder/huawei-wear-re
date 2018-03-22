package com.huawei.hwdatamigrate.hihealth.sync.p420b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hihealth.p394c.C4544f;
import com.huawei.hwcloudmodel.model.SportTotalData;
import com.huawei.hwcloudmodel.model.unite.SportBasicInfo;
import com.huawei.hwcloudmodel.model.unite.SportTotal;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p068d.C4883o;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C4970b;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: SportStatSwitch */
public class C4959k {
    private Context f18047a;
    private C4960l f18048b = new C4960l();
    private C4953e f18049c = new C4953e();

    public C4959k(Context context) {
        this.f18047a = context.getApplicationContext();
    }

    public List<C4807a> m23858a(@NonNull SportTotalData sportTotalData, int i) {
        int intValue = sportTotalData.getRecordDay().intValue();
        int intValue2 = sportTotalData.getSportType().intValue();
        SportBasicInfo sportBasicInfo = sportTotalData.getSportBasicInfo();
        String timeZone = sportTotalData.getTimeZone();
        if (sportBasicInfo == null) {
            return null;
        }
        if (sportTotalData.getDeviceCode().longValue() != 0) {
            C2538c.d("Debug_SportDataSwitch", new Object[]{"the sportTotal's deviceCode should be 0, deviceCode is ", sportTotalData.getDeviceCode()});
            return null;
        }
        g a = C4883o.m23650a(this.f18047a).m23654a(0, i, 0);
        if (a == null) {
            return null;
        }
        C2538c.c("Debug_SportDataSwitch", new Object[]{"switchSportTotalDataToDayStat sportType is ", Integer.valueOf(intValue2)});
        List<C4807a> a2 = this.f18048b.m23867a(intValue2, sportBasicInfo);
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        int c = a.c();
        for (int i2 = 0; i2 < a2.size(); i2++) {
            ((C4807a) a2.get(i2)).m23038e(c);
            ((C4807a) a2.get(i2)).m23029a(timeZone);
            ((C4807a) a2.get(i2)).m23027a(intValue);
            ((C4807a) a2.get(i2)).m23042g(1);
            ((C4807a) a2.get(i2)).m23031b(20001);
        }
        return a2;
    }

    public List<SportTotal> m23859a(List<HiHealthData> list) {
        List<SportTotal> arrayList = new ArrayList();
        for (HiHealthData hiHealthData : list) {
            Collection arrayList2 = new ArrayList();
            int a = C4540b.m21750a(hiHealthData.getStartTime());
            String timeZone = hiHealthData.getTimeZone();
            this.f18049c.m23831a(arrayList2, hiHealthData, a, 2, timeZone);
            this.f18049c.m23833b(arrayList2, hiHealthData, a, 2, timeZone);
            m23855a(arrayList2, hiHealthData, a, 2, timeZone);
            m23856b(arrayList2, hiHealthData, a, 2, timeZone);
            if (!arrayList2.isEmpty()) {
                arrayList.addAll(arrayList2);
            }
        }
        return arrayList;
    }

    public List<SportTotal> m23860b(@NonNull List<HiHealthData> list) {
        List<SportTotal> arrayList = new ArrayList();
        for (HiHealthData hiHealthData : list) {
            Collection arrayList2 = new ArrayList();
            m23857c(arrayList2, hiHealthData, C4540b.m21750a(hiHealthData.getStartTime()), 2, hiHealthData.getTimeZone());
            if (!arrayList2.isEmpty()) {
                arrayList.addAll(arrayList2);
            }
        }
        return arrayList;
    }

    private void m23855a(List<SportTotal> list, @NonNull HiHealthData hiHealthData, int i, int i2, String str) {
        SportTotal sportTotal = new SportTotal();
        int i3 = (int) hiHealthData.getDouble("sport_cycle_distance_sum");
        int i4 = (int) hiHealthData.getDouble("sport_cycle_calorie_sum");
        int i5 = (int) hiHealthData.getDouble("sport_cycle_duration_sum");
        if (C4544f.m21788d(i4)) {
            sportTotal.setSportBasicInfo(C4970b.m23888a(Integer.valueOf(0), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(0.0f), Integer.valueOf(0), Integer.valueOf(i5 / 60), Integer.valueOf(0)));
            sportTotal.setRecordDay(Integer.valueOf(i));
            sportTotal.setDataSource(Integer.valueOf(i2));
            sportTotal.setTimeZone(str);
            sportTotal.setSportType(Integer.valueOf(3));
            list.add(sportTotal);
            return;
        }
        C2538c.e("Debug_SportDataSwitch", new Object[]{"addRideTotal calorie is out of range hiHealthData = ", hiHealthData});
    }

    private void m23856b(List<SportTotal> list, @NonNull HiHealthData hiHealthData, int i, int i2, String str) {
        SportTotal sportTotal = new SportTotal();
        int i3 = (int) hiHealthData.getDouble("sport_climb_step_sum");
        int i4 = (int) hiHealthData.getDouble("sport_climb_distance_sum");
        int i5 = (int) hiHealthData.getDouble("sport_climb_calorie_sum");
        int i6 = (int) hiHealthData.getDouble("sport_climb_duration_sum");
        float f = (float) hiHealthData.getDouble("sport_altitude_offset_sum");
        if (C4544f.m21787c(i3) && C4544f.m21785b((double) f)) {
            sportTotal.setSportBasicInfo(C4970b.m23888a(Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f / 10.0f), Integer.valueOf(0), Integer.valueOf(i6 / 60), Integer.valueOf(0)));
            sportTotal.setRecordDay(Integer.valueOf(i));
            sportTotal.setDataSource(Integer.valueOf(i2));
            sportTotal.setTimeZone(str);
            sportTotal.setSportType(Integer.valueOf(2));
            list.add(sportTotal);
            return;
        }
        C2538c.e("Debug_SportDataSwitch", new Object[]{"addMountainTotal STEPS is out of range hiHealthData = ", hiHealthData});
    }

    private void m23857c(List<SportTotal> list, @NonNull HiHealthData hiHealthData, int i, int i2, String str) {
        SportTotal sportTotal = new SportTotal();
        int i3 = (int) hiHealthData.getDouble("sport_step_sum");
        int i4 = (int) hiHealthData.getDouble("sport_distance_sum");
        int i5 = (int) hiHealthData.getDouble("sport_calorie_sum");
        int i6 = (int) hiHealthData.getDouble("sport_duration_sum");
        float f = (float) hiHealthData.getDouble("sport_altitude_offset_sum");
        if (C4544f.m21787c(i3) && C4544f.m21788d(i5) && C4544f.m21785b((double) f)) {
            sportTotal.setSportBasicInfo(C4970b.m23888a(Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f / 10.0f), Integer.valueOf(0), Integer.valueOf(i6 / 60), Integer.valueOf(0)));
            sportTotal.setRecordDay(Integer.valueOf(i));
            sportTotal.setDataSource(Integer.valueOf(i2));
            sportTotal.setTimeZone(str);
            sportTotal.setSportType(Integer.valueOf(0));
            list.add(sportTotal);
            return;
        }
        C2538c.e("Debug_SportDataSwitch", new Object[]{"addAllTotal STEPS or CALORIE or altitude is out of range hiHealthData = ", hiHealthData});
    }

    public List<SportTotalData> m23861c(List<SportTotalData> list) {
        C2538c.c("Debug_SportDataSwitch", new Object[]{"start mergeClimbAndFloor"});
        List arrayList = new ArrayList();
        List<SportTotalData> arrayList2 = new ArrayList();
        for (SportTotalData sportTotalData : list) {
            if (sportTotalData.getSportType().intValue() == 1) {
                this.f18049c.m23830a(sportTotalData);
                arrayList.add(sportTotalData);
            } else if (sportTotalData.getSportType().intValue() == 2) {
                arrayList.add(sportTotalData);
            } else {
                arrayList2.add(sportTotalData);
            }
        }
        if (arrayList.isEmpty()) {
            C2538c.c("Debug_SportDataSwitch", new Object[]{"mergeClimbAndFloor no such data"});
            return arrayList2;
        }
        arrayList2.addAll(m23862d(arrayList));
        return arrayList2;
    }

    public List<SportTotalData> m23862d(List<SportTotalData> list) {
        SparseArray sparseArray = new SparseArray();
        for (SportTotalData sportTotalData : list) {
            if (sportTotalData != null) {
                int intValue = sportTotalData.getRecordDay().intValue();
                C2538c.b("Debug_SportDataSwitch", new Object[]{"mergeOneDayStat key is ", Integer.valueOf(intValue)});
                Object obj = (SportTotalData) sparseArray.get(intValue);
                if (obj != null) {
                    obj = this.f18049c.m23827a(obj, sportTotalData);
                    C2538c.b("Debug_SportDataSwitch", new Object[]{"mergeOneDayStat need merged key is ", Integer.valueOf(intValue)});
                }
                sparseArray.put(intValue, obj);
            }
        }
        List<SportTotalData> arrayList = new ArrayList();
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add((SportTotalData) sparseArray.valueAt(i));
        }
        return arrayList;
    }
}

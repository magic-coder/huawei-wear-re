package com.huawei.hwdatamigrate.hihealth.sync.p420b;

import android.support.annotation.NonNull;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4543e;
import com.huawei.hihealth.p394c.C4544f;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwcloudmodel.model.SportTotalData;
import com.huawei.hwcloudmodel.model.unite.SportBasicInfo;
import com.huawei.hwcloudmodel.model.unite.SportTotal;
import com.huawei.hwdatamigrate.hihealth.p409b.p411b.C4807a;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C4970b;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MSportStatSwitchUtil */
public class C4953e {
    public void m23831a(List<SportTotal> list, @NonNull HiHealthData hiHealthData, int i, int i2, String str) {
        SportTotal sportTotal = new SportTotal();
        int i3 = (int) hiHealthData.getDouble("sport_walk_step_sum");
        int i4 = (int) hiHealthData.getDouble("sport_walk_distance_sum");
        int i5 = (int) hiHealthData.getDouble("sport_walk_calorie_sum");
        int i6 = (int) hiHealthData.getDouble("sport_walk_duration_sum");
        if (C4544f.m21787c(i3)) {
            sportTotal.setSportBasicInfo(C4970b.m23888a(Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(0.0f), Integer.valueOf(0), Integer.valueOf(i6 / 60), Integer.valueOf(0)));
            sportTotal.setRecordDay(Integer.valueOf(i));
            sportTotal.setDataSource(Integer.valueOf(i2));
            sportTotal.setTimeZone(str);
            sportTotal.setSportType(Integer.valueOf(5));
            list.add(sportTotal);
            return;
        }
        C2538c.e("Debug_SportStatSwitchUtil", new Object[]{"addWalkTotal steps is out of range hiHealthData = ", hiHealthData});
    }

    public List<C4807a> m23829a(SportBasicInfo sportBasicInfo) {
        List<C4807a> arrayList = new ArrayList();
        int intValue = sportBasicInfo.getSteps().intValue();
        int intValue2 = sportBasicInfo.getDistance().intValue();
        int intValue3 = sportBasicInfo.getCalorie().intValue();
        int intValue4 = sportBasicInfo.getDuration().intValue();
        float intValue5 = (float) (sportBasicInfo.getFloor().intValue() * 30);
        if (C4544f.m21787c(intValue) && C4544f.m21785b((double) intValue5)) {
            if (C4544f.m21789e(intValue)) {
                arrayList.add(m23828a(40013, (double) intValue, 1));
            }
            if (C4544f.m21789e(intValue2)) {
                arrayList.add(m23828a(40034, (double) intValue2, 2));
            }
            C2538c.b("Debug_SportStatSwitchUtil", new Object[]{""});
            if (C4544f.m21789e(intValue4)) {
                arrayList.add(m23828a(40044, (double) (intValue4 * 60), 13));
            }
            if (C4544f.m21789e(intValue3)) {
                arrayList.add(m23828a(40024, (double) intValue3, 3));
            }
            if (!C4544f.m21783a(intValue5)) {
                return arrayList;
            }
            arrayList.add(m23828a(40005, (double) intValue5, 4));
            return arrayList;
        }
        C2538c.e("Debug_SportStatSwitchUtil", new Object[]{"getStairStatTable STEP is out of rang sportBasicInfo = ", C4543e.m21779a(sportBasicInfo)});
        return null;
    }

    public List<C4807a> m23832b(SportBasicInfo sportBasicInfo) {
        List<C4807a> arrayList = new ArrayList();
        int intValue = sportBasicInfo.getSteps().intValue();
        int intValue2 = sportBasicInfo.getDistance().intValue();
        int intValue3 = sportBasicInfo.getCalorie().intValue();
        int intValue4 = sportBasicInfo.getDuration().intValue();
        float floatValue = (sportBasicInfo.getAltitude().floatValue() * 10.0f) + ((float) (sportBasicInfo.getFloor().intValue() * 30));
        if (C4544f.m21787c(intValue) && C4544f.m21788d(intValue3) && C4544f.m21785b((double) floatValue)) {
            if (C4544f.m21789e(intValue)) {
                arrayList.add(m23828a(PayStatusCodes.PRODUCT_AUTHENTICATION_FAILED, (double) intValue, 1));
            }
            if (C4544f.m21789e(intValue2)) {
                arrayList.add(m23828a(PayStatusCodes.PRODUCT_SOME_NOT_EXIST, (double) intValue2, 2));
            }
            if (C4544f.m21789e(intValue4)) {
                arrayList.add(m23828a(40006, (double) (intValue4 * 60), 13));
            }
            if (C4544f.m21789e(intValue3)) {
                arrayList.add(m23828a(PayStatusCodes.PRODUCT_SERVER_INTERNAL_EXCEPTION, (double) intValue3, 3));
            }
            if (!C4544f.m21783a(floatValue)) {
                return arrayList;
            }
            arrayList.add(m23828a(40005, (double) floatValue, 4));
            return arrayList;
        }
        C2538c.e("Debug_SportStatSwitchUtil", new Object[]{"getSportStatTable STEP OR CALORIE or altitude is out of rang sportBasicInfo = ", C4543e.m21779a(sportBasicInfo)});
        return null;
    }

    public C4807a m23828a(int i, double d, int i2) {
        C4807a c4807a = new C4807a();
        c4807a.m23034c(i);
        c4807a.m23026a(d);
        c4807a.m23040f(i2);
        return c4807a;
    }

    public void m23830a(SportTotalData sportTotalData) {
        sportTotalData.setSportType(Integer.valueOf(2));
        SportBasicInfo sportBasicInfo = sportTotalData.getSportBasicInfo();
        sportBasicInfo.setAltitude(Float.valueOf(((float) (sportBasicInfo.getFloor().intValue() * 30)) / 10.0f));
        sportBasicInfo.setFloor(Integer.valueOf(0));
    }

    public SportTotalData m23827a(SportTotalData sportTotalData, SportTotalData sportTotalData2) {
        SportTotalData sportTotalData3 = new SportTotalData();
        sportTotalData3.setSportType(sportTotalData.getSportType());
        sportTotalData3.setDeviceCode(sportTotalData.getDeviceCode());
        sportTotalData3.setDataSource(sportTotalData.getDataSource());
        sportTotalData3.setRecordDay(sportTotalData.getRecordDay());
        sportTotalData3.setTimeZone(sportTotalData.getTimeZone());
        sportTotalData3.setSportBasicInfo(C4970b.m23888a(Integer.valueOf(sportTotalData.getSportBasicInfo().getSteps().intValue() + sportTotalData2.getSportBasicInfo().getSteps().intValue()), Integer.valueOf(sportTotalData.getSportBasicInfo().getDistance().intValue() + sportTotalData2.getSportBasicInfo().getDistance().intValue()), Integer.valueOf(sportTotalData.getSportBasicInfo().getCalorie().intValue() + sportTotalData2.getSportBasicInfo().getCalorie().intValue()), Float.valueOf(sportTotalData.getSportBasicInfo().getAltitude().floatValue() + sportTotalData2.getSportBasicInfo().getAltitude().floatValue()), Integer.valueOf(sportTotalData.getSportBasicInfo().getFloor().intValue() + sportTotalData2.getSportBasicInfo().getFloor().intValue()), Integer.valueOf(sportTotalData.getSportBasicInfo().getDuration().intValue() + sportTotalData2.getSportBasicInfo().getDuration().intValue()), Integer.valueOf(sportTotalData.getSportBasicInfo().getCount().intValue() + sportTotalData2.getSportBasicInfo().getCount().intValue())));
        return sportTotalData3;
    }

    public void m23833b(List<SportTotal> list, @NonNull HiHealthData hiHealthData, int i, int i2, String str) {
        SportTotal sportTotal = new SportTotal();
        int i3 = (int) hiHealthData.getDouble("sport_run_step_sum");
        int i4 = (int) hiHealthData.getDouble("sport_run_distance_sum");
        int i5 = (int) hiHealthData.getDouble("sport_run_calorie_sum");
        int i6 = (int) hiHealthData.getDouble("sport_run_duration_sum");
        if (C4544f.m21787c(i3)) {
            sportTotal.setSportBasicInfo(C4970b.m23888a(Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(0.0f), Integer.valueOf(0), Integer.valueOf(i6 / 60), Integer.valueOf(0)));
            sportTotal.setRecordDay(Integer.valueOf(i));
            sportTotal.setDataSource(Integer.valueOf(i2));
            sportTotal.setTimeZone(str);
            sportTotal.setSportType(Integer.valueOf(4));
            list.add(sportTotal);
            return;
        }
        C2538c.e("Debug_SportStatSwitchUtil", new Object[]{"addRunTotal steps is out of range hiHealthData = ", hiHealthData});
    }
}

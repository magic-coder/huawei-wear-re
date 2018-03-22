package com.huawei.hihealth.p036a;

import com.huawei.hihealth.HiAccountInfo;
import com.huawei.hihealth.HiAggregateOption;
import com.huawei.hihealth.HiDataInsertOption;
import com.huawei.hihealth.HiDataReadOption;
import com.huawei.hihealth.HiDeviceInfo;
import com.huawei.hihealth.HiGoalInfo;
import com.huawei.hihealth.HiSyncOption;
import com.huawei.hihealth.HiUserPreference;
import com.huawei.hihealth.data.b.a;
import com.huawei.hihealth.data.b.b;
import com.huawei.hihealth.data.b.c;
import com.huawei.hihealth.data.b.d;
import com.huawei.hihealth.data.b.e;
import com.huawei.hihealth.data.b.f;
import com.huawei.hihealth.data.b.g;
import java.util.List;

/* compiled from: HiHealthAPI */
public interface C0823a {
    HiUserPreference m2898a(String str);

    void m2899a(int i, int i2, b bVar);

    void m2900a(int i, List<HiGoalInfo> list, b bVar);

    void m2901a(HiAccountInfo hiAccountInfo, b bVar);

    void m2902a(HiAggregateOption hiAggregateOption, a aVar);

    void m2903a(HiDataInsertOption hiDataInsertOption, c cVar);

    void m2904a(HiDataReadOption hiDataReadOption, d dVar);

    void m2905a(HiDeviceInfo hiDeviceInfo, List<Integer> list, e eVar);

    void m2906a(HiSyncOption hiSyncOption, b bVar);

    void m2907a(b bVar);

    void m2908a(List<Integer> list, f fVar);

    void m2909a(List<Integer> list, g gVar);

    boolean m2910a();

    boolean m2911a(HiUserPreference hiUserPreference, boolean z);

    int m2912b();

    boolean m2913b(String str);
}

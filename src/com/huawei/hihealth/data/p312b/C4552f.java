package com.huawei.hihealth.data.p312b;

import com.huawei.hihealth.HiHealthClient;
import com.huawei.hihealth.HiHealthData;
import java.util.List;

/* compiled from: HiSubscribeListener */
public interface C4552f {
    void onChange(int i, HiHealthClient hiHealthClient, String str, HiHealthData hiHealthData, long j);

    void onResult(List<Integer> list, List<Integer> list2);
}

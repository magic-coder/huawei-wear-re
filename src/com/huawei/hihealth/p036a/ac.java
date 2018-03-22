package com.huawei.hihealth.p036a;

import android.os.RemoteException;
import com.huawei.hihealth.HiHealthClient;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.at;
import java.util.List;

/* compiled from: HiHealthNativeAPI */
class ac extends at {
    final /* synthetic */ ab f16696a;

    ac(ab abVar) {
        this.f16696a = abVar;
    }

    public void mo4488a(List list, List list2) throws RemoteException {
        if (this.f16696a.f16694b != null) {
            this.f16696a.f16694b.onResult(list, list2);
        }
    }

    public void mo4487a(int i, HiHealthClient hiHealthClient, String str, HiHealthData hiHealthData, long j) throws RemoteException {
        if (this.f16696a.f16694b != null) {
            this.f16696a.f16694b.onChange(i, hiHealthClient, str, hiHealthData, j);
        }
    }
}

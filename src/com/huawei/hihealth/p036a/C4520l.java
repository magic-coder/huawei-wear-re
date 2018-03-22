package com.huawei.hihealth.p036a;

import android.os.RemoteException;
import android.util.SparseArray;
import com.huawei.hihealth.ak;
import com.huawei.hihealth.p394c.C4541c;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: HiHealthNativeAPI */
class C4520l extends ak {
    final /* synthetic */ List f16724a;
    final /* synthetic */ SparseArray f16725b;
    final /* synthetic */ long f16726c;
    final /* synthetic */ C4519k f16727d;

    C4520l(C4519k c4519k, List list, SparseArray sparseArray, long j) {
        this.f16727d = c4519k;
        this.f16724a = list;
        this.f16725b = sparseArray;
        this.f16726c = j;
    }

    public void mo4492a(List list, int i, int i2) throws RemoteException {
        if (this.f16727d.f16722b != null) {
            if (C4541c.m21769a(C4509c.f16698a, list, i, i2, this.f16724a, this.f16725b)) {
                C2538c.b("HiH_HiHealthNativeAPI", new Object[]{"readHiHealthData option = ", this.f16727d.f16721a, ",totalTime = ", Long.valueOf(System.currentTimeMillis() - this.f16726c)});
                this.f16727d.f16722b.mo4610a(this.f16725b, i, i2);
            }
        }
    }
}

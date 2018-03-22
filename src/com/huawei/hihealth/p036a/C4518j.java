package com.huawei.hihealth.p036a;

import android.os.RemoteException;
import com.huawei.hihealth.ah;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* compiled from: HiHealthNativeAPI */
class C4518j extends ah {
    final /* synthetic */ int[] f16717a;
    final /* synthetic */ Object[] f16718b;
    final /* synthetic */ CountDownLatch f16719c;
    final /* synthetic */ C4517i f16720d;

    C4518j(C4517i c4517i, int[] iArr, Object[] objArr, CountDownLatch countDownLatch) {
        this.f16720d = c4517i;
        this.f16717a = iArr;
        this.f16718b = objArr;
        this.f16719c = countDownLatch;
    }

    public void mo4491a(int i, List list) throws RemoteException {
        if (i != 0) {
            this.f16717a[0] = i;
            this.f16718b[0] = list.get(0);
        }
        this.f16719c.countDown();
    }
}

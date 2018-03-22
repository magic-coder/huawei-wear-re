package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p159b.C1694b;

/* compiled from: SendCommandUtil */
class aw extends Thread {
    private aw() {
    }

    public void run() {
        super.run();
    }

    synchronized C1694b m8018a(byte[] bArr) {
        C1694b c1694b;
        C2538c.m12664a("SendCommandUtil", " Enter synchronized ");
        c1694b = null;
        if (bArr != null && bArr.length > 0) {
            if (as.f4474c != null) {
                c1694b = as.f4474c.m7971a(bArr.length, bArr, bArr[0]);
            } else {
                C2538c.m12680e("SendCommandUtil", "mWearableManager Is NULL ");
            }
        }
        return c1694b;
    }
}

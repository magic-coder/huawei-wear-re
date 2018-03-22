package com.huawei.hwdatamigrate.hihealth.sync.p072d;

import com.huawei.p111o.p478b.C5699d;
import com.huawei.p111o.p478b.C5703i;

/* compiled from: HiRecordIdUtil */
public class C4972d {
    public static String m23895a(long j, int i, long j2) {
        byte[] bArr = new byte[20];
        C4972d.m23897a(j, bArr, 0);
        C4972d.m23896a(i, bArr, 8);
        C4972d.m23897a(j2, bArr, 12);
        return C5703i.m26313a(C5699d.m26304a(bArr));
    }

    public static void m23897a(long j, byte[] bArr, int i) {
        bArr[i] = (byte) ((int) j);
        bArr[i + 1] = (byte) ((int) (j >> 8));
        bArr[i + 2] = (byte) ((int) (j >> 16));
        bArr[i + 3] = (byte) ((int) (j >> 24));
        bArr[i + 4] = (byte) ((int) (j >> 32));
        bArr[i + 5] = (byte) ((int) (j >> 40));
        bArr[i + 6] = (byte) ((int) (j >> 48));
        bArr[i + 7] = (byte) ((int) (j >>> 56));
    }

    public static void m23896a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }
}

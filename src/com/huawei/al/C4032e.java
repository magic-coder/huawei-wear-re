package com.huawei.al;

import android.content.Context;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: WordLibUtil */
public class C4032e {
    private C4031d f15327a;
    private CountDownLatch f15328b = new CountDownLatch(1);

    public C4032e(Context context) {
        m19843a(context);
    }

    void m19843a(Context context) {
        new Thread(new C4033f(this, context)).start();
    }

    public ArrayList<byte[]> m19842a(String str) {
        int i = 0;
        C2538c.c("WordLibUtil", new Object[]{"getHZKDatas() enter"});
        m19840a();
        if (this.f15327a == null) {
            return null;
        }
        ArrayList a = this.f15327a.m19836a(str);
        if (a == null) {
            return null;
        }
        C2538c.c("WordLibUtil", new Object[]{"getHZKDatas() mWordLib.list=" + Arrays.toString(a.toArray())});
        byte[] bArr = new byte[64];
        ArrayList<byte[]> arrayList = new ArrayList();
        C2538c.c("WordLibUtil", new Object[]{"getHZKDatas() for() begin"});
        Iterator it = a.iterator();
        int i2 = 0;
        int i3 = 0;
        byte[] bArr2 = bArr;
        int i4 = 0;
        int i5 = 4;
        while (it.hasNext()) {
            byte[] bArr3;
            int i6;
            byte b = (byte) (i5 + 1);
            int i7 = i2 + 1;
            bArr2[b] = (byte) ((Integer) it.next()).intValue();
            i2 = bArr2[b] + i3;
            if (b == TagName.CARD_BUSINESS_ORDER_STATUS) {
                bArr2[0] = (byte) -86;
                bArr2[1] = TagName.APK_DOWNLOAD_URL;
                bArr2[2] = (byte) (i7 + 2);
                bArr2[3] = (byte) (i4 >> 8);
                bArr2[4] = (byte) (i4 & 255);
                bArr2[63] = (byte) ((((((bArr2[0] + bArr2[1]) + bArr2[2]) + bArr2[3]) + bArr2[4]) + i2) & 255);
                arrayList.add(bArr2);
                bArr3 = new byte[64];
                i6 = i4 + 1;
                i7 = 0;
                i2 = 0;
                i4 = 4;
            } else {
                bArr3 = bArr2;
                i6 = i4;
                byte b2 = b;
            }
            i5 = i4;
            i4 = i6;
            bArr2 = bArr3;
            i3 = i2;
            i2 = i7;
        }
        C2538c.c("WordLibUtil", new Object[]{"getHZKDatas() for() end index=" + i5 + ", length=" + i2});
        if (i5 > 2) {
            bArr2[0] = (byte) -86;
            bArr2[1] = TagName.APK_DOWNLOAD_URL;
            bArr2[2] = (byte) (i2 + 2);
            bArr2[3] = (byte) (i4 >> 8);
            bArr2[4] = (byte) (i4 & 255);
            Object obj = new byte[(i2 + 6)];
            i7 = 0;
            while (i < i2 + 5) {
                obj[i] = bArr2[i];
                i7 += obj[i];
                i++;
            }
            obj[i2 + 5] = (byte) (i7 & 255);
            arrayList.add(obj);
        }
        return arrayList;
    }

    private void m19840a() {
        if (this.f15328b != null) {
            m19841a(this.f15328b);
        }
    }

    private void m19841a(CountDownLatch countDownLatch) {
        if (countDownLatch != null) {
            while (!countDownLatch.await(5000, TimeUnit.MILLISECONDS)) {
                try {
                    C2538c.d("WordLibUtil", new Object[]{"Thread " + Thread.currentThread().getName() + " still waiting for WordLib ready..."});
                } catch (InterruptedException e) {
                    C2538c.d("WordLibUtil", new Object[]{"Interrupt while waiting for WordLib to be ready."});
                }
            }
        }
    }
}

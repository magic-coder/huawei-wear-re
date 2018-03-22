package com.huawei.pluginkidwatch.plugin.setting.qrcode.decoding;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.a;
import com.google.zxing.e;
import com.google.zxing.p;
import com.huawei.p190v.C2538c;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/* compiled from: DecodeThread */
public final class C1964k extends Thread {
    private Handler f6819a;
    private final Hashtable<e, Object> f6820b = new Hashtable(3);
    private Handler f6821c;
    private final CountDownLatch f6822d = new CountDownLatch(1);

    C1964k(Handler handler, Vector<a> vector, String str, p pVar) {
        this.f6819a = handler;
        if (vector == null || vector.isEmpty()) {
            vector = new Vector();
            vector.addAll(C1963j.f6815b);
            vector.addAll(C1963j.f6816c);
            vector.addAll(C1963j.f6817d);
        }
        this.f6820b.put(e.c, vector);
        if (str != null) {
            this.f6820b.put(e.e, str);
        }
        this.f6820b.put(e.j, pVar);
    }

    Handler m10228a() {
        try {
            this.f6822d.await();
        } catch (InterruptedException e) {
            C2538c.m12680e("DecodeThread", "Exception ie = " + e.getMessage());
        }
        return this.f6821c;
    }

    public void run() {
        Looper.prepare();
        this.f6821c = new DecodeHandler(this.f6819a, this.f6820b);
        this.f6822d.countDown();
        Looper.loop();
    }
}

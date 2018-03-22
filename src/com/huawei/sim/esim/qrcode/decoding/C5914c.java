package com.huawei.sim.esim.qrcode.decoding;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.C3709a;
import com.google.zxing.C3803p;
import com.google.zxing.C3880e;
import com.huawei.sim.esim.qrcode.QrCodeActivity;
import com.huawei.p190v.C2538c;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/* compiled from: DecodeThread */
public final class C5914c extends Thread {
    private final QrCodeActivity f20276a;
    private Handler f20277b;
    private final CountDownLatch f20278c = new CountDownLatch(1);
    private final Hashtable<C3880e, Object> f20279d;

    C5914c(QrCodeActivity qrCodeActivity, Vector<C3709a> vector, String str, C3803p c3803p) {
        this.f20276a = qrCodeActivity;
        this.f20279d = new Hashtable(3);
        if (vector == null || vector.isEmpty()) {
            vector = new Vector();
            vector.addAll(C5913b.f20271a);
            vector.addAll(C5913b.f20272b);
            vector.addAll(C5913b.f20274d);
        }
        this.f20279d.put(C3880e.POSSIBLE_FORMATS, vector);
        if (str != null) {
            this.f20279d.put(C3880e.CHARACTER_SET, str);
        }
        this.f20279d.put(C3880e.NEED_RESULT_POINT_CALLBACK, c3803p);
    }

    public void run() {
        Looper.prepare();
        this.f20277b = new DecodeHandler(this.f20276a, this.f20279d);
        this.f20278c.countDown();
        Looper.loop();
    }

    Handler m27179a() {
        try {
            this.f20278c.await();
        } catch (InterruptedException e) {
            C2538c.e("DecodeThread", new Object[]{"Exception ie = " + e.getMessage()});
        }
        return this.f20277b;
    }
}

package com.huawei.openalliance.ad.p112a.p124i.p126a;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.utils.C1345b;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class C1300g extends Thread {
    private Bitmap f2755A;
    private byte[] f2756B = new byte[256];
    private int f2757C = 0;
    private int f2758D = 0;
    private int f2759E = 0;
    private boolean f2760F = false;
    private int f2761G = 100;
    private final int f2762H;
    private int f2763I;
    private short[] f2764J;
    private byte[] f2765K;
    private byte[] f2766L;
    private byte[] f2767M;
    private int[] f2768N = null;
    private int f2769O = 0;
    private Queue<C1295c> f2770P = new ArrayBlockingQueue(1);
    private final ReentrantLock f2771Q = new ReentrantLock();
    private final Condition f2772R = this.f2771Q.newCondition();
    private final Condition f2773S = this.f2771Q.newCondition();
    private C1296h f2774T = null;
    public boolean f2775a = false;
    public int f2776b;
    public int f2777c;
    private boolean f2778d = false;
    private InputStream f2779e;
    private int f2780f = 0;
    private boolean f2781g;
    private boolean f2782h;
    private int f2783i;
    private int f2784j;
    private int[] f2785k = null;
    private int[] f2786l = null;
    private int[] f2787m;
    private int f2788n;
    private int f2789o;
    private int f2790p;
    private boolean f2791q;
    private int f2792r;
    private int f2793s;
    private int f2794t;
    private int f2795u;
    private int f2796v;
    private int f2797w;
    private int f2798x;
    private int f2799y;
    private Bitmap f2800z;

    public C1300g(C1296h c1296h, int i) {
        this.f2774T = c1296h;
        this.f2762H = i;
        this.f2761G = i;
    }

    private Bitmap m5764a(int[] iArr, int i, int i2) {
        return C1287e.m5680a() > 31457280 ? Bitmap.createBitmap(iArr, i, i2, Config.ARGB_8888) : Bitmap.createBitmap(iArr, i, i2, Config.RGB_565);
    }

    private void m5765a(int i) {
        if (this.f2774T != null) {
            this.f2774T.mo2444a(i);
        }
    }

    private void m5766b(int i) {
        if (this.f2767M == null || this.f2767M.length < i) {
            this.f2767M = new byte[i];
        }
        if (this.f2764J == null) {
            this.f2764J = new short[4096];
        }
        if (this.f2765K == null) {
            this.f2765K = new byte[4096];
        }
        if (this.f2766L == null) {
            this.f2766L = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
    }

    private void m5767c() {
        this.f2780f = 3;
        if (this.f2770P != null) {
            this.f2770P.clear();
            this.f2770P = null;
        }
    }

    private int[] m5768c(int i) {
        int read;
        int i2 = 0;
        int[] iArr = new int[256];
        int i3 = i * 3;
        byte[] bArr = new byte[i3];
        try {
            read = this.f2779e.read(bArr);
        } catch (Throwable e) {
            C1336d.m5883a("GifParser", "read color table fail", e);
            read = 0;
        }
        if (read < i3) {
            this.f2780f = 1;
        } else {
            read = 0;
            while (i2 < i) {
                i3 = read + 1;
                int i4 = bArr[read] & 255;
                int i5 = i3 + 1;
                int i6 = bArr[i3] & 255;
                read = i5 + 1;
                i3 = i2 + 1;
                iArr[i2] = (((i4 << 16) | ViewCompat.MEASURED_STATE_MASK) | (i6 << 8)) | (bArr[i5] & 255);
                i2 = i3;
            }
        }
        return iArr;
    }

    private void m5769d() {
        int i = 0;
        if (this.f2768N == null) {
            this.f2768N = new int[(this.f2776b * this.f2777c)];
        }
        if (this.f2759E > 0) {
            if (3 == this.f2759E) {
                this.f2755A = null;
            }
            if (this.f2755A != null) {
                this.f2755A.getPixels(this.f2768N, 0, this.f2776b, 0, 0, this.f2776b, this.f2777c);
                if (2 == this.f2759E) {
                    int i2 = !this.f2760F ? this.f2790p : 0;
                    while (i < this.f2799y) {
                        int i3 = ((this.f2797w + i) * this.f2776b) + this.f2796v;
                        int i4 = this.f2798x + i3;
                        while (i3 < i4) {
                            this.f2768N[i3] = i2;
                            i3++;
                        }
                        i++;
                    }
                }
            }
        }
    }

    private void m5770e() {
        int i = 0;
        try {
            m5769d();
            int i2 = 8;
            int i3 = 0;
            int i4 = 1;
            while (i < this.f2795u) {
                int i5;
                int i6;
                int i7;
                if (this.f2791q) {
                    if (i3 >= this.f2795u) {
                        i4++;
                        switch (i4) {
                            case 2:
                                i3 = 4;
                                break;
                            case 3:
                                i3 = 2;
                                i2 = 4;
                                break;
                            case 4:
                                i3 = 1;
                                i2 = 2;
                                break;
                        }
                    }
                    i5 = i3 + i2;
                    i6 = i2;
                    i7 = i4;
                } else {
                    i5 = i3;
                    i6 = i2;
                    i7 = i4;
                    i3 = i;
                }
                i3 += this.f2793s;
                if (i3 < this.f2777c) {
                    i4 = i3 * this.f2776b;
                    i2 = i4 + this.f2792r;
                    i3 = this.f2794t + i2;
                    int i8 = this.f2776b + i4 < i3 ? this.f2776b + i4 : i3;
                    i3 = this.f2794t * i;
                    i4 = i2;
                    while (i4 < i8) {
                        i2 = i3 + 1;
                        i3 = this.f2787m[this.f2767M[i3] & 255];
                        if (i3 != 0) {
                            this.f2768N[i4] = i3;
                        }
                        i4++;
                        i3 = i2;
                    }
                }
                i++;
                i3 = i5;
                i2 = i6;
                i4 = i7;
            }
            this.f2800z = m5764a(this.f2768N, this.f2776b, this.f2777c);
        } catch (Throwable e) {
            this.f2780f = 1;
            C1336d.m5883a("GifParser", "run out of memory", e);
            m5767c();
        } catch (Throwable e2) {
            this.f2780f = 1;
            C1336d.m5883a("GifParser", "set pixel error", e2);
        } catch (Throwable e22) {
            this.f2780f = 1;
            C1336d.m5883a("GifParser", "set pixel error", e22);
        }
    }

    private void m5771f() {
        if (this.f2779e != null) {
            m5779n();
            if (m5774i()) {
                this.f2780f = 1;
                m5765a(4);
            } else {
                m5777l();
                if (this.f2769O <= 0 || m5774i()) {
                    this.f2780f = 1;
                    m5765a(4);
                } else {
                    this.f2780f = 3;
                    this.f2778d = true;
                    m5765a(3);
                }
            }
            m5772g();
            return;
        }
        this.f2780f = 2;
        m5765a(4);
    }

    private void m5772g() {
        C1345b.m5935a(this.f2779e);
        this.f2779e = null;
    }

    private void m5773h() {
        int i;
        int i2 = this.f2794t * this.f2795u;
        m5766b(i2);
        int j = m5775j();
        int i3 = 1 << j;
        int i4 = i3 + 1;
        int i5 = i3 + 2;
        int i6 = j + 1;
        int i7 = (1 << i6) - 1;
        for (i = 0; i < i3; i++) {
            this.f2764J[i] = (short) 0;
            this.f2765K[i] = (byte) i;
        }
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = -1;
        i = 0;
        int i15 = 0;
        int i16 = i6;
        i6 = i7;
        while (i13 < i2) {
            int i17;
            if (i10 == 0) {
                if (i8 >= i16) {
                    i7 = i12 & i6;
                    i12 >>= i16;
                    i8 -= i16;
                    Object obj = (i7 > i5 || i7 == i4) ? 1 : null;
                    if (obj == null) {
                        if (i7 != i3) {
                            if (i14 != -1) {
                                if (i7 == i5) {
                                    i17 = i10 + 1;
                                    this.f2766L[i10] = (byte) i9;
                                    i9 = i14;
                                } else {
                                    i17 = i10;
                                    i9 = i7;
                                }
                                while (i9 > i3) {
                                    i10 = i17 + 1;
                                    this.f2766L[i17] = this.f2765K[i9];
                                    i9 = this.f2764J[i9];
                                    i17 = i10;
                                }
                                i9 = this.f2765K[i9] & 255;
                                if (i5 >= 4096) {
                                    break;
                                }
                                i10 = i17 + 1;
                                this.f2766L[i17] = (byte) i9;
                                this.f2764J[i5] = (short) i14;
                                this.f2765K[i5] = (byte) i9;
                                i14 = i5 + 1;
                                Object obj2 = ((i14 & i6) != 0 || i14 >= 4096) ? null : 1;
                                if (obj2 != null) {
                                    i16++;
                                    i6 += i14;
                                }
                                int i18 = i12;
                                i12 = i9;
                                i9 = i7;
                                i7 = i6;
                                i6 = i10;
                                i10 = i8;
                                i8 = i16;
                                i16 = i18;
                            } else {
                                i9 = i10 + 1;
                                this.f2766L[i10] = this.f2765K[i7];
                                i10 = i9;
                                i14 = i7;
                                i9 = i7;
                            }
                        } else {
                            i16 = j + 1;
                            i6 = (1 << i16) - 1;
                            i5 = i3 + 2;
                            i14 = -1;
                        }
                    } else {
                        break;
                    }
                }
                if (i15 == 0) {
                    i15 = m5776k();
                    if (i15 <= 0) {
                        break;
                    }
                    i = 0;
                }
                i12 += (this.f2756B[i] & 255) << i8;
                i8 += 8;
                i++;
                i15--;
            } else {
                i7 = i6;
                i6 = i10;
                i10 = i8;
                i8 = i16;
                i16 = i12;
                i12 = i9;
                i9 = i14;
                i14 = i5;
            }
            i17 = i6 - 1;
            i5 = i11 + 1;
            this.f2767M[i11] = this.f2766L[i17];
            i13++;
            i11 = i5;
            i6 = i7;
            i5 = i14;
            i14 = i9;
            i9 = i12;
            i12 = i16;
            i16 = i8;
            i8 = i10;
            i10 = i17;
        }
        for (i = i11; i < i2; i++) {
            this.f2767M[i] = (byte) 0;
        }
    }

    private boolean m5774i() {
        return this.f2780f != 0;
    }

    private int m5775j() {
        int i = 0;
        try {
            i = this.f2779e.read();
        } catch (Exception e) {
            this.f2780f = 1;
        }
        return i;
    }

    private int m5776k() {
        this.f2757C = m5775j();
        int i = 0;
        if (this.f2757C > 0) {
            while (i < this.f2757C) {
                try {
                    int read = this.f2779e.read(this.f2756B, i, this.f2757C - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                } catch (Throwable e) {
                    C1336d.m5883a("GifParser", "read block fail", e);
                }
            }
            if (i < this.f2757C) {
                this.f2780f = 1;
            }
        }
        return i;
    }

    private void m5777l() {
        int i = 0;
        while (i == 0 && !m5774i() && !this.f2775a) {
            switch (m5775j()) {
                case 0:
                    break;
                case 33:
                    switch (m5775j()) {
                        case 249:
                            m5778m();
                            break;
                        default:
                            m5785t();
                            break;
                    }
                case 44:
                    m5781p();
                    break;
                case 59:
                    i = 1;
                    break;
                default:
                    this.f2780f = 1;
                    break;
            }
        }
    }

    private void m5778m() {
        boolean z = true;
        m5775j();
        int j = m5775j();
        this.f2758D = (j & 28) >> 2;
        if (this.f2758D == 0) {
            this.f2758D = 1;
        }
        if ((j & 1) == 0) {
            z = false;
        }
        this.f2760F = z;
        this.f2761G = m5783r() * 10;
        if (this.f2762H > this.f2761G) {
            this.f2761G = this.f2762H;
        }
        this.f2763I = m5775j();
        m5775j();
    }

    private void m5779n() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            stringBuffer.append((char) m5775j());
        }
        if (stringBuffer.toString().startsWith("GIF")) {
            m5782q();
            if (this.f2781g && !m5774i()) {
                this.f2785k = m5768c(this.f2783i);
                this.f2789o = this.f2785k[this.f2788n];
                return;
            }
            return;
        }
        this.f2780f = 1;
    }

    private int m5780o() {
        int i = 0;
        this.f2792r = m5783r();
        this.f2793s = m5783r();
        this.f2794t = m5783r();
        this.f2795u = m5783r();
        int j = m5775j();
        this.f2782h = (j & 128) != 0;
        this.f2791q = (j & 64) != 0;
        this.f2784j = (int) Math.pow(2.0d, (double) ((j & 7) + 1));
        if (this.f2782h) {
            this.f2786l = m5768c(this.f2784j);
            this.f2787m = this.f2786l;
        } else {
            this.f2787m = this.f2785k;
            if (this.f2788n == this.f2763I) {
                this.f2789o = 0;
            }
        }
        if (this.f2760F && this.f2787m != null && this.f2787m.length > 0 && this.f2787m.length > this.f2763I) {
            int i2 = this.f2787m[this.f2763I];
            this.f2787m[this.f2763I] = 0;
            i = i2;
        }
        if (this.f2787m == null) {
            this.f2780f = 1;
        }
        return i;
    }

    private void m5781p() {
        int o = m5780o();
        if (!m5774i()) {
            m5773h();
            m5785t();
            if (!m5774i()) {
                m5770e();
                if (!m5774i()) {
                    try {
                        this.f2771Q.lockInterruptibly();
                        try {
                            if (this.f2770P == null || this.f2770P.size() < 1 || this.f2773S.await(3000, TimeUnit.MILLISECONDS)) {
                                if (!(this.f2770P == null || this.f2800z == null)) {
                                    this.f2769O++;
                                    this.f2770P.add(new C1295c(this.f2800z, this.f2761G));
                                    this.f2772R.signal();
                                    if (1 == this.f2769O) {
                                        this.f2778d = true;
                                        m5765a(2);
                                    }
                                }
                                this.f2771Q.unlock();
                                if (!m5774i()) {
                                    if (this.f2760F) {
                                        this.f2787m[this.f2763I] = o;
                                    }
                                    m5784s();
                                }
                            }
                            this.f2780f = 1;
                        } catch (Throwable e) {
                            this.f2773S.signal();
                            this.f2780f = 1;
                            C1336d.m5883a("GifParser", "InterruptedException", e);
                            if (!m5774i()) {
                                if (this.f2760F) {
                                    this.f2787m[this.f2763I] = o;
                                }
                                m5784s();
                            }
                        } catch (OutOfMemoryError e2) {
                            this.f2773S.signal();
                            this.f2780f = 1;
                            m5767c();
                        } finally {
                            this.f2771Q.unlock();
                        }
                    } catch (Throwable e3) {
                        C1336d.m5883a("GifParser", "require lock fail", e3);
                        this.f2780f = 1;
                    }
                }
            }
        }
    }

    private void m5782q() {
        this.f2776b = m5783r();
        this.f2777c = m5783r();
        int j = m5775j();
        this.f2781g = (j & 128) != 0;
        this.f2783i = (int) Math.pow(2.0d, (double) ((j & 7) + 1));
        this.f2788n = m5775j();
        m5775j();
    }

    private int m5783r() {
        return m5775j() | (m5775j() << 8);
    }

    private void m5784s() {
        this.f2759E = this.f2758D;
        this.f2796v = this.f2792r;
        this.f2797w = this.f2793s;
        this.f2798x = this.f2794t;
        this.f2799y = this.f2795u;
        this.f2790p = this.f2789o;
        this.f2755A = this.f2800z;
        this.f2760F = false;
        this.f2758D = 0;
        this.f2786l = null;
        this.f2761G = this.f2762H;
    }

    private void m5785t() {
        do {
            m5776k();
            if (this.f2757C <= 0) {
                return;
            }
        } while (!m5774i());
    }

    public void m5786a(Resources resources, int i) {
        try {
            this.f2779e = resources.openRawResource(i);
        } catch (NotFoundException e) {
            C1336d.m5888c("GifParser", "resId is not found");
        }
    }

    public void m5787a(String str) {
        try {
            this.f2779e = new FileInputStream(str);
        } catch (Throwable e) {
            C1336d.m5883a("GifParser", "set file source fail", e);
        }
    }

    public boolean m5788a() {
        return this.f2778d;
    }

    public C1295c m5789b() {
        C1295c c1295c;
        Throwable e;
        Throwable th;
        Throwable th2;
        Object obj;
        ReentrantLock reentrantLock = null;
        try {
            this.f2771Q.lockInterruptibly();
            try {
                if (this.f2770P.size() == 0 && this.f2780f == 0) {
                    if (this.f2772R.await(1000, TimeUnit.MILLISECONDS)) {
                        C1336d.m5888c("GifParser", "show go on:" + this.f2772R.await(1000, TimeUnit.MILLISECONDS));
                    } else {
                        C1336d.m5888c("GifParser", "wait for 1000ms, leave the show");
                        this.f2780f = 1;
                    }
                }
                c1295c = (C1295c) this.f2770P.poll();
                try {
                    this.f2773S.signal();
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C1336d.m5883a("GifParser", "get frame fail", e);
                        this.f2772R.signal();
                        this.f2771Q.unlock();
                    } catch (Throwable e3) {
                        th = e3;
                        reentrantLock = c1295c;
                        th2 = th;
                        try {
                            C1336d.m5883a("GifParser", "get lock fail", th2);
                            obj = reentrantLock;
                            this.f2774T.mo2445d();
                            return c1295c;
                        } finally {
                            reentrantLock = this.f2771Q;
                            reentrantLock.unlock();
                        }
                    }
                    this.f2774T.mo2445d();
                    return c1295c;
                }
            } catch (Throwable th22) {
                th = th22;
                c1295c = null;
                e3 = th;
                C1336d.m5883a("GifParser", "get frame fail", e3);
                this.f2772R.signal();
                this.f2771Q.unlock();
                this.f2774T.mo2445d();
                return c1295c;
            }
            this.f2771Q.unlock();
        } catch (Exception e4) {
            th22 = e4;
            C1336d.m5883a("GifParser", "get lock fail", th22);
            obj = reentrantLock;
            this.f2774T.mo2445d();
            return c1295c;
        }
        if (!(c1295c != null || this.f2780f == 0 || this.f2774T == null)) {
            this.f2774T.mo2445d();
        }
        return c1295c;
    }

    public void destroy() {
        this.f2775a = true;
        this.f2778d = false;
        m5767c();
        this.f2774T = null;
    }

    public void run() {
        try {
            m5771f();
        } catch (Throwable e) {
            C1336d.m5883a("GifParser", "parser gif image fail", e);
            this.f2780f = 1;
            m5765a(4);
        } catch (OutOfMemoryError e2) {
            this.f2780f = 1;
            m5765a(4);
            if (this.f2800z != null) {
                this.f2800z.recycle();
                this.f2800z = null;
            }
            if (this.f2755A != null) {
                this.f2755A.recycle();
                this.f2755A = null;
            }
        }
    }
}

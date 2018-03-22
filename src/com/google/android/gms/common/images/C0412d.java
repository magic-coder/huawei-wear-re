package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.internal.C0430l;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

final class C0412d implements Runnable {
    final /* synthetic */ ImageManager f349a;
    private final Uri f350b;
    private final Bitmap f351c;
    private final CountDownLatch f352d;
    private boolean f353e;

    public C0412d(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
        this.f349a = imageManager;
        this.f350b = uri;
        this.f351c = bitmap;
        this.f353e = z;
        this.f352d = countDownLatch;
    }

    private void m508a(ImageReceiver imageReceiver, boolean z) {
        ArrayList zza = imageReceiver.zzaEp;
        int size = zza.size();
        for (int i = 0; i < size; i++) {
            C0413e c0413e = (C0413e) zza.get(i);
            if (z) {
                c0413e.m510a(this.f349a.f338c, this.f351c, false);
            } else {
                this.f349a.f345j.put(this.f350b, Long.valueOf(SystemClock.elapsedRealtime()));
                c0413e.m511a(this.f349a.f338c, this.f349a.f342g, false);
            }
            if (!(c0413e instanceof C0415g)) {
                this.f349a.f343h.remove(c0413e);
            }
        }
    }

    public void run() {
        C0430l.m677a("OnBitmapLoadedRunnable must be executed in the main thread");
        boolean z = this.f351c != null;
        if (this.f349a.f341f != null) {
            if (this.f353e) {
                this.f349a.f341f.evictAll();
                System.gc();
                this.f353e = false;
                this.f349a.f339d.post(this);
                return;
            } else if (z) {
                this.f349a.f341f.put(new C0414f(this.f350b), this.f351c);
            }
        }
        ImageReceiver imageReceiver = (ImageReceiver) this.f349a.f344i.remove(this.f350b);
        if (imageReceiver != null) {
            m508a(imageReceiver, z);
        }
        this.f352d.countDown();
        synchronized (ImageManager.f336a) {
            ImageManager.f337b.remove(this.f350b);
        }
    }
}

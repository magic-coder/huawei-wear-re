package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.internal.C0430l;
import java.util.concurrent.CountDownLatch;

final class C0411c implements Runnable {
    final /* synthetic */ ImageManager f346a;
    private final Uri f347b;
    private final ParcelFileDescriptor f348c;

    public C0411c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.f346a = imageManager;
        this.f347b = uri;
        this.f348c = parcelFileDescriptor;
    }

    public void run() {
        C0430l.m678b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        boolean z = false;
        Bitmap bitmap = null;
        if (this.f348c != null) {
            try {
                bitmap = BitmapFactory.decodeFileDescriptor(this.f348c.getFileDescriptor());
            } catch (Throwable e) {
                String valueOf = String.valueOf(this.f347b);
                Log.e("ImageManager", new StringBuilder(String.valueOf(valueOf).length() + 34).append("OOM while loading bitmap for uri: ").append(valueOf).toString(), e);
                z = true;
            }
            try {
                this.f348c.close();
            } catch (Throwable e2) {
                Log.e("ImageManager", "closed failed", e2);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f346a.f339d.post(new C0412d(this.f346a, this.f347b, bitmap, z, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e3) {
            String valueOf2 = String.valueOf(this.f347b);
            Log.w("ImageManager", new StringBuilder(String.valueOf(valueOf2).length() + 32).append("Latch interrupted while posting ").append(valueOf2).toString());
        }
    }
}

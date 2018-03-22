package com.google.zxing.client.android.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.zxing.C3740c;
import com.google.zxing.C3831l;
import com.google.zxing.C3880e;
import com.google.zxing.C3931h;
import com.google.zxing.C3933j;
import com.google.zxing.client.android.C3817n;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.p278b.C3725j;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;

final class DecodeHandler extends Handler {
    private static final String f14758a = DecodeHandler.class.getSimpleName();
    private CaptureActivity f14759b;
    private final C3931h f14760c = new C3931h();
    private boolean f14761d = true;
    private C3817n f14762e = null;

    DecodeHandler(CaptureActivity captureActivity, Map<C3880e, Object> map) {
        this.f14760c.m19564a((Map) map);
        this.f14759b = captureActivity;
        this.f14762e = new C3817n(captureActivity);
    }

    public void handleMessage(Message message) {
        if (!this.f14761d) {
            return;
        }
        if (message.what == this.f14762e.m19061c("decode")) {
            m19029a((byte[]) message.obj, message.arg1, message.arg2);
        } else if (message.what == this.f14762e.m19061c("quit")) {
            this.f14761d = false;
            Looper.myLooper().quit();
        }
    }

    private void m19029a(byte[] bArr, int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = null;
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        C3933j a = this.f14759b.m18964c().m18988a(bArr2, i2, i);
        if (a != null) {
            try {
                obj = this.f14760c.m19561a(new C3740c(new C3725j(a)));
            } catch (C3831l e) {
            } catch (NullPointerException e2) {
            } finally {
                a = this.f14760c;
                a.mo4302a();
            }
        }
        Handler b = this.f14759b.m18963b();
        if (obj != null && this.f14759b.m18967f()) {
            Log.d(f14758a, "Found 1 barcode in " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            if (b != null) {
                Message obtain = Message.obtain(b, this.f14762e.m19061c("decode_succeeded"), obj);
                Bundle bundle = new Bundle();
                m19028a(a, bundle);
                obtain.setData(bundle);
                obtain.sendToTarget();
            }
        } else if (b != null) {
            Message.obtain(b, this.f14762e.m19061c("decode_failed")).sendToTarget();
        }
    }

    private static void m19028a(C3933j c3933j, Bundle bundle) {
        int[] f = c3933j.m19569f();
        int g = c3933j.m19570g();
        Bitmap createBitmap = Bitmap.createBitmap(f, 0, g, g, c3933j.m19571h(), Config.ARGB_8888);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray("barcode_bitmap", byteArrayOutputStream.toByteArray());
        bundle.putFloat("barcode_scaled_factor", ((float) g) / ((float) c3933j.m19082b()));
    }
}

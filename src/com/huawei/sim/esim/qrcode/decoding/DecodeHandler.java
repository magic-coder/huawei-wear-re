package com.huawei.sim.esim.qrcode.decoding;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.zxing.C3740c;
import com.google.zxing.C3824g;
import com.google.zxing.C3831l;
import com.google.zxing.C3880e;
import com.google.zxing.C3931h;
import com.google.zxing.p278b.C3725j;
import com.huawei.sim.esim.qrcode.QrCodeActivity;
import com.huawei.sim.esim.qrcode.p506a.C5905c;
import com.huawei.sim.g;
import com.huawei.p190v.C2538c;
import java.util.Hashtable;
import java.util.Map;

final class DecodeHandler extends Handler {
    private static final String f20264a = DecodeHandler.class.getSimpleName();
    private final C3931h f20265b = new C3931h();
    private final QrCodeActivity f20266c;

    DecodeHandler(QrCodeActivity qrCodeActivity, Hashtable<C3880e, Object> hashtable) {
        this.f20265b.m19564a((Map) hashtable);
        this.f20266c = qrCodeActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == g.sim_decode) {
            m27178a((byte[]) message.obj, message.arg1, message.arg2);
        } else if (message.what == g.sim_quit) {
            Looper.myLooper().quit();
        }
    }

    private void m27178a(byte[] bArr, int i, int i2) {
        Object a;
        C3931h c3931h = null;
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        C3824g a2 = C5905c.m27159a().m27161a(bArr2, i2, i);
        try {
            a = this.f20265b.m19561a(new C3740c(new C3725j(a2)));
        } catch (C3831l e) {
            C2538c.e(f20264a, new Object[]{"Exception re = " + e.getMessage()});
            C3931h c3931h2 = c3931h;
            if (a == null) {
                Message.obtain(this.f20266c.m27144c(), g.sim_decode_failed).sendToTarget();
            }
            Message obtain = Message.obtain(this.f20266c.m27144c(), g.sim_decode_succeeded, a);
            Bundle bundle = new Bundle();
            bundle.putParcelable("barcode_bitmap", a2.m27173f());
            obtain.setData(bundle);
            obtain.sendToTarget();
            return;
        } finally {
            c3931h = this.f20265b;
            c3931h.mo4302a();
        }
        if (a == null) {
            Message obtain2 = Message.obtain(this.f20266c.m27144c(), g.sim_decode_succeeded, a);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("barcode_bitmap", a2.m27173f());
            obtain2.setData(bundle2);
            obtain2.sendToTarget();
            return;
        }
        Message.obtain(this.f20266c.m27144c(), g.sim_decode_failed).sendToTarget();
    }
}

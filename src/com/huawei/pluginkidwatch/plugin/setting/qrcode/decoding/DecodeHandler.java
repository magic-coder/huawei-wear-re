package com.huawei.pluginkidwatch.plugin.setting.qrcode.decoding;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.zxing.b.j;
import com.google.zxing.c;
import com.google.zxing.e;
import com.google.zxing.h;
import com.google.zxing.l;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.plugin.setting.qrcode.p168a.C1947d;
import java.util.Hashtable;

final class DecodeHandler extends Handler {
    private static final String f6796a = DecodeHandler.class.getSimpleName();
    private Handler f6797b = null;
    private final h f6798c = new h();

    DecodeHandler(Handler handler, Hashtable<e, Object> hashtable) {
        this.f6798c.a(hashtable);
        this.f6797b = handler;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == g.decode) {
            m10227a((byte[]) message.obj, message.arg1, message.arg2);
        } else if (message.what == g.quit) {
            Looper.myLooper().quit();
        }
    }

    private void m10227a(byte[] bArr, int i, int i2) {
        Object a;
        h hVar = null;
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        com.google.zxing.g a2 = C1947d.m10193a().m10195a(bArr2, i2, i);
        try {
            a = this.f6798c.a(new c(new j(a2)));
        } catch (l e) {
            C2538c.m12680e(f6796a, "Exception re = " + e.getMessage());
            h hVar2 = hVar;
            if (a == null) {
                Message.obtain(this.f6797b, g.decode_failed).sendToTarget();
            }
            Message obtain = Message.obtain(this.f6797b, g.decode_succeeded, a);
            Bundle bundle = new Bundle();
            bundle.putParcelable("barcode_bitmap", a2.m10207f());
            obtain.setData(bundle);
            obtain.sendToTarget();
            return;
        } finally {
            hVar = this.f6798c;
            hVar.a();
        }
        if (a == null) {
            Message obtain2 = Message.obtain(this.f6797b, g.decode_succeeded, a);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("barcode_bitmap", a2.m10207f());
            obtain2.setData(bundle2);
            obtain2.sendToTarget();
            return;
        }
        Message.obtain(this.f6797b, g.decode_failed).sendToTarget();
    }
}

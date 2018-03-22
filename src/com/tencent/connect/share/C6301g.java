package com.tencent.connect.share;

import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p541a.C6367n;

/* compiled from: ProGuard */
final class C6301g implements Runnable {
    final /* synthetic */ String f21902a;
    final /* synthetic */ Handler f21903b;

    C6301g(String str, Handler handler) {
        this.f21902a = str;
        this.f21903b = handler;
    }

    public void run() {
        Bitmap a = C6300f.m28902a(this.f21902a, 140);
        if (a != null) {
            String a2;
            String str = Environment.getExternalStorageDirectory() + "/tmp/";
            String str2 = "share2qq_temp" + C6412y.m29264f(this.f21902a) + ".jpg";
            if (C6300f.m28908b(this.f21902a, 140, 140)) {
                C6367n.m29107b("AsynScaleCompressImage", "out of bound,compress!");
                a2 = C6300f.m28903a(a, str, str2);
            } else {
                C6367n.m29107b("AsynScaleCompressImage", "not out of bound,not compress!");
                a2 = this.f21902a;
            }
            C6367n.m29107b("AsynScaleCompressImage", "-->destFilePath: " + a2);
            if (a2 != null) {
                Message obtainMessage = this.f21903b.obtainMessage(101);
                obtainMessage.obj = a2;
                this.f21903b.sendMessage(obtainMessage);
                return;
            }
        }
        Message obtainMessage2 = this.f21903b.obtainMessage(102);
        obtainMessage2.arg1 = 3;
        this.f21903b.sendMessage(obtainMessage2);
    }
}

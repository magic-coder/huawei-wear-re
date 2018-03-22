package com.tencent.open.p532d;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.open.p541a.C6367n;
import java.io.File;

/* compiled from: ProGuard */
class C6394f implements Runnable {
    final /* synthetic */ C6392d f22227a;

    C6394f(C6392d c6392d) {
        this.f22227a = c6392d;
    }

    public void run() {
        C6367n.m29104a("AsynLoadImg", "saveFileRunnable:");
        String str = "share_qq_" + C6412y.m29264f(this.f22227a.f22221a) + ".jpg";
        String str2 = C6392d.f22220c + str;
        File file = new File(str2);
        Message obtainMessage = this.f22227a.f22224e.obtainMessage();
        if (file.exists()) {
            obtainMessage.arg1 = 0;
            obtainMessage.obj = str2;
            C6367n.m29104a("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - this.f22227a.f22223d));
        } else {
            boolean a;
            Bitmap a2 = C6392d.m29176a(this.f22227a.f22221a);
            if (a2 != null) {
                a = this.f22227a.m29183a(a2, str);
            } else {
                C6367n.m29104a("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                a = false;
            }
            if (a) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
            } else {
                obtainMessage.arg1 = 1;
            }
            C6367n.m29104a("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - this.f22227a.f22223d));
        }
        this.f22227a.f22224e.sendMessage(obtainMessage);
    }
}

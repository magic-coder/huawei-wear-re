package com.tencent.connect.share;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p541a.C6367n;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class C6302h implements Runnable {
    final /* synthetic */ ArrayList f21904a;
    final /* synthetic */ Handler f21905b;

    C6302h(ArrayList arrayList, Handler handler) {
        this.f21904a = arrayList;
        this.f21905b = handler;
    }

    public void run() {
        for (int i = 0; i < this.f21904a.size(); i++) {
            Object obj = (String) this.f21904a.get(i);
            if (!C6412y.m29265g(obj) && C6412y.m29267i(obj)) {
                Bitmap a = C6300f.m28902a((String) obj, 10000);
                if (a != null) {
                    String str = Environment.getExternalStorageDirectory() + "/tmp/";
                    String str2 = "share2qzone_temp" + C6412y.m29264f(obj) + ".jpg";
                    if (C6300f.m28908b((String) obj, 640, 10000)) {
                        C6367n.m29107b("AsynScaleCompressImage", "out of bound, compress!");
                        obj = C6300f.m28903a(a, str, str2);
                    } else {
                        C6367n.m29107b("AsynScaleCompressImage", "not out of bound,not compress!");
                    }
                    if (obj != null) {
                        this.f21904a.set(i, obj);
                    }
                }
            }
        }
        Message obtainMessage = this.f21905b.obtainMessage(101);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("images", this.f21904a);
        obtainMessage.setData(bundle);
        this.f21905b.sendMessage(obtainMessage);
    }
}

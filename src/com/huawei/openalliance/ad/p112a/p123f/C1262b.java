package com.huawei.openalliance.ad.p112a.p123f;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.huawei.openalliance.ad.inter.listener.AdListener;
import com.huawei.openalliance.ad.p112a.p113a.C1235b;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1212b;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1213c;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1216b;
import com.huawei.openalliance.ad.p112a.p122h.C1250f;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.p112a.p123f.C1261a.C1260a;
import com.huawei.openalliance.ad.p112a.p125g.C1278b;
import com.huawei.openalliance.ad.utils.C1366j;
import com.huawei.openalliance.ad.utils.p129b.C1336d;

final class C1262b implements C1250f {
    final /* synthetic */ C1278b f2680a;
    final /* synthetic */ Handler f2681b;
    final /* synthetic */ AdListener f2682c;
    final /* synthetic */ int f2683d;
    final /* synthetic */ C1216b f2684e;
    final /* synthetic */ C1216b f2685f;

    C1262b(C1278b c1278b, Handler handler, AdListener adListener, int i, C1216b c1216b, C1216b c1216b2) {
        this.f2680a = c1278b;
        this.f2681b = handler;
        this.f2682c = adListener;
        this.f2683d = i;
        this.f2684e = c1216b;
        this.f2685f = c1216b2;
    }

    public void mo2429a() {
        this.f2684e.setTime__(C1287e.m5689d());
    }

    public void mo2430a(Context context, C1212b c1212b, C1213c c1213c) {
        if (c1213c instanceof C1235b) {
            C1235b c1235b = (C1235b) c1213c;
            Message message;
            if (!this.f2680a.mo2443a(c1235b)) {
                if (this.f2681b != null) {
                    message = new Message();
                    message.obj = c1235b;
                    message.what = 1001;
                    this.f2681b.sendMessage(message);
                }
                try {
                    C1366j.f2951c.execute(new C1264d(this, context, c1235b));
                } catch (Exception e) {
                    C1336d.m5888c("AdContent", "fail to deal invalid ids and slogan");
                }
                this.f2680a.mo2442a(c1235b.getRetcode__(), this.f2682c);
                return;
            } else if (this.f2681b != null) {
                message = new Message();
                message.obj = c1235b;
                message.what = 1001;
                this.f2681b.sendMessage(message);
                this.f2680a.mo2442a(c1235b.getRetcode__(), this.f2682c);
                try {
                    C1366j.f2951c.execute(new C1260a(context, c1235b, this.f2683d, this.f2684e, this.f2685f));
                    return;
                } catch (Exception e2) {
                    C1336d.m5888c("AdContent", "execute realrsp runnable fail");
                    return;
                }
            } else {
                try {
                    C1366j.f2951c.execute(new C1263c(this, c1235b, context));
                } catch (Exception e3) {
                    C1336d.m5888c("AdContent", "delete invalid material from server fail");
                }
                this.f2680a.mo2442a(c1235b.getRetcode__(), this.f2682c);
                return;
            }
        }
        this.f2680a.mo2442a(499, this.f2682c);
    }

    public void mo2431b() {
        this.f2685f.setTime__(C1287e.m5689d());
    }
}

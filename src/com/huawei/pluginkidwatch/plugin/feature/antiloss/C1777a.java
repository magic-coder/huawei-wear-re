package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import android.os.Handler.Callback;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: AntilossActivity */
class C1777a implements Callback {
    final /* synthetic */ AntilossActivity f4926a;

    C1777a(AntilossActivity antilossActivity) {
        this.f4926a = antilossActivity;
    }

    public boolean handleMessage(Message message) {
        if (!this.f4926a.isFinishing()) {
            C2538c.m12674b("AntilossActivity", "arg0.what = " + message.what);
            switch (message.what) {
                case -1:
                case 0:
                case 3:
                    if (9 == this.f4926a.f4904w.m8303j()) {
                        this.f4926a.m8524n();
                        if (C1506g.m6977a() == null || !C1506g.m6977a().isShowing()) {
                            this.f4926a.m8540v();
                            break;
                        }
                    }
                    break;
                case 2:
                    this.f4926a.m8524n();
                    this.f4926a.m8539u();
                    break;
                case 10:
                    this.f4926a.m8528p();
                    break;
                case 10002:
                    this.f4926a.m8527o();
                    this.f4926a.m8528p();
                    break;
                default:
                    break;
            }
        }
        return false;
    }
}

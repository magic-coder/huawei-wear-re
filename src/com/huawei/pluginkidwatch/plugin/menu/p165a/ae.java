package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.os.Message;
import com.huawei.pluginkidwatch.common.ui.button.C1514c;

/* compiled from: FenceModeAdapter */
class ae implements C1514c {
    final /* synthetic */ ag f5164a;
    final /* synthetic */ ad f5165b;

    ae(ad adVar, ag agVar) {
        this.f5165b = adVar;
        this.f5164a = agVar;
    }

    public void mo2610a(boolean z) {
        this.f5164a.f5171d.setmIsOn(z);
        Message message = new Message();
        message.obj = this.f5164a.f5171d;
        message.what = 5;
        this.f5165b.f5163d.sendMessage(message);
    }
}

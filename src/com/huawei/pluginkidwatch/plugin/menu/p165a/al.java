package com.huawei.pluginkidwatch.plugin.menu.p165a;

import com.huawei.pluginkidwatch.plugin.menu.utils.C1898o;
import java.util.TimerTask;

/* compiled from: NotificationHistoryAdapter */
class al extends TimerTask {
    final /* synthetic */ ak f5192a;

    al(ak akVar) {
        this.f5192a = akVar;
    }

    public void run() {
        if (this.f5192a.f5190a.f5210D == this.f5192a.f5191b.f5178f.f5210D) {
            this.f5192a.f5190a.f5211E.setProgress(C1898o.m9673d());
            this.f5192a.f5191b.f5183k = C1898o.m9673d();
        }
    }
}

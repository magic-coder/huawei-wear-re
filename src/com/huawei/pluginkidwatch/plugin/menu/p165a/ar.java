package com.huawei.pluginkidwatch.plugin.menu.p165a;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1669v;

/* compiled from: NotificationHistoryAdapter */
class ar implements C1669v {
    final /* synthetic */ aq f5205a;

    ar(aq aqVar) {
        this.f5205a = aqVar;
    }

    public void mo2563a(int i) {
        C2538c.m12674b("NotificationHistoryAdapter", "====btnReject resultCode==" + i);
        if (13204 == i) {
            this.f5205a.f5204d.m8842a(this.f5205a.f5202b, this.f5205a.f5201a, C1680l.IDS_plugin_kidwatch_push_confirm_bind_noavail_operation_message, true);
        } else {
            this.f5205a.f5204d.m8842a(this.f5205a.f5202b, this.f5205a.f5201a, this.f5205a.f5203c, false);
        }
        this.f5205a.f5204d.f5186n = false;
    }
}

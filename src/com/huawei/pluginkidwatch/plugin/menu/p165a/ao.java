package com.huawei.pluginkidwatch.plugin.menu.p165a;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1669v;

/* compiled from: NotificationHistoryAdapter */
class ao implements C1669v {
    final /* synthetic */ an f5199a;

    ao(an anVar) {
        this.f5199a = anVar;
    }

    public void mo2563a(int i) {
        C2538c.m12674b("NotificationHistoryAdapter", "====btnReject resultCode==" + i);
        if (13204 == i) {
            this.f5199a.f5198d.m8842a(this.f5199a.f5196b, this.f5199a.f5195a, C1680l.IDS_plugin_kidwatch_push_confirm_bind_noavail_operation_message, true);
        } else {
            this.f5199a.f5198d.m8842a(this.f5199a.f5196b, this.f5199a.f5195a, this.f5199a.f5197c, false);
        }
        this.f5199a.f5198d.f5185m = false;
    }
}

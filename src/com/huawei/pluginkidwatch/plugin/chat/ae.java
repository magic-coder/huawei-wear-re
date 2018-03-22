package com.huawei.pluginkidwatch.plugin.chat;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;

/* compiled from: ChatActivity */
class ae implements Runnable {
    final /* synthetic */ ad f4807a;

    ae(ad adVar) {
        this.f4807a = adVar;
    }

    public void run() {
        C2538c.m12674b("ChatActivity", "==========startRecordTimer 到达录音时间上限");
        this.f4807a.f4806a.f4737u.setEnabled(false);
        this.f4807a.f4806a.m8447r();
        this.f4807a.f4806a.m8366a(C1680l.IDS_plugin_kidwatch_chat_long_tips, C1617f.kw_pic_chat_long);
        this.f4807a.f4806a.ay.postDelayed(new af(this), 1000);
    }
}

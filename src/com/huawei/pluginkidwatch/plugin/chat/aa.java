package com.huawei.pluginkidwatch.plugin.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.ab;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: ChatActivity */
class aa extends BroadcastReceiver {
    final /* synthetic */ ChatActivity f4803a;

    aa(ChatActivity chatActivity) {
        this.f4803a = chatActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12674b("ChatActivity", "=======Enter mReceiver onReceive");
        if (intent != null) {
            C2538c.m12674b("ChatActivity", "=======action is com.huawei.chat.refresh");
            if ("com.huawei.chat.refresh".equalsIgnoreCase(intent.getAction())) {
                this.f4803a.m8453u();
                C2538c.m12674b("ChatActivity", "=======intent.getaction:" + intent.getAction());
                ab a = C1392h.m6268a(this.f4803a.f4709Q, C1462f.m6744i(), C1462f.m6746j(), intent.getStringExtra("chat_voice_path"));
                C1744a a2 = C1744a.m8467a(a);
                if (a2 == null) {
                    C2538c.m12674b("ChatActivity", "=======BroadcastReceiver modal is null,return");
                    return;
                }
                if (1 == this.f4803a.ae) {
                    a2.f4787v = false;
                    a2.f4786u = true;
                    this.f4803a.f4702J.setVisibility(8);
                    this.f4803a.f4701I.setVisibility(0);
                }
                if (this.f4803a.f4700H != null) {
                    this.f4803a.f4700H.setVisibility(8);
                }
                if (this.f4803a.f4719c == null) {
                    this.f4803a.f4719c = new ArrayList();
                }
                if ("0".equals(a.f2994e) && a2.f4773h.intValue() != 0) {
                    this.f4803a.f4719c.add(a2);
                } else if ("1".equals(a.f2994e)) {
                    this.f4803a.f4719c.add(a2);
                }
                if (!this.f4803a.aj) {
                    C2538c.m12674b("ChatActivity", "后台没有获取完，新收到的消息加入缓存");
                    this.f4803a.f4722f.add(a2);
                }
                Collections.sort(this.f4803a.f4719c);
                this.f4803a.f4705M.m8494a(this.f4803a.ae);
                this.f4803a.m8370a(this.f4803a.f4725i);
            }
        }
    }
}

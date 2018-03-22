package com.huawei.pluginkidwatch.plugin.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;
import java.util.List;

/* compiled from: ChatActivity */
class ap implements OnClickListener {
    final /* synthetic */ List f4820a;
    final /* synthetic */ ChatActivity f4821b;

    ap(ChatActivity chatActivity, List list) {
        this.f4821b = chatActivity;
        this.f4820a = list;
    }

    public void onClick(View view) {
        this.f4821b.f4712T.cancel();
        this.f4821b.f4712T = null;
        if (this.f4820a.size() > 0) {
            for (C1744a remove : this.f4820a) {
                this.f4821b.f4719c.remove(remove);
            }
            this.f4821b.f4705M.m8494a(this.f4821b.ae);
        }
        this.f4821b.m8336F();
        this.f4821b.m8385a(this.f4820a);
    }
}

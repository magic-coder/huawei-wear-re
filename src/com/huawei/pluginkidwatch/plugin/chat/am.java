package com.huawei.pluginkidwatch.plugin.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChatActivity */
class am implements OnClickListener {
    final /* synthetic */ ChatActivity f4816a;

    am(ChatActivity chatActivity) {
        this.f4816a = chatActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("ChatActivity", "=====Enter deleteClickListener");
        if (this.f4816a.f4719c == null || this.f4816a.f4719c.size() == 0) {
            C2538c.m12674b("ChatActivity", "====return;");
            return;
        }
        List arrayList = new ArrayList();
        for (C1744a c1744a : this.f4816a.f4719c) {
            C2538c.m12674b("ChatActivity", "====returdeleteClickListener arr:" + c1744a.toString());
            if (c1744a.f4786u && c1744a.f4787v) {
                arrayList.add(c1744a);
            }
        }
        if (arrayList.size() > 0) {
            this.f4816a.m8396b(arrayList);
        } else if (!this.f4816a.ag) {
            this.f4816a.ag = true;
            this.f4816a.ay.postDelayed(this.f4816a.at, 3000);
            C1483c.m6824a(this.f4816a.f4709Q, C1680l.IDS_plugin_kidwatch_chat_please_select_message_to_delete);
        }
    }
}

package com.huawei.pluginkidwatch.plugin.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.p138a.ab;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;
import java.util.Collections;

/* compiled from: ChatActivity */
class C1748b implements OnClickListener {
    final /* synthetic */ ChatActivity f4839a;

    C1748b(ChatActivity chatActivity) {
        this.f4839a = chatActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("ChatActivity", "=====sendTextListener-->onClick");
        String obj = this.f4839a.f4740x.getText().toString();
        if (obj != null && obj.trim().length() != 0) {
            ab a = this.f4839a.m8360a(obj, this.f4839a.m8463z());
            this.f4839a.m8453u();
            C1744a a2 = C1744a.m8467a(a);
            if (a2 == null) {
                C2538c.m12674b("ChatActivity", "=======sendTextListener modal is null,return");
                return;
            }
            if (1 == this.f4839a.ae) {
                a2.f4787v = false;
                a2.f4786u = true;
            }
            this.f4839a.f4740x.setText("");
            this.f4839a.f4719c.add(a2);
            if (!this.f4839a.aj) {
                C2538c.m12674b("ChatActivity", "后台没有获取完，新发的消息加入缓存");
                this.f4839a.f4722f.add(a2);
            }
            Collections.sort(this.f4839a.f4719c);
            this.f4839a.f4705M.m8494a(this.f4839a.ae);
            this.f4839a.m8370a(this.f4839a.f4725i);
            this.f4839a.m8405c(a2);
        } else if (!this.f4839a.ag) {
            this.f4839a.ag = true;
            this.f4839a.ay.postDelayed(this.f4839a.at, 3000);
            C1483c.m6832c(this.f4839a.f4709Q, "请输入文字");
        }
    }
}

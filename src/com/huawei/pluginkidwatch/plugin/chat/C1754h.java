package com.huawei.pluginkidwatch.plugin.chat;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;

/* compiled from: ChatActivity */
class C1754h implements OnLongClickListener {
    final /* synthetic */ ChatActivity f4846a;

    C1754h(ChatActivity chatActivity) {
        this.f4846a = chatActivity;
    }

    public boolean onLongClick(View view) {
        C2538c.m12674b("ChatActivity", "=====_cellLongClickListener-->onClick:isInitMsglist=" + this.f4846a.aj);
        if (this.f4846a.aj && this.f4846a.f4719c != null && this.f4846a.f4719c.size() > 0) {
            for (C1744a c1744a : this.f4846a.f4719c) {
                c1744a.f4786u = true;
                c1744a.f4787v = false;
            }
            this.f4846a.ae = 1;
            this.f4846a.f4705M.m8494a(this.f4846a.ae);
            this.f4846a.f4742z.setVisibility(8);
            this.f4846a.f4693A.setVisibility(0);
            this.f4846a.f4695C.setVisibility(0);
            this.f4846a.f4701I.setVisibility(0);
            this.f4846a.f4702J.setVisibility(8);
            this.f4846a.f4714V.setBackBtnBackground(this.f4846a.getResources().getDrawable(C1617f.title_delete));
            this.f4846a.f4714V.getBackBt().setVisibility(0);
            this.f4846a.f4714V.getBackBt().setOnClickListener(this.f4846a.aw);
            this.f4846a.m8397b(true);
        }
        return false;
    }
}

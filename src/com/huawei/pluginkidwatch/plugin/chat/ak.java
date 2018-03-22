package com.huawei.pluginkidwatch.plugin.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: ChatActivity */
class ak implements OnClickListener {
    final /* synthetic */ ChatActivity f4814a;

    ak(ChatActivity chatActivity) {
        this.f4814a = chatActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2538c.m12674b("ChatActivity", "=====Enter setNegativeButton");
        this.f4814a.f4713U.dismiss();
    }
}

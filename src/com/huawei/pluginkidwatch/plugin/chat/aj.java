package com.huawei.pluginkidwatch.plugin.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: ChatActivity */
class aj implements OnClickListener {
    final /* synthetic */ ChatActivity f4813a;

    aj(ChatActivity chatActivity) {
        this.f4813a = chatActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2538c.m12674b("ChatActivity", "=====Enter setPositiveButton");
        this.f4813a.f4713U.dismiss();
        this.f4813a.finish();
    }
}

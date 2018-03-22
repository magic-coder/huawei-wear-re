package com.huawei.pluginkidwatch.plugin.chat;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1745b;

/* compiled from: ChatActivity */
class C1767u implements OnCompletionListener {
    final /* synthetic */ ChatActivity f4860a;

    C1767u(ChatActivity chatActivity) {
        this.f4860a = chatActivity;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        C2538c.m12674b("ChatActivity", "==========playRecord onCompletion");
        C1745b.m8476a(this.f4860a.f4709Q, false);
        for (C1744a c1744a : this.f4860a.f4719c) {
            c1744a.f4774i = false;
        }
        this.f4860a.f4705M.m8494a(this.f4860a.ae);
        this.f4860a.f4707O.stop();
        this.f4860a.f4707O.release();
        this.f4860a.f4707O = null;
    }
}

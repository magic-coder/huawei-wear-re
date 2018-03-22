package com.huawei.pluginkidwatch.plugin.chat;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.huawei.p190v.C2538c;

/* compiled from: ChatActivity */
class C1768v implements OnErrorListener {
    final /* synthetic */ ChatActivity f4861a;

    C1768v(ChatActivity chatActivity) {
        this.f4861a = chatActivity;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        C2538c.m12674b("ChatActivity", "playRecord onError:what" + String.valueOf(i) + ",extra:" + String.valueOf(i2));
        return false;
    }
}

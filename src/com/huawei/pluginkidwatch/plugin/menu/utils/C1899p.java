package com.huawei.pluginkidwatch.plugin.menu.utils;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

/* compiled from: MediaPlayerHelper */
final class C1899p implements OnPreparedListener {
    final /* synthetic */ Runnable f6220a;

    C1899p(Runnable runnable) {
        this.f6220a = runnable;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        if (this.f6220a != null) {
            this.f6220a.run();
        }
        C1898o.f6219a.start();
    }
}

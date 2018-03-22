package com.huawei.pluginkidwatch.plugin.menu.utils;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/* compiled from: MediaPlayerHelper */
final class C1900q implements OnCompletionListener {
    final /* synthetic */ Runnable f6221a;

    C1900q(Runnable runnable) {
        this.f6221a = runnable;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.f6221a != null) {
            this.f6221a.run();
        }
    }
}

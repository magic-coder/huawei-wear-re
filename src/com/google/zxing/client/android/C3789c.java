package com.google.zxing.client.android;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/* compiled from: BeepManager */
class C3789c implements OnCompletionListener {
    final /* synthetic */ C3782b f14733a;

    C3789c(C3782b c3782b) {
        this.f14733a = c3782b;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.seekTo(0);
    }
}

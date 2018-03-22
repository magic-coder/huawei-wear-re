package com.huawei.pluginaf500.ui;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

/* compiled from: FindPhoneActivity */
class ai implements OnErrorListener {
    final /* synthetic */ FindPhoneActivity f19884a;

    ai(FindPhoneActivity findPhoneActivity) {
        this.f19884a = findPhoneActivity;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        mediaPlayer.stop();
        mediaPlayer.release();
        this.f19884a.f19731d = null;
        return false;
    }
}

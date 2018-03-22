package com.huawei.pluginaf500.ui;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/* compiled from: RemoteTakePictureActivity */
class az implements OnCompletionListener {
    final /* synthetic */ RemoteTakePictureActivity f19903a;

    az(RemoteTakePictureActivity remoteTakePictureActivity) {
        this.f19903a = remoteTakePictureActivity;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (mediaPlayer == this.f19903a.f19797o) {
            this.f19903a.f19800r = false;
        }
    }
}

package com.huawei.pluginaf500.ui;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

/* compiled from: RemoteTakePictureActivity */
class ba implements OnErrorListener {
    final /* synthetic */ RemoteTakePictureActivity f19921a;

    ba(RemoteTakePictureActivity remoteTakePictureActivity) {
        this.f19921a = remoteTakePictureActivity;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (mediaPlayer == this.f19921a.f19797o && this.f19921a.f19797o != null) {
            try {
                this.f19921a.f19797o.stop();
                this.f19921a.f19797o.release();
                this.f19921a.f19797o = null;
                this.f19921a.f19800r = false;
            } catch (IllegalStateException e) {
            }
        }
        return false;
    }
}

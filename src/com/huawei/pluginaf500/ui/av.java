package com.huawei.pluginaf500.ui;

import android.hardware.Camera.ShutterCallback;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;

/* compiled from: RemoteTakePictureActivity */
class av implements ShutterCallback {
    final /* synthetic */ RemoteTakePictureActivity f19899a;

    av(RemoteTakePictureActivity remoteTakePictureActivity) {
        this.f19899a = remoteTakePictureActivity;
    }

    public void onShutter() {
        if (((AudioManager) this.f19899a.getSystemService("audio")).getStreamVolume(5) != 0) {
            if (this.f19899a.f19797o == null) {
                this.f19899a.f19797o = MediaPlayer.create(this.f19899a, Uri.parse("file:///system/media/audio/ui/camera_click.ogg"));
                this.f19899a.f19797o.reset();
            } else {
                this.f19899a.f19797o.reset();
            }
            if (this.f19899a.f19797o != null) {
                this.f19899a.f19797o.start();
                this.f19899a.f19797o.setOnCompletionListener(this.f19899a.f19798p);
                this.f19899a.f19797o.setOnErrorListener(this.f19899a.f19799q);
                this.f19899a.f19800r = true;
            }
        }
    }
}

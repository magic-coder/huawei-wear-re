package com.huawei.pluginaf500.ui;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

/* compiled from: RemoteTakePictureActivity */
class ax implements PreviewCallback {
    final /* synthetic */ RemoteTakePictureActivity f19901a;

    ax(RemoteTakePictureActivity remoteTakePictureActivity) {
        this.f19901a = remoteTakePictureActivity;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.f19901a.f19779L) {
            this.f19901a.f19779L = false;
            this.f19901a.f19793k.setVisibility(0);
        }
    }
}

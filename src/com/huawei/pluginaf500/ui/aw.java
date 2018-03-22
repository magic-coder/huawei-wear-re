package com.huawei.pluginaf500.ui;

import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import com.huawei.p190v.C2538c;

/* compiled from: RemoteTakePictureActivity */
class aw implements PictureCallback {
    final /* synthetic */ RemoteTakePictureActivity f19900a;

    aw(RemoteTakePictureActivity remoteTakePictureActivity) {
        this.f19900a = remoteTakePictureActivity;
    }

    public void onPictureTaken(byte[] bArr, Camera camera) {
        C2538c.b("RemoteTakePictureActivity", new Object[]{"onPictureTaken camera:" + camera});
        this.f19900a.f19801s = false;
        this.f19900a.f19802t = true;
        if (this.f19900a.f19789g != null) {
            this.f19900a.f19789g.startPreview();
        }
        new bb().m26880a(bArr);
        new bc(this.f19900a).execute(new bb[]{r0});
    }
}

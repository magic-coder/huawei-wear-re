package com.huawei.pluginaf500.ui;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.widget.Toast;
import com.huawei.p190v.C2538c;

/* compiled from: RemoteTakePictureActivity */
class au implements AutoFocusCallback {
    final /* synthetic */ RemoteTakePictureActivity f19898a;

    au(RemoteTakePictureActivity remoteTakePictureActivity) {
        this.f19898a = remoteTakePictureActivity;
    }

    public void onAutoFocus(boolean z, Camera camera) {
        if (z && this.f19898a.f19789g != null) {
            this.f19898a.f19789g.setOneShotPreviewCallback(null);
        }
        if (this.f19898a.f19778K) {
            this.f19898a.f19778K = false;
            try {
                if (this.f19898a.f19789g != null) {
                    this.f19898a.f19789g.takePicture(this.f19898a.f19782O, null, this.f19898a.f19783P);
                }
            } catch (Exception e) {
                C2538c.e("RemoteTakePictureActivity", new Object[]{"Exception e = " + e.getMessage()});
                Toast.makeText(this.f19898a, "TakePicture failed", 0).show();
            }
        }
    }
}

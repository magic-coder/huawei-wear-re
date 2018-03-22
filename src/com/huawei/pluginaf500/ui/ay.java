package com.huawei.pluginaf500.ui;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.huawei.pluginaf500.h;
import java.util.List;

/* compiled from: RemoteTakePictureActivity */
class ay implements OnClickListener {
    final /* synthetic */ RemoteTakePictureActivity f19902a;

    ay(RemoteTakePictureActivity remoteTakePictureActivity) {
        this.f19902a = remoteTakePictureActivity;
    }

    public void onClick(View view) {
        if (view == this.f19902a.f19791i) {
            if (this.f19902a.f19789g != null) {
                this.f19902a.m26765k();
                this.f19902a.f19789g.release();
                this.f19902a.f19789g = null;
            }
            if (VERSION.SDK_INT >= 9) {
                int numberOfCameras = Camera.getNumberOfCameras();
                CameraInfo cameraInfo = new CameraInfo();
                for (int i = 0; i < numberOfCameras; i++) {
                    Camera.getCameraInfo(i, cameraInfo);
                    if (this.f19902a.f19796n != 0) {
                        if (this.f19902a.f19796n == 1 && cameraInfo.facing == 1) {
                            this.f19902a.f19794l = i;
                            this.f19902a.f19796n = 0;
                            break;
                        }
                    } else if (cameraInfo.facing != 1) {
                        this.f19902a.f19794l = i;
                        this.f19902a.f19796n = 1;
                        break;
                    }
                }
                if (this.f19902a.f19794l == this.f19902a.f19795m) {
                    this.f19902a.f19796n = 0;
                } else {
                    this.f19902a.f19796n = 1;
                }
                this.f19902a.f19789g = Camera.open(this.f19902a.f19794l);
            } else {
                this.f19902a.f19794l = 0;
                this.f19902a.f19796n = 1;
                this.f19902a.f19789g = Camera.open();
            }
            this.f19902a.surfaceChanged(this.f19902a.f19805w, this.f19902a.f19769B, this.f19902a.f19808z, this.f19902a.f19768A);
        } else if (view == this.f19902a.f19793k) {
            this.f19902a.f19778K = true;
            if (this.f19902a.f19801s) {
                if (!this.f19902a.f19803u) {
                    Toast.makeText(this.f19902a, this.f19902a.getString(h.is_taking_picture), 0).show();
                }
            } else if (this.f19902a.f19802t) {
                if (!this.f19902a.f19803u) {
                    Toast.makeText(this.f19902a, this.f19902a.getString(h.is_saving_picture), 0).show();
                }
            } else if (!this.f19902a.f19800r) {
                this.f19902a.m26763j();
                List supportedFocusModes = this.f19902a.f19790h.getSupportedFocusModes();
                if (supportedFocusModes == null || !supportedFocusModes.contains("continuous-picture")) {
                    this.f19902a.f19801s = true;
                    this.f19902a.f19778K = false;
                    if (this.f19902a.f19789g != null) {
                        this.f19902a.f19789g.autoFocus(null);
                        this.f19902a.f19789g.takePicture(this.f19902a.f19782O, null, this.f19902a.f19783P);
                        return;
                    }
                    return;
                }
                this.f19902a.f19801s = true;
                this.f19902a.f19790h.setFocusMode("continuous-picture");
                if (this.f19902a.f19789g != null) {
                    this.f19902a.f19789g.autoFocus(this.f19902a.f19781N);
                }
            }
        }
    }
}

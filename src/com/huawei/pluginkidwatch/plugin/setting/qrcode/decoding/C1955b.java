package com.huawei.pluginkidwatch.plugin.setting.qrcode.decoding;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import com.google.zxing.m;
import com.huawei.p190v.C2538c;

/* compiled from: CaptureActivityHandler */
class C1955b implements OnDismissListener {
    final /* synthetic */ String f6800a;
    final /* synthetic */ m f6801b;
    final /* synthetic */ Bitmap f6802c;
    final /* synthetic */ CaptureActivityHandler f6803d;

    C1955b(CaptureActivityHandler captureActivityHandler, String str, m mVar, Bitmap bitmap) {
        this.f6803d = captureActivityHandler;
        this.f6800a = str;
        this.f6801b = mVar;
        this.f6802c = bitmap;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f6803d.f6790d) {
            C2538c.m12674b(CaptureActivityHandler.f6787a, "===www123=======设备选择错误，继续向下走");
            this.f6803d.m10215a(this.f6800a, this.f6801b, this.f6802c);
        }
    }
}

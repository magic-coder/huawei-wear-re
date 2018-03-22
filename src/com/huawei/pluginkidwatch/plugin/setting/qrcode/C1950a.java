package com.huawei.pluginkidwatch.plugin.setting.qrcode;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.plugin.setting.activity.BindbyQrActivity;

/* compiled from: QrCodeActivity */
class C1950a implements OnClickListener {
    final /* synthetic */ QrCodeActivity f6783a;

    C1950a(QrCodeActivity qrCodeActivity) {
        this.f6783a = qrCodeActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setPackage(this.f6783a.getPackageName());
        intent.setClass(this.f6783a, BindbyQrActivity.class);
        intent.putExtra("qrcode_album", "1");
        this.f6783a.startActivity(intent);
    }
}

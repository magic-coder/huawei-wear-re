package com.huawei.pluginkidwatch.plugin.setting.qrcode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.pluginkidwatch.plugin.setting.activity.BindbyQrActivity;

/* compiled from: QrCodeActivity */
class C1969e implements OnDismissListener {
    final /* synthetic */ QrCodeActivity f6827a;

    C1969e(QrCodeActivity qrCodeActivity) {
        this.f6827a = qrCodeActivity;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f6827a.f6747k) {
            this.f6827a.startActivity(new Intent("android.settings.SETTINGS"));
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.f6827a, BindbyQrActivity.class);
        intent.putExtra("qrcode_result", "");
        intent.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        this.f6827a.startActivity(intent);
    }
}

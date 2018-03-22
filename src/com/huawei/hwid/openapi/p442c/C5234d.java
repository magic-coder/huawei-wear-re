package com.huawei.hwid.openapi.p442c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.huawei.hwid.openapi.OpenHwID;

class C5234d implements OnClickListener {
    final /* synthetic */ C5231a f18865a;

    C5234d(C5231a c5231a) {
        this.f18865a = c5231a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        String accessToken = OpenHwID.getAccessToken(this.f18865a.f18860d, this.f18865a.f18861e, null, null);
        if (TextUtils.isEmpty(accessToken)) {
            this.f18865a.m25390g();
        } else {
            this.f18865a.m25383a(accessToken);
        }
    }
}

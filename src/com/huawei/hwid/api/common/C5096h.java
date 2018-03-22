package com.huawei.hwid.api.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: FingerBroadcastReceiver */
class C5096h extends BroadcastReceiver {
    private Context f18380a;
    private CloudRequestHandler f18381b;
    private boolean f18382c = false;

    public C5096h(Context context, CloudRequestHandler cloudRequestHandler) {
        this.f18380a = context;
        this.f18381b = cloudRequestHandler;
    }

    public void onReceive(Context context, Intent intent) {
        if (!this.f18382c) {
            Bundle bundle;
            try {
                bundle = new Bundle();
                bundle.putBoolean("FingerBroadcastReceiver", true);
                C5088d.m24471a(this.f18380a, bundle);
            } catch (Throwable e) {
                C5165e.m24909c("FingerBroadcastReceiver", e.getMessage(), e);
            }
            this.f18382c = true;
            if (intent != null) {
                String action = intent.getAction();
                C5088d.m24507e(context);
                try {
                    if ("com.huawei.cloudserive.fingerSuccess".equals(action)) {
                        if (this.f18381b != null) {
                            C5088d.m24469a(context, intent);
                            bundle = intent.getBundleExtra(HwAccountConstants.EXTRA_BUNDLE);
                            if (bundle == null) {
                                bundle = new Bundle();
                            }
                            this.f18381b.onFinish(bundle);
                        }
                    } else if ("com.huawei.cloudserive.fingerCancel".equals(action)) {
                        ErrorStatus errorStatus = new ErrorStatus(3002, "use the sdk: press cancel or back key");
                        C5165e.m24912e("FingerBroadcastReceiver", "error: " + errorStatus.toString());
                        if (this.f18381b != null) {
                            this.f18381b.onError(errorStatus);
                        }
                    }
                } catch (RuntimeException e2) {
                    C5165e.m24906b("FingerBroadcastReceiver", "BroadcastReceiver components are not allowed to register to receive intents");
                }
            }
        }
    }
}

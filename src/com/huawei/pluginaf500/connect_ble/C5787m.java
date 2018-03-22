package com.huawei.pluginaf500.connect_ble;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import com.fenda.hwbracelet.connection.C3596n;
import com.huawei.pluginaf500.e;

/* compiled from: ScanBleDeviceActivity */
class C5787m extends BroadcastReceiver {
    final /* synthetic */ ScanBleDeviceActivity f19629a;

    C5787m(ScanBleDeviceActivity scanBleDeviceActivity) {
        this.f19629a = scanBleDeviceActivity;
    }

    public void onReceive(Context context, Intent intent) {
        switch (C3596n.m18054a()) {
            case 0:
                if (this.f19629a.f19594p != null) {
                    this.f19629a.f19594p.cancel();
                    this.f19629a.f19594p = null;
                }
                this.f19629a.f19590l = false;
                if (!this.f19629a.f19595q) {
                    this.f19629a.m26527b(e.jump_btn_layout);
                    this.f19629a.m26530c(e.scan_fail);
                    return;
                }
                return;
            case 2:
                this.f19629a.f19590l = true;
                if (!this.f19629a.f19595q) {
                    this.f19629a.m26541k();
                    return;
                }
                return;
            case 3:
                this.f19629a.f19590l = false;
                this.f19629a.f19595q = true;
                if (this.f19629a.f19594p != null) {
                    this.f19629a.f19594p.cancel();
                    this.f19629a.f19594p = null;
                }
                this.f19629a.m26527b(e.bind_success_btn_layout);
                this.f19629a.m26530c(e.scan_success);
                ((Button) this.f19629a.findViewById(e.done_btn)).setEnabled(true);
                return;
            default:
                return;
        }
    }
}

package com.huawei.pluginaf500.connect_ble;

import android.os.Handler;
import android.os.Message;
import com.huawei.pluginaf500.e;

/* compiled from: ScanBleDeviceActivity */
class C5786l extends Handler {
    final /* synthetic */ ScanBleDeviceActivity f19628a;

    C5786l(ScanBleDeviceActivity scanBleDeviceActivity) {
        this.f19628a = scanBleDeviceActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 0:
                this.f19628a.f19589k = true;
                this.f19628a.f19590l = false;
                this.f19628a.f19586h.clear();
                if (this.f19628a.f19593o != null) {
                    this.f19628a.f19593o.m26930a(false);
                    this.f19628a.f19593o.m26932c();
                }
                this.f19628a.m26530c(e.scan_view);
                this.f19628a.m26527b(e.scan_cancel_btn_layout);
                return;
            case 1:
                this.f19628a.f19589k = false;
                if (this.f19628a.f19593o != null) {
                    this.f19628a.f19593o.m26930a(true);
                }
                if (!this.f19628a.f19590l) {
                    if (this.f19628a.f19586h.size() == 0) {
                        this.f19628a.m26527b(e.jump_btn_layout);
                        this.f19628a.m26530c(e.scan_fail);
                        return;
                    }
                    this.f19628a.f19583b.setText(((BleDeviceInfo) this.f19628a.f19586h.get(0)).deviceName + ":" + ((BleDeviceInfo) this.f19628a.f19586h.get(0)).address);
                    this.f19628a.m26530c(e.scan_dev_list);
                    this.f19628a.m26527b(e.jump_btn_layout);
                    return;
                }
                return;
            case 3:
                this.f19628a.m26522a((BleDeviceInfo) message.obj);
                return;
            case 4:
                this.f19628a.f19592n.setImageBitmap(this.f19628a.f19593o.m26929a());
                return;
            default:
                return;
        }
    }
}

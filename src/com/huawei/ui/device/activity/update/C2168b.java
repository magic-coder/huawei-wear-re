package com.huawei.ui.device.activity.update;

import android.os.Message;
import android.text.TextUtils;
import com.huawei.hwservicesmgr.C1053k;
import com.huawei.p190v.C2538c;

/* compiled from: DeviceOtaActivity */
class C2168b extends C1053k {
    final /* synthetic */ DeviceOtaActivity f7748a;

    C2168b(DeviceOtaActivity deviceOtaActivity) {
        this.f7748a = deviceOtaActivity;
    }

    public void mo2630a(int i) {
        C2538c.m12677c("DeviceOtaActivity", "onFileTransferState percentage = " + i);
        if (this.f7748a.f7710x != null) {
            Message obtainMessage = this.f7748a.f7710x.obtainMessage();
            if (this.f7748a.f7706s == null) {
                C2538c.m12677c("DeviceOtaActivity", "mOtaInteractors is null");
            } else if (1 == this.f7748a.f7706s.m10331b()) {
                C2538c.m12677c("DeviceOtaActivity", "IOTAResultAIDLCallback V1 ");
                if (100 == i) {
                    C2538c.m12677c("DeviceOtaActivity", "IOTAResultAIDLCallback V1 100 ");
                    obtainMessage.what = 5;
                    this.f7748a.f7710x.sendMessage(obtainMessage);
                    return;
                }
                obtainMessage.what = 4;
                obtainMessage.arg1 = i;
                C2538c.m12677c("DeviceOtaActivity", "onFileTransferState percentage = " + i);
                this.f7748a.f7710x.sendMessage(obtainMessage);
            } else {
                obtainMessage.what = 4;
                obtainMessage.arg1 = i;
                C2538c.m12677c("DeviceOtaActivity", "onFileTransferState percentage = " + i);
                this.f7748a.f7710x.sendMessage(obtainMessage);
            }
        }
    }

    public void mo2631a(int i, String str) {
        C2538c.m12677c("DeviceOtaActivity", "onUpgradeFailed: onUpgradeFailed = " + i + " errorMessage = " + str);
        if (this.f7748a.f7706s != null) {
            C2538c.m12677c("DeviceOtaActivity", "is transfering :" + this.f7748a.f7706s.m10329a());
            this.f7748a.f7706s.m10325a(Boolean.valueOf(false));
        } else {
            C2538c.m12677c("DeviceOtaActivity", "mOtaInteractors is null");
        }
        if (i == 1 && this.f7748a.f7712z) {
            C2538c.m12677c("DeviceOtaActivity", "单板升级超时为上次失败");
        } else if (this.f7748a.f7710x != null) {
            Message obtainMessage = this.f7748a.f7710x.obtainMessage();
            obtainMessage.what = 6;
            obtainMessage.arg1 = i;
            if (109002 == i && !TextUtils.isEmpty(str)) {
                DeviceOtaActivity.f7684w = Integer.parseInt(str);
                C2538c.m12677c("DeviceOtaActivity", "单板升级电量门限值为：" + DeviceOtaActivity.f7684w);
            }
            this.f7748a.f7710x.sendMessage(obtainMessage);
        }
    }

    public void mo2632b(int i) {
        C2538c.m12677c("DeviceOtaActivity", "onFileRespond: checkResult = " + i);
        if (this.f7748a.f7706s != null) {
            C2538c.m12677c("DeviceOtaActivity", "is transfering :" + this.f7748a.f7706s.m10329a());
            this.f7748a.f7706s.m10325a(Boolean.valueOf(false));
            this.f7748a.f7706s.m10351r();
        } else {
            C2538c.m12677c("DeviceOtaActivity", "mOtaInteractors is null");
        }
        if (this.f7748a.f7710x == null) {
            return;
        }
        if (i != 0) {
            Message obtainMessage = this.f7748a.f7710x.obtainMessage();
            obtainMessage.what = 5;
            this.f7748a.f7710x.sendMessage(obtainMessage);
            return;
        }
        C2538c.m12677c("DeviceOtaActivity", "DeviceUpgradeCallback, i != 1");
        obtainMessage = this.f7748a.f7710x.obtainMessage();
        obtainMessage.what = 6;
        obtainMessage.arg1 = 1002;
        this.f7748a.f7710x.sendMessage(obtainMessage);
    }
}

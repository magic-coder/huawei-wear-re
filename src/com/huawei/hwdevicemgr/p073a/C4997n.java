package com.huawei.hwdevicemgr.p073a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.p190v.C2538c;

/* compiled from: OTATransferFile */
class C4997n extends Handler {
    final /* synthetic */ C4991j f18115a;

    public C4997n(C4991j c4991j, Looper looper) {
        this.f18115a = c4991j;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                if (this.f18115a.f18108w != null) {
                    this.f18115a.f18108w.getLooper().quit();
                    this.f18115a.f18108w = null;
                    this.f18115a.f18109x = null;
                }
                C2538c.c("OTATransferFile", new Object[]{"WAIT_CRC_CHECK_TIMEOUT, set crc result 1"});
                if (this.f18115a.f18104s != null) {
                    this.f18115a.f18104s.b(1);
                }
                this.f18115a.f18095j = 0;
                this.f18115a.f18096k = false;
                return;
            case 3:
                C2538c.e("OTATransferFile", new Object[]{"Wait dfu respond timeout"});
                this.f18115a.f18103r = false;
                if (this.f18115a.f18106u.size() > 0) {
                    this.f18115a.f18106u.clear();
                }
                if (this.f18115a.f18107v != null) {
                    this.f18115a.f18107v.mo4606a(104005, "没有回复ACK");
                    this.f18115a.f18107v = null;
                    this.f18115a.f18105t = null;
                    return;
                }
                return;
            case 6:
                if (this.f18115a.f18104s != null) {
                    C2538c.e("OTATransferFile", new Object[]{"Wait V2 OTA upgrade timeout!!!"});
                    this.f18115a.f18104s.a(1, "wait time out !!!");
                    this.f18115a.f18083I = true;
                    return;
                }
                return;
            case 7:
                if (this.f18115a.f18104s != null) {
                    C2538c.e("OTATransferFile", new Object[]{"B0 OTA upgrade timeout!!!"});
                    this.f18115a.f18104s.a(0, "wait time out !!!");
                    return;
                }
                return;
            default:
                return;
        }
    }
}

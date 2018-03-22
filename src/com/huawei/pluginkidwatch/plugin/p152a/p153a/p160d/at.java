package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1690h;

/* compiled from: SendCommandUtil */
class at implements C1690h {
    final /* synthetic */ as f4489a;

    at(as asVar) {
        this.f4489a = asVar;
    }

    public void mo2570a(int i, byte[] bArr) {
    }

    public void mo2569a(int i, String str) {
        C2538c.m12680e("SendCommandUtil", "=Enter onErrorHappen(): errorCode=" + i + ", errorMsg=" + str);
        this.f4489a.m7991a(this.f4489a.f4480f, i, str);
    }

    public void mo2568a(int i) {
        C2538c.m12674b("SendCommandUtil", "Enter onDeviceConnectionStateChanged() state=" + i + ", while(STATE_UNKNOWN=" + 0 + ", STATE_CONNECTING=" + 1 + ", STATE_CONNECTED=" + 2 + ", STATE_DISCONNECTED=" + 3 + ", STATE_PAIRING=" + 4 + ", unPairFlag=" + this.f4489a.f4487n);
        synchronized (this.f4489a.f4478d) {
            C2538c.m12674b("SendCommandUtil", "Enter onDeviceConnectionStateChanged() bondInfoAvailableFlag = " + this.f4489a.f4488o);
        }
        if (3 != i && i != 0) {
            this.f4489a.m7987a(i, false);
            this.f4489a.f4487n = false;
        } else if (!this.f4489a.f4487n) {
            this.f4489a.m7987a(i, false);
        } else if (!C1705k.m8107d()) {
            this.f4489a.m7987a(i, false);
        }
    }
}

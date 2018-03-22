package com.unionpay.blepayservice;

import android.os.RemoteException;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.p190v.C2538c;

/* compiled from: PayService */
class C2681g extends C2679e {
    final /* synthetic */ PayService f9092a;

    C2681g(PayService payService) {
        this.f9092a = payService;
    }

    public int mo2921a() throws RemoteException {
        C2538c.m12677c("PayService", "close");
        return 0;
    }

    public boolean mo2923b() throws RemoteException {
        C2538c.m12677c("PayService", "isClosed");
        return false;
    }

    public byte[] mo2922a(byte[] bArr) throws RemoteException {
        C2538c.m12677c("PayService", "transmit");
        C2538c.m12677c("PayService", "transmit, result = " + ((PluginPayAdapter) PluginPay.getInstance(this.f9092a.f9088b).getAdapter()).sendApdu(String.valueOf(this.f9092a.f9087a), C0973a.m3509a(bArr)));
        return C0973a.m3512b(((PluginPayAdapter) PluginPay.getInstance(this.f9092a.f9088b).getAdapter()).sendApdu(String.valueOf(this.f9092a.f9087a), C0973a.m3509a(bArr)));
    }
}

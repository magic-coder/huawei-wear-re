package com.snowballtech.smartdevice;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;

public class SnowBallAPDU {
    private PluginPayAdapter pluginPayAdapter = ((PluginPayAdapter) PluginPay.getInstance(BaseApplication.b()).getAdapter());

    public SnowBallAPDU(String str) {
    }

    public byte[] openChannel(byte[] bArr, int i) {
        return this.pluginPayAdapter.openChannelSNB(bArr, i);
    }

    public byte[] transmit(byte[] bArr) {
        return this.pluginPayAdapter.transmitSNB(bArr);
    }

    public void close() {
        this.pluginPayAdapter.closeChannelSNB();
    }
}

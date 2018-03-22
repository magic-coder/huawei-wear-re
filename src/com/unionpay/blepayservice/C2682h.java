package com.unionpay.blepayservice;

import android.os.RemoteException;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.p190v.C2538c;
import com.unionpay.tsmservice.request.GetTransElementsRequestParams;
import java.util.Map;

/* compiled from: PayService */
class C2682h extends C2677c {
    final /* synthetic */ PayService f9093a;

    C2682h(PayService payService) {
        this.f9093a = payService;
    }

    public int mo2924a() throws RemoteException {
        C2538c.m12677c("PayService", "init, enter...");
        if (2 == ((PluginPayAdapter) PluginPay.getInstance(this.f9093a.f9088b).getAdapter()).getDeviceConnectState()) {
            return 0;
        }
        return -1;
    }

    public Channel mo2926a(byte[] bArr) throws RemoteException {
        C2538c.m12677c("PayService", "openLogicChannel, aid = " + C0973a.m3509a(bArr));
        Map openChannel = ((PluginPayAdapter) PluginPay.getInstance(this.f9093a.f9088b).getAdapter()).openChannel(r2, 0);
        if (openChannel != null) {
            this.f9093a.f9087a = Integer.parseInt((String) openChannel.get(PluginPayAdapter.KEY_OPEN_CHANNEL_ID));
            C2538c.m12677c("PayService", "openLogicChannel, channelID = " + this.f9093a.f9087a + ", selectResp = " + ((String) openChannel.get("apdu")));
            return new Channel(this.f9093a.f9087a, (String) openChannel.get("apdu"), this.f9093a.f9089c);
        }
        C2538c.m12680e("PayService", "openLogicChannel fail! payOpenChannelInfo is null!");
        return null;
    }

    public int mo2925a(int i) throws RemoteException {
        ((PluginPayAdapter) PluginPay.getInstance(this.f9093a.f9088b).getAdapter()).closeChannel();
        C2538c.m12677c("PayService", "closeLogicChannel, closeResult");
        return 0;
    }

    public String mo2927b() throws RemoteException {
        C2538c.m12677c("PayService", "bleSEStatus, enter...");
        if (2 == ((PluginPayAdapter) PluginPay.getInstance(this.f9093a.f9088b).getAdapter()).getDeviceConnectState()) {
            return GetTransElementsRequestParams.TRANS_TYPE_DOWNLOAD_APPLY;
        }
        return "0000";
    }

    public String mo2928c() throws RemoteException {
        C2538c.m12677c("PayService", "getBTCInfo, enter...");
        PluginPayAdapter pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(this.f9093a.f9088b).getAdapter();
        String bTCInfoResponse = pluginPayAdapter.getBTCInfoResponse();
        String str = "";
        C2538c.m12677c("PayService", "getBTCInfo, BTCInfo = " + bTCInfoResponse);
        int deviceProtocol = pluginPayAdapter.getDeviceProtocol();
        String str2 = (String) pluginPayAdapter.getDeviceInfo().get(PluginPayAdapter.KEY_DEVICE_INFO_BT_VERSION);
        if (bTCInfoResponse == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bTCInfoResponse);
        C2538c.m12677c("PayService", "getBTCInfo, isTest = " + false);
        C2538c.m12677c("PayService", "getBTCInfo, deviceType = " + deviceProtocol);
        C2538c.m12677c("PayService", "getBTCInfo, BT_version = " + str2);
        if (bTCInfoResponse.length() > 15 && 10 == deviceProtocol && "4.1.1.68".equals(str2)) {
            stringBuffer.replace(15, 16, "2");
            C2538c.m12677c("PayService", "getBTCInfo,  buffer.replace");
            str2 = stringBuffer.toString();
        } else {
            str2 = bTCInfoResponse;
        }
        C2538c.m12677c("PayService", "getBTCInfo, return btcInfotemp = " + str2);
        return str2;
    }

    public String mo2929d() throws RemoteException {
        C2538c.m12677c("PayService", "getCPLCInfo");
        C2538c.m12677c("PayService", "getCPLCInfo, cplc = " + ((PluginPayAdapter) PluginPay.getInstance(this.f9093a.f9088b).getAdapter()).getCplc());
        return ((PluginPayAdapter) PluginPay.getInstance(this.f9093a.f9088b).getAdapter()).getCplc();
    }
}

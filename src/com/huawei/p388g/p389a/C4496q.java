package com.huawei.p388g.p389a;

import com.huawei.datatype.PayOpenChannelInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.nfc.PluginPayAdapter;

/* compiled from: PluginPayAdapterImpl */
class C4496q implements IBaseResponseCallback {
    final /* synthetic */ C4481b f16669a;

    C4496q(C4481b c4481b) {
        this.f16669a = c4481b;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            PayOpenChannelInfo payOpenChannelInfo = (PayOpenChannelInfo) obj;
            this.f16669a.f16652u.put("apdu", payOpenChannelInfo.getApdu());
            this.f16669a.f16652u.put(PluginPayAdapter.KEY_OPEN_CHANNEL_ID, payOpenChannelInfo.getChannelID() + "");
        } else {
            this.f16669a.f16652u.clear();
        }
        this.f16669a.m21484a("openChannel", C4481b.f16611B);
    }
}

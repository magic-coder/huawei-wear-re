package com.huawei.p388g.p389a;

import com.huawei.datatype.DataDeviceInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.p190v.C2538c;

import java.util.Map;

/* compiled from: PluginPayAdapterImpl */
class C4492m implements IBaseResponseCallback {
    final /* synthetic */ Map f16664a;
    final /* synthetic */ C4481b f16665b;

    C4492m(C4481b c4481b, Map map) {
        this.f16665b = c4481b;
        this.f16664a = map;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            this.f16665b.f16653v = (DataDeviceInfo) obj;
            if (this.f16665b.f16653v != null) {
                this.f16664a.put(PluginPayAdapter.KEY_DEVICE_INFO_SN, this.f16665b.f16653v.getDevice_sn());
                this.f16664a.put(PluginPayAdapter.KEY_DEVICE_INFO_MODEL, this.f16665b.f16653v.getDevice_model());
                this.f16664a.put(PluginPayAdapter.KEY_DEVICE_INFO_SOFT_VERSION, this.f16665b.f16653v.getDevice_soft_version());
                this.f16664a.put(PluginPayAdapter.KEY_DEVICE_INFO_BT_VERSION, this.f16665b.f16653v.getBT_version());
                C2538c.b("PluginPayAdapterImpl", new Object[]{"dataDeviceInfo=" + this.f16665b.f16653v.toString()});
            }
        }
        this.f16665b.m21484a("getDeviceInfo", C4481b.f16613D);
    }
}

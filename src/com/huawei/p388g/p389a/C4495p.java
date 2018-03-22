package com.huawei.p388g.p389a;

import com.huawei.datatype.PayAPDUInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: PluginPayAdapterImpl */
class C4495p implements IBaseResponseCallback {
    final /* synthetic */ C4481b f16668a;

    C4495p(C4481b c4481b) {
        this.f16668a = c4481b;
    }

    public void onResponse(int i, Object obj) {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"send apdu onResponse,err_code=" + i + ",mapApdu.size=" + this.f16668a.f16638g.size()});
        this.f16668a.f16633O.removeCallbacks(this.f16668a.f16635Q);
        if (i == 0) {
            PayAPDUInfo payAPDUInfo = (PayAPDUInfo) obj;
            if (payAPDUInfo != null) {
                this.f16668a.f16650s = payAPDUInfo.getApdu();
                this.f16668a.m21484a("onResponse", this.f16668a.f16638g.get(Integer.valueOf(payAPDUInfo.getReqid())));
                this.f16668a.f16638g.remove(Integer.valueOf(payAPDUInfo.getReqid()));
                C2538c.b("PluginPayAdapterImpl", new Object[]{"success ,unlockAndRemove,reqID=" + payAPDUInfo.getReqid() + ",lockObject=" + this.f16668a.f16638g.get(Integer.valueOf(payAPDUInfo.getReqid())) + ",map.size=" + this.f16668a.f16638g.size()});
                return;
            }
            return;
        }
        Iterator it = this.f16668a.f16638g.entrySet().iterator();
        while (it.hasNext()) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"fail entry.getKey ()=" + r0.getKey() + ",entry.getValue ()=" + ((Entry) it.next()).getValue()});
            this.f16668a.f16650s = null;
            this.f16668a.m21484a("onResponse", r0.getValue());
            it.remove();
        }
        C2538c.b("PluginPayAdapterImpl", new Object[]{"fail ,unlockAndRemoveAll,map.size=" + this.f16668a.f16638g.size()});
    }
}

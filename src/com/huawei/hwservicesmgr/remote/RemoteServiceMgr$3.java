package com.huawei.hwservicesmgr.remote;

import android.os.RemoteException;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.Map;

final class RemoteServiceMgr$3 implements IBaseResponseCallback {
    RemoteServiceMgr$3() {
    }

    public void onResponse(int i, Object obj) {
        Map hashMap;
        if (obj == null) {
            hashMap = new HashMap();
        } else {
            hashMap = (Map) obj;
        }
        hashMap.put("code", Integer.valueOf(i));
        try {
            if (RemoteServiceMgr.access$100() != null) {
                RemoteServiceMgr.access$100().mo4455a(hashMap);
                return;
            }
            C2538c.e("RemoteServiceMgr", new Object[]{"iCallbackInterface is null, the AIDL communication is broken"});
        } catch (RemoteException e) {
            C2538c.e("RemoteServiceMgr", new Object[]{e.getMessage()});
        }
    }
}

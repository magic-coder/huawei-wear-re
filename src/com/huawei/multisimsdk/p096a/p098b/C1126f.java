package com.huawei.multisimsdk.p096a.p098b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimsdk.p096a.p097a.C1115a;
import com.huawei.multisimsdk.p096a.p097a.C1116b;
import com.huawei.multisimsdk.p096a.p097a.C1117c;
import com.huawei.multisimservice.model.MultiSimDeviceInfo;
import java.util.Iterator;

/* compiled from: AttachedDeviceManager */
class C1126f extends Handler {
    public void handleMessage(Message message) {
        C1183h.m5282b("AttachedDeviceManager", "AttachedDeviceMgrCallbackHandler handle message: " + message.what);
        Bundle data = message.getData();
        switch (message.what) {
            case 7:
                C1183h.m5278a("AttachedDeviceManager", "Manager handle MSG, get device sim info callback.");
                C1116b a = m5017a(data);
                C1183h.m5278a("AttachedDeviceManager", "type = " + 0);
                synchronized (C1119a.f2365h) {
                    C1115a c1115a;
                    C1183h.m5282b("AttachedDeviceManager", "start to do onInfoBack, return the result to the caller.");
                    for (Object next : C1119a.f2365h.keySet()) {
                        if (next instanceof C1115a) {
                            c1115a = (C1115a) next;
                            if (0 == c1115a.m4981b()) {
                                m5018a(c1115a, a);
                            }
                        }
                    }
                    C1183h.m5282b("AttachedDeviceManager", "handle complete, remove callback.");
                    synchronized (C1119a.f2366i) {
                        Iterator it = C1119a.f2366i.iterator();
                        while (it.hasNext()) {
                            c1115a = (C1115a) it.next();
                            if (C1119a.f2365h.containsKey(c1115a)) {
                                C1119a.f2365h.remove(c1115a);
                            }
                        }
                        C1119a.f2366i.clear();
                    }
                }
                return;
            default:
                C1183h.m5286d("AttachedDeviceManager", "handle message error occurred.");
                return;
        }
    }

    private void m5018a(C1115a c1115a, C1116b c1116b) {
        if (c1115a == null || c1116b == null) {
            C1183h.m5286d("AttachedDeviceManager", "callback or commonResult is null.");
            return;
        }
        C1117c a = c1115a.m4980a();
        if (a == null) {
            C1183h.m5286d("AttachedDeviceManager", "attachedDeviceManagerCallback is null.");
            return;
        }
        a.m4982a(c1115a.m4981b(), c1116b);
        synchronized (C1119a.f2366i) {
            C1119a.f2366i.add(c1115a);
        }
    }

    private C1116b m5017a(Bundle bundle) {
        C1183h.m5282b("AttachedDeviceManager", "getCommonResultForGetAttachedDeviceSimInfo");
        if (bundle == null) {
            C1183h.m5286d("AttachedDeviceManager", "bundle is null, RESULT_CODE_ERROR");
            bundle = new Bundle();
        }
        Parcelable parcelable = bundle.getParcelable("deviceSimInfo");
        if (parcelable instanceof MultiSimDeviceInfo) {
            return new C1116b(0, (MultiSimDeviceInfo) parcelable);
        }
        C1183h.m5286d("AttachedDeviceManager", "error, can not change to MultiSimDeviceInfo.");
        MultiSimDeviceInfo multiSimDeviceInfo = new MultiSimDeviceInfo();
        multiSimDeviceInfo.setResultCode(-8);
        return new C1116b(0, multiSimDeviceInfo);
    }
}

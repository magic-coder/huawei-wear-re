package com.huawei.multisimsdk.p096a.p098b;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimservice.model.C1121b;
import com.huawei.multisimservice.model.MultiSimDeviceInfo;
import com.huawei.multisimservice.model.SimInfo;
import java.util.List;

/* compiled from: AttachedDeviceManager */
class C1122b extends C1121b {
    final /* synthetic */ C1119a f2379a;

    C1122b(C1119a c1119a) {
        this.f2379a = c1119a;
    }

    public void mo2359a(MultiSimDeviceInfo multiSimDeviceInfo) throws RemoteException {
        C1183h.m5282b("AttachedDeviceManager", "Wear Service start to callback manager, getAttachDeviceMultiSimInfo.");
        Bundle bundle = new Bundle();
        if (multiSimDeviceInfo != null) {
            bundle.putParcelable("deviceSimInfo", multiSimDeviceInfo);
            C1183h.m5278a("AttachedDeviceManager", "result code : " + multiSimDeviceInfo.getResultCode());
        } else {
            C1183h.m5286d("AttachedDeviceManager", "Wear service support device sim info with unknown type.");
            Parcelable multiSimDeviceInfo2 = new MultiSimDeviceInfo();
            multiSimDeviceInfo2.setResultCode(-8);
            bundle.putParcelable("deviceSimInfo", multiSimDeviceInfo2);
        }
        this.f2379a.m4989a(this.f2379a.f2371c, 7, bundle);
    }

    public void mo2358a(int i, List<SimInfo> list) throws RemoteException {
        C1183h.m5282b("AttachedDeviceManager", "WearService start to callback AttachedDeviceManager, downloadESimProfile.");
    }

    public void mo2357a(int i) throws RemoteException {
        C1183h.m5282b("AttachedDeviceManager", "WearService start to callback AttachedDeviceManager, deleteESimProfileNotify.");
    }
}

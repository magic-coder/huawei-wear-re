package com.huawei.hwdevicemgr.p073a;

import android.content.Context;
import com.google.gson.Gson;
import com.huawei.hwcommonmodel.datatypes.C4746m;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwdevicemgr.dmsdatatype.p074a.C1024b;
import com.huawei.p032e.p264a.p265a.p385a.C4383a;
import com.huawei.p032e.p264a.p265a.p385a.C4384b;
import com.huawei.p032e.p264a.p386b.C4389a;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;

/* compiled from: DeviceSyncDataListener */
public class C4984b implements C4389a {
    private C1024b f18067a;

    public C4984b(Context context) {
    }

    public void m23918a(C1024b bVar) {
        this.f18067a = bVar;
    }

    public void mo4597a(int i) {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setProductType(-2);
        if (this.f18067a != null) {
            C4746m c4746m = new C4746m();
            Gson gson = new Gson();
            c4746m.m22708a(1000);
            c4746m.m22709a(null);
            c4746m.m22712b(null);
            if (i == 0 || 1 == i || 2 == i) {
                c4746m.m22711b(0);
            } else {
                c4746m.m22711b(i);
            }
            C2538c.e("DeviceSyncDataListener", new Object[]{"healthData " + gson.toJson(c4746m).toString()});
            if (this.f18067a != null) {
                this.f18067a.a(deviceInfo, 7, r1);
                return;
            }
            return;
        }
        C2538c.e("DeviceSyncDataListener", new Object[]{"mDeviceStateClientCallback is null."});
    }

    public void mo4600b(int i) {
    }

    public void mo4598a(String str, String str2) {
    }

    public void mo4599a(ArrayList<C4384b> arrayList, ArrayList<C4383a> arrayList2) {
        DeviceInfo deviceInfo = new DeviceInfo();
        if (arrayList != null) {
            C2538c.e("DeviceSyncDataListener", new Object[]{"onSaveData3rd sportDataList " + arrayList.toString()});
        } else {
            C2538c.e("DeviceSyncDataListener", new Object[]{"onSaveData3rd sportDataList is null "});
        }
        if (arrayList2 != null) {
            C2538c.e("DeviceSyncDataListener", new Object[]{"onSaveData3rd sleepDataList " + arrayList2.toString()});
        } else {
            C2538c.e("DeviceSyncDataListener", new Object[]{"onSaveData3rd sleepDataList is null "});
        }
        deviceInfo.setProductType(-2);
        if (this.f18067a != null) {
            C4746m c4746m = new C4746m();
            Gson gson = new Gson();
            String toJson = gson.toJson(arrayList);
            String toJson2 = gson.toJson(arrayList2);
            c4746m.m22708a(1001);
            c4746m.m22709a(toJson);
            c4746m.m22712b(toJson2);
            this.f18067a.a(deviceInfo, 7, gson.toJson(c4746m));
            return;
        }
        C2538c.e("DeviceSyncDataListener", new Object[]{"mDeviceStateClientCallback is null."});
    }
}

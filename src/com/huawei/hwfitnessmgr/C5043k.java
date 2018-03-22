package com.huawei.hwfitnessmgr;

import android.util.SparseArray;
import com.huawei.al.C4028a;
import com.huawei.hihealth.HiDataInsertOption;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.a.b;
import com.huawei.hihealth.data.p312b.C4550d;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.C5021d;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: FitnessMgrStorage */
class C5043k implements C4550d {
    final /* synthetic */ C5021d f18253a;
    final /* synthetic */ C5039g f18254b;

    C5043k(C5039g c5039g, C5021d c5021d) {
        this.f18254b = c5039g;
        this.f18253a = c5021d;
    }

    public void mo4610a(Object obj, int i, int i2) {
        HiHealthData hiHealthData;
        List list;
        int i3;
        C2538c.c("Fitness_MgrStorage", new Object[]{"appendToExistData onResult() data "});
        C2538c.b("Fitness_MgrStorage", new Object[]{"data ", obj});
        SparseArray sparseArray = new SparseArray();
        if (obj == null) {
            C2538c.e("Fitness_MgrStorage", new Object[]{"onSuccess() data = null"});
            obj = sparseArray;
        } else {
            SparseArray sparseArray2 = (SparseArray) obj;
            if (sparseArray2.size() <= 0) {
                C2538c.c("Fitness_MgrStorage", new Object[]{"onSuccess map empty"});
            }
        }
        long a = this.f18253a.m24194a();
        HiDataInsertOption hiDataInsertOption = new HiDataInsertOption();
        List arrayList = new ArrayList();
        if (this.f18253a.m24199c() > 0) {
            hiHealthData = new HiHealthData(2);
            hiHealthData.setTimeInterval(1000 * a, (60 + a) * 1000);
            hiHealthData.setValue(this.f18253a.m24199c());
            hiHealthData.setDeviceUUID(C4028a.m19823a());
            list = (List) obj.get(2);
            if (list != null && list.size() > 0 && ((HiHealthData) list.get(0)).getStartTime() == 1000 * a && ((HiHealthData) list.get(0)).getType() == 2) {
                hiHealthData.setValue(((HiHealthData) list.get(0)).getValue() + ((double) this.f18253a.m24199c()));
                hiHealthData.setDeviceUUID(C4028a.m19823a());
            }
            arrayList.add(hiHealthData);
        }
        if (this.f18253a.m24201d() > 0) {
            hiHealthData = new HiHealthData(4);
            hiHealthData.setTimeInterval(1000 * a, (60 + a) * 1000);
            hiHealthData.setValue(this.f18253a.m24201d());
            hiHealthData.setDeviceUUID(C4028a.m19823a());
            list = (List) obj.get(4);
            if (list != null && list.size() > 0 && ((HiHealthData) list.get(0)).getStartTime() == 1000 * a && ((HiHealthData) list.get(0)).getType() == 4) {
                hiHealthData.setValue(((HiHealthData) list.get(0)).getValue() + ((double) this.f18253a.m24201d()));
                hiHealthData.setDeviceUUID(C4028a.m19823a());
            }
            arrayList.add(hiHealthData);
        }
        if (this.f18254b.m24332b() && this.f18253a.m24197b() == 3) {
            i3 = 5;
        } else {
            i3 = 3;
        }
        if (this.f18253a.m24203e() > 0) {
            HiHealthData hiHealthData2 = new HiHealthData(i3);
            hiHealthData2.setTimeInterval(1000 * a, (60 + a) * 1000);
            hiHealthData2.setValue(this.f18253a.m24203e());
            hiHealthData2.setDeviceUUID(C4028a.m19823a());
            list = (List) obj.get(i3);
            if (list != null && list.size() > 0 && ((HiHealthData) list.get(0)).getStartTime() == a * 1000 && ((HiHealthData) list.get(0)).getType() == i3) {
                hiHealthData2.setValue(((HiHealthData) list.get(0)).getValue() + ((double) this.f18253a.m24203e()));
                hiHealthData2.setDeviceUUID(C4028a.m19823a());
            }
            arrayList.add(hiHealthData2);
        }
        hiDataInsertOption.setDatas(arrayList);
        C2538c.c("Fitness_MgrStorage", new Object[]{"update data "});
        b.a(BaseApplication.b()).a(hiDataInsertOption, new C5044l(this));
    }
}

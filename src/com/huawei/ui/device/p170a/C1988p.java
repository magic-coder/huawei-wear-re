package com.huawei.ui.device.p170a;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.datatypes.j;
import com.huawei.hwdevicefontmgr.C1021a;
import com.huawei.hwservicesmgr.C1046a;
import com.huawei.hwservicesmgr.p076a.C1045q;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.u.a;
import com.huawei.ui.commonui.d.c;
import com.huawei.ui.device.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DeviceInteractors */
public class C1988p {
    private static C1204c f6939a;
    private static C1988p f6940c;
    private Context f6941b;

    private C1988p(Context context) {
        this.f6941b = context;
    }

    public static C1988p m10381a(Context context) {
        if (f6940c == null) {
            f6940c = new C1988p(BaseApplication.m2632b());
        }
        f6939a = C1204c.m5370a(BaseApplication.m2632b());
        a.a();
        com.huawei.i.a.a(BaseApplication.m2632b());
        com.huawei.h.a.a(BaseApplication.m2632b());
        C1021a.m3912a(BaseApplication.m2632b());
        return f6940c;
    }

    public void m10387a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("DeviceInteractors", "enter getDeviceBattery()");
        f6939a.m5441b(iBaseResponseCallback);
    }

    public DeviceInfo m10384a() {
        return f6939a.m5447c();
    }

    public List<DeviceInfo> m10392b() {
        List<DeviceInfo> list = null;
        try {
            list = f6939a.m5421a();
        } catch (RemoteException e) {
            C2538c.m12680e("DeviceInteractors", "RemoteException = " + e.getMessage());
            C1045q.m4405a(BaseApplication.m2632b());
        }
        return list;
    }

    public void m10390a(List<DeviceInfo> list) {
        try {
            f6939a.m5433a((List) list);
        } catch (RemoteException e) {
            C2538c.m12680e("DeviceInteractors", "RemoteException = " + e.getMessage());
            C1045q.m4405a(BaseApplication.m2632b());
        }
    }

    public static int m10379a(int i) {
        return com.huawei.n.a.a(i).a();
    }

    public static int m10380a(String str) {
        return com.huawei.n.a.a(str);
    }

    public void m10386a(int i, String str, List<String> list, C1046a c1046a, String str2) {
        try {
            C1045q.m4406a(c1046a);
            f6939a.m5424a(i, str, (List) list, c1046a, str2);
        } catch (RemoteException e) {
            C2538c.m12680e("DeviceInteractors", "RemoteException = " + e.getMessage());
            C1045q.m4405a(BaseApplication.m2632b());
            if (c1046a != null) {
                try {
                    c1046a.mo2634a(4);
                } catch (RemoteException e2) {
                    C2538c.m12680e("DeviceInteractors", " iAddDeviceStateAIDLCallback RemoteException = " + e2.getMessage());
                }
            }
        }
    }

    public String m10394c() {
        if (m10384a() != null) {
            return m10384a().getDeviceName();
        }
        C2538c.m12677c("DeviceInteractors", "getCurrentDeviceName() getCurrentDeviceInfo() == null");
        return "";
    }

    public int m10396d() {
        if (m10384a() != null) {
            return m10384a().getDeviceConnectState();
        }
        C2538c.m12677c("DeviceInteractors", "getCurrentDeviceConnectState() getCurrentDeviceInfo() == null");
        return 0;
    }

    public String m10391b(int i) {
        String str = "Unknown";
        switch (i) {
            case -2:
                str = this.f6941b.getResources().getString(i.IDS_messagecenter_color_band_name);
                break;
            case 0:
                str = this.f6941b.getResources().getString(i.IDS_select_device_b1_name);
                break;
            case 1:
                str = this.f6941b.getResources().getString(i.IDS_select_device_b2_name);
                break;
            case 2:
                str = this.f6941b.getResources().getString(i.IDS_app_display_name_k1);
                break;
            case 3:
                str = this.f6941b.getResources().getString(i.IDS_app_display_name_w1);
                break;
            case 4:
                str = this.f6941b.getResources().getString(i.IDS_app_display_name_n1);
                break;
            case 5:
                str = c.h(this.f6941b);
                break;
            case 7:
                str = this.f6941b.getResources().getString(i.IDS_app_display_name_gemini);
                break;
            case 8:
                str = c.f(this.f6941b);
                break;
            case 9:
                str = this.f6941b.getResources().getString(i.IDS_app_display_name_k2);
                break;
            case 10:
                if (m10384a() != null && !TextUtils.isEmpty(m10384a().getDeviceModel()) && TextUtils.equals(m10384a().getDeviceModel(), "PORSCHE DESIGN")) {
                    str = "PORSCHE DESIGN";
                    break;
                }
                str = "HUAWEI WATCH 2";
                break;
                break;
            case 11:
                str = this.f6941b.getResources().getString(i.IDS_huawei_r1_content);
                break;
            case 12:
                str = c.g(this.f6941b);
                break;
            case 13:
                str = this.f6941b.getResources().getString(i.IDS_app_display_name_nys);
                break;
            case 14:
                str = this.f6941b.getResources().getString(i.IDS_app_display_name_grus);
                break;
            case 15:
                str = this.f6941b.getResources().getString(i.IDS_app_display_name_eris);
                break;
        }
        C2538c.m12677c("DeviceInteractors", "transDeviceProductTypeIntToStr: mDeviceProductType = " + str);
        return str;
    }

    public void m10397e() {
        C2538c.m12677c("DeviceInteractors", "Enter initNpsRequestDeviceInfo !");
        if (f6939a != null) {
            f6939a.m5425a(new C1989q(this));
            DeviceInfo c = f6939a.m5447c();
            if (c != null) {
                C2538c.m12677c("DeviceInteractors", "initNpsRequestDeviceInfo mac : " + c.getDeviceIdentify());
                j.a(c.getDeviceIdentify());
                C2538c.m12677c("DeviceInteractors", "initNpsRequestDeviceInfo WearName : " + c.getProductType());
                j.b(C1996x.m10459b(c.getProductType()));
            }
            C2538c.m12677c("DeviceInteractors", "Leave initNpsRequestDeviceInfo !");
        }
    }

    public static List<String> m10382f() {
        List<String> arrayList = new ArrayList();
        arrayList.add("HONOR ZERO");
        arrayList.add("HUAWEI B0");
        arrayList.add("HUAWEI BAND-");
        arrayList.add("HONOR BAND Z1");
        arrayList.add("metis");
        arrayList.add("honor watch S1");
        arrayList.add("HUAWEI FIT");
        arrayList.add("HUAWEI band A2");
        arrayList.add("honor band A2");
        arrayList.add("AW61");
        arrayList.add("HUAWEI Color Band A2");
        arrayList.add("HUAWEI NYX");
        arrayList.add("HONOR NYX");
        arrayList.add("Honor Band 3-");
        arrayList.add("Huawei Band 2-");
        arrayList.add("HUAWEI GE");
        arrayList.add("HUAWEI B3-");
        arrayList.add("HUAWEI B2");
        arrayList.add("HUAWEI B1");
        arrayList.add("HUAWEI AM-R1");
        arrayList.add("HUAWEI CM-R1P");
        arrayList.add("HUAWEI GRUS");
        arrayList.add("HUAWEI B3 Lite-");
        return arrayList;
    }

    public static List<String> m10383g() {
        List<String> arrayList = new ArrayList();
        arrayList.add("HUAWEI GE");
        arrayList.add("HUAWEI B3-");
        arrayList.add("HUAWEI B2");
        arrayList.add("HUAWEI B1");
        arrayList.add("HUAWEI AM-R1");
        arrayList.add("HUAWEI GRUS");
        arrayList.add("HUAWEI B3 Lite-");
        return arrayList;
    }

    public int m10398h() {
        C2538c.m12677c("DeviceInteractors", "enter getAllowDisturbListItem()");
        if (f6939a != null) {
            return f6939a.m5455g();
        }
        return 0;
    }

    public void m10393b(IBaseResponseCallback iBaseResponseCallback) {
        try {
            f6939a.m5460i(iBaseResponseCallback);
        } catch (RemoteException e) {
            C2538c.m12680e("DeviceInteractors", "getDeviceListFromHealth RemoteException = " + e.getMessage());
            C1045q.m4405a(BaseApplication.m2632b());
        }
    }

    public void m10395c(IBaseResponseCallback iBaseResponseCallback) {
        try {
            f6939a.m5461j(iBaseResponseCallback);
        } catch (RemoteException e) {
            C2538c.m12680e("DeviceInteractors", "getDeviceListFromHealth RemoteException = " + e.getMessage());
            C1045q.m4405a(BaseApplication.m2632b());
        }
    }

    public void m10388a(String str, IBaseResponseCallback iBaseResponseCallback) {
        try {
            f6939a.m5444b(str, iBaseResponseCallback);
        } catch (RemoteException e) {
            C2538c.m12680e("DeviceInteractors", "sendDataToHealth RemoteException = " + e.getMessage());
            C1045q.m4405a(BaseApplication.m2632b());
        }
    }

    public void m10389a(String str, boolean z, IBaseResponseCallback iBaseResponseCallback) {
        try {
            f6939a.m5432a(str, z, iBaseResponseCallback);
        } catch (RemoteException e) {
            C2538c.m12680e("DeviceInteractors", "sendDataToHealth RemoteException = " + e.getMessage());
            C1045q.m4405a(BaseApplication.m2632b());
        }
    }

    public void m10385a(int i, IBaseResponseCallback iBaseResponseCallback) {
        try {
            f6939a.m5440b(i, iBaseResponseCallback);
        } catch (RemoteException e) {
            C2538c.m12680e("DeviceInteractors", "getDeviceListFromHealth RemoteException = " + e.getMessage());
            iBaseResponseCallback.onResponse(-1, "error:" + e.getMessage());
            C1045q.m4405a(BaseApplication.m2632b());
        }
    }
}

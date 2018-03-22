package com.huawei.hwservicesmgr;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.datatypes.TransferFileInfo;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwservicesmgr.p076a.p078b.C1041p;
import com.huawei.hwservicesmgr.remote.RemoteServiceMgr;
import com.huawei.p032e.C0802a;
import com.huawei.p032e.C0804j;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: PhoneService */
class C1062w extends C1055n {
    final /* synthetic */ PhoneService f2083a;

    C1062w(PhoneService phoneService) {
        this.f2083a = phoneService;
    }

    public void mo2325a(DeviceCommand deviceCommand) throws RemoteException {
        if (this.f2083a.f1935c == null) {
            C2538c.m12674b("PhoneService", "sendDeviceData, HWDeviceMgr is null");
            return;
        }
        this.f2083a.f1935c.m3995b(deviceCommand);
    }

    public void mo2326a(C1048d c1048d) throws RemoteException {
        if (this.f2083a.f1935c == null) {
            C2538c.m12674b("PhoneService", "registerDeviceStateCallBack, HWDeviceMgr is null");
            return;
        }
        PhoneService.f1932b = c1048d;
        this.f2083a.f1935c.m3987a(this.f2083a.f1949s);
    }

    public void mo2336b(C1048d c1048d) throws RemoteException {
        if (this.f2083a.f1935c == null) {
            C2538c.m12674b("PhoneService", "unRegisterDeviceStateCallBack, HWDeviceMgr is null");
            return;
        }
        this.f2083a.f1935c.m3994b(this.f2083a.f1949s);
    }

    public void mo2320a(int i, String str, List<String> list, C1046a c1046a, String str2) throws RemoteException {
        if (this.f2083a.f1935c == null) {
            C2538c.m12674b("PhoneService", "addDevice, HWDeviceMgr is null");
            return;
        }
        this.f2083a.f1935c.m3985a(i, str, (List) list, new C1063x(this, c1046a), str2);
    }

    public void mo2331a(List<DeviceInfo> list) throws RemoteException {
        if (this.f2083a.f1935c == null) {
            C2538c.m12674b("PhoneService", "setUsedDeviceList, HWDeviceMgr is null");
            return;
        }
        this.f2083a.f1935c.m3991a((List) list, false);
    }

    public List<DeviceInfo> mo2317a() throws RemoteException {
        if (this.f2083a.f1935c != null) {
            return this.f2083a.f1935c.m3984a();
        }
        C2538c.m12674b("PhoneService", "getUsedDeviceList, HWDeviceMgr is null");
        return null;
    }

    public void mo2335b(DeviceCommand deviceCommand) throws RemoteException {
        if (this.f2083a.f1935c == null) {
            C2538c.m12674b("PhoneService", "sendOTACommand, HWDeviceMgr is null");
            return;
        }
        this.f2083a.f1935c.m3988a(deviceCommand);
    }

    public void mo2329a(String str, String str2, String str3, int i, C1052j c1052j) throws RemoteException {
        if (this.f2083a.f1935c == null) {
            C2538c.m12674b("PhoneService", "getUsedDeviceList, HWDeviceMgr is null");
            return;
        }
        this.f2083a.f1935c.m3990a(str, str2, str3, i, new C1064y(this, c1052j));
    }

    public void mo2337c() throws RemoteException {
        if (this.f2083a.f1935c == null) {
            C2538c.m12674b("PhoneService", "forceConnectBTDevice, HWDeviceMgr is null");
            return;
        }
        this.f2083a.f1935c.m3992a(false);
    }

    public DeviceCapability mo2333b() throws RemoteException {
        if (this.f2083a.f1935c != null) {
            return this.f2083a.f1935c.m3993b();
        }
        C2538c.m12674b("PhoneService", "getDeviceCapability, HWDeviceMgr is null");
        return null;
    }

    public void mo2321a(IBinder iBinder, String str, String str2) throws RemoteException {
        C2538c.m12674b("PhoneService", "registerBinder called ");
        DeathRecipient c1065z = new C1065z(this.f2083a, iBinder, str, str2);
        iBinder.linkToDeath(c1065z, 0);
        this.f2083a.f1941i.add(c1065z);
        if (this.f2083a.f1942l != null) {
            this.f2083a.f1942l;
            RemoteServiceMgr.reconnect();
        }
    }

    public void mo2327a(String str) throws RemoteException {
        C2538c.m12674b("PhoneService", "sendfilepath called ");
        if (this.f2083a.f1935c == null) {
            C2538c.m12674b("PhoneService", "sendfilepath, HWDeviceMgr is null");
            return;
        }
        this.f2083a.f1935c.m3989a(str);
    }

    public void mo2324a(TransferFileInfo transferFileInfo, C1057r c1057r) throws RemoteException {
        C2538c.m12674b("PhoneService", "getFile called ");
        C1041p.m4346a().m4353a(transferFileInfo, (Object) c1057r);
    }

    public void mo2332a(boolean z) {
        if (this.f2083a.f1935c != null) {
            this.f2083a.f1935c.m3996b(z);
        }
    }

    public boolean mo2338d() {
        if (this.f2083a.f1935c != null) {
            return this.f2083a.f1935c.m3999e();
        }
        return false;
    }

    public void mo2318a(int i, int i2, C1050g c1050g) throws RemoteException {
        if (this.f2083a.f1942l != null) {
            this.f2083a.f1942l.isLoudspeakerMuteOpenOrCloseHeartRate(i, i2, c1050g);
        }
    }

    public void mo2323a(C0804j c0804j) throws RemoteException {
        if (this.f2083a.f1942l != null) {
            this.f2083a.f1942l.getDeviceListSizeFromHealth(c0804j);
        }
    }

    public void mo2322a(C0802a c0802a) throws RemoteException {
        if (this.f2083a.f1942l != null) {
            this.f2083a.f1942l.unbindDeviceListFromHealth(c0802a);
        }
    }

    public void mo2334b(C0802a c0802a) throws RemoteException {
        if (this.f2083a.f1942l != null) {
            this.f2083a.f1942l.isHealthSupportWearDevice(c0802a);
        }
    }

    public void mo2328a(String str, C0802a c0802a) throws RemoteException {
        C2538c.m12677c("PhoneService", "Enter sendDataToHealth:" + str);
        if (this.f2083a.f1942l != null) {
            this.f2083a.f1942l.sendDataToHealth(str, c0802a);
            return;
        }
        C2538c.m12677c("PhoneService", "Enter remoteServiceMgr is null");
    }

    public void mo2319a(int i, C0802a c0802a) throws RemoteException {
        C2538c.m12677c("PhoneService", "Enter getCommonData:" + i);
        if (this.f2083a.f1942l != null) {
            this.f2083a.f1942l.getCommonData(i, c0802a);
            return;
        }
        C2538c.m12677c("PhoneService", "Enter remoteServiceMgr is null");
    }

    public void mo2330a(String str, boolean z, C0802a c0802a) throws RemoteException {
        C2538c.m12677c("PhoneService", "Enter sendLeoSuppoptInHealthFlag:" + str + "issupport:" + z);
        C0996a.m3611a(BaseApplication.m2632b(), String.valueOf(20009), str, "" + z, new C0993c(0));
    }
}

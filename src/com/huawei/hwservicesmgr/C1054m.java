package com.huawei.hwservicesmgr;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.datatypes.TransferFileInfo;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.p032e.C0802a;
import com.huawei.p032e.C0804j;
import java.util.List;

/* compiled from: IPhoneServiceAIDL */
public interface C1054m extends IInterface {
    List<DeviceInfo> mo2317a() throws RemoteException;

    void mo2318a(int i, int i2, C1050g c1050g) throws RemoteException;

    void mo2319a(int i, C0802a c0802a) throws RemoteException;

    void mo2320a(int i, String str, List<String> list, C1046a c1046a, String str2) throws RemoteException;

    void mo2321a(IBinder iBinder, String str, String str2) throws RemoteException;

    void mo2322a(C0802a c0802a) throws RemoteException;

    void mo2323a(C0804j c0804j) throws RemoteException;

    void mo2324a(TransferFileInfo transferFileInfo, C1057r c1057r) throws RemoteException;

    void mo2325a(DeviceCommand deviceCommand) throws RemoteException;

    void mo2326a(C1048d c1048d) throws RemoteException;

    void mo2327a(String str) throws RemoteException;

    void mo2328a(String str, C0802a c0802a) throws RemoteException;

    void mo2329a(String str, String str2, String str3, int i, C1052j c1052j) throws RemoteException;

    void mo2330a(String str, boolean z, C0802a c0802a) throws RemoteException;

    void mo2331a(List<DeviceInfo> list) throws RemoteException;

    void mo2332a(boolean z) throws RemoteException;

    DeviceCapability mo2333b() throws RemoteException;

    void mo2334b(C0802a c0802a) throws RemoteException;

    void mo2335b(DeviceCommand deviceCommand) throws RemoteException;

    void mo2336b(C1048d c1048d) throws RemoteException;

    void mo2337c() throws RemoteException;

    boolean mo2338d() throws RemoteException;
}

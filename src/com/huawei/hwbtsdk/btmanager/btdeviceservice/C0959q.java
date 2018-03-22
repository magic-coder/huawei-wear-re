package com.huawei.hwbtsdk.btmanager.btdeviceservice;

import android.bluetooth.BluetoothDevice;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;

/* compiled from: BTDeviceServiceBase */
public interface C0959q {
    // connectBTDevice
    void mo2291a(BluetoothDevice bluetoothDevice);

    //setFileCallback
    void mo2292a(IBaseResponseCallback iBaseResponseCallback);

    //sendBTFilePath
    void mo2293a(String str);

    boolean mo2294a(byte[] bArr);

    // disconnectBTDevice
    void mo2295b();

    // btSwitchChangeInfo
    void mo2296b(int i);

    // setPathExtendNum
    void mo2297c(int i);

    // getDeviceInfo
    DeviceInfo mo2298d();

    // disconnectGMS
    void mo2299e();

    // removeV1CheckCommand
    void mo2300f();

    // connect status
    int mo2301g();
}

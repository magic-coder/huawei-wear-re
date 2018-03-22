package com.huawei.hwbtsdk.btmanager.btdeviceservice;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.text.TextUtils;
import com.huawei.p190v.C2538c;

import java.io.IOException;
import java.util.UUID;

/* compiled from: BTDeviceBRService */
class C4641o extends Thread {
    final /* synthetic */ C4639m f16973a;
    private final BluetoothSocket f16974b;
    private String f16975c;

    private C4641o(C4639m c4639m, BluetoothDevice bluetoothDevice) {
        BluetoothSocket bluetoothSocket = null;
        this.f16973a = c4639m;
        this.f16975c = "Secure";
        C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Enter ConnectThread."});
        if (bluetoothDevice == null) {
            C2538c.a("0xA0200006", "01", 1, "BTDeviceBRService", new Object[]{"ConnectThread: device parameter is null."});
            this.f16974b = null;
            c4639m.f16964a = null;
            return;
        }
        UUID fromString;
        c4639m.f16964a = bluetoothDevice;
        int d = c4639m.f16969j.m21949d(bluetoothDevice);
        C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Device product type = " + d});
        if (-1 == d && TextUtils.isEmpty(bluetoothDevice.getName()) && -1 != c4639m.f16970k) {
            C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"device name is null so use mProductType with value = " + c4639m.f16970k});
            d = c4639m.f16970k;
        }
        switch (d) {
            case 0:
                fromString = UUID.fromString("82ff3820-8411-400c-b85a-55bdb32cf056");
                break;
            case 1:
                fromString = UUID.fromString("82ff3820-8411-400c-b85a-55bdb32cf057");
                break;
            case 4:
                fromString = UUID.fromString("82ff3820-8411-400c-b85a-55bdb32cf059");
                break;
            case 7:
                fromString = UUID.fromString("82ff3820-8411-400c-b85a-55bdb32cf060");
                break;
            default:
                try {
                    C2538c.b("01", 1, "BTDeviceBRService", new Object[]{"Do not find suitable UUID info."});
                    Object name = bluetoothDevice.getName();
                    if (!TextUtils.isEmpty(name) && name.toUpperCase().contains("HUAWEI")) {
                        fromString = UUID.fromString("82ff3820-8411-400c-b85a-55bdb32cf060");
                        break;
                    } else {
                        fromString = null;
                        break;
                    }
                } catch (IOException e) {
                    C2538c.a("0xA0200000", "01", 1, "BTDeviceBRService", new Object[]{"create socket exception with info = " + e.getMessage()});
                    break;
                }
        }
        if (fromString != null) {
            bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(fromString);
        } else {
            C2538c.a("0xA0200000", "01", 1, "BTDeviceBRService", new Object[]{"mSecureSocketUUID is null."});
        }
        this.f16974b = bluetoothSocket;
    }

    public void run() {
        setName("ConnectThread" + this.f16975c);
        try {
            Thread.sleep(500);
            if (this.f16973a.f16967h) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            C2538c.a("0xA0200006", "01", 1, "BTDeviceBRService", new Object[]{"InterruptedException = " + e.getMessage()});
        }
        this.f16973a.f16969j.m21953f();
        if (this.f16974b == null) {
            C2538c.a("0xA0200006", "01", 1, "BTDeviceBRService", new Object[]{"mBTSocket is null."});
            this.f16973a.m22236c();
            return;
        }
        try {
            this.f16974b.connect();
            C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Start DataTransferThread."});
            this.f16973a.m22230a(this.f16974b);
        } catch (IOException e2) {
            try {
                C2538c.a("0xA0200000", "01", 1, "BTDeviceBRService", new Object[]{"mBTSocket connect IOException1 with info = " + e2.getMessage()});
                this.f16974b.close();
            } catch (IOException e22) {
                C2538c.a("0xA0200000", "01", 1, "BTDeviceBRService", new Object[]{"mBTSocket connect IOException2 with info = " + e22.getMessage()});
            }
            this.f16973a.m22236c();
        } catch (NullPointerException e3) {
            try {
                C2538c.a("0xA0200000", "01", 1, "BTDeviceBRService", new Object[]{"mBTSocket connect NullPointerException1 with info = " + e3.getMessage()});
                this.f16974b.close();
            } catch (IOException e4) {
                C2538c.a("0xA0200000", "01", 1, "BTDeviceBRService", new Object[]{"mBTSocket connect IOException with info = " + e3.getMessage()});
            }
            this.f16973a.m22236c();
        }
    }

    public void m22260a() {
        try {
            if (this.f16974b != null) {
                this.f16974b.close();
            }
        } catch (IOException e) {
            C2538c.a("0xA0200000", "01", 1, "BTDeviceBRService", new Object[]{"Close socket exception with info = " + e.getMessage()});
        }
    }
}

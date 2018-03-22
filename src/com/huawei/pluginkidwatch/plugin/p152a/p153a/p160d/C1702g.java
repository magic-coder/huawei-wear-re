package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.SystemClock;
import com.huawei.p190v.C2538c;
import java.io.IOException;
import java.util.UUID;

/* compiled from: BluetoothClassicConnectService */
class C1702g extends Thread {
    final /* synthetic */ C1701f f4519a;
    private final BluetoothSocket f4520b;
    private final BluetoothDevice f4521c;
    private String f4522d;

    public C1702g(C1701f c1701f, BluetoothDevice bluetoothDevice, boolean z, int i) {
        BluetoothSocket bluetoothSocket;
        this.f4519a = c1701f;
        this.f4521c = bluetoothDevice;
        this.f4522d = z ? "Secure" : "Insecure";
        C2538c.m12674b("ClassicBTConnectService", "  ConnectThread() created.");
        if (z) {
            switch (i) {
                case 0:
                    c1701f.f4513e = UUID.fromString("82ff3820-8411-400c-b85a-55bdb32cf056");
                    break;
                case 1:
                    c1701f.f4513e = UUID.fromString("82ff3820-8411-400c-b85a-55bdb32cf057");
                    break;
                case 2:
                    c1701f.f4513e = UUID.fromString("82ff3820-8411-400c-b85a-55bdb32cf059");
                    break;
                case 6:
                    c1701f.f4513e = UUID.fromString("82ff3820-8411-400c-b85a-55bdb32cf060");
                    break;
                default:
                    try {
                        c1701f.f4513e = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
                        break;
                    } catch (IOException e) {
                        C2538c.m12680e("ClassicBTConnectService", " Socket Type: " + this.f4522d + " createRfcommSocketToServiceRecord create() failed, error:" + e.getMessage());
                        bluetoothSocket = null;
                        break;
                    }
            }
            C2538c.m12674b("ClassicBTConnectService", " createRfcommSocketToServiceRecord called, cnt to UUID:" + c1701f.f4513e.toString());
            bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(c1701f.f4513e);
        } else {
            C2538c.m12674b("ClassicBTConnectService", " createInsecureRfcommSocketToServiceRecord called");
            bluetoothSocket = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(C1701f.f4510a);
        }
        this.f4520b = bluetoothSocket;
    }

    public void run() {
        C2538c.m12674b("ClassicBTConnectService", "  BEGIN mConnectThread() running, SocketType:" + this.f4522d);
        setName("ConnectThread" + this.f4522d);
        Long.valueOf(0);
        Long.valueOf(0);
        synchronized (this.f4519a) {
            Long valueOf = Long.valueOf(SystemClock.uptimeMillis());
            Long valueOf2 = Long.valueOf(valueOf.longValue() - this.f4519a.f4518k.longValue());
        }
        if (valueOf.longValue() > 0 && valueOf2.longValue() <= 3000) {
            C2538c.m12674b("ClassicBTConnectService", " doing BT reconnect,add 3000ms delay after old connection closed.");
            try {
                Thread.sleep(3000 - valueOf2.longValue());
            } catch (InterruptedException e) {
                C2538c.m12680e("ClassicBTConnectService", "Exception e = " + e.getMessage());
            }
        }
        this.f4519a.c.cancelDiscovery();
        if (this.f4520b == null) {
            C2538c.m12674b("ClassicBTConnectService", "ConnectThread: mmSocket == null");
            this.f4519a.m8056c();
            return;
        }
        try {
            this.f4520b.connect();
            synchronized (this.f4519a.f4515g) {
                this.f4519a.f4514f = null;
            }
            this.f4519a.m8062a(this.f4520b, this.f4521c, this.f4522d);
        } catch (IOException e2) {
            C2538c.m12680e("ClassicBTConnectService", " mmSocket connect failed error:" + e2.getMessage());
            try {
                this.f4520b.close();
            } catch (IOException e22) {
                C2538c.m12680e("ClassicBTConnectService", " unable to close() " + this.f4522d + " socket during connection failure" + e22.getMessage());
            }
            this.f4519a.m8056c();
        } catch (NullPointerException e3) {
            C2538c.m12680e("ClassicBTConnectService", " mmSocket connect failed error:" + e3.getMessage());
            try {
                this.f4520b.close();
            } catch (IOException e222) {
                C2538c.m12680e("ClassicBTConnectService", " unable to close() " + this.f4522d + " socket during connection failure" + e222.getMessage());
            }
            this.f4519a.m8056c();
        }
    }

    public void m8066a() {
        try {
            this.f4520b.close();
        } catch (IOException e) {
            C2538c.m12680e("ClassicBTConnectService", " close() of connect " + this.f4522d + " socket failed" + e.getMessage());
        }
    }
}

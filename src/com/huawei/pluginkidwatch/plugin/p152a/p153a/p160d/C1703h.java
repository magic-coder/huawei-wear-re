package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.bluetooth.BluetoothSocket;
import com.huawei.p190v.C2538c;
import com.unionpay.tsmservice.data.Constant;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* compiled from: BluetoothClassicConnectService */
class C1703h extends Thread {
    final /* synthetic */ C1701f f4523a;
    private final BluetoothSocket f4524b;
    private final InputStream f4525c;
    private final OutputStream f4526d;

    public C1703h(C1701f c1701f, BluetoothSocket bluetoothSocket, String str) {
        InputStream inputStream;
        IOException e;
        OutputStream outputStream = null;
        this.f4523a = c1701f;
        C2538c.m12674b("ClassicBTConnectService", "  create ConnectedThread: " + str);
        this.f4524b = bluetoothSocket;
        try {
            inputStream = bluetoothSocket.getInputStream();
            try {
                outputStream = bluetoothSocket.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                C2538c.m12680e("ClassicBTConnectService", " temp sockets not created" + e.getMessage());
                this.f4525c = inputStream;
                this.f4526d = outputStream;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = outputStream;
            C2538c.m12680e("ClassicBTConnectService", " temp sockets not created" + e.getMessage());
            this.f4525c = inputStream;
            this.f4526d = outputStream;
        }
        this.f4525c = inputStream;
        this.f4526d = outputStream;
    }

    public void run() {
        C2538c.m12674b("ClassicBTConnectService", " ConnectedThread started.");
        byte[] bArr = new byte[Constant.CALLBACK_UNITE_APP_LIST];
        while (true) {
            try {
                Arrays.fill(bArr, (byte) 0);
                int read = this.f4525c.read(bArr);
                C2538c.m12674b("ClassicBTConnectService", " run copyOfRange bytes" + read + ",data." + al.m7917a(Arrays.copyOfRange(bArr, 0, read)));
                this.f4523a.d.mo2570a(read, r2);
            } catch (IOException e) {
                C2538c.m12680e("ClassicBTConnectService", " data read socket disconnected error:" + e.getMessage() + "read thread exit.");
                this.f4523a.m8059d();
                C2538c.m12674b("ClassicBTConnectService", " ConnectedThread exited.");
                return;
            }
        }
    }

    public void m8068a(byte[] bArr) {
        try {
            this.f4526d.write(bArr);
        } catch (IOException e) {
            C2538c.m12680e("ClassicBTConnectService", " Exception during write" + e.getMessage());
        }
    }

    public void m8069a(byte[] bArr, int i) {
        try {
            this.f4526d.write(bArr, 0, i);
        } catch (IOException e) {
            C2538c.m12680e("ClassicBTConnectService", " Exception during writeWithLen" + e.getMessage());
        }
    }

    public void m8067a() {
        C2538c.m12674b("ClassicBTConnectService", " call  connected thread cancel() enter.");
        try {
            if (this.f4525c != null) {
                this.f4525c.close();
                C2538c.m12674b("ClassicBTConnectService", " call mmInStream.close.");
            }
        } catch (IOException e) {
            C2538c.m12680e("ClassicBTConnectService", " close() of mmInStream failed, error:" + e.getMessage());
        }
        try {
            if (this.f4526d != null) {
                this.f4526d.close();
                C2538c.m12674b("ClassicBTConnectService", " call mmOutStream.close.");
            }
        } catch (IOException e2) {
            C2538c.m12680e("ClassicBTConnectService", " close() of mmOutStream failed, error:" + e2.getMessage());
        }
        try {
            this.f4524b.close();
            C2538c.m12674b("ClassicBTConnectService", " old Socket mmSocket is closed.");
        } catch (IOException e22) {
            C2538c.m12680e("ClassicBTConnectService", " close() of connect socket failed" + e22.getMessage());
        }
    }
}

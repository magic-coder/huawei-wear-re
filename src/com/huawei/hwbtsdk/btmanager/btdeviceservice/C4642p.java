package com.huawei.hwbtsdk.btmanager.btdeviceservice;

import android.bluetooth.BluetoothSocket;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;
import com.unionpay.tsmservice.data.Constant;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* compiled from: BTDeviceBRService */
class C4642p extends Thread {
    final /* synthetic */ C4639m f16976a;
    private final BluetoothSocket f16977b;
    private final InputStream f16978c;
    private final OutputStream f16979d;

    private C4642p(C4639m c4639m, BluetoothSocket bluetoothSocket) {
        InputStream inputStream;
        IOException e;
        OutputStream outputStream = null;
        this.f16976a = c4639m;
        this.f16977b = bluetoothSocket;
        try {
            inputStream = bluetoothSocket.getInputStream();
            try {
                outputStream = bluetoothSocket.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                C2538c.a("0xA0200006", "01", 1, "BTDeviceBRService", new Object[]{"Get Input Stream Handle exception with info = " + e.getMessage()});
                this.f16978c = inputStream;
                this.f16979d = outputStream;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = outputStream;
            C2538c.a("0xA0200006", "01", 1, "BTDeviceBRService", new Object[]{"Get Input Stream Handle exception with info = " + e.getMessage()});
            this.f16978c = inputStream;
            this.f16979d = outputStream;
        }
        this.f16978c = inputStream;
        this.f16979d = outputStream;
    }

    public void run() {
        byte[] bArr = new byte[Constant.CALLBACK_UNITE_APP_LIST];
        while (true) {
            try {
                Arrays.fill(bArr, (byte) 0);
                int read = this.f16978c.read(bArr);
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, read);
                if (!(this.f16976a.f16965b == null || this.f16976a.f16968i == null)) {
                    this.f16976a.f16968i.setDeviceName(this.f16976a.f16964a.getName());
                    this.f16976a.f16968i.setDeviceIdentify(this.f16976a.f16964a.getAddress());
                    C2538c.a("01", 0, "BTDeviceBRService", new Object[]{"Device-->SDK : " + C0973a.a(copyOfRange)});
                    this.f16976a.f16965b.a(this.f16976a.f16968i, read, copyOfRange);
                }
            } catch (IOException e) {
                C2538c.b("01", 1, "BTDeviceBRService", new Object[]{"SPP Socket read occur IOException with info = " + e.getMessage()});
                this.f16976a.m22229a();
                return;
            }
        }
    }

    private void m22262a(byte[] bArr) {
        try {
            if (this.f16979d != null) {
                C2538c.a("01", 0, "BTDeviceBRService", new Object[]{"SDK-->Device : " + C0973a.a(bArr)});
                this.f16979d.write(bArr);
                return;
            }
            C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Send BT Data with mBTOutStream is null."});
        } catch (IOException e) {
            C2538c.a("0xA0200006", "01", 1, "BTDeviceBRService", new Object[]{"SPP Socket send occur IOException with info = " + e.getMessage()});
        }
    }

    public void m22263a() {
        try {
            if (this.f16978c != null) {
                this.f16978c.close();
            } else {
                C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Cancel Spp Socket with mBTInStream is null."});
            }
        } catch (IOException e) {
            C2538c.a("0xA0200000", "01", 1, "BTDeviceBRService", new Object[]{"In Stream close occur IOException with info = " + e.getMessage()});
        }
        try {
            if (this.f16979d != null) {
                this.f16979d.close();
            } else {
                C2538c.a("01", 1, "BTDeviceBRService", new Object[]{"Cancel Spp Socket with mBTOutStream is null."});
            }
        } catch (IOException e2) {
            C2538c.a("0xA0200000", "01", 1, "BTDeviceBRService", new Object[]{"Out Stream close occur IOException with info = " + e2.getMessage()});
        }
        try {
            this.f16977b.close();
        } catch (IOException e22) {
            C2538c.a("0xA0200000", "01", 1, "BTDeviceBRService", new Object[]{"Socket close occur IOException with info = " + e22.getMessage()});
        }
    }
}

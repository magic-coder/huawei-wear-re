package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwdevicedfxmanager.constants.HWDeviceDFXConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1620b;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1685c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1686d;
import java.nio.charset.Charset;

/* compiled from: BTBLEDeviceManager */
public class C1697c extends ak {
    private static C1697c f4492a = null;
    private as f4493b;
    private Context f4494c = null;
    private BluetoothDevice f4495d = null;
    private C1685c f4496e;
    private int f4497f = -1;

    private C1697c(Context context, int i) {
        this.f4494c = context;
        this.f4497f = i;
        this.f4493b = as.m7983a(this.f4494c, i);
    }

    public static C1697c m8023a(Context context, int i) {
        C2538c.m12674b("BTBLEDeviceManager", "BTBLEDeviceManager getInstance with deviceType: " + i);
        if (context != null) {
            synchronized (C1697c.class) {
                if (f4492a == null) {
                    C2538c.m12674b("BTBLEDeviceManager", "BTBLEDeviceManager is null");
                    f4492a = new C1697c(context, i);
                } else {
                    C2538c.m12674b("BTBLEDeviceManager", "mBTBLEDeviceManager is not null");
                }
            }
        }
        return f4492a;
    }

    public void mo2580a(C1685c c1685c) {
        if (this.f4493b != null && c1685c != null) {
            this.f4496e = c1685c;
            this.f4493b.m8007a(c1685c);
        }
    }

    public void mo2584b(C1685c c1685c) {
        C2538c.m12664a("BTBLEDeviceManager", "=======Enter unregisterDeviceConnectStatusCallback()========");
        if (this.f4493b == null || c1685c == null) {
            C2538c.m12664a("BTBLEDeviceManager", "=======sendCommandUtil or callback Is NULL========");
            return;
        }
        this.f4493b.m8011b(c1685c);
    }

    public void mo2578a(BluetoothDevice bluetoothDevice) {
        C2538c.m12664a("BTBLEDeviceManager", "=======Enter connect(macAddress)======");
        String address = bluetoothDevice.getAddress();
        if (this.f4493b != null) {
            new Handler(this.f4494c.getMainLooper()).postDelayed(new C1698d(this, bluetoothDevice, address), 1000);
        }
    }

    public void mo2576a() {
        if (this.f4493b != null) {
            this.f4493b.m8010b();
            return;
        }
        C2538c.m12664a("BTBLEDeviceManager", " sendCommandUtil Is NULL");
    }

    public int mo2583b() {
        C2538c.m12664a("BTBLEDeviceManager", "Enter getConnectStatus()");
        if (this.f4493b != null) {
            return as.m7999c();
        }
        return 0;
    }

    private void m8027e() {
        if (this.f4493b == null) {
            this.f4493b = as.m7983a(this.f4494c, this.f4497f);
            C2538c.m12674b("BTBLEDeviceManager", "sendCommandUtil is null ,create a instance ");
        }
    }

    public void mo2579a(C1620b c1620b, int i) {
        C2538c.m12664a("BTBLEDeviceManager", " Enter turnOnLostAlert()");
        m8027e();
        byte[] bArr = null;
        switch (i) {
            case 1:
                bArr = C0973a.m3512b(C0973a.m3506a(1));
                break;
            case 2:
                bArr = C0973a.m3512b(C0973a.m3506a(0));
                break;
            case 3:
                bArr = C0973a.m3512b(C0973a.m3506a(3));
                break;
            default:
                C2538c.m12664a("BTBLEDeviceManager", " type is unknow! type=" + i);
                break;
        }
        if (bArr != null) {
            C2538c.m12674b("BTBLEDeviceManager", "turnOnLostAlert:" + new String(bArr, Charset.defaultCharset()));
            this.f4493b.m8005a(bArr.length, bArr);
        }
    }

    public void mo2581a(C1686d c1686d, int i) {
        super.mo2581a(c1686d, i);
        C2538c.m12674b("BTBLEDeviceManager", "Enter searchBluetoothDevice()");
        if (this.f4493b != null) {
            this.f4493b.m8008a(c1686d, i);
        }
    }

    public void mo2585c() {
        super.mo2585c();
        C2538c.m12674b("BTBLEDeviceManager", "Enter cancelSearchBluetoothDevice()");
        if (this.f4493b != null) {
            this.f4493b.m8013d();
        }
    }

    public void mo2582a(byte[] bArr, int i, C1620b c1620b) {
        String str;
        C2538c.m12664a("BTBLEDeviceManager", " Enter writeAuthenticationCharacteristic()");
        if (i == 1) {
            str = C0973a.m3506a(16) + C0973a.m3506a(1) + C0973a.m3506a(16) + C0973a.m3509a(bArr);
        } else if (i == 2) {
            str = C0973a.m3506a(16) + C0973a.m3506a(2) + C0973a.m3506a(16) + C0973a.m3509a(bArr);
        } else {
            c1620b.mo2554a(100005, HWDeviceDFXConstants.ERROR_CODE_INFO_REQUEST_FORMAT_ERROR);
            return;
        }
        this.f4493b.m8009a(C0973a.m3512b(str), c1620b);
    }

    public boolean mo2586d() {
        return this.f4493b.m8014e();
    }

    public void mo2577a(int i, C1620b c1620b) {
        byte[] b;
        String str = null;
        C2538c.m12664a("BTBLEDeviceManager", " Enter writeDataToLinkLossCharacteristic()");
        switch (i) {
            case 1:
                b = C0973a.m3512b(C0973a.m3506a(1));
                break;
            case 2:
                b = C0973a.m3512b(C0973a.m3506a(0));
                break;
            default:
                b = null;
                break;
        }
        String str2 = "BTBLEDeviceManager";
        Object[] objArr = new Object[1];
        StringBuilder append = new StringBuilder().append("writeDataToLinkLossCharacteristic:");
        if (b != null) {
            str = new String(b, Charset.defaultCharset());
        }
        objArr[0] = append.append(str).toString();
        C2538c.m12664a(str2, objArr);
        this.f4493b.m8012b(b, c1620b);
    }
}

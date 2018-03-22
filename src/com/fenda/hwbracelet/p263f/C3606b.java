package com.fenda.hwbracelet.p263f;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.fenda.hwbracelet.p260c.C3581a;
import com.fenda.p255a.p256a.C3566b;
import com.huawei.p032e.p264a.p265a.p266b.C3605d;
import com.huawei.p032e.p264a.p265a.p266b.C4386b;
import com.huawei.p032e.p264a.p265a.p266b.C4387c;
import com.huawei.p032e.p264a.p265a.p266b.C4388e;
import com.huawei.p032e.p264a.p386b.C4389a;
import com.huawei.p190v.C2538c;

/* compiled from: AF500HealthManager */
public class C3606b implements C3605d {
    private C4387c f13827a = null;
    private Context f13828b = null;
    private C4386b f13829c;
    private String f13830d;

    public C3606b(Context context) {
        this.f13828b = context;
        C3609e.m18112a(context);
    }

    public void mo4221a(BluetoothDevice bluetoothDevice) {
        if (this.f13828b != null) {
            C3609e.m18112a(this.f13828b).m18119a(bluetoothDevice, this.f13827a);
            C3566b c3566b = new C3566b(this.f13828b);
            if (c3566b != null) {
                c3566b.m17907a(bluetoothDevice.getAddress());
            }
        } else if (this.f13827a != null) {
            this.f13827a.mo5110a(3);
        }
    }

    public boolean mo4227a(C4388e c4388e, String str) {
        switch (c4388e) {
            case TYPE_CALLING:
                this.f13830d = str;
                C2538c.c("AF500HealthManager", new Object[]{"calling number: " + this.f13830d});
                break;
            case TYPE_CALLING_END:
                C3581a.m17962b();
                break;
            case TYPE_LOST_PHONE:
                C3581a.m17966c();
                break;
        }
        return true;
    }

    public void mo4218a() {
        C2538c.c("AF500HealthManager", new Object[]{"disconnect"});
        if (this.f13828b != null) {
            C3609e.m18112a(this.f13828b).m18125b();
        }
    }

    public void mo4223a(C4387c c4387c) {
        this.f13827a = c4387c;
        C3581a.m17957a(c4387c);
    }

    public void mo4226a(byte[] bArr) {
        C3581a.m17961a(bArr);
    }

    public void mo4224a(C4388e c4388e) {
        switch (c4388e) {
            case TYPE_CALLING:
                C2538c.c("AF500HealthManager", new Object[]{"XCommand.sendIncomingCallMessage, number: " + this.f13830d});
                if (this.f13830d != null) {
                    C3581a.m17954a(this.f13828b, this.f13830d);
                    this.f13830d = null;
                    return;
                }
                return;
            case TYPE_CALLING_END:
                C3581a.m17962b();
                return;
            case TYPE_LOST_PHONE:
                C3581a.m17966c();
                return;
            default:
                return;
        }
    }

    public void mo4225a(C4389a c4389a) {
        C3581a.m17958a(c4389a);
    }

    public void mo4228b() {
        C3581a.m17963b(this.f13828b);
    }

    public void mo4219a(int i) {
        C3581a.m17951a(i);
    }

    public void mo4220a(int i, int i2) {
        C3581a.m17952a(i2, i);
    }

    public void mo4222a(C4386b c4386b) {
        C2538c.c("AF500HealthManager", new Object[]{"XCommand.setGetTotalDataFromDevice "});
        this.f13829c = c4386b;
        C3581a.m17956a(c4386b);
    }
}

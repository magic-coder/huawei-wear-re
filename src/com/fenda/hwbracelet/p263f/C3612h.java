package com.fenda.hwbracelet.p263f;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.ParcelUuid;
import com.fenda.hwbracelet.p258b.p259a.C3578a;
import com.fenda.hwbracelet.p258b.p259a.C3580c;
import com.fenda.hwbracelet.p260c.C3581a;
import com.fenda.hwbracelet.p262e.C3603f;
import com.fenda.hwbracelet.p267g.C3614a;
import com.huawei.p190v.C2538c;

import java.nio.ByteBuffer;
import java.util.UUID;

/* compiled from: XbService */
class C3612h implements Callback {
    final /* synthetic */ C3609e f13849a;

    C3612h(C3609e c3609e) {
        this.f13849a = c3609e;
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 3:
                Bundle data = message.getData();
                if (data != null) {
                    ParcelUuid parcelUuid = (ParcelUuid) data.getParcelable("SERVUUID");
                    if (parcelUuid != null) {
                        UUID uuid = parcelUuid.getUuid();
                        parcelUuid = (ParcelUuid) data.getParcelable("CHARUUID");
                        if (parcelUuid != null) {
                            UUID uuid2 = parcelUuid.getUuid();
                            byte[] byteArray = data.getByteArray("CVALUE");
                            if (byteArray != null) {
                                C2538c.c("XbService", new Object[]{"receivced data @service: " + C3580c.m17949a(uuid, "unkown") + " @characteristic: " + C3578a.m17948a(uuid2, "unkown") + " and data: " + C3608d.m18110a(byteArray)});
                                if (uuid.equals(C3580c.f13701a) && uuid2.equals(C3578a.f13696a) && byteArray.length >= 1) {
                                    ByteBuffer wrap = ByteBuffer.wrap(byteArray);
                                    C3603f c3603f = new C3603f(wrap.get(), wrap.slice());
                                    C3614a.m18129a().m18139a(this.f13849a.f13839h);
                                    C3614a.m18129a().m18141a(this.f13849a.f13833a, this.f13849a.f13841j, c3603f);
                                    break;
                                }
                            }
                        }
                        C2538c.e("XbService", new Object[]{"parcelUuid1 is null"});
                        break;
                    }
                    C2538c.e("XbService", new Object[]{"parcelUuid is null"});
                    break;
                }
                C2538c.c("XbService", new Object[]{"bundle is null"});
                break;
                break;
            case 11:
                if (message.getData().getInt("RSSI") < this.f13849a.f13835d) {
                    C2538c.c("XbService", new Object[]{"rssi: " + message.getData().getInt("RSSI")});
                    if (this.f13849a.f13839h == null) {
                        C2538c.e("XbService", new Object[]{"mContext == null"});
                    }
                    C3581a.m17966c();
                    break;
                }
                break;
        }
        return false;
    }
}

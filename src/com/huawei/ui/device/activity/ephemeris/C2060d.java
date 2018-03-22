package com.huawei.ui.device.activity.ephemeris;

import com.huawei.p190v.C2538c;

/* compiled from: UpdateEphemerisActivity */
class C2060d implements Runnable {
    final /* synthetic */ UpdateEphemerisActivity f7232a;

    C2060d(UpdateEphemerisActivity updateEphemerisActivity) {
        this.f7232a = updateEphemerisActivity;
    }

    public void run() {
        C2538c.m12677c("UpdateEphemerisActivity", "eph delayTensShowSuccessUI delay 12 check!!!");
        this.f7232a.m10716b("com.huawei.bone.ephemeris.checkUpdate");
        this.f7232a.m10729j();
    }
}

package com.huawei.ui.device.activity.ephemeris;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: UpdateEphemerisActivity */
class C2059c extends BroadcastReceiver {
    final /* synthetic */ UpdateEphemerisActivity f7231a;

    C2059c(UpdateEphemerisActivity updateEphemerisActivity) {
        this.f7231a = updateEphemerisActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            C2538c.m12677c("UpdateEphemerisActivity", "eph mLocalStateChangedReceiver(): intent is null return !!! ");
            return;
        }
        C2538c.m12677c("UpdateEphemerisActivity", "eph mLocalStateChangedReceiver(): intent = " + intent.getAction());
        if (context == null) {
            return;
        }
        if ("com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            this.f7231a.m10707a(intent);
        } else if ("com.huawei.bone.ephemeris.currentState.updating".equals(intent.getAction())) {
            this.f7231a.m10714b(intent);
        } else if ("com.huawei.bone.ephemeris.currentState.update.sucess".equals(intent.getAction())) {
            if (this.f7231a.f7201B == 0) {
                this.f7231a.m10728i();
            } else {
                this.f7231a.m10729j();
            }
        } else if ("com.huawei.bone.ephemeris.currentState.update.fail".equals(intent.getAction()) && 3 == this.f7231a.f7200A) {
            this.f7231a.m10725g();
        }
    }
}

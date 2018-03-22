package com.aps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class C3512v extends BroadcastReceiver {
    C3512v(bz bzVar) {
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (intent.getAction().equals("android.location.GPS_FIX_CHANGE")) {
                    bz.f13102b = false;
                }
            } catch (Exception e) {
            }
        }
    }
}

package com.aps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

final class C3509s extends BroadcastReceiver {
    final /* synthetic */ C3505o f13236a;

    private C3509s(C3505o c3505o) {
        this.f13236a = c3505o;
    }

    public final void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            try {
                if (this.f13236a.f13211d != null && this.f13236a.f13205A != null && this.f13236a.f13232z != null && intent.getAction() != null && "android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                    List scanResults = this.f13236a.f13211d.getScanResults();
                    synchronized (this) {
                        this.f13236a.f13232z.clear();
                        this.f13236a.f13226s = System.currentTimeMillis();
                        if (scanResults != null && scanResults.size() > 0) {
                            for (int i = 0; i < scanResults.size(); i++) {
                                this.f13236a.f13232z.add((ScanResult) scanResults.get(i));
                            }
                        }
                    }
                    TimerTask c3510t = new C3510t(this);
                    synchronized (this) {
                        if (this.f13236a.f13205A != null) {
                            this.f13236a.f13205A.cancel();
                            this.f13236a.f13205A = null;
                        }
                        this.f13236a.f13205A = new Timer();
                        this.f13236a.f13205A.schedule(c3510t, (long) C3505o.f13203D);
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}

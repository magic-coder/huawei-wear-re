package com.aps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: APS */
class ag extends BroadcastReceiver {
    final /* synthetic */ ac f12893a;

    private ag(ac acVar) {
        this.f12893a = acVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    if (this.f12893a.f12874l != null) {
                        this.f12893a.f12877o = this.f12893a.f12874l.getScanResults();
                        this.f12893a.f12853B = bu.m17460b();
                        if (this.f12893a.f12877o == null) {
                            this.f12893a.f12877o = new ArrayList();
                        }
                    }
                } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                    if (this.f12893a.f12874l != null) {
                        int i = 4;
                        try {
                            i = this.f12893a.f12874l.getWifiState();
                        } catch (SecurityException e) {
                        }
                        switch (i) {
                            case 0:
                                this.f12893a.m17244o();
                                return;
                            case 1:
                                this.f12893a.m17244o();
                                return;
                            case 4:
                                this.f12893a.m17244o();
                                return;
                            default:
                                return;
                        }
                        th.printStackTrace();
                    }
                } else if (action.equals("android.intent.action.SCREEN_ON")) {
                    this.f12893a.m17231g();
                    this.f12893a.m17245p();
                    ax.f12979i = 10000;
                    ax.f12980j = StatisticConfig.MIN_UPLOAD_INTERVAL;
                } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                    if (this.f12893a.f12855D >= 5) {
                        ax.f12979i = 20000;
                        ax.f12980j = FileWatchdog.DEFAULT_DELAY;
                    }
                } else if (action.equals("android.intent.action.AIRPLANE_MODE")) {
                    this.f12893a.f12887y = bu.m17455a(context);
                } else if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    this.f12893a.m17256a(true, 2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}

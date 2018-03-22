package com.tencent.map.p535b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

public final class C6315g {
    private Context f22001a;
    private WifiManager f22002b;
    private Handler f22003c;
    private Runnable f22004d;
    private int f22005e;
    private C6312p f22006f;
    private C6323o f22007g;
    private boolean f22008h;

    public final class C6314a extends BroadcastReceiver {
        private int f21997a;
        private List<ScanResult> f21998b;
        private boolean f21999c;
        private /* synthetic */ C6315g f22000d;

        private void m28978a(List<ScanResult> list) {
            if (list != null) {
                if (this.f21999c) {
                    if (this.f21998b == null) {
                        this.f21998b = new ArrayList();
                    }
                    int size = this.f21998b.size();
                    for (ScanResult scanResult : list) {
                        for (int i = 0; i < size; i++) {
                            if (((ScanResult) this.f21998b.get(i)).BSSID.equals(scanResult.BSSID)) {
                                this.f21998b.remove(i);
                                break;
                            }
                        }
                        this.f21998b.add(scanResult);
                    }
                    return;
                }
                if (this.f21998b == null) {
                    this.f21998b = new ArrayList();
                } else {
                    this.f21998b.clear();
                }
                for (ScanResult scanResult2 : list) {
                    this.f21998b.add(scanResult2);
                }
            }
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                this.f21997a = intent.getIntExtra("wifi_state", 4);
                if (this.f22000d.f22006f != null) {
                    this.f22000d.f22006f.mo5303a(this.f21997a);
                }
            }
            if (intent.getAction().equals("android.net.wifi.SCAN_RESULTS") || intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                List list = null;
                if (this.f22000d.f22002b != null) {
                    list = this.f22000d.f22002b.getScanResults();
                }
                if (intent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                    if (list == null) {
                        return;
                    }
                    if (list != null && list.size() == 0) {
                        return;
                    }
                }
                if (this.f21999c || this.f21998b == null || this.f21998b.size() < 4 || list == null || list.size() > 2) {
                    m28978a(list);
                    this.f21999c = false;
                    this.f22000d.f22007g = new C6323o(this.f22000d, this.f21998b, System.currentTimeMillis(), this.f21997a);
                    if (this.f22000d.f22006f != null) {
                        this.f22000d.f22006f.mo5304a(this.f22000d.f22007g);
                    }
                    this.f22000d.m28984a(((long) this.f22000d.f22005e) * 20000);
                    return;
                }
                m28978a(list);
                this.f21999c = true;
                this.f22000d.m28984a(0);
            }
        }
    }

    public final void m28984a(long j) {
        if (this.f22003c != null && this.f22008h) {
            this.f22003c.removeCallbacks(this.f22004d);
            this.f22003c.postDelayed(this.f22004d, j);
        }
    }

    public final boolean m28985a() {
        return this.f22008h;
    }

    public final boolean m28986b() {
        return (this.f22001a == null || this.f22002b == null) ? false : this.f22002b.isWifiEnabled();
    }
}

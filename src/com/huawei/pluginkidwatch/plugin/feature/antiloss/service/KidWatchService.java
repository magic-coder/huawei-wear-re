package com.huawei.pluginkidwatch.plugin.feature.antiloss.service;

import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.plugin.feature.antiloss.p162a.C1773a;
import com.huawei.pluginkidwatch.plugin.p152a.C1647c;
import com.huawei.pluginkidwatch.plugin.p152a.C1723d;
import com.huawei.pluginkidwatch.plugin.p152a.C1743x;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;

public class KidWatchService extends Service {
    private C1798c f4945a;
    private C1723d f4946b;
    private BluetoothAdapter f4947c = BluetoothAdapter.getDefaultAdapter();
    private Boolean f4948d = Boolean.valueOf(false);
    private C1797b f4949e = null;
    private C1799d f4950f;
    private boolean f4951g = false;
    private int f4952h = 1000;
    private C1647c f4953i = new C1796a(this);

    public IBinder onBind(Intent intent) {
        C2538c.m12674b("KidWatchService", "----onBind----");
        if (this.f4945a == null) {
            this.f4945a = new C1798c(this);
        }
        return this.f4945a;
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void onCreate() {
        C2538c.m12674b("KidWatchService", "----KidWatchService onCreate----");
        super.onCreate();
        this.f4952h = 1000;
        this.f4951g = true;
        C1773a.m8553b(this);
        this.f4949e = new C1797b(this);
        m8570a();
        this.f4950f = new C1799d(this);
        C1497q.m6942a((Context) this, "kidwatch_service_state", Boolean.valueOf(true));
        m8575b(false);
    }

    private void m8570a() {
        this.f4946b = C1743x.m8322a((Context) this).m8323a();
        if (this.f4946b != null) {
            this.f4946b.m8284a(this.f4953i);
        }
    }

    private void m8575b(boolean z) {
        if (z) {
            m8574b();
        } else {
            stopForeground(true);
        }
    }

    private void m8574b() {
        CharSequence string;
        String str = "";
        if (C1462f.m6748k() == null) {
            string = getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_doing_bluetooth_antiloss, new Object[]{getResources().getString(C1680l.IDS_plugin_kidwatch_settings_profilekid_nickname_default)});
        } else {
            string = getResources().getString(C1680l.IDS_plugin_kidwatch_feature_antiloss_doing_bluetooth_antiloss, new Object[]{C1462f.m6748k().f3083c});
        }
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, KidWatchService.class), 0);
        Builder builder = new Builder(this);
        builder.setAutoCancel(true);
        builder.setContentIntent(activity);
        builder.setSmallIcon(C1617f.app_logo_little);
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle(getText(C1680l.IDS_plugin_kidwatch_feature_antiloss_open_bluetooth_antiloss));
        builder.setContentText(string);
        builder.setDefaults(98);
        startForeground(110, builder.build());
    }

    public void onDestroy() {
        C2538c.m12674b("KidWatchService", "----KidWatchService onDestroy----");
        this.f4951g = false;
        m8575b(false);
        super.onDestroy();
        m8580e();
        this.f4946b = C1743x.m8322a((Context) this).m8323a();
        if (this.f4946b != null) {
            this.f4946b.m8287b();
        }
        this.f4949e = null;
        C1497q.m6942a((Context) this, "kidwatch_service_state", Boolean.valueOf(false));
    }

    private void m8577c() {
        C2538c.m12674b("KidWatchService", "startCurKidWatchAntiloss ...");
        this.f4946b = C1743x.m8322a((Context) this).m8323a();
        if (this.f4946b != null) {
            if (!this.f4948d.booleanValue()) {
                this.f4946b.m8292c(6);
                C1497q.m6942a((Context) this, "kidwatch_antiloss_state", Boolean.valueOf(true));
            }
            this.f4946b.m8286a(true);
        }
        this.f4950f.m8601c();
        this.f4950f.m8599a(true);
        if (this.f4949e != null) {
            this.f4949e.removeMessages(101);
        }
        m8575b(true);
    }

    public void m8587a(boolean z) {
        C2538c.m12674b("KidWatchService", "closeCurKidWatchAntiloss ... isManualClose = " + z);
        this.f4946b = C1743x.m8322a((Context) this).m8323a();
        this.f4950f.m8601c();
        this.f4950f.m8599a(false);
        if (z) {
            m8578d();
        } else {
            this.f4948d = Boolean.valueOf(true);
            if (this.f4949e != null) {
                this.f4949e.removeMessages(101);
                this.f4949e.sendEmptyMessageDelayed(101, 500);
            }
        }
        if (this.f4946b != null) {
            this.f4946b.m8286a(this.f4948d.booleanValue());
        }
    }

    private void m8578d() {
        this.f4948d = Boolean.valueOf(false);
        if (this.f4946b != null) {
            this.f4946b.m8292c(9);
        }
        if (this.f4951g) {
            C1497q.m6942a((Context) this, "kidwatch_antiloss_state", Boolean.valueOf(false));
        }
        if (this.f4949e != null) {
            this.f4949e.removeMessages(101);
            this.f4949e.removeMessages(102);
            this.f4949e.removeMessages(103);
        }
        m8575b(false);
    }

    public void m8585a(long j) {
        C2538c.m12674b("KidWatchService", "========进入圈内 onInRange timeStamp = " + j);
        this.f4950f.m8601c();
        this.f4950f.m8598a("rangein.close.antiloss.radarimage");
        this.f4946b = C1743x.m8322a((Context) this).m8323a();
        if (this.f4946b != null) {
            this.f4946b.m8292c(8);
        }
        this.f4950f.m8602d();
        this.f4950f.m8597a(8);
        if (this.f4949e != null) {
            this.f4949e.removeMessages(102);
        }
    }

    public void m8586a(long j, int i) {
        C2538c.m12674b("KidWatchService", "=========出圈 onOutRange timeStamp = " + j + " type = " + i + " KWCache.isRadar() = " + C1462f.m6755o());
        this.f4950f.m8601c();
        this.f4946b = C1743x.m8322a((Context) this).m8323a();
        if (this.f4946b != null) {
            this.f4946b.m8292c(7);
        }
        if (this.f4949e != null && 1001 == this.f4952h) {
            this.f4949e.removeMessages(102);
            this.f4949e.sendEmptyMessageDelayed(102, LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
        }
        if (!C1462f.m6755o()) {
            this.f4950f.m8597a(7);
            this.f4950f.m8600b();
        }
    }

    private void m8580e() {
        C2538c.m12674b("KidWatchService", "onRangeOutTimeoutProcess runnableRangeOutTimeout !!!!");
        m8587a(true);
        this.f4950f.m8596a();
    }

    private void m8571a(int i) {
        this.f4946b = C1743x.m8322a((Context) this).m8323a();
        if (this.f4946b == null) {
            C2538c.m12674b("KidWatchService", "onDataReceived curKWBtDevice is null return !!!");
            return;
        }
        C2538c.m12674b("KidWatchService", "000000 serviceChangeBluetoothState onDataReceived state = " + i);
        switch (i) {
            case -1:
            case 0:
            case 3:
                m8583g();
                break;
            case 2:
                m8582f();
                break;
        }
        this.f4950f.m8601c();
    }

    private void m8582f() {
        if (this.f4949e != null) {
            this.f4949e.removeMessages(103);
        }
        m8577c();
        if (1000 == this.f4952h) {
            m8585a(0);
        }
    }

    private void m8583g() {
        if (!this.f4947c.isEnabled()) {
            C2538c.m12674b("KidWatchService", "serviceChangeBluetoothState STATE_DISCONNECT btAdapter.isEnabled false!!!!");
            m8587a(true);
            this.f4946b.m8292c(9);
            this.f4946b.m8288b(0);
        } else if (6 == this.f4946b.m8303j() || 8 == this.f4946b.m8303j()) {
            C2538c.m12674b("KidWatchService", "serviceChangeBluetoothState STATE_DISCONNECT 1111111111111");
            m8584h();
        } else if (7 == this.f4946b.m8303j()) {
            C2538c.m12674b("KidWatchService", "serviceChangeBluetoothState STATE_DISCONNECT 222222222222");
            m8587a(false);
        } else if (9 == this.f4946b.m8303j()) {
            m8587a(true);
        }
    }

    private void m8584h() {
        if (this.f4949e != null) {
            this.f4949e.removeMessages(103);
            this.f4949e.sendEmptyMessageDelayed(103, LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
        }
        this.f4946b.m8292c(7);
        m8587a(false);
        if (1000 == this.f4952h) {
            m8586a(1000, 1);
        } else if (!C1462f.m6755o()) {
            this.f4950f.m8600b();
        }
    }
}

package com.huawei.pluginkidwatch.plugin.feature.antiloss.p162a;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Vibrator;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetOModel;
import com.huawei.pluginkidwatch.k;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: AntilossUtils */
public class C1773a {
    private static C1773a f4915b = null;
    private final long[] f4916a = new long[]{500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500};
    private Context f4917c;
    private MediaPlayer f4918d = null;
    private Vibrator f4919e = null;
    private WakeLock f4920f;
    private Timer f4921g = new Timer();
    private TimerTask f4922h = new C1776d(this);

    public static C1773a m8552a(Context context) {
        if (f4915b == null) {
            f4915b = new C1773a(context);
        }
        return f4915b;
    }

    private C1773a(Context context) {
        this.f4917c = context;
    }

    public static void m8553b(Context context) {
        f4915b = new C1773a(context);
    }

    public void m8554a() {
        C2538c.m12674b("AntilossUtils", "===========Enter antilossAlarm");
        m8559d();
        m8556b();
    }

    public void m8556b() {
        C2538c.m12674b("AntilossUtils", "===========Enter startAlarmTimeoutTimer");
        if (this.f4921g == null) {
            this.f4921g = new Timer();
        }
        this.f4922h.cancel();
        this.f4922h = new C1776d(this);
        this.f4921g.schedule(this.f4922h, FileWatchdog.DEFAULT_DELAY);
    }

    public void m8557c() {
        if (this.f4921g != null) {
            this.f4921g.cancel();
            this.f4921g = null;
        }
    }

    public void m8559d() {
        C2538c.m12674b("AntilossUtils", "===========Enter antilossRangeOutAlarm");
        if (this.f4918d == null) {
            this.f4918d = MediaPlayer.create(this.f4917c, k.antiloss_ring);
        } else {
            this.f4918d.stop();
        }
        this.f4918d.setOnPreparedListener(new C1774b(this));
        try {
            this.f4918d.setLooping(true);
            this.f4918d.prepareAsync();
        } catch (IllegalStateException e) {
            C2538c.m12674b("AntilossUtils", "===========Enter antilossRangeOutAlarm IllegalStateException !!!!!!");
        }
        this.f4918d.start();
        C2538c.m12674b("AntilossUtils", "mMediaPlayer start !!!");
        this.f4919e = (Vibrator) this.f4917c.getSystemService("vibrator");
        if (this.f4919e.hasVibrator()) {
            this.f4919e.cancel();
        }
        this.f4919e.vibrate(this.f4916a, -1);
    }

    public void m8561e() {
        if (this.f4918d != null) {
            if (this.f4918d.isPlaying()) {
                this.f4918d.stop();
            }
            C2538c.m12674b("AntilossUtils", "mMediaPlayer stop !!!");
            this.f4918d.release();
            this.f4918d = null;
        }
        if (this.f4919e != null && this.f4919e.hasVibrator()) {
            this.f4919e.cancel();
        }
    }

    public void m8558c(Context context) {
        C2538c.m12674b("AntilossUtils", "===========Enter goToHomeActivity");
        Intent intent = new Intent();
        intent.setClassName(context, "com.huawei.pluginkidwatch.home.HomeActivity");
        context.startActivity(intent);
    }

    public void m8555a(Context context, String str, Class cls) {
        Intent intent = new Intent();
        if (!"".equals(str)) {
            intent.setClassName(context, str);
        } else if (cls != null) {
            intent.setClass(context, cls);
        }
        try {
            PendingIntent.getActivity(context, 0, intent, HwAccountConstants.FLAG_TRANS_NAVIGATION_BAR).send(context, 0, intent);
        } catch (CanceledException e) {
            C2538c.m12674b("====== PendingIntent.CanceledException e = " + e.getMessage(), new Object[0]);
        }
    }

    public void m8560d(Context context) {
        C2538c.m12674b("AntilossUtils", "=======requestKidWatchOpenBleAntiloss");
        C1413d a = C1417a.m6594a(context);
        CommonRetOModel commonRetOModel = new CommonRetOModel();
        commonRetOModel.data = "";
        commonRetOModel.deviceCode = C1462f.m6746j();
        commonRetOModel.type = 5;
        if (a != null) {
            a.mo2473a(commonRetOModel, new C1775c(this));
        }
    }

    public void m8562f() {
        this.f4920f = ((PowerManager) this.f4917c.getSystemService("power")).newWakeLock(536870922, "AntilossUtils");
        if (this.f4920f != null) {
            this.f4920f.acquire(FileWatchdog.DEFAULT_DELAY);
        }
    }

    public void m8563g() {
        if (this.f4920f != null && this.f4920f.isHeld()) {
            this.f4920f.release();
        }
    }
}

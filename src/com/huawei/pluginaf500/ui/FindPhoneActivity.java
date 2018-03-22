package com.huawei.pluginaf500.ui;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Vibrator;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;
import com.huawei.pluginaf500.g;
import com.huawei.pluginaf500.h;
import com.huawei.p190v.C2538c;
import java.io.IOException;
import org.apache.log4j.helpers.FileWatchdog;

public class FindPhoneActivity extends AF500BaseActivity {
    private static final String f19728a = "FindPhoneActivity".toString();
    private long[] f19729b = new long[]{1000, 500};
    private boolean f19730c = false;
    private MediaPlayer f19731d;
    private Vibrator f19732g;
    private TelephonyManager f19733h;
    private int f19734i = 0;
    private TextView f19735j;
    private WakeLock f19736k;
    private Handler f19737l = new aj(this);
    private PhoneStateListener f19738m = new ak(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19736k = ((PowerManager) getSystemService("power")).newWakeLock(268435466, "bright");
        this.f19736k.acquire(FileWatchdog.DEFAULT_DELAY);
        this.f19735j = (TextView) findViewById(e.find_phone_text);
        String str = "ColorBand";
        this.f19735j.setText(getString(h.finding_phone));
        this.f19732g = (Vibrator) getSystemService("vibrator");
        this.f19733h = (TelephonyManager) getSystemService("phone");
        this.f19733h.listen(this.f19738m, 32);
        this.f19730c = false;
    }

    public void onResume() {
        super.onResume();
        if (!this.f19730c) {
            this.f19731d = new MediaPlayer();
            this.f19731d.setOnErrorListener(new ai(this));
            try {
                if (this.f19733h.getCallState() != 0) {
                    this.f19731d.setVolume(0.125f, 0.125f);
                    m26707a(getResources(), this.f19731d, g.fallbackring);
                } else {
                    m26707a(getResources(), this.f19731d, g.carina);
                }
                m26708a(this.f19731d);
            } catch (Exception e) {
                C2538c.e(f19728a, new Object[]{"Exception e = " + e.getMessage()});
                try {
                    m26707a(getResources(), this.f19731d, g.fallbackring);
                    m26708a(this.f19731d);
                } catch (IOException e2) {
                }
            }
            this.f19732g.vibrate(this.f19729b, 0);
            m26709k();
            this.f19734i = this.f19733h.getCallState();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m26707a(android.content.res.Resources r8, android.media.MediaPlayer r9, int r10) {
        /*
        r7 = this;
        r6 = r8.openRawResourceFd(r10);
        if (r6 == 0) goto L_0x0019;
    L_0x0006:
        r1 = r6.getFileDescriptor();	 Catch:{ IOException -> 0x001a, all -> 0x0021 }
        r2 = r6.getStartOffset();	 Catch:{ IOException -> 0x001a, all -> 0x0021 }
        r4 = r6.getLength();	 Catch:{ IOException -> 0x001a, all -> 0x0021 }
        r0 = r9;
        r0.setDataSource(r1, r2, r4);	 Catch:{ IOException -> 0x001a, all -> 0x0021 }
        r6.close();	 Catch:{ IOException -> 0x0026 }
    L_0x0019:
        return;
    L_0x001a:
        r0 = move-exception;
        r6.close();	 Catch:{ IOException -> 0x001f }
        goto L_0x0019;
    L_0x001f:
        r0 = move-exception;
        goto L_0x0019;
    L_0x0021:
        r0 = move-exception;
        r6.close();	 Catch:{ IOException -> 0x0028 }
    L_0x0025:
        throw r0;
    L_0x0026:
        r0 = move-exception;
        goto L_0x0019;
    L_0x0028:
        r1 = move-exception;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.pluginaf500.ui.FindPhoneActivity.a(android.content.res.Resources, android.media.MediaPlayer, int):void");
    }

    private void m26708a(MediaPlayer mediaPlayer) throws IllegalStateException, IOException {
        if (((AudioManager) getSystemService("audio")).getStreamVolume(4) != 0) {
            mediaPlayer.setAudioStreamType(4);
            mediaPlayer.setLooping(true);
            mediaPlayer.prepare();
            mediaPlayer.start();
            this.f19730c = true;
        }
    }

    public void viewOnClick(View view) {
        if (view.getId() == e.find_phone_button) {
            mo5115j();
            finish();
        }
    }

    public void mo5115j() {
        if (this.f19730c) {
            this.f19730c = false;
            if (this.f19731d == null) {
            }
            if (this.f19731d != null) {
                this.f19731d.stop();
                this.f19731d.release();
                this.f19731d = null;
            }
        }
        this.f19732g.cancel();
        m26710l();
    }

    private void m26709k() {
        this.f19737l.sendMessageDelayed(this.f19737l.obtainMessage(1000), StatisticConfig.MIN_UPLOAD_INTERVAL);
    }

    private void m26710l() {
        this.f19737l.removeMessages(1000);
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f19733h.listen(this.f19738m, 0);
        if (this.f19736k != null) {
            this.f19736k.release();
        }
        mo5115j();
    }

    protected int mo5104a() {
        return f.act_find_phone;
    }

    protected int mo5114f() {
        return 0;
    }
}

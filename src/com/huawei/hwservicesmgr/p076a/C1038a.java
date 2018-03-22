package com.huawei.hwservicesmgr.p076a;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwdevicemgr.c;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwdevicemgr.p073a.C1023c;
import com.huawei.hwservicesmgr.a.b;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.p190v.C2538c;
import java.util.Locale;

/* compiled from: HWFindPhoneMgr */
public class C1038a {
    private static C1038a f1970b = null;
    private static final Object f1971g = new Object();
    private Context f1972a;
    private MediaPlayer f1973c = null;
    private AudioManager f1974d = null;
    private int f1975e = 0;
    private int f1976f = 0;
    private Handler f1977h = new b(this);

    public C1038a(Context context) {
        this.f1972a = context;
    }

    public void m4267a() {
        if (this.f1977h != null) {
            this.f1977h.removeCallbacksAndMessages(null);
            this.f1977h = null;
        }
    }

    public static C1038a m4260a(Context context) {
        C1038a c1038a;
        synchronized (f1971g) {
            if (f1970b == null) {
                f1970b = new C1038a(context);
            }
            c1038a = f1970b;
        }
        return c1038a;
    }

    public void m4269a(byte[] bArr) {
        if (bArr.length < 5) {
            C2538c.m12679d("HWFindPhoneMgr", "handleFindPhoneOperationReport ,length < 5, return");
        } else if ((byte) 1 == bArr[1]) {
            switch (bArr[4]) {
                case (byte) 1:
                    C2538c.m12677c("HWFindPhoneMgr", "operation = " + bArr[4] + "——————Find phone start");
                    m4262b();
                    return;
                case (byte) 2:
                    C2538c.m12677c("HWFindPhoneMgr", "operation = " + bArr[4] + "——————Find phone stop");
                    m4264c();
                    return;
                default:
                    return;
            }
        }
    }

    private void m4262b() {
        this.f1974d = (AudioManager) this.f1972a.getSystemService("audio");
        if (this.f1974d != null) {
            this.f1975e = this.f1974d.getStreamMaxVolume(3);
            this.f1976f = this.f1974d.getStreamVolume(3);
        }
        m4265d();
        Message message = new Message();
        message.what = 1;
        if (this.f1977h != null) {
            this.f1977h.sendMessageDelayed(message, 10000);
        }
    }

    private void m4264c() {
        C2538c.m12677c("HWFindPhoneMgr", "===www===Stop phone lost alert");
        if (this.f1977h != null) {
            this.f1977h.removeMessages(1);
        }
        m4266e();
    }

    private void m4265d() {
        C2538c.m12677c("HWFindPhoneMgr", "startPlayRing()");
        if (this.f1973c == null) {
            if (Locale.getDefault().getLanguage().equals(PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH)) {
                this.f1973c = MediaPlayer.create(this.f1972a, c.ring_vivid);
            } else {
                this.f1973c = MediaPlayer.create(this.f1972a, c.ring_vivid_en);
            }
        }
        if (this.f1973c.isPlaying()) {
            C2538c.m12677c("HWFindPhoneMgr", "startPlayRing() isPlaying");
            return;
        }
        this.f1973c.setAudioStreamType(3);
        this.f1973c.setLooping(true);
        m4263b(this.f1975e);
        this.f1973c.start();
    }

    private void m4266e() {
        C2538c.m12677c("HWFindPhoneMgr", "stopPlayRing()");
        if (this.f1973c != null) {
            C2538c.m12677c("HWFindPhoneMgr", "===www==stopPlayRing()  mMediaPlayer");
            this.f1973c.stop();
            this.f1973c.reset();
            this.f1973c.release();
            this.f1973c = null;
        }
        m4263b(this.f1976f);
    }

    private void m4263b(int i) {
        C2538c.m12677c("HWFindPhoneMgr", "===www===setRingVolume");
        if (this.f1974d != null) {
            this.f1974d.setStreamVolume(3, i, 0);
        }
    }

    public void m4268a(int i) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(11);
        deviceCommand.setCommandID(2);
        deviceCommand.setNeedAck(false);
        String a = C0973a.m3506a(1);
        String a2 = C0973a.m3506a(1);
        a = a + a2 + C0973a.m3506a(i);
        deviceCommand.setDataContent(C0973a.m3512b(a));
        deviceCommand.setDataLen(C0973a.m3512b(a).length);
        C1023c.m3920a(this.f1972a).m3995b(deviceCommand);
    }
}

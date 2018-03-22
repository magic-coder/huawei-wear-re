package com.google.zxing.client.android;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;

/* compiled from: BeepManager */
public final class C3782b {
    private static final String f14718a = C3782b.class.getSimpleName();
    private final Activity f14719b;
    private MediaPlayer f14720c;
    private boolean f14721d;
    private boolean f14722e;
    private C3817n f14723f = null;

    public C3782b(Activity activity) {
        this.f14719b = activity;
        this.f14720c = null;
        this.f14723f = new C3817n(activity);
        m19008a();
    }

    public void m19008a() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f14719b);
        this.f14721d = m19007a(defaultSharedPreferences, this.f14719b);
        this.f14722e = defaultSharedPreferences.getBoolean("preferences_vibrate", false);
        if (this.f14721d && this.f14720c == null) {
            this.f14719b.setVolumeControlStream(3);
            this.f14720c = m19006a(this.f14719b);
        }
    }

    public void m19009b() {
        if (this.f14721d && this.f14720c != null) {
            this.f14720c.start();
        }
        if (this.f14722e) {
            ((Vibrator) this.f14719b.getSystemService("vibrator")).vibrate(200);
        }
    }

    private boolean m19007a(SharedPreferences sharedPreferences, Context context) {
        boolean z = sharedPreferences.getBoolean("preferences_play_beep", true);
        if (!z || ((AudioManager) context.getSystemService("audio")).getRingerMode() == 2) {
            return z;
        }
        return false;
    }

    private MediaPlayer m19006a(Context context) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener(new C3789c(this));
        try {
            AssetFileDescriptor openRawResourceFd = context.getResources().openRawResourceFd(this.f14723f.m19062d("sns_beep"));
            mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
            openRawResourceFd.close();
            mediaPlayer.setVolume(0.1f, 0.1f);
            mediaPlayer.prepare();
            return mediaPlayer;
        } catch (Throwable e) {
            Log.w(f14718a, e);
            return null;
        }
    }
}

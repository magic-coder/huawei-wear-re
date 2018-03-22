package com.huawei.pluginkidwatch.plugin.menu.utils;

import android.media.MediaPlayer;
import com.huawei.p190v.C2538c;
import java.io.IOException;

/* compiled from: MediaPlayerHelper */
public class C1898o {
    private static MediaPlayer f6219a = null;

    public static boolean m9670a(String str) {
        try {
            if (f6219a == null) {
                f6219a = new MediaPlayer();
            } else {
                if (C1898o.m9675f()) {
                    f6219a.stop();
                }
                f6219a.release();
                f6219a = null;
                f6219a = new MediaPlayer();
            }
            f6219a.setDataSource(str);
            return true;
        } catch (IllegalArgumentException e) {
            C2538c.m12680e("MediaPlayerHelper", "Exception e = " + e.getMessage());
            return false;
        } catch (SecurityException e2) {
            C2538c.m12680e("MediaPlayerHelper", "Exception e = " + e2.getMessage());
            return false;
        } catch (IllegalStateException e3) {
            C2538c.m12680e("MediaPlayerHelper", "Exception e = " + e3.getMessage());
            return false;
        } catch (IOException e4) {
            C2538c.m12680e("MediaPlayerHelper", "Exception e = " + e4.getMessage());
            return false;
        }
    }

    private static boolean m9675f() {
        boolean z = false;
        if (f6219a != null) {
            try {
                z = f6219a.isPlaying();
            } catch (IllegalStateException e) {
                f6219a = null;
                f6219a = new MediaPlayer();
            }
        }
        return z;
    }

    public static void m9669a(Runnable runnable, Runnable runnable2) {
        try {
            if (f6219a != null) {
                f6219a.prepareAsync();
                f6219a.setOnPreparedListener(new C1899p(runnable));
                f6219a.setOnCompletionListener(new C1900q(runnable2));
            }
        } catch (IllegalStateException e) {
            C2538c.m12680e("MediaPlayerHelper", "Exception e = " + e.getMessage());
        }
    }

    public static void m9668a() {
        if (f6219a != null && C1898o.m9675f()) {
            f6219a.pause();
            f6219a.seekTo(0);
            f6219a.stop();
        }
    }

    public static void m9671b() {
        if (f6219a != null) {
            f6219a.reset();
        }
    }

    public static int m9672c() {
        if (f6219a != null) {
            return f6219a.getDuration();
        }
        return 0;
    }

    public static int m9673d() {
        if (f6219a != null) {
            return f6219a.getCurrentPosition();
        }
        return 0;
    }
}

package com.huawei.nfc.carrera.util;

import android.content.Context;
import android.media.AudioAttributes;
import android.os.Vibrator;

public final class VibratorUtil {

    public interface VibratorUtilSAI1 {
    }

    public interface VibratorUtilSAI2 {
    }

    public interface VibratorUtilSAI3 {
    }

    public interface VibratorUtilSAI4 {
    }

    public interface VibratorUtilSAI5 {
    }

    private VibratorUtil() {
    }

    public static void vibrate(Context context, long j) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator == null) {
            LogX.i("VibratorUtil", "vibrate. vib is null.");
        } else {
            vibrator.vibrate(j);
        }
    }

    public static void vibrate(Context context, long j, AudioAttributes audioAttributes) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator == null) {
            LogX.i("VibratorUtil", "vibrate. vib is null.");
        } else {
            vibrator.vibrate(j, audioAttributes);
        }
    }

    public static void vibrateRange(Context context, long j) {
        long j2 = 0;
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator == null) {
            LogX.i("VibratorUtil", "vibrateRange. vib is null.");
            return;
        }
        long j3 = (j - (60 + (j / 2))) - 50;
        if (j3 >= 0) {
            j2 = j3;
        }
        vibrator.vibrate(new long[]{r6, 50, j2}, -1);
    }

    public static void cancel(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator == null) {
            LogX.i("VibratorUtil", "vibrate. vib is null.");
        } else {
            vibrator.cancel();
        }
    }
}

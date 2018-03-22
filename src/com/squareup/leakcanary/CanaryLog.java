package com.squareup.leakcanary;

import android.util.Log;

public final class CanaryLog {
    private static volatile Logger logger = new DefaultLogger();

    public interface Logger {
        void mo2784d(String str, Object... objArr);

        void mo2785d(Throwable th, String str, Object... objArr);
    }

    class DefaultLogger implements Logger {
        DefaultLogger() {
        }

        public void mo2784d(String str, Object... objArr) {
            String format = String.format(str, objArr);
            if (format.length() < 4000) {
                Log.d("LeakCanary", format);
                return;
            }
            for (String d : format.split("\n")) {
                Log.d("LeakCanary", d);
            }
        }

        public void mo2785d(Throwable th, String str, Object... objArr) {
            mo2784d(String.format(str, objArr) + '\n' + Log.getStackTraceString(th), new Object[0]);
        }
    }

    public static void setLogger(Logger logger) {
        logger = logger;
    }

    public static void m12769d(String str, Object... objArr) {
        Logger logger = logger;
        if (logger != null) {
            logger.mo2784d(str, objArr);
        }
    }

    public static void m12770d(Throwable th, String str, Object... objArr) {
        Logger logger = logger;
        if (logger != null) {
            logger.mo2785d(th, str, objArr);
        }
    }

    private CanaryLog() {
        throw new AssertionError();
    }
}

package com.huawei.hms.support.log;

import android.os.Process;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: LogRecord */
public class C0889d {
    private String f1425a = null;
    private String f1426b = "HMS";
    private int f1427c = 0;
    private long f1428d = 0;
    private long f1429e = 0;
    private String f1430f;
    private int f1431g;
    private int f1432h;
    private int f1433i = 0;
    private final StringBuilder f1434j = new StringBuilder();

    C0889d(int i, String str, int i2, String str2) {
        this.f1433i = i;
        this.f1425a = str;
        this.f1427c = i2;
        if (str2 != null) {
            this.f1426b = str2;
        }
        m3108c();
    }

    private C0889d m3108c() {
        this.f1428d = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();
        this.f1429e = currentThread.getId();
        this.f1431g = Process.myPid();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        if (stackTrace.length > this.f1433i) {
            StackTraceElement stackTraceElement = stackTrace[this.f1433i];
            this.f1430f = stackTraceElement.getFileName();
            this.f1432h = stackTraceElement.getLineNumber();
        }
        return this;
    }

    public <T> C0889d m3109a(T t) {
        this.f1434j.append(t);
        return this;
    }

    public C0889d m3110a(Throwable th) {
        m3109a(Character.valueOf('\n')).m3109a(Log.getStackTraceString(th));
        return this;
    }

    public String m3111a() {
        StringBuilder stringBuilder = new StringBuilder();
        m3106a(stringBuilder);
        return stringBuilder.toString();
    }

    private StringBuilder m3106a(StringBuilder stringBuilder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        stringBuilder.append('[');
        stringBuilder.append(simpleDateFormat.format(Long.valueOf(this.f1428d)));
        stringBuilder.append(' ').append(C0889d.m3105a(this.f1427c)).append('/').append(this.f1426b).append('/').append(this.f1425a);
        stringBuilder.append(' ').append(this.f1431g).append(':').append(this.f1429e);
        stringBuilder.append(' ').append(this.f1430f).append(':').append(this.f1432h);
        stringBuilder.append(']');
        return stringBuilder;
    }

    public static String m3105a(int i) {
        switch (i) {
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            default:
                return String.valueOf(i);
        }
    }

    public String m3112b() {
        StringBuilder stringBuilder = new StringBuilder();
        m3107b(stringBuilder);
        return stringBuilder.toString();
    }

    private StringBuilder m3107b(StringBuilder stringBuilder) {
        stringBuilder.append(' ').append(this.f1434j.toString());
        return stringBuilder;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        m3106a(stringBuilder);
        m3107b(stringBuilder);
        return stringBuilder.toString();
    }
}

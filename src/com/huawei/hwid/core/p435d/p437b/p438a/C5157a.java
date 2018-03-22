package com.huawei.hwid.core.p435d.p437b.p438a;

import android.os.Process;
import android.util.Log;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: Record */
public class C5157a {
    private final SimpleDateFormat f18597a;
    private final long f18598b;
    private final long f18599c;
    private final long f18600d;
    private final int f18601e;
    private final String f18602f;
    private final String f18603g;
    private final int f18604h;
    private final String f18605i;
    private final String f18606j;

    /* compiled from: Record */
    public class C5156a {
        private final long f18588a;
        private final long f18589b;
        private final long f18590c;
        private final int f18591d;
        private final String f18592e;
        private String f18593f;
        private int f18594g;
        private String f18595h;
        private String f18596i;

        private C5156a(int i, String str) {
            this.f18588a = System.currentTimeMillis();
            this.f18589b = (long) Process.myPid();
            this.f18590c = (long) Process.myTid();
            this.f18591d = i;
            this.f18592e = str;
        }

        public C5157a m24864a() {
            return new C5157a();
        }

        public C5156a m24862a(String str) {
            this.f18595h = str;
            return this;
        }

        public C5156a m24863a(Throwable th) {
            StackTraceElement stackTraceElement;
            if (th != null) {
                this.f18596i = Log.getStackTraceString(th);
                stackTraceElement = th.getStackTrace()[0];
            } else {
                StackTraceElement[] stackTrace = new IllegalArgumentException().getStackTrace();
                if (stackTrace.length > 2) {
                    stackTraceElement = stackTrace[2];
                } else {
                    stackTraceElement = null;
                }
            }
            if (stackTraceElement != null) {
                this.f18593f = stackTraceElement.getFileName();
                this.f18594g = stackTraceElement.getLineNumber();
            }
            return this;
        }
    }

    private C5157a(C5156a c5156a) {
        this.f18597a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        this.f18598b = c5156a.f18588a;
        this.f18599c = c5156a.f18589b;
        this.f18600d = c5156a.f18590c;
        this.f18601e = c5156a.f18591d;
        this.f18602f = c5156a.f18592e;
        this.f18603g = c5156a.f18593f;
        this.f18604h = c5156a.f18594g;
        this.f18605i = c5156a.f18595h;
        this.f18606j = c5156a.f18596i;
    }

    public void m24867a(StringBuilder stringBuilder) {
        stringBuilder.append("[");
        stringBuilder.append(this.f18597a.format(Long.valueOf(this.f18598b)));
        stringBuilder.append(HwAccountConstants.BLANK);
        stringBuilder.append(C5157a.m24865a(this.f18601e)).append("/").append(this.f18602f);
        stringBuilder.append(HwAccountConstants.BLANK);
        stringBuilder.append(this.f18599c).append(":").append(this.f18600d);
        stringBuilder.append(HwAccountConstants.BLANK);
        stringBuilder.append(this.f18603g).append(":").append(this.f18604h);
        stringBuilder.append("]");
    }

    public void m24868b(StringBuilder stringBuilder) {
        stringBuilder.append(this.f18605i);
    }

    public void m24869c(StringBuilder stringBuilder) {
        if (this.f18606j != null) {
            stringBuilder.append('\n').append(this.f18606j);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        m24867a(stringBuilder);
        stringBuilder.append(HwAccountConstants.BLANK);
        m24868b(stringBuilder);
        m24869c(stringBuilder);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    private static char m24865a(int i) {
        switch (i) {
            case 3:
                return 'D';
            case 4:
                return 'I';
            case 5:
                return 'W';
            case 6:
                return 'E';
            case 7:
                return 'A';
            default:
                return 'V';
        }
    }

    public static C5156a m24866a(int i, String str) {
        return new C5156a(i, str);
    }
}

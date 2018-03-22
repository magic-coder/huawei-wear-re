package com.cmb.pboc.context;

import android.content.Context;
import com.cmb.pboc.logger.PbocLog;

public class ContextHolder {
    private static String f13374a = ContextHolder.class.getSimpleName();
    private static volatile ContextHolder f13375b;
    private Context f13376c;

    private ContextHolder() {
        PbocLog.m17738a(f13374a, "Build ContextHolder.");
    }

    public static ContextHolder m17714a() {
        PbocLog.m17738a(f13374a, "Get ContextHolder instance");
        if (f13375b == null) {
            synchronized (ContextHolder.class) {
                if (f13375b == null) {
                    f13375b = new ContextHolder();
                }
            }
        }
        return f13375b;
    }

    public final void m17715a(Context context) {
        if (context == null) {
            PbocLog.m17741d(f13374a, "Input context obj is null.");
            return;
        }
        this.f13376c = context;
        PbocLog.m17738a(f13374a, "Input context obj has be set.");
    }

    public final Context m17716b() {
        if (this.f13376c == null) {
            PbocLog.m17741d(f13374a, "Context obj isn't ok!");
        }
        return this.f13376c;
    }
}

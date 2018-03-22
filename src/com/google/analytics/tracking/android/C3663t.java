package com.google.analytics.tracking.android;

import android.content.Context;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

/* compiled from: ExceptionReporter */
public class C3663t implements UncaughtExceptionHandler {
    private final UncaughtExceptionHandler f14195a;
    private final bh f14196b;
    private final bd f14197c;
    private C3651s f14198d;

    public C3663t(bh bhVar, bd bdVar, UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        if (bhVar == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (bdVar == null) {
            throw new NullPointerException("serviceManager cannot be null");
        } else {
            this.f14195a = uncaughtExceptionHandler;
            this.f14196b = bhVar;
            this.f14197c = bdVar;
            this.f14198d = new bg(context, new ArrayList());
            ar.m18268c("ExceptionReporter created, original handler is " + (uncaughtExceptionHandler == null ? "null" : uncaughtExceptionHandler.getClass().getName()));
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str = "UncaughtException";
        if (this.f14198d != null) {
            str = this.f14198d.mo4253a(thread != null ? thread.getName() : null, th);
        }
        ar.m18268c("Tracking Exception: " + str);
        this.f14196b.m18338a(au.m18276a(str, Boolean.valueOf(true)).m18280a());
        this.f14197c.c();
        if (this.f14195a != null) {
            ar.m18268c("Passing exception to original handler.");
            this.f14195a.uncaughtException(thread, th);
        }
    }
}

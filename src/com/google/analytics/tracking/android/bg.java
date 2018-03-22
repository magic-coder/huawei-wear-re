package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* compiled from: StandardExceptionParser */
public class bg implements C3651s {
    private final TreeSet<String> f14169a = new TreeSet();

    public bg(Context context, Collection<String> collection) {
        m18335a(context, (Collection) collection);
    }

    public void m18335a(Context context, Collection<String> collection) {
        this.f14169a.clear();
        Set<String> hashSet = new HashSet();
        if (collection != null) {
            hashSet.addAll(collection);
        }
        if (context != null) {
            try {
                String packageName = context.getApplicationContext().getPackageName();
                this.f14169a.add(packageName);
                ActivityInfo[] activityInfoArr = context.getApplicationContext().getPackageManager().getPackageInfo(packageName, 15).activities;
                if (activityInfoArr != null) {
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        hashSet.add(activityInfo.packageName);
                    }
                }
            } catch (NameNotFoundException e) {
                ar.m18267b("No package found");
            }
        }
        for (String packageName2 : hashSet) {
            Iterator it = this.f14169a.iterator();
            Object obj = 1;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (packageName2.startsWith(str)) {
                    obj = null;
                } else {
                    if (str.startsWith(packageName2)) {
                        this.f14169a.remove(str);
                    }
                    if (obj != null) {
                        this.f14169a.add(packageName2);
                    }
                }
            }
            if (obj != null) {
                this.f14169a.add(packageName2);
            }
        }
    }

    protected Throwable m18334a(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    protected StackTraceElement m18336b(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Iterator it = this.f14169a.iterator();
            while (it.hasNext()) {
                if (className.startsWith((String) it.next())) {
                    return stackTraceElement;
                }
            }
        }
        return stackTrace[0];
    }

    protected String m18333a(Throwable th, StackTraceElement stackTraceElement, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(th.getClass().getSimpleName());
        if (stackTraceElement != null) {
            String[] split = stackTraceElement.getClassName().split("\\.");
            String str2 = "unknown";
            if (split != null && split.length > 0) {
                str2 = split[split.length - 1];
            }
            stringBuilder.append(String.format(" (@%s:%s:%s)", new Object[]{str2, stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())}));
        }
        if (str != null) {
            stringBuilder.append(String.format(" {%s}", new Object[]{str}));
        }
        return stringBuilder.toString();
    }

    public String mo4253a(String str, Throwable th) {
        return m18333a(m18334a(th), m18336b(m18334a(th)), str);
    }
}

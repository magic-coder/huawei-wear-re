package org.apache.log4j.spi;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.reflect.Method;
import org.apache.log4j.helpers.LogLog;

public class LocationInfo implements Serializable {
    public static final String NA = "?";
    public static final LocationInfo NA_LOCATION_INFO = new LocationInfo(NA, NA, NA, NA);
    static Class class$java$lang$Throwable = null;
    private static Method getClassNameMethod = null;
    private static Method getFileNameMethod = null;
    private static Method getLineNumberMethod = null;
    private static Method getMethodNameMethod = null;
    private static Method getStackTraceMethod = null;
    static boolean inVisualAge = false;
    private static PrintWriter pw = new PrintWriter(sw);
    static final long serialVersionUID = -1325822038990805636L;
    private static StringWriter sw = new StringWriter();
    transient String className;
    transient String fileName;
    public String fullInfo;
    transient String lineNumber;
    transient String methodName;

    static {
        boolean z = false;
        inVisualAge = false;
        try {
            if (Class.forName("com.ibm.uvm.tools.DebugSupport") != null) {
                z = true;
            }
            inVisualAge = z;
            LogLog.debug("Detected IBM VisualAge environment.");
        } catch (Throwable th) {
        }
        try {
            Class class$;
            if (class$java$lang$Throwable == null) {
                class$ = class$("java.lang.Throwable");
                class$java$lang$Throwable = class$;
            } else {
                class$ = class$java$lang$Throwable;
            }
            getStackTraceMethod = class$.getMethod("getStackTrace", null);
            class$ = Class.forName("java.lang.StackTraceElement");
            getClassNameMethod = class$.getMethod("getClassName", null);
            getMethodNameMethod = class$.getMethod("getMethodName", null);
            getFileNameMethod = class$.getMethod("getFileName", null);
            getLineNumberMethod = class$.getMethod("getLineNumber", null);
        } catch (ClassNotFoundException e) {
            LogLog.debug("LocationInfo will use pre-JDK 1.4 methods to determine location.");
        } catch (NoSuchMethodException e2) {
            LogLog.debug("LocationInfo will use pre-JDK 1.4 methods to determine location.");
        }
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LocationInfo(java.lang.Throwable r8, java.lang.String r9) {
        /*
        r7 = this;
        r6 = -1;
        r7.<init>();
        if (r8 == 0) goto L_0x0008;
    L_0x0006:
        if (r9 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = getLineNumberMethod;
        if (r0 == 0) goto L_0x00a7;
    L_0x000d:
        r4 = 0;
        r0 = getStackTraceMethod;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r0 = r0.invoke(r8, r4);	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r0 = (java.lang.Object[]) r0;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r0 = (java.lang.Object[]) r0;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r2 = "?";
        r1 = r0.length;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = r1 + -1;
        r3 = r2;
        r2 = r1;
    L_0x001f:
        if (r2 < 0) goto L_0x0008;
    L_0x0021:
        r1 = getClassNameMethod;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r5 = r0[r2];	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = r1.invoke(r5, r4);	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = (java.lang.String) r1;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r5 = r9.equals(r1);	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        if (r5 == 0) goto L_0x0147;
    L_0x0031:
        r2 = r2 + 1;
        r1 = r0.length;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        if (r2 >= r1) goto L_0x0008;
    L_0x0036:
        r7.className = r3;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = getMethodNameMethod;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r3 = r0[r2];	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = r1.invoke(r3, r4);	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = (java.lang.String) r1;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r7.methodName = r1;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = getFileNameMethod;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r3 = r0[r2];	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = r1.invoke(r3, r4);	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = (java.lang.String) r1;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r7.fileName = r1;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = r7.fileName;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        if (r1 != 0) goto L_0x0058;
    L_0x0054:
        r1 = "?";
        r7.fileName = r1;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
    L_0x0058:
        r1 = getLineNumberMethod;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r0 = r0[r2];	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r0 = r1.invoke(r0, r4);	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r0 = (java.lang.Integer) r0;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r0 = r0.intValue();	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        if (r0 >= 0) goto L_0x0120;
    L_0x0068:
        r0 = "?";
        r7.lineNumber = r0;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
    L_0x006c:
        r0 = new java.lang.StringBuffer;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r0.<init>();	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = r7.className;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r0.append(r1);	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = ".";
        r0.append(r1);	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = r7.methodName;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r0.append(r1);	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = "(";
        r0.append(r1);	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = r7.fileName;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r0.append(r1);	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = ":";
        r0.append(r1);	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = r7.lineNumber;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r0.append(r1);	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r1 = ")";
        r0.append(r1);	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r0 = r0.toString();	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r7.fullInfo = r0;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        goto L_0x0008;
    L_0x00a1:
        r0 = move-exception;
        r1 = "LocationInfo failed using JDK 1.4 methods";
        org.apache.log4j.helpers.LogLog.debug(r1, r0);
    L_0x00a7:
        r1 = sw;
        monitor-enter(r1);
        r0 = pw;	 Catch:{ all -> 0x0154 }
        r8.printStackTrace(r0);	 Catch:{ all -> 0x0154 }
        r0 = sw;	 Catch:{ all -> 0x0154 }
        r2 = r0.toString();	 Catch:{ all -> 0x0154 }
        r0 = sw;	 Catch:{ all -> 0x0154 }
        r0 = r0.getBuffer();	 Catch:{ all -> 0x0154 }
        r3 = 0;
        r0.setLength(r3);	 Catch:{ all -> 0x0154 }
        monitor-exit(r1);	 Catch:{ all -> 0x0154 }
        r1 = r2.lastIndexOf(r9);
        if (r1 == r6) goto L_0x0008;
    L_0x00c6:
        r0 = r9.length();
        r0 = r0 + r1;
        r3 = r2.length();
        if (r0 >= r3) goto L_0x0157;
    L_0x00d1:
        r0 = r9.length();
        r0 = r0 + r1;
        r0 = r2.charAt(r0);
        r3 = 46;
        if (r0 == r3) goto L_0x0157;
    L_0x00de:
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r0 = r0.append(r9);
        r3 = ".";
        r0 = r0.append(r3);
        r0 = r0.toString();
        r0 = r2.lastIndexOf(r0);
        if (r0 == r6) goto L_0x0157;
    L_0x00f7:
        r1 = org.apache.log4j.Layout.LINE_SEP;
        r0 = r2.indexOf(r1, r0);
        if (r0 == r6) goto L_0x0008;
    L_0x00ff:
        r1 = org.apache.log4j.Layout.LINE_SEP_LEN;
        r0 = r0 + r1;
        r1 = org.apache.log4j.Layout.LINE_SEP;
        r1 = r2.indexOf(r1, r0);
        if (r1 == r6) goto L_0x0008;
    L_0x010a:
        r3 = inVisualAge;
        if (r3 != 0) goto L_0x0118;
    L_0x010e:
        r0 = "at ";
        r0 = r2.lastIndexOf(r0, r1);
        if (r0 == r6) goto L_0x0008;
    L_0x0116:
        r0 = r0 + 3;
    L_0x0118:
        r0 = r2.substring(r0, r1);
        r7.fullInfo = r0;
        goto L_0x0008;
    L_0x0120:
        r0 = java.lang.String.valueOf(r0);	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        r7.lineNumber = r0;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0128, RuntimeException -> 0x014c }
        goto L_0x006c;
    L_0x0128:
        r0 = move-exception;
        r1 = r0.getTargetException();
        r1 = r1 instanceof java.lang.InterruptedException;
        if (r1 != 0) goto L_0x0139;
    L_0x0131:
        r1 = r0.getTargetException();
        r1 = r1 instanceof java.io.InterruptedIOException;
        if (r1 == 0) goto L_0x0140;
    L_0x0139:
        r1 = java.lang.Thread.currentThread();
        r1.interrupt();
    L_0x0140:
        r1 = "LocationInfo failed using JDK 1.4 methods";
        org.apache.log4j.helpers.LogLog.debug(r1, r0);
        goto L_0x00a7;
    L_0x0147:
        r2 = r2 + -1;
        r3 = r1;
        goto L_0x001f;
    L_0x014c:
        r0 = move-exception;
        r1 = "LocationInfo failed using JDK 1.4 methods";
        org.apache.log4j.helpers.LogLog.debug(r1, r0);
        goto L_0x00a7;
    L_0x0154:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0154 }
        throw r0;
    L_0x0157:
        r0 = r1;
        goto L_0x00f7;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.log4j.spi.LocationInfo.<init>(java.lang.Throwable, java.lang.String):void");
    }

    private static final void appendFragment(StringBuffer stringBuffer, String str) {
        if (str == null) {
            stringBuffer.append(NA);
        } else {
            stringBuffer.append(str);
        }
    }

    public LocationInfo(String str, String str2, String str3, String str4) {
        this.fileName = str;
        this.className = str2;
        this.methodName = str3;
        this.lineNumber = str4;
        StringBuffer stringBuffer = new StringBuffer();
        appendFragment(stringBuffer, str2);
        stringBuffer.append(".");
        appendFragment(stringBuffer, str3);
        stringBuffer.append("(");
        appendFragment(stringBuffer, str);
        stringBuffer.append(":");
        appendFragment(stringBuffer, str4);
        stringBuffer.append(")");
        this.fullInfo = stringBuffer.toString();
    }

    public String getClassName() {
        if (this.fullInfo == null) {
            return NA;
        }
        if (this.className == null) {
            int lastIndexOf = this.fullInfo.lastIndexOf(40);
            if (lastIndexOf == -1) {
                this.className = NA;
            } else {
                int lastIndexOf2 = this.fullInfo.lastIndexOf(46, lastIndexOf);
                lastIndexOf = 0;
                if (inVisualAge) {
                    lastIndexOf = this.fullInfo.lastIndexOf(32, lastIndexOf2) + 1;
                }
                if (lastIndexOf2 == -1) {
                    this.className = NA;
                } else {
                    this.className = this.fullInfo.substring(lastIndexOf, lastIndexOf2);
                }
            }
        }
        return this.className;
    }

    public String getFileName() {
        if (this.fullInfo == null) {
            return NA;
        }
        if (this.fileName == null) {
            int lastIndexOf = this.fullInfo.lastIndexOf(58);
            if (lastIndexOf == -1) {
                this.fileName = NA;
            } else {
                this.fileName = this.fullInfo.substring(this.fullInfo.lastIndexOf(40, lastIndexOf - 1) + 1, lastIndexOf);
            }
        }
        return this.fileName;
    }

    public String getLineNumber() {
        if (this.fullInfo == null) {
            return NA;
        }
        if (this.lineNumber == null) {
            int lastIndexOf = this.fullInfo.lastIndexOf(41);
            int lastIndexOf2 = this.fullInfo.lastIndexOf(58, lastIndexOf - 1);
            if (lastIndexOf2 == -1) {
                this.lineNumber = NA;
            } else {
                this.lineNumber = this.fullInfo.substring(lastIndexOf2 + 1, lastIndexOf);
            }
        }
        return this.lineNumber;
    }

    public String getMethodName() {
        if (this.fullInfo == null) {
            return NA;
        }
        if (this.methodName == null) {
            int lastIndexOf = this.fullInfo.lastIndexOf(40);
            int lastIndexOf2 = this.fullInfo.lastIndexOf(46, lastIndexOf);
            if (lastIndexOf2 == -1) {
                this.methodName = NA;
            } else {
                this.methodName = this.fullInfo.substring(lastIndexOf2 + 1, lastIndexOf);
            }
        }
        return this.methodName;
    }
}

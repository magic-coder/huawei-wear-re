package org.apache.log4j;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.CodeSource;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.spi.ThrowableRenderer;

public final class EnhancedThrowableRenderer implements ThrowableRenderer {
    static Class class$java$lang$Throwable;
    private Method getClassNameMethod;
    private Method getStackTraceMethod;

    public EnhancedThrowableRenderer() {
        try {
            Class class$;
            if (class$java$lang$Throwable == null) {
                class$ = class$("java.lang.Throwable");
                class$java$lang$Throwable = class$;
            } else {
                class$ = class$java$lang$Throwable;
            }
            this.getStackTraceMethod = class$.getMethod("getStackTrace", null);
            this.getClassNameMethod = Class.forName("java.lang.StackTraceElement").getMethod("getClassName", null);
        } catch (Exception e) {
        }
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public String[] doRender(Throwable th) {
        if (this.getStackTraceMethod != null) {
            try {
                Object[] objArr = (Object[]) this.getStackTraceMethod.invoke(th, null);
                String[] strArr = new String[(objArr.length + 1)];
                strArr[0] = th.toString();
                Map hashMap = new HashMap();
                for (int i = 0; i < objArr.length; i++) {
                    strArr[i + 1] = formatElement(objArr[i], hashMap);
                }
                return strArr;
            } catch (Exception e) {
            }
        }
        return DefaultThrowableRenderer.render(th);
    }

    private String formatElement(Object obj, Map map) {
        StringBuffer stringBuffer = new StringBuffer("\tat ");
        stringBuffer.append(obj);
        try {
            String obj2 = this.getClassNameMethod.invoke(obj, (Object[]) null).toString();
            Object obj3 = map.get(obj2);
            if (obj3 != null) {
                stringBuffer.append(obj3);
            } else {
                Class findClass = findClass(obj2);
                int length = stringBuffer.length();
                stringBuffer.append('[');
                try {
                    CodeSource codeSource = findClass.getProtectionDomain().getCodeSource();
                    if (codeSource != null) {
                        URL location = codeSource.getLocation();
                        if (location != null) {
                            if ("file".equals(location.getProtocol())) {
                                String path = location.getPath();
                                if (path != null) {
                                    int lastIndexOf = path.lastIndexOf(47);
                                    int lastIndexOf2 = path.lastIndexOf(File.separatorChar);
                                    if (lastIndexOf2 <= lastIndexOf) {
                                        lastIndexOf2 = lastIndexOf;
                                    }
                                    if (lastIndexOf2 <= 0 || lastIndexOf2 == path.length() - 1) {
                                        stringBuffer.append(location);
                                    } else {
                                        stringBuffer.append(path.substring(lastIndexOf2 + 1));
                                    }
                                }
                            } else {
                                stringBuffer.append(location);
                            }
                        }
                    }
                } catch (SecurityException e) {
                }
                stringBuffer.append(':');
                Package packageR = findClass.getPackage();
                if (packageR != null) {
                    String implementationVersion = packageR.getImplementationVersion();
                    if (implementationVersion != null) {
                        stringBuffer.append(implementationVersion);
                    }
                }
                stringBuffer.append(']');
                map.put(obj2, stringBuffer.substring(length));
            }
        } catch (Exception e2) {
        }
        return stringBuffer.toString();
    }

    private Class findClass(String str) throws ClassNotFoundException {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(str);
        } catch (ClassNotFoundException e) {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e2) {
                return getClass().getClassLoader().loadClass(str);
            }
        }
    }
}

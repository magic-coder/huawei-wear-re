package org.apache.log4j.helpers;

import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

public class Loader {
    static final String TSTR = "Caught Exception while in Loader.getResource. This may be innocuous.";
    static Class class$java$lang$Thread;
    static Class class$org$apache$log4j$helpers$Loader;
    private static boolean ignoreTCL;
    private static boolean java1;

    static {
        java1 = true;
        ignoreTCL = false;
        String systemProperty = OptionConverter.getSystemProperty("java.version", null);
        if (systemProperty != null) {
            int indexOf = systemProperty.indexOf(46);
            if (!(indexOf == -1 || systemProperty.charAt(indexOf + 1) == '1')) {
                java1 = false;
            }
        }
        systemProperty = OptionConverter.getSystemProperty("log4j.ignoreTCL", null);
        if (systemProperty != null) {
            ignoreTCL = OptionConverter.toBoolean(systemProperty, true);
        }
    }

    public static URL getResource(String str, Class cls) {
        return getResource(str);
    }

    public static URL getResource(String str) {
        try {
            ClassLoader tcl;
            URL resource;
            Class class$;
            if (!(java1 || ignoreTCL)) {
                tcl = getTCL();
                if (tcl != null) {
                    LogLog.debug(new StringBuffer().append("Trying to find [").append(str).append("] using context classloader ").append(tcl).append(".").toString());
                    resource = tcl.getResource(str);
                    if (resource != null) {
                        return resource;
                    }
                }
            }
            if (class$org$apache$log4j$helpers$Loader == null) {
                class$ = class$("org.apache.log4j.helpers.Loader");
                class$org$apache$log4j$helpers$Loader = class$;
            } else {
                class$ = class$org$apache$log4j$helpers$Loader;
            }
            tcl = class$.getClassLoader();
            if (tcl != null) {
                LogLog.debug(new StringBuffer().append("Trying to find [").append(str).append("] using ").append(tcl).append(" class loader.").toString());
                resource = tcl.getResource(str);
                if (resource != null) {
                    return resource;
                }
            }
        } catch (Throwable e) {
            LogLog.warn(TSTR, e);
        } catch (Throwable e2) {
            if ((e2.getTargetException() instanceof InterruptedException) || (e2.getTargetException() instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            LogLog.warn(TSTR, e2);
        } catch (Throwable e22) {
            LogLog.warn(TSTR, e22);
        }
        LogLog.debug(new StringBuffer().append("Trying to find [").append(str).append("] using ClassLoader.getSystemResource().").toString());
        return ClassLoader.getSystemResource(str);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static boolean isJava1() {
        return java1;
    }

    private static ClassLoader getTCL() throws IllegalAccessException, InvocationTargetException {
        try {
            Class class$;
            if (class$java$lang$Thread == null) {
                class$ = class$("java.lang.Thread");
                class$java$lang$Thread = class$;
            } else {
                class$ = class$java$lang$Thread;
            }
            return (ClassLoader) class$.getMethod("getContextClassLoader", null).invoke(Thread.currentThread(), null);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static Class loadClass(String str) throws ClassNotFoundException {
        if (java1 || ignoreTCL) {
            return Class.forName(str);
        }
        try {
            return getTCL().loadClass(str);
        } catch (InvocationTargetException e) {
            if ((e.getTargetException() instanceof InterruptedException) || (e.getTargetException() instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            return Class.forName(str);
        } catch (Throwable th) {
            return Class.forName(str);
        }
    }
}

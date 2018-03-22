package org.apache.log4j.net;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.apache.log4j.helpers.LogLog;

public class ZeroConfSupport {
    static Class class$java$lang$String;
    static Class class$java$util$Hashtable;
    static Class class$java$util$Map;
    private static Object jmDNS = initializeJMDNS();
    private static Class jmDNSClass;
    private static Class serviceInfoClass;
    Object serviceInfo;

    public ZeroConfSupport(String str, int i, String str2, Map map) {
        Object obj = null;
        try {
            jmDNSClass.getMethod("create", null);
            obj = 1;
        } catch (NoSuchMethodException e) {
        }
        if (obj != null) {
            LogLog.debug("using JmDNS version 3 to construct serviceInfo instance");
            this.serviceInfo = buildServiceInfoVersion3(str, i, str2, map);
            return;
        }
        LogLog.debug("using JmDNS version 1.0 to construct serviceInfo instance");
        this.serviceInfo = buildServiceInfoVersion1(str, i, str2, map);
    }

    public ZeroConfSupport(String str, int i, String str2) {
        this(str, i, str2, new HashMap());
    }

    private static Object createJmDNSVersion1() {
        try {
            return jmDNSClass.newInstance();
        } catch (Throwable e) {
            LogLog.warn("Unable to instantiate JMDNS", e);
            return null;
        } catch (Throwable e2) {
            LogLog.warn("Unable to instantiate JMDNS", e2);
            return null;
        }
    }

    private static Object createJmDNSVersion3() {
        Object obj = null;
        try {
            obj = jmDNSClass.getMethod("create", null).invoke(null, null);
        } catch (Throwable e) {
            LogLog.warn("Unable to instantiate jmdns class", e);
        } catch (Throwable e2) {
            LogLog.warn("Unable to access constructor", e2);
        } catch (Throwable e22) {
            LogLog.warn("Unable to call constructor", e22);
        }
        return obj;
    }

    private Object buildServiceInfoVersion1(String str, int i, String str2, Map map) {
        Hashtable hashtable = new Hashtable(map);
        try {
            Class class$;
            Class[] clsArr = new Class[6];
            if (class$java$lang$String == null) {
                class$ = class$("java.lang.String");
                class$java$lang$String = class$;
            } else {
                class$ = class$java$lang$String;
            }
            clsArr[0] = class$;
            if (class$java$lang$String == null) {
                class$ = class$("java.lang.String");
                class$java$lang$String = class$;
            } else {
                class$ = class$java$lang$String;
            }
            clsArr[1] = class$;
            clsArr[2] = Integer.TYPE;
            clsArr[3] = Integer.TYPE;
            clsArr[4] = Integer.TYPE;
            if (class$java$util$Hashtable == null) {
                class$ = class$("java.util.Hashtable");
                class$java$util$Hashtable = class$;
            } else {
                class$ = class$java$util$Hashtable;
            }
            clsArr[5] = class$;
            Object newInstance = serviceInfoClass.getConstructor(clsArr).newInstance(new Object[]{str, str2, new Integer(i), new Integer(0), new Integer(0), hashtable});
            LogLog.debug(new StringBuffer().append("created serviceinfo: ").append(newInstance).toString());
            return newInstance;
        } catch (Throwable e) {
            LogLog.warn("Unable to construct ServiceInfo instance", e);
            return null;
        } catch (Throwable e2) {
            LogLog.warn("Unable to get ServiceInfo constructor", e2);
            return null;
        } catch (Throwable e22) {
            LogLog.warn("Unable to construct ServiceInfo instance", e22);
            return null;
        } catch (Throwable e222) {
            LogLog.warn("Unable to construct ServiceInfo instance", e222);
            return null;
        }
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private Object buildServiceInfoVersion3(String str, int i, String str2, Map map) {
        try {
            Class class$;
            Class[] clsArr = new Class[6];
            if (class$java$lang$String == null) {
                class$ = class$("java.lang.String");
                class$java$lang$String = class$;
            } else {
                class$ = class$java$lang$String;
            }
            clsArr[0] = class$;
            if (class$java$lang$String == null) {
                class$ = class$("java.lang.String");
                class$java$lang$String = class$;
            } else {
                class$ = class$java$lang$String;
            }
            clsArr[1] = class$;
            clsArr[2] = Integer.TYPE;
            clsArr[3] = Integer.TYPE;
            clsArr[4] = Integer.TYPE;
            if (class$java$util$Map == null) {
                class$ = class$("java.util.Map");
                class$java$util$Map = class$;
            } else {
                class$ = class$java$util$Map;
            }
            clsArr[5] = class$;
            Object invoke = serviceInfoClass.getMethod("create", clsArr).invoke(null, new Object[]{str, str2, new Integer(i), new Integer(0), new Integer(0), map});
            LogLog.debug(new StringBuffer().append("created serviceinfo: ").append(invoke).toString());
            return invoke;
        } catch (Throwable e) {
            LogLog.warn("Unable to invoke create method", e);
            return null;
        } catch (Throwable e2) {
            LogLog.warn("Unable to find create method", e2);
            return null;
        } catch (Throwable e22) {
            LogLog.warn("Unable to invoke create method", e22);
            return null;
        }
    }

    public void advertise() {
        try {
            jmDNSClass.getMethod("registerService", new Class[]{serviceInfoClass}).invoke(jmDNS, new Object[]{this.serviceInfo});
            LogLog.debug(new StringBuffer().append("registered serviceInfo: ").append(this.serviceInfo).toString());
        } catch (Throwable e) {
            LogLog.warn("Unable to invoke registerService method", e);
        } catch (Throwable e2) {
            LogLog.warn("No registerService method", e2);
        } catch (Throwable e22) {
            LogLog.warn("Unable to invoke registerService method", e22);
        }
    }

    public void unadvertise() {
        try {
            jmDNSClass.getMethod("unregisterService", new Class[]{serviceInfoClass}).invoke(jmDNS, new Object[]{this.serviceInfo});
            LogLog.debug(new StringBuffer().append("unregistered serviceInfo: ").append(this.serviceInfo).toString());
        } catch (Throwable e) {
            LogLog.warn("Unable to invoke unregisterService method", e);
        } catch (Throwable e2) {
            LogLog.warn("No unregisterService method", e2);
        } catch (Throwable e22) {
            LogLog.warn("Unable to invoke unregisterService method", e22);
        }
    }

    private static Object initializeJMDNS() {
        try {
            jmDNSClass = Class.forName("javax.jmdns.JmDNS");
            serviceInfoClass = Class.forName("javax.jmdns.ServiceInfo");
        } catch (Throwable e) {
            LogLog.warn("JmDNS or serviceInfo class not found", e);
        }
        Object obj = null;
        try {
            jmDNSClass.getMethod("create", null);
            obj = 1;
        } catch (NoSuchMethodException e2) {
        }
        if (obj != null) {
            return createJmDNSVersion3();
        }
        return createJmDNSVersion1();
    }

    public static Object getJMDNSInstance() {
        return jmDNS;
    }
}

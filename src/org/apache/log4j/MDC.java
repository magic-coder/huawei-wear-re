package org.apache.log4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.ThreadLocalMap;

public class MDC {
    static final int HT_SIZE = 7;
    static Class class$java$lang$ThreadLocal;
    static final MDC mdc = new MDC();
    boolean java1 = Loader.isJava1();
    private Method removeMethod;
    Object tlm;

    private MDC() {
        if (!this.java1) {
            this.tlm = new ThreadLocalMap();
        }
        try {
            Class class$;
            if (class$java$lang$ThreadLocal == null) {
                class$ = class$("java.lang.ThreadLocal");
                class$java$lang$ThreadLocal = class$;
            } else {
                class$ = class$java$lang$ThreadLocal;
            }
            this.removeMethod = class$.getMethod("remove", null);
        } catch (NoSuchMethodException e) {
        }
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static void put(String str, Object obj) {
        if (mdc != null) {
            mdc.put0(str, obj);
        }
    }

    public static Object get(String str) {
        if (mdc != null) {
            return mdc.get0(str);
        }
        return null;
    }

    public static void remove(String str) {
        if (mdc != null) {
            mdc.remove0(str);
        }
    }

    public static Hashtable getContext() {
        if (mdc != null) {
            return mdc.getContext0();
        }
        return null;
    }

    public static void clear() {
        if (mdc != null) {
            mdc.clear0();
        }
    }

    private void put0(String str, Object obj) {
        if (!this.java1 && this.tlm != null) {
            Hashtable hashtable = (Hashtable) ((ThreadLocalMap) this.tlm).get();
            if (hashtable == null) {
                Hashtable hashtable2 = new Hashtable(7);
                ((ThreadLocalMap) this.tlm).set(hashtable2);
                hashtable = hashtable2;
            }
            hashtable.put(str, obj);
        }
    }

    private Object get0(String str) {
        if (this.java1 || this.tlm == null) {
            return null;
        }
        Hashtable hashtable = (Hashtable) ((ThreadLocalMap) this.tlm).get();
        return (hashtable == null || str == null) ? null : hashtable.get(str);
    }

    private void remove0(String str) {
        if (!this.java1 && this.tlm != null) {
            Hashtable hashtable = (Hashtable) ((ThreadLocalMap) this.tlm).get();
            if (hashtable != null) {
                hashtable.remove(str);
                if (hashtable.isEmpty()) {
                    clear0();
                }
            }
        }
    }

    private Hashtable getContext0() {
        if (this.java1 || this.tlm == null) {
            return null;
        }
        return (Hashtable) ((ThreadLocalMap) this.tlm).get();
    }

    private void clear0() {
        if (!this.java1 && this.tlm != null) {
            Hashtable hashtable = (Hashtable) ((ThreadLocalMap) this.tlm).get();
            if (hashtable != null) {
                hashtable.clear();
            }
            if (this.removeMethod != null) {
                try {
                    this.removeMethod.invoke(this.tlm, null);
                } catch (IllegalAccessException e) {
                } catch (InvocationTargetException e2) {
                }
            }
        }
    }
}

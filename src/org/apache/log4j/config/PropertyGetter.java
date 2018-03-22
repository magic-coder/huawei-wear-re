package org.apache.log4j.config;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.log4j.helpers.LogLog;

public class PropertyGetter {
    protected static final Object[] NULL_ARG = new Object[0];
    static Class class$java$lang$String;
    static Class class$org$apache$log4j$Priority;
    protected Object obj;
    protected PropertyDescriptor[] props;

    public interface PropertyCallback {
        void foundProperty(Object obj, String str, String str2, Object obj2);
    }

    public PropertyGetter(Object obj) throws IntrospectionException {
        this.props = Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors();
        this.obj = obj;
    }

    public static void getProperties(Object obj, PropertyCallback propertyCallback, String str) {
        try {
            new PropertyGetter(obj).getProperties(propertyCallback, str);
        } catch (IntrospectionException e) {
            LogLog.error(new StringBuffer().append("Failed to introspect object ").append(obj).toString(), e);
        }
    }

    public void getProperties(PropertyCallback propertyCallback, String str) {
        for (int i = 0; i < this.props.length; i++) {
            Method readMethod = this.props[i].getReadMethod();
            if (readMethod != null && isHandledType(readMethod.getReturnType())) {
                String name = this.props[i].getName();
                try {
                    Object invoke = readMethod.invoke(this.obj, NULL_ARG);
                    if (invoke != null) {
                        propertyCallback.foundProperty(this.obj, str, name, invoke);
                    }
                } catch (IllegalAccessException e) {
                    LogLog.warn(new StringBuffer().append("Failed to get value of property ").append(name).toString());
                } catch (InvocationTargetException e2) {
                    if ((e2.getTargetException() instanceof InterruptedException) || (e2.getTargetException() instanceof InterruptedIOException)) {
                        Thread.currentThread().interrupt();
                    }
                    LogLog.warn(new StringBuffer().append("Failed to get value of property ").append(name).toString());
                } catch (RuntimeException e3) {
                    LogLog.warn(new StringBuffer().append("Failed to get value of property ").append(name).toString());
                }
            }
        }
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    protected boolean isHandledType(Class cls) {
        Class class$;
        if (class$java$lang$String == null) {
            class$ = class$("java.lang.String");
            class$java$lang$String = class$;
        } else {
            class$ = class$java$lang$String;
        }
        if (!(class$.isAssignableFrom(cls) || Integer.TYPE.isAssignableFrom(cls) || Long.TYPE.isAssignableFrom(cls) || Boolean.TYPE.isAssignableFrom(cls))) {
            if (class$org$apache$log4j$Priority == null) {
                class$ = class$("org.apache.log4j.Priority");
                class$org$apache$log4j$Priority = class$;
            } else {
                class$ = class$org$apache$log4j$Priority;
            }
            if (!class$.isAssignableFrom(cls)) {
                return false;
            }
        }
        return true;
    }
}

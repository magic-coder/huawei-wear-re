package org.apache.log4j.config;

import com.huawei.crowdtestsdk.utils.ResUtil;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Properties;
import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.OptionHandler;

public class PropertySetter {
    static Class class$java$lang$String;
    static Class class$org$apache$log4j$Priority;
    static Class class$org$apache$log4j$spi$ErrorHandler;
    static Class class$org$apache$log4j$spi$OptionHandler;
    protected Object obj;
    protected PropertyDescriptor[] props;

    public PropertySetter(Object obj) {
        this.obj = obj;
    }

    protected void introspect() {
        try {
            this.props = Introspector.getBeanInfo(this.obj.getClass()).getPropertyDescriptors();
        } catch (IntrospectionException e) {
            LogLog.error(new StringBuffer().append("Failed to introspect ").append(this.obj).append(": ").append(e.getMessage()).toString());
            this.props = new PropertyDescriptor[0];
        }
    }

    public static void setProperties(Object obj, Properties properties, String str) {
        new PropertySetter(obj).setProperties(properties, str);
    }

    public void setProperties(Properties properties, String str) {
        int length = str.length();
        Enumeration propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str2 = (String) propertyNames.nextElement();
            if (str2.startsWith(str) && str2.indexOf(46, length + 1) <= 0) {
                String findAndSubst = OptionConverter.findAndSubst(str2, properties);
                String substring = str2.substring(length);
                if ((!ResUtil.TYPE_LAYOUT.equals(substring) && !"errorhandler".equals(substring)) || !(this.obj instanceof Appender)) {
                    PropertyDescriptor propertyDescriptor = getPropertyDescriptor(Introspector.decapitalize(substring));
                    if (propertyDescriptor != null) {
                        Class class$;
                        if (class$org$apache$log4j$spi$OptionHandler == null) {
                            class$ = class$("org.apache.log4j.spi.OptionHandler");
                            class$org$apache$log4j$spi$OptionHandler = class$;
                        } else {
                            class$ = class$org$apache$log4j$spi$OptionHandler;
                        }
                        if (class$.isAssignableFrom(propertyDescriptor.getPropertyType()) && propertyDescriptor.getWriteMethod() != null) {
                            new PropertySetter((OptionHandler) OptionConverter.instantiateByKey(properties, new StringBuffer().append(str).append(substring).toString(), propertyDescriptor.getPropertyType(), null)).setProperties(properties, new StringBuffer().append(str).append(substring).append(".").toString());
                            try {
                                propertyDescriptor.getWriteMethod().invoke(this.obj, new Object[]{r0});
                            } catch (Throwable e) {
                                LogLog.warn(new StringBuffer().append("Failed to set property [").append(substring).append("] to value \"").append(findAndSubst).append("\". ").toString(), e);
                            } catch (Throwable e2) {
                                if ((e2.getTargetException() instanceof InterruptedException) || (e2.getTargetException() instanceof InterruptedIOException)) {
                                    Thread.currentThread().interrupt();
                                }
                                LogLog.warn(new StringBuffer().append("Failed to set property [").append(substring).append("] to value \"").append(findAndSubst).append("\". ").toString(), e2);
                            } catch (Throwable e22) {
                                LogLog.warn(new StringBuffer().append("Failed to set property [").append(substring).append("] to value \"").append(findAndSubst).append("\". ").toString(), e22);
                            }
                        }
                    }
                    setProperty(substring, findAndSubst);
                }
            }
        }
        activate();
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public void setProperty(String str, String str2) {
        if (str2 != null) {
            String decapitalize = Introspector.decapitalize(str);
            PropertyDescriptor propertyDescriptor = getPropertyDescriptor(decapitalize);
            if (propertyDescriptor == null) {
                LogLog.warn(new StringBuffer().append("No such property [").append(decapitalize).append("] in ").append(this.obj.getClass().getName()).append(".").toString());
                return;
            }
            try {
                setProperty(propertyDescriptor, decapitalize, str2);
            } catch (PropertySetterException e) {
                LogLog.warn(new StringBuffer().append("Failed to set property [").append(decapitalize).append("] to value \"").append(str2).append("\". ").toString(), e.rootCause);
            }
        }
    }

    public void setProperty(PropertyDescriptor propertyDescriptor, String str, String str2) throws PropertySetterException {
        Method writeMethod = propertyDescriptor.getWriteMethod();
        if (writeMethod == null) {
            throw new PropertySetterException(new StringBuffer().append("No setter for property [").append(str).append("].").toString());
        }
        Class[] parameterTypes = writeMethod.getParameterTypes();
        if (parameterTypes.length != 1) {
            throw new PropertySetterException("#params for setter != 1");
        }
        try {
            Object convertArg = convertArg(str2, parameterTypes[0]);
            if (convertArg == null) {
                throw new PropertySetterException(new StringBuffer().append("Conversion to type [").append(parameterTypes[0]).append("] failed.").toString());
            }
            LogLog.debug(new StringBuffer().append("Setting property [").append(str).append("] to [").append(convertArg).append("].").toString());
            try {
                writeMethod.invoke(this.obj, new Object[]{convertArg});
            } catch (Throwable e) {
                throw new PropertySetterException(e);
            } catch (Throwable e2) {
                if ((e2.getTargetException() instanceof InterruptedException) || (e2.getTargetException() instanceof InterruptedIOException)) {
                    Thread.currentThread().interrupt();
                }
                throw new PropertySetterException(e2);
            } catch (Throwable e22) {
                throw new PropertySetterException(e22);
            }
        } catch (Throwable e222) {
            PropertySetterException propertySetterException = new PropertySetterException(new StringBuffer().append("Conversion to type [").append(parameterTypes[0]).append("] failed. Reason: ").append(e222).toString());
        }
    }

    protected Object convertArg(String str, Class cls) {
        if (str == null) {
            return null;
        }
        Class class$;
        String trim = str.trim();
        if (class$java$lang$String == null) {
            class$ = class$("java.lang.String");
            class$java$lang$String = class$;
        } else {
            class$ = class$java$lang$String;
        }
        if (class$.isAssignableFrom(cls)) {
            return str;
        }
        if (Integer.TYPE.isAssignableFrom(cls)) {
            return new Integer(trim);
        }
        if (Long.TYPE.isAssignableFrom(cls)) {
            return new Long(trim);
        }
        if (!Boolean.TYPE.isAssignableFrom(cls)) {
            if (class$org$apache$log4j$Priority == null) {
                class$ = class$("org.apache.log4j.Priority");
                class$org$apache$log4j$Priority = class$;
            } else {
                class$ = class$org$apache$log4j$Priority;
            }
            if (class$.isAssignableFrom(cls)) {
                return OptionConverter.toLevel(trim, Level.DEBUG);
            }
            if (class$org$apache$log4j$spi$ErrorHandler == null) {
                class$ = class$("org.apache.log4j.spi.ErrorHandler");
                class$org$apache$log4j$spi$ErrorHandler = class$;
            } else {
                class$ = class$org$apache$log4j$spi$ErrorHandler;
            }
            if (class$.isAssignableFrom(cls)) {
                if (class$org$apache$log4j$spi$ErrorHandler == null) {
                    class$ = class$("org.apache.log4j.spi.ErrorHandler");
                    class$org$apache$log4j$spi$ErrorHandler = class$;
                } else {
                    class$ = class$org$apache$log4j$spi$ErrorHandler;
                }
                return OptionConverter.instantiateByClassName(trim, class$, null);
            }
        } else if ("true".equalsIgnoreCase(trim)) {
            return Boolean.TRUE;
        } else {
            if ("false".equalsIgnoreCase(trim)) {
                return Boolean.FALSE;
            }
        }
        return null;
    }

    protected PropertyDescriptor getPropertyDescriptor(String str) {
        if (this.props == null) {
            introspect();
        }
        for (int i = 0; i < this.props.length; i++) {
            if (str.equals(this.props[i].getName())) {
                return this.props[i];
            }
        }
        return null;
    }

    public void activate() {
        if (this.obj instanceof OptionHandler) {
            ((OptionHandler) this.obj).activateOptions();
        }
    }
}

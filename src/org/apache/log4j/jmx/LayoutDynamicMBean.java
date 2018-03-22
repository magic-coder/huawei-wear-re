package org.apache.log4j.jmx;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Vector;
import javax.management.Attribute;
import javax.management.AttributeNotFoundException;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.ReflectionException;
import javax.management.RuntimeOperationsException;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.OptionHandler;

public class LayoutDynamicMBean extends AbstractDynamicMBean {
    private static Logger cat;
    static Class class$java$lang$String;
    static Class class$org$apache$log4j$Level;
    static Class class$org$apache$log4j$Priority;
    static Class class$org$apache$log4j$jmx$LayoutDynamicMBean;
    private Vector dAttributes = new Vector();
    private String dClassName = getClass().getName();
    private MBeanConstructorInfo[] dConstructors = new MBeanConstructorInfo[1];
    private String dDescription = "This MBean acts as a management facade for log4j layouts.";
    private MBeanOperationInfo[] dOperations = new MBeanOperationInfo[1];
    private Hashtable dynamicProps = new Hashtable(5);
    private Layout layout;

    static {
        Class class$;
        if (class$org$apache$log4j$jmx$LayoutDynamicMBean == null) {
            class$ = class$("org.apache.log4j.jmx.LayoutDynamicMBean");
            class$org$apache$log4j$jmx$LayoutDynamicMBean = class$;
        } else {
            class$ = class$org$apache$log4j$jmx$LayoutDynamicMBean;
        }
        cat = Logger.getLogger(class$);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public LayoutDynamicMBean(Layout layout) throws IntrospectionException {
        this.layout = layout;
        buildDynamicMBeanInfo();
    }

    private void buildDynamicMBeanInfo() throws IntrospectionException {
        this.dConstructors[0] = new MBeanConstructorInfo("LayoutDynamicMBean(): Constructs a LayoutDynamicMBean instance", getClass().getConstructors()[0]);
        PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(this.layout.getClass()).getPropertyDescriptors();
        int length = propertyDescriptors.length;
        for (int i = 0; i < length; i++) {
            String name = propertyDescriptors[i].getName();
            Method readMethod = propertyDescriptors[i].getReadMethod();
            Method writeMethod = propertyDescriptors[i].getWriteMethod();
            if (readMethod != null) {
                Class returnType = readMethod.getReturnType();
                if (isSupportedType(returnType)) {
                    Class class$;
                    String str;
                    boolean z;
                    if (class$org$apache$log4j$Level == null) {
                        class$ = class$("org.apache.log4j.Level");
                        class$org$apache$log4j$Level = class$;
                    } else {
                        class$ = class$org$apache$log4j$Level;
                    }
                    if (returnType.isAssignableFrom(class$)) {
                        str = "java.lang.String";
                    } else {
                        str = returnType.getName();
                    }
                    Vector vector = this.dAttributes;
                    String str2 = "Dynamic";
                    if (writeMethod != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    vector.add(new MBeanAttributeInfo(name, str, str2, true, z, false));
                    this.dynamicProps.put(name, new MethodUnion(readMethod, writeMethod));
                }
            }
        }
        this.dOperations[0] = new MBeanOperationInfo("activateOptions", "activateOptions(): add an layout", new MBeanParameterInfo[0], "void", 1);
    }

    private boolean isSupportedType(Class cls) {
        if (cls.isPrimitive()) {
            return true;
        }
        Class class$;
        if (class$java$lang$String == null) {
            class$ = class$("java.lang.String");
            class$java$lang$String = class$;
        } else {
            class$ = class$java$lang$String;
        }
        if (cls == class$) {
            return true;
        }
        if (class$org$apache$log4j$Level == null) {
            class$ = class$("org.apache.log4j.Level");
            class$org$apache$log4j$Level = class$;
        } else {
            class$ = class$org$apache$log4j$Level;
        }
        if (cls.isAssignableFrom(class$)) {
            return true;
        }
        return false;
    }

    public MBeanInfo getMBeanInfo() {
        cat.debug("getMBeanInfo called.");
        MBeanAttributeInfo[] mBeanAttributeInfoArr = new MBeanAttributeInfo[this.dAttributes.size()];
        this.dAttributes.toArray(mBeanAttributeInfoArr);
        return new MBeanInfo(this.dClassName, this.dDescription, mBeanAttributeInfoArr, this.dConstructors, this.dOperations, new MBeanNotificationInfo[0]);
    }

    public Object invoke(String str, Object[] objArr, String[] strArr) throws MBeanException, ReflectionException {
        if (!str.equals("activateOptions") || !(this.layout instanceof OptionHandler)) {
            return null;
        }
        this.layout.activateOptions();
        return "Options activated.";
    }

    protected Logger getLogger() {
        return cat;
    }

    public Object getAttribute(String str) throws AttributeNotFoundException, MBeanException, ReflectionException {
        if (str == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("Attribute name cannot be null"), new StringBuffer().append("Cannot invoke a getter of ").append(this.dClassName).append(" with null attribute name").toString());
        }
        MethodUnion methodUnion = (MethodUnion) this.dynamicProps.get(str);
        cat.debug(new StringBuffer().append("----name=").append(str).append(", mu=").append(methodUnion).toString());
        if (methodUnion == null || methodUnion.readMethod == null) {
            throw new AttributeNotFoundException(new StringBuffer().append("Cannot find ").append(str).append(" attribute in ").append(this.dClassName).toString());
        }
        try {
            return methodUnion.readMethod.invoke(this.layout, null);
        } catch (InvocationTargetException e) {
            if ((e.getTargetException() instanceof InterruptedException) || (e.getTargetException() instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            return null;
        } catch (IllegalAccessException e2) {
            return null;
        } catch (RuntimeException e3) {
            return null;
        }
    }

    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        if (attribute == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("Attribute cannot be null"), new StringBuffer().append("Cannot invoke a setter of ").append(this.dClassName).append(" with null attribute").toString());
        }
        String name = attribute.getName();
        Object value = attribute.getValue();
        if (name == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("Attribute name cannot be null"), new StringBuffer().append("Cannot invoke the setter of ").append(this.dClassName).append(" with null attribute name").toString());
        }
        MethodUnion methodUnion = (MethodUnion) this.dynamicProps.get(name);
        if (methodUnion == null || methodUnion.writeMethod == null) {
            throw new AttributeNotFoundException(new StringBuffer().append("Attribute ").append(name).append(" not found in ").append(getClass().getName()).toString());
        }
        Class class$;
        Object[] objArr = new Object[1];
        Class cls = methodUnion.writeMethod.getParameterTypes()[0];
        if (class$org$apache$log4j$Priority == null) {
            class$ = class$("org.apache.log4j.Priority");
            class$org$apache$log4j$Priority = class$;
        } else {
            class$ = class$org$apache$log4j$Priority;
        }
        if (cls == class$) {
            value = OptionConverter.toLevel((String) value, (Level) getAttribute(name));
        }
        objArr[0] = value;
        try {
            methodUnion.writeMethod.invoke(this.layout, objArr);
        } catch (Throwable e) {
            if ((e.getTargetException() instanceof InterruptedException) || (e.getTargetException() instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            cat.error("FIXME", e);
        } catch (Throwable e2) {
            cat.error("FIXME", e2);
        } catch (Throwable e22) {
            cat.error("FIXME", e22);
        }
    }
}

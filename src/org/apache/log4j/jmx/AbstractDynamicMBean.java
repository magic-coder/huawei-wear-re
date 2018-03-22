package org.apache.log4j.jmx;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.DynamicMBean;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.JMException;
import javax.management.MBeanRegistration;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.RuntimeOperationsException;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;

public abstract class AbstractDynamicMBean implements DynamicMBean, MBeanRegistration {
    String dClassName;
    private final Vector mbeanList = new Vector();
    MBeanServer server;

    protected abstract Logger getLogger();

    protected static String getAppenderName(Appender appender) {
        String name = appender.getName();
        if (name == null || name.trim().length() == 0) {
            return appender.toString();
        }
        return name;
    }

    public AttributeList getAttributes(String[] strArr) {
        if (strArr == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("attributeNames[] cannot be null"), new StringBuffer().append("Cannot invoke a getter of ").append(this.dClassName).toString());
        }
        AttributeList attributeList = new AttributeList();
        if (strArr.length == 0) {
            return attributeList;
        }
        for (int i = 0; i < strArr.length; i++) {
            try {
                attributeList.add(new Attribute(strArr[i], getAttribute(strArr[i])));
            } catch (JMException e) {
                e.printStackTrace();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
        return attributeList;
    }

    public AttributeList setAttributes(AttributeList attributeList) {
        if (attributeList == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("AttributeList attributes cannot be null"), new StringBuffer().append("Cannot invoke a setter of ").append(this.dClassName).toString());
        }
        AttributeList attributeList2 = new AttributeList();
        if (attributeList.isEmpty()) {
            return attributeList2;
        }
        Iterator it = attributeList.iterator();
        while (it.hasNext()) {
            Attribute attribute = (Attribute) it.next();
            try {
                setAttribute(attribute);
                String name = attribute.getName();
                attributeList2.add(new Attribute(name, getAttribute(name)));
            } catch (JMException e) {
                e.printStackTrace();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
        return attributeList2;
    }

    public void postDeregister() {
        getLogger().debug("postDeregister is called.");
    }

    public void postRegister(Boolean bool) {
    }

    public ObjectName preRegister(MBeanServer mBeanServer, ObjectName objectName) {
        getLogger().debug(new StringBuffer().append("preRegister called. Server=").append(mBeanServer).append(", name=").append(objectName).toString());
        this.server = mBeanServer;
        return objectName;
    }

    protected void registerMBean(Object obj, ObjectName objectName) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        this.server.registerMBean(obj, objectName);
        this.mbeanList.add(objectName);
    }

    public void preDeregister() {
        getLogger().debug("preDeregister called.");
        Enumeration elements = this.mbeanList.elements();
        while (elements.hasMoreElements()) {
            ObjectName objectName = (ObjectName) elements.nextElement();
            try {
                this.server.unregisterMBean(objectName);
            } catch (InstanceNotFoundException e) {
                getLogger().warn(new StringBuffer().append("Missing MBean ").append(objectName.getCanonicalName()).toString());
            } catch (MBeanRegistrationException e2) {
                getLogger().warn(new StringBuffer().append("Failed unregistering ").append(objectName.getCanonicalName()).toString());
            }
        }
    }
}

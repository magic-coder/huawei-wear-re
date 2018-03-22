package org.apache.log4j.jmx;

import java.util.Vector;
import javax.management.Attribute;
import javax.management.AttributeNotFoundException;
import javax.management.InvalidAttributeValueException;
import javax.management.JMException;
import javax.management.ListenerNotFoundException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcaster;
import javax.management.NotificationBroadcasterSupport;
import javax.management.NotificationFilter;
import javax.management.NotificationFilterSupport;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.RuntimeOperationsException;
import org.apache.log4j.Appender;
import org.apache.log4j.Category;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.HierarchyEventListener;
import org.apache.log4j.spi.LoggerRepository;

public class HierarchyDynamicMBean extends AbstractDynamicMBean implements NotificationBroadcaster, HierarchyEventListener {
    static final String ADD_APPENDER = "addAppender.";
    static final String THRESHOLD = "threshold";
    static Class class$org$apache$log4j$jmx$HierarchyDynamicMBean;
    private static Logger log;
    private String dClassName = getClass().getName();
    private MBeanConstructorInfo[] dConstructors = new MBeanConstructorInfo[1];
    private String dDescription = "This MBean acts as a management facade for org.apache.log4j.Hierarchy.";
    private MBeanOperationInfo[] dOperations = new MBeanOperationInfo[1];
    private LoggerRepository hierarchy = LogManager.getLoggerRepository();
    private NotificationBroadcasterSupport nbs = new NotificationBroadcasterSupport();
    private Vector vAttributes = new Vector();

    static {
        Class class$;
        if (class$org$apache$log4j$jmx$HierarchyDynamicMBean == null) {
            class$ = class$("org.apache.log4j.jmx.HierarchyDynamicMBean");
            class$org$apache$log4j$jmx$HierarchyDynamicMBean = class$;
        } else {
            class$ = class$org$apache$log4j$jmx$HierarchyDynamicMBean;
        }
        log = Logger.getLogger(class$);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public HierarchyDynamicMBean() {
        buildDynamicMBeanInfo();
    }

    private void buildDynamicMBeanInfo() {
        this.dConstructors[0] = new MBeanConstructorInfo("HierarchyDynamicMBean(): Constructs a HierarchyDynamicMBean instance", getClass().getConstructors()[0]);
        this.vAttributes.add(new MBeanAttributeInfo(THRESHOLD, "java.lang.String", "The \"threshold\" state of the hiearchy.", true, true, false));
        this.dOperations[0] = new MBeanOperationInfo("addLoggerMBean", "addLoggerMBean(): add a loggerMBean", new MBeanParameterInfo[]{new MBeanParameterInfo("name", "java.lang.String", "Create a logger MBean")}, "javax.management.ObjectName", 1);
    }

    public ObjectName addLoggerMBean(String str) {
        Logger exists = LogManager.exists(str);
        if (exists != null) {
            return addLoggerMBean(exists);
        }
        return null;
    }

    ObjectName addLoggerMBean(Logger logger) {
        Throwable th;
        ObjectName objectName;
        String name = logger.getName();
        try {
            LoggerDynamicMBean loggerDynamicMBean = new LoggerDynamicMBean(logger);
            ObjectName objectName2 = new ObjectName("log4j", "logger", name);
            try {
                if (!this.server.isRegistered(objectName2)) {
                    registerMBean(loggerDynamicMBean, objectName2);
                    NotificationFilterSupport notificationFilterSupport = new NotificationFilterSupport();
                    notificationFilterSupport.enableType(new StringBuffer().append(ADD_APPENDER).append(logger.getName()).toString());
                    log.debug(new StringBuffer().append("---Adding logger [").append(name).append("] as listener.").toString());
                    this.nbs.addNotificationListener(loggerDynamicMBean, notificationFilterSupport, null);
                    this.vAttributes.add(new MBeanAttributeInfo(new StringBuffer().append("logger=").append(name).toString(), "javax.management.ObjectName", new StringBuffer().append("The ").append(name).append(" logger.").toString(), true, true, false));
                }
                return objectName2;
            } catch (JMException e) {
                th = e;
                objectName = objectName2;
                log.error(new StringBuffer().append("Could not add loggerMBean for [").append(name).append("].").toString(), th);
                return objectName;
            } catch (Throwable e2) {
                th = e2;
                objectName = objectName2;
                log.error(new StringBuffer().append("Could not add loggerMBean for [").append(name).append("].").toString(), th);
                return objectName;
            }
        } catch (JMException e3) {
            JMException jMException = e3;
            objectName = null;
            th = jMException;
            log.error(new StringBuffer().append("Could not add loggerMBean for [").append(name).append("].").toString(), th);
            return objectName;
        } catch (Throwable e22) {
            Throwable th2 = e22;
            objectName = null;
            th = th2;
            log.error(new StringBuffer().append("Could not add loggerMBean for [").append(name).append("].").toString(), th);
            return objectName;
        }
    }

    public void addNotificationListener(NotificationListener notificationListener, NotificationFilter notificationFilter, Object obj) {
        this.nbs.addNotificationListener(notificationListener, notificationFilter, obj);
    }

    protected Logger getLogger() {
        return log;
    }

    public MBeanInfo getMBeanInfo() {
        MBeanAttributeInfo[] mBeanAttributeInfoArr = new MBeanAttributeInfo[this.vAttributes.size()];
        this.vAttributes.toArray(mBeanAttributeInfoArr);
        return new MBeanInfo(this.dClassName, this.dDescription, mBeanAttributeInfoArr, this.dConstructors, this.dOperations, new MBeanNotificationInfo[0]);
    }

    public MBeanNotificationInfo[] getNotificationInfo() {
        return this.nbs.getNotificationInfo();
    }

    public Object invoke(String str, Object[] objArr, String[] strArr) throws MBeanException, ReflectionException {
        if (str == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("Operation name cannot be null"), new StringBuffer().append("Cannot invoke a null operation in ").append(this.dClassName).toString());
        } else if (str.equals("addLoggerMBean")) {
            return addLoggerMBean((String) objArr[0]);
        } else {
            throw new ReflectionException(new NoSuchMethodException(str), new StringBuffer().append("Cannot find the operation ").append(str).append(" in ").append(this.dClassName).toString());
        }
    }

    public Object getAttribute(String str) throws AttributeNotFoundException, MBeanException, ReflectionException {
        String stringBuffer;
        if (str == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("Attribute name cannot be null"), new StringBuffer().append("Cannot invoke a getter of ").append(this.dClassName).append(" with null attribute name").toString());
        }
        log.debug(new StringBuffer().append("Called getAttribute with [").append(str).append("].").toString());
        if (str.equals(THRESHOLD)) {
            return this.hierarchy.getThreshold();
        }
        if (str.startsWith("logger")) {
            int indexOf = str.indexOf("%3D");
            if (indexOf > 0) {
                stringBuffer = new StringBuffer().append(str.substring(0, indexOf)).append('=').append(str.substring(indexOf + 3)).toString();
            } else {
                stringBuffer = str;
            }
            try {
                return new ObjectName(new StringBuffer().append("log4j:").append(stringBuffer).toString());
            } catch (JMException e) {
                log.error(new StringBuffer().append("Could not create ObjectName").append(stringBuffer).toString());
            } catch (RuntimeException e2) {
                log.error(new StringBuffer().append("Could not create ObjectName").append(stringBuffer).toString());
            }
        }
        throw new AttributeNotFoundException(new StringBuffer().append("Cannot find ").append(str).append(" attribute in ").append(this.dClassName).toString());
    }

    public void addAppenderEvent(Category category, Appender appender) {
        log.debug(new StringBuffer().append("addAppenderEvent called: logger=").append(category.getName()).append(", appender=").append(appender.getName()).toString());
        Notification notification = new Notification(new StringBuffer().append(ADD_APPENDER).append(category.getName()).toString(), this, 0);
        notification.setUserData(appender);
        log.debug("sending notification.");
        this.nbs.sendNotification(notification);
    }

    public void removeAppenderEvent(Category category, Appender appender) {
        log.debug(new StringBuffer().append("removeAppenderCalled: logger=").append(category.getName()).append(", appender=").append(appender.getName()).toString());
    }

    public void postRegister(Boolean bool) {
        log.debug("postRegister is called.");
        this.hierarchy.addHierarchyEventListener(this);
        addLoggerMBean(this.hierarchy.getRootLogger());
    }

    public void removeNotificationListener(NotificationListener notificationListener) throws ListenerNotFoundException {
        this.nbs.removeNotificationListener(notificationListener);
    }

    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        if (attribute == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("Attribute cannot be null"), new StringBuffer().append("Cannot invoke a setter of ").append(this.dClassName).append(" with null attribute").toString());
        }
        String name = attribute.getName();
        Object value = attribute.getValue();
        if (name == null) {
            throw new RuntimeOperationsException(new IllegalArgumentException("Attribute name cannot be null"), new StringBuffer().append("Cannot invoke the setter of ").append(this.dClassName).append(" with null attribute name").toString());
        } else if (name.equals(THRESHOLD)) {
            this.hierarchy.setThreshold(OptionConverter.toLevel((String) value, this.hierarchy.getThreshold()));
        }
    }
}

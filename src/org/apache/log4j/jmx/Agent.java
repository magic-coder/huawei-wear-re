package org.apache.log4j.jmx;

import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import org.apache.log4j.Logger;

public class Agent {
    static Class class$org$apache$log4j$jmx$Agent;
    static Logger log;

    static {
        Class class$;
        if (class$org$apache$log4j$jmx$Agent == null) {
            class$ = class$("org.apache.log4j.jmx.Agent");
            class$org$apache$log4j$jmx$Agent = class$;
        } else {
            class$ = class$org$apache$log4j$jmx$Agent;
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

    private static Object createServer() {
        try {
            return Class.forName("com.sun.jdmk.comm.HtmlAdapterServer").newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.toString());
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2.toString());
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3.toString());
        }
    }

    private static void startServer(Object obj) {
        try {
            obj.getClass().getMethod("start", new Class[0]).invoke(obj, new Object[0]);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            } else if (targetException != null) {
                if ((targetException instanceof InterruptedException) || (targetException instanceof InterruptedIOException)) {
                    Thread.currentThread().interrupt();
                }
                throw new RuntimeException(targetException.toString());
            } else {
                throw new RuntimeException();
            }
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2.toString());
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3.toString());
        }
    }

    public void start() {
        MBeanServer createMBeanServer = MBeanServerFactory.createMBeanServer();
        Object createServer = createServer();
        try {
            log.info("Registering HtmlAdaptorServer instance.");
            createMBeanServer.registerMBean(createServer, new ObjectName("Adaptor:name=html,port=8082"));
            log.info("Registering HierarchyDynamicMBean instance.");
            createMBeanServer.registerMBean(new HierarchyDynamicMBean(), new ObjectName("log4j:hiearchy=default"));
            startServer(createServer);
        } catch (JMException e) {
            log.error("Problem while registering MBeans instances.", e);
        } catch (Throwable e2) {
            log.error("Problem while registering MBeans instances.", e2);
        }
    }
}
